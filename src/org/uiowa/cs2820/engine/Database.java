package org.uiowa.cs2820.engine;

import java.util.*;

import org.uiowa.cs2820.engine.Field;

// This purpose of the Database class is to store 
// relationships between Fields and file addresses.
// With the following methods a user may:
//  - add an entry
//  - get an entry at the specified index

public class Database {
	// Static inner class
	// An Entry contains one Field and one String (for the address of the file)
	private static class Entry {
		private Field fd;
		private String addr;
		Entry(Field fd, String addr) {
			this.fd = fd;
			this.addr = addr;
		}
		Field getField() {
			return fd;
		}
		String getAddr() {
			return addr;
		}		
	}
	private static ArrayList<Entry> db = new ArrayList<Entry>();
	// Adds an entry to the database
	protected static void add(Field fd, String addr) {
		Database.Entry e = new Entry(fd,addr);
		db.add(e);
	}
	// Return the address string at position index
	protected static String getAddrByIndex(int index) {
		return db.get(index).getAddr();
	}
	protected static Field getFieldByIndex(int index) {
		return db.get(index).getField();
	}
	// Removes an entry from the database
	protected static void removeByField(Field fd) {
		// Can be implemented later
	}
	// Returns the number of Entries in the database
	public static int getSize(){
		return db.size();
	}
	
}