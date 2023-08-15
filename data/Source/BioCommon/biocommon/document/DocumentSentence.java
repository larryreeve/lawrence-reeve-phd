/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biocommon.document;

import java.io.*;
import java.util.*;


/**
 * 
 *
 */
public final class DocumentSentence 
	implements Serializable
{
    @SuppressWarnings("unused")
    private static final String          COPYRIGHT           = biocommon.copyright.Copyright.COPYRIGHT;
    private static final long            serialVersionUID    = 1965082495622776140L;

    private String                       sentenceTextValue   = "";
    private int                          sectionNumberValue  = 0;
    private int                          sentenceNumberValue = 0;
    private double                       scoreValue          = 0.0;
    private List<DocumentPhrase> phraseListValue     = new ArrayList<DocumentPhrase>();
	
	
	public double getScore()
	{
		return this.scoreValue;
	}

	public void setScore(double value)
	{
		this.scoreValue = value;
	}

	public List<DocumentPhrase> getPhrases()
	{
		return this.phraseListValue;
	}

	public int getSectionNumber()
	{
		return this.sectionNumberValue;
	}

	public void setSectionNumber(int value)
	{
		this.sectionNumberValue = value;
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


	public DocumentSentence()
	{
		this("", 0, 0);
	}
	
	public DocumentSentence(String 	sentenceText,
							int 	sentenceNumber,
							int 	sectionNumber)
	{
		this.sentenceTextValue		= sentenceText;
		this.sentenceNumberValue	= sentenceNumber;
		this.sectionNumberValue		= sectionNumber;
	}
	
}
