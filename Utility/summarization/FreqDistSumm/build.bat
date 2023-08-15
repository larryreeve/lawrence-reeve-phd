javac -cp release\lingpipe-2.3.0.jar -d classes src/edu/drexelist/summarizer/Sentence.java src/edu/drexelist/summarizer/SentenceComparatorByScore.java src/edu/drexelist/summarizer/SentenceComparatorBySentenceNumber.java src/edu/drexelist/summarizer/SentenceSplitter.java src/edu/drexelist/summarizer/WordSplitter.java src/edu/drexelist/summarizer/FreqDistSummarizer.java src/edu/drexelist/summarizer/StopWordManager.java src/edu/drexelist/summarizer/FreqDistSummarizer.java
jar cvf release\freqdistsumm.jar -C classes .
jar uvf release\freqdistsumm.jar -C src .
