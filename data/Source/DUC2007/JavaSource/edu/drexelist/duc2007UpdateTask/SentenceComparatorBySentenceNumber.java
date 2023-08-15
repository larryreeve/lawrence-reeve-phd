/*
 * 
 *
 *
 */
package edu.drexelist.duc2007UpdateTask;

import java.util.*;


/**
 * 
 *
 */
public class SentenceComparatorBySentenceNumber
    implements Comparator<Sentence> 
{
    public int compare(Sentence s1, Sentence s2) 
    {
        if (s1.getSentenceNumber() < s2.getSentenceNumber())
            return -1;
        else if (s1.getSentenceNumber() > s2.getSentenceNumber())
            return 1;
        return 0;
    }
}
