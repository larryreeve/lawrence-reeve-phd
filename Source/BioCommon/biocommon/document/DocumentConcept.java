/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biocommon.document;

import java.io.*;

public class DocumentConcept 
	implements Serializable
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT           = biocommon.copyright.Copyright.COPYRIGHT;
    private static final long   serialVersionUID    = 1965082495622776140L;

    private String              idValue             = "";
    private String              nameValue           = "";
    private String              semanticTypeIdValue = "";
	

    public String getId()
	{
		return this.idValue + "";
	}
	
	public void setId(String value)
	{
		this.idValue = value;
	}

	public String getName()
	{
		return this.nameValue + "";
	}
	
	public void setName(String value)
	{
		this.nameValue = value;
	}

	public String getSemanticTypeId()
	{
		return this.semanticTypeIdValue + "";
	}
	
	public void setSemanticTypeId(String value)
	{
		this.semanticTypeIdValue = value;
	}

	public DocumentConcept(String id,
				   		   String name,
				           String semanticTypeId)
	{
		this.idValue = id;
		this.nameValue = name;
		this.semanticTypeIdValue = semanticTypeId;
	}
}
