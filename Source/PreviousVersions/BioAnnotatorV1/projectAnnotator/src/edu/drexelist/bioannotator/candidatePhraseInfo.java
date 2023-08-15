package edu.drexelist.bioannotator;

import java.util.*;

public class candidatePhraseInfo 
{
	String phrase 		= null;
	int coverageLength 	= 0;
	int positionStart 	= 0;
	int positionEnd 	= 0;
	double conceptPhraseScore = 0.0;
	private double score = 0.0;
	private Map<Integer,Double> conceptPhrases = null;
	
	
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
