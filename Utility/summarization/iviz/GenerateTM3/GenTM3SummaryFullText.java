import java.io.*;
import java.util.*;

class GenTM3SummaryFullText
{
    public static void main(String[] args) 
    {
        try 
        {
            BufferedReader readerConcepts = null;
            String line = null;
            Map<String, Integer> conceptCounts = new HashMap<String, Integer>();
            
        	  String filenameSummary  = args[0];
        	  String filenameFullText = args[1];
        	  String filenameTM3      = args[2];
        	  
        	  // Open output file
        	  System.out.println("Generating output file " + filenameTM3 + "...");
            PrintWriter writerTM3 = new PrintWriter(new BufferedWriter(new FileWriter(filenameTM3)));
            writerTM3.println("Source Text\tConcept Name\tSemantic Type\tConcept Frequency");
            writerTM3.println("STRING\tSTRING\tSTRING\tINTEGER");

            // Process summary file
            System.out.println("\tReading summary file " + filenameSummary + "...");
            readerConcepts = new BufferedReader(new FileReader(filenameSummary));
            while ((line = readerConcepts.readLine()) != null)
            {
                //System.out.println(line);
                String [] conceptInfo = line.split("\\t");
                
                if (conceptInfo.length == 3)
                {
                    //System.out.println("\t" + conceptCountInfo[0] + ":" + conceptCountInfo[1] + ":" + conceptCountInfo[2]);
                    
                    String conceptName = conceptInfo[0];
                    Integer conceptCount = Integer.valueOf(conceptInfo[1]);
                    String  conceptSemanticType = conceptInfo[2];
                    
                    writerTM3.println("Summary\t" + conceptName + "\t" + conceptSemanticType + "\t" + conceptCount + "\t\tSummary\t" + conceptSemanticType + "\t" + conceptName);
                }
            }
            readerConcepts.close();
            
        	  
        	  // Process full-text file
            System.out.println("\tReading full-text file " + filenameFullText + "...");
            readerConcepts = new BufferedReader(new FileReader(filenameFullText));
            line = null;
            while ((line = readerConcepts.readLine()) != null)
            {
                //System.out.println(line);
                String [] conceptInfo = line.split("\\t");
              
                if (conceptInfo.length == 3)
                {
                    //System.out.println("\t" + conceptCountInfo[0] + ":" + conceptCountInfo[1] + ":" + conceptCountInfo[2]);
                    
                    String conceptName = conceptInfo[0];
                    Integer conceptCount = Integer.valueOf(conceptInfo[1]);
                    String  conceptSemanticType = conceptInfo[2];

                  writerTM3.println("Full-text\t" + conceptName + "\t" + conceptSemanticType + "\t" + conceptCount + "\t\tFull-text\t" + conceptSemanticType + "\t" + conceptName);
                }
            }
            
            readerConcepts.close();
            
            writerTM3.close();
        } 
        catch(Exception e) 
        {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
    }
}
