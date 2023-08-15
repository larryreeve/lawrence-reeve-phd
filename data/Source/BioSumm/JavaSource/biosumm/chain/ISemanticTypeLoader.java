/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biosumm.chain;

import java.util.*;


/**
 * Interface for loading semantic types
 * 
 *
 */
public interface ISemanticTypeLoader
{
	public List<SemanticType> loadFromFile(String filename)
		throws Exception;
}
