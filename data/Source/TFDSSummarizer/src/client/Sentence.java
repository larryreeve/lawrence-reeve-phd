package client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public final class Sentence implements IsSerializable
{
    private String  sentenceTextValue       = "";
    private int     sectionNumberValue      = 0;
    private int     sentenceNumberValue     = 0;
    private double  scoreValue              = 0.0;  
    
    
    public double getScore()
    {
        return this.scoreValue;
    }

    public void setScore(double value)
    {
        this.scoreValue = value;
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
