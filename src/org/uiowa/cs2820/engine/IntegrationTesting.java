package org.uiowa.cs2820.engine;

import org.uiowa.cs2820.engine.UserSearch;
import org.uiowa.cs2820.engine.UserIndex;

public class IntegrationTesting {
	
	public static void main(String [] args) throws Exception {
		for (String e: args) {
			UserIndex index = new UserIndex(e);
			index.indexLines();
		}
		UserSearch searcher = new UserSearch();
		searcher.testLookups();
	}
}
