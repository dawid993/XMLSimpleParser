package com.xmlsimpleparser.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Element 
{
	private String textContent;
	private Map<String,String> attributes;
	private List<Element> childrens;
	private Element father;
	private String markerName;
	
	public Element(String textContentParam,Element fatherParam, String markerNameParam)
	{
		this.textContent = textContentParam;
		this.father = fatherParam;
		this.markerName = markerNameParam;			
		attributes = new HashMap<String,String>();		
		childrens = new ArrayList<Element>();		
	}
	
	public String getTextContent() 
	{
		return textContent;
	}
	
	
	public Map<String, String> getAtributes()
	{
		return attributes;
	}
	
	public List<Element> getChildrens() 
	{
		return childrens;
	}
		
	public String getMarkerName() 
	{
		return markerName;
	}	
	
	
	public Element getFather()
	{
		return father;
	}
	
	public void addChildren(Element elementParam)
	{		
		childrens.add(elementParam);
	}
	
	public void addAttribute(String attributeName,String attributeValue)
	{		
		attributes.put(attributeName, attributeValue);
	}
	
}
