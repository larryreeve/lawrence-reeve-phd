@echo off
if "%1%" == "" goto ERROR

call ..\setenv.bat

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\0002\0002-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\0002-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\0002\0002-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\0002-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\0013\0013-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\0013-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\0013\0013-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\0013-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\0162\0162-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\0162-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\0162\0162-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\0162-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true 

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\0234\0234-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\0234-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\0234\0234-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\0234-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\0782\0782-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\0782-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\0782\0782-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\0782-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\0786\0786-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\0786-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\0786\0786-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\0786-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\0787\0787-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\0787-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\0787\0787-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\0787-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\0811\0811-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\0811-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\0811\0811-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\0811-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\0814\0814-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\0814-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\0814\0814-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\0814-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\0821\0821-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\0821-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\0821\0821-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\0821-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\0954\0954-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\0954-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\0954\0954-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\0954-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\1001\1001-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\1001-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\1001\1001-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\1001-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\1108\1108-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\1108-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\1108\1108-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\1108-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\1110\1110-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\1110-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\1110\1110-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\1110-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\1111\1111-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\1111-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\1111\1111-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\1111-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\1115\1115-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\1115-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\1115\1115-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\1115-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\1117\1117-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\1117-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\1117\1117-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\1117-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\1118\1118-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\1118-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\1118\1118-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\1118-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\1122\1122-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\1122-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\1122\1122-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\1122-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\1132\1132-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\1132-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\1132\1132-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\1132-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\1197\1197-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\1197-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\1197\1197-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\1197-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\3563\3563-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\3563-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\3563\3563-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\3563-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\4016\4016-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\4016-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\4016\4016-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\4016-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\4017\4017-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\4017-ArticleSummary_%1pct_BioSumm_SumBasic-Term.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-term -scoringoptions useconcepts=false
call ..\biosumm.bat -annotator mmtx -inputfilefull %DATA_HOME%\summarization\input\4017\4017-Article-A.txt -outputtype summary -outputfile %DATA_HOME%\summarization\eval\rouge\duist\systems\4017-ArticleSummary_%1pct_BioSumm_SumBasic-ConceptMMTX.spl -outputoptions compressionrate=%1;format=spl -scorer sumbasic-concept -scoringoptions useconcepts=true

goto END


:ERROR
  echo.
  echo.
  echo Parameter error. The compression rate must be specified.
  echo Example: GenFreqSummaries 15 to use 15 percent compression
  echo.
  echo.

:END