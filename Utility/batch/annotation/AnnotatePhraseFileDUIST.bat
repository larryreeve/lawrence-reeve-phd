call ..\setenv.bat
call ..\bioannotator.bat -annotator duist -phrasefile %DATA_HOME%\Annotation\Input\24PaperCorpus-AllUniquePhrasesWithOneConcept.txt -outputfile %DATA_HOME%\Annotation\Output\DUIST-AllUniquePhrasesWithOneConcept.txt
rem call ..\bioannotator.bat -annotator duist -phrasefile %DATA_HOME%\Annotation\Input\24PaperCorpus-AllUniquePhrases.txt -outputfile %DATA_HOME%\Annotation\Output\DUIST-AllUniquePhrases.txt

