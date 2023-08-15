package server.service;

import java.util.List;


import client.service.ISummarizerService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class SummarizerService extends RemoteServiceServlet implements ISummarizerService
{
    private static final long serialVersionUID = 7526472295622776147L;
    
    public List summarizeTFDS(String textToSummarize, Integer sourcePctOfSentences)
    {
        return FreqDistSummarizer.summarize(textToSummarize, sourcePctOfSentences);
    }
}
