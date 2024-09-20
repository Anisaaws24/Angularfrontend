package com.example.angular_backend.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;
	private String resourseName;
	private String FieldName;
	private Object FieldValue;
	
	public ResourceNotFoundException(String resourseName, String fieldName, Object fieldValue) {
		//super();
		super(String.format("%s not found with '%s'",resourseName, fieldName, fieldValue));
		this.resourseName = resourseName;
		FieldName = fieldName;
		FieldValue = fieldValue;
	}
	public String getresourseName()
	{
		return resourseName;
	}
	
	public String getFieldName()
	{
		return FieldName;
	}
	public Object Fieldvalue()
	{
		return FieldValue;
	}

}
