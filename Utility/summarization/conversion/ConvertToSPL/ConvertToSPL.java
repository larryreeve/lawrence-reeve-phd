import java.io.*;
import java.util.*;

class ConvertToSPL
{
    public static void main(String[] args) 
    {
        BufferedReader 	reader = null;
        BufferedWriter 	writer = null;
      
        try 
        {
        	String inputFilename  = args[0];
        	String outputFilename = args[0];
        	if (args.length > 1)
        		outputFilename = args[1];
        	
            System.out.println("\nConverting \t" + inputFilename + 
                               "\nto         \t" + outputFilename + "...");

        	  // Read all input lines into a single text buffer
        	  StringBuffer sbText = new StringBuffer();
            String line = null;
            reader = new BufferedReader(new FileReader(inputFilename));
            while ((line = reader.readLine()) != null)
            {
              sbText.append(line);
            }
            reader.close();

            // Split text into sentences            
            List<String> SPLLines = SentenceSplitter.splitTextIntoSentences(sbText.toString());
            
            // Process all lines for SPL requirements
            List<String> SPLLinesProcessed = new ArrayList<String>();
            for (String SPLLine : SPLLines)
            {
              String        processedLine   = SPLLine;
              StringBuffer  sbProcessedLine = new StringBuffer();
              
              // Add space to commas separators
              for (int idx=0; idx < SPLLine.length(); idx++)
              {
                if (SPLLine.charAt(idx) == ',')
                {
                  // Check digit before and after comma
                  boolean isPartOfNumber = (idx > 0 && Character.isDigit(SPLLine.charAt(idx-1)) && 
                                           (idx+1) < SPLLine.length() && Character.isDigit(SPLLine.charAt(idx+1)));
                                           
                  if (isPartOfNumber)
                  {
                    sbProcessedLine.append(SPLLine.charAt(idx));
                  }
                  else
                  {
                    sbProcessedLine.append(" , ");
                  }
                }
                else
                {
                  sbProcessedLine.append(SPLLine.charAt(idx));
                } 
              }
              
              sbProcessedLine.append(" .");
              SPLLinesProcessed.add(sbProcessedLine.toString());
            }

            
            // Reformat processed lines and write out
            writer = new BufferedWriter(new FileWriter(outputFilename));
            StringBuffer outputLine = new StringBuffer();
            for (String SPLLine : SPLLinesProcessed)
            {
              if (SPLLine.length() > 0)
              {
                writer.write(SPLLine);
                writer.newLine();
              }
            }
        	
        	  writer.close();
        	  
        	  System.out.println(SPLLinesProcessed.size() + " lines.");
        } 
        catch(Exception e) 
        {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
        finally
        {
        	try
        	{
        		if (reader != null)
        			reader.close();
            
        		if (writer != null)
        			writer.close();
        	}
        	catch(Exception e)
        	{
        	}
        }
    }
}
