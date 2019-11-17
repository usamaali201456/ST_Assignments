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
/**
 *
 * @author DELL 3542
 */
public class CandidateList {
    
    
    private static CandidateList v;
    ArrayList <Candidate> candidates;

    

    private CandidateList() {
        
        candidates = new ArrayList ();
        try {
            readFile();
        } catch (IOException ex) {
           
        }
    }
    
    public static CandidateList getInstance ()
    {
        if (v==null)
            v = new CandidateList ();
        
        return  v;
    }
    
    public void readFile() throws IOException
    {
        String filename = "candidates.txt";
        candidates.clear();
        String line;
        try {
            FileReader freader = new FileReader (filename);
            BufferedReader bufferedReader = new BufferedReader(freader);
            String name,address,type,  dob;
            type = null;
           String id;
            while((line = bufferedReader.readLine()) != null) {
                String[] arrOfStr = line.split("/");
                
                id = arrOfStr[0];
                name = arrOfStr[1];
                address =  arrOfStr[2];
                dob =  arrOfStr[3];
                
             
                Candidate c = new Candidate (type,id,name,address,dob);
                candidates.add(c);
                
            }
            
            
            
        } catch (FileNotFoundException ex) {
           
        }
        
    }
    
    public void writeFile ()
    {
        String filename = "candidates.txt";
        
        try {
            BufferedWriter fw = new BufferedWriter (new FileWriter (filename));
            String line;
            
            for (int i=0; i<candidates.size(); i++)
            {
                line = candidates.get(i).getId() + "/" + candidates.get(i).getName() + "/"+ candidates.get(i).getAddress()+ "/" +candidates.get(i).getDob();
                fw.write(line);
                fw.newLine();
                System.out.println(line);
            }
            
            fw.close();
            
            
        } catch (IOException ex) {
           
        }
        
    }
    
    
    boolean addCandidate (String id, String name, String address, String dob, String type)
    {
        Candidate vo = new Candidate (type,id,name,address,dob);
        boolean check = true;
        for (int i=0; i<candidates.size(); i++)
        {
            if (vo.getId().equals(candidates.get(i).getId()))
            {
                
                return false;
            }
        }
        
        
            candidates.add(vo);
            return true;
    }
    
    boolean removeCandidate (String id)
    {
        for (int i=0; i<candidates.size(); i++)
        {
            if (candidates.get(i).getId().equals(id))
            {
                candidates.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Candidate> getCandidates() {
        return candidates;
    }
    
    Candidate getCandidate (String id)
    {
        for (int i=0;i<candidates.size();i++)
        {
            if (candidates.get(i).getId().equals(id))
                return candidates.get(i);
        }
        return null;
    }
    
    
}
