import java.io.*;
import java.util.*;

class GenTRECFormat
{
    public static void main(String[] args) 
    {
        BufferedReader 	reader = null;
        BufferedWriter 	writer = null;
        boolean blankLinesInFile = true;
      
        try 
        {
            if (args.length < 3) 
            {
                System.out.println("params are: docid inputfilename outputfilename");
                return;
            }
            
            String docId          = args[0];
        	  String inputFilename  = args[1];
        	  String outputFilename = args[2];
        	
            System.out.println("\tDocId:"  + docId + ": " + inputFilename + "\n\t" + outputFilename + "...");

        	
        	  // Read all input lines
            List<String> inputLines = new ArrayList<String>();
            String line = null;
            reader = new BufferedReader(new FileReader(inputFilename));
            while ((line = reader.readLine()) != null)
            {
            	  inputLines.add(line);
            }
            reader.close();
            reader = null;

            
            // Write out in TREC format
            writer = new BufferedWriter(new FileWriter(outputFilename, true));
            
            writer.write("<DOC>");
            writer.newLine();
            
            writer.write("<DOCNO>" + docId + "</DOCNO>");
            writer.newLine();
            
            writer.write("<TEXT>");
            writer.newLine();

            for (String inputLine : inputLines)
            {
                writer.write(inputLine.toString());
                writer.newLine();
            }
            
            writer.write("</TEXT>");
            writer.newLine();
            
            writer.write("</DOC>");
            writer.newLine();
        	  
        	  writer.close();
        	  writer = null;
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
