package com.xmlsimpleparser.model;

public class AttributePair 
{
	private String key;
	private String value;
	
	public AttributePair(String line)
	{
		String[] spilitedLine = line.split("=");
		this.key = spilitedLine[0];
		this.value = spilitedLine[1];
	}

	public String getKey()
	{
		return key;
	}

	public String getValue() 
	{
		return value;
	}

}
