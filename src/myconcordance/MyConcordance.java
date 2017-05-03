/*
 * Concordance Project by Carlos Alonzo Student ID: 00011329
 * Objective: Using collection classes and hybrid data structures
 * Using Collection classes build a concordance. 
 * A concordance lists every word used in a document and where each instance is. 
 * For example a biblical concordance would show you every use (page and line) of the word “beget”. 
 * Use a hash for the words and a linked list for every instance.
 */
package myconcordance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author Carlos Alonzo
 */
public class MyConcordance 
{
    
    public static String Filepath ="C:\\Users\\Carlos\\Dropbox\\CIS 252\\Projects\\MyConcordance\\src\\javahistory.txt";
    public static String Delimiter =" ";
    
    Hashtable <String, LinkedList <Integer>> Concordance;

    public MyConcordance() 
    {        
        this.Concordance = new Hashtable();        
        try{this.readFile(Filepath, Delimiter);}
        catch(IOException e){System.out.println("Error occurred: "+ e.getMessage());}
    }
    
    public LinkedList<Integer> getKey(String searchStr)
    {
        return Concordance.get(searchStr);    
    }
    
    public Set<String> printKeys()
    {
        return Concordance.keySet();
    
    }
    
    public void readFile(String Filepath, String Delimiter ) throws IOException, NullPointerException
    {
        String OneLine;
        String [] WordArray;
        int currline=0;
        
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(Filepath));  
            
            while(null != (OneLine = in.readLine()))
            {
                currline++;
                WordArray = OneLine.split(Delimiter);
                
                for(String E : WordArray)
                {
                    System.out.println("On line: "+ currline +" This word is:" + E);
                    
                    //if word not in hash put word in hash with a linked list with the initial line number
                    if(!Concordance.containsKey(E))
                    {
                        LinkedList <Integer> Linelist = new LinkedList(); 
                        Linelist.add(currline);
                        Concordance.put(E, Linelist);                    
                    }
                    
                    //Get the value, use the linked list to insert a new node with the current line number
                    else
                    {
                        Concordance.get(E).add(currline);
                    
                    }
                }
                            
            }
            
       }
    
        catch (IOException | NullPointerException e)
        {
            System.out.println("Error occurred: "+ e.getMessage());
        }
     }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {   
        MyConcordance JavaConcordance = new MyConcordance();
        
        HashSet<String> keys = new HashSet(JavaConcordance.printKeys());
        
        for(String E : keys)
        {
            System.out.println("The concordance for word: \"" + E +
                    "\" has " + JavaConcordance.getKey(E).size() +
                    " number of entries. Ocurring on the following lines: " +
                    JavaConcordance.getKey(E).toString());              
        
        }
    }
    
}
