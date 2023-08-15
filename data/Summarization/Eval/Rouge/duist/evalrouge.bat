@echo off
if "%1" == "" GOTO ERROR


rem set ROUGE_EVAL_HOME=..\RELEASE-1.5.5\data
..\release-1.5.5\ROUGE-1.5.5.pl -n 2 -x -m -2 4 -u -c 95 -r 1000 -f A -p 0.5 -t 0 -e ..\RELEASE-1.5.5\data -a %1.xml > results\%1.txt
rem set ROUGE_EVAL_HOME=
type results\%1.txt
GOTO END

:ERROR
  echo.
  echo.
  echo ERROR: Configuration file must be specified
  echo.
  echo.

:END

