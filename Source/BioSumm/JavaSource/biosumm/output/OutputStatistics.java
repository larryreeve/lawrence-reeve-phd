/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biosumm.output;

import java.io.*;
import java.util.*;

import biocommon.document.*;
import biosumm.chain.ConceptChain;


public class OutputStatistics 
	implements IOutputGenerator
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT    = biocommon.copyright.Copyright.COPYRIGHT;

	
    /*
	 * Display document contents
	 */
	public void generate(PrintWriter 		writer,
            			 Document			annotatedDocument,
            			 List<ConceptChain> conceptChainList,
            			 Properties 		parameters)
	{
		int numSentencesTotal = 0;
		int numWordsTotal = 0;
		int sentenceLengthLongest  = Integer.MIN_VALUE;
		int sentenceLengthShortest = Integer.MAX_VALUE;
		
		for (DocumentSection section : annotatedDocument.getSections())
		{
			for (DocumentSentence sentence : section.getSentences())
			{
				numSentencesTotal++;
				
				String[] sentenceWords = sentence.getSentenceText().split(" ");
				
//				for (String word : sentenceWords)
//					writer.print(word + " ");
//				writer.println();
//				writer.println();
				
				if (sentenceWords != null)
				{
					numWordsTotal += sentenceWords.length;
					
					if (sentenceWords.length > sentenceLengthLongest)
						sentenceLengthLongest = sentenceWords.length;

					if (sentenceWords.length < sentenceLengthShortest)
						sentenceLengthShortest = sentenceWords.length;
				}
			}
		}

        int numLinesAt10Percent = (int) Math.ceil(numSentencesTotal * .10);
        int numLinesAt15Percent = (int) Math.ceil(numSentencesTotal * .15);
        int numLinesAt20Percent = (int) Math.ceil(numSentencesTotal * .20);
        int numLinesAt25Percent = (int) Math.ceil(numSentencesTotal * .25);
    	
		writer.println();
		writer.println("  Number of sentences: "         + numSentencesTotal);
		writer.println("    10% ==> " + numLinesAt10Percent + " sentences");
		writer.println("    15% ==> " + numLinesAt15Percent + " sentences");
		writer.println("    20% ==> " + numLinesAt20Percent + " sentences");
		writer.println("    25% ==> " + numLinesAt25Percent + " sentences");
		writer.println("  Number of words: "             + numWordsTotal);
		writer.println("  Average words per sentence: "  + (numWordsTotal / numSentencesTotal));
		writer.println("  Length of longest sentence: "  + sentenceLengthLongest);
		writer.println("  Length of shortest sentence: " + sentenceLengthShortest);
	}
}
