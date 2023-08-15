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



public class ScoreFreqDistMembership 
	implements IScorer
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT = biocommon.copyright.Copyright.COPYRIGHT;
    
	
    public void score(List<ConceptChain> 	conceptChainList,
					  Document 				annotatedDocument,
					  Properties 			parameters)
		throws Exception
	{
		// Get parameters
		Boolean paramUseConcepts = Boolean.parseBoolean(parameters.getProperty("useconcepts", "false"));
		

		// Build list of sentences: initialize sentence scores, determine # of sentences
		int totalSentenceCount = 0;
		Map<Integer, DocumentSentence> sentenceList = new HashMap<Integer, DocumentSentence>();
		for (DocumentSection section : annotatedDocument.getSections())
		{
			for (DocumentSentence sentence : section.getSentences())
			{
				sentence.setScore(0.0);
				totalSentenceCount++;
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
//		Double sqrtNumberOfUnitItems = Math.sqrt(unitItemCountsSourceText.size());
		
		
		//	Build concept model of full-source text
		Map<String, Double> unitItemModelSourceText = new HashMap<String, Double>();
		for (String unitItemId : unitItemCountsSourceText.keySet())
		{
//			if (paramUseConcepts)
//			{
				Integer count = unitItemCountsSourceText.get(unitItemId);
				if (count > 0)
					unitItemModelSourceText.put(unitItemId, 1.0);
				else
					unitItemModelSourceText.put(unitItemId, 0.0);
//			}
//			else
//			{
//				unitItemModelSourceText.put(unitItemId, new Double(unitItemCountsSourceText.get(unitItemId)));
//			}
		}
		
		
		
		//
		// Score sentences
		//
		
		// Pre-compute cosine model denominator
//		Double cosineSourceTextDenominator = 1.0;
//		for (String unitItem : unitItemModelSourceText.keySet())
//		{
//			cosineFullTextDenominator += Math.pow(unitItemModelSourceText.get(unitItem), 2.0);
//		}
//		cosineFullTextDenominator = Math.sqrt(cosineFullTextDenominator);
//		if (!paramUseConcepts)
//			cosineSourceTextDenominator = Math.sqrt(unitItemCountsSourceText);
		
		// Duplicate and initialize model summary entries from source text
		Map<String, Double> unitItemModelSummary = new HashMap<String, Double>();
		for (String unitItemId : unitItemModelSourceText.keySet())
			unitItemModelSummary.put(unitItemId, new Double(0));
		
		Map<String, Integer> unitItemCountsSummary = new HashMap<String, Integer>();
		for (String unitItem : unitItemModelSourceText.keySet())
			unitItemCountsSummary.put(unitItem, new Integer(0));
		
		// Score each sentence
		Integer bestSentenceNumber = new Integer(-1);
		Double  bestSentenceScore = 0.0;
		Map<String, Integer> unitItemCountsCandidateSummary = new HashMap<String, Integer>();
		Map<String, Double>  unitItemModelCandidateSummary  = new HashMap<String, Double>();
		
		for (int sentenceScoreIdx=totalSentenceCount; sentenceScoreIdx > 0; sentenceScoreIdx--)
		{
			bestSentenceScore = 0.0;
			
			for (Integer sentenceNumber : sentenceList.keySet())
			{
				DocumentSentence sentence = sentenceList.get(sentenceNumber);
				
				// Skip sentences already scored
				if (sentence.getScore() > 0.0)
					continue;
				
				// Initialize unit item counts to the current summary model
				unitItemCountsCandidateSummary.clear();
				for (String unitItem : unitItemCountsSummary.keySet())
					unitItemCountsCandidateSummary.put(unitItem, unitItemCountsSummary.get(unitItem));
				
				// Add this sentence to the summary
				List<String> unitItemList = sentenceUnitItems.get(sentenceNumber);
				for (String unitItemId : unitItemList)
				{
					Integer count = unitItemCountsCandidateSummary.get(unitItemId);
					count++;
					unitItemCountsCandidateSummary.put(unitItemId, count);
				}
				
				// Set up candidate summary model based on new sentence added
				unitItemModelCandidateSummary.clear();
				for (String unitItem : unitItemCountsCandidateSummary.keySet())
				{
//					if (paramUseConcepts)
//					{
						Integer count = unitItemCountsCandidateSummary.get(unitItem);
						if (count > 0)
							unitItemModelCandidateSummary.put(unitItem, 1.0);
						else
							unitItemModelCandidateSummary.put(unitItem, 0.0);
//					}
//					else
//					{
//						unitItemModelCandidateSummary.put(unitItem, new Double(unitItemCountsCandidateSummary.get(unitItem)));
//					}
					
//					Integer count = unitItemCountsCandidateSummary.get(unitItem);
//					if (count > 0)
//						unitItemModelCandidateSummary.put(unitItem, 1.0);
//					else
//						unitItemModelCandidateSummary.put(unitItem, 0.0);
//					//conceptModelCandidateSummary.put(conceptId, (conceptCountsCandidateSummary.get(conceptId) * 1.0) / normalizationFactor);
				}

//				for (String unitItem : conceptCountsCandidateSummary.keySet())
//				{
//					Integer count = unitItemCountsCandidateSummary.get(unitItem);
//					Double modelValue = unitItemModelCandidateSummary.get(unitItem);
//					if (count > 0)
//						System.out.println("--" + count + "," + modelValue);
//				}

				
				//
				// Evaluate candidate summary and full-text for concept distribution
				//
				
				// Calculate cosine candidate summary denominator
//				Double cosineCandidateSummaryDenominator = 0.0;
//				for (String unitItem : unitItemModelCandidateSummary.keySet())
//				{
//					cosineCandidateSummaryDenominator += Math.pow(unitItemModelCandidateSummary.get(unitItem), 2.0);
//				}
//				cosineCandidateSummaryDenominator = Math.sqrt(cosineCandidateSummaryDenominator);
				
				
//				// Calculate cosine numerator
//				Double cosineNumerator = 0.0;
//				for (String unitItem : unitItemModelSourceText.keySet())
//				{
//					cosineNumerator += (unitItemModelSourceText.get(unitItem) * unitItemModelCandidateSummary.get(unitItem));
//				}
				
				
//				
//				// Calculate cosine value
//				Double cosineValue = cosineNumerator / (cosineCandidateSummaryDenominator * cosineSourceTextDenominator);
				
				Double cosineValue = 0.0;
				for (String unitItemId : unitItemModelSourceText.keySet())
				{
					Double weightSourceText = 0.0;
					Double weightCandidateSummary  = 0.0;
					
					//if (unitItemModelSourceText.containsKey(unitItemId))
						weightSourceText = unitItemModelSourceText.get(unitItemId);

					if (unitItemModelCandidateSummary.containsKey(unitItemId))
						weightCandidateSummary = unitItemModelCandidateSummary.get(unitItemId);
					
					cosineValue += (weightSourceText * weightCandidateSummary);
				}
				
//				if (!paramUseConcepts)
//					cosineValue /= sqrtNumberOfUnitItems; 
				

				
				//System.out.println("cosineValue=" + cosineValue);
				
				if (cosineValue > bestSentenceScore)
				{
					bestSentenceNumber = sentence.getSentenceNumber();
					bestSentenceScore = cosineValue;
				}
			}
			
			// Update sentence information of best scoring sentence
			//System.out.println("bestSentenceNumber=" + bestSentenceNumber);
			DocumentSentence sentence = sentenceList.get(bestSentenceNumber);
			sentence.setScore(sentenceScoreIdx);
			
			// Update summary with the best sentence
			for (String unitItemId : unitItemCountsCandidateSummary.keySet())
				unitItemCountsSummary.put(unitItemId, unitItemCountsSummary.get(unitItemId) + unitItemCountsCandidateSummary.get(unitItemId));
			
			for (String unitItemId : unitItemCountsCandidateSummary.keySet())
			{
//				if (paramUseConcepts)
//				{
//					Integer count = unitItemCountsCandidateSummary.get(unitItem);
//					if (count > 0)
					if (!unitItemModelSummary.containsKey(unitItemId))
						unitItemModelSummary.put(unitItemId, 1.0);
//					else
//						unitItemModelSummary.put(unitItem, 0.0);
//				}
//				else
//				{
//					if (unitItemModelCandidateSummary.containsKey(unitItemId))
//					{
//						Double count = unitItemModelCandidateSummary.get(unitItemId);
//						count++;
//						unitItemModelCandidateSummary.put(unitItemId, unitItemModelCandidateSummary.get(unitItemId) + count);
//					}
//					else
//					{
//						unitItemModelCandidateSummary.put(unitItemId, new Double(1.0));
//					}
//				}
				
				//conceptModelSummary.put(conceptId, (conceptCountsCandidateSummary.get(conceptId) * 1.0) / normalizationFactor);
			}
		}

		// Display sentence scores
//		for (DocumentSection section : annotatedDocument.getSections())
//		{
//			for (DocumentSentence sentence : section.getSentences())
//			{
//				System.out.println("Sentence#" + sentence.getSentenceNumber() + ": " + sentence.getScore());
//			}
//		}
	}
}
