/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator.duist;

import java.util.List;

public interface IConceptMapper
{
    String getName();
    
    void initialize();
    
    List<Integer> map(List<SourcePhraseWord> sourcePhraseWords, List<CandidatePhrase> candidatePhraseItems);
}
