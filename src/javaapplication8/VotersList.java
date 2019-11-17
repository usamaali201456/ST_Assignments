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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL 3542
 */
public class VotersList {
    
    private static VotersList v;
    ArrayList <Voter> voters;

    

    private VotersList() {
        
        voters = new ArrayList ();
        try 
        {
            readFile();
        } catch (IOException ex) {
           
        }
    }
    
    public static VotersList getInstance ()
    {
        if (v==null)
            v = new VotersList ();
        
        return  v;
    }
    
    public void readFile() throws IOException
    {
        String filename = "voters.txt";
        voters.clear();
        String line;
        try {
            FileReader freader = new FileReader (filename);
            BufferedReader bufferedReader = new BufferedReader(freader);
            String name,address,pswrd,  dob;
           String id;
            while((line = bufferedReader.readLine()) != null) {
                String[] arrOfStr = line.split("/");
                
                id = arrOfStr[0];
                name = arrOfStr[1];
                address =  arrOfStr[2];
                dob =  arrOfStr[3];
                pswrd = arrOfStr[4];
                
                System.out.println(id);
                System.out.println(pswrd);
               
                
             
                Voter voter = new Voter (pswrd,id,name,address,dob);
                voters.add(voter);
                
            }
            
            
            
        } catch (FileNotFoundException ex) {
           
        }
        
    }
    
    public void writeFile ()
    {
        String filename = "voters.txt";
        
        try {
            BufferedWriter fw = new BufferedWriter (new FileWriter(filename));
            String line;
            
            for (int i=0; i<voters.size(); i++)
            {
                line = voters.get(i).getId() + "/" + voters.get(i).getName() + "/"+ voters.get(i).getAddress()+ "/" +voters.get(i).getDob()+"/"+voters.get(i).getPassword();
                fw.write(line);
                fw.newLine();
            }
            
            
            fw.close();
            
        } catch (IOException ex) {
           
        }
        
    }
    
    
    Voter getVoter (String id)
    {
        for (int i=0; i<voters.size(); i++)
        {
            if (voters.get(i).getId().equals(id))
                return voters.get(i);
        }
        return null;
    }
    
    
    void updateVoter (Voter vtr)
    {
        for (int i=0;i<voters.size();i++)
        {
            if (vtr.getId().equals(voters.get(i).getId()))
            {
                voters.add(i, vtr);
                break;
            }
        }
    }
    
    boolean addVoter (String id, String name, String address, String dob, String pswrd)
    {
        Voter v = new Voter (pswrd,id,name,address,dob);
        
        for (int i=0; i<voters.size(); i++)
        {
            if (v.getId().equals(voters.get(i).getId()))
            {
                return false;
            }
        }
        
        
            voters.add(v);
        return true;
    }
    
    boolean removeVoter (String id)
    {
        for (int i=0; i<voters.size(); i++)
        {
            if (voters.get(i).getId().equals(id))
            {
                voters.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Voter> getVoters() {
        return voters;
    }
    
    boolean loginVoter (String n, String ps)
    {
        for ( int i=0; i<voters.size(); i++)
        {
            
            if ((voters.get(i).getId().equals(n)) &&( voters.get(i).getPassword().equals(ps)))
            {
               // System.out.print(voters.get(i).getId() + voters.get(i).getPassword());
                return true;
            }
        }
        return false;
    }
    
}
