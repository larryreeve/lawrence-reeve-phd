package edu.drexelist.duc2007UpdateTask;

import java.util.*;

import com.aliasi.chunk.*;
import com.aliasi.sentences.*;
import com.aliasi.tokenizer.*;


public class SentenceSplitter 
{
    private static final TokenizerFactory   TOKENIZER_FACTORY   = new IndoEuropeanTokenizerFactory();
    private static final SentenceModel      SENTENCE_MODEL      = new IndoEuropeanSentenceModel();
    private static final SentenceChunker    SENTENCE_CHUNKER    = new SentenceChunker(TOKENIZER_FACTORY, SENTENCE_MODEL);

    public static List<Sentence> splitTextIntoSentences(String textToSplit)
    {
        List<Sentence> sentenceList = new ArrayList<Sentence>();
        Chunking chunking = SENTENCE_CHUNKER.chunk(textToSplit.toCharArray(), 0, textToSplit.length());
        Set sentences = chunking.chunkSet();
        String slice = chunking.charSequence().toString();
        
        int sentenceNumber = 1;
        for (Iterator it = sentences.iterator();it.hasNext();) 
        {
            Chunk sentenceChunk = (Chunk)it.next();
            int start = sentenceChunk.start();
            int end = sentenceChunk.end();
            
            String sentenceText = slice.substring(start, end);
            
            sentenceNumber++;
            Sentence newSentence = new Sentence(sentenceText, sentenceNumber);
            sentenceList.add(newSentence);
        }
        
        return sentenceList;
    }
}
  
  