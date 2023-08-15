/*
 * 
 *
 *
 */
package edu.drexelist.duc2007UpdateTask;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 *
 */
public class Sentence 
{
	private String originalsentenceTextValue = "";
	private String normalizedsentenceTextValue = "";
	private List<String> words = new ArrayList<String>();
	private int sentenceNumberValue = 0;
	private double scoreValue = 0.0;	
	private int wordCountOriginal = 0;
	
	
	public double getScore()
	{
		return this.scoreValue;
	}

	public void setScore(double value)
	{
		this.scoreValue = value;
	}

	public String getSentenceText()
	{
		return this.originalsentenceTextValue;
	}
	
	public String getNormalizedSentenceText()
	{
		return this.normalizedsentenceTextValue;
	}

	public void setSentenceText(String value)
	{
		this.originalsentenceTextValue = value.replace(" the ", " ").replace(" _ ", "");
		this.normalizedsentenceTextValue = this.normalizeSentenceText(this.originalsentenceTextValue);
		this.words = WordSplitter.splitWithStopWords(this.normalizedsentenceTextValue);
		String[] originalWords = this.originalsentenceTextValue.split(" ");
		this.wordCountOriginal = originalWords.length;
	}

	public int getSentenceNumber()
	{
		return this.sentenceNumberValue;
	}

	public void setSentenceNumber(int value)
	{
		this.sentenceNumberValue = value;
	}
	
	public List<String> getWords()
	{
		return this.words;
	}
	
	public int getWordCount()
	{
		return this.wordCountOriginal;
	}

	public Sentence()
	{
		this("", 0);
	}
	
	public Sentence(String 	sentenceText,
					int 	sentenceNumber)
	{
		this.sentenceNumberValue = sentenceNumber;
		this.setSentenceText(sentenceText);
	}
	
	private String normalizeSentenceText(String sentenceText)
	{
		String normalizedSentence = sentenceText;
		
		normalizedSentence = normalizedSentence.replace("(", " ");
		normalizedSentence = normalizedSentence.replace(")", " ");
		normalizedSentence = normalizedSentence.replace(",", " ");
		normalizedSentence = normalizedSentence.replace(".", " ");
		normalizedSentence = normalizedSentence.replace(";", " ");
		normalizedSentence = normalizedSentence.replace(":", " ");
		normalizedSentence = normalizedSentence.replace("_", " ");
		normalizedSentence = normalizedSentence.replace("-", " ");
		normalizedSentence = normalizedSentence.replace("'", " ");
		normalizedSentence = normalizedSentence.replace(",", " ");
		normalizedSentence = normalizedSentence.replace(".", " ");
		
		return normalizedSentence;
	}
}
