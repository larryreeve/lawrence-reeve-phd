@echo off
if "%1%" == "" goto ERROR

call util\converttospl.bat data\output\0002\0002-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\0002-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\0013\0013-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\0013-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\0162\0162-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\0162-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\0234\0234-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\0234-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\0782\0782-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\0782-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\0786\0786-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\0786-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\0787\0787-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\0787-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\0811\0811-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\0811-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\0814\0814-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\0814-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\0821\0821-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\0821-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\0954\0954-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\0954-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\1001\1001-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\1001-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\1108\1108-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\1108-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\1110\1110-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\1110-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\1111\1111-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\1111-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\1115\1115-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\1115-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\1117\1117-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\1117-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\1118\1118-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\1118-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\1122\1122-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\1122-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\1132\1132-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\1132-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\1197\1197-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\1197-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\3563\3563-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\3563-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\4016\4016-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\4016-ArticleSummary_%1pct_SweSum.spl
call util\converttospl.bat data\output\4017\4017-ArticleSummary_%1pct_SweSum.txt data\eval\rouge\duist\systems\4017-ArticleSummary_%1pct_SweSum.spl


goto END


:ERROR
  echo.
  echo.
  echo Parameter error. The compression rate must be specified.
  echo.
  echo.

:END