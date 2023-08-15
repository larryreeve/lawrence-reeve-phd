/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator.conceptload;

public class AnnotatorString 
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT = biocommon.copyright.Copyright.COPYRIGHT;

    private byte[]              stringValue;

    
	public AnnotatorString(String s)
	{
		if (s == null)
			this.stringValue = null;
		else
			this.stringValue = s.getBytes();
	}
	
	public int hashCode()
	{
		if (this.stringValue == null)
			return 0;
		return this.stringValue.hashCode(); 
	}
	
	public int length()
	{
		if (this.stringValue == null)
			return 0;
		
		return this.stringValue.length;
	}
	
	public String toString()
	{
		if (this.stringValue == null)
			return null;
		return new String(this.stringValue);
	}
}
