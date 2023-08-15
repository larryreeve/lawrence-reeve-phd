import java.io.*;
import java.util.*;

class InsertBlankLines
{
    public static void main(String[] args) 
    {
        BufferedReader 	reader = null;
        BufferedWriter 	writer = null;
      
        try 
        {
        	  String filename  = args[0];
        	
            System.out.println("\t" + filename + "...");

        	
        	  // Read all input lines
            List<String> inputLines = new ArrayList<String>();
            String line = null;
            reader = new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null)
            {
            	  inputLines.add(line);
            }
            reader.close();

            
            // Write lines with intervening blank lines
            writer = new BufferedWriter(new FileWriter(filename));
            StringBuffer outputLine = new StringBuffer();
            for (String inputLine : inputLines)
            {
                writer.write(inputLine);
                writer.newLine();
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
