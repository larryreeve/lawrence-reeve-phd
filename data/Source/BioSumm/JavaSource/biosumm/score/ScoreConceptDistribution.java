/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biosumm.score;

import java.util.*;

import biocommon.document.Document;
import biocommon.document.DocumentConcept;
import biocommon.document.DocumentSection;
import biocommon.document.DocumentSentence;
import biocommon.document.DocumentPhrase;
import biosumm.chain.Concept;
import biosumm.chain.ConceptChain;



public class ScoreConceptDistribution 
	implements IScorer
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT    = biocommon.copyright.Copyright.COPYRIGHT;
    
	
    public void score(List<ConceptChain> 	conceptChainList,
			  		  Document 				annotatedDocument,
			  		  Properties 			parameters)
		throws Exception
	{
		// Initialize 
		int numSentences = 0;
		for (DocumentSection section : annotatedDocument.getSections())
		{
			for (DocumentSentence sentence : section.getSentences())
			{
				// Initialize sentence score
				sentence.setScore(0.0);
				
				// Get number of sentences in text
				if (sentence.getSentenceNumber() > numSentences)
					numSentences = sentence.getSentenceNumber();
			}
		}

		

		// --------------
		// Step 1: 
		//	Compute frequency probability of each concept in the source text 
		// --------------

		// 	Find total number of concepts and build list of concept frequencies
		int conceptFrequencyTotal = 0;
		Map<String, Integer> conceptFrequencyList = new HashMap<String, Integer>();
		
		for (ConceptChain chain : conceptChainList)
		{
			// Skip filtered chains
			if (chain.isFiltered())
				continue;
			
			for (Concept conceptEntry : chain.getConceptList())
			{
				conceptFrequencyTotal++;

				String conceptId = conceptEntry.getId().toLowerCase();
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
		
		// 	Compute probability of each concept in the source text
		Map<String, Double> conceptProbabilityList = new HashMap<String, Double>();
		for (String conceptId : conceptFrequencyList.keySet())
		{
			Integer count = conceptFrequencyList.get(conceptId);
			
			Double prob = new Double((count * 1.0) / conceptFrequencyTotal);
			
			//System.out.format("cid=" + conceptId + ", count=" + count + ", conceptFrequencyTotal=" + conceptFrequencyTotal + ", prob=%.4f", prob);
			//System.out.println();
			
			conceptProbabilityList.put(conceptId, prob);
		}
		

//		System.out.println("total concepts=" + conceptFrequency.size());
//		for (String conceptId : conceptFrequency.keySet())
//		{
//			Integer count = conceptFrequency.get(conceptId);
//			Double  prob  = conceptProbability.get(conceptId);
//			
//			System.out.println(conceptId + ": count=" + count + ", probability=" + String.format("%.2f", prob));
//		}

		

		// --------------
		// Step 2: 
		//	Score similarity between source text vector and the 
		//	the summary + each sentence
		// --------------
		
		
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
					if (sentence.getScore() > 0.0)
						continue;
		
					// Get concept frequencies in sentence
					Map<String, Integer> sentenceConceptFrequencyList = new HashMap<String, Integer>();
					for (DocumentPhrase phrase : sentence.getPhrases())
					{
						for (DocumentConcept phraseConcept : phrase.getConcepts().values())
						{
							String conceptId = phraseConcept.getId().toLowerCase();
							
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

					// Get probabilities for each concept in sentence
					Map<String, Double> sentenceConceptProbabilityList = new HashMap<String, Double>();
					for (String conceptId : sentenceConceptFrequencyList.keySet())
					{
						if (conceptProbabilityList.containsKey(conceptId))
						{
							Integer conceptCount = sentenceConceptFrequencyList.get(conceptId);
						
							Double conceptProbability = conceptProbabilityList.get(conceptId);
						
							Double sentenceConceptProbability = new Double(conceptProbability / conceptCount);
						
							sentenceConceptProbabilityList.put(conceptId, sentenceConceptProbability);
						}
						else
						{
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
			// Step 3: 
			//	Add sentence with the highest score to the summary 
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
									String conceptId = phraseConcept.getId().toLowerCase();

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
			// Step 4 
			//	If the desired summary length has not been reached, go back to Step 2.
			// --------------
		}
	}
}
