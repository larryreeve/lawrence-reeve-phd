/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biosumm.chain;

import java.util.*;

import biocommon.document.*;


public class ConceptChainer 
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT    = biocommon.copyright.Copyright.COPYRIGHT;
    

    public static void chainDocument(List<ConceptChain> conceptChainList,
							  		 Document 			annotatedDocument)
		throws Exception
	{
		conceptChainList.clear();
		
		// Load semantic types
		ISemanticTypeLoader stLoader = new SemanticTypeLoaderUMLS();
		List<SemanticType> semanticTypeList = stLoader.loadFromFile(null);
		
		// Create concept chain for each semantic type
		
		// Find highest id #, which becomes highest dimension for concept chain list
		int highestIdNumber = 0;
		for (SemanticType st : semanticTypeList)
		{
			//System.out.println("st: " + st.getId() + ", " + st.getTypeNumber());
			if (st.getTypeNumber() > highestIdNumber)
				highestIdNumber = st.getTypeNumber();
		}
		
		// Allocate concept chain list based on largest semantic type number
		//System.out.println("highestIdNumber=" + highestIdNumber);
		for (int idx=0; idx <= highestIdNumber; idx++)
			conceptChainList.add(new ConceptChain());
		
		// Initialize concept chain list entries
		for (SemanticType st : semanticTypeList)
		{
			ConceptChain chain = conceptChainList.get(st.getTypeNumber());
			
			chain.setId(st.getId());
			chain.setDescription(st.getDescription());
			chain.setIdNumber(st.getTypeNumber());
			chain.setScore(0.00);
		}
		
		
		// Chain the document's concepts to the semantic types
		for (DocumentSection section : annotatedDocument.getSections())
		{
			for (DocumentSentence sentence : section.getSentences())
			{
				for (DocumentPhrase phrase : sentence.getPhrases())
				{
					for (DocumentConcept phraseConcept : phrase.getConcepts().values())
					{
						int semanticTypeIdNumber = Integer.parseInt(phraseConcept.getSemanticTypeId().substring(1, 4));
						
						Concept c = new Concept(phraseConcept.getId(),
												phraseConcept.getName(),
												phraseConcept.getSemanticTypeId(),
												sentence.getSectionNumber(),
												sentence.getSentenceNumber());
						
						//System.out.println(phraseConcept.getSemanticTypeId() + ":" + semanticTypeIdNumber + ": " + phraseConcept.getSemanticTypeId().substring(1, 4));
						
						conceptChainList.get(semanticTypeIdNumber).getConceptList().add(c);
					}
				}
			}
		}
	}
}
