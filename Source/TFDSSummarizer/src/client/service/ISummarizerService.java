package client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;

public interface ISummarizerService extends RemoteService 
{
    /**
     * @gwt.typeArgs textToSummarize        <java.lang.String>
     * @gwt.typeArgs sourcePctOfSentences   <java.lang.Integer>
     * @gwt.typeArgs                        <client.Sentence>
     */
    public List summarizeTFDS(String textToSummarize, Integer sourcePctOfSentences);
}
