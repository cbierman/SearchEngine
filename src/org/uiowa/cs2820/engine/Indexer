package org.uiowa.cs2820.engine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.uiowa.cs2820.engine.Field;
import org.uiowa.cs2820.engine.Database;

public class Indexer {
	//prepare to read a file
	String fileName;
	FileReader A;
	BufferedReader B;
	
	Indexer(String fileName) {
		this.fileName = fileName;
		this.A = new FileReader(fileName);
		this.B = new BufferedReader(A);
		
	}
	public void setId() { //where the identifier is created and file is read
		String line = null, identifier;
		int count = 0;
		line = B.readLine();
		while (true) { 
			identifier = fileName + "_" + count;
			if (line == null) //create new ids with growing counts		 
				break;        //added to end to show its uniqueness
			lineId(identifier, line);
			line = B.readLine();
			count += 1;
		}
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
