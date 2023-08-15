/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biosumm.chain;


/**
 * 
 *
 */
public class SemanticType 
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT          = biocommon.copyright.Copyright.COPYRIGHT;

    public static final int     MAX_SEMANTIC_TYPES = 256;
    
    
    //  ------------------------------------------------------- Instance Varibles
    private String 	idValue = null;
    private String 	descriptionValue = null;
	private int 	typeNumberValue = 0;

    
    //  ------------------------------------------------------- Properties
    /**
     * @return The elapsed time in ms
     *
     */
    public String getDescription() 
    {
        return this.descriptionValue;
    }


    /**
     * @return 
     *
     */
    public int getTypeNumber() 
    {
        return this.typeNumberValue;
    }

    /**
     * @return 
     *
     */
    public String getId() 
    {
        return this.idValue;
    }

	
    //  ------------------------------------------------------- Public Methods
	/**
	  * ctor
	  *
	  */
    public SemanticType(int 	typeNumber, 
    					String 	id, 
    					String 	description) 
    {
        this.idValue = id;
        this.descriptionValue = description;
        this.typeNumberValue = typeNumber;
    }
}
