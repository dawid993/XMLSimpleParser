package com.xmlsimpleparser.domapproach;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.xmlsimpleparser.model.AttributePair;
import com.xmlsimpleparser.model.Element;
import com.xmlsimpleparser.model.service.ElementService;

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
		Matcher matcher = compiledPattern.matcher(contentToParse);
		while(matcher.find())
		{
			String markerName = matcher.group(1);
			String attributeParameters = matcher.group(2).trim();
			String textInMarker = matcher.group(4);			
			
			if(compiledPattern.matcher(textInMarker).find())
				textInMarker = "";
			
			List<AttributePair> attributePairs = splitAtributes(attributeParameters);
			Element newElement = ElementService.createElement(markerName, textInMarker, father, attributePairs);
			ElementService.addChild(father, newElement);
			
			if(textInMarker.equals("") && matcher.group(4) != null)
				parseFile(matcher.group(4), newElement);
		}
	}
	
	public String getXmlFileContent() 
	{
		return xmlFileContent;
	}		
	
	private Pattern getCompiledPatern()
	{
		String pattern = "<(\\w+)((\\s+\\S+=\"[^\"]+\")*)>([\\w\\W]*?)(</\\1>+)";
		return Pattern.compile(pattern);
	}	

	private List<AttributePair> splitAtributes(String line)
	{
		List<AttributePair> splitedLinesWithAttributes = new ArrayList<AttributePair>();
		String patternToSplitAttributes = "(\\S+)=\"([^\"]+)\"\\s*";
		
		Matcher matcher = Pattern.compile(patternToSplitAttributes).matcher(line);
		while(matcher.find())		
			splitedLinesWithAttributes.add(new AttributePair(matcher.group(1), matcher.group(2)));
		
		return splitedLinesWithAttributes;		
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
}
