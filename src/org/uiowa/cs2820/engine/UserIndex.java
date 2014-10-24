package org.uiowa.cs2820.engine;

import org.uiowa.cs2820.engine.Indexer;
import org.uiowa.cs2820.engine.FieldSearch;
import org.uiowa.cs2820.engine.Field;

import java.io.*;
public class UserIndex {
	
	String filename;
	FileReader f;
	BufferedReader b;
	
	UserIndex(String filename) throws Exception {
		this.filename = filename;
		this.f = new FileReader(filename);
		this.b = new BufferedReader(f);
	}
	
	
	public void lineIndex(String ident, String line) throws Exception {
		Indexer I = new Indexer(ident);
		
		String [] WordsInLine = line.split("\\s+");
		
		if (WordsInLine[0].length() == 0) { return; }
		
		String fieldname = WordsInLine[0];
		for (int i =1; i<WordsInLine.length; i++) {
			Field f = new Field(fieldname, WordsInLine[i]);
			I.addField(f);
		}
		
	}
	
	public void indexLines() throws Exception {
		String line = null, identifier;
		int count = 0;
		line = b.readLine();
		while(true) {
			identifier = filename + "-" + count;
			if (line == null) {break;}
			lineIndex(identifier, line);
			line = b.readLine();
			count += 1;
		}
	}
}
