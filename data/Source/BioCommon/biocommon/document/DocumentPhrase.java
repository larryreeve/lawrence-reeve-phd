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
 */
public class DocumentPhrase 
	implements Serializable
{
    @SuppressWarnings("unused")
    private static final String          COPYRIGHT           = biocommon.copyright.Copyright.COPYRIGHT;
    private static final long            serialVersionUID    = 1965082495622776140L;

    private String                       phraseValue         = "";
    private int                          sectionNumberValue  = 0;
    private int                          sentenceNumberValue = 0;
    private Map<String, DocumentConcept> conceptListValue    = new HashMap<String, DocumentConcept>();
    

    /**
     * @return The term phrase
     *
     */
    public Map<String,DocumentConcept> getConcepts() 
    {
        return this.conceptListValue;
    }

    /**
     * @return The term phrase
     *
     */
    public String getPhraseText() 
    {
        return this.phraseValue;
    }

    /**
     * param The term phrase
     *
     */
    public void setPhraseText(String value) 
    {
        this.phraseValue = value;
    }
    
    /**
	  * @return The elapsed time in ms
	  *
	  */
	public int getSectionNumber() 
    {
		return this.sectionNumberValue;
	}

	/**
	  * param The elapsed time in ms
	  *
	  */
	public void setSectionNumber(int value) 
    {
		this.sectionNumberValue = value;
	}

	/**
	  * @return The elapsed time in ms
	  *
	  */
	public int getSentenceNumber() 
    {
		return this.sentenceNumberValue;
	}

	/**
	  * param The elapsed time in ms
	  *
	  */
	public void setSentenceNumber(int value) 
    {
		this.sentenceNumberValue = value;
	}


	//  ------------------------------------------------------- Public Methods
	public DocumentPhrase()  
    {
		this("", 0, 0);
	}

	public DocumentPhrase(
            String  phrase,
			int		sectionNumber,
			int		sentenceNumber) 
    {
        this.phraseValue = phrase;
		this.sectionNumberValue = sectionNumber;
		this.sentenceNumberValue = sentenceNumber;
	}
}
