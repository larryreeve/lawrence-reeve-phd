@echo off
if "%1%" == "" goto ERROR

echo ---Baseline
call EvalGenBaselineSummariesSPL.bat %1

echo ---BioChain
call EvalGenBioChainSummariesSPL.bat %1

echo ---BioChain Frequency Distribution
call EvalGenBioFreqDistSummariesSPL.bat %1

echo ---SummBasic
call EvalGenBioSumBasicSummariesSPL.bat %1

echo ---MEAD
call EvalGenMEADSummariesSPL.bat %1

echo ---MSWORD
call EvalGenMSWordSummariesSPL.bat %1

echo ---SweSum
call EvalGenSwesumSummariesSPL.bat %1

goto END


:ERROR
  echo.
  echo.
  echo Parameter error. The compression rate must be specified.
  echo.
  echo.

:END