package org.uiowa.cs2820.engine;

import java.io.FileReader;
import java.util.ArrayList;

import org.uiowa.cs2820.engine.Field;
import org.uiowa.cs2820.engine.Database;

public class Indexer {
	
	private String identifier;			//initialize the identifier and the database
	private Database myDatabase;
	private Boolean isClosed;
	
	Indexer(String indentifier, Database myDatabase) {
		this.identifier = identifier;
		this.myDatabase = myDatabase;
		this.isClosed = false;
	}
	
	public void add(Field newField){
		if (!isClosed){
			myDatabase.add(newField, identifier);}
	}
	
	public void close(){
		isClosed = true;
	}
	
	public String getId() { 					//where the identifier can be retrieved
		return this.identifier
	}
	
	public void lineId(String identifier, String line) {
		ArrayList ent = new ArrayList();
		String[] sentence = line.split("\\s+"); //takes a line and creates field objects
		if (sentence[0].length() == 0)
			return;
		String fieldName = sentence[0];
		for (int i=1; i<sentence.length; i++) { //uses the first word as field name and uses others as values
			Field n = new Field(fieldName, sentence[i]);
			ent.add(n); //create the [(fieldname,value), ident.] structure
			ent.add(identifier);
			Database.addField(n); //add to the database
		}
	}
	public void addField(Field addend) { //adds field to database
		Database.add(addend);
		
		}
	
}
