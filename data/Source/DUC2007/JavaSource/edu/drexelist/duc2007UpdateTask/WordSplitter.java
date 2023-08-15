package edu.drexelist.duc2007UpdateTask;

import java.util.*;

public class WordSplitter 
{
	public static List<String> splitWithStopWords(String sentenceText)
	{
		String words[] = sentenceText.split(" ");
		
		List<String> wordList = new ArrayList<String>();
		
		if (words != null && words.length > 0)
		{	
			for (String word : words)
			{
				String wordNormalized = word.trim().toLowerCase();
				
				if (wordNormalized.length() > 0)
				{
					if (!StopWordManager.isStopWord(wordNormalized))
						wordList.add(wordNormalized);
				}
			}
		}
		
		return wordList;
	}
}
