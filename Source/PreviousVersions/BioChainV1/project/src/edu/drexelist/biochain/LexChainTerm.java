/*
 * 
 *
 *
 */
package edu.drexelist.biochain;

/**
 * Container for lexical term information
 * Term may consist of more than one word
 *
 */
public class LexChainTerm implements Comparable 
{
    //  ------------------------------------------------------- Constants
    
    //  ------------------------------------------------------- Instance Variables
    private String  phrase = "";
	private String 	termValue = "";
	private int		sectionNumber = 0;
	private int 	sentenceNumber = 0;
    
    //  ------------------------------------------------------- Properties
    /**
     * @return The term phrase
     *
     */
    public String getPhrase() 
    {
        return this.phrase;
    }

    /**
     * param The term phrase
     *
     */
    public void setPhrase(String value) 
    {
        this.phrase = value;
    }
    
    /**
	  * @return The elapsed time in ms
	  *
	  */
	public int getSectionNumber() 
    {
		return this.sectionNumber;
	}

	/**
	  * param The elapsed time in ms
	  *
	  */
	public void setSectionNumber(int value) 
    {
		this.sectionNumber = value;
	}

	/**
	  * @return The elapsed time in ms
	  *
	  */
	public int getSentenceNumber() 
    {
		return this.sentenceNumber;
	}

	/**
	  * param The elapsed time in ms
	  *
	  */
	public void setSentenceNumber(int value) 
    {
		this.sentenceNumber = value;
	}

	/**
	  * @return The elapsed time in ms
	  *
	  */
	public String getTerm() 
    {
		return this.termValue;
	}

	/**
	  * param The elapsed time in ms
	  *
	  */
	public void setTerm(String value) 
    {
		this.termValue = value;
	}

    //  ------------------------------------------------------- Public Methods
	public LexChainTerm()  
    {
		this("", "", 0, 0);
	}

	public LexChainTerm(
            String  phrase,
			String 	termValue,
			int		sectionNumber,
			int		sentenceNumber) 
    {
        this.phrase = phrase;
		this.termValue = termValue;
		this.sectionNumber = sectionNumber;
		this.sentenceNumber = sentenceNumber;
	}

	public int compareTo(Object obj) 
    {
		LexChainTerm other = (LexChainTerm) obj;
		
		return this.termValue.compareTo(other.termValue);
	}
	
	public boolean equals(Object obj) 
    {
		LexChainTerm other = (LexChainTerm) obj;

		return this.termValue.equals(other.termValue);
	}	
	
    
    //  ------------------------------------------------------- Private Methods    
}
