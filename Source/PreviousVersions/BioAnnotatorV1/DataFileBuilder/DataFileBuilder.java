import java.io.*;
import java.util.*;

public class DataFileBuilder 
{
  
  public static void main(String[] args)
    throws Exception
	{
	    String inputFilename  = "..\\data\\cui_concept.txt";
	    String outputFilename = "ConceptIdToConceptName.txt";
		
		  // Build concept id to concept name map
		  // Input line looks like: 
		  //		C0026764|Multiple Myeloma
		  Map<String, String> conceptIdToConceptName = new HashMap<String,String>();
    	BufferedReader textFileReader = null;
    	BufferedWriter textFileWriter = null;
    	try
    	{
    		  textFileReader = new BufferedReader(new FileReader(inputFilename));
    		  textFileWriter = new BufferedWriter(new FileWriter(outputFilename));
		
    		  String line = null;
    		  while ((line = textFileReader.readLine()) != null)
    		  {
    		      String[] fields = line.split("[|]");
			
    			    if (fields.length != 2)
    				    throw new Exception("Invalid cui_concept.txt format: " + line);
    			
    			    String conceptId   = fields[0];
    			    String conceptName = fields[1];
			
    			    //System.out.println(line);
    			    //System.out.println("\tFieldLen:" + fields.length);
    			    //System.out.println("\tF1:'" + fields[0] + "'");
    			    //System.out.println("\tF2:'" + fields[1] + "'");
    			
    			    if (conceptIdToConceptName.containsKey(conceptId))
    				    throw new Exception("cui_concept key already exists: '" + conceptId + "', '" + conceptName + "', " + line);
    			
    			    conceptIdToConceptName.put(conceptId, conceptName);
    		  }
    		  textFileReader.close();

    		  for (String conceptId : conceptIdToConceptName.keySet())
    		  {
    		      textFileWriter.write(conceptId);
    		      textFileWriter.newLine();
              textFileWriter.write(conceptIdToConceptName.get(conceptId));
              textFileWriter.newLine();
          }
          textFileWriter.close();
    	}
    	finally 
    	{
    	    try 
    		  {
    			    if (textFileReader != null) 
    				    textFileReader.close();
              if (textFileWriter != null) 
                textFileWriter.close();
    		  }
    		  catch(Exception e) {} 
    	}
		
		
		// Build Phrase-to-Concept map
		// Input line looks like: 
		//		S0000005|C0025362
//    	try
//    	{
//    		File inputFile = new File("data\\sui_cui.txt");
//
//    		textFileReader = new BufferedReader(new FileReader(inputFile));
//		
//    		String line = null;
//    		while (( line = textFileReader.readLine()) != null)
//    		{
//    			String[] fields = line.split("[|]");
//			
//    			if (fields.length != 2)
//    				throw new Exception("Invalid sui_cui format: " + line);
//    			
//    			String phraseId  = fields[0];
//    			String conceptId = fields[1];
//			
//    			//System.out.println(line);
//    			//System.out.println("\tFieldLen:" + fields.length);
//    			//System.out.println("\tF1:'" + fields[0] + "'");
//    			//System.out.println("\tF2:'" + fields[1] + "'");
//    			
//				if (!phraseIdToConceptIdList.containsKey(phraseId))
//				{
//					Map<String, String> conceptIdList = new HashMap<String, String>();
//					if (!conceptIdList.containsKey(conceptId))
//					{
//						conceptIdList.put(conceptId, conceptId);
//						termIdToPhraseIdList.put(phraseId, conceptIdList);
//					}
//				}
//				else
//				{
//					Map<String, String> conceptIdList = phraseIdToConceptIdList.get(phraseId);
//					if (!conceptIdList.containsKey(conceptId))
//						conceptIdList.put(conceptId, conceptId);
//				}
//    		}
//    		System.out.println("2");
//    	}
//    	finally 
//    	{
//    		try 
//    		{
//    			if (textFileReader!= null) 
//    			{
//    				//	flush and close both "input" and its underlying FileReader
//    				textFileReader.close();
//    			}
//    		}
//    		catch(Exception e) {} 
//    	}
    	

		// Build terms map and phrase terms map
    	//	S0005246|myeloma|Myeloma
//    	try
//    	{
//    		StringBuffer s = new StringBuffer();
//    		int termId = 0;
//    		File inputFile = new File("data\\sui_nmstr_str.txt");
//
//    		textFileReader = new BufferedReader(new FileReader(inputFile));
//		
//    		String line = null;
//		
//    		while (( line = textFileReader.readLine()) != null)
//    		{
//    			String[] fields = line.split("[|]");
//			
//    			if (fields.length != 3)
//    				throw new Exception("Invalid sui_nmstr_str format: " + line);
//			
//    			//System.out.println(line);
//    			//System.out.println("\tC:" + fields.length);
//    			//System.out.println("\tF1:'" + fields[0] + "'");
//    			//System.out.println("\tF2:'" + fields[1] + "'");
//    			//System.out.println("\tF3:'" + fields[2] + "'");
//    			
//    			int phraseId = Integer.parseInt(fields[0].substring(1, fields[0].length()));
//    			String[] phraseTerms = fields[1].split(" ");
//    			
//    			// Add new terms to maps
//    			for (String phraseTerm : phraseTerms)
//    			{
//    				if (!wordHT.containsKey(phraseTerm))
//    				{
//    					termId++;
//    					wordHT.put(phraseTerm, termId);
//    				}
//    				
//    				int thisTermId = wordHT.get(phraseTerm);
//    				
//    				if (!wid2pids.containsKey(thisTermId))
//    				{
//    					Map<Integer, Integer> pidList = new HashMap<Integer, Integer>();
//						pidList.put(phraseId, phraseId);
//						wid2pids.put(thisTermId, pidList);
//    				}
//    				else
//    				{
//    					Map<Integer, Integer> pidList = wid2pids.get(thisTermId);
//    					if (!pidList.containsKey(phraseId))
//    						pidList.put(phraseId, phraseId);
//    				}
//    			}
//    		}
//    		
//    		int totalChars = 0;
//    		for (String term : wordHT.keySet())
//    			totalChars += term.length();
//    		
//    		System.out.println("# of unique terms: " + wordHT.size());
//    		System.out.println("Total chars: " + totalChars);
//    		System.out.println("Avg chars per term: " + (totalChars / wordHT.size()));
//    		System.gc();
//    	}
//    	finally 
//    	{
//    		try 
//    		{
//    			if (textFileReader!= null) 
//    			{
//    				//	flush and close both "input" and its underlying FileReader
//    				textFileReader.close();
//    			}
//    		}
//    		catch(Exception e) {} 
//    	}
//
	}
}