package org.uiowa.cs2820.engine;


import org.uiowa.cs2820.engine.Field;
import org.uiowa.cs2820.engine.Database;

public class Indexer {
	
	private String identifier;			//initialize the identifier and the database
	private Boolean isClosed;
	
	Indexer(String identifier) { 
		this.identifier = identifier;
		this.isClosed = false;
	}
	
	public void addField(Field newField) {		//add a field and store in database
		if (!isClosed) {
			Database.add(newField, identifier);
		}
	}
	//public void remove(Field newField) {
	//	if (!isClosed) {
	//		Database.remove(newField);
	//	}
	//}
	public void close() {  //close the indexer
		isClosed = true;
	}
	
	public String getId() { 	//where the identifier can be retrieved
		return this.identifier;
	}
	
	//public String defaultIdentifier(Field item) {
		//set a default identifier for a field object
	//}
	
	
}
