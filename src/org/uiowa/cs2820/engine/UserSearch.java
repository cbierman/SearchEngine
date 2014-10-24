package org.uiowa.cs2820.engine;


import java.util.ArrayList;

import org.uiowa.cs2820.engine.FieldSearch;
import org.uiowa.cs2820.engine.Field;

public class UserSearch {
	ArrayList<Field> lookups;
	
	UserSearch() {
		// Setup a dummy Database to use with the fieldSearch
		this.lookups = new ArrayList<Field>();
		String [] sampleFields = "amount 900 sku 13254 color blue".split("\\s+");
		for(int i=0; i< sampleFields.length; i+=2 ) {
			Field f = new Field(sampleFields[i], sampleFields[i+1]);
			lookups.add(f);
		}
	}
	
	public void testLookups() throws Exception {
		FieldSearch searcher = new FieldSearch();
		for (Field f: lookups) {
			System.out.println("Lookup Field name: " + f.getFieldName());
			System.out.println("Lookup Field Value: " + f.getFieldValue());
			System.out.println("FieldSearch results: ");
			ArrayList<String> result = searcher.findEquals(f);
			for (String e: result) {
				System.out.println("\t\t" + e);
			}
		}
	}
}
