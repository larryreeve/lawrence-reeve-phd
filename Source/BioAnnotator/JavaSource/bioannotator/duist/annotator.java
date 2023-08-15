/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator.duist;

import java.io.*;
import java.util.*;


//import edu.drexelist.bioannotator.conceptload.*;
//import org.apache.commons.collections.map.*;

public class annotator
{
    @SuppressWarnings("unused")
    private static final String  COPYRIGHT         = biocommon.copyright.Copyright.COPYRIGHT;

    private static String        FILENAME_CID2NAME = "data\\bio_cid2name.txt";
    private static String        FILENAME_PID2CIDS = "data\\bio_pid2cids.bin";
    private static String        FILENAME_PID2WIDS = "data\\bio_pid2wids.bin";
    private static String        FILENAME_WID2PIDS = "data\\bio_wid2pids.bin";
    private static String        FILENAME_WORD2WID = "data\\bio_word2wid.txt";

    private Map<Integer, String> cid2name          = null;
    private int[][]              pid2cids          = null;
    private int[][]              pid2wids          = null;
    private int[][]              wid2pids          = null;
    private Map<String, String>  stopWordList      = null;
    private Map<String, Integer> wordHT            = null;


	public static void main(String [] args)
		throws Exception
	{
		annotator testAnnotator = new annotator();
		
//		testAnnotator.preProcessMMTX();
		
		testAnnotator.initializeFromMMTX();
		
		testAnnotator.initializeStopWords();
		
		testAnnotator.annotateFromPhraseFile(args[0]);
	
//		testAnnotator.annotatePhrase("possible therapeutic role");
	}
    
	public void annotateFromPhraseFile(String phraseFilename)
		throws Exception
	{
		BufferedReader textFileReader = null;
		String inputLine = null;

		textFileReader = new BufferedReader(new FileReader(new File(phraseFilename)));
		
		while ((inputLine = textFileReader.readLine()) != null)
		{
			if (inputLine != null && 
				inputLine.length() > 0 && 
				!inputLine.startsWith("\t"))
			{
				annotatePhrase(inputLine);
			}
		}
		textFileReader.close();
	}

	
	public void annotatePhrase(String phraseToAnnotate)
	{
		StringBuffer candidatePhrase = new StringBuffer();
		List<wordInfo> contentWords = new ArrayList<wordInfo>();
		
		// Split phrase into words
		String[] phraseWords = phraseToAnnotate.split(" ");
		int positionIndex = 0;
		List<wordInfo> phraseWordList = new ArrayList<wordInfo>();
		for (String word : phraseWords)
		{
			wordInfo wordEntry = new wordInfo();
			wordEntry.word = word;
			wordEntry.position = positionIndex;
			positionIndex++;
			phraseWordList.add(wordEntry);
		}
	
		
		// Remove stop words and non-UMLS words
		for (wordInfo wordEntry : phraseWordList)
		{
			if (!this.stopWordList.containsKey(wordEntry.word) &&
				 this.wordHT.containsKey(wordEntry.word))
			{
				contentWords.add(wordEntry);
				
				if (candidatePhrase.length() > 0)
					candidatePhrase.append(" ");
				candidatePhrase.append(wordEntry.word);
			}
		}
		
		if (contentWords.size() == 0)
			return;

		candidatePhraseInfo candidateInfo = new candidatePhraseInfo();
		candidateInfo.phrase = phraseToAnnotate;
		candidateInfo.positionStart = 0;
		candidateInfo.positionEnd = contentWords.size() - 1;
		candidateInfo.coverageLength = (candidateInfo.positionEnd - candidateInfo.positionStart) + 1;
		candidateInfo.setConceptPhrases(getConceptPhrasesForCandidatePhrase(candidatePhrase.toString()));

		System.out.println(phraseToAnnotate + "(" + candidatePhrase.toString() + ")");
		for (Integer pid : candidateInfo.getConceptPhrases().keySet())
		{
			int cidList[] = pid2cids[pid.intValue()];
			for (int cid : cidList)
			{
				Integer cidInteger = Integer.valueOf(cid);
				
				System.out.println("\tC" + cidInteger.intValue() + "|" + cid2name.get(cidInteger) + "|");
			}
		}
	}

	public void annotateSentence(String sentenceToAnnotate)
	{
		StringBuffer candidatePhrase = new StringBuffer();
		List<wordInfo> contentWords = new ArrayList<wordInfo>();
		Map<String, candidatePhraseInfo> candidatePhrases = new HashMap<String, candidatePhraseInfo>();
		
		// Split phrase into words
		String[] phraseWords = sentenceToAnnotate.split(" ");
		int positionIndex = 0;
		List<wordInfo> phraseWordList = new ArrayList<wordInfo>();
		//stemmerLovins stemmer = new stemmerLovins();
		for (String word : phraseWords)
		{
			wordInfo wordEntry = new wordInfo();
			wordEntry.word = word;
			wordEntry.position = positionIndex;
			positionIndex++;
			phraseWordList.add(wordEntry);
		}
	
		
		// Remove stop words and non-UMLS words
		for (wordInfo wordEntry : phraseWordList)
		{
			if (!this.stopWordList.containsKey(wordEntry.word) &&
				 this.wordHT.containsKey(wordEntry.word))
				contentWords.add(wordEntry);
		}
		
		if (contentWords.size() == 0)
			return;
		
		// Build list of candidate phrases
		for (int idxRoot=0; idxRoot < contentWords.size(); idxRoot++)
		{
			candidatePhrase.setLength(0);
			
			int positionStart = contentWords.get(idxRoot).position;
			
			for (int idxSubRoot=idxRoot; idxSubRoot < contentWords.size(); idxSubRoot++)
			{
				if (candidatePhrase.length() > 0)
					candidatePhrase.append(" ");
				candidatePhrase.append(contentWords.get(idxSubRoot).word);
				
				candidatePhrase.trimToSize();
				
				if (!candidatePhrases.containsKey(candidatePhrase.toString()))
				{
					candidatePhraseInfo candidateInfo = new candidatePhraseInfo();
					
					candidateInfo.phrase = candidatePhrase.toString();
					candidateInfo.positionStart = positionStart;
					candidateInfo.positionEnd = contentWords.get(idxSubRoot).position;
					candidateInfo.coverageLength = (candidateInfo.positionEnd - candidateInfo.positionStart) + 1;
					
					candidatePhrases.put(candidatePhrase.toString(), candidateInfo);
					
//					System.out.println("Candidate phrase: " + candidatePhrase.toString());
				}
			}
		}
		
		// Compute coverage score for each phrase
		for (String phraseKey : candidatePhrases.keySet())
		{
			candidatePhraseInfo candidateInfo = candidatePhrases.get(phraseKey);
			candidateInfo.setConceptPhrases(getConceptPhrasesForCandidatePhrase(phraseKey));
		}
		

		//
		// Annotate sentence
		//
		List<candidatePhraseInfo> candidatePhraseList = new ArrayList<candidatePhraseInfo>(); 
		for (String phraseKey : candidatePhrases.keySet())
		{
			candidatePhraseInfo candidateInfo = candidatePhrases.get(phraseKey);
//			candidateInfo.setScore((candidateInfo.conceptPhraseScore * contentWords.size()) + 
//									candidateInfo.coverageLength);
			candidateInfo.setScore(candidateInfo.conceptPhraseScore);
			candidatePhraseList.add(candidateInfo);
		}
		
		Object[] candidatePhraseArray = candidatePhraseList.toArray();
		
		Arrays.sort(candidatePhraseArray, 
					new Comparator() 
					{
		    			public int compare(Object o1, Object o2) 
		    			{
		    				candidatePhraseInfo cp1 = (candidatePhraseInfo) o1;
		    				candidatePhraseInfo cp2 = (candidatePhraseInfo) o2;
		    				
		    				if (cp1.getScore() > cp2.getScore())
		    					return -1;
		    				if (cp1.getScore() < cp2.getScore())
		    					return 1;
		    				
		    				if (cp1.coverageLength > cp2.coverageLength)
		    					return -1;
		    				if (cp1.coverageLength < cp2.coverageLength)
		    					return 1;
		    				
		    				return 0;
		    			}
					});
		
		
		candidatePhraseList.clear();
		for (Object o : candidatePhraseArray)
		{
			candidatePhraseInfo phrase = (candidatePhraseInfo) o;
			
			boolean alreadyMapped = false;
			for (candidatePhraseInfo existingPhrase : candidatePhraseList)
			{
				if (phrase.positionStart >= existingPhrase.positionStart && 
					phrase.positionStart <= existingPhrase.positionEnd)
				{
					alreadyMapped = true;
				}
				else if (phrase.positionEnd >= existingPhrase.positionStart && 
						phrase.positionEnd <= existingPhrase.positionEnd)
				{
					alreadyMapped = true;
				}
			}
			
			if (!alreadyMapped)
				candidatePhraseList.add(phrase);
		}
		
		
		// Output phrase scores
//		System.out.println("Candidate phrase scores: (" + candidatePhraseArray.length + ")");
//		for (Object o : candidatePhraseArray)
//		{
//			candidatePhraseInfo phrase = (candidatePhraseInfo) o;
//			System.out.println(phrase.phrase + ": " + phrase.getScore() + "," + phrase.positionStart + "," + phrase.positionEnd);
//		}

		
		// Output phrases with concepts
		Map<Integer, String> finalConcepts = new HashMap<Integer, String>();
		System.out.println(sentenceToAnnotate);
		for (candidatePhraseInfo phrase : candidatePhraseList)
		{
			for (Integer pid : phrase.getConceptPhrases().keySet())
			{
				int cidList[] = pid2cids[pid.intValue()];
				for (int cid : cidList)
				{
					Integer cidInteger = Integer.valueOf(cid);
					
					if (!finalConcepts.containsKey(cidInteger))
						finalConcepts.put(cidInteger, cid2name.get(cidInteger));
				}
			}
		}
		
//		for (Integer cidInteger : finalConcepts.keySet())
//		{
//			System.out.println("\tC" + cidInteger.intValue() + "|" + finalConcepts.get(cidInteger) + "|");
//		}


//		System.out.println();
//		System.out.println("Candidate phrases");
//		System.out.println("=================");
//		for (candidatePhraseInfo phrase : candidatePhraseList)
//		{
//			//System.out.println("Candidate phrase: " + phrase.phrase);
//			System.out.print("Phrase (" + phrase.positionStart + ":" + phrase.positionEnd + "): ");
//			for (wordInfo wordEntry : phraseWordList)
//			{
//				//System.out.print(wordEntry.position + ":");
//				if (wordEntry.position >= phrase.positionStart && 
//					wordEntry.position <= phrase.positionEnd)
//				{
//					System.out.print(wordEntry.word + " ");
//				}
//			}
//			System.out.println();
//				
//			System.out.println("\tConcepts:");
//			
//			for (Integer pid : phrase.getConceptPhrases().keySet())
//			{
//				int cidList[] = pid2cids[pid.intValue()];
//				for (int cid : cidList)
//				{
//					String conceptName = cid2name.get(Integer.valueOf(cid));
//					System.out.println("\tC" + cid + "|" + conceptName + "|" + phrase.getScore());
//				}
//			}
//		}
	}
	
	
	public Map<Integer,Double> getConceptPhrasesForCandidatePhrase(String	candidatePhrase)
	{
		// Get list of words in candidate phrase
		String[] candidatePhraseWords = candidatePhrase.split(" ");
		int widListCandidate[] = new int[candidatePhraseWords.length];
		
		// Get list of candidate phrase pids
		int widListCandidateIndex = 0;
		for (String phraseWordCandidate : candidatePhraseWords)
		{
			int wid = ((Integer) wordHT.get(phraseWordCandidate)).intValue();
			
			widListCandidate[widListCandidateIndex] = wid;
			widListCandidateIndex++;
		}
		
		// Get frequency count all concept phrases having the candidate terms
		Map<Integer, Integer> phraseIdFrequency = new HashMap<Integer, Integer>();
		for (int wid : widListCandidate)
		{
			int[] pidListConcept = wid2pids[wid];
		
			if (pidListConcept != null)
			{
				for (int pidConcept : pidListConcept)
				{
					Integer pidConceptInteger = Integer.valueOf(pidConcept);
					
					if (!phraseIdFrequency.containsKey(pidConceptInteger))
					{
						phraseIdFrequency.put(pidConceptInteger, Integer.valueOf(1));
					}
					else
					{
						Integer freqCount = phraseIdFrequency.get(pidConceptInteger);
						phraseIdFrequency.put(pidConceptInteger, Integer.valueOf(freqCount.intValue()+1));
					}
				}
			}
		}

		// Get list of all concept phrases having the candidate terms
		Map<Integer, Double> phraseIdList = new HashMap<Integer, Double>();
		for (Integer pidConceptInteger : phraseIdFrequency.keySet())
		{
			Integer freqCount = phraseIdFrequency.get(pidConceptInteger);
			if (freqCount.intValue() == widListCandidate.length)
			{
				if (!phraseIdList.containsKey(pidConceptInteger))
					phraseIdList.put(pidConceptInteger, null);
			}
		}
		

		
		// Compute coverage score for each concept phrase
//		System.out.println();
//		System.out.println("coverage score for each concept phrase");
//		System.out.println("======================================");
		double highScore = 0.0;
		for (Integer phraseId : phraseIdList.keySet())
		{
			int matchCount = 0;
			
			// Get list of terms in concept phrase
			int[] widListConcept = pid2wids[phraseId.intValue()];
//			
//			for (int wid : widListConcept)
//			{
//				Integer widInteger = Integer.valueOf(wid);
//				boolean foundFlag = false;
//				
//				for (String word : this.wordHT.keySet())
//				{
//					if (widInteger.compareTo(this.wordHT.get(word)) == 0)
//					{
//						System.out.print(" " + word);
//						foundFlag = true;
//					}
//				}
//				if (!foundFlag)
//					System.out.print(" " + widInteger.toString());
//			}
//			System.out.println();
			
			// Score Concept_phrase: # of terms in concept_phrase matching candidate_phrase terms
			double conceptPhraseScore = 0.0;
			matchCount = 0;
			for (int widConcept : widListConcept)
			{
				boolean found = false;
				for (int widCandidate : widListCandidate)
				{
					if (widCandidate == widConcept)
					{
						matchCount++;
						found = true;
						break;
					}
				}
				
				if (!found)
					break;
			}
			conceptPhraseScore = matchCount / (widListConcept.length * 1.0);
			if (conceptPhraseScore > 1.0)
			{
				System.out.println("score errorCO: " + conceptPhraseScore);
			}
			
			
			// Score Candidate_phrase: # of terms matching concept_phrase
			double candidatePhraseScore = 0.0; 
			matchCount = 0;
			for (int widCandidate : widListCandidate)
			{
				boolean found = false;
				for (int widConcept : widListConcept)	
				{
					if (widConcept == widCandidate)
					{
						matchCount++;
						found = true;
						break;
					}
				}
				if (!found)
					break;
			}
			candidatePhraseScore = matchCount / (widListCandidate.length * 1.0);
			if (candidatePhraseScore > 1.0)
			{
				System.out.println("score errorCA: " + candidatePhraseScore);
			}
			
			//double coverageScore = ((conceptPhraseScore * 0.66) + (candidatePhraseScore * 0.33)) / 2;
			double coverageScore = (conceptPhraseScore + candidatePhraseScore) / 2;
			if (coverageScore > 1.0)
			{
				System.out.println("score error: " + coverageScore);
			}
			
			if (coverageScore > highScore)
				highScore = coverageScore;
			
//			System.out.println("candidate:" + candidatePhraseScore + ", concept:" + conceptPhraseScore + ", coverage:" + coverageScore);
			
			
			phraseIdList.put(phraseId, new Double(coverageScore));
		}
		

		// Get list of highest scoring concepts
		Map<Integer, Double> phraseIdListBest = new HashMap<Integer, Double>();
		for (Integer phraseId : phraseIdList.keySet())
		{
			Double score = phraseIdList.get(phraseId);
			
			if (score.doubleValue() >= highScore)
			{
				phraseIdListBest.put(phraseId, score);
			}
		}

		// Display all phrases w/scores
//		System.out.println("\tphrase: " + candidatePhrase + " (" + phraseIdList.size() + ")"); 
//		for (Integer pid : phraseIdListBest.keySet())
//		{
//			Double score = phraseIdListBest.get(pid);
//			if (score != null)
//			{
//				System.out.println("\t\t" + pid + " == " + score.toString());
//				
//				int cidList[] = pid2cids[pid.intValue()];
//				for (int cid : cidList)
//				{
//					String conceptName = cid2name.get(Integer.valueOf(cid));
//					System.out.println("\t\t\t[" + cid + "] == " + conceptName);
//				}
//			}
//		}
		
		return phraseIdListBest;
	}
	
	
	private void initializeStopWords()
		throws Exception
	{
		this.stopWordList = new HashMap<String, String>();
		
		BufferedReader textFileReader = null;
		
		try
		{
    		textFileReader = new BufferedReader(new FileReader(new File("data\\StopWordsList.txt")));
		
    		String line = null;
    		while ((line = textFileReader.readLine()) != null)
    		{		
    			this.stopWordList.put(line.trim().toLowerCase(), null);
    		}
    	}
    	catch(Exception e)
    	{
    		throw e;
    	}
    	finally 
    	{
    		try 
    		{
    			if (textFileReader!= null) 
    				textFileReader.close();
    		}
    		catch(Exception e) {} 
    	}
	}

	public void initializeFromMMTX()
		throws Exception
	{
		IteratedLovinsStemmer stemmer = new IteratedLovinsStemmer();
		BufferedReader textFileReader = null;
		DataInputStream binaryReader = null;
		String inputLine = null;
		int numEntries = 0;

		//
		// cid2name
		textFileReader = new BufferedReader(new FileReader(new File(FILENAME_CID2NAME)));
		
		// Get number of entries
		inputLine = textFileReader.readLine();
		numEntries = Integer.valueOf(inputLine).intValue();
		this.cid2name = new HashMap<Integer, String>(numEntries);
		
		while ((inputLine = textFileReader.readLine()) != null)
		{
			Integer cid  = Integer.valueOf(inputLine);
			String  name = textFileReader.readLine();
			
			this.cid2name.put(cid, name);
		}
		textFileReader.close();
		//System.out.println("cid2name load completed");
		
		
		//
		// pid2cids
		binaryReader = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(FILENAME_PID2CIDS))));
		
		// Get number of entries
		numEntries = binaryReader.readInt();
		this.pid2cids = new int[numEntries][];
		
		while (binaryReader.available() != 0)
		{
			// Read pid
			int pid = binaryReader.readInt();
			
			// Read # of entries in cids list
			int listSize = binaryReader.readInt();
			
			//List<Integer> cidList = new ArrayList<Integer>(listSize);
			this.pid2cids[pid]= new int[listSize];
			
			for (int idx=0; idx < listSize; idx++)
			{
				//cidList.add(Integer.valueOf(binaryReader.readInt()));
				this.pid2cids[pid][idx] = binaryReader.readInt();
			}
		}
		binaryReader.close();
		//System.out.println("pid2cids load completed");
		
		//
		// pid2wids
		binaryReader = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(FILENAME_PID2WIDS))));
		
		// Get number of entries
		numEntries = binaryReader.readInt();
		
		this.pid2wids = new int[numEntries][];
		
		while (binaryReader.available() != 0)
		{
			// Read wid
			int pid = binaryReader.readInt();
			
			// Read # of entries in cids list
			int listSize = binaryReader.readInt();
			
			this.pid2wids[pid]= new int[listSize];
			
			for (int idx=0; idx < listSize; idx++)
			{
				this.pid2wids[pid][idx] = binaryReader.readInt();
			}
		}
		binaryReader.close();
		//System.out.println("pid2wids load completed");
		

		//
		// wid2pids
		binaryReader = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(FILENAME_WID2PIDS))));
		
		// Get number of entries
		numEntries = binaryReader.readInt();
		
		//this.wid2pids = new HashMap<Integer, List<Integer>>(numEntries);
		this.wid2pids = new int[numEntries][];
		
		while (binaryReader.available() != 0)
		{
			// Read cid
			int wid = binaryReader.readInt();
			
			// Read # of entries in cids list
			int listSize = binaryReader.readInt();
			
			this.wid2pids[wid]= new int[listSize];
			for (int idx=0; idx < listSize; idx++)
			{
				this.wid2pids[wid][idx] = binaryReader.readInt();
			}
		}
		binaryReader.close();
		//System.out.println("wid2pids load completed");
		
		
		//
		// word2wid
		textFileReader = new BufferedReader(new FileReader(new File(FILENAME_WORD2WID)));
		
		// Get number of entries
		inputLine = textFileReader.readLine();
		numEntries = Integer.valueOf(inputLine).intValue();
		this.wordHT = new HashMap<String, Integer>(numEntries);
		
		while ((inputLine = textFileReader.readLine()) != null)
		{
			String word = inputLine;
			
			inputLine = textFileReader.readLine();
			Integer wid  = Integer.valueOf(inputLine);
			
			this.wordHT.put(word, wid);
		}
		textFileReader.close();
		//System.out.println("word2wid load completed");

//		Runtime runtime = Runtime.getRuntime();
//		runtime.gc();
//		Thread.currentThread().yield();
		//System.out.println("Memory used: " + (runtime.totalMemory () - runtime.freeMemory()));
		//System.out.println();
	}

	public void preProcessMMTX()
		throws Exception
	{
		// Initialize
		HashMap<Integer, String> 		cid2name = new HashMap<Integer, String>(1000000);
		HashMap<Integer, List<Integer>> pid2cids = new HashMap<Integer, List<Integer>>(1000000);
		HashMap<Integer, List<Integer>>	pid2wids = new HashMap<Integer, List<Integer>>(1000000);
		HashMap<Integer, List<Integer>> wid2pids = new HashMap<Integer, List<Integer>>(1000000);
		HashMap<String, Integer> 		wordHT   = new HashMap<String, Integer>(1000000);
		HashMap<Integer, Integer> 		sui2pid  = new HashMap<Integer, Integer>(1000000);
		int wordIndex = 0;
		int phraseIndex = 0;
    	BufferedWriter textWriter = null;
    	DataOutputStream binaryWriter = null;
		
		// Build concept id to concept name map
		//	cid2name
		//
		// 	Input line looks like: 
		//		C0026764|Multiple Myeloma
    	BufferedReader textFileReader = null;
    	try
    	{
    		textFileReader = new BufferedReader(new FileReader(new File("data\\cui_concept.txt")));
		
    		String line = null;
    		while ((line = textFileReader.readLine()) != null)
    		{
    			String[] fields = line.split("[|]");
			
    			if (fields.length != 2)
    				throw new Exception("Invalid cui_concept.txt format: " + line);
    			
    			try
    			{
    				int cid = Integer.parseInt(fields[0].substring(1, fields[0].length()));
					cid2name.put(cid, fields[1]);
    			}
    			catch(NumberFormatException e)
    			{
    			}
    		}
    		textFileReader.close();
    		textFileReader = null;
    		
        	//	cid2name Output
    		Object cidList[] = cid2name.keySet().toArray();
    		Arrays.sort(cidList);
    		textWriter = new BufferedWriter(new FileWriter(FILENAME_CID2NAME));
    		textWriter.write(String.valueOf(cidList.length));
    		textWriter.newLine();
    		for (Object cid : cidList)
    		{
    			Integer cidValue = (Integer) cid;
    			
    			textWriter.write(cidValue.toString());
    			textWriter.newLine();
    		
    			String nameValue = cid2name.get(cidValue);
    			textWriter.write(nameValue);
    			textWriter.newLine();
    		}
    		textWriter.close();
    		
    		
    		cid2name.clear();
    		cid2name = null;
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
    				textFileReader.close();
    		}
    		catch(Exception e) {} 
    	}
    	System.gc();
    	System.out.println("1");
    	System.out.println();
	
	
    	
		// Build Phrase-to-Concept map
    	//	pid2cids
		// Input line looks like: 
		//		S0000005|C0025362
    	int numPhrases = 0;
    	try
    	{
    		textFileReader = new BufferedReader(new FileReader(new File("data\\sui_cui.txt")));
		
    		String line = null;
    		while ((line = textFileReader.readLine()) != null)
    		{
    			String[] fields = line.split("[|]");
			
    			if (fields.length != 2)
    				throw new Exception("Invalid sui_cui format: " + line);
    			
    			numPhrases++;
    			Integer suiId = Integer.parseInt(fields[0].substring(1, fields[0].length()));
    			Integer conceptId = Integer.parseInt(fields[1].substring(1, fields[1].length()));
    			
    			// Generate new phrase id if not already added
    			Integer pid = null;
    			if (!sui2pid.containsKey(suiId))
    			{
    				pid = Integer.valueOf(phraseIndex);
    				sui2pid.put(suiId, pid);
    				phraseIndex++;
    			}
    			else
    			{
    				pid = sui2pid.get(suiId);
    			}
    			
    			// Add cid to pid list
				if (!pid2cids.containsKey(pid))
				{
					ArrayList<Integer> conceptIdList = new ArrayList<Integer>();
					conceptIdList.add(conceptId);
					pid2cids.put(pid, conceptIdList);
				}
				else
				{
					ArrayList<Integer> conceptIdList =  (ArrayList<Integer>) pid2cids.get(pid);
					if (!conceptIdList.contains(conceptId))
						conceptIdList.add(conceptId);
				}
    		}
    		textFileReader.close();
    		textFileReader = null;
    		
            // pid2cids Output
    		Object pidList[] = pid2cids.keySet().toArray();
    		Arrays.sort(pidList);
    		binaryWriter = new DataOutputStream(new FileOutputStream(new File(FILENAME_PID2CIDS)));
    		binaryWriter.writeInt(pidList.length);
    		for (Object pid : pidList) 
    		{
    			int pidValue = ((Integer)pid).intValue();
    			
    			binaryWriter.writeInt(pidValue);

    			List<Integer> cidList = pid2cids.get(pidValue);
    			binaryWriter.writeInt(cidList.size());

    			for (Integer cid : cidList)
    				binaryWriter.writeInt(cid.intValue());
    		}
    		binaryWriter.close();
    		
    		pid2cids.clear();
    		pid2cids = null;
    	}
    	finally 
    	{
    		try 
    		{
    			if (textFileReader!= null) 
    				textFileReader.close();
    		}
    		catch(Exception e) {} 
    	}
    	System.gc();
    	System.out.println("2");
    	System.out.println("numPhrases=" + numPhrases);
    	System.out.println();

    	
    	// Build terms map and phrase terms map
    	//	wordHT,wid2pids,pid2wids 
    	//	S0005246|myeloma|Myeloma
    	try
    	{
    		textFileReader = new BufferedReader(new FileReader(new File("data\\sui_nmstr_str.txt")));
	
    		String line = null;
    		while ((line = textFileReader.readLine()) != null)
    		{
    			String[] fields = line.split("[|]");
		
    			if (fields.length != 3)
    				throw new Exception("Invalid sui_nmstr_str format: " + line);
		
    			int suiId = Integer.parseInt(fields[0].substring(1, fields[0].length()));
    			String[] phraseTerms = fields[1].split(" ");
    			ArrayList<Integer> widList = new ArrayList<Integer>();
    			
    			Integer pid = sui2pid.get(suiId);
			
    			// Add new terms to maps
    			for (String phraseTerm : phraseTerms)
    			{
    				Integer wid = null;

    				// Get word index
    				if (!wordHT.containsKey(phraseTerm))
    				{
    					wid = Integer.valueOf(wordIndex);
    					wordHT.put(phraseTerm, wid);
    					wordIndex++;
    				}
    				else
    				{
    					wid = (Integer) wordHT.get(phraseTerm);
    				}
    				
    				// Map word id to phrase id
    				if (!wid2pids.containsKey(wid))
    				{
    					ArrayList<Integer> pidList = new ArrayList<Integer>();
    					pidList.add(pid);
    					wid2pids.put(wid, pidList);
    				}
    				else
    				{
    					ArrayList<Integer> pidList = (ArrayList<Integer>) wid2pids.get(wid);
    					if (!pidList.contains(pid))
    						pidList.add(pid);
    				}
    				
    				widList.add(wid);
    			}
    			
    			pid2wids.put(pid, widList);
    		}
    		textFileReader.close();
    		textFileReader = null;
		
    		
        	//
        	// Generate preprocessed files
        	//
        	
        	//	word2wid
    		{
    		Object wordList[] = wordHT.keySet().toArray();
    		Arrays.sort(wordList);
    		textWriter = new BufferedWriter(new FileWriter(FILENAME_WORD2WID));
    		textWriter.write(String.valueOf(wordList.length));
    		textWriter.newLine();
    		for (Object word : wordList)
    		{
    			String wordValue = (String) word;
    			textWriter.write(wordValue);
    			textWriter.newLine();
    		
    			Integer widValue = wordHT.get(wordValue);
    			textWriter.write(widValue.toString());
    			textWriter.newLine();
    		}
    		textWriter.close();
    		}

    		
            // pid2wids Output
    		{
	    		Object pidList[] = pid2wids.keySet().toArray();
	    		Arrays.sort(pidList);
	    		binaryWriter = new DataOutputStream(new FileOutputStream(new File(FILENAME_PID2WIDS)));
	    		binaryWriter.writeInt(pidList.length);
	    		for (Object pid : pidList) 
	    		{
	    			int pidValue = ((Integer)pid).intValue();
	    			
	    			binaryWriter.writeInt(pidValue);
	
	    			List<Integer> widList = pid2wids.get(pidValue);
	    			binaryWriter.writeInt(widList.size());
	
	    			for (Integer wid : widList)
	    				binaryWriter.writeInt(wid.intValue());
	    		}
	    		binaryWriter.close();
    		}


            // wid2pids Output
    		{
	    		Object widList[] = wid2pids.keySet().toArray();
	    		Arrays.sort(widList);
	    		binaryWriter = new DataOutputStream(new FileOutputStream(new File(FILENAME_WID2PIDS)));
	    		binaryWriter.writeInt(widList.length);
	    		for (Object wid : widList) 
	    		{
	    			int widValue = ((Integer)wid).intValue();
	    			
	    			binaryWriter.writeInt(widValue);
	    			
	    			List<Integer> pidList = wid2pids.get(widValue);
	    			binaryWriter.writeInt(pidList.size());
	
	    			for (Integer pid : pidList)
	    				binaryWriter.writeInt(pid);
	    		}
	    		binaryWriter.close();
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
    				textFileReader.close();
    		}
    		catch(Exception e) {} 
    	}
    	
    	System.out.println("completed");
		System.gc();
		System.out.println();
	}
}
