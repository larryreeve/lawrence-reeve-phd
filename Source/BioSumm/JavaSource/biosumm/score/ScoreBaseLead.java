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


public class ScoreBaseLead
	implements IScorer
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT    = biocommon.copyright.Copyright.COPYRIGHT;

	
    public void score(List<ConceptChain> 	conceptChainList,
					  Document 				annotatedDocument,
					  Properties 			parameters)
		throws Exception
	{
		// Set sentence score based on sentence position
		for (DocumentSection section : annotatedDocument.getSections())
		{
			for (DocumentSentence sentence : section.getSentences())
			{
				sentence.setScore(1.0 / (sentence.getSentenceNumber() + 1));
			}
		}
	}
}
