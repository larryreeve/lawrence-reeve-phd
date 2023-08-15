import java.io.*;
import java.util.*;

class Rename
{
    public static void main(String[] args) 
    {
        try 
        {
        	  String inputFilename   = args[0];
        	  String outputFilename  = args[1];
        	  
            System.out.println("Renaming ading input file list from " + inputFilename + "...");
            BufferedReader readerFileList = new BufferedReader(new FileReader(inputFilename));
            String filenameConceptCount = null;
            while ((filenameConceptCount = readerFileList.readLine()) != null)
            {
                System.out.println("Processing file: " + filenameConceptCount + "...");
                
                // Count concepts in the file
                BufferedReader readerConceptCount = new BufferedReader(new FileReader(filenameConceptCount));
                
                String line = null;
                int conceptCountThisFile = 0;
                while ((line = readerConceptCount.readLine()) != null)
                {
                    //System.out.println(line);
                    String [] conceptInfo = line.split("\\t");
                    //System.out.println("\t" + conceptCountInfo[0] + ":" + conceptCountInfo[1]);
                    
                    conceptCountThisFile++;
                    String conceptName = conceptInfo[0];
                    Integer conceptCount = Integer.valueOf(conceptInfo[1]);
                    String semanticType = conceptInfo[2];
                    
                    String conceptKey = conceptInfo[2] + "::" + conceptInfo[0];
                    
                    if (conceptCounts.containsKey(conceptKey))
                    {
                        Integer count = conceptCounts.get(conceptKey);
                        conceptCounts.put(conceptKey, new Integer(count.intValue() + 1));
                    }
                    else
                    {
                        conceptCounts.put(conceptKey, new Integer(1));
                    }
                }
                System.out.println("\t" + conceptCountThisFile + " concepts");
                readerConceptCount.close();
            }
            
            readerFileList.close();
            
            
            // Write out concept counts
            if (outputFilename.endsWith(".csv"))
            {
                PrintWriter writerConceptCounts = new PrintWriter(new BufferedWriter(new FileWriter(outputFilename)));
                for (String conceptKey : conceptCounts.keySet())
                {
                    String [] conceptKeyParts = conceptKey.split("::");
			
                    //System.out.println(conceptKeyParts[0] + "-->" + conceptKeyParts[1]);
			
                    String semanticType = conceptKeyParts[0];
                    String conceptName = conceptKeyParts[1];
                    Integer count = conceptCounts.get(conceptKey);
                
                    writerConceptCounts.println("\"" + conceptName + "\"," + count);
                }
                writerConceptCounts.close();
            }
            else
            {
                PrintWriter writerConceptCounts = new PrintWriter(new BufferedWriter(new FileWriter(outputFilename)));
                for (String conceptKey : conceptCounts.keySet())
                {
                    String [] conceptKeyParts = conceptKey.split("::");
			
                    //System.out.println(conceptKeyParts[0] + "-->" + conceptKeyParts[1]);
			
                    String semanticType = conceptKeyParts[0];
                    String conceptName = conceptKeyParts[1];
                    Integer count = conceptCounts.get(conceptKey);
                
                    writerConceptCounts.println(conceptName + "\t" + count + "\t" + semanticType);
                }
                writerConceptCounts.close();
            }
        } 
        catch(Exception e) 
        {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
    }
}
