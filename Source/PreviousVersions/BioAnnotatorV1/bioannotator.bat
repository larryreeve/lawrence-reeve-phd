@echo off
java -cp "C:\Data\BioAnnotator\projectAnnotator\lib\cli\commons-cli-1.0.jar;C:\Data\BioAnnotator\projectAnnotator\dist\bioannotator.jar" -ms100m -mx800m edu.drexelist.bioannotator.annotator  %*%
