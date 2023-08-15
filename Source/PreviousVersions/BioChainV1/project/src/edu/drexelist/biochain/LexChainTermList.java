/*
 * 
 *
 *
 */
package edu.drexelist.biochain;

import java.util.*;

/**
 * Stores a chain of lexical terms
 *
 */
public class LexChainTermList
	implements Comparable
{
    //  ------------------------------------------------------- Constants
    
    //  ------------------------------------------------------- Instance Variables
	private String 		description = "Unknown Semantic Type";
	private Properties	parameters = new Properties();
	private double 		score = -1.0;
	private ArrayList	termList = new ArrayList();
	private int 		tuiNumber = 0;
	private String 		tui = "T00";
    
    //  ------------------------------------------------------- Properties
	/**
	  * @return The elapsed time in ms
	  *
	  */
	public double getScore()
	{
		if (this.score < 0.0)
		{
			String scoreMethod = this.parameters.getProperty("scoremethod", "dublin");
			boolean filtered = (this.parameters.getProperty("filtered", "true").equalsIgnoreCase("true"));
			
			if (filtered)
			{
				if ((this.tuiNumber !=  37) && // Injury or Poisoning
					(this.tuiNumber !=  51) && // Event
					(this.tuiNumber !=  52) && // Activity
					(this.tuiNumber !=  61) && // Therapeutic or Preventative Procedure
					(this.tuiNumber !=  62) && // Research Activity
					(this.tuiNumber !=  67) && // Phenomena or Process
					(this.tuiNumber !=  81) && // Quantitative Concept
					(this.tuiNumber != 169) && // Functional Concept
					(this.tuiNumber != 170) && // Intellectual Product
					(this.tuiNumber != 191))   // Neoplastic Process
				{
					return 0.0;
				}
			}
		
			if (scoreMethod == null || scoreMethod.length() == 0)
			{
				this.score = scoreDUIST();	
			}
			else
			{
				if (scoreMethod.equalsIgnoreCase("duist"))
					this.score = scoreDUIST();
				else if (scoreMethod.equalsIgnoreCase("be"))
					this.score = scoreBE();
				else if (scoreMethod.equalsIgnoreCase("word-distance"))
					this.score = scoreWordDistance();
				else
					this.score = scoreDUIST();
			}
		}
		
		return this.score;
	}
	

	/**
	  * @return The elapsed time in ms
	  *
	  */
	public String getDescription() 
	{
		return this.description;
	}

	/**
	  * param The elapsed time in ms
	  *
	  */
	public void setDescription(String value) 
	{
		this.description = value;
	}

	/**
	  * @return The elapsed time in ms
	  *
	  */
	public int getNumber() 
	{
		return this.tuiNumber;
	}

	/**
	  * param The elapsed time in ms
	  *
	  */
	public void setNumber(int value) 
	{
		this.tuiNumber = value;
	}

	/**
	  * @return The elapsed time in ms
	  *
	  */
	public Properties getParameters() 
	{
		return this.parameters;
	}

	/**
	  * param The elapsed time in ms
	  *
	  */
	public void setParameters(Properties value) 
	{
		this.parameters.clear();
		
        Iterator it = value.keySet().iterator();
        while (it.hasNext()) 
		{
        	String keyName = (String) it.next();
			this.parameters.setProperty(keyName, value.getProperty(keyName));
		}
	}

	/**
	  * @return The elapsed time in ms
	  *
	  */
	public List getTermList() 
	{
		return this.termList;
	}

	/**
	  * @return The elapsed time in ms
	  *
	  */
	public String getTUI() 
	{
		return this.tui;
	}

	/**
	  * param The elapsed time in ms
	  *
	  */
	public void setTUI(String value) 
	{
		this.tui = value;
	}


    //  ------------------------------------------------------- Public Methods
	/**
	  * param The elapsed time in ms
	  *
	  */
	public void addTerm(LexChainTerm term) 
	{
		this.score = -1.0;
		
		// Ignore duplicates
		for (int idx=0; idx < this.termList.size(); idx++) 
		{
			LexChainTerm checkTerm = (LexChainTerm) this.termList.get(idx);
			
			if ((checkTerm.getSectionNumber() == term.getSectionNumber()) &&
				(checkTerm.getSentenceNumber() == term.getSentenceNumber()) &&
				(checkTerm.getTerm().equalsIgnoreCase(term.getTerm())))
				return;
		}
		
		this.termList.add(term);
	}
	
    public int compareTo(Object obj) 
    {
    	LexChainTermList other = (LexChainTermList) obj;
    	
    	return Double.compare(this.score, other.getScore());
		
        //return this.tui.compareTo(other.tui);
		
//        if (this.score == other.getScore())
//        {
//        	//System.out.println("compareTo: " + this.tui + "(" + this.score + ") : " + other.tui + "(" + other.getScore() + ") ==");
//            return 0;
//        }
//        
//        else if (this.score < other.getScore())
//        {
//        	//System.out.println("compareTo: " + this.tui + "(" + this.score + ") : " + other.tui + "(" + other.getScore() + ") <<");
//            return 1;
//        }
//        
//        else
//        {
//        	//System.out.println("compareTo: " + this.tui + "(" + this.score + ") : " + other.tui + "(" + other.getScore() + ") >>");
//            return -1;
//        }
    }
	
    public boolean equals(Object obj)
    {
    	if (obj == null)
    		return false;
    	
    	LexChainTermList other = (LexChainTermList) obj;
        //System.out.println("equals: " + this.tui + ":" + other.tui);

        //return this.tui.equals(other.getTUI());
    	if ((this.tuiNumber == other.tuiNumber) &&
    		(this.score == other.getScore()))
    		return true;
    	
    	return false;
    }	


    
    //  ------------------------------------------------------- Private Methods    
	private double scoreBE() 
	{
		//System.out.println("ScoreBE");
		
		int numUniqueOccurences = this.termList.size();
		
		if (this.termList.size() == 0)
			return 0.0;
		
		for (int idx=0; idx < this.termList.size(); idx++) {
			LexChainTerm term = (LexChainTerm) this.termList.get(idx);
			
			for (int subidx=idx+1; subidx < this.termList.size(); subidx++) 
			{
				LexChainTerm termsub = (LexChainTerm) this.termList.get(subidx);
				if (term.getTerm().equalsIgnoreCase(termsub.getTerm()))
					numUniqueOccurences--;
			}
		}
		
		return this.termList.size() * (1 - (numUniqueOccurences / this.termList.size()));
	}

	private double scoreWordDistance() {
		double score = 0.0;
		
		for (int idx=0; idx < this.termList.size()-1; idx++) {
			LexChainTerm currterm = (LexChainTerm) this.termList.get(idx);
			LexChainTerm nextterm = (LexChainTerm) this.termList.get(idx+1);
			
			int distance = nextterm.getSentenceNumber() - currterm.getSentenceNumber();
			if (distance >= 0 && distance <= 3)
				score += 1.0;
			else if (distance >= 4 && distance <= 6)
				score += 0.5;
			else if (distance >= 7 && distance <= 9)
				score += 0.25;
		}
		
		return score;
	}

	private double scoreDUIST() {
		double score = 0.0;
		int mostFrequentMatches=-1;
		int mostFrequentIdx=0;
		int numUniqueOccurences = this.termList.size();
		
		if (this.termList.size() > 0) {
			// Find most common term
			ArrayList templist = (ArrayList) this.termList.clone();
			
			Collections.sort(templist);
			
			LexChainTerm currterm = (LexChainTerm) templist.get(0);
			mostFrequentIdx = 0;
			mostFrequentMatches = 1;
			
			int numMatches = 1;
			for (int idx=1; idx < templist.size(); idx++) {
				LexChainTerm term = (LexChainTerm) templist.get(idx);
			
				//System.out.println("compare: " + currterm.getTerm() + " vs " + term.getTerm());
				if (currterm.getTerm().equalsIgnoreCase(term.getTerm())) {
					numMatches++;
					numUniqueOccurences--;
					//System.out.println("\tmatch, total=" + numMatches);
				}
				else {
					//System.out.println("\tmatch, total=" + numMatches + ", frequent=" + mostFrequentMatches);
					if (numMatches > mostFrequentMatches) {
						mostFrequentIdx = idx-1;
						mostFrequentMatches = numMatches;
					}
					numMatches = 1;
					currterm = (LexChainTerm) templist.get(idx);
				}
			}
			
			if (numMatches > mostFrequentMatches) {
				mostFrequentMatches = numMatches;
				mostFrequentIdx = templist.size()-1;
			}
			
			score = mostFrequentMatches * (numUniqueOccurences-1);
			
			//LexChainTerm term = (LexChainTerm) templist.get(mostFrequentIdx);
			//System.out.println(this.tui + ":MFT=" + term.getTerm() + ", cnt=" + mostFrequentMatches + ",unq=" + numUniqueOccurences);
		}
		
		return score;
	}
}
