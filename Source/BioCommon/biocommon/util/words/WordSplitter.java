/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biocommon.util.words;

import java.util.*;


public class WordSplitter 
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT  = biocommon.copyright.Copyright.COPYRIGHT;
    
    // private static final char[] DELIMITERS = {'(', ')', ',', '.', ';', ':'};
    private static final char[] DELIMITERS = { '(', ')', ';', ':' };
    

    public static List<String> splitWithStopWords(String sentenceText)
	{
        return WordSplitter.split(sentenceText, DELIMITERS, true);
	}
    
    public static List<String> splitWithStopWords(String sentenceText, char[] delimiters)
    {
        return WordSplitter.split(sentenceText, delimiters, true);
    }

    public static List<String> splitWithoutStopWords(String sentenceText)
    {
        return WordSplitter.split(sentenceText, DELIMITERS, false);
    }
    
    public static List<String> splitWithoutStopWords(String sentenceText, char[] delimiters)
    {
        return WordSplitter.split(sentenceText, delimiters, false);
    }
    
    static List<String> split(String sentenceText, char[] delimiters, boolean filterStopWords)
    {
        if (delimiters != null && delimiters.length > 0)
        {
            for (char ch : delimiters)
                sentenceText = sentenceText.replace(String.valueOf(ch), " ");        
        }
        
        String words[] = sentenceText.split(" ");
        
        List<String> wordList = new ArrayList<String>();
        
        if (words != null && words.length > 0)
        {   
            for (String word : words)
            {
                String wordNormalized = word.trim();
                
                if (wordNormalized.length() > 0)
                {
                    if (filterStopWords)
                    {
                        if (!StopWordManager.isStopWord(wordNormalized))
                            wordList.add(wordNormalized);
                    }
                    else
                    {
                        wordList.add(wordNormalized);
                    }
                }
            }
        }
        
        return wordList;
    }
}
