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



public class ScoreFreqSumBasic 
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

		// Initialize
		Map<Integer, ArrayList<String>> sentenceUnitItems = new HashMap<Integer, ArrayList<String>>();
		
		int totalSentenceCount = 0;

		for (DocumentSection section : annotatedDocument.getSections())
		{
			for (DocumentSentence sentence : section.getSentences())
			{
				// Initialize sentence score
				sentence.setScore(0.0);
				
				ArrayList<String> unitItemList = new ArrayList<String>();

				
				// Find sentence concepts
				if (paramUseConcepts)
				{
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
				}
				
				sentenceUnitItems.put(new Integer(sentence.getSentenceNumber()), unitItemList);
				
				// Get number of sentences in text
				if (sentence.getSentenceNumber() > totalSentenceCount)
					totalSentenceCount = sentence.getSentenceNumber();
			}
		}
		
		
		// --------------
		// Step 1 Compute the probability distribution over the words wi appearing in the input, 
		// p(wi) for every i; p(wi) = n/N , where n is the number of times the word appeared in 
		// the input, and N is the total number of content word tokens in the input.
		// --------------
		
		// 	Find total number of unit items and build list of unit item frequencies
		int unitItemFrequencyTotal = 0;
		Map<String, Integer> unitItemFrequencyList = new HashMap<String, Integer>();

		for (Integer sentenceNumber : sentenceUnitItems.keySet())
		{
			List<String> unitItemList = sentenceUnitItems.get(sentenceNumber);
			
			for (String unitItem : unitItemList)
			{
				unitItemFrequencyTotal++;

				if (unitItemFrequencyList.containsKey(unitItem))
				{
					Integer count = unitItemFrequencyList.get(unitItem);
					count++;
					unitItemFrequencyList.put(unitItem, count);
				}
				else
				{
					unitItemFrequencyList.put(unitItem, new Integer(1));
				}
			}
		}
		

		// 	Compute probability of each term
		Map<String, Double> unitItemProbabilityList = new HashMap<String, Double>();
		for (String term : unitItemFrequencyList.keySet())
		{
			Integer count = unitItemFrequencyList.get(term);
			
			Double prob = new Double((count * 1.0) / unitItemFrequencyTotal);
			
			//System.out.format("term=" + term + ", count=" + count + ", termFrequencyTotal=" + termFrequencyTotal + ", prob=%.4f", prob);
			//System.out.println();
			
			unitItemProbabilityList.put(term, prob);
		}
		

//		System.out.println("total terms=" + termFrequencyList.size());
//		for (String term : termFrequencyList.keySet())
//		{
//			Integer count = termFrequencyList.get(term);
//			Double  prob  = termProbabilityList.get(term);
//			
//			System.out.println("term='" + term + "': count=" + count + ", prob=%.4f" + String.format("%.04f", prob));
//		}

		

		// --------------
		// Step 2 For each sentence Sj in the input, assign a weight equal to the average 
		// probability of the words in the sentence, i.e. 
		//	weight(Sj) = Sum(wi in Sj) p(wi) / |{wi | wi element in Sj}|
		// --------------
		
		// Allocate list for scores
		double[] sentenceScores = new double[totalSentenceCount+1];
		
		
		// Score all sentences
		for (int numSentencesScored=0; numSentencesScored < totalSentenceCount; numSentencesScored++)
		{
			// Initialize sentence scores
			for (int idx=0; idx < sentenceScores.length; idx++)
				sentenceScores[idx] = 0.0;
			
			// Calculate scores for each sentence
			for (DocumentSection section : annotatedDocument.getSections())
			{
				for (DocumentSentence sentence : section.getSentences())
				{
					// Skip sentences already scored
					if (sentence.getScore() > 0.0)
						continue;
		
					// Get term frequencies in sentence
					Map<String, Integer> sentenceTermFrequencyList = new HashMap<String, Integer>();
					
					List<String> unitItemList = sentenceUnitItems.get(new Integer(sentence.getSentenceNumber()));
					
					for (String unitItem : unitItemList)
					{
						if (sentenceTermFrequencyList.containsKey(unitItem))
						{
							Integer count = sentenceTermFrequencyList.get(unitItem);
							count++;
							sentenceTermFrequencyList.put(unitItem, count);
						}
						else
						{
							sentenceTermFrequencyList.put(unitItem, new Integer(1));
						}
					}
					

					// Get average probability for each term in sentence
					Map<String, Double> sentenceTermProbabilityList = new HashMap<String, Double>();
					for (String term : sentenceTermFrequencyList.keySet())
					{
						if (unitItemProbabilityList.containsKey(term))
						{
							Integer unitItemCount = sentenceTermFrequencyList.get(term);
						
							Double unitItemProbability = unitItemProbabilityList.get(term);
						
							Double sentenceUnitItemProbability = new Double(unitItemProbability / unitItemCount);
						
							sentenceTermProbabilityList.put(term, sentenceUnitItemProbability);
						}
						else
						{
							sentenceTermProbabilityList.put(term, new Double(0.0));
						}
					}
					
					// Calculate sentence score
					for (String term : sentenceTermProbabilityList.keySet())
					{
						sentenceScores[sentence.getSentenceNumber()] += sentenceTermProbabilityList.get(term);
					}
				}
			}
			
			
			// --------------
			// Step 3 Pick the best scoring sentence that contains the highest probability word.
			// --------------
			int highScoreSentence = -1;
			double highScore = 0.0;
			
			for (int idx=0; idx < sentenceScores.length; idx++)
			{
				if (sentenceScores[idx] > highScore)
				{
					highScore = sentenceScores[idx];
					highScoreSentence = idx;
				}
			}
			
			// Find the sentence number and set the score
			if (highScoreSentence >= 0)
			{
				for (DocumentSection section : annotatedDocument.getSections())
				{
					for (DocumentSentence sentence : section.getSentences())
					{
						if (sentence.getSentenceNumber() == highScoreSentence)
						{
							sentence.setScore(highScore);
							
							// --------------
							// Step 4 For each word wi in the sentence chosen at step 3, update their probability
							// pnew(wi) = Pold(wi) x Pold(wi)
							// --------------
							List<String> unitItemList = sentenceUnitItems.get(new Integer(sentence.getSentenceNumber()));
							
							for (String unitItem : unitItemList)
							{
								if (unitItemProbabilityList.containsKey(unitItem))
								{
									Double prob = unitItemProbabilityList.get(unitItem);
							
									prob *= prob;
							
									unitItemProbabilityList.put(unitItem, prob);
								}
							}
						}
					}
				}
			}

			
			// --------------
			// Step 5 If the desired summary length has not been reached, go back to Step 2.
			// --------------
		}
	}
}
