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



public class ScoreLM 
	implements IScorer
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT = biocommon.copyright.Copyright.COPYRIGHT;
    
	private enum EInformationContentMethod
	{
		IDF,
		TFIDF
	}

	private enum EMixtureMethod
	{
		ADDITION,
		MULTIPLICATION,
		MIXTURE
	}
	

	public void score(List<ConceptChain> 	conceptChainList,
					  Document 				annotatedDocument,
					  Properties 			parameters)
		throws Exception
	{
		System.out.println("***START***");
		
		//System.out.println(parameters);
		
		// Get parameters
		//	Use concepts or terms as unit item
		Boolean paramUseConcepts = Boolean.parseBoolean(parameters.getProperty("useconcepts", "false"));

		//	Only use information content scores
		Boolean paramUseInfoContentOnly = Boolean.parseBoolean(parameters.getProperty("infocontentonly", "false"));

		// 	Lamda for Information Content/Language Model mixture
		Double paramLamdaICLM = new Double(0.50);
		String propertyLamdaICLM = parameters.getProperty("lamdaiclm", ".50");
		paramLamdaICLM = Double.parseDouble(propertyLamdaICLM);

		// 	Lamda for Language Model mixture
		Double paramLamdaLM = new Double(0.50);
		String propertyLamdaLM = parameters.getProperty("lamdalm", ".50");
		paramLamdaLM = Double.parseDouble(propertyLamdaLM);
		
		// Information content scoring method
		EInformationContentMethod paramInformationContentMethod = EInformationContentMethod.IDF;
		String popertyInformationWeightMethod = parameters.getProperty("infocontent", "idf");
		if (popertyInformationWeightMethod.equalsIgnoreCase("idf"))
			paramInformationContentMethod = EInformationContentMethod.IDF;
		else if (popertyInformationWeightMethod.equalsIgnoreCase("tfidf"))
			paramInformationContentMethod = EInformationContentMethod.TFIDF;
		
		// Mixture method for Information Content/Language Model mixture
		EMixtureMethod paramMixtureMethod = EMixtureMethod.MIXTURE;
		String popertyMixtureMethod = parameters.getProperty("mixture", "mixture");
		if (popertyMixtureMethod.equalsIgnoreCase("mixture"))
			paramMixtureMethod = EMixtureMethod.MIXTURE;
		else if (popertyMixtureMethod.equalsIgnoreCase("multiplication"))
			paramMixtureMethod = EMixtureMethod.MULTIPLICATION;
		else if (popertyMixtureMethod.equalsIgnoreCase("addition"))
			paramMixtureMethod = EMixtureMethod.ADDITION;
		
		System.out.println("Parameter summary:");
		System.out.println("\tparamUseConcepts: " + paramUseConcepts);
		if (paramUseInfoContentOnly)
		{
			System.out.println("\tUsing information content scores only");
		}
		else
		{
			System.out.println("\tparamInformationContentMethod: " + paramInformationContentMethod);
			System.out.println("\tparamLamda-LM: " + paramLamdaLM);
			System.out.println("\tparamLamda-ICLM: " + paramLamdaICLM);
			System.out.println("\tparamMixtureMethod: " + paramMixtureMethod);
		}
		
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
		
		// Get unit items in each sentence
		Map<Integer, ArrayList<String>> sourceSentenceUnitItems = new HashMap<Integer, ArrayList<String>>();
		Map<Integer, HashMap<String,Integer>> sourceSentenceUnitItemsFrequencies = new HashMap<Integer, HashMap<String, Integer>>();
		for (Integer sentenceNumber : sentenceList.keySet())
		{
			DocumentSentence sentence = sentenceList.get(sentenceNumber);
			
			ArrayList<String> unitItemList = null;
			HashMap<String, Integer> unitItemFrequencies = new HashMap<String, Integer>();
			
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
						
						if (unitItemFrequencies.containsKey(conceptId))
						{
							Integer count = unitItemFrequencies.get(conceptId);
							count++;
							unitItemFrequencies.put(conceptId, count);
						}
						else
						{
							unitItemFrequencies.put(conceptId, new Integer(1));
						}
					}
				}
			}
			// Find sentence terms
			else
			{
				unitItemList = (ArrayList<String>) WordSplitter.splitWithStopWords(sentence.getSentenceText().toLowerCase());

				for (String word : unitItemList)
				{
					if (unitItemFrequencies.containsKey(word))
					{
						Integer count = unitItemFrequencies.get(word);
						count++;
						unitItemFrequencies.put(word, count);
					}
					else
					{
						unitItemFrequencies.put(word, new Integer(1));
					}
				}
			}
			
			sourceSentenceUnitItems.put(new Integer(sentence.getSentenceNumber()), unitItemList);
			sourceSentenceUnitItemsFrequencies.put(new Integer(sentence.getSentenceNumber()), unitItemFrequencies);
		}
		
		// Display sentence and collected stats
		/*
		for (Integer sentenceNumber : sentenceList.keySet())
		{
			ArrayList<String> unitItemList = sourceSentenceUnitItems.get(sentenceNumber);
			HashMap<String, Integer> unitItemFrequencies = sourceSentenceUnitItemsFrequencies.get(sentenceNumber);
			
			System.out.println("sentence #" + sentenceNumber);
			System.out.println("\t# of unitItems: " + unitItemList.size());
			for (String unitItem : unitItemList)
				System.out.println("\t\t" + unitItem);
			System.out.println("\tUnitItem Counts: " + unitItemFrequencies.size());
			for (String unitItem : unitItemFrequencies.keySet())
				System.out.println("\t\t" + unitItem + " => " + unitItemFrequencies.get(unitItem));
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
		}
		*/
		
		//	Get source text unit items frequency
		Map<String, Integer> sourceUnitItemFrequencies = new HashMap<String, Integer>();
		for (Integer sentenceNumber : sentenceList.keySet())
		{
			HashMap<String, Integer> sentenceUnitItemFrequencies = sourceSentenceUnitItemsFrequencies.get(sentenceNumber);
			
			for (String unitItem : sentenceUnitItemFrequencies.keySet())
			{
				if (sourceUnitItemFrequencies.containsKey(unitItem))
				{
					Integer count = sourceUnitItemFrequencies.get(unitItem);
					count += sentenceUnitItemFrequencies.get(unitItem);
					sourceUnitItemFrequencies.put(unitItem, count);
				}
				else
				{
					sourceUnitItemFrequencies.put(unitItem, sentenceUnitItemFrequencies.get(unitItem));
				}
			}
		}
		
		// Calculate number of sentences in source text
		int totalNumSentencesInSource = sentenceList.size();
		

		// 1) Determine length of each sentence (total # of unit items in each sentence)
		// 2) Calculate max length of a sentence (based on # of unit items in each sentence)
		int sourceMaxSentenceLength = 0;
		Map<Integer, Integer> sourceSentenceLengths = new HashMap<Integer, Integer>(); 
		for (Integer sentenceNumber : sentenceList.keySet())
		{
			int sentenceLength = 0;

			HashMap<String, Integer> sentenceUnitItemFrequencies = sourceSentenceUnitItemsFrequencies.get(sentenceNumber);
			
			for (String unitItem : sentenceUnitItemFrequencies.keySet())
				sentenceLength += sentenceUnitItemFrequencies.get(unitItem);

			sourceSentenceLengths.put(sentenceNumber, sentenceLength);
			
			if (sentenceLength > sourceMaxSentenceLength)
				sourceMaxSentenceLength = sentenceLength;
		}

		// Calculate total number of unit items in the source text
		int totalNumUnitItemsInSource = 0;
		for (Integer sentenceNumber : sentenceList.keySet())
		{
			totalNumUnitItemsInSource += sourceSentenceLengths.get(sentenceNumber);
		}


		//	Calculate source text unit item IDF values
		Map<String, Double> sourceIDF = new HashMap<String, Double>();
		for (String unitItem : sourceUnitItemFrequencies.keySet())
		{
			// Find # of sentences unit item appears in
			int totalNumSentencesUnitItemAppearsIn = 0;
			for (Integer sentenceNumber : sentenceList.keySet())
			{
				HashMap<String, Integer> sentenceUnitItemFrequencies = sourceSentenceUnitItemsFrequencies.get(sentenceNumber);
				
				if (sentenceUnitItemFrequencies.containsKey(unitItem))
					totalNumSentencesUnitItemAppearsIn++;
			}

			//System.out.println("unitItemIDFcalc: " + unitItem + ", SentenceCount=" + unitItemSentenceCount + ", totalNumSourceSentences=" + totalNumSourceSentences);
			Double unitItemIDF = Math.log((double) totalNumSentencesInSource / (double) totalNumSentencesUnitItemAppearsIn);
			
			sourceIDF.put(unitItem, unitItemIDF);
		}

		/*
		System.out.println("\t# of unitItems: " + unitItemCountsSourceText.size());
		for (String unitItem : unitItemCountsSourceText.keySet())
		{
			System.out.println("\t" + unitItem + "==> " + unitItemCountsSourceText.get(unitItem) + ", IDF=" + idfSourceText.get(unitItem));
		}
		System.out.println("");
		System.out.println("***END***");
		*/

		
		// Score information content of source text sentences
		Map<Integer, Double> sourceInfoContentScores = new HashMap<Integer, Double>();
		for (Integer sentenceNumber : sentenceList.keySet())
		{
			double sentenceScore = 0.0;
			
			HashMap<String, Integer> sentenceUnitItemFrequencies = sourceSentenceUnitItemsFrequencies.get(sentenceNumber);
			
			int mostFrequentUnitItemCount = 0;
			if (EInformationContentMethod.TFIDF == paramInformationContentMethod)
			{
				for (String unitItemSentence : sentenceUnitItemFrequencies.keySet())
				{
					if (sentenceUnitItemFrequencies.get(unitItemSentence) > mostFrequentUnitItemCount)
						mostFrequentUnitItemCount = sentenceUnitItemFrequencies.get(unitItemSentence);
				}
			}
			
			for (String unitItem : sentenceUnitItemFrequencies.keySet())
			{
				if (EInformationContentMethod.IDF == paramInformationContentMethod)
				{
					int unitItemFreqCount = sentenceUnitItemFrequencies.get(unitItem);
					double unitItemIDF = sourceIDF.get(unitItem);
					sentenceScore += unitItemFreqCount * unitItemIDF;
				}
				else if (EInformationContentMethod.TFIDF == paramInformationContentMethod)
				{
					int unitItemFreqCount = sentenceUnitItemFrequencies.get(unitItem);
					//Double tf = new Double(1.0 + Math.log(unitItemFreqCount));
					Double tf = new Double(0.5 + ((0.5 * (double) unitItemFreqCount) / (double) mostFrequentUnitItemCount));
					double unitItemIDF = sourceIDF.get(unitItem);
					//System.out.println("unitItemFreqCount=" + unitItemFreqCount + ", maxFreqUnitItemCount=" + maxFreqUnitItemCount + ", tf=" + tf +", mult=" + (unitItemFreqCount * (tf * unitItemIDF)));
					sentenceScore += unitItemFreqCount * (tf * unitItemIDF);
				}
			}
			
			// Normalize the IDF score by the length
			//	i.e., used to find the shortest sentence with the most information
			int totalSentenceUnitItemCount = sourceSentenceLengths.get(sentenceNumber);
			if (totalSentenceUnitItemCount > 0)
//				if (totalSentenceUnitItemCount < 5)
//					sourceInfoContentScores.put(sentenceNumber, 0.0);
//				else
				sourceInfoContentScores.put(sentenceNumber, sentenceScore);
				//sourceInfoContentScores.put(sentenceNumber, sentenceScore / (double) totalSentenceUnitItemCount);
			else
				sourceInfoContentScores.put(sentenceNumber, 0.0);
			
			if (paramUseInfoContentOnly)
			{
				DocumentSentence sentence = sentenceList.get(sentenceNumber);
				sentence.setScore(sentenceScore);
			}
		}
		
		// Normalize Information Content Scores to between 0..1
		//	Find highest information content score
		double highestInfoContentScore = 0.0;
		for (Integer sentenceNumber : sourceInfoContentScores.keySet())
		{
			Double sentenceScore = sourceInfoContentScores.get(sentenceNumber); 
			if (sentenceScore > highestInfoContentScore)
				highestInfoContentScore = sentenceScore;  
		}
		//	Normalize information content score based on highest information content score
		for (Integer sentenceNumber : sourceInfoContentScores.keySet())
		{
			Double sentenceScore = sourceInfoContentScores.get(sentenceNumber);
			sourceInfoContentScores.put(sentenceNumber, sentenceScore / highestInfoContentScore);
		}

		
		//if (!paramUseInfoContentOnly)
		{
			/*
			System.out.println("\t# of source sentences: " + totalNumSourceSentences);
			for (Integer sentenceNumber : sentenceList.keySet())
			{
				System.out.println("#"  + sentenceNumber + ": " + sentenceList.get(sentenceNumber).getSentenceText()); 
						
				System.out.println(infoContentScoresSourceText.get(sentenceNumber));
				System.out.println();
			}
			System.out.println("");
			System.out.println("***END***");
			*/
			
			//	Initialize summary text unit items frequency
			Map<String, Integer> summaryUnitItemFrequencies = new HashMap<String, Integer>();
			int totalSummaryUnitItems = 0;
			
	
			//
			// Build summary based on information content and novelty
			//
			Integer bestSentenceNumber = new Integer(-1);
			Double  bestSentenceScore = 0.0;
			
			// Score each sentence
			for (int sentenceScoreIdx=sentenceList.size(); sentenceScoreIdx > 0; sentenceScoreIdx--)
			{
				bestSentenceScore = 0.0;
				bestSentenceNumber = -1;
				
				// if summary has no sentences, find sentence with highest information content to initialize
				if (0 == totalSummaryUnitItems)
				{
					for (Integer sentenceNumber : sourceInfoContentScores.keySet())
					{
						Double infoContentScore = sourceInfoContentScores.get(sentenceNumber);
						
						if (infoContentScore > bestSentenceScore)
						{
							bestSentenceNumber = sentenceNumber;
							bestSentenceScore  = infoContentScore;
						}
					}
				}
				else
				{
					// Generate a novelty score for each unscored sentence based on the summary's language model
					Map<Integer, Double> sourceNoveltyScores = new HashMap<Integer, Double>();
					
					// Generate novelty scores
					for (Integer sentenceNumber : sentenceList.keySet())
					{
						//System.out.println("Processing sentence #" + sentenceNumber);
						
						DocumentSentence sentence = sentenceList.get(sentenceNumber);
						
						// Skip sentences already scored
						if (sentence.getScore() > 0.0)
							continue;
						
						HashMap<String, Integer> sentenceUnitItemFrequencies = sourceSentenceUnitItemsFrequencies.get(sentenceNumber);
						
						// Find # of unit items in sentence
						//int totalUnitItemsInSentence = sourceSentenceLengths.get(sentenceNumber);
	
						// Calculate lamda
//						double lamdaLM = paramLamdaLM; 
//						if (lamdaLM <= 0.0 || lamdaLM > 1.0)
//						{
//							lamdaLM = Math.abs(Math.log10((double) totNumUnitItemsSentence / (double) maxSentenceLengthSource));
//							if (lamdaLM > 0.999)
//								lamdaLM = 0.999;
//							//System.out.println("lamda=" + lamda + ", totNumUnitItemsSentence=" + totNumUnitItemsSentence + ", maxSentenceLengthSource=" + maxSentenceLengthSource);
//						}
	
						// Find likelihood of sentence given summary LM
						double sentenceLikelihood = 0.0;	
						for (String unitItem : sentenceUnitItemFrequencies.keySet())
						{
							// (1 - lamda) * (prob of term in collection)
							double collectionScore = (1.0 - paramLamdaLM) * ((double) sourceUnitItemFrequencies.get(unitItem) / (double) totalNumUnitItemsInSource);
							
							double documentScore = 0.0;
							if (summaryUnitItemFrequencies.containsKey(unitItem))
							{
								double probUnitItemInDocument = (double) summaryUnitItemFrequencies.get(unitItem) / (double) totalSummaryUnitItems;
								documentScore = paramLamdaLM * probUnitItemInDocument;
							}
							
							//System.out.println("\t unitItem=" + unitItem + ", docScore=" + documentScore + ", modelProb=" + documentScore); 
	
							if (sentenceLikelihood > 0)
								sentenceLikelihood *= (collectionScore + documentScore);
							else
								sentenceLikelihood = (collectionScore + documentScore);
							
							//System.out.println("\t#" + sentenceNumber + ", probSentence=" + probSentence +", lamda=" + lamda + ",collScore=" + collectionScore + ", docScore=" + documentScore);						
						}
						
						// Convert likelihood score to novelty score
						double sentenceNoveltyScore = 1.0 - sentenceLikelihood;
						sourceNoveltyScores.put(sentenceNumber, sentenceNoveltyScore);
						//System.out.println("#" + sentenceNumber + ", sentenceLikelihood=" + sentenceLikelihood + ", novelty=" + sentenceNoveltyScore);
					}
					
					// Score each sentence on information content and novelty
					Map<Integer, Double> sentenceScores = new HashMap<Integer, Double>();
					for (Integer sentenceNumber : sourceNoveltyScores.keySet())
					{
						if (EMixtureMethod.MIXTURE == paramMixtureMethod)
							sentenceScores.put(sentenceNumber, ((1.0 - paramLamdaICLM) * sourceInfoContentScores.get(sentenceNumber)) + (paramLamdaICLM * sourceNoveltyScores.get(sentenceNumber)));
						else if (EMixtureMethod.ADDITION == paramMixtureMethod)					
							sentenceScores.put(sentenceNumber, sourceInfoContentScores.get(sentenceNumber) + sourceNoveltyScores.get(sentenceNumber));
						else if (EMixtureMethod.MULTIPLICATION == paramMixtureMethod)
							sentenceScores.put(sentenceNumber, sourceInfoContentScores.get(sentenceNumber) * sourceNoveltyScores.get(sentenceNumber));
					}
					
					// Find best scoring sentence
					for (Integer sentenceNumber : sentenceScores.keySet())
					{
						if (sentenceScores.get(sentenceNumber) > bestSentenceScore)
						{
							bestSentenceNumber = sentenceNumber;
							bestSentenceScore  = sentenceScores.get(sentenceNumber);
						}
					}
				}
				
				// Update sentence information of best scoring sentence
				if (bestSentenceNumber >= 0)
				{
					DocumentSentence sentence = sentenceList.get(bestSentenceNumber);
					sentence.setScore(sentenceScoreIdx);
					
					//System.out.println("selected sentence #" + bestSentenceNumber); 
					//System.out.println(bestSentenceNumber + "," + sentenceScoreIdx);
				
					// Update summary language model
					HashMap<String, Integer> sentenceUnitItemFrequencies = sourceSentenceUnitItemsFrequencies.get(bestSentenceNumber);
					for (String unitItem : sentenceUnitItemFrequencies.keySet())
					{
						if (summaryUnitItemFrequencies.containsKey(unitItem))
						{
							Integer count = summaryUnitItemFrequencies.get(unitItem);
							count += sentenceUnitItemFrequencies.get(unitItem);
							summaryUnitItemFrequencies.put(unitItem, count);
							totalSummaryUnitItems += count;
						}
						else
						{
							summaryUnitItemFrequencies.put(unitItem, new Integer(1));
							totalSummaryUnitItems++;
						}
					}
				}
			}
			
			// Generate list of top scoring sentences
	//		List<DocumentSentence> sentenceList2 = new ArrayList<DocumentSentence>();
	//		for (Integer sentenceNumber : sentenceList.keySet())
	//			sentenceList2.add(sentenceList.get(sentenceNumber));
	//		Collections.sort(sentenceList2, new DocumentSentenceCompareByScore(false));
	//		
	//		List<DocumentSentence> topscoringSentenceList = new ArrayList<DocumentSentence>();
	//		for (int idx=0; idx < 30; idx++)
	//			topscoringSentenceList.add(sentenceList2.get(idx));
	//
	//		// Sort sentences in order of appearance
	//		Collections.sort(topscoringSentenceList, new DocumentSentenceCompareByNumber(true));
			
	//		for (DocumentSentence sentence : topscoringSentenceList)
	//		{
	//			System.out.println("#" + sentence.getSentenceNumber() + ": " + sentence.getSentenceText());
	//		}
		}
	}
}
