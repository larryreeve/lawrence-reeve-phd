/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biosumm.filefilter;

import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterTxt 
	implements FilenameFilter
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT        = biocommon.copyright.Copyright.COPYRIGHT;
    

    public boolean accept(File dir, String name) 
	{ 
		return (name.endsWith(".txt") ); 
	};
}
