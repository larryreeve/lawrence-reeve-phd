package client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ISummarizerServiceAsync
{
    public void summarizeTFDS(String textToSummarize, Integer sourcePctOfSentences, AsyncCallback callback);
}
