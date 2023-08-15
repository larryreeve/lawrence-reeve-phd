using System;
using System.Collections;
using System.IO;
using System.Text;

namespace DotNetAnnotator 
{
    public class annotator 
    {
        private static char[]   DELIMITERS = {' ', ',', '-'};

        private IDictionary 	cid2name = new Hashtable(2000000);
        private IDictionary 	pid2cids = new Hashtable(2000000); //
        private IDictionary 	pid2wids = new Hashtable(2000000); ///--
        private IDictionary 	wid2pids = new Hashtable(2000000); //
        private IDictionary 	wordHT   = new Hashtable(2000000); //
        private IList	        stopWordList = new ArrayList();
	

        public static void Main(string[] args) 
        {

            annotator testAnnotator = new annotator();

            testAnnotator.initializeFromMMTX();
//		
//            testAnnotator.initializeStopWords();
//	
//            testAnnotator.annotate(args[0]);
        }
	
        public void annotate(string phrase) 
        {
            StringBuilder rootPhrase = new StringBuilder();
            IList contentWords = new ArrayList();
            IDictionary candidatePhrases = new Hashtable();
		
            phrase = "cancer of the lung";

            // Split phrase into words
            string[] phraseWords = phrase.Split(DELIMITERS);
		
		
            // Remove stop words
            foreach (string word in phraseWords) {
                if (!this.stopWordList.Contains(word))
                    contentWords.Add(word);
            }
		
            if (contentWords.Count == 0) {
                return;
            }
		
            // Build list of candidate phrases
            for (int idxRoot=0; idxRoot < contentWords.Count; idxRoot++) {
                rootPhrase.Length = 0;
			
                for (int idxSubRoot=idxRoot; idxSubRoot < contentWords.Count; idxSubRoot++) {
                    if (rootPhrase.Length > 0)
                        rootPhrase.Append(" ");
                    rootPhrase.Append(contentWords[idxSubRoot]);
				
                    //Console.WriteLine(rootPhrase.toString());
				
                    if (!candidatePhrases.Contains(rootPhrase.ToString()))
                        candidatePhrases.Add(rootPhrase.ToString(), new Double());
                }
            }
		
            // Compute coverage score for each phrase
            foreach (string phraseKey in candidatePhrases.Keys) 
            {
                candidatePhrases.Add(phraseKey, computeCoverageScoreForPhrase(phraseKey));
            }
		
            // Output phrase scores
            Console.WriteLine("Candidate phrase scores: ");
            foreach (string phraseKey in candidatePhrases.Keys) {
                Console.WriteLine(phraseKey + ":" + candidatePhrases[phraseKey]);
            }
        }
	
        public double computeCoverageScoreForPhrase(string phrase) {
            // Get list of terms in phrase
            string[] phraseWords = phrase.Split(DELIMITERS);
		
            // Get list of all phrases having term in it
            IDictionary pidMap = new Hashtable();
            foreach (string phraseWord in phraseWords) {
                int wordId = (int) wordHT[phraseWord];
			
                IList pidList =	(IList) wid2pids[wordId];
			
                if (pidList != null) {
                    foreach (int pid in pidList) {
                        if (!pidMap.Contains(pid))
                            pidMap.Add(pid, null);
                    }
                }
            }
		
            // Compute coverage score for each concept phrase
            foreach (int pid in pidMap.Keys) {
                // Get list of terms in concept phrase
			
                // Concept_phrase: # of terms matching candidate_phrase terms
			
                // Candidate_phrase: # of terms matching concept_phrase
            }

            // Display all phrases w/scores
            Console.WriteLine("\tphrase: " + phrase + " (" + pidMap.Count + ")"); 
            foreach (int pid in pidMap.Keys)
                Console.WriteLine("\t\t" + pid);
		
		
            return 0.1;
        }
	
	
        public void initializeStopWords() 
        {
            StreamReader textFileReader = null;
            try 
            {
                textFileReader = new StreamReader("data\\StopWordsList.txt");
		
                string line = null;
                while ((line = textFileReader.ReadLine()) != null) 
                {		
                    this.stopWordList.Add(line.Trim().ToLower());
                }
            }
            catch(Exception e) {
                Console.WriteLine(e.Message);
            }
            finally {
                try {
                    if (textFileReader!= null) {
                        //	flush and close both "input" and its underlying FileReader
                        textFileReader.Close();
                    }
                }
                catch(Exception e) {} 
            }
        }
	
        public void initializeFromMMTX() 
        {
            // Initialize
            int wordHTId = 0;
		
            cid2name.Clear();
            pid2cids.Clear();
            pid2wids.Clear();
            wid2pids.Clear();
            wordHT.Clear();
		

            // Build concept id to concept name map
            //	cid2name, wordHT
            //
            // 	Input line looks like: 
            //		C0026764|Multiple Myeloma
            StreamReader textFileReader = null;
            try 
            {
                textFileReader = new StreamReader ("data\\cui_concept.txt");
		
                string line = null;
                while ((line = textFileReader.ReadLine()) != null) 
                {
                    string[] fields = line.Split('|');
			
                    if (fields.Length != 2)
                        throw new Exception("Invalid cui_concept.txt format: " + line);
    			
                    try 
                    {
                        int conceptId = Convert.ToInt32(fields[0].Substring(1));
    				
//                        string[] conceptNameWords = fields[1].Split(DELIMITERS);
//                        int[] wordIdList = new int[conceptNameWords.Length];
//                        int wordIdListIndex = 0;
//        				
//                        foreach (string word in conceptNameWords) 
//                        {
//                            if (!wordHT.Contains(word)) 
//                            {
//                                wordHTId++;
//                                wordHT.Add(word, wordHTId);
//                            }
//            				
//                            wordIdListIndex++;
//                        }
            				
                        //Console.WriteLine(line);
                        //Console.WriteLine("\tFieldLen:" + fields.length);
                        //Console.WriteLine("\tF1:'" + fields[0] + "'");
                        //Console.WriteLine("\tF2:'" + fields[1] + "'");
        			
//                        cid2name.Add(conceptId, wordIdList);
                          cid2name.Add(conceptId, fields[1]);
                    }
                    catch(Exception e) 
                    {
                    }
                }
            }
            catch(Exception e) 
            {
                Console.WriteLine(e.Message);
            }
            finally 
            {
                try 
                {
                    if (textFileReader!= null) 
                        textFileReader.Close();
                }
                catch(Exception e) {} 
            }
            Console.WriteLine("1");
            Console.WriteLine("# words in wordHT: " + wordHT.Count);
            Console.WriteLine("# concepts: "        + cid2name.Count);
            Console.WriteLine();
    	
    	
        	
            // Build Phrase-to-Concept map
            // Input line looks like: 
            //		S0000005|C0025362
            int numPhrases = 0;
            int numConcepts = 0;
            int totalChars2 = 0;
            try 
            {
                textFileReader = new StreamReader("data\\sui_cui.txt");
    		
                string line = null;
                while ((line = textFileReader.ReadLine()) != null) 
                {
                    string[] fields = line.Split('|');
    			
                    if (fields.Length != 2)
                        throw new Exception("Invalid sui_cui format: " + line);
        			
                    numPhrases++;
                    int phraseId  = Convert.ToInt32(fields[0].Substring(1));
                    int conceptId = Convert.ToInt32(fields[1].Substring(1));
    			
                    //Console.WriteLine(line);
                    //Console.WriteLine("\tFieldLen:" + fields.length);
                    //Console.WriteLine("\tF1:'" + fields[0] + "'");
                    //Console.WriteLine("\tF2:'" + fields[1] + "'");
        			
                    if (!pid2cids.Contains(phraseId)) 
                    {
                        numConcepts++;
                        IList conceptIdList = new ArrayList();
                        conceptIdList.Add(conceptId);
                        pid2cids.Add(phraseId, conceptIdList);
                    }
                    else 
                    {
                        IList conceptIdList =  (IList) pid2cids[phraseId];
                        conceptIdList.Add(conceptId);
                    }
                }
            }
            finally 
            {
                try 
                {
                    if (textFileReader!= null) 
                        textFileReader.Close();
                }
                catch(Exception e) {} 
            }
            Console.WriteLine("2");
            Console.WriteLine("numPhrases=" + numPhrases);
            Console.WriteLine("numConcepts=" + numConcepts);
            Console.WriteLine("totalChars=" + totalChars2);
            Console.WriteLine();

        	

            // Build terms map and phrase terms map
            //	wordHT, 
            //	S0005246|myeloma|Myeloma
            int totalChars3 = 0;
            try 
            {
                textFileReader = new StreamReader("data\\sui_nmstr_str.txt");
    	
                string line = null;
                while ((line = textFileReader.ReadLine()) != null) 
                {
                    string[] fields = line.Split('|');
    		
                    if (fields.Length != 3)
                        throw new Exception("Invalid sui_nmstr_str format: " + line);
    		
                    //Console.WriteLine(line);
                    //Console.WriteLine("\tC:" + fields.length);
                    //Console.WriteLine("\tF1:'" + fields[0] + "'");
                    //Console.WriteLine("\tF2:'" + fields[1] + "'");
                    //Console.WriteLine("\tF3:'" + fields[2] + "'");
    			
                    int phraseId = Convert.ToInt32(fields[0].Substring(1));
                    string[] phraseTerms = fields[1].Split(DELIMITERS);
                    IList widList = new ArrayList();

                    // Add new terms to maps
                    foreach (string phraseTerm in phraseTerms) 
                    {
                        int wid = -1;
        			
                        if (!wordHT.Contains(phraseTerm)) 
                        {
                            wordHTId++;
                            wid = wordHTId;
                            wordHT.Add(phraseTerm, wid);
                            totalChars3 += phraseTerm.Length;
                        }
                        else 
                        {
                            wid = (int) wordHT[phraseTerm];
                        }
        				
                        if (!wid2pids.Contains(wid)) 
                        {
                            IList pidList = new ArrayList();
                            pidList.Add(phraseId);
                            wid2pids.Add(wid, pidList);
                        }
                        else 
                        {
                            IList pidList = (IList) wid2pids[wid];
                            pidList.Add(phraseId);
                        }
        				
                        widList.Add(wid);
                    }
        			
                    pid2wids.Add(phraseId, widList);
                }
    		
    		
                //for (byte[] term : wordHT.keySet())
                //	totalChars += term.length;

                Console.WriteLine("Total Memory Before: {0}", GC.GetTotalMemory(false));
                GC.Collect();
                Console.WriteLine("Total Memory After : {0}", GC.GetTotalMemory(false));
    		
                Console.WriteLine("# words in wordHT: " + wordHT.Count);
                Console.WriteLine("Total chars: " + totalChars3);
                Console.WriteLine("Avg chars per term: " + (totalChars3 / wordHT.Count));
                Console.WriteLine();

                StreamWriter sw = null;

                // WordHT
                sw = new StreamWriter("data\\bio_wordHT.txt");
                foreach (string word in wordHT.Keys)
                    sw.WriteLine(word);
                sw.Close();


                // cid2name
                sw = new StreamWriter("data\\bio_cid2name.txt");
                foreach (int cid in cid2name.Keys) {
                    sw.WriteLine(cid);
                    sw.WriteLine(cid2name[cid]);
                }
                sw.Close();

                // pid2cids
                sw = new StreamWriter("data\\bio_pid2cids.txt");
                foreach (int pid in pid2cids.Keys) {
                    sw.WriteLine(pid);

                    IList cidList =  (IList) pid2cids[pid];
                    sw.WriteLine(cidList.Count);

                    foreach (int cid in cidList)
                        sw.WriteLine(cid);
                }
                sw.Close();

                //  pid2wids
                sw = new StreamWriter("data\\bio_pid2wids.txt");
                foreach (int pid in pid2wids.Keys) {
                    sw.WriteLine(pid);

                    IList widList =  (IList) pid2wids[pid];
                    sw.WriteLine(widList.Count);

                    foreach (int wid in widList)
                        sw.WriteLine(wid);
                }
                sw.Close();

                //  wid2pids
                sw = new StreamWriter("data\\bio_wid2pids.txt");
                foreach (int wid in wid2pids.Keys) {
                    sw.WriteLine(wid);

                    IList pidList =  (IList) wid2pids[wid];
                    sw.WriteLine(pidList.Count);

                    foreach (int pid in pidList)
                        sw.WriteLine(pid);
                }
                sw.Close();

            }
            catch(Exception e) 
            {
                Console.WriteLine(e.Message);
            }
            finally 
            {
                try 
                {
                    if (textFileReader!= null) 
                    {
                        //	flush and close both "input" and its underlying FileReader
                        textFileReader.Close();
                    }
                }
                catch(Exception e) {} 
            }
        }
    }
}
