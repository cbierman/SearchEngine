package org.uiowa.cs2820.engine;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.io.IOException;

import org.uiowa.cs2820.engine.Field;
import org.uiowa.cs2820.engine.FieldSearch;
import org.uiowa.cs2820.engine.Indexer;
import org.junit.*;

public class IntegrationTesting {
	
	@Test
	// Tests when adding a Field object via the Indexer,
	// whether we get the identifier (filename) that field was in
	public void Test1() {
		// Sample input that might be read from a file
		String sampleFieldInput = "customer Bob";
		// Break it into a list to iterate over
		String [] sampleFieldsList = sampleFieldInput.split("\\s+");
		// Dummy identifier, user would actually make this themselves.
		String ident = "sampleFields-1";
		Indexer i = new Indexer(ident);
		// Create a field out of the list
		Field f = new Field(sampleFieldsList[0], sampleFieldsList[1]);
		// Add it via the indexer. May throw an IOException
		try {
			i.add(f, ident);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// close the indexer
		i.close();
		// Identifier needs to go in a list since FieldSearch returns a 
		// list of filenames.
		ArrayList<String> identInList = new ArrayList<String>();
		identInList.add(ident);
		
		FieldSearch searcher = new FieldSearch();
		// Create the same dummy field
		Field y = new Field(sampleFieldsList[0], sampleFieldsList[1]);
		// See if we search for that field that we get the identifier in a 
		// list back.
		assertEquals(identInList, searcher.findEquals(y));
	
	}
	
	@Test
	// Test whether we get nothing back if the field is not in the Database.
	public void Test2() {
		// Sample input that might be read from a file
				String sampleFieldInput = "customer Bob";
				// Break it into a list to iterate over
				String [] sampleFieldsList = sampleFieldInput.split("\\s+");
				// Dummy identifier, user would actually make this themselves.
				String ident = "sampleFields-1";
				Indexer i = new Indexer(ident);
				// Create a field out of the list
				Field f = new Field(sampleFieldsList[0], sampleFieldsList[1]);
				// Add it via the indexer. May throw an IOException
				try {
					i.add(f, ident);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// close the indexer
				i.close();
				// Identifier needs to go in a list since FieldSearch returns a 
				// list of filenames.
				ArrayList<String> identInList = new ArrayList<String>();
				
				FieldSearch searcher = new FieldSearch();
				// Create the same dummy field
				Field y = new Field("chicken", "masala");
				// See if we search for that field that we get an empty list back
				// (since the Indexer never added it)
				assertEquals(identInList, searcher.findEquals(y));
			
	}
	
}
