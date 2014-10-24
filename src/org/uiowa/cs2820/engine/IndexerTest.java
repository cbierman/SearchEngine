package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

import org.junit.Test;

public class IndexerTest {
	
	// This test should get the identifier
	@Test
	public void IndexerTakesTheIdentifierIn() {
		String identifier;
		identifier = "Ray"
		Indexer U = new Indexer(identifier)
		assertEquals(U.getId(),identifier);
	}
	// This test should add to the database
	@Test
	public void AddFieldAndIdentifier() {
		Field fd0 = new Field("Hawkeyes","Canzeri,Alston,Spears");
		String identifier = "Cale";
		Indexer Y = new Indexer(identifier); 
		Database.add(fd0, identifier);
		assertEquals(Database.getField(), fd0);
	}
	// This test should show Indexer is closed
	@Test
	public void IndexerIsClosed {
		String identifier = "Chris";
		Field tt = new Field("Mitchell")
		Indexer T = new Indexer(identifier);
		T.close();
		assertEquals(T.add(tt, identifier), "Index Closed")
	}

}
