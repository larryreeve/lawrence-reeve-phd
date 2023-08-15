/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biosumm.chain;

import java.util.*;

public class ConceptChain 
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT        = biocommon.copyright.Copyright.COPYRIGHT;

    private String              descriptionValue = "Unknown Semantic Type";
    private double              scoreValue       = -1.0;
    private List<Concept>       conceptListValue = new ArrayList<Concept>();
    private int                 idNumberValue    = 0;
    private String              idValue          = "";
    private boolean             filteredValue    = false;


	/**
	  * @return 
	  *
	  */
	public List<Concept> getConceptList() 
	{
		return this.conceptListValue;
	}

	/**
	  * @return 
	  *
	  */
	public String getDescription() 
	{
		return this.descriptionValue;
	}

	/**
	  * param 
	  *
	  */
	public void setDescription(String value) 
	{
		this.descriptionValue = value;
	}
	
	public boolean isFiltered()
	{
		return this.filteredValue;
	}
	
	public void setFiltered(boolean value)
	{
		this.filteredValue = value;
	}
	
	public String getId()
	{
		return this.idValue;
	}
	
	public void setId(String value)
	{
		this.idValue = value;
	}

	public int getIdNumber()
	{
		return this.idNumberValue;
	}
	
	public void setIdNumber(int value)
	{
		this.idNumberValue = value;
	}

	public double getScore()
	{
		return this.scoreValue;
	}

	public void setScore(double value)
	{
		this.scoreValue = value;
	}

}
