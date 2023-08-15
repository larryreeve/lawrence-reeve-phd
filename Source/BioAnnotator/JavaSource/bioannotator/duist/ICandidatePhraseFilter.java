/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator.duist;

import java.util.List;

public interface ICandidatePhraseFilter
{
    String getName();
    
    void initialize();
    
    List<CandidatePhrase> filter(List<SourcePhraseWord> sourcePhraseWords, List<CandidatePhrase> candidatePhraseItems);
}
