@echo off

:SETENV
  set UMLS_HOME=f:\umls
  set DATA_HOME=f:\data
  set RELEASE_HOME=F:\release\BinaryDistribution\v1\summann

  echo.
  echo Environment settings:
  echo   UMLS_HOME=%UMLS_HOME%
  echo   DATA_HOME=%DATA_HOME%
  echo   RELEASE_HOME=%RELEASE_HOME%
  echo.

:START
  java -cp "%UMLS_HOME%\mmtx\nls\mmtx\config;%UMLS_HOME%\mmtx\nls\mmtx\lib\mmtx.jar;%UMLS_HOME%\mmtx\nls\mmtx\lib\mmtxProject.jar;%UMLS_HOME%\mmtx\nls\mmtx\lib\util.jar;%RELEASE_HOME%\commons-collections-3.2.jar;%RELEASE_HOME%\commons-cli-1.0.jar;%RELEASE_HOME%\biocommon.jar;%RELEASE_HOME%\bioannotator.jar" -ms512m -mx1600m bioannotator.BioAnnotatorMain  %*%
