/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biocommon.document;

import java.util.*;

public class DocumentSentenceCompareByScore
	implements Comparator<DocumentSentence>
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT     = biocommon.copyright.Copyright.COPYRIGHT;

    private boolean             ascendingFlag = true;
    

    public DocumentSentenceCompareByScore(boolean ascending) 
    {
        this.ascendingFlag = ascending;
    }    
    
    public final int compare(DocumentSentence sentence1, 
    						 DocumentSentence sentence2) 
    {
        int result = 0;
        
        if (sentence1.getScore() < sentence2.getScore())
        	result =  -1;
        else if (sentence1.getScore() > sentence2.getScore())
        	result = 1;
        
        if (!this.ascendingFlag)
            result = -result;
        
        return result;
    }
}
