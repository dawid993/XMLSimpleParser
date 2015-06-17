package com.xmlsimpleparser.model;

import java.util.Map;

public class Element 
{
	private String textContent;
	private Map<String,String> attributes;
	private String markerName;
	
	private Element father;
	private Element leftSideSon;
	private Element rightSideBrother;
	
	
	public Element(String markerNameParam,String textContentParam,Element fatherParam)
	{
		this.textContent = textContentParam;		
		this.markerName = markerNameParam;			
		this.attributes = null;		
				
		this.father = fatherParam;
		this.leftSideSon = null;
		this.rightSideBrother = null;		
	}
	
	public String getTextContent() 
	{
		return textContent;
	}
	
	public Map<String, String> getAttributes()
	{
		return attributes;
	}
	
	public void setAttributes(Map<String,String> attributesParam)
	{
		this.attributes = attributesParam;
	}	
	
	public String getMarkerName() 
	{
		return markerName;
	}		
	
	public Element getFather()
	{
		return father;
	}	
	
	public void setFather(Element fatherParam)
	{
		this.father = fatherParam;
	}
	
	public Element getLeftSideSon() 
	{
		return leftSideSon;
	}

	public void setLeftSideSon(Element leftSideSonParam)
	{
		this.leftSideSon = leftSideSonParam;
	}

	public Element getRightSideBrother() 
	{
		return rightSideBrother;
	}

	public void setRightSideBrother(Element rightSideBrotherParam)
	{
		this.rightSideBrother = rightSideBrotherParam;
	}
	
	@Override
	public String toString()
	{
		StringBuilder description = new StringBuilder();
		description.append(markerName+" "+attributes+" text:"+textContent);
		
		return description.toString();
	}	
}
