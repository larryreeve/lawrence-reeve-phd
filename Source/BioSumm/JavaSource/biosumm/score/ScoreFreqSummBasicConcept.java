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



public class ScoreFreqSummBasicConcept 
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
		//int numStdDeviations = Integer.parseInt(parameters.getProperty("stddev", "2"));
		
		// Initialize sentence scores
		for (DocumentSection section : annotatedDocument.getSections())
		{
			for (DocumentSentence sentence : section.getSentences())
			{
				sentence.setScore(0.0);
			}
		}
		
		
		// --------------
		// Step 1 Compute the probability distribution over the words wi appearing in the input, 
		// p(wi) for every i; p(wi) = n/N , where n is the number of times the word appeared in 
		// the input, and N is the total number of content word tokens in the input.
		// --------------
		
		// 	Find total number of concepts and build list of concept frequencies
		int conceptFrequencyTotal = 0;
		Map<String, Integer> conceptFrequencyList = new HashMap<String, Integer>();
		
		for (DocumentSection section : annotatedDocument.getSections())
		{
			for (DocumentSentence sentence : section.getSentences())
			{
				for (DocumentPhrase phrase : sentence.getPhrases())
				{
					for (String conceptName : phrase.getConcepts().keySet())
					{
						DocumentConcept concept = phrase.getConcepts().get(conceptName);
						
						conceptFrequencyTotal++;
						
						String conceptId = concept.getId();
						
						if (conceptFrequencyList.containsKey(conceptId))
						{
							Integer count = conceptFrequencyList.get(conceptId);
							count++;
							conceptFrequencyList.put(conceptId, count);
						}
						else
						{
							conceptFrequencyList.put(conceptId, new Integer(1));
						}
					}
				}
			}
		}
		
		
//		for (ConceptChain chain : conceptChainList)
//		{
//			// Skip filtered chains
//			if (chain.isFiltered())
//				continue;
//			
//			for (Concept conceptEntry : chain.getConceptList())
//			{
//				conceptFrequencyTotal++;
//
//				String conceptId = conceptEntry.getId();
//				if (conceptFrequencyList.containsKey(conceptId))
//				{
//					Integer count = conceptFrequencyList.get(conceptId);
//					count++;
//					conceptFrequencyList.put(conceptId, count);
//				}
//				else
//				{
//					conceptFrequencyList.put(conceptId, new Integer(1));
//				}
//			}
//		}
		

		// 	Compute probability of each concept
		Map<String, Double> conceptProbabilityList = new HashMap<String, Double>();
		for (String conceptId : conceptFrequencyList.keySet())
		{
			Integer count = conceptFrequencyList.get(conceptId);
			
			Double prob = new Double((count * 1.0) / conceptFrequencyTotal);
			
			//System.out.format("cid=" + conceptId + ", count=" + count + ", conceptFrequencyTotal=" + conceptFrequencyTotal + ", prob=%.4f", prob);
			//System.out.println();
			
			conceptProbabilityList.put(conceptId, prob);
		}
		

//		System.out.println("total concepts=" + conceptFrequencyList.size());
//		Double totalProbability = 0.0;
//		for (String conceptId : conceptFrequencyList.keySet())
//		{
//			Integer count = conceptFrequencyList.get(conceptId);
//			Double  prob  = conceptProbabilityList.get(conceptId);
//			
//			totalProbability += prob;
//			
//			System.out.println(conceptId + ": count=" + count + ", probability=" + String.format("%.6f", prob));
//		}
//		System.out.println("totalProbability=" + String.format("%.6f", totalProbability));

		

		// --------------
		// Step 2 For each sentence Sj in the input, assign a weight equal to the average 
		// probability of the words in the sentence, i.e. 
		//	weight(Sj) = Sum(wi in Sj) p(wi) / |{wi | wi element in Sj}|
		// --------------
		
		// Get number of sentences in text
		int numSentences = 0;
		for (DocumentSection section : annotatedDocument.getSections())
		{
			for (DocumentSentence sentence : section.getSentences())
			{
				if (sentence.getSentenceNumber() > numSentences)
					numSentences = sentence.getSentenceNumber();
			}
		}
		
		// Allocate list for scores
		double[] sentenceScores = new double[numSentences+1];
		
		
		// Score all sentences
		for (int numSentencesScored=0; numSentencesScored < numSentences; numSentencesScored++)
		{
			// Initialize sentence scores
			for (int idx=0; idx < sentenceScores.length; idx++)
				sentenceScores[idx] = 0.0;
			
			// Calculate scores for each sentence
			for (DocumentSection section : annotatedDocument.getSections())
			{
				for (DocumentSentence sentence : section.getSentences())
				{
					// Skip already scored sentences
					if (sentence.getScore() > 0.0)
						continue;
		
					// Get concept frequencies in sentence
					Map<String, Integer> sentenceConceptFrequencyList = new HashMap<String, Integer>();
					for (DocumentPhrase phrase : sentence.getPhrases())
					{
						for (DocumentConcept phraseConcept : phrase.getConcepts().values())
						{
							String conceptId = phraseConcept.getId();
							
							if (sentenceConceptFrequencyList.containsKey(conceptId))
							{
								Integer count = sentenceConceptFrequencyList.get(conceptId);
								count++;
								sentenceConceptFrequencyList.put(conceptId, count);
							}
							else
							{
								sentenceConceptFrequencyList.put(conceptId, new Integer(1));
							}
						}
					}

					//	Get average probability for each term in sentence
					Map<String, Double> sentenceConceptProbabilityList = new HashMap<String, Double>();
					//System.out.println("sentenceConceptFrequencyList count=" + sentenceConceptFrequencyList.size());
					for (String conceptId : sentenceConceptFrequencyList.keySet())
					{
						if (conceptProbabilityList.containsKey(conceptId))
						{
							Integer conceptCount = sentenceConceptFrequencyList.get(conceptId);
						
							Double conceptProbability = conceptProbabilityList.get(conceptId);
						
							Double sentenceConceptProbability = new Double(conceptProbability / conceptCount);
							//System.out.println("sentenceConceptProbability=" + sentenceConceptProbability);
						
							sentenceConceptProbabilityList.put(conceptId, sentenceConceptProbability);
						}
						else
						{
							//System.out.println("sentenceConceptProbability2=0");
							sentenceConceptProbabilityList.put(conceptId, new Double(0.0));
						}
					}
					
					// Calculate sentence score
					for (String conceptId : sentenceConceptProbabilityList.keySet())
					{
						sentenceScores[sentence.getSentenceNumber()] += sentenceConceptProbabilityList.get(conceptId);
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
							for (DocumentPhrase phrase : sentence.getPhrases())
							{
								for (DocumentConcept phraseConcept : phrase.getConcepts().values())
								{
									String conceptId = phraseConcept.getId();

									if (conceptProbabilityList.containsKey(conceptId))
									{
										Double prob = conceptProbabilityList.get(conceptId);
								
										prob *= prob;
								
										conceptProbabilityList.put(conceptId, prob);
									}
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
		
//		for (DocumentSection section : annotatedDocument.getSections())
//		{
//			for (DocumentSentence sentence : section.getSentences())
//			{
//				System.out.println("sentence#" + sentence.getSentenceNumber() + ": " + sentence.getScore());
//			}
//		}

	}
}
