import java.util.*;

public class Test 
{
	public static void main (String[] arguments)
	throws Exception
	{
		//List<String> sentences = SentenceSplitter.splitTextIntoSentences("This is a test. So is this.");
		
		List<String> sentences = SentenceSplitter.splitTextIntoSentences("Is the benefit worth it? Many forms of treatment, i.e., test procedure one.  We report the 5-yr results of a prospective randomized study comparing 12 versus 6 cycles of CMF (cyclophosphamide, methotrexate, fluorouracil) with the aim to evaluate the possibility of reducing the duration of adjuvant treatment without compromising the therapeutic effect of the multimodal approach. At 5-yr from mastectomy, both relapse-free survival (CMF 12:59%; CMF 6: 65.6%) and total survival (CMF 12:72.7%; CMF 6: 76.9%) were not significantly different in the two treatment groups. Within the two series,no difference was detected between pre- and postmenopausal patients (CMF 12: 59.3% versus 57.6%; CMF 6: 66.5% versus 63.1%), while findings were inversely related to the number of involved axillary nodes. The analysis of relapse-free survival confirmed that in both menopausal groups, relapse-free survival was not significantly affected by estrogen receptor status. Acute toxic manifestations were moderate and reversible. In particular, no drug-induced leukemia nor increased incidence of solid tumors other than breast cancer were documented in this series. Present results after 12 CMF cycles are almost identical to those of our first CMF adjuvant study. Current findings are sufficiently mature to indicate that the maximum tumor cytoreduction with CMF occurs within a relatively short period of time. To improve the results achieved with a single multidrug regimen, more intensive forms of treatment, i.e., utilizing noncross-resistant combinations, warrant careful evaluation.");
		
		for (String sentence : sentences)
		{
			System.out.println(sentence);
			System.out.println();
		}
	}
}
