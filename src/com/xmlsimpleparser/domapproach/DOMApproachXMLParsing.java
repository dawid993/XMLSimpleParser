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
		Element root = new Element("",null,"root");
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
		System.out.println(prefix+root);
		for(Element e:root.getChildrens())		
			showTree(e, prefix+"  *");		
	}
	
}
