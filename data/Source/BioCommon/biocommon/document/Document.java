/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biocommon.document;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Document
	implements Serializable
{
    @SuppressWarnings("unused")
    private static final String   COPYRIGHT        = biocommon.copyright.Copyright.COPYRIGHT;
    private static final long     serialVersionUID = 1965082495622776140L;

    private String                docIDValue       = "";
    private String                titleValue       = "";
    private List<DocumentSection> sectionListValue = new ArrayList<DocumentSection>();
    private Map<Integer, String>  spaceBufferCache = new HashMap<Integer, String>();
	

    public List<DocumentSection> getSections()
	{
		return this.sectionListValue;
	}
	
	public String getDocID()
	{
		return this.docIDValue;
	}
	
	public void setDocID(String value)
	{
		this.docIDValue = value;
	}
	
	
	public String getTitle()
	{
		return this.titleValue;
	}
	
	public void setTitle(String value)
	{
		this.titleValue = value;
	}
	
	public void clear()
	{
		this.sectionListValue.clear();
		this.titleValue = "";
	}
	
	public void writeToXMLFile(String outputFilename) throws Exception
	{
	    PrintWriter pw = null;
	
	    try
	    {
	        pw = new PrintWriter(outputFilename);
        
            pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            pw.println("<Sections>");
            for (DocumentSection section : this.sectionListValue)
            {
                pw.println(this.spaces(1) + "<Section number=\"" + section.getSectionNumber() + "\">");
                
                pw.println(this.spaces(2) + "<Sentences>");
                for (DocumentSentence sentence : section.getSentences())
                {
                    pw.println(this.spaces(3) + "<Sentence number=\"" + sentence.getSentenceNumber() + "\">");
                    pw.println(this.spaces(3) + "<![CDATA[ " + sentence.getSentenceText() + "]]>");
                    
                    pw.println(this.spaces(4) + "<Phrases>");
                    for (DocumentPhrase phrase : sentence.getPhrases())
                    {
                        pw.println(this.spaces(5) + "<Phrase>");
                        pw.println(this.spaces(5) + "<![CDATA[ " + phrase.getPhraseText() + "]]>");
                        pw.println(this.spaces(6) + "<PhraseConcepts>");
                        Map<String,DocumentConcept> conceptMap = phrase.getConcepts();
                        for (String conceptId : conceptMap.keySet())
                        {
                            DocumentConcept concept = conceptMap.get(conceptId);
                            pw.println(this.spaces(7) + "<PhraseConcept>");
                            pw.println(this.spaces(8) + "<id>" + concept.getId() + "</id>");
                            pw.println(this.spaces(8) + "<name>" + concept.getName() + "</name>");
                            pw.println(this.spaces(8) + "<semantictypeid>" + concept.getSemanticTypeId() + "</semantictypeid>");
                            pw.println(this.spaces(7) + "</PhraseConcept>");
                        }
                        pw.println(this.spaces(6) + "</PhraseConcepts>");
                        pw.println(this.spaces(5) + "</Phrase>");
                    }
                    pw.println(this.spaces(4) + "</Phrases>");
                    pw.println(this.spaces(3) + "</Sentence>");
                 }
                pw.println(this.spaces(2) + "</Sentences>");
                pw.println(this.spaces(1) + "</Section>");
            }
            pw.println("</Sections>");
	    }
	    catch(Exception e)
	    {
	        System.err.println(e.getMessage());
	        throw e;
	    }
	    finally
	    {
	        if (pw != null)
	        {
	            try
	            {
	                pw.flush();
	                pw.close();
	            }
	            catch(Exception e)
	            {
	                // ignore
	            }
	        }
	    }
	}
	
	public Document(String title)
	{
		this.titleValue = title;
	}
	
	private String spaces(int factor)
	{
	    final int TAB_SIZE = 4;
	    
	    if (factor <= 0)
	        return "";
	    
	    int totalSpaces = (factor * TAB_SIZE);
	    
	    if (!this.spaceBufferCache.containsKey(Integer.valueOf(totalSpaces)))
        {
	        StringBuffer sb = new StringBuffer(totalSpaces);

	        for (int idx=0; idx < totalSpaces; idx++)
	            sb.append(" ");
	    
	        this.spaceBufferCache.put(Integer.valueOf(totalSpaces), sb.toString());
	    }
	    
	    return this.spaceBufferCache.get(Integer.valueOf(totalSpaces));
	}
	
}
