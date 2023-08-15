import java.io.*;
import java.util.*;

class CompareSingleConceptAnnotationFiles {
	public static void main(String[] args) 
    {
        BufferedReader readerBaseLine = null;
        BufferedReader readerTestSystem = null;
        PrintStream    writerNoMatch = null;
        
        List<String> conceptIdsBaseLine = new ArrayList<String>();
        List<String> conceptIdsTestSystem = new ArrayList<String>();
        
        int metricNumPhrases = 0;
        int metricNumPhrasesWithMatchingConcepts = 0;
        int metricNumTestSystemMoreThanOneConcept = 0;
        int metricNumTestSystemZeroConcepts = 0;
        
        try 
        {
            String line = null;
            
     	   	String filenameBaseLine   = args[0];
     	   	String filenameTestSystem = args[1];
     	    String filenameNoMatch    = args[2];

     	   	readerBaseLine = new BufferedReader(new FileReader(filenameBaseLine));
     	   	readerTestSystem = new BufferedReader(new FileReader(filenameTestSystem));
     	    writerNoMatch = new PrintStream(new FileOutputStream(filenameNoMatch));
     	    
            while ((line = readerBaseLine.readLine()) != null)
            {
            	// Initialize
            	conceptIdsBaseLine.clear();
            	conceptIdsTestSystem.clear();
            	
            	// Get baseline concepts
                String baselinePhrase = line.trim().toLowerCase();
                
                int numMappings = Integer.parseInt(readerBaseLine.readLine().trim());
                for (int idx=0; idx < numMappings; idx++)
                {
                	line = readerBaseLine.readLine();
                	
                	String fields[] = line.split("\\|");
                	if (fields.length < 1)
                		throw new Exception("Invalid file format");
                	
                	conceptIdsBaseLine.add(fields[0].trim());
                }
                
                // Get test system concepts
                line = readerTestSystem.readLine();
                
                String testSystemPhrase = line.trim().toLowerCase();
                
                //System.out.println("TestSystem Phrase: " + testSystemPhrase);
                
                numMappings = Integer.parseInt(readerTestSystem.readLine().trim());
                for (int idx=0; idx < numMappings; idx++)
                {
                	line = readerTestSystem.readLine();
                	
                	String fields[] = line.split("\\|");
                	if (fields.length < 1)
                		throw new Exception("Invalid file format");
                	
                	conceptIdsTestSystem.add(fields[0].trim());
                }
                
                // Evaluate
                if (!testSystemPhrase.equalsIgnoreCase(baselinePhrase))
                	throw new Exception("TestSystem phrase and BaseLine phrase do not match");

                metricNumPhrases++;
                
                if (conceptIdsTestSystem.size() > 1)
                	metricNumTestSystemMoreThanOneConcept++;
                
                if (conceptIdsTestSystem.size() == 0)
                	metricNumTestSystemZeroConcepts++;
                
                //System.out.println("Phrase: " + baselinePhrase);

                boolean foundAtLeastOneMatch = false;
                for (String conceptIdBaseLine : conceptIdsBaseLine)
                {
                	for (String conceptIdTestSystem : conceptIdsTestSystem)
                	{
                		if (conceptIdTestSystem.equalsIgnoreCase(conceptIdBaseLine))
                        {
                			//System.out.println("\tConcept match, BaseLine=" + conceptIdBaseLine + ", TestSystem=" + conceptIdTestSystem);  
                			foundAtLeastOneMatch = true;
                        }
                	}
                }
                
                if (foundAtLeastOneMatch)
                {
                	metricNumPhrasesWithMatchingConcepts++;
                }
                else
                {
                	writerNoMatch.println(testSystemPhrase);
                	writerNoMatch.println("  0");
                	//System.out.println("No match: " + testSystemPhrase);
                }
            }
            readerBaseLine.close();
            readerTestSystem.close();
            writerNoMatch.close();

            double precision = (double) metricNumPhrasesWithMatchingConcepts / (double) metricNumPhrases;
            
            System.out.println("NumPhrases: " + metricNumPhrases);
            System.out.println("NumPhrasesWithMatchingConcepts: " + metricNumPhrasesWithMatchingConcepts);
            System.out.println("Precision: " + String.format("%.4f", precision));
            System.out.println("NumTestSystemMoreThanOneConcept: " + metricNumTestSystemMoreThanOneConcept);
            System.out.println("NumTestSystemZeroConcepts: " + metricNumTestSystemZeroConcepts);
        } 
        catch(Exception e) 
        {
        	System.out.println("Error: " + e.getMessage());
        }
    }
}
