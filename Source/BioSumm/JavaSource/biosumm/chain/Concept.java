/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biosumm.chain;

public class Concept 
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT           = biocommon.copyright.Copyright.COPYRIGHT;

    private String              idValue             = "";
    private String              nameValue           = "";
    private String              semanticTypeIdValue = "";
    private int                 sectionNumber       = 0;
    private int                 sentenceNumber      = 0;
	

    public String getId()
	{
		return this.idValue;
	}
	
	public void setId(String value)
	{
		this.idValue = value;
	}

	public String getName()
	{
		return this.nameValue;
	}
	
	public void setName(String value)
	{
		this.nameValue = value;
	}

	public int getSectionNumber()
	{
		return this.sectionNumber;
	}

	public String getSemanticTypeId()
	{
		return this.semanticTypeIdValue;
	}
	
	public void setSemanticTypeId(String value)
	{
		this.semanticTypeIdValue = value;
	}

	public int getSentenceNumber()
	{
		return this.sentenceNumber;
	}

	public Concept(String id,
				   String name,
				   String semanticTypeId,
				   int    sectionNumber,
				   int	  sentenceNumber)
	{
		this.idValue = id;
		this.nameValue = name;
		this.semanticTypeIdValue = semanticTypeId;
		this.sectionNumber = sectionNumber;
		this.sentenceNumber = sentenceNumber;
	}
}
