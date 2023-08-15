/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biosumm.score;

import java.util.*;

import biocommon.document.*;
import biosumm.chain.*;


public class ScoreChainConceptFreqSentencePosition
	implements IScorer
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT    = biocommon.copyright.Copyright.COPYRIGHT;
    
	
    public void score(List<ConceptChain> 	conceptChainList,
					  Document 				annotatedDocument,
					  Properties 			parameters)
		throws Exception
	{
		// Get parameters
		int numStdDeviations = Integer.parseInt(parameters.getProperty("stddev", "2"));
		
		// 	Scoring method
		boolean useAllStrongChainConcepts = (parameters.getProperty("useallstrongchainconcepts", "false").equalsIgnoreCase("true"));
		//System.out.println("\tScoreChainConceptFreqSentencePosition: useAllStrongChainConcepts=" + useAllStrongChainConcepts);
		
		
		// Set initial sentence score based on sentence position
		for (DocumentSection section : annotatedDocument.getSections())
		{
			for (DocumentSentence sentence : section.getSentences())
			{
				//sentence.setScore(0.0);
				sentence.setScore(1.0 / (sentence.getSentenceNumber() + 1));
				//System.out.println("a:sen#" + sentence.getSentenceNumber() + ",score=" + sentence.getScore());
			}
		}

		// Calculate chain score
		for (ConceptChain chain : conceptChainList)
		{
			// Skip filtered chains
			if (chain.isFiltered())
				continue;
			
			int mostFrequentMatches=-1;
			int numUniqueOccurences = chain.getConceptList().size();
			
			//System.out.println("Scoring chain " + chain.getId());
			
			if (chain.getConceptList().size() > 0)
			{
				// Get a copy of the concept list and sort by concept type
				List<Concept> conceptSortedList = new ArrayList<Concept>();
				for (Concept c : chain.getConceptList())
					conceptSortedList.add(c);
				Collections.sort(conceptSortedList, new ComparatorConceptByConceptType());

				//for (Concept c : conceptSortedList)
				//{
				//	System.out.println(c.getId());
				//}

				// Find most common term
				Concept currConcept = null;
				mostFrequentMatches = 0;
				int numMatches = 0;
				
				for (Concept conceptEntry : conceptSortedList) 
				{
					
					if (currConcept == null)
					{
						currConcept = conceptEntry;
						numMatches++;
					}
					else if (currConcept.getId().equalsIgnoreCase(conceptEntry.getId())) 
					{
						//System.out.println("\tcompare: " + currConcept.getId() + " vs " + conceptEntry.getId());
						
						numMatches++;
						numUniqueOccurences--;
						//System.out.println("\tmatch, total=" + numMatches);
					}
					else 
					{
						//System.out.println("\tmatch, total=" + numMatches + ", frequent=" + mostFrequentMatches);
						
						if (numMatches > mostFrequentMatches) 
							mostFrequentMatches = numMatches;
						
						numMatches = 1;
						currConcept = conceptEntry;
					}
				}
				
				// Handle last concept entry
				if (numMatches > mostFrequentMatches) 
					mostFrequentMatches = numMatches;
				
				chain.setScore(mostFrequentMatches * numUniqueOccurences);
				
				//System.out.println("\tChain score: " + chain.getScore());
				//System.out.println("\t\tmostFrequentMatches=" + mostFrequentMatches + ", numUniqueOccurences=" + numUniqueOccurences);
			}
		}

		// Calculate sentence scores based on concept frequency
		// Find strong chains first
		
		// 	Make copy of chain list to sort in ascending order by score
		List<ConceptChain> tempChainList = new ArrayList<ConceptChain>();
		for (ConceptChain chain : conceptChainList)
			tempChainList.add(chain);
		Collections.sort(tempChainList, new ChainCompareByScore(false));
		
        // Calculate minimum chain score
        double 	totalScore = 0.0;
        double 	squareSum  = 0.0;
        int 	numEntries = 0;
        
		for (ConceptChain chain : tempChainList)
		{
        	if (chain.getConceptList().size() > 0)
        	{
        		numEntries++;
        		totalScore += chain.getScore();
        		squareSum  += (chain.getScore() * chain.getScore());
        	}
        }

        double averageScore = totalScore / numEntries;
        double stdDev = Math.sqrt(squareSum/numEntries - averageScore*averageScore);
        double strongChainMinScore = (averageScore + (numStdDeviations * stdDev));
        
        
        // 	Find strong chains, their most frequent concepts, and the update the scores of the
        //	sentences the concepts appear in
		for (ConceptChain chain : tempChainList)
		{
			if (chain.getScore() >= strongChainMinScore) 
			{
				//System.out.println("strong chain: " + chain.getId());
				
				// Build concept counts in chain
				Map<String, Integer> conceptCountMap = new HashMap<String, Integer>();
				for (Concept chainConcept : chain.getConceptList())
				{
		    		if (conceptCountMap.containsKey(chainConcept.getId()))
		    		{
		    			Integer conceptCount = conceptCountMap.get(chainConcept.getId());
		    			conceptCount++;
		    			conceptCountMap.put(chainConcept.getId(), conceptCount);
		    		}
		    		else
		    		{
		    			conceptCountMap.put(chainConcept.getId(), new Integer(1));
		    		}
				}
				
				// Get highest concept count in chain
		    	int highestConceptCount = 0;
		    	for (String conceptId : conceptCountMap.keySet())
				{
					Integer conceptCount = conceptCountMap.get(conceptId);
					
					if (conceptCount.intValue() > highestConceptCount)
						highestConceptCount = conceptCount.intValue();
				}

				// Find all sentences in chain whose concept count is = maxCount and update score
		    	for (String conceptId : conceptCountMap.keySet())
				{
					Integer conceptCount =  conceptCountMap.get(conceptId);
					
					//if (conceptCount.intValue() == highestConceptCount)
					if (useAllStrongChainConcepts || 
						    (!useAllStrongChainConcepts && (conceptCount.intValue() == highestConceptCount)))
					
					{
						for (Concept chainConcept : chain.getConceptList())
						{
							if (chainConcept.getId().equalsIgnoreCase(conceptId))
							{
								
								// Find the sentence this concept is from
								for (DocumentSection section: annotatedDocument.getSections())
								{
									for (DocumentSentence sentence : section.getSentences())
									{
											if (sentence.getSentenceNumber() == chainConcept.getSentenceNumber())
												sentence.setScore(sentence.getScore() + 0.5);
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
