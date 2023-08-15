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
import biosumm.chain.*;


public class OutputLemur
	implements IOutputGenerator
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT    = biocommon.copyright.Copyright.COPYRIGHT;

	
    public void generate(PrintWriter 		writer,
            			 Document			annotatedDocument,
            			 List<ConceptChain> conceptChainList,
            			 Properties 		parameters)
	{
		System.out.println("DocID: " + annotatedDocument.getDocID() + " has " + annotatedDocument.getSections().size() + " sections...");
		
		writer.println("<DOC>");
		writer.println("  <DOCNO>" + annotatedDocument.getDocID() + "</DOCNO>");
		writer.println("  <TEXT>");
		
		for (DocumentSection section : annotatedDocument.getSections())
		{
//			if (section.getSentences().size() == 1 && 
//				section.getSentences().get(0).getPhrases().size() == 1)
//			{
//				DocumentSentencePhrase phrase = section.getSentences().get(0).getPhrases().get(0);
//				String phraseText = phrase.getPhraseText();
//				
//				if (phraseText.equalsIgnoreCase("introduction") ||
//					phraseText.equalsIgnoreCase("introduction."))
//				{
//						System.out.println("Introduction");
//				}
//				else if (phraseText.equalsIgnoreCase("methods") ||
//						 phraseText.equalsIgnoreCase("methods."))
//				{
//					System.out.println("Methods");
//				}
//				else if (phraseText.equalsIgnoreCase("discussion") ||
//						 phraseText.equalsIgnoreCase("discussion."))
//				{
//					System.out.println("Discussion");
//				}
//				else if (phraseText.equalsIgnoreCase("results") ||
//						 phraseText.equalsIgnoreCase("results."))
//				{
//					System.out.println("Results");
//				}
//				else
//				{
//					System.out.println("Unknown: '" + phraseText + "'");
//				}
//			}
				
			//System.out.println("  Section#" + section.getSectionNumber() + ": '" + section.getSentences().get(0).getSentenceText());
			//System.out.println("  Section#" + section.getSectionNumber() + ": '" + section.getTitle() + "': " + section.getSentences().size() + " sentences");
			for (DocumentSentence sentence : section.getSentences())
			{
				writer.print(sentence.getSentenceText() + " *eos ");
			}
			
			writer.println();
			writer.println();
		}
		
		writer.println("  </TEXT>");
		writer.println("</DOC>");
	}
}
