/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biosumm.output;

import java.io.*;
import java.util.*;

import biocommon.document.*;
import biosumm.chain.*;


/**
 * Interface for generating output from an annotated document
 * 
 *
 */
public interface IOutputGenerator 
{
    //  ------------------------------------------------------- Public Methods
	public void generate(PrintWriter 		writer,
                         Document			annotatedDocument,
                         List<ConceptChain> conceptChainList,
                         Properties 		parameters);
}
