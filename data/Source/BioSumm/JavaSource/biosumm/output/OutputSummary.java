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


public class OutputSummary 
	implements IOutputGenerator
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT    = biocommon.copyright.Copyright.COPYRIGHT;
    
	
    public void generate(PrintWriter 		writer,
            			 Document			annotatedDocument,
            			 List<ConceptChain> conceptChainList,
            			 Properties 		parameters)
	{
		int MAX_SENTENCE_LENGTH = 100;
		
		// Get parameters
		//	Compression Rate
		double paramCompressionRate = Double.parseDouble(parameters.getProperty("compressionrate", "15"));
		if (paramCompressionRate > 0) 
			paramCompressionRate /= 100;
		if (paramCompressionRate <= 0)
			paramCompressionRate = 0.15;
		
		//	Number of Sentences
		int paramNumSentences = Integer.parseInt(parameters.getProperty("numsentences", "0"));
		
		boolean SPLFormatFlag = (parameters.getProperty("format", "text").toLowerCase().equalsIgnoreCase("spl"));
		

		// Find maximum # of sentences to generate
		int maxNumberOfSentencesToGenerate = 0;
		int totalNumberOfSentences = 0;
		

		// Make a list of sentences to sort in ascending order by score
		List<DocumentSentence> sentenceList = new ArrayList<DocumentSentence>();
		for (DocumentSection section : annotatedDocument.getSections())
		{
			for (DocumentSentence sentence : section.getSentences())
			{
				totalNumberOfSentences++;
				sentenceList.add(sentence);
			}
		}
		Collections.sort(sentenceList, new DocumentSentenceCompareByScore(false));
		
		if (paramNumSentences > 0)
			maxNumberOfSentencesToGenerate = paramNumSentences;
		else
			maxNumberOfSentencesToGenerate = (int) Math.ceil(totalNumberOfSentences * paramCompressionRate);
		

		// Generate list of top scoring sentences
		List<DocumentSentence> topscoringSentenceList = new ArrayList<DocumentSentence>();
		for (int idx=0; idx < maxNumberOfSentencesToGenerate; idx++)
			topscoringSentenceList.add(sentenceList.get(idx));
		

		// Sort sentences in order of appearance
		Collections.sort(topscoringSentenceList, new DocumentSentenceCompareByNumber(true));
		
		if (SPLFormatFlag)
		{
			StringBuffer sbProcessedLine = new StringBuffer();
			
			for (DocumentSentence sentence : topscoringSentenceList)
			{
				sbProcessedLine.setLength(0);
				String sentenceText = sentence.getSentenceText().trim();
	              
	            // Add spaces to comma separators
	            for (int idx=0; idx < sentenceText.length(); idx++)
	            {
	                if (sentenceText.charAt(idx) == ',')
	                {
	                	// Check digit before and after comma
	                	boolean isPartOfNumber = (idx > 0 && Character.isDigit(sentenceText.charAt(idx-1)) && 
	                							 (idx+1) < sentenceText.length() && Character.isDigit(sentenceText.charAt(idx+1)));
	                                           
	                	if (isPartOfNumber)
	                		sbProcessedLine.append(sentenceText.charAt(idx));
	                	else
	                		sbProcessedLine.append(" , ");
	                }
	                else if (sentenceText.charAt(idx) == '.')
	                {
	                	if (idx != sentenceText.length()-1)
	                		sbProcessedLine.append(sentenceText.charAt(idx));
	                }
	                else
	                {
	                	
	                	sbProcessedLine.append(sentenceText.charAt(idx));
	                } 
	            }
	             
	            sbProcessedLine.append(" .");
	            //sbProcessedLine.append("sentence#" + sentence.getSentenceNumber() + ", score: " + sentence.getScore());
	            writer.println(sbProcessedLine.toString());
			}			
		}
		else
		{
			int lastSectionNumber = -1;
			StringBuffer outputBuffer = new StringBuffer();
			for (DocumentSentence sentence : topscoringSentenceList)
			{
	//			System.out.println(sentence.getScore() + ": " + sentence.getSentenceText());
	//			System.out.println();
	        	if (lastSectionNumber != sentence.getSectionNumber())
	        	{
	    			if (outputBuffer.length() > 0)
	    			{
	    				writer.println(outputBuffer.toString());
	    				outputBuffer.setLength(0);
	    			}
	        		
	        		writer.println();
	        		writer.println();
	        		//writer.print("   ");
	        	}
	        	
	        	lastSectionNumber = sentence.getSectionNumber();
	    		
	        	String sentenceText = sentence.getSentenceText();
	        	
	        	int curSentencePos = 0;
	        	
	        	while (curSentencePos < sentenceText.length())
	        	{
	        		if ((outputBuffer.length() + (sentenceText.length() - curSentencePos)) > MAX_SENTENCE_LENGTH)
	        		{
	        			// Get maximum length of text that can be added
	        			int maxTextLength = MAX_SENTENCE_LENGTH - outputBuffer.length();
	        			
	        			if (maxTextLength > (sentenceText.length() - curSentencePos))
	        				maxTextLength = sentenceText.length() - curSentencePos;
	        			
	        			//System.out.println("outputBuffer=" + outputBuffer.length() + ", sentenceText=" + sentenceText.length() + ", curSentencePos=" + curSentencePos + ", maxTextLength=" + maxTextLength);
	    			
	        			// Find word break
	        			int wordBreakAt = -1;
	        			for (int idx=curSentencePos + maxTextLength; idx >= 0; idx--)
	        			{
	        				if (Character.isWhitespace(sentenceText.charAt(idx)))
	        				{
	        					wordBreakAt = idx;
	        					break;
	        				}
	        			}
	        			
	        			if (wordBreakAt > 0)
	        			{
	        				//outputBuffer.append(" ");
	        				outputBuffer.append(sentenceText.substring(curSentencePos, wordBreakAt));
	        				//System.out.println("wordBreakAt=" + wordBreakAt + ", " + sentenceText.substring(curSentencePos, wordBreakAt));
	        				//System.out.println("ob= " + outputBuffer.toString());
	        				curSentencePos = wordBreakAt+1;
	        			}
	        			
	    				writer.println(outputBuffer.toString());
	        			outputBuffer.setLength(0);
	    			}
	        		else
	        		{
	        			outputBuffer.append(sentenceText.substring(curSentencePos, sentenceText.length()));
	        			curSentencePos = sentenceText.length();
	        		}
	    		}
			}
			
			if (outputBuffer.length() > 0)
				writer.println(outputBuffer.toString());
		}
		
		
//		writer.println();
//		writer.println("---------");
//		for (DocumentSentence sentence : topscoringSentenceList)
//		{
//        	if (lastSectionNumber != sentence.getSectionNumber())
//        	{
//        		writer.println();
//        		writer.println();
//        		writer.print("   ");
//        	}
//        	
//        	lastSectionNumber = sentence.getSectionNumber();
//        			
//        	writer.print(sentence.getSentenceText());
//		}
	}
}
