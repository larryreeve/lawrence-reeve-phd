@echo off
rem 
rem Filtered 
rem 
echo Filtered
call sentencematch data\output\1001\1001-AbstractSummary_25pct_Filtered_BioChain.txt data\output\1001\1001-AbstractSummary_25pct_Copernic.txt	> data\output\1001\1001-SentenceMatchAbstract_25pct_Filtered_Copernic.txt
call sentencematch data\output\1001\1001-AbstractSummary_25pct_Filtered_BioChain.txt data\output\1001\1001-AbstractSummary_25pct_SweSum.txt	> data\output\1001\1001-SentenceMatchAbstract_25pct_Filtered_SweSum.txt
call sentencematch data\output\1001\1001-AbstractSummary_25pct_Filtered_BioChain.txt data\output\1001\1001-AbstractSummary_25pct_Word2002.txt	> data\output\1001\1001-SentenceMatchAbstract_25pct_Filtered_Word2002.txt
call sentencematch data\output\1001\1001-ArticleSummary_25pct_Filtered_BioChain.txt  data\output\1001\1001-ArticleSummary_25pct_Copernic.txt	> data\output\1001\1001-SentenceMatchArticle_25pct_Filtered_Copernic.txt
call sentencematch data\output\1001\1001-ArticleSummary_25pct_Filtered_BioChain.txt  data\output\1001\1001-ArticleSummary_25pct_SweSum.txt	> data\output\1001\1001-SentenceMatchArticle_25pct_Filtered_SweSum.txt
call sentencematch data\output\1001\1001-ArticleSummary_25pct_Filtered_BioChain.txt  data\output\1001\1001-ArticleSummary_25pct_Word2002.txt	> data\output\1001\1001-SentenceMatchArticle_25pct_Filtered_Word2002.txt

call sentencematch data\output\1197\1197-AbstractSummary_25pct_Filtered_BioChain.txt data\output\1197\1197-AbstractSummary_25pct_Copernic.txt	> data\output\1197\1197-SentenceMatchAbstract_25pct_Filtered_Copernic.txt
call sentencematch data\output\1197\1197-AbstractSummary_25pct_Filtered_BioChain.txt data\output\1197\1197-AbstractSummary_25pct_SweSum.txt	> data\output\1197\1197-SentenceMatchAbstract_25pct_Filtered_SweSum.txt
call sentencematch data\output\1197\1197-AbstractSummary_25pct_Filtered_BioChain.txt data\output\1197\1197-AbstractSummary_25pct_Word2002.txt	> data\output\1197\1197-SentenceMatchAbstract_25pct_Filtered_Word2002.txt
call sentencematch data\output\1197\1197-ArticleSummary_25pct_Filtered_BioChain.txt  data\output\1197\1197-ArticleSummary_25pct_Copernic.txt	> data\output\1197\1197-SentenceMatchArticle_25pct_Filtered_Copernic.txt
call sentencematch data\output\1197\1197-ArticleSummary_25pct_Filtered_BioChain.txt  data\output\1197\1197-ArticleSummary_25pct_SweSum.txt	> data\output\1197\1197-SentenceMatchArticle_25pct_Filtered_SweSum.txt
call sentencematch data\output\1197\1197-ArticleSummary_25pct_Filtered_BioChain.txt  data\output\1197\1197-ArticleSummary_25pct_Word2002.txt	> data\output\1197\1197-SentenceMatchArticle_25pct_Filtered_Word2002.txt


rem 
rem Unfiltered 
rem 
echo Unfiltered
call sentencematch data\output\1001\1001-AbstractSummary_25pct_BioChain.txt data\output\1001\1001-AbstractSummary_25pct_Copernic.txt 		> data\output\1001\1001-SentenceMatchAbstract_25pct_Copernic.txt
call sentencematch data\output\1001\1001-AbstractSummary_25pct_BioChain.txt data\output\1001\1001-AbstractSummary_25pct_SweSum.txt 		> data\output\1001\1001-SentenceMatchAbstract_25pct_SweSum.txt
call sentencematch data\output\1001\1001-AbstractSummary_25pct_BioChain.txt data\output\1001\1001-AbstractSummary_25pct_Word2002.txt 		> data\output\1001\1001-SentenceMatchAbstract_25pct_Word2002.txt
call sentencematch data\output\1001\1001-ArticleSummary_25pct_BioChain.txt  data\output\1001\1001-ArticleSummary_25pct_Copernic.txt 		> data\output\1001\1001-SentenceMatchArticle_25pct_Copernic.txt
call sentencematch data\output\1001\1001-ArticleSummary_25pct_BioChain.txt  data\output\1001\1001-ArticleSummary_25pct_SweSum.txt 		> data\output\1001\1001-SentenceMatchArticle_25pct_SweSum.txt
call sentencematch data\output\1001\1001-ArticleSummary_25pct_BioChain.txt  data\output\1001\1001-ArticleSummary_25pct_Word2002.txt		> data\output\1001\1001-SentenceMatchArticle_25pct_Word2002.txt

call sentencematch data\output\1197\1197-AbstractSummary_25pct_BioChain.txt data\output\1197\1197-AbstractSummary_25pct_Copernic.txt 		> data\output\1197\1197-SentenceMatchAbstract_25pct_Copernic.txt
call sentencematch data\output\1197\1197-AbstractSummary_25pct_BioChain.txt data\output\1197\1197-AbstractSummary_25pct_SweSum.txt 		> data\output\1197\1197-SentenceMatchAbstract_25pct_SweSum.txt
call sentencematch data\output\1197\1197-AbstractSummary_25pct_BioChain.txt data\output\1197\1197-AbstractSummary_25pct_Word2002.txt 		> data\output\1197\1197-SentenceMatchAbstract_25pct_Word2002.txt
call sentencematch data\output\1197\1197-ArticleSummary_25pct_BioChain.txt  data\output\1197\1197-ArticleSummary_25pct_Copernic.txt 		> data\output\1197\1197-SentenceMatchArticle_25pct_Copernic.txt
call sentencematch data\output\1197\1197-ArticleSummary_25pct_BioChain.txt  data\output\1197\1197-ArticleSummary_25pct_SweSum.txt 		> data\output\1197\1197-SentenceMatchArticle_25pct_SweSum.txt
call sentencematch data\output\1197\1197-ArticleSummary_25pct_BioChain.txt  data\output\1197\1197-ArticleSummary_25pct_Word2002.txt		> data\output\1197\1197-SentenceMatchArticle_25pct_Word2002.txt
