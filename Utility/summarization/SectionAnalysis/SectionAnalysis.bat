@echo off
set UMLS_HOME=f:\umls
set DATA_HOME=f:\data
set RELEASE_HOME=f:\source\release

echo.
echo Environment settings:
echo   UMLS_HOME=%UMLS_HOME%
echo   DATA_HOME=%DATA_HOME%
echo   RELEASE_HOME=%RELEASE_HOME%
echo.

javac OrderedSentence.java OrderedSentenceFileReader.java SectionAnalysis.java 

java -cp .\ SectionAnalysis