package com.notes.testdata;

import org.testng.annotations.DataProvider;

public class NotesTestData {
	@DataProvider(name="create_notes")
	public Object[][] iso_name(){
		// Two dimensional object
	    return new Object[][] {
	            {"usa_api","UNITED STATES","Home"},
	            {"ind_api","INDIA","Work"},
	            {"pak_api","PAKISTAN","Personal"},
	     };
	}
}
