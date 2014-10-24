package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

import org.junit.Test;

public class FieldSearchTest {

	// This methods runs one time before any test methods
	// as a setup
	@BeforeClass
	public static void initialSetUp() {
		Field fd0 = new Field("fruit","bananas,apples,oranges");
		Field fd1 = new Field("shape","sqaure");
		Field fd2 = new Field("cheese","parmesan,cheddar");
		Field fd3 = new Field("dupes","I am a duplicate");
		Database.add(fd0,"id0");
		Database.add(fd1,"id1");
		Database.add(fd2,"id2");
		Database.add(fd3,"id3");
		Database.add(fd3,"id4");
		
	}
	
	@Test
	public void FindEqualsShouldReturnNothing() {
		Field fdUnique = new Field("unique","nothing else looks like this field");
		ArrayList<String> results = new ArrayList<String>();
		results = FieldSearch.findEquals(fdUnique);
		assertTrue(results.isEmpty());
	}
	
	@Test
	public void FindEqualsShouldReturnOneMatch() {
		Field fdWillMatch = new Field("shape","sqaure");
		ArrayList<String> results = new ArrayList<String>();
		results = FieldSearch.findEquals(fdWillMatch);
		ArrayList<String> expectedResults = new ArrayList<String>();
		expectedResults.add("id1");
		assertEquals(expectedResults,results);
	}
	
	@Test
	public void FindEqualsShouldReturnTwoMatches() {
		Field fdWillMatch = new Field("dupes","I am a duplicate");
		ArrayList<String> results = new ArrayList<String>();
		results = FieldSearch.findEquals(fdWillMatch);
		ArrayList<String> expectedResults = new ArrayList<String>();
		expectedResults.add("id3");
		expectedResults.add("id4");
		assertEquals(expectedResults,results);
	}

}
