if "%UMLS_HOME%1" == "1" goto SETENV
goto START

:SETENV
  set UMLS_HOME=f:\umls
  set DATA_HOME=f:\data
  set RELEASE_HOME=f:\source\release

  echo.
  echo Environment settings:
  echo   UMLS_HOME=%UMLS_HOME%
  echo   DATA_HOME=%DATA_HOME%
  echo   RELEASE_HOME=%RELEASE_HOME%
  echo.

:START
  call duc2007.bat -updatepath %DATA_HOME%\DUC\2007\update -docsetid D0703A
  call duc2007.bat -updatepath %DATA_HOME%\DUC\2007\update -docsetid D0706B
  call duc2007.bat -updatepath %DATA_HOME%\DUC\2007\update -docsetid D0711C
  call duc2007.bat -updatepath %DATA_HOME%\DUC\2007\update -docsetid D0716D
  call duc2007.bat -updatepath %DATA_HOME%\DUC\2007\update -docsetid D0721E
  call duc2007.bat -updatepath %DATA_HOME%\DUC\2007\update -docsetid D0726F
  call duc2007.bat -updatepath %DATA_HOME%\DUC\2007\update -docsetid D0727G
  call duc2007.bat -updatepath %DATA_HOME%\DUC\2007\update -docsetid D0736H
  call duc2007.bat -updatepath %DATA_HOME%\DUC\2007\update -docsetid D0740I
  call duc2007.bat -updatepath %DATA_HOME%\DUC\2007\update -docsetid D0743J