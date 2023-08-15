package client.splitters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import client.freqdist.Sentence;

public class SentenceSplitter 
{
	private static Map m_abbreviations = new HashMap(); 
	
	static 
	{
		m_abbreviations.put("al.",        null);
		m_abbreviations.put("Apr.",       null);
		m_abbreviations.put("Aug.",       null);
		m_abbreviations.put("co.",        null);
		m_abbreviations.put("Dec.",       null);
		m_abbreviations.put("Dr.",        null);
		m_abbreviations.put("Drs.",       null);
		m_abbreviations.put("Feb.",       null);
		m_abbreviations.put("e.",         null);
		m_abbreviations.put("e.g.",       null);
		m_abbreviations.put("fig.",       null);
		m_abbreviations.put("Fig.",       null);
		m_abbreviations.put("fl.",        null);
		m_abbreviations.put("i.",         null);
		m_abbreviations.put("i.e.",       null);
		m_abbreviations.put("Jan.",       null);
		m_abbreviations.put("Jr.",        null);
		m_abbreviations.put("Jul.",       null);
		m_abbreviations.put("Jun.",       null);
		m_abbreviations.put("m.", 		  null);
		m_abbreviations.put("Mar.",       null);
		m_abbreviations.put("Mr.",        null);
		m_abbreviations.put("Mrs.",       null);
		m_abbreviations.put("non.",       null);
		m_abbreviations.put("Nov.",       null);
		m_abbreviations.put("Oct.",       null);
		m_abbreviations.put("oz.",        null);
		m_abbreviations.put("pl.",        null);
		m_abbreviations.put("Rep.",       null);
		m_abbreviations.put("Sens.",      null);
		m_abbreviations.put("Sep.",       null);
		m_abbreviations.put("vs.",        null);
	}

	public static List split(String textToSplit)
	{
		List sentences = new ArrayList();
		
		if (textToSplit == null || textToSplit.length() == 0)
			return sentences;
		
		// Convert string to character array
		char textToSplitChars[] = textToSplit.toCharArray();
		
		// Find sentences
		int sentenceNumber = 0;
        int sectionNumber = 0;
        StringBuffer sentence = new StringBuffer();
        StringBuffer word = new StringBuffer();
        int textToSplitIndex = 0;
        
		while (textToSplitIndex < textToSplitChars.length)
		{
			boolean isEOS = true;
			
			char ch = textToSplitChars[textToSplitIndex];
			
			if (ch == '.')
			{
				word.append(ch);
				
				if (word.length() > 0)
				{
					if (m_abbreviations.containsKey(stripNonAlphaNum(word.toString())))
						isEOS = false;
					
					if ((textToSplitIndex + 1) < textToSplitChars.length)
					{
					    if (Character.isDigit(textToSplitChars[textToSplitIndex+1]))
					        isEOS = false;        
					}
				}
			}
			else if (ch == '?')
			{
			}
			else if (ch == '!')
			{
			}
			else if (ch == '\r')
			{
				// Skip (for now)
			}
			else if (ch == '\n')
			{
			    sentence.append(" ");
			}
			else if (ch == ' ' || ch == '\t')
			{
				sentence.append(" ");
				sentence.append(word);
				word.setLength(0);
				isEOS = false;
			}
			else
			{
				word.append(ch);
				isEOS = false;
			}
			
			if (isEOS)
			{
				if (word.length() > 0)
				{
					sentence.append(" ");
					sentence.append(word);
				}
				
				String sentenceValue = sentence.toString().trim();
				if (sentenceValue.length() > 0)
				{
				    sentenceNumber++;
				    sentences.add(new Sentence(sentenceValue, sentenceNumber, sectionNumber));
				}
				
				word.setLength(0);
				sentence.setLength(0);
			}
			
			textToSplitIndex++;
		}
		
		return sentences;
	}
	
	private static String stripNonAlphaNum(String value)
	{
	    if (value == null || value.length() == 0)
	        return value;
	    
	    StringBuffer sb = new StringBuffer(value.length());
	    
	    char valueChars[] = value.toCharArray();
	    for (int idx=0; idx < valueChars.length; idx++)
	    {
	        char ch = valueChars[idx];
	        if (Character.isLetter(ch) || Character.isDigit(ch) || (ch == '.'))
	            sb.append(valueChars[idx]);
	    }
	    
	    return sb.toString();
	}
}
