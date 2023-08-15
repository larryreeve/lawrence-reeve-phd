import java.io.*;
import java.util.*;

class OrderedSentence implements Comparable 
{
	int sentenceIndex = 0;
	
	String sectionType = "";
	
	String sentenceText = "";
	
	public OrderedSentence(int sentenceIndex, String sectionType, String sentenceText) 
	{
		this.sentenceIndex = sentenceIndex;
		this.sectionType = sectionType;
		this.sentenceText = sentenceText;
	}
	
	public int compareTo(Object anotherOrderedSentence) throws ClassCastException 
	{
		if (!(anotherOrderedSentence instanceof OrderedSentence))
			throw new ClassCastException("An OrderedSentence object expected.");
	    
	    return this.sentenceIndex - ((OrderedSentence) anotherOrderedSentence).sentenceIndex;    
	}
}
