/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biocommon.document;

import java.io.*;
import java.util.*;


public class DocumentSection 
	implements Serializable
{
    @SuppressWarnings("unused")
    private static final String    COPYRIGHT        = biocommon.copyright.Copyright.COPYRIGHT;
    private static final long      serialVersionUID = 1965082495622776140L;

    private String                 title            = "";
    private List<DocumentSentence> sentences        = new ArrayList<DocumentSentence>();
    private int                    sectionNumber    = 0;


    public int getSectionNumber()
	{
		return this.sectionNumber;
	}
	
	public void setSectionNumber(int value)
	{
		this.sectionNumber = value;
	}

	public List<DocumentSentence> getSentences()
	{
		return this.sentences;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public void setTitle(String value)
	{
		this.title = value;
	}
	
	public void clear()
	{
		this.sentences.clear();
		this.title = "";
	}
	
	public DocumentSection()
	{
		this(0, "");
	}
	
	public DocumentSection(int sectionNumber, 
						   String sectionTitle)
	{
		this.sectionNumber = sectionNumber;
		this.title = sectionTitle;
	}
}
