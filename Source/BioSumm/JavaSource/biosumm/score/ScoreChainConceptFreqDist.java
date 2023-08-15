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


public class ScoreChainConceptFreqDist
	implements IScorer
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT    = biocommon.copyright.Copyright.COPYRIGHT;
    
	private enum ESimilarityFunction
	{
		COSINE,
		DICE,
		EUCLIDEAN,
		NEWITEMS,
		UNITFREQUENCY,
		VECTORSUBTRACTION
	}
	
	
	public void score(List<ConceptChain> 	conceptChainList,
					  Document 				annotatedDocument,
					  Properties 			parameters)
		throws Exception
	{
		//
		// Get parameters
		//
		
		//	# of Standard Deviations
		int numStdDeviations = Integer.parseInt(parameters.getProperty("stddev", "2"));
		
		// 	Determine similarity function to use
		String  paramSimilarityFunction = parameters.getProperty("similarityfunction", "dice");
		ESimilarityFunction similarityFunction = ESimilarityFunction.DICE;
		if (paramSimilarityFunction.equalsIgnoreCase("cosine"))
			similarityFunction = ESimilarityFunction.COSINE;
		else if (paramSimilarityFunction.equalsIgnoreCase("dice"))
			similarityFunction = ESimilarityFunction.DICE;
		else if (paramSimilarityFunction.equalsIgnoreCase("euclidean"))
			similarityFunction = ESimilarityFunction.EUCLIDEAN;
		else if (paramSimilarityFunction.equalsIgnoreCase("newitems"))
			similarityFunction = ESimilarityFunction.NEWITEMS;
		else if (paramSimilarityFunction.equalsIgnoreCase("unitfrequency"))
			similarityFunction = ESimilarityFunction.UNITFREQUENCY;
		else if (paramSimilarityFunction.equalsIgnoreCase("vectorsubtraction"))
			similarityFunction = ESimilarityFunction.VECTORSUBTRACTION;
		else
			throw new Exception("Unknown similarity function: " + similarityFunction);
		
		// 	Scoring method
		boolean useAllStrongChainConcepts = (parameters.getProperty("useallstrongchainconcepts", "false").equalsIgnoreCase("true"));

		System.out.println("\tScoreChainConceptFreqDist: AllStrongChainConcepts=" + useAllStrongChainConcepts + ", similarity=" + similarityFunction);
		
		// Build list of sentences: initialize sentence scores, determine # of sentences
		Map<Integer, DocumentSentence> sentenceList = new HashMap<Integer, DocumentSentence>();
		for (DocumentSection section : annotatedDocument.getSections())
		{
			for (DocumentSentence sentence : section.getSentences())
			{
				sentence.setScore(0.0);
				sentenceList.put(sentence.getSentenceNumber(), sentence);		
			}
		}
		
		// Initialize sentence score based on sentence position
		for (Integer sentenceNumber : sentenceList.keySet())
		{
			DocumentSentence sentence = sentenceList.get(sentenceNumber);
			sentence.setScore(new Double(1 / sentenceList.size()));
		}


		// Get list of unit items in each sentence
		Map<Integer, ArrayList<String>> sentenceUnitItems = new HashMap<Integer, ArrayList<String>>();
		for (Integer sentenceNumber : sentenceList.keySet())
		{
			DocumentSentence sentence = sentenceList.get(sentenceNumber);
			
			ArrayList<String> unitItemList = new ArrayList<String>();
			
			// Find sentence concepts
			for (DocumentPhrase phrase : sentence.getPhrases())
			{
				for (String conceptName : phrase.getConcepts().keySet())
				{
					DocumentConcept concept = phrase.getConcepts().get(conceptName);
				
					String conceptId = concept.getId();
				
					unitItemList.add(conceptId);
				}
			}
			
			sentenceUnitItems.put(new Integer(sentence.getSentenceNumber()), unitItemList);
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

				// Find most common concept
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
		
		//
		// Calculate sentence scores based on concept frequency
		//
		
		// Find strong chains first
		
		// 	Make copy of chain list to sort in ascending order by score
		List<ConceptChain> sortedScoreChainList = new ArrayList<ConceptChain>();
		for (ConceptChain chain : conceptChainList)
			sortedScoreChainList.add(chain);
		Collections.sort(sortedScoreChainList, new ChainCompareByScore(false));
		
        // Calculate minimum chain score
        double 	totalScore = 0.0;
        double 	squareSum  = 0.0;
        int 	numEntries = 0;

		for (ConceptChain chain : sortedScoreChainList)
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
        
        List<ConceptChain> strongChainList = new ArrayList<ConceptChain>();
		for (ConceptChain chain : sortedScoreChainList)
		{
			if (chain.getScore() >= strongChainMinScore) 
			{
				strongChainList.add(chain);
			}
		}

		
        // 	Find the most frequent strong chain concepts, and the update the scores of the
        //	sentences the concepts appear in
		for (ConceptChain chain : strongChainList)
		{
			// Build concept counts in strong chain
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
				
			// Get highest concept count in strong chain
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
				
				if ((useAllStrongChainConcepts) || 
				    (!useAllStrongChainConcepts && (conceptCount.intValue() == highestConceptCount)))
				{
					//System.out.println("\tUsing strong chain concept: " + conceptId);
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

    	
		//
		// Calculate sentence scores based on concept frequency distribution
		//
		
		// Get concepts in all strong chains
//		Map<String, Integer> unitItemCountsSourceText = new HashMap<String, Integer>();
//		for (ConceptChain strongChain : strongChainList)
//		{
//			for (Concept strongchainConcept : strongChain.getConceptList())
//			{
//	    		if (unitItemCountsSourceText.containsKey(strongchainConcept.getId()))
//	    		{
//					Integer count = unitItemCountsSourceText.get(strongchainConcept.getId());
//					count++;
//					unitItemCountsSourceText.put(strongchainConcept.getId(), count);
//	    		}
//	    		else
//	    		{
//	    			unitItemCountsSourceText.put(strongchainConcept.getId(), new Integer(1));
//	    		}
//			}
//		}
		
		// Get concepts in full-text
		Map<String, Integer> unitItemCountsSourceText = new HashMap<String, Integer>();
		for (Integer sentenceNumber : sentenceUnitItems.keySet())
		{
			ArrayList<String> unitItemList = sentenceUnitItems.get(sentenceNumber);
			
			for (String conceptId : unitItemList)
			{
	    		if (unitItemCountsSourceText.containsKey(conceptId))
	    		{
					Integer count = unitItemCountsSourceText.get(conceptId);
					count++;
					unitItemCountsSourceText.put(conceptId, count);
	    		}
	    		else
	    		{
	    			unitItemCountsSourceText.put(conceptId, new Integer(1));
	    		}
			}
		}
		

		// Duplicate and initialize model summary entries from source text
		Map<String, Integer> unitItemCountsSummary = new HashMap<String, Integer>();
		for (String unitItem : unitItemCountsSourceText.keySet())
			unitItemCountsSummary.put(unitItem, new Integer(0));
		
		// Score each sentence
		Integer bestSentenceNumber = new Integer(-1);
		Double  bestSentenceScore = 0.0;
		Map<String, Integer> unitItemCountsCandidateSummary = new HashMap<String, Integer>();
		
		for (int sentenceScoreIdx=sentenceList.size(); sentenceScoreIdx > 0; sentenceScoreIdx--)
		{
			bestSentenceScore = 0.0;
			bestSentenceNumber = -1;
			
			for (Integer sentenceNumber : sentenceList.keySet())
			{
				DocumentSentence sentence = sentenceList.get(sentenceNumber);

				// Skip sentences not selected by BioChain
				if (sentence.getScore() <= 0.0)
					continue;

				// Skip sentences already scored
				if (sentence.getScore() > 10000)
					continue;
				
				// Initialize unit item counts of candidate summary to the current summary
				unitItemCountsCandidateSummary.clear();
				for (String unitItemId : unitItemCountsSummary.keySet())
					unitItemCountsCandidateSummary.put(unitItemId, unitItemCountsSummary.get(unitItemId));
				
				// Add this sentence to the summary
				List<String> unitItemList = sentenceUnitItems.get(sentenceNumber);
				for (String unitItemId : unitItemList)
				{
					if (unitItemCountsSummary.containsKey(unitItemId))
					{
						Integer count = unitItemCountsCandidateSummary.get(unitItemId);
						count++;
						unitItemCountsCandidateSummary.put(unitItemId, count);
					}
				}
				
				
				//
				// Evaluate candidate summary and strong concepts
				//
				
				//
				// Evaluate candidate summary and full-text for concept distribution
				//
				
				Double sentenceScore = 0.0;
				
				if (similarityFunction == ESimilarityFunction.COSINE)
				{
					// Cosine similarity
					int numerator = 0;
					int denom1 = 0;
					int denom2 = 0;
					for (String unitItemId : unitItemCountsSourceText.keySet())
					{
						Integer countSourceText  = unitItemCountsSourceText.get(unitItemId);
						Integer countCandidateSummary = unitItemCountsCandidateSummary.get(unitItemId);
						
						denom1 += Math.pow(countSourceText, 2);
						denom2 += Math.pow(countCandidateSummary, 2);
						
						numerator += (countSourceText * countCandidateSummary);
					}
					
					Double denominator = Math.sqrt(denom1 * denom2);
					
					sentenceScore = (numerator * 1.0) / denominator;
				}
				else if (similarityFunction == ESimilarityFunction.DICE)
				{
					// Find Dice's coefficient
					//	Find # of common terms, # of terms in each
					int numUnitItemsSourceText = 0;
					int numUnitItemsCandidateSummary = 0;
					int numUnitItemsCommon = 0;
					for (String unitItemId : unitItemCountsSourceText.keySet())
					{
						Integer countSourceText  = unitItemCountsSourceText.get(unitItemId);
						Integer countCandidateSummary = unitItemCountsCandidateSummary.get(unitItemId);
					
						if (countSourceText > 0)
							numUnitItemsSourceText++;

						if (countCandidateSummary > 0)
							numUnitItemsCandidateSummary++;

						if (countSourceText > 0 && countCandidateSummary > 0)
							numUnitItemsCommon++;
					}
					
					sentenceScore = numUnitItemsCommon * 1.0 / (numUnitItemsSourceText + numUnitItemsCandidateSummary) * 1.0;
				}
				else if (similarityFunction == ESimilarityFunction.EUCLIDEAN)
				{
					// 	Find Euclidean distance between summary and full-text unit item vectors
					for (String unitItemId : unitItemCountsSourceText.keySet())
					{
						Integer countCandidateSummary = unitItemCountsCandidateSummary.get(unitItemId);
						Integer countSourceText  = unitItemCountsSourceText.get(unitItemId);
					
						sentenceScore += Math.pow((countCandidateSummary - countSourceText) * 1.0, 2);
					}
					sentenceScore = Math.sqrt(sentenceScore);
				}
				else if (similarityFunction == ESimilarityFunction.NEWITEMS)
				{
					int numNewUnitItems = 0;
					for (String unitItemId : unitItemCountsSourceText.keySet())
					{
						Integer countCandidateSummary = unitItemCountsCandidateSummary.get(unitItemId);
					
						if (countCandidateSummary > 0)
							numNewUnitItems++;
					}
					
					sentenceScore = numNewUnitItems * 1.0;
				}
				else if (similarityFunction == ESimilarityFunction.UNITFREQUENCY)
				{
					// Method#4 in IR paper
					for (String unitItemId : unitItemCountsSourceText.keySet())
					{
						Integer countSourceText  = unitItemCountsSourceText.get(unitItemId);
						Integer countCandidateSummary = unitItemCountsCandidateSummary.get(unitItemId);
						
						sentenceScore += countCandidateSummary * countSourceText;
					}
				}
				else if (similarityFunction == ESimilarityFunction.VECTORSUBTRACTION)
				{
					// Vector subtraction
					for (String unitItemId : unitItemCountsSourceText.keySet())
					{
						
						Integer countSourceText  = unitItemCountsSourceText.get(unitItemId);
						Integer countCandidateSummary = unitItemCountsCandidateSummary.get(unitItemId);
						
						sentenceScore += Math.abs(countSourceText - countCandidateSummary);
					}
				}
				else
				{
					throw new Exception("No similarity function defined");
				}
				
				//System.out.println("sentenceScore=" + sentenceScore);
				

				if (sentenceScore > bestSentenceScore)
				{
					bestSentenceNumber = sentence.getSentenceNumber();
					bestSentenceScore = sentenceScore;
				}
			}
			
			// Update sentence information of best scoring sentence
			//System.out.println("bestSentenceNumber=" + bestSentenceNumber);
			if (bestSentenceNumber >= 0)
			{
				DocumentSentence sentence = sentenceList.get(bestSentenceNumber);
				sentence.setScore(sentenceScoreIdx * 10000);
			
				// Update summary with the best sentence
				for (String unitItemId : unitItemCountsCandidateSummary.keySet())
					unitItemCountsSummary.put(unitItemId, unitItemCountsCandidateSummary.get(unitItemId));
			}
		}
	}
}
