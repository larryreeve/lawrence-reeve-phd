@echo off

:START
  java -cp "%RELEASE_HOME%\lingpipe-2.4.0.jar;%RELEASE_HOME%\commons-cli-1.0.jar;%RELEASE_HOME%\biocommon.jar;%RELEASE_HOME%\duc2007.jar" -ms32m -mx50m edu.drexelist.duc2007UpdateTask.DUCMain  %*%
