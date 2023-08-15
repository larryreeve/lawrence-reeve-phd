import java.io.*;
import java.util.*;

class GenerateGenUniquePhrasesBatFile
{
    public static void main(String[] args) 
    {
        try 
        {
            String [] paperIds  = { "0002", 
                                    "0013",
                                    "0162",
                                    "0234",
                                    "0782",
                                    "0786",
                                    "0787",
                                    "0811",
                                    "0814",
                                    "0821",
                                    "0954",
                                    "1001",
                                    "1108",
                                    "1110",
                                    "1111",
                                    "1115",
                                    "1117",
                                    "1118",
                                    "1122",
                                    "1132",
                                    "1197",
                                    "3563",
                                    "4016",
                                    "4017"
                                  };
                                  
            
        	  String filename = "GenUniquePhrases.bat";
        	  
        	  
        	  
        	  // Open output config file
        	  System.out.println("Generating bat file " + filename + "...");
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
            
            writer.println("@echo off");
            writer.println("");
            
            
            // Write an entry for each paper
            for (String paperId : paperIds)
            {
                writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype uphrases -outputoptions phrasesfilename=data\\output\\UniquePhrases.txt");
                writer.println("");
            }
            
            // Close output config file
          writer.println("");
          writer.println();
          writer.println(":END");
          writer.close();
        } 
        catch(Exception e) 
        {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
    }
}
