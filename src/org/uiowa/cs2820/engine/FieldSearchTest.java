package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

import org.junit.Test;

public class FieldSearchTest {
	ArrayList<String> results = new ArrayList<String>();
	ArrayList<String> expectedResults = new ArrayList<String>();
	// This methods runs one time before any test methods
	// as a setup
	@BeforeClass
	public static void initialSetUp() {
		// Instantiate Fields
		Field fd0 = new Field("fruit","bananas,apples,oranges");
		Field fd1 = new Field("shape","sqaure");
		Field fd2 = new Field("cheese","parmesan,cheddar");
		Field fd3 = new Field("dupes","I am a duplicate");
		// Add the fields to the database
		Database.add(fd0,"id0");
		Database.add(fd1,"id1");
		Database.add(fd2,"id2");
		Database.add(fd3,"id3");
		Database.add(fd3,"id4");
		
	}
	// This method runs prior to each and every test
	@Before
	public void setUp() {
		
	}
	// This method runs after each and every test
	@After
	public void tearDown() {
		// Empty the ArrayLists so each test can
		// begin fresh
		results.clear();
		expectedResults.clear();
	}
	// This test should get zero results
	@Test
	public void FindEqualsShouldReturnNothing() {
		FieldSearch fs = new FieldSearch();
		Field fdUnique = new Field("unique","nothing else looks like this field");
		results = fs.findEquals(fdUnique);
		assertTrue(results.isEmpty());
	}
	// This test should get one result
	@Test
	public void FindEqualsShouldReturnOneMatch() {
		FieldSearch fs = new FieldSearch();
		Field fdWillMatch = new Field("shape","sqaure");
		results = fs.findEquals(fdWillMatch);
		expectedResults.add("id1");
		assertEquals(expectedResults,results);
	}
	// This test should get two results
	@Test
	public void FindEqualsShouldReturnTwoMatches() {
		FieldSearch fs = new FieldSearch();
		Field fdWillMatch = new Field("dupes","I am a duplicate");
		results = fs.findEquals(fdWillMatch);
		expectedResults.add("id3");
		expectedResults.add("id4");
		assertEquals(expectedResults,results);
	}

}
