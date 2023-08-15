/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biosumm.evaluate;

import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;

import biocommon.document.Document;
import biosumm.chain.ConceptChain;


public interface IEvaluator 
{
    //  ------------------------------------------------------- Public Methods
	public void evaluate(PrintWriter 		writer,
                         Document			annotatedDocumentFullText,
                         List<ConceptChain> conceptChainListFulltext,
                         Document			annotatedDocumentAbstract,
                         List<ConceptChain> conceptChainListAbstract,
                         Properties 		parameters);
}
