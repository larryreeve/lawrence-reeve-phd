import java.util.*;
//import opennlp.tools.sentdetect.*;

public class SentenceSplitter 
{
	private static Map<String, String> m_acronymsList = new HashMap<String, String>(); 
	
	static
	{
		//
		// List initially taken from the set outlined in:
		// "What is a word, What is a sentence"
		// Problems of Tokenization by G. Grefenstette, P. Tapanainen
		// 
		// http://citeseer.ist.psu.edu/cache/papers/cs/4680/http:zSzzSzwww.mri.mq.edu.auzSzltgzSzintro-to-ltzSzweek02zSzgrefenstette.pdf/grefenstette94what.pdf
		//
		m_acronymsList.clear();
		
		// State and Nation names
		m_acronymsList.put("U.S.", null);
		
		// Titles
		m_acronymsList.put("Mrs.", 		null);
		m_acronymsList.put("Mr.", 		null);
		m_acronymsList.put("Ms.", 		null);
		m_acronymsList.put("Prof.", 	null);
		m_acronymsList.put("Dr.", 		null);
		m_acronymsList.put("Drs.", 		null);
		m_acronymsList.put("Gen.", 		null);
		m_acronymsList.put("Msgr.", 	null);
		m_acronymsList.put("Msgrs.",	null);
		m_acronymsList.put("Rep.", 		null);
		m_acronymsList.put("Sen.", 		null);
		m_acronymsList.put("St.", 		null);
		m_acronymsList.put("Sr.", 		null);
		m_acronymsList.put("Jr.", 		null);
		m_acronymsList.put("Ph.D.", 	null);
		
		// Measurements
		m_acronymsList.put("cf.", 		null);
		m_acronymsList.put("cm.", 		null);
		m_acronymsList.put("cu.", 		null);
		m_acronymsList.put("dia.", 		null);
		m_acronymsList.put("ed.", 		null);
		m_acronymsList.put("cc.", 		null);
		m_acronymsList.put("ft.", 		null);
		m_acronymsList.put("gm.", 		null);
		m_acronymsList.put("hp.", 		null);
		m_acronymsList.put("hr.", 		null);
		m_acronymsList.put("l.", 		null);
		m_acronymsList.put("lb.", 		null);
		m_acronymsList.put("lbs.", 		null);
		m_acronymsList.put("mEq.", 		null);
		m_acronymsList.put("mc.", 		null);
		m_acronymsList.put("mg.", 		null);
		m_acronymsList.put("mil.", 		null);
		m_acronymsList.put("Msec.", 	null);
		m_acronymsList.put("msec.", 	null);
		m_acronymsList.put("ms.", 		null);
		m_acronymsList.put("oz.", 		null);
		m_acronymsList.put("sec.", 		null);
		m_acronymsList.put("yd.", 		null);
		m_acronymsList.put("yr.", 		null);
		m_acronymsList.put("yrs.", 		null);
		

		// Misc. 
		m_acronymsList.put("Assn.", 	null);
		m_acronymsList.put("Av.", 		null);
		m_acronymsList.put("Ave.", 		null);
		m_acronymsList.put("Bldg.", 	null);
		m_acronymsList.put("Cf.", 		null);
		m_acronymsList.put("cf.", 		null);
		m_acronymsList.put("Co.", 		null);
		m_acronymsList.put("Corp.", 	null);
		m_acronymsList.put("Ct.", 		null);
		m_acronymsList.put("Dept.", 	null);
		m_acronymsList.put("Dist.", 	null);
		m_acronymsList.put("e.g.", 		null);
		m_acronymsList.put("Eq.", 		null);
		m_acronymsList.put("eqn.", 		null);
		m_acronymsList.put("eqns.", 	null);
		m_acronymsList.put("etc.", 		null);
		m_acronymsList.put("Fig.", 		null);
		m_acronymsList.put("fig.", 		null);		
		m_acronymsList.put("Figs.", 	null);
		m_acronymsList.put("figs.", 	null);
		m_acronymsList.put("i.e.", 		null);
		m_acronymsList.put("Inc.", 		null);
		m_acronymsList.put("Jas.", 		null);
		m_acronymsList.put("kc.", 		null);		
		m_acronymsList.put("Ltd.", 		null);
		m_acronymsList.put("Mfg.", 		null);
		m_acronymsList.put("min.", 		null);
		m_acronymsList.put("mm.", 		null);		
		m_acronymsList.put("mo.", 		null);
		m_acronymsList.put("mos.", 		null);		
		m_acronymsList.put("Mt.", 		null);
		m_acronymsList.put("Mts.", 		null);
		m_acronymsList.put("No.", 		null);
		m_acronymsList.put("nw.", 		null);
		m_acronymsList.put("Op.", 		null);
		m_acronymsList.put("pl.", 		null);
		m_acronymsList.put("pp.", 		null);		
		m_acronymsList.put("p.", 		null);		
		m_acronymsList.put("prop.", 	null);
		m_acronymsList.put("Rd.", 		null);
		m_acronymsList.put("Rte.", 		null);
		m_acronymsList.put("sq.", 		null);		
		m_acronymsList.put("St.", 		null);
		m_acronymsList.put("Stat.", 	null);
		m_acronymsList.put("Tech.", 	null);
		m_acronymsList.put("USN.", 		null);
		m_acronymsList.put("v.", 		null);
		m_acronymsList.put("var.", 		null);		
		m_acronymsList.put("viz.", 		null);
		m_acronymsList.put("Vol.", 		null);
		m_acronymsList.put("Vs.", 		null);
		m_acronymsList.put("vs.", 		null);		
	}
	
//  public static List<String> splitTextIntoSentences(String textToSplit)
//  throws Exception
//  {
//    List<String> sentenceList = new ArrayList<String>();
//		
//    if (textToSplit == null || textToSplit.length() == 0)
//      return sentenceList;
//      
//    opennlp.tools.sentdetect.EnglishSentenceDetectorME sentSplitter = new opennlp.tools.sentdetect.EnglishSentenceDetectorME("..\\lib\\opennlp\\models\\EnglishSD.bin.gz");
//    
//    String[] sentences = sentSplitter.sentDetect(textToSplit);
//    
//    for (String sentence : sentences)
//    {
//      sentenceList.add(sentence);
//    }
//    
//    return sentenceList;
//  }	
  
	public static List<String> splitTextIntoSentences(String textToSplit)
	{
		List<String> sentenceList = new ArrayList<String>();
		
		if (textToSplit == null || textToSplit.length() == 0)
			return sentenceList;
			
		// Replace other end-of-sentence punctuation with periods
		textToSplit = textToSplit.replace('?', '.');
		textToSplit = textToSplit.replace('!', '.');
		textToSplit = textToSplit.replace('\n', ' ');
		
		int positionOfPeriod = 0;
		int indexStartOfNextSentence = 0;
		int nextSplitPos = 0;
		while ((positionOfPeriod = textToSplit.indexOf(".", nextSplitPos)) >= 0)
		{
			boolean isSentence = true;
			
			// Look backwards for first whitespace
			int positionOfWhitespace = positionOfPeriod;
			while (positionOfWhitespace > 0 && !Character.isWhitespace(textToSplit.charAt(positionOfWhitespace)))
				positionOfWhitespace--;
			
			// Look forward for next period (to capture e.g., i.e., etc)
			int positionOfNextPeriod = positionOfPeriod+1;
			while (positionOfNextPeriod < textToSplit.length() && textToSplit.charAt(positionOfNextPeriod) != '.')
				positionOfNextPeriod++;
			
			// See if token is in list of known acronyms 
			if (positionOfPeriod >= 0)
			{
				// Find tokens like Mr., Dr., etc.
				String tokenBackward = textToSplit.substring(positionOfWhitespace+1, positionOfPeriod+1);
				  tokenBackward = tokenBackward.replace("(", "");
				  tokenBackward = tokenBackward.replace(")", "");
				String tokenForward  = textToSplit.substring(positionOfWhitespace+1, positionOfNextPeriod) + ".";
          tokenForward = tokenForward.replace("(", "");
          tokenForward = tokenForward.replace(")", "");
				
				if (m_acronymsList.containsKey(tokenBackward) ||
					m_acronymsList.containsKey(tokenForward))
					isSentence = false;
				
//				boolean tokenBackwardIsNumeric = true;
//				for (int idx=0; idx < tokenBackward.length(); idx++)
//				{
//					if (!Character.isDigit(tokenBackward.charAt(idx)))
//					{
//						tokenBackwardIsNumeric = false;
//						break;
//					}
//				}
//
//				boolean tokenForwardIsNumeric = true;
//				for (int idx=0; idx < tokenForward.length(); idx++)
//				{
//					if (!Character.isDigit(tokenForward.charAt(idx)))
//					{
//						tokenForwardIsNumeric = false;
//						break;
//					}
//				}
//				
//				if (tokenForwardIsNumeric || tokenBackwardIsNumeric)
//					isSentence = false;

        // Check for digit before period and no digit afterward (e.g. "1997.")
				if (Character.isDigit(textToSplit.charAt(positionOfPeriod-1)))
				{
				  if (positionOfPeriod+1 < textToSplit.length() && Character.isDigit(textToSplit.charAt(positionOfPeriod+1)))
				    isSentence = false;
				}
					

        // Check for digit after period (e.g. ".8")
				if (positionOfPeriod+1 < textToSplit.length() && Character.isDigit(textToSplit.charAt(positionOfPeriod+1)))
					isSentence = false;
			}

			// If end of sentence found, then add it to list
			if (isSentence)
			{
				sentenceList.add(textToSplit.substring(indexStartOfNextSentence, positionOfPeriod).trim());
				indexStartOfNextSentence = positionOfPeriod + 1;
			}
			
			nextSplitPos = positionOfPeriod + 1;
		}
		
		return sentenceList;
	}
}
