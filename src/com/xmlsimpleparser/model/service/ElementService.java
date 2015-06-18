package com.xmlsimpleparser.model.service;

import java.util.ArrayList;
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
		Element element = new Element(markerName, markerTextContent.trim(), fatherOfElement);		
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
		if(element == null || brotherParam == null)
			return;		
		
		Element rightBrother = element;		
		while(rightBrother.getRightSideBrother() != null)
			rightBrother = rightBrother.getRightSideBrother();
		
		rightBrother.setRightSideBrother(brotherParam);
	}
	
	public static void addBrotherAfterElement(Element element,Element brotherParam)
	{
		if(element == null || brotherParam == null)
			return;
		
		Element tempBrother = element.getRightSideBrother();
		element.setRightSideBrother(brotherParam);
		brotherParam.setRightSideBrother(tempBrother);
	}
	
	public static void addChild(Element element,Element child)
	{
		if(element.getLeftSideSon() != null)
			addBrotherToElement(element.getLeftSideSon(),child);
		else
			element.setLeftSideSon(child);
	}
	
	public static Element getFather(Element element)
	{
		if(element == null)
			return null;
		
		return element.getFather();
	}
	
	public static List<Element> getChildrens(Element element)
	{
		List<Element> childrens = new ArrayList<Element>();
		
		if(element == null)
			return childrens;
		
		Element child = element.getLeftSideSon();		
		while(child != null)
		{
			childrens.add(child);
			child = child.getRightSideBrother();
		}
		
		return childrens;
	}
	
	public static List<Element> getBrothers(Element element)
	{
		List<Element> brothers = new ArrayList<Element>();	
		
		if(element == null)
			return brothers;
		
		Element father = element.getFather();
		Element brother = null;
		if(father != null)
			brother = father.getLeftSideSon();
		
		while(brother != null)
		{
			if(brother != element)
				brothers.add(brother);
			
			brother = brother.getRightSideBrother();
		}
		
		return brothers;
	}
	
	public static void showTreeStructure(Element root)
	{
		showTree(root, "*");
	}
	
	private static void showTree(Element root,String prefix)
	{		
		Element elem = root;		
		while(elem != null)
		{
			System.out.println(prefix+" "+elem);
			if(elem.getLeftSideSon() != null)		
				showTree(elem.getLeftSideSon(),prefix+"  *");					
			elem=elem.getRightSideBrother();				
		}
	}
	
}
