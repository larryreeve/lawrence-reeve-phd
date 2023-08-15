cls
cd F:\Utility\batch\summarization
erase /q F:\data\Summarization\Eval\Rouge\duist\systems\*conceptduist*.spl
call EvalGenBioFreqDistSummariesSPLUsingDUIST.bat 20
call EvalGenBioSumBasicSummariesSPLUsingDUIST.bat 20
cd F:\data\Summarization\Eval\Rouge\duist
call evalrouge.bat 24DUISTvsMMTXDiceOnly
cd F:\Utility\batch\summarization
