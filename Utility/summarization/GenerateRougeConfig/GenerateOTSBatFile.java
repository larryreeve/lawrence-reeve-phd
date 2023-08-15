import java.io.*;
import java.util.*;

class GenerateOTSBatFile
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
                                  
            
        	  String filename = "EvalGenOTSSummaries.bat";
        	  
        	  
        	  
        	  // Open output config file
        	  System.out.println("Generating bat file " + filename + "...");
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
            
            writer.println("@echo off");
            writer.println("if \"%1%\" == \"\" goto ERROR");
            writer.println();
            
            
            // Write an entry for each paper
            for (String paperId : paperIds)
            {
                writer.println("cd ..\\Summarizers\\ots\\ots-0.4.2\\bin");
                writer.println("type ..\\..\\..\\..\\BioChain\\data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt  | OtsWin32 --ratio %1 -o ..\\..\\..\\..\\BioChain\\data\\output\\" + paperId + "\\" + paperId + "-ArticleSummary_%1pct_OTS.txt");
                writer.println("cd   ..\\..\\..\\..\\BioChain");
                writer.println("call util\\converttospl.bat data\\output\\" + paperId + "\\" + paperId + "-ArticleSummary_%1pct_OTS.txt data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_OTS.spl");
                writer.println();
            }
            
            // Close output config file
          writer.println();
          writer.println();
          writer.println("goto END");
          writer.println();
          writer.println(":ERROR");
          writer.println("echo.");
          writer.println("echo.");
          writer.println("echo Parameter error. The compression rate must be specified.");
          writer.println("echo Example: GenOTSSummaries 15 to use 15 percent compression");
          writer.println("echo.");
          writer.println("echo.");
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
