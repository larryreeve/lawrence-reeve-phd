import java.io.*;
import java.util.*;

class SectionAnalysis
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
                                  
            String [] models    = {"Jonathan", "Saya", "Tami"};
            
        	String filenameOutput = "SectionAnalysis.csv";
        	
        	String dataPath = System.getenv("DATA_HOME");
        	
        	Map <String, Map<String, Integer>> sectionStatsAll = new HashMap<String, Map<String, Integer>>();
        	Map <String, Map<String, Integer>> sectionStatsTopThird = new HashMap<String, Map<String, Integer>>();
        	
        	
            // Read and process all available papers with ordered sentences
        	int fileCount = 0;
        	int filesWithSentences = 0;
        	
            for (String paperId : paperIds)
            {
            	BufferedReader readerInput = null;
            	String line = null;
            	
            	
            	for (String model : models)
            	{
            		String filename = dataPath + File.separator + "Summarization" + File.separator + "Input" + File.separator + paperId + File.separator + paperId + "-OrderedSentences-" + model + ".txt";
            		
            		//System.out.println("Reading results file " + filename + "...");
            		
            		List<OrderedSentence> sentenceList = OrderedSentenceFileReader.load(filename);
            		
            		fileCount++;
            		if (sentenceList.size() > 0)
            			filesWithSentences++;
            		
            		//System.out.println(paperId + "-" + model);
            		
            		// Find top third boundary
            		int highestSentenceIndex = 0;
            		for (OrderedSentence sentence : sentenceList)
            		{
            			if (sentence.sentenceIndex > highestSentenceIndex)
            				highestSentenceIndex = sentence.sentenceIndex;
            		}
            		
            		int topThirdBoundary = (int) Math.ceil((highestSentenceIndex * 1.0) * 0.333);
            		//System.out.println("highest: " + highestSentenceIndex + ", top third: " + topThirdBoundary);
            		
            		for (OrderedSentence sentence : sentenceList)
            		{
            			//System.out.println(sentence.sentenceIndex + ", " + sentence.sectionType + ", " + sentence.sentenceText);
            			//System.out.println("\t" + sentence.sentenceIndex + ", " + sentence.sectionType);
            			
            			
            			// Update section stats
                		if (sectionStatsAll.containsKey(model))
                		{
                			Map<String, Integer> modelStats = sectionStatsAll.get(model);
                			
                			if (modelStats.containsKey(sentence.sectionType))
                			{
                				Integer count = modelStats.get(sentence.sectionType);
                				count++;
                				modelStats.put(sentence.sectionType, count);
                			}
                			else
                			{
                				modelStats.put(sentence.sectionType, Integer.valueOf(1));	
                			}
                		}
                		else
                		{
                			Map<String, Integer> modelStats = new HashMap<String, Integer>();
                			modelStats.put(sentence.sectionType, Integer.valueOf(1));
                			sectionStatsAll.put(model, modelStats);
                		}
                		
            			// Update top third section stats
                		if (sentence.sentenceIndex >= topThirdBoundary)
                		{
	                		if (sectionStatsTopThird.containsKey(model))
	                		{
	                			Map<String, Integer> modelStats = sectionStatsTopThird.get(model);
	                			
	                			if (modelStats.containsKey(sentence.sectionType))
	                			{
	                				Integer count = modelStats.get(sentence.sectionType);
	                				count++;
	                				modelStats.put(sentence.sectionType, count);
	                			}
	                			else
	                			{
	                				modelStats.put(sentence.sectionType, Integer.valueOf(1));	
	                			}
	                		}
	                		else
	                		{
	                			Map<String, Integer> modelStats = new HashMap<String, Integer>();
	                			modelStats.put(sentence.sectionType, Integer.valueOf(1));
	                			sectionStatsTopThird.put(model, modelStats);
	                		}
                		}                		
            		}
                }
            }
            
            System.out.println("# files processed: " + fileCount);
            System.out.println("# files with sentences: " + filesWithSentences);
            System.out.println();
            
            
            for (String model : models)
            {
            	Map<String, Integer> modelStats = sectionStatsAll.get(model);
            	
            	System.out.println(model + ":");
            	
            	for (String sectionType : modelStats.keySet())
            	{
            		System.out.println("\t" + sectionType + ":" + modelStats.get(sectionType));	
            	}
            }
            
      	  	// Open output file
        	System.out.println("Generating output file " + filenameOutput + "...");
        	PrintWriter writerOutput = new PrintWriter(new BufferedWriter(new FileWriter(filenameOutput)));
        	

        	// Write output
        	writerOutput.println("Summarizer, Introduction, Methods, Results, Discussion, Appendix");
            for (String model : models)
            {
            	Map<String, Integer> modelStats = sectionStatsAll.get(model);
            	
            	if (model.equalsIgnoreCase("Jonathan"))
            		writerOutput.print("Summarizer #1,");
            	else if (model.equalsIgnoreCase("Saya"))
            		writerOutput.print("Summarizer #2,");
            	else if (model.equalsIgnoreCase("Tami"))
            		writerOutput.print("Summarizer #3,");
            	
            	writerOutput.print(getMapValue(modelStats, "I") + ",");
            	writerOutput.print(getMapValue(modelStats, "M") + ",");
            	writerOutput.print(getMapValue(modelStats, "R") + ",");
            	writerOutput.print(getMapValue(modelStats, "D") + ",");
            	writerOutput.println(getMapValue(modelStats, "A"));
            }
            
            writerOutput.println();
            
        	writerOutput.println("Summarizer, Introduction, Methods, Results, Discussion, Appendix");
            for (String model : models)
            {
            	Map<String, Integer> modelStats = sectionStatsTopThird.get(model);
            	
            	if (model.equalsIgnoreCase("Jonathan"))
            		writerOutput.print("Summarizer #1,");
            	else if (model.equalsIgnoreCase("Saya"))
            		writerOutput.print("Summarizer #2,");
            	else if (model.equalsIgnoreCase("Tami"))
            		writerOutput.print("Summarizer #3,");
            	
            	writerOutput.print(getMapValue(modelStats, "I") + ",");
            	writerOutput.print(getMapValue(modelStats, "M") + ",");
            	writerOutput.print(getMapValue(modelStats, "R") + ",");
            	writerOutput.print(getMapValue(modelStats, "D") + ",");
            	writerOutput.println(getMapValue(modelStats, "A"));
            }
            
            
            // Close output  file
        	writerOutput.close();
        } 
        catch(Exception e) 
        {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
    }
    
    private static Integer getMapValue(Map<String, Integer> mapToExtractFrom, String key)
    {
    	if (mapToExtractFrom.containsKey(key))
    		return mapToExtractFrom.get(key);
    	
    	return Integer.valueOf(0);
    }
}
