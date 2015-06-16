package com.xmlsimpleparser.model;

public class AttributePair 
{
	private String key;
	private String value;
	
	public AttributePair(String keyParam,String valueParam)
	{
		this.key = keyParam;
		this.value = valueParam;
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
