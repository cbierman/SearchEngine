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
	// Array list of fields to hold results
	private static List<Field> results;
	
	// getEquals searches a database for a field and 
	// returns a list of fields for which there is an
	// exact match.
	public static List<Field> getEquals(Field fd) {
		int index = 0;
		int size = Database.getSize();
		
		while (index < size) {
			if (Database.get(index) == fd) {
				results.add(Database.get(index));
			}
		}
		return results;
	}
	
	// getKey searches the database for fields which match
	// the key of the given field and returns the results
	// in a list
	public static List<Field> getKey(Field fd) {
		// implement later
		return results;
	}
	
	// getValue searches the database for fields which match
	// the value of the given field and returns the results
	// in a list	
	public static List<Field> getValue(Field fd) {
		// implement later
		return results;
	}	
}
