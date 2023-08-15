package edu.drexelist.bioannotator.conceptload;

public class AnnotatorString 
{
	private byte[] stringValue;
	
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
