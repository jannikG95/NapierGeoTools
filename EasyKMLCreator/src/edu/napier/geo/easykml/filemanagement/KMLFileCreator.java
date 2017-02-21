package edu.napier.geo.easykml.filemanagement;

import javax.xml.parsers.*;
import org.w3c.dom.Document;

public class KMLFileCreator {

	private static Document document;
	
	private KMLFileCreator() {
	}
	
	private static void initializeDocument(){
        DocumentBuilderFactory dbFactory =
        DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
	        document = dBuilder.newDocument();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Document getKMLDoument(){
		if(document != null){
			return document;
		}
		else{
			initializeDocument();
			return document;
		}
	}
	
}
