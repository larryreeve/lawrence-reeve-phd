/*
 * 
 *
 *
 */
package edu.drexelist.summarizer;

import java.io.*;
import java.util.*;


/**
 * 
 *
 */
public class Sentence 
{
	private String 	sentenceTextValue 		= "";
	private int 	sentenceNumberValue 	= 0;
	private double	scoreValue				= 0.0;	
	
	
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
		return this.sentenceTextValue;
	}

	public void setSentenceText(String value)
	{
		this.sentenceTextValue = value;
	}

	public int getSentenceNumber()
	{
		return this.sentenceNumberValue;
	}

	public void setSentenceNumber(int value)
	{
		this.sentenceNumberValue = value;
	}


	public Sentence()
	{
		this("", 0);
	}
	
	public Sentence(String 	sentenceText,
					int 	sentenceNumber)
	{
		this.sentenceTextValue		= sentenceText;
		this.sentenceNumberValue	= sentenceNumber;
	}
}
