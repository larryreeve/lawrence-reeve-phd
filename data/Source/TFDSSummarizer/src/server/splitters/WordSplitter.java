package server.splitters;

import java.util.*;


public class WordSplitter 
{
    private static final char[] DELIMITERS = {'(', ')', ';', ':', '.', '?', '!'};
    
    public static List split(String sentenceText)
    {
        return WordSplitter.split(sentenceText, DELIMITERS, true);
    }
    
    private static List split(String sentenceText, char[] delimiters, boolean filterStopWords)
    {
        List wordList = new ArrayList();

        if (delimiters != null && delimiters.length > 0)
        {
            for (int idx=0; idx < delimiters.length; idx++)
            {
                while (true)
                {
                    int delimiterOffset = sentenceText.indexOf(delimiters[idx]);
                    if (delimiterOffset < 0)
                    {
                        break;
                    }
                    else
                    {
                        sentenceText = sentenceText.substring(0, delimiterOffset) + " " +  sentenceText.substring(delimiterOffset+1);
                    }
                }
            }
        }
        
        String words[] = sentenceText.split(" ");
        
        
        if (words != null && words.length > 0)
        {   
            for (int idx=0; idx < words.length; idx++)
            {
                String wordNormalized = WordSplitter.stripPunctuation(words[idx].trim());
                
                if (wordNormalized.length() > 0)
                {
                    if (WordSplitter.isNumeric(wordNormalized))
                        wordList.add("__NUMERIC_VALUE__");
                    else if (!StopWordManager.isStopWord(wordNormalized))
                        wordList.add(wordNormalized);
                }
            }
        }
        
        return wordList;
    }
    
    private static String stripPunctuation(String value)
    {
        if (value == null || value.length() == 0)
            return value;
        
        StringBuffer sb = new StringBuffer(value.length());
        
        char valueChars[] = value.toCharArray();
        for (int idx=0; idx < valueChars.length; idx++)
        {
            char ch = valueChars[idx];
            if (Character.isLetter(ch) || Character.isDigit(ch))
                sb.append(valueChars[idx]);
        }
        
        return sb.toString();
    }
    
    private static boolean isNumeric(String value)
    {
        if (value == null || value.length() == 0)
            return false;
        
        char valueChars[] = value.toCharArray();
        for (int idx=0; idx < valueChars.length; idx++)
        {
            char ch = valueChars[idx];
            
            if (!Character.isDigit(ch) && !(ch == '.') && !(ch == ','))
                return false;
        }
        
        return true;
    }
    
}
