@echo off
java -cp "..\..\summarization\conversion\ConvertToSPL;..\..\summarization\SortWordList\SentenceSplitter" -ms100m -mx800m ConvertToSPL  %1 %2
