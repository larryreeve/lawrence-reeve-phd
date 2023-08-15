/*
 * 
 *
 *
 */
package edu.drexelist.biochain;


/**
 * Implements lexical chaining using MetaMap Transfer
 *
 */
public class SemanticType implements Comparable 
{

	//  ------------------------------------------------------- Constants
    
    //  ------------------------------------------------------- Instance Varibles
    private String tui = null;
    private String description = null;
    private double score = 0.0;

    
    //  ------------------------------------------------------- Properties
    /**
     * @return The elapsed time in ms
     *
     */
    public String getDescription() 
    {
        return this.description;
    }

    /**
     * @return The elapsed time in ms
     *
     */
    public double getScore() 
    {
        return this.score;
    }

    /**
     * @return The elapsed time in ms
     *
     */
    public String getTUI() 
    {
        return this.tui;
    }

	
    //  ------------------------------------------------------- Public Methods
	/**
	  * ctor
	  *
	  */
    public SemanticType(String tui, String description, double score) 
    {
        this.tui = tui;
        this.description = description;
        this.score = score;
    }
	
	
    public int compareTo(Object obj) 
    {
        SemanticType other = (SemanticType) obj;
		
        //return this.tui.compareTo(other.tui);
		
        //System.out.println("compareTo: " + this.score + ":" + other.getScore());
		
        if (this.score == other.getScore())
            return 0;
        else if (this.score < other.getScore())
            return 1;
        else
            return -1;
    }
	
    public boolean equals(Object obj)
    {
        SemanticType other = (SemanticType) obj;
        //System.out.println("equals: " + this.tui + ":" + other.tui);

        //return this.tui.equals(other.getTUI());
        return this.score == other.score;
    }	

	//  ------------------------------------------------------- Private Methods    
}
