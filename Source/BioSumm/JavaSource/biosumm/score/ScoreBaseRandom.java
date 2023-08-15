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


public class ScoreBaseRandom
	implements IScorer
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT    = biocommon.copyright.Copyright.COPYRIGHT;
    
	
    public void score(List<ConceptChain> 	conceptChainList,
					  Document 				annotatedDocument,
					  Properties 			parameters)
		throws Exception
	{
		// Get total # of sentences in document
		int totalNumberOfSentences = 0;
		for (DocumentSection section : annotatedDocument.getSections())
		{
			totalNumberOfSentences += section.getSentences().size();
		}
		
		Map<Integer, Integer> dupCheck = new HashMap<Integer, Integer>();
		
		// Assign random score to each sentence
		Random numberGenerator = new Random();
		for (DocumentSection section : annotatedDocument.getSections())
		{
			for (DocumentSentence sentence : section.getSentences())
			{
				int randomIndex = numberGenerator.nextInt(totalNumberOfSentences) + 1;
				while (true)
				{
					//System.out.println("randomIndex=" + randomIndex + ", totalNumberOfSentences=" + totalNumberOfSentences);
					if (!dupCheck.containsKey(new Integer(randomIndex)))
					{
						dupCheck.put(new Integer(randomIndex), null);
						break;
					}
					else
					{
						randomIndex = numberGenerator.nextInt(totalNumberOfSentences) + 1;
					}
				}
				sentence.setScore(randomIndex);
			}
		}
		
//		for (DocumentSection section : annotatedDocument.getSections())
//		{
//			for (DocumentSentence sentence : section.getSentences())
//			{
//				System.out.println("Sentence#" + sentence.getSentenceNumber() + ": " + sentence.getScore());
//			}
//		}
	}
}
