package com.xmlsimpleparser.model;

import java.util.List;
import java.util.Map;

public class Element 
{
	private String textContent;
	private Map<String,String> atributes;
	private List<Element> childrens;
	private String markerName;
	
	public String getTextContent() 
	{
		return textContent;
	}
	public void setTextContent(String textContent)
	{
		this.textContent = textContent;
	}
	
	public Map<String, String> getAtributes()
	{
		return atributes;
	}
	
	public void setAtributes(Map<String, String> atributes) 
	{
		this.atributes = atributes;
	}
	
	public List<Element> getChildrens() 
	{
		return childrens;
	}
	
	public void setChildrens(List<Element> childrens) 
	{
		this.childrens = childrens;
	}
	
	public String getMarkerName() 
	{
		return markerName;
	}
	
	public void setMarkerName(String markerName) 
	{
		this.markerName = markerName;
	}
}
