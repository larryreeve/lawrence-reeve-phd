package edu.drexelist.bioannotator;

public class IteratedLovinsStemmer extends stemmerLovins {

	  /**
	   * Iterated stemming of the given word.
	   * Word is converted to lower case.
	   */
	  public String stem(String str) {

	    if (str.length() <= 2) {
	      return str;
	    }
	    String stemmed = super.stem(str);
	    while (!stemmed.equals(str)) {
	      str = stemmed;
	      stemmed = super.stem(stemmed);
	    }
	    return stemmed;
	  }

	  /**
	   * Stems text coming into stdin and writes it to stdout.
	   */
	  public static void main(String[] ops) {

	    IteratedLovinsStemmer ls = new IteratedLovinsStemmer();

	    try {
	      int num;
	      StringBuffer wordBuffer = new StringBuffer();
	      while ((num = System.in.read()) != -1) {
		char c = (char)num;
		if (((num >= (int)'A') && (num <= (int)'Z')) ||
		    ((num >= (int)'a') && (num <= (int)'z'))) {
		  wordBuffer.append(c);
		} else {
		  if (wordBuffer.length() > 0) {
		    System.out.print(ls.stem(wordBuffer.toString().
					     toLowerCase()));
		    wordBuffer = new StringBuffer();
		  }
		  System.out.print(c);
		}
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	}
	    

