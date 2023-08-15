@echo off
java -cp "ConvertMedStudent;..\util\ConvertToSPL;" -ms100m -mx800m ConvertMedStudent  Input.txt Output.txt
cd ..
call ConvertToSpl.bat ConvertMedStudent\Output.txt ConvertMedStudent\Output.txt
cd ConvertMedStudent
copy Output.txt %1

