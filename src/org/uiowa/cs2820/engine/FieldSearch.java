// FieldSearch.java
// Chris Grycki
// Team 8

package org.uiowa.cs2820.engine;

import java.util.*;
import org.uiowa.cs2820.engine.Field;
import org.uiowa.cs2820.engine.Database;

// FieldSearch implements three methods:
// getEquals - searches for exact matches
// getKey - searches for matching keys
// getValue - searches for matching values

public class FieldSearch {
	// Array of strings to hold results
	private ArrayList<String> results;
	
	// getEquals searches a database for a field and 
	// returns a list of fields for which there is an
	// exact match.
	public ArrayList<String> findEquals(Field fd) {
		int index = 0;
		int size = Database.getSize();
		
		while (index < size) {
			if ( Database.getFieldByIndex(index).equals(fd) ) {
				results.add(Database.getAddrByIndex(index));
			}
			index++;
		}
		return results;
	}
	
	// getKey searches the database for fields which match
	// the key of the given field and returns the results
	// in a list
	/*
	public List<String> getKey(Field fd) {
		// implement later
		return results;
	}
	*/
	// getValue searches the database for fields which match
	// the value of the given field and returns the results
	// in a list
	/*
	public List<String> getValue(Field fd) {
		// implement later
		return results;
	}
	*/	
}
