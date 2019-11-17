/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL 3542
 */
public class Poling {
    
    private static Poling p;
    boolean polingFlag;
    ArrayList <Voter> v;
    ArrayList <Candidate> c;
    ArrayList<String> voteTo;
    ArrayList<String> voteFrom;
    ArrayList<String> countOfVotes;
    
    private Poling ()
    {
        polingFlag = false;
        voteTo = new ArrayList ();
        voteFrom = new ArrayList ();
        countOfVotes = new ArrayList ();
        VotersList vl = VotersList.getInstance();
        CandidateList cl = CandidateList.getInstance();
        try {
            vl.readFile();
            cl.readFile();
        } catch (IOException ex) {
           
        }
        
        v = vl.getVoters();
        c = cl.getCandidates();
    }
    
    
    
    public static Poling getInstance ()
    {
        if (p==null)
            p = new Poling ();
        
        return  p;
    }
    
    public void readFlag () throws IOException
    {
        String filename = "polingFlag.txt";
        String line;
        
        FileReader freader;
        try {
            freader = new FileReader (filename);
            BufferedReader bufferedReader = new BufferedReader(freader);
            line = bufferedReader.readLine();
            
            int check;
            check = Integer.parseInt(line);
            if (check ==1)
                polingFlag = true;
            else
                polingFlag = false;
            
        } catch (FileNotFoundException ex) {
           
        }
            
    }
    
    void writeFlag()
    {
        String filename = "polingFlag.txt";
        
        try {
            BufferedWriter fw = new BufferedWriter (new FileWriter (filename));
            
            if (polingFlag == true)
                fw.write("1");
            else
                fw.write("0");
            
            fw.close();
            
        } catch (IOException ex) {
            
        }
    }
    
    int registerVote (String voterID, String candidateID)
    {
        if (polingFlag == true)
        {
            boolean check = false;
            
            for (int i=0; i<voteFrom.size(); i++)
            {
                
                if (voterID.equals(voteFrom.get(i)))
                    return -1;
            }
            
            for (int i=0; i<v.size(); i++)
            {
               
                if (v.get(i).getId().equals(voterID))
                {
                    check = true;
                    break;
                }
            }
            
            if (check == false)
                return -1;
            
            check = false;
            
            for (int i=0; i<c.size(); i++)
            {
                
                if (c.get(i).getId().equals(candidateID))
                {
                    check = true;
                    break;
                }
            }
            
            if (check == false)
                return -1;
            
         
            voteFrom.add(voterID);
            voteTo.add(candidateID);
            
            return 1;
            
        }
        
        return 0;
    }
    
    
    
    void readVotesFrom () throws IOException 
    {
         String filename = "voteFrom.txt";
        String line;
        
        FileReader freader;
        try {
            freader = new FileReader (filename);
            BufferedReader bufferedReader = new BufferedReader(freader);
            voteFrom.clear();
            
             while((line = bufferedReader.readLine()) != null)
             {
                 voteFrom.add(line);
             }
          
            
        } catch (FileNotFoundException ex) {
           
        }
            
    }
    
      void readVotesTo () throws IOException 
    {
         String filename = "voteTo.txt";
        String line;
        
        FileReader freader;
        try {
            freader = new FileReader (filename);
            BufferedReader bufferedReader = new BufferedReader(freader);
            voteTo.clear();
            
             while((line = bufferedReader.readLine()) != null)
             {
                 voteTo.add(line);
             }
          
            
        } catch (FileNotFoundException ex) {
           
        }
            
    }
    
    void startPoling ()
    {
        polingFlag = true;
    }
    
    void endPoling ()
    {
        polingFlag = false;
    }
    
    String getResult ()
    {
        
         VotersList vl = VotersList.getInstance();
        CandidateList cl = CandidateList.getInstance();
        try {
            vl.readFile();
            cl.readFile();
        } catch (IOException ex) {
           
        }
        Poling p = Poling.getInstance();
        try {
            readVotesTo();
             readVotesFrom();
        } catch (IOException ex) {
           
        }
       
        v = vl.getVoters();
        c = cl.getCandidates();
         int count;
        for (int i=0; i<c.size(); i++)
        {
           count =0;
           System.out.println(i);
           
            for (int j=0; j<voteTo.size(); j++)
            {
                System.out.print(voteTo.get(j));
                if (c.get(i).getId().equals(voteTo.get(i)))
                    count++;
            }
            
            countOfVotes.add(i, Integer.toString(count));
        }
        
        int ind=-1;
        int b = 0;
        int a = 0;
        for (int i=0; i<countOfVotes.size(); i++)
        {
            b = Integer.parseInt(countOfVotes.get(i));
            if (b>=a)
            {
                ind = i;
                a=b;
            }
        }
        
        String totalVotes = Integer.toString(a) + " votes";
        
       if (a==0)
            return "No poling results are available";
        
        if (ind > -1)
        return (c.get(ind).getId() + "-" + c.get(ind).getName() + "has won by attaining " + totalVotes );
       String s = null;
       return s;
    }

    public boolean isPolingFlag() {
        return polingFlag;
    }

    public void setPolingFlag(boolean polingFlag) {
        this.polingFlag = polingFlag;
    }
    
    
      void writeVoteFrom()
    {
        String filename = "voteFrom.txt";
        
        try {
            BufferedWriter fw = new BufferedWriter (new FileWriter (filename));
            
            for (int i=0;i<voteFrom.size(); i++)
            {
                fw.write(voteFrom.get(i));
                fw.newLine();
            }
            fw.close();
            
        } catch (IOException ex) {
            
        }
    }
    
    void writeVoteTo()
    {
        String filename = "voteTo.txt";
        
        try {
            BufferedWriter fw = new BufferedWriter (new FileWriter (filename));
            
            for (int i=0;i<voteTo.size(); i++)
            {
                fw.write(voteTo.get(i));
                fw.newLine();
            }
            fw.close();
            
        } catch (IOException ex) {
            
        }
    }
    
    
    
}
