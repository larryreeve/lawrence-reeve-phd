package edu.drexelist.duc2007UpdateTask;

import java.io.*;
import java.util.*;

public class StopWordManager 
{
	private static Map<String, String> m_stopwords = new HashMap<String, String>();
	

	static
	{
	    File stopWordsFile = new File("stopwords.txt");
	    if (stopWordsFile.exists())
	    {
		    BufferedReader textFileReader = null;
	
		    try
		    {
			    textFileReader = new BufferedReader(new FileReader(stopWordsFile));
	
			    String line = null;
			    while ((line = textFileReader.readLine()) != null)
			    {		
				    if (!line.startsWith("#"))
				    {
					    String normalizedWord =line.trim().toLowerCase(); 
					    if (!m_stopwords.containsKey(normalizedWord))
						    m_stopwords.put(normalizedWord, null);
				    }
			    }
		    }
		    catch(Exception e)
		    {
			    System.err.println("Error loading stopwords: " + e.getMessage());
		    }
		    finally 
		    {
			    try 
			    {
				    if (textFileReader!= null) 
    					textFileReader.close();
	    		}
		    	catch(Exception e) {} 
		    }
	    }
	    else
	    {
            m_stopwords.put("-",                null);
            m_stopwords.put("a",                null);
            m_stopwords.put("about",            null);
            m_stopwords.put("abs",              null);
            m_stopwords.put("accordingly",      null);
            m_stopwords.put("affected",         null);
            m_stopwords.put("affecting",        null);
            m_stopwords.put("after",            null);
            m_stopwords.put("again",        null);
            m_stopwords.put("against",      null);
            m_stopwords.put("all",          null);
            m_stopwords.put("almost",       null);
            m_stopwords.put("already",      null);
            m_stopwords.put("also",         null);
            m_stopwords.put("although",     null);
            m_stopwords.put("always",       null);
            m_stopwords.put("among",        null);
            m_stopwords.put("an",           null);
            m_stopwords.put("and",          null);
            m_stopwords.put("any",          null);
            m_stopwords.put("anyone",       null);
            m_stopwords.put("apparently",   null);
            m_stopwords.put("are",          null);
            m_stopwords.put("arise",        null);
            m_stopwords.put("as",           null);
            m_stopwords.put("aside",        null);
            m_stopwords.put("at",           null);
            m_stopwords.put("away",         null);
            m_stopwords.put("be",           null);
            m_stopwords.put("became",       null);
            m_stopwords.put("because",      null);
            m_stopwords.put("become",       null);
            m_stopwords.put("becomes",      null);
            m_stopwords.put("been",         null);
            m_stopwords.put("before",       null);
            m_stopwords.put("being",        null);
            m_stopwords.put("between",      null);
            m_stopwords.put("beyond",       null);
            m_stopwords.put("both",         null);
            m_stopwords.put("briefly",      null);
            m_stopwords.put("but",          null);
            m_stopwords.put("by",           null);
            m_stopwords.put("call",         null);
            m_stopwords.put("called",       null);
            m_stopwords.put("came",         null);
            m_stopwords.put("can",          null);
            m_stopwords.put("cannot",       null);
            m_stopwords.put("certain",      null);
            m_stopwords.put("certainly",    null);
            m_stopwords.put("could",        null);
            m_stopwords.put("does",         null);
            m_stopwords.put("done",         null);
            m_stopwords.put("during",       null);
            m_stopwords.put("each",         null);
            m_stopwords.put("either",       null);
            m_stopwords.put("else",             null);
            m_stopwords.put("end",              null);
            m_stopwords.put("etc",              null);
            m_stopwords.put("ever",             null);
            m_stopwords.put("every",            null);
            m_stopwords.put("fig",              null);
            m_stopwords.put("figure",           null);
            m_stopwords.put("following",        null);
            m_stopwords.put("for",              null);
            m_stopwords.put("found",            null);
            m_stopwords.put("from",             null);
            m_stopwords.put("further",          null);
            m_stopwords.put("gave",             null);
            m_stopwords.put("gets",             null);
            m_stopwords.put("give",             null);
            m_stopwords.put("given",            null);
            m_stopwords.put("giving",           null);
            m_stopwords.put("gone",             null);
            m_stopwords.put("got",              null);
            m_stopwords.put("had",              null);
            m_stopwords.put("hardly",           null);
            m_stopwords.put("has",              null);
            m_stopwords.put("have",             null);
            m_stopwords.put("having",           null);
            m_stopwords.put("he",               null);
            m_stopwords.put("her",              null);
            m_stopwords.put("here",             null);
            m_stopwords.put("his",              null);
            m_stopwords.put("however",          null);
            m_stopwords.put("i",                null);
            m_stopwords.put("if",               null);
            m_stopwords.put("in",               null);
            m_stopwords.put("into",             null);
            m_stopwords.put("is",               null);
            m_stopwords.put("it",               null);
            m_stopwords.put("its",              null);
            m_stopwords.put("itself",           null);
            m_stopwords.put("just",             null);
            m_stopwords.put("keep",             null);
            m_stopwords.put("kept",             null);
            m_stopwords.put("largely",          null);
            m_stopwords.put("like",             null);
            m_stopwords.put("made",             null);
            m_stopwords.put("mainly",           null);
            m_stopwords.put("make",             null);
            m_stopwords.put("many",             null);
            m_stopwords.put("may",              null);
            m_stopwords.put("might",            null);
            m_stopwords.put("more",             null);
            m_stopwords.put("moreover",         null);
            m_stopwords.put("most",             null);
            m_stopwords.put("mostly",           null);
            m_stopwords.put("much",             null);
            m_stopwords.put("must",             null);
            m_stopwords.put("nearly",           null);
            m_stopwords.put("necessarily",      null);
            m_stopwords.put("neither",          null);
            m_stopwords.put("next",             null);
            m_stopwords.put("non",              null);
            m_stopwords.put("none",             null);
            m_stopwords.put("nor",              null);
            m_stopwords.put("normally",         null);
            m_stopwords.put("not",              null);
            m_stopwords.put("noted",            null);
            m_stopwords.put("now",              null);
            m_stopwords.put("obtain",           null);
            m_stopwords.put("obtained",         null);
            m_stopwords.put("of",               null);
            m_stopwords.put("off",              null);
            m_stopwords.put("often",            null);
            m_stopwords.put("on",               null);
            m_stopwords.put("only",             null);
            m_stopwords.put("or",               null);
            m_stopwords.put("other",            null);
            m_stopwords.put("our",              null);
            m_stopwords.put("ours",             null);
            m_stopwords.put("out",              null);
            m_stopwords.put("owing",            null);
            m_stopwords.put("particularly",     null);
            m_stopwords.put("past",             null);
            m_stopwords.put("per",              null);
            m_stopwords.put("perhaps",          null);
            m_stopwords.put("please",           null);
            m_stopwords.put("poorly",           null);
            m_stopwords.put("possible",         null);
            m_stopwords.put("possibly",         null);
            m_stopwords.put("potentially",      null);
            m_stopwords.put("predominantly",    null);
            m_stopwords.put("present",          null);
            m_stopwords.put("previously",       null);
            m_stopwords.put("primarily",        null);
            m_stopwords.put("probably",         null);
            m_stopwords.put("prompt",           null);
            m_stopwords.put("promptly",         null);
            m_stopwords.put("put",              null);
            m_stopwords.put("quickly",          null);
            m_stopwords.put("quite",            null);
            m_stopwords.put("rather",           null);
            m_stopwords.put("readily", null);
            m_stopwords.put("really", null);
            m_stopwords.put("recently", null);
            m_stopwords.put("refs", null);
            m_stopwords.put("regarding", null);
            m_stopwords.put("regardless", null);
            m_stopwords.put("relatively", null);
            m_stopwords.put("respectively", null);
            m_stopwords.put("resulted", null);
            m_stopwords.put("resulting", null);
            m_stopwords.put("results", null);
            m_stopwords.put("said", null);
            m_stopwords.put("same", null);
            m_stopwords.put("seem", null);
            m_stopwords.put("seen", null);
            m_stopwords.put("several", null);
            m_stopwords.put("shall", null);
            m_stopwords.put("should", null);
            m_stopwords.put("show", null);
            m_stopwords.put("showed", null);
            m_stopwords.put("shown", null);
            m_stopwords.put("shows", null);
            m_stopwords.put("significantly", null);
            m_stopwords.put("similar", null);
            m_stopwords.put("similarly", null);
            m_stopwords.put("since", null);
            m_stopwords.put("slightly", null);
            m_stopwords.put("so", null);
            m_stopwords.put("some", null);
            m_stopwords.put("sometime", null);
            m_stopwords.put("somewhat", null);
            m_stopwords.put("soon", null);
            m_stopwords.put("specifically", null);
            m_stopwords.put("state", null);
            m_stopwords.put("states", null);
            m_stopwords.put("still", null);
            m_stopwords.put("strongly", null);
            m_stopwords.put("substantially", null);
            m_stopwords.put("successfully", null);
            m_stopwords.put("such", null);
            m_stopwords.put("sufficiently", null);
            m_stopwords.put("take", null);
            m_stopwords.put("taken", null);
            m_stopwords.put("than", null);
            m_stopwords.put("that", null);
            m_stopwords.put("the", null);
            m_stopwords.put("their", null);
            m_stopwords.put("theirs", null);
            m_stopwords.put("them", null);
            m_stopwords.put("then", null);
            m_stopwords.put("there", null);
            m_stopwords.put("therefore", null);
            m_stopwords.put("these", null);
            m_stopwords.put("they", null);
            m_stopwords.put("this", null);
            m_stopwords.put("those", null);
            m_stopwords.put("though", null);
            m_stopwords.put("through", null);
            m_stopwords.put("throughout", null);
            m_stopwords.put("thus", null);
            m_stopwords.put("to", null);
            m_stopwords.put("too", null);
            m_stopwords.put("toward", null);
            m_stopwords.put("trailed", null);
            m_stopwords.put("under", null);
            m_stopwords.put("unless", null);
            m_stopwords.put("until", null);
            m_stopwords.put("upon", null);
            m_stopwords.put("use", null);
            m_stopwords.put("used", null);
            m_stopwords.put("useful", null);
            m_stopwords.put("usefully", null);
            m_stopwords.put("usefulness", null);
            m_stopwords.put("using", null);
            m_stopwords.put("usually", null);
            m_stopwords.put("various", null);
            m_stopwords.put("vary", null);
            m_stopwords.put("was", null);
            m_stopwords.put("we", null);
            m_stopwords.put("were", null);
            m_stopwords.put("what", null);
            m_stopwords.put("when", null);
            m_stopwords.put("where", null);
            m_stopwords.put("whereas", null);
            m_stopwords.put("whether", null);
            m_stopwords.put("which", null);
            m_stopwords.put("while", null);
            m_stopwords.put("who", null);
            m_stopwords.put("whose", null);
            m_stopwords.put("why", null);
            m_stopwords.put("widely", null);
            m_stopwords.put("will", null);
            m_stopwords.put("with", null);
            m_stopwords.put("within", null);
            m_stopwords.put("without", null);
            m_stopwords.put("would", null);
            m_stopwords.put("yet", null);
	    }
	}
	
	
	public static boolean isStopWord(String word)
	{
		String normalizedWord = word.trim().toLowerCase();
		
		return (m_stopwords.containsKey(normalizedWord));
	}
}
