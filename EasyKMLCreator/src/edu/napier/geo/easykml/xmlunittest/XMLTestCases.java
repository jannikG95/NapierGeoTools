package edu.napier.geo.easykml.xmlunittest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.IgnoreTextAndAttributeValuesDifferenceListener;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.xml.sax.SAXException;

public class XMLTestCases extends XMLTestCase {


	public void testPointPlacemark() throws Exception {
		assertEquals(true, compareXMLFiles("pointPlacemarkTest.kml", "createdPoint.kml"));
	}
	

	public void testPathPlacemark() throws Exception {
		assertEquals(true, compareXMLFiles("pathPlacemarkTest.kml", "createdPath.kml"));
	}

	public void testPolygonPlacemark() throws Exception {
		assertEquals(true, compareXMLFiles("polygonPlacemarkTest.kml", "createdPolygon.kml"));
	}

	public void testStyle() throws Exception {
		assertEquals(true, compareXMLFiles("styleTest.kml", "createdStyle.kml"));
	}


	public void testTour() throws Exception {
		assertEquals(true, compareXMLFiles("tourTest.kml", "createdTour.kml"));
	}
	
	public void testFeature() throws Exception {
		assertEquals(true, compareXMLFiles("featureTest.kml", "createdFeature.kml"));
	}

	public boolean compareXMLFiles(String testFile, String generatedFile){
		XMLUnit.setIgnoreAttributeOrder(true);
		XMLUnit.setIgnoreComments(true);
		XMLUnit.setIgnoreDiffBetweenTextAndCDATA(true);
		XMLUnit.setIgnoreWhitespace(true);
		XMLUnit.setNormalizeWhitespace(true);
		
	
		String strGoldVersion = "";
		String strTestVersion = "";
		try {
			strGoldVersion= FileUtils.readFileToString(new File(".\\generatedFiles\\"+generatedFile));
			strTestVersion = FileUtils.readFileToString(new File(".\\testDocuments\\" + testFile));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		Diff myDiff=null;
		 
		DifferenceListener myDifferenceListener = new IgnoreTextAndAttributeValuesDifferenceListener(); 
		 
		try {
			myDiff = new Diff(strGoldVersion,strTestVersion);
			myDiff.overrideDifferenceListener(myDifferenceListener);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
		 		
		boolean similar = myDiff.similar();
		return similar;
	}


}
