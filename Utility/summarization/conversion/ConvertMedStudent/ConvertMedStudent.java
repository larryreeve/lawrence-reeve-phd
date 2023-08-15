import java.io.*;
import java.util.*;

class ConvertMedStudent
{
    public static void main(String[] args) 
    {
        final int LINE_LENGTH_TARGET = 100;
      
        BufferedReader 	reader = null;
        BufferedWriter 	writer = null;
        boolean blankLinesInFile = true;
      
        try 
        {
        	  String inputFilename  = args[0];
        	  String outputFilename = args[1];
        	
            System.out.println("\t" + inputFilename + "\n\t" + outputFilename + "...");

        	
        	  // Read all input lines
            List<String> inputLines = new ArrayList<String>();
            String line = null;
            reader = new BufferedReader(new FileReader(inputFilename));
            while ((line = reader.readLine()) != null)
            {
                // Strip leading ">" chars and whitespace
                if (line.startsWith(">"))
                {
                    while (line.startsWith(">") || line.startsWith(" "))
                      line = line.substring(1);
                }
                
                //if (line.length() == 0)
                //  blankLinesInFile = true;
                    
            	  inputLines.add(line);
            }
            reader.close();

            System.out.println("blankLinesInFile: " + blankLinesInFile);
            
            // Parse lines and write out
            writer = new BufferedWriter(new FileWriter(outputFilename));
            StringBuffer outputLine = new StringBuffer();
            boolean parsingLine = false;
            boolean foundSignificantLine = false;
            for (String inputLine : inputLines)
            {
            	  foundSignificantLine = inputLine.startsWith("**");
            	  if (!foundSignificantLine)
            	  {
            	      int indexPos = inputLine.indexOf("**");
            	      if (indexPos >= 0)
            	      {
            	          foundSignificantLine = true;
            	          
            	          // Strip everything before the two asterisks
            	          inputLine = inputLine.substring(indexPos);
            	          //System.out.println(inputLine);
            	      }
            	  }
            	  
            	  if (foundSignificantLine)
            	  {
            	      outputLine.setLength(0);
            	      outputLine.append(inputLine.substring(2));
            	      parsingLine = true;
            	  }
            	  else if (inputLine.length() == 0 || !blankLinesInFile) // New line
            	  {
            	      if (parsingLine)
            	      {
                        if (outputLine.length() > 0)
                        {
                            //System.out.println("---------");
                            //System.out.println(outputLine.toString());
                            writer.write(outputLine.toString());
                            writer.newLine();
                        }
            	      }
            	  
            	      outputLine.setLength(0);
            	      parsingLine = false;
            	  }
            	  else
            	  {
                    if (parsingLine)
                    {
                        outputLine.append(" ");
                        outputLine.append(inputLine);
                    }
            	  }
        	  }
        	  
            if (outputLine.length() > 0 || !blankLinesInFile)
            {
                writer.write(outputLine.toString());
                writer.newLine();
            }
        	  
        	  writer.close();
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
