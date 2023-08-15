import java.io.*;
import java.util.*;

class OrderedSentenceFileReader
{
    public static List<OrderedSentence> load(String filename) throws Exception
    {
    	BufferedReader readerInput = null;
    	
    	List<OrderedSentence> sentenceList = new ArrayList<OrderedSentence>();
    	
        try 
        {
        	String line = null;
            
            File orderedFile = new File(filename);
            
            if (orderedFile.exists())
            {
            	readerInput = new BufferedReader(new FileReader(filename));
            	while ((line = readerInput.readLine()) != null)
            	{
            		line = line.trim();
            		String[] fields = line.split("[|]");
            		if (fields == null || fields.length != 3)
            			throw new Exception("Malformed file, line contents: " + line);
                	
            		Integer sentenceNumber = Integer.valueOf(fields[0]);
            		String sectionType = fields[1].trim();
            		String sentenceText = fields[2].trim();
            		
            		sentenceList.add(new OrderedSentence(sentenceNumber, sectionType, sentenceText));
                }
            	readerInput.close();
            	readerInput = null;
            	
            	Collections.sort(sentenceList, new Comparator<OrderedSentence> () 
                        { 
                    public int compare(OrderedSentence s1, OrderedSentence s2)  
                    { 
                        return s1.sentenceIndex - s2.sentenceIndex;
                    }
                });
                
//                System.out.println(filename);
//                for (OrderedSentence sentence : sentenceList)
//                {
//                	System.out.println(sentence.sentenceIndex + ": " + sentence.sentenceText);
//                }
//                System.out.println();
            }
        } 
        catch(Exception e) 
        {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
        finally
        {
        	if (readerInput != null)
        	{
        		try
        		{
        			readerInput.close();
        		}
        		catch(Exception e) {}
        	}
        }
        
        return sentenceList;
    }
}
