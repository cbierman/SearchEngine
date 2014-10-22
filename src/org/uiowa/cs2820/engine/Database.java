package org.uiowa.cs2820.engine;

import java.util.*;

import org.uiowa.cs2820.engine.Field;

// This purpose of this class is to store field objects.
// With the following methods a user may:
//  - add an entry
//  - get an entry at the specified index


public class Database {
	private static List<Field> db;

	// Adds an entry to the database
	public static void add(Field entry) {
		db.add(entry);
	}
	// Return the field object at position index
	public static Field get(int index) {
		return db.get(index);
	}
	// Removes an entry from the database
	public void remove(Field fd) {
		// Can be implemented later
	}
	// Returns the number of fields in the database
	public static int getSize(){
		return db.size();
	}
	
}