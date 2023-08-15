/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biosumm.score;

import java.util.*;

import biocommon.document.*;
import biocommon.util.words.WordSplitter;
import biosumm.chain.*;



public class ScoreFreqDist 
	implements IScorer
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT    = biocommon.copyright.Copyright.COPYRIGHT;
    
	
    private enum ESimilarityFunction
	{
		COSINE,
		DICE,
		EUCLIDEAN,
		UNITFREQUENCY,
		VECTORSUBTRACTION
	}
	
    
    public void score(List<ConceptChain> 	conceptChainList,
					  Document 				annotatedDocument,
					  Properties 			parameters)
		throws Exception
	{
		// Get parameters
		Boolean paramUseConcepts = Boolean.parseBoolean(parameters.getProperty("useconcepts", "false"));
		String  paramSimilarityFunction = parameters.getProperty("similarityfunction", "dice");
		
		// Determine similarity function to use
		ESimilarityFunction similarityFunction = ESimilarityFunction.DICE;
		if (paramSimilarityFunction.equalsIgnoreCase("cosine"))
			similarityFunction = ESimilarityFunction.COSINE;
		else if (paramSimilarityFunction.equalsIgnoreCase("dice"))
			similarityFunction = ESimilarityFunction.DICE;
		else if (paramSimilarityFunction.equalsIgnoreCase("euclidean"))
			similarityFunction = ESimilarityFunction.EUCLIDEAN;
		else if (paramSimilarityFunction.equalsIgnoreCase("unitfrequency"))
			similarityFunction = ESimilarityFunction.UNITFREQUENCY;
		else if (paramSimilarityFunction.equalsIgnoreCase("vectorsubtraction"))
			similarityFunction = ESimilarityFunction.VECTORSUBTRACTION;
		
		
		System.out.println("Starting summarization, use concepts: " + paramUseConcepts + ", similarity function: " + similarityFunction + "...");
		

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

		
		// Get list of unit items in each sentence
		Map<Integer, ArrayList<String>> sentenceUnitItems = new HashMap<Integer, ArrayList<String>>();
		for (Integer sentenceNumber : sentenceList.keySet())
		{
			DocumentSentence sentence = sentenceList.get(sentenceNumber);
			
			ArrayList<String> unitItemList = null;
			
			// Find sentence concepts
			if (paramUseConcepts)
			{
				unitItemList = new ArrayList<String>();
				
				for (DocumentPhrase phrase : sentence.getPhrases())
				{
					for (String conceptName : phrase.getConcepts().keySet())
					{
						DocumentConcept concept = phrase.getConcepts().get(conceptName);
					
						String conceptId = concept.getId();
					
						unitItemList.add(conceptId);
					}
				}
			}
			// Find sentence terms
			else
			{
				unitItemList = (ArrayList<String>) WordSplitter.splitWithStopWords(sentence.getSentenceText().toLowerCase());
//				for (String word : unitItemList)
//					System.out.println(word);
			}
			
			sentenceUnitItems.put(new Integer(sentence.getSentenceNumber()), unitItemList);
		}
		

		// Get frequency counts of units in full-source text
		Map<String, Integer> unitItemCountsSourceText = new HashMap<String, Integer>();
		for (Integer sentenceNumber : sentenceUnitItems.keySet())
		{
			List<String> unitItemList = sentenceUnitItems.get(sentenceNumber);
			
			for (String unitItem : unitItemList)
			{
				if (unitItemCountsSourceText.containsKey(unitItem))
				{
					Integer count = unitItemCountsSourceText.get(unitItem);
					count++;
					unitItemCountsSourceText.put(unitItem, count);
				}
				else
				{
					unitItemCountsSourceText.put(unitItem, new Integer(1));
				}
			}
		}
		
		
		//
		// Score sentences
		//
		
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
			//bestSentenceScore = Double.MAX_VALUE;
			bestSentenceScore = 0.0;
			bestSentenceNumber = -1;
			
			for (Integer sentenceNumber : sentenceList.keySet())
			{
				DocumentSentence sentence = sentenceList.get(sentenceNumber);
				
				// Skip sentences already scored
				if (sentence.getScore() > 0.0)
					continue;
				
				// Initialize unit item counts of candidate summary to the current summary
				unitItemCountsCandidateSummary.clear();
				for (String unitItemId : unitItemCountsSummary.keySet())
					unitItemCountsCandidateSummary.put(unitItemId, unitItemCountsSummary.get(unitItemId));
				
				// Add this sentence to the summary
				List<String> unitItemList = sentenceUnitItems.get(sentenceNumber);
				for (String unitItemId : unitItemList)
				{
					Integer count = unitItemCountsCandidateSummary.get(unitItemId);
					count++;
					unitItemCountsCandidateSummary.put(unitItemId, count);
				}
				
				
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
				sentence.setScore(sentenceScoreIdx);
			
				// Update summary with the best sentence
				for (String unitItemId : unitItemCountsCandidateSummary.keySet())
					unitItemCountsSummary.put(unitItemId, unitItemCountsCandidateSummary.get(unitItemId));
			}
		}
		
		//System.out.println("source size= " + sentenceList.size() + ", 20% summary size = " + ((int) sentenceList.size() * 0.20));
	}
}
