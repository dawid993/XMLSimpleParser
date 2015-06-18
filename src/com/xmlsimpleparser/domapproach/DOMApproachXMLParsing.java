package com.xmlsimpleparser.domapproach;

import java.io.File;

import com.xmlsimpleparser.model.Element;

public class DOMApproachXMLParsing 
{
	private File fileToParse;
	private Element rootOfXMLTree;
	
	public DOMApproachXMLParsing(File file) 
	{
		this.fileToParse = file;
	}
	
	public DOMApproachXMLParsing(String pathToFile)
	{
		this(new File(pathToFile));
	}
	
	public void parseDocument()
	{
		Element root = new Element("root","begin",null);
		RegularExpressionXMLParser parser = new RegularExpressionXMLParser(fileToParse);
		parser.parseFile(parser.getXmlFileContent(), root);
		
		rootOfXMLTree = root;
	}
	
	public Element getRoot()
	{
		return rootOfXMLTree;
	}
	
	public void showTreeStructure()
	{
		showTree(rootOfXMLTree, "*");
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
