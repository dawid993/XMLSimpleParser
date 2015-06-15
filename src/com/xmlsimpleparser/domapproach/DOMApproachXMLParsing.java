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
		//Element root = new Element();
		
		
		
	}
	
}
