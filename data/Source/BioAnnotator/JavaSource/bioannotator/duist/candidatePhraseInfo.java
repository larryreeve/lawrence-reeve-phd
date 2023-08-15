/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator.duist;

import java.util.*;

public class candidatePhraseInfo 
{
    @SuppressWarnings("unused")
    private static final String  COPYRIGHT          = biocommon.copyright.Copyright.COPYRIGHT;

    String                       phrase             = null;
    int                          coverageLength     = 0;
    int                          positionStart      = 0;
    int                          positionEnd        = 0;
    double                       conceptPhraseScore = 0.0;
    private double               score              = 0.0;
    private Map<Integer, Double> conceptPhrases     = null;
	
	
	public Map<Integer,Double> getConceptPhrases()
	{
		return this.conceptPhrases;
	}
	
	public void setConceptPhrases(Map<Integer,Double> value)
	{
		this.conceptPhraseScore = 0.0;
		this.conceptPhrases = value;
		
		if (this.conceptPhrases != null)
		{
			for (Integer pid : this.conceptPhrases.keySet())
			{
				Double scoreDouble = this.conceptPhrases.get(pid);
				
				this.conceptPhraseScore = scoreDouble.doubleValue();
				
				break;
			}
		}
	}

	public void setScore(double value)
	{
		this.score = value;
	}

	public double getScore()
	{
		return this.score;
		//return this.conceptPhraseScore + ((positionEnd - positionStart) + 1);
	}
}
