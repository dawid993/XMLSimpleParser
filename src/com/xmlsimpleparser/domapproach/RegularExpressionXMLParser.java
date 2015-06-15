package com.xmlsimpleparser.domapproach;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.xmlsimpleparser.model.AttributePair;
import com.xmlsimpleparser.model.Element;

public class RegularExpressionXMLParser
{	
	private final Pattern compiledPattern;
	private final String xmlFileContent;
	
	public RegularExpressionXMLParser(File fileToParse)
	{		
		compiledPattern = getCompiledPatern();
		xmlFileContent = getFileContent(fileToParse);
	}
	
	public void parseFile(String contentToParse,Element father)
	{		
//		System.out.println("********************************************");
//		System.out.println(contentToParse);
//		System.out.println("********************************************");
		Matcher matcher = compiledPattern.matcher(contentToParse);
		while(matcher.find())
		{
			String markerName = matcher.group(1);
			String attributeParameters = matcher.group(2).trim();
			String textInMarker = matcher.group(4);			
			if(compiledPattern.matcher(textInMarker).find())
				textInMarker = "";
			
			Element newElement = new Element(textInMarker,father,markerName);

//			if(!attributeParameters.equals(""))
//			{
//				System.out.println(attributeParameters);
//				for(AttributePair attribut:separateAttributes(attributeParameters))
//					newElement.addAttribute(attribut.getKey(),attribut.getValue());
//			}
			father.addChildren(newElement);
			
			parseFile(matcher.group(4), newElement);
		}
	}
	
	private String getFileContent(File fileToParse)
	{
		Scanner in = null;
		
		try 
		{
			in = new Scanner(fileToParse);
			StringBuilder builder = new StringBuilder();
			
			while(in.hasNextLine())
				builder.append(in.nextLine()+"\n");
			
			return builder.toString();
		} 
		catch (FileNotFoundException e)
		{			
			e.printStackTrace();
			return null;
		}
		finally
		{
			in.close();			
		}
	}
	
	private Pattern getCompiledPatern()
	{
		String pattern = "<(\\w+)((\\s+\\S+=\"[^\"]+\")*)>([\\w\\W]+?)(</\\1>+)";
		return Pattern.compile(pattern);
	}
	
	private AttributePair[] separateAttributes(String content)
	{
		String[] tokens = content.trim().split(" ");
		AttributePair[] pairs = new AttributePair[tokens.length];
		
		for(int i=0;i<tokens.length;i++)		
			pairs[i]=new AttributePair(tokens[i]);
		
		return pairs;
	}

	public String getXmlFileContent() 
	{
		return xmlFileContent;
	}
	
	
	
}
