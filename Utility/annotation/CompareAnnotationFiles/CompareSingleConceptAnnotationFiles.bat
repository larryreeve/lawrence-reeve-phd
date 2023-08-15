call ..\..\batch\setenv.bat
java CompareSingleConceptAnnotationFiles %DATA_HOME%\Annotation\Input\24PaperCorpus-AllUniquePhrasesWithOneConcept.txt %DATA_HOME%\Annotation\Output\DUIST-AllUniquePhrasesWithOneConcept.txt %DATA_HOME%\Annotation\Output\DUIST-AllUniquePhrasesWithOneConceptNoMatch.txt
rem java CompareSingleConceptAnnotationFiles %DATA_HOME%\Annotation\Input\24PaperCorpus-AllUniquePhrases.txt %DATA_HOME%\Annotation\Output\DUIST-AllUniquePhrases.txt %DATA_HOME%\Annotation\Output\DUIST-AllUniquePhrasesNoMatch.txt
rem java CompareSingleConceptAnnotationFiles %DATA_HOME%\Annotation\Input\24PaperCorpus-AllUniquePhrases.txt %DATA_HOME%\Annotation\Output\DUIST-AllUniquePhrases.txt %DATA_HOME%\Annotation\Output\DUIST-AllUniquePhrasesNoMatch.txt
