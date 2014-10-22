package org.uiowa.cs2820.engine;


public class Field {
	String fieldName;
	String fieldValue;
	
	public Field() {
		this.fieldName = "";
		this.fieldValue = "";
	}
	
	public Field(String fieldName) {
		this.fieldName = fieldName;
		this.fieldValue = "";
	}

	public Field(String fieldName, String fieldValue) {
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	public String getFieldName() {
		return this.fieldName;
	}
	
	public String getFieldValue() {
		return this.fieldValue;
	}
	
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) { return false; }
		if (!(obj instanceof Field)) {return false;}
		if (obj == this) { return true; }
		if (obj.getClass() != this.getClass()) { return false; }
		
		Field fieldObj = (Field) obj;
		
		return ((this.fieldName.equals(fieldObj.fieldName)) && (this.fieldValue.equals(fieldObj.fieldValue)));
		
	}
}




