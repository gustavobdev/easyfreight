package com.gbs.easyfreight.resource.exception;

import java.io.Serializable;
import java.util.Objects;

public class FieldMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	private String fieldName;
	private String message;
	
	public FieldMessage(){
	}

	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fieldName, message);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FieldMessage other = (FieldMessage) obj;
		return Objects.equals(fieldName, other.fieldName) && Objects.equals(message, other.message);
	}
	
	
	
	

}
