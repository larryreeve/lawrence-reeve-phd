package client.freqdist;

import java.util.ArrayList;
import java.util.List;

import client.splitters.WordSplitter;



public final class Sentence 
{
    private String  sentenceTextValue       = "";
    private int     sectionNumberValue      = 0;
    private int     sentenceNumberValue     = 0;
    private double  scoreValue              = 0.0;  
    private List    wordListValue           = new ArrayList();
    
    
    public double getScore()
    {
        return this.scoreValue;
    }

    public void setScore(double value)
    {
        this.scoreValue = value;
    }

    public List getWords()
    {
        if (this.sentenceTextValue.length() > 0 && this.wordListValue.size() == 0)
        {
            this.wordListValue = WordSplitter.split(this.sentenceTextValue);
        }
        
        return this.wordListValue;
    }

    public int getSectionNumber()
    {
        return this.sectionNumberValue;
    }

    public void setSectionNumber(int value)
    {
        this.sectionNumberValue = value;
    }

    public String getSentenceText()
    {
        return this.sentenceTextValue;
    }

    public void setSentenceText(String value)
    {
        this.sentenceTextValue = value;
        this.wordListValue.clear();
    }

    public int getSentenceNumber()
    {
        return this.sentenceNumberValue;
    }

    public void setSentenceNumber(int value)
    {
        this.sentenceNumberValue = value;
    }


    public Sentence()
    {
        this("", 0, 0);
    }
    
    public Sentence(String  sentenceText,
                    int     sentenceNumber,
                    int     sectionNumber)
    {
        this.sentenceTextValue      = sentenceText;
        this.sentenceNumberValue    = sentenceNumber;
        this.sectionNumberValue     = sectionNumber;
    }
}
