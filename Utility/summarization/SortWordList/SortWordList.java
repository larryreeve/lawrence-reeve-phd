import java.io.*;
import java.util.*;

class SortWordList
{
    public static void main(String[] args) 
    {
        final int LINE_LENGTH_TARGET = 100;
      
        BufferedReader 	reader = null;
        BufferedWriter 	writer = null;
      
        try 
        {
        	String inputFilename  = args[0];
        	String outputFilename = args[0];
        	if (args.length > 1)
        		outputFilename = args[1];
        	
            System.out.println("\t" + inputFilename + "\n\t" + outputFilename + "...");

        	
        	  //  Read all terms
            Map<String, String> termMap = new HashMap<String, String>();
            String term = null;
            reader = new BufferedReader(new FileReader(inputFilename));
            while ((term = reader.readLine()) != null)
            {
              String termNormalized = term.trim();
              
              if (termNormalized.length() > 0) 
              {
                if (!termMap.containsKey(termNormalized))
            	    termMap.put(termNormalized, null);
            	}
            }
            reader.close();
            
            
            // Sort words
            List<String> sortedTermList = new ArrayList<String>(termMap.keySet());
            Collections.sort(sortedTermList); 

            
            // Reformat lines and write out
            writer = new BufferedWriter(new FileWriter(outputFilename));
            for (String sortedTerm : sortedTermList)
            {
            			writer.write(sortedTerm);
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
