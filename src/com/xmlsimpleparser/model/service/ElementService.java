package com.xmlsimpleparser.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xmlsimpleparser.model.AttributePair;
import com.xmlsimpleparser.model.Element;

public class ElementService
{
	public static Element createElement(String markerName,String markerTextContent,Element fatherOfElement,
			List<AttributePair> attributes)
	{
		Element element = new Element(markerName, markerTextContent, fatherOfElement);		
		if(attributes != null)
			addAttributesToElement(element,attributes);
		
		return element;
	}

	public static void addAttributesToElement(Element element,List<AttributePair> attributes) 
	{
		if(element.getAttributes() == null)
			element.setAttributes(new HashMap<String,String>());		
		Map<String,String> attributesMap = element.getAttributes();
		
		for(AttributePair pair:attributes)
			attributesMap.put(pair.getKey(), pair.getValue());
	}
	
	public static void addBrotherToElement(Element element,Element brotherParam)
	{
		Element rightBrother = element;		
		while(rightBrother.getRightSideBrother() != null)
			rightBrother = rightBrother.getRightSideBrother();
		
		rightBrother.setRightSideBrother(brotherParam);
	}
	
	public static void addChild(Element element,Element child)
	{
		if(element.getLeftSideSon() != null)
			addBrotherToElement(element.getLeftSideSon(),child);
		else
			element.setLeftSideSon(child);
	}
}
