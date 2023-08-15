/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator.conceptload;

import java.io.*;
import java.util.*;
import org.apache.commons.collections.map.*;

public class DataFileLoader 
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT = biocommon.copyright.Copyright.COPYRIGHT;

    
	//Map<byte[], Map<byte[], byte[]>>
//	public static final void loadFromMMTX(Map<Integer, byte[]> 					conceptIdToConceptName, 
//			  HashMap<Integer, HashMap<Integer, Integer>> 	phraseIdToConceptIdList,
//			  Map<byte[], Integer> 					wordHT,			//
//			  Map<Integer, Map<Integer, Integer>> 	wid2pids)
	public static final void loadFromMMTX(HashedMap conceptIdToConceptName, 
										  HashedMap phraseIdToConceptIdList,
										  HashedMap wordHT,			//
										  HashedMap wid2pids)
		throws Exception
	{
		// Initialization
		int wordId=0;
		wordHT.clear();
		
		
		// Build concept id to concept name map
		// Input line looks like: 
		//		C0026764|Multiple Myeloma
    	BufferedReader textFileReader = null;
    	try
    	{
    		File inputFile = new File("data\\cui_concept.txt");

    		textFileReader = new BufferedReader(new FileReader(inputFile));
		
    		String line = null;
    		while ((line = textFileReader.readLine()) != null)
    		{
    			String[] fields = line.split("[|]");
			
    			if (fields.length != 2)
    				throw new Exception("Invalid cui_concept.txt format: " + line);
    			
    			try
    			{
    				int conceptId = Integer.parseInt(fields[0].substring(1, fields[0].length()));
    				
    				String[] conceptNameWords = fields[1].split(" ");
    				int wordIdList[] = new int[conceptNameWords.length];
    				int wordIdListIndex = 0;
    				
        			for (String word : conceptNameWords)
        			{
        				byte[] wordBytes = word.getBytes();
        				if (!wordHT.containsKey(wordBytes))
        				{
        					wordId++;
        					wordHT.put(wordBytes, wordId);
        					wordIdList[wordIdListIndex] = wordId;
        				}
        				else
        				{
        					int existingWordId = ((Integer) wordHT.get(wordBytes)).intValue(); 
        					wordIdList[wordIdListIndex] = existingWordId;
        				}
        				
        				wordIdListIndex++;
        			}
        				
;
    				//AnnotatorString conceptId   = new AnnotatorString(fields[0]);
    				//AnnotatorString conceptName = new AnnotatorString(fields[1]);
			
    				//System.out.println(line);
	    			//System.out.println("\tFieldLen:" + fields.length);
	    			//System.out.println("\tF1:'" + fields[0] + "'");
	    			//System.out.println("\tF2:'" + fields[1] + "'");
    			
    				//if (conceptIdToConceptName.containsKey(conceptId))
    				//	throw new Exception("cui_concept key already exists: '" + conceptId + "', '" + conceptName + "', " + line);
    				
    				conceptIdToConceptName.put(conceptId, wordIdList);
    			}
    			catch(Exception e)
    			{
    			}
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
    	finally 
    	{
    		try 
    		{
    			if (textFileReader!= null) 
    			{
    				//	flush and close both "input" and its underlying FileReader
    				textFileReader.close();
    			}
    		}
    		catch(Exception e) {} 
    	}
    	System.gc();
    	System.out.println("1");
    	
    	
//		int totalChars = 0;
//    	try
//    	{
//    		File inputFile = new File("data\\ConceptIdToConceptName.txt");
//
//    		textFileReader = new BufferedReader(new FileReader(inputFile));
//		
//    		String conceptIdLine = null;
//    		while ((conceptIdLine = textFileReader.readLine()) != null)
//    		{
//    			AnnotatorString conceptNameLine = new AnnotatorString(textFileReader.readLine());
//    			
//    			if (conceptIdToConceptName.containsKey(conceptIdLine))
//    				throw new Exception("cui_concept key already exists: '" + conceptIdLine + "', '" + conceptNameLine.toString() + "'");
//    			
//    			conceptIdToConceptName.put(new AnnotatorString(conceptIdLine), conceptNameLine);
//    			
//    			totalChars += conceptIdLine.length() + conceptNameLine.length();
//    		}
//    		
//    		//System.out.println("1");
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
//    	System.gc();
//    	System.out.println("totalChars=" + totalChars);
    	
    	
		// Build Phrase-to-Concept map
		// Input line looks like: 
		//		S0000005|C0025362
    	int numPhrases = 0;
    	int numConcepts = 0;
    	int totalChars2 = 0;
    	try
    	{
    		File inputFile = new File("data\\sui_cui.txt");

    		textFileReader = new BufferedReader(new FileReader(inputFile));
		
    		String line = null;
    		while ((line = textFileReader.readLine()) != null)
    		{
    			String[] fields = line.split("[|]");
			
    			if (fields.length != 2)
    				throw new Exception("Invalid sui_cui format: " + line);
    			
    			numPhrases++;
    			int phraseId = Integer.parseInt(fields[0].substring(1, fields[0].length()));
    			int conceptId = Integer.parseInt(fields[1].substring(1, fields[1].length()));
    			//byte[] phraseId = fields[0].getBytes();
    			//byte[] conceptId = fields[1].getBytes();
    			
    			//totalChars2 += phraseId.length + conceptId.length;
    			
    			//AnnotatorString phraseId  = new AnnotatorString(fields[0]);
    			//AnnotatorString conceptId = new AnnotatorString(fields[1]);
			
    			//System.out.println(line);
    			//System.out.println("\tFieldLen:" + fields.length);
    			//System.out.println("\tF1:'" + fields[0] + "'");
    			//System.out.println("\tF2:'" + fields[1] + "'");
    			
				if (!phraseIdToConceptIdList.containsKey(phraseId))
				{
					numConcepts++;
					//HashMap<Integer, Integer> conceptIdList = new HashMap<Integer, Integer>();
					//HashedMap conceptIdList = new HashedMap();
					//conceptIdList.put(new Integer(conceptId), new Integer(conceptId));
					ArrayList<Integer> conceptIdList = new ArrayList<Integer>();
					conceptIdList.add(conceptId);
					phraseIdToConceptIdList.put(new Integer(phraseId), conceptIdList);
					//phraseIdToConceptIdList.put(phraseId, conceptId);
				}
				else
				{
					//Map<byte[], byte[]> conceptIdList = phraseIdToConceptIdList.get(phraseId);
					//HashMap<Integer, Integer> conceptIdList = phraseIdToConceptIdList.get(phraseId);
					//HashedMap conceptIdList = (HashedMap) phraseIdToConceptIdList.get(phraseId);
					//if (!conceptIdList.containsKey(conceptId))
					//	conceptIdList.put(conceptId, conceptId);
					ArrayList<Integer> conceptIdList =  (ArrayList<Integer>) phraseIdToConceptIdList.get(phraseId);
					conceptIdList.add(conceptId);
				}
    		}
    	}
    	finally 
    	{
    		try 
    		{
    			if (textFileReader!= null) 
    			{
    				//	flush and close both "input" and its underlying FileReader
    				textFileReader.close();
    			}
    		}
    		catch(Exception e) {} 
    	}
    	System.gc();
    	System.out.println("2");
    	System.out.println("numPhrases=" + numPhrases);
    	System.out.println("numConcepts=" + numConcepts);
    	System.out.println("totalChars=" + totalChars2);
    	System.out.println();
    	

		// Build terms map and phrase terms map
    	//	S0005246|myeloma|Myeloma
    	int totalChars3 = 0;
    	try
    	{
    		int termId = 0;
    		File inputFile = new File("data\\sui_nmstr_str.txt");

    		textFileReader = new BufferedReader(new FileReader(inputFile));
		
    		String line = null;
		
    		while ((line = textFileReader.readLine()) != null)
    		{
    			String[] fields = line.split("[|]");
			
    			if (fields.length != 3)
    				throw new Exception("Invalid sui_nmstr_str format: " + line);
			
    			//System.out.println(line);
    			//System.out.println("\tC:" + fields.length);
    			//System.out.println("\tF1:'" + fields[0] + "'");
    			//System.out.println("\tF2:'" + fields[1] + "'");
    			//System.out.println("\tF3:'" + fields[2] + "'");
    			
    			int phraseId = Integer.parseInt(fields[0].substring(1, fields[0].length()));
    			String[] phraseTerms = fields[1].split(" ");
    			
    			// Add new terms to maps
    			for (String phraseTerm : phraseTerms)
    			{
    				//AnnotatorString phraseTermAnnotator = new AnnotatorString(phraseTerm);
    				byte[] phraseTermBytes = phraseTerm.getBytes();
    				
    				if (!wordHT.containsKey(phraseTermBytes))
    				{
    					termId++;
    					wordHT.put(phraseTermBytes, termId);
    					totalChars3 += phraseTermBytes.length;
    				}
    				
    				//int thisTermId = wordHT.get(phraseTermAnnotator);
    				
    				if (!wid2pids.containsKey(termId))
    				{
    					//Map<Integer, Integer> pidList = new HashMap<Integer, Integer>();
						//pidList.put(phraseId, phraseId);
						//wid2pids.put(termId, pidList);
    					ArrayList<Integer> pidList = new ArrayList<Integer>();
    					pidList.add(phraseId);
    					wid2pids.put(termId, pidList);
    				}
    				else
    				{
    					//Map<Integer, Integer> pidList = wid2pids.get(termId);
    					ArrayList<Integer> pidList = (ArrayList<Integer>) wid2pids.get(termId);
    					pidList.add(phraseId);
    					//if (!pidList.containsKey(phraseId))
    						//pidList.put(phraseId, phraseId);
    				}
    			}
    		}
    		
    		
    		//for (byte[] term : wordHT.keySet())
    		//	totalChars += term.length;
    		
    		System.out.println("# of unique terms: " + wordHT.size());
    		System.out.println("Total chars: " + totalChars3);
    		System.out.println("Avg chars per term: " + (totalChars3 / wordHT.size()));
    		System.gc();
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
    	finally 
    	{
    		try 
    		{
    			if (textFileReader!= null) 
    			{
    				//	flush and close both "input" and its underlying FileReader
    				textFileReader.close();
    			}
    		}
    		catch(Exception e) {} 
    	}

	}
}