/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biosumm.score;

import java.util.*;

import biosumm.chain.*;


public class ComparatorConceptByConceptType
	implements Comparator<Concept>
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT    = biocommon.copyright.Copyright.COPYRIGHT;
    
    
    public int compare(Concept concept1,
                       Concept concept2) 
    {
        return concept1.getId().compareTo(concept2.getId());
    }
}
