import java.io.*;
import java.util.*;

class GenPctSummaries
{
    public static void main(String[] args) 
    {
        try 
        {
            String [] paperIds  = { "0002", 
                                    "0013",
                                    "0162",
                                    "0234",
                                    "0782",
                                    "0786",
                                    "0787",
                                    "0811",
                                    "0814",
                                    "0821",
                                    "0954",
                                    "1001",
                                    "1108",
                                    "1110",
                                    "1111",
                                    "1115",
                                    "1117",
                                    "1118",
                                    "1122",
                                    "1132",
                                    "1197",
                                    "3563",
                                    "4016",
                                    "4017"
                                  };
                                  
            //String [] models    = {"Jonathan", "Saya", "Tami"};
            String [] models    = { "Saya", "Tami"};
            
            int [] pctValues = { 1, 5, 10, 15 };
            //int [] pctValues = { 1 };
            
        	String dataPath = System.getenv("DATA_HOME");
        	
            // Read and process all available papers with ordered sentences
            for (String paperId : paperIds)
            {
            	BufferedReader readerInput = null;
            	String line = null;
            	
            	for (String model : models)
            	{
            		// Read sentences for model
            		//String inputFilename = dataPath + File.separator + "Summarization" + File.separator + "Input" + File.separator + paperId + File.separator + paperId + "-Model-" + model + ".spl";
                    String inputFilename = dataPath + File.separator + "Summarization" + File.separator + "Input" + File.separator + paperId + File.separator + paperId + "-OrderedSentences-" + model + ".txt";
            		System.out.println("Inputfilename: " + inputFilename);
            		List<String> modelSentences = loadModelSentences(inputFilename);
            		
            		double numSentencesPerOnePct = ((double) modelSentences.size()) / 20.0;
            		
            		//System.out.println("\tnumSentences: " + modelSentences.size() + ", numSentencesPerOnePct=" + numSentencesPerOnePct);
            		
            		for (int pctValue : pctValues)
            		{
            			String outputFilename = dataPath + File.separator + "Summarization" + File.separator + "Eval" + File.separator + "Rouge" + File.separator + "duist" + File.separator + "models" + File.separator + paperId + "-Model_" + Integer.toString(pctValue) + "pct_" + model + ".spl";
            			//System.out.println("\tOutputfilename: " + outputFilename);
            			writeModelSentences(outputFilename, modelSentences, pctValue, numSentencesPerOnePct);
            		}
            	}
            }
        } 
        catch(Exception e) 
        {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
    }

    public static List<String> loadModelSentences(String filename) throws Exception
    {
//    	BufferedReader readerInput = null;
    	
    	List<String> sentenceList = new ArrayList<String>();
    	
    	List<OrderedSentence> orderedSentenceList = OrderedSentenceFileReader.load(filename);
    	
    	for (OrderedSentence sentence : orderedSentenceList)
    		sentenceList.add(sentence.sentenceText);
    	
//        try 
//        {
//        	String line = null;
//            
//            File modelFile = new File(filename);
//            
//            if (modelFile.exists())
//            {
//            	readerInput = new BufferedReader(new FileReader(filename));
//            	while ((line = readerInput.readLine()) != null)
//            	{
//            		sentenceList.add(line.trim());
//                }
//            	readerInput.close();
//            	readerInput = null;
//            }
//        } 
//        catch(Exception e) 
//        {
//        	System.out.println("Error reading model file '" + filename + "': " + e.getMessage());
//        	e.printStackTrace();
//        }
//        finally
//        {
//        	if (readerInput != null)
//        	{
//        		try
//        		{
//        			readerInput.close();
//        		}
//        		catch(Exception e) {}
//        	}
//        }
        
        return sentenceList;
    }
    
    public static void writeModelSentences(String filename, List<String> sentences, int pct, double numSentencesPerOnePct)
    {
    	try
    	{
	    	PrintWriter writerOutput = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
	    	
	    	int numSentencesToWrite = (int) Math.ceil(((double) pct) * numSentencesPerOnePct);
	    	
	    	if (numSentencesToWrite > sentences.size())
	    		numSentencesToWrite = sentences.size();
	    	
	    	//System.out.println("pct=" + pct + ", numSentencesPerPct=" + numSentencesPerOnePct + ", numSentencesToWrite=" + numSentencesToWrite);
	    	
	    	for (int sentenceIdx = 0; sentenceIdx < numSentencesToWrite; sentenceIdx++)
	    	{
	        	writerOutput.println(sentences.get(sentenceIdx));
	    	}
	    	
	    	writerOutput.close();
    	}
    	catch(Exception e)
    	{
        	System.out.println("Error writing model file '" + filename + "': " + e.getMessage());
        	e.printStackTrace();
    	}
    }
}
