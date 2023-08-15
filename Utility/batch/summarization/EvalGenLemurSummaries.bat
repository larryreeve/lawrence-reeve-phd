@echo off
if "%1%" == "" goto ERROR
goto Index

:BuildDB
  rem Build database of fulltext articles
  call biochain.bat -docid 0002 -inputfilefull data\input\0002\0002-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=true
  call biochain.bat -docid 0013 -inputfilefull data\input\0013\0013-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false
  call biochain.bat -docid 0162 -inputfilefull data\input\0162\0162-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false 
  call biochain.bat -docid 0234 -inputfilefull data\input\0234\0234-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false
  call biochain.bat -docid 0782 -inputfilefull data\input\0782\0782-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false
  call biochain.bat -docid 0786 -inputfilefull data\input\0786\0786-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false
  call biochain.bat -docid 0787 -inputfilefull data\input\0787\0787-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false
  call biochain.bat -docid 0811 -inputfilefull data\input\0811\0811-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false
  call biochain.bat -docid 0814 -inputfilefull data\input\0814\0814-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false
  call biochain.bat -docid 0821 -inputfilefull data\input\0821\0821-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false
  call biochain.bat -docid 0954 -inputfilefull data\input\0954\0954-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false
  call biochain.bat -docid 1001 -inputfilefull data\input\1001\1001-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false
  call biochain.bat -docid 1108 -inputfilefull data\input\1108\1108-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false
  call biochain.bat -docid 1110 -inputfilefull data\input\1110\1110-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false
  call biochain.bat -docid 1111 -inputfilefull data\input\1111\1111-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false
  call biochain.bat -docid 1115 -inputfilefull data\input\1115\1115-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false
  call biochain.bat -docid 1117 -inputfilefull data\input\1117\1117-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false
  call biochain.bat -docid 1118 -inputfilefull data\input\1118\1118-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false
  call biochain.bat -docid 1122 -inputfilefull data\input\1122\1122-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false
  call biochain.bat -docid 1132 -inputfilefull data\input\1132\1132-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false
  call biochain.bat -docid 1197 -inputfilefull data\input\1197\1197-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false
  call biochain.bat -docid 3563 -inputfilefull data\input\3563\3563-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false
  call biochain.bat -docid 4016 -inputfilefull data\input\4016\4016-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false
  call biochain.bat -docid 4017 -inputfilefull data\input\4017\4017-Article-A.txt -outputtype lemur -outputfile data\Lemur\LemurAllFiles.txt -outputoptions overwrite=false


:Index
  rem Index the fulltext articles
  ..\summarizers\lemur\bin\buildindex data\Lemur\Params\LemurIndexParam.txt data\Lemur\LemurAllFiles.txt

:GenParamFiles
  call biochain.bat -docid 0002 -inputfilefull data\input\0002\0002-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-0002.txt -outputoptions compressionrate=%1
  call biochain.bat -docid 0013 -inputfilefull data\input\0013\0013-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-0013.txt -outputoptions compressionrate=%1
  call biochain.bat -docid 0162 -inputfilefull data\input\0162\0162-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-0162.txt -outputoptions compressionrate=%1 
  call biochain.bat -docid 0234 -inputfilefull data\input\0234\0234-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-0234.txt -outputoptions compressionrate=%1
  call biochain.bat -docid 0782 -inputfilefull data\input\0782\0782-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-0782.txt -outputoptions compressionrate=%1
  call biochain.bat -docid 0786 -inputfilefull data\input\0786\0786-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-0786.txt -outputoptions compressionrate=%1
  call biochain.bat -docid 0787 -inputfilefull data\input\0787\0787-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-0787.txt -outputoptions compressionrate=%1
  call biochain.bat -docid 0811 -inputfilefull data\input\0811\0811-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-0811.txt -outputoptions compressionrate=%1
  call biochain.bat -docid 0814 -inputfilefull data\input\0814\0814-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-0814.txt -outputoptions compressionrate=%1
  call biochain.bat -docid 0821 -inputfilefull data\input\0821\0821-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-0821.txt -outputoptions compressionrate=%1
  call biochain.bat -docid 0954 -inputfilefull data\input\0954\0954-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-0954.txt -outputoptions compressionrate=%1
  call biochain.bat -docid 1001 -inputfilefull data\input\1001\1001-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-1001.txt -outputoptions compressionrate=%1
  call biochain.bat -docid 1108 -inputfilefull data\input\1108\1108-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-1108.txt -outputoptions compressionrate=%1
  call biochain.bat -docid 1110 -inputfilefull data\input\1110\1110-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-1110.txt -outputoptions compressionrate=%1
  call biochain.bat -docid 1111 -inputfilefull data\input\1111\1111-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-1111.txt -outputoptions compressionrate=%1
  call biochain.bat -docid 1115 -inputfilefull data\input\1115\1115-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-1115.txt -outputoptions compressionrate=%1
  call biochain.bat -docid 1117 -inputfilefull data\input\1117\1117-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-1117.txt -outputoptions compressionrate=%1
  call biochain.bat -docid 1118 -inputfilefull data\input\1118\1118-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-1118.txt -outputoptions compressionrate=%1
  call biochain.bat -docid 1122 -inputfilefull data\input\1122\1122-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-1122.txt -outputoptions compressionrate=%1
  call biochain.bat -docid 1132 -inputfilefull data\input\1132\1132-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-1132.txt -outputoptions compressionrate=%1
  call biochain.bat -docid 1197 -inputfilefull data\input\1197\1197-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-1197.txt -outputoptions compressionrate=%1
  call biochain.bat -docid 3563 -inputfilefull data\input\3563\3563-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-3563.txt -outputoptions compressionrate=%1
  call biochain.bat -docid 4016 -inputfilefull data\input\4016\4016-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-4016.txt -outputoptions compressionrate=%1
  call biochain.bat -docid 4017 -inputfilefull data\input\4017\4017-Article-A.txt -outputtype LemurParam -outputfile data\Lemur\Params\LemurSummParam-4017.txt -outputoptions compressionrate=%1


:SummBasic
  rem Summarize each paper using Basic
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-0002.txt > data\output\0002\0002-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-0013.txt > data\output\0013\0013-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-0162.txt > data\output\0162\0162-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-0234.txt > data\output\0234\0234-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-0782.txt > data\output\0782\0782-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-0786.txt > data\output\0786\0786-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-0787.txt > data\output\0787\0787-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-0811.txt > data\output\0811\0811-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-0814.txt > data\output\0814\0814-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-0821.txt > data\output\0821\0821-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-0954.txt > data\output\0954\0954-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-1001.txt > data\output\1001\1001-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-1108.txt > data\output\1108\1108-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-1110.txt > data\output\1110\1110-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-1111.txt > data\output\1111\1111-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-1115.txt > data\output\1115\1115-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-1117.txt > data\output\1117\1117-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-1118.txt > data\output\1118\1118-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-1122.txt > data\output\1122\1122-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-1132.txt > data\output\1132\1132-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-1197.txt > data\output\1197\1197-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-3563.txt > data\output\3563\3563-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-4016.txt > data\output\4016\4016-ArticleSummary_20pct_LemurBasic.txt
  ..\summarizers\lemur\bin\BasicSummApp data\Lemur\Params\LemurSummParam-4017.txt > data\output\4017\4017-ArticleSummary_20pct_LemurBasic.txt

:SummMMR
  rem Summarize each paper using MMR
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-0002.txt > data\output\0002\0002-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-0013.txt > data\output\0013\0013-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-0162.txt > data\output\0162\0162-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-0234.txt > data\output\0234\0234-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-0782.txt > data\output\0782\0782-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-0786.txt > data\output\0786\0786-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-0787.txt > data\output\0787\0787-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-0811.txt > data\output\0811\0811-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-0814.txt > data\output\0814\0814-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-0821.txt > data\output\0821\0821-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-0954.txt > data\output\0954\0954-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-1001.txt > data\output\1001\1001-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-1108.txt > data\output\1108\1108-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-1110.txt > data\output\1110\1110-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-1111.txt > data\output\1111\1111-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-1115.txt > data\output\1115\1115-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-1117.txt > data\output\1117\1117-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-1118.txt > data\output\1118\1118-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-1122.txt > data\output\1122\1122-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-1132.txt > data\output\1132\1132-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-1197.txt > data\output\1197\1197-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-3563.txt > data\output\3563\3563-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-4016.txt > data\output\4016\4016-ArticleSummary_20pct_LemurMMR.txt
  ..\summarizers\lemur\bin\MMRSummApp data\Lemur\Params\LemurSummParam-4017.txt > data\output\4017\4017-ArticleSummary_20pct_LemurMMR.txt


:SummBasicSPL
  copy data\output\0002\0002-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\0002-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\0013\0013-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\0013-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\0162\0162-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\0162-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\0234\0234-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\0234-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\0782\0782-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\0782-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\0786\0786-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\0786-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\0787\0787-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\0787-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\0811\0811-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\0811-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\0814\0814-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\0814-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\0821\0821-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\0821-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\0954\0954-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\0954-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\1001\1001-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\1001-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\1108\1108-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\1108-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\1110\1110-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\1110-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\1111\1111-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\1111-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\1115\1115-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\1115-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\1117\1117-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\1117-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\1118\1118-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\1118-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\1122\1122-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\1122-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\1132\1132-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\1132-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\1197\1197-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\1197-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\3563\3563-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\3563-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\4016\4016-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\4016-ArticleSummary_%1pct_LemurBasic.spl
  copy data\output\4017\4017-ArticleSummary_%1pct_LemurBasic.txt data\eval\rouge\duist\systems\4017-ArticleSummary_%1pct_LemurBasic.spl

:SummMMRSPL
  copy data\output\0002\0002-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\0002-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\0013\0013-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\0013-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\0162\0162-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\0162-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\0234\0234-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\0234-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\0782\0782-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\0782-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\0786\0786-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\0786-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\0787\0787-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\0787-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\0811\0811-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\0811-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\0814\0814-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\0814-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\0821\0821-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\0821-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\0954\0954-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\0954-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\1001\1001-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\1001-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\1108\1108-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\1108-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\1110\1110-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\1110-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\1111\1111-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\1111-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\1115\1115-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\1115-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\1117\1117-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\1117-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\1118\1118-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\1118-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\1122\1122-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\1122-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\1132\1132-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\1132-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\1197\1197-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\1197-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\3563\3563-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\3563-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\4016\4016-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\4016-ArticleSummary_%1pct_LemurMMR.spl
  copy data\output\4017\4017-ArticleSummary_%1pct_LemurMMR.txt data\eval\rouge\duist\systems\4017-ArticleSummary_%1pct_LemurMMR.spl
 
:END