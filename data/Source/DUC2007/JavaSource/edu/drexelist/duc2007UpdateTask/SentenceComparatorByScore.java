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
public class SentenceComparatorByScore
    implements Comparator<Sentence> 
{
    public int compare(Sentence s1, Sentence s2) 
    {
        if (s1.getScore() < s2.getScore())
            return -1;
        else if (s1.getScore() > s2.getScore())
            return 1;
        return 0;
    }
}
