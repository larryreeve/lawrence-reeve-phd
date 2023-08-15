import java.io.*;
import java.util.*;

class SentenceCounter
{
    public static void main(String[] args) 
    {
        BufferedReader 	reader = null;

        try 
        {
        	  String inputFilename  = args[0];
        	
            System.out.println("Reading " + inputFilename + "...");

            int lineCount = 0;
            String line = null;
            boolean lastLineIsBlank = false;
            reader = new BufferedReader(new FileReader(inputFilename));
            while ((line = reader.readLine()) != null)
            {
              if (line.length() == 0)
              {
                lastLineIsBlank = true;
                lineCount++;
              }
              else
              {
                lastLineIsBlank = false;
              }
            }
            reader.close();
            
            if (lastLineIsBlank)
              lineCount--;
            
            int numLinesAt10Percent = (int) Math.ceil(lineCount * .10);
            int numLinesAt15Percent = (int) Math.ceil(lineCount * .15);
            int numLinesAt20Percent = (int) Math.ceil(lineCount * .20);
            int numLinesAt25Percent = (int) Math.ceil(lineCount * .25);
        	
        	  System.out.println("\t" + lineCount + " lines");
        	  System.out.println("\t\t10% ==> " + numLinesAt10Percent + " lines");
        	  System.out.println("\t\t15% ==> " + numLinesAt15Percent + " lines");
        	  System.out.println("\t\t20% ==> " + numLinesAt20Percent + " lines");
        	  System.out.println("\t\t25% ==> " + numLinesAt25Percent + " lines");
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
        	}
        	catch(Exception e)
        	{
        	}
        }
    }
}
