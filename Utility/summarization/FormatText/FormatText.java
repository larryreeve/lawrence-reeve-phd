import java.io.*;
import java.util.*;

class FormatText
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

        	
        	//  Read all input lines
            List<String> inputLines = new ArrayList<String>();
            String line = null;
            reader = new BufferedReader(new FileReader(inputFilename));
            while ((line = reader.readLine()) != null)
            {
            	inputLines.add(line);
            }
            reader.close();

            
            // Reformat lines and write out
            writer = new BufferedWriter(new FileWriter(outputFilename));
            StringBuffer outputLine = new StringBuffer();
            for (String inputLine : inputLines)
            {
            	//System.out.println(inputLine);
            	
            	// New line
            	if (inputLine.length() == 0)
            	{
            		if (outputLine.length() > 0)
            			writer.write(outputLine.toString());
        			writer.newLine();
        			writer.newLine();
        			outputLine.setLength(0);
            	}
            	// Line fits within current line
            	else if (inputLine.length() + outputLine.length() < LINE_LENGTH_TARGET)
            	{
//            		if (outputLine.length() > 0)
//            		{
//            			if (outputLine.charAt(outputLine.length()-1) != ' ')
//            				outputLine.append(" ");
//            		}
            		
            		outputLine.append(inputLine);
            	}
            	// Part of line fits in current line
            	else
            	{
        			// Get largest string that will fit
        			int addLength = LINE_LENGTH_TARGET - outputLine.length();
        			if (addLength > inputLine.length())
        				addLength = inputLine.length();
        			
        			outputLine.append(inputLine.substring(0, addLength));
        			
        			// if line is broken in middle, get next word
        			int curPos = addLength;
        			
        			while (curPos < inputLine.length() && !Character.isWhitespace(inputLine.charAt(curPos)))
					{
        				outputLine.append(inputLine.charAt(curPos));
        				curPos++;
					}
        			
        			// Write line 
        			writer.write(outputLine.toString());
        			writer.newLine();
        			outputLine.setLength(0);
        			
        			// Initialize next line to remaining chars
        			//System.out.println(curPos + ":" + inputLine.length());
//        			 Skip white space
        			curPos++;	
        			while (curPos < inputLine.length() && Character.isWhitespace(inputLine.charAt(curPos)))
        				curPos++;
        			if (curPos < inputLine.length())
        				outputLine.append(inputLine.substring(curPos, inputLine.length()));
            	}
            	
            	
            	if (outputLine.length() >= LINE_LENGTH_TARGET)
            	{
        			writer.write(outputLine.toString());
        			writer.newLine();
        			outputLine.setLength(0);
            	}
            }
            
        	if (outputLine.length() > 0)
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
