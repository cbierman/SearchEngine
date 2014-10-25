package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import org.junit.*;

import java.io.IOException;
import java.util.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IndexerTest {
	
	// This test should get the identifier
	@Test
	public void IndexerTakesTheIdentifierIn() {
		String identifier;
		identifier = "Ray";
		Indexer U = new Indexer(identifier);
		assertEquals(U.getId(),identifier);
	}
	// This test should add to the database
	@Test
	public void AddFieldAndIdentifier() throws IOException {
		Field fd0 = new Field("Hawkeyes","Canzeri,Alston,Spears");
		String identifier = "Cale";
		Indexer Y = new Indexer(identifier);
		Y.add(fd0, identifier);
		//Database.add(fd0, identifier);
		FieldSearch fs = new FieldSearch();
		ArrayList<String> results = fs.findEquals(fd0);
		// Test that the identifier we get back is the same identifier we added
		// and that only one result was returned
		assertEquals(results.size(),1);
		assertEquals(identifier,results.get(0));
	}
	
	// The @Rule annotation here allows us to setup
	// a JUnit test that passes if the expected exception
	// is thrown.
	@Rule public ExpectedException e = ExpectedException.none();
	// This test should show Indexer is closed
	@Test
	public void IndexerIsClosed() throws IOException {
		e.expect( IOException.class );
		e.expectMessage("Indexer Closed");
		
		String identifier = "Chris";
		Field tt = new Field("Mitchell");
		Indexer T = new Indexer(identifier);
		T.close();
		T.add(tt, identifier);
	}

}
