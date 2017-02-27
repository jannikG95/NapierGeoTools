package edu.napier.geo.easykml.facade;

import org.w3c.dom.Document;

import edu.napier.geo.easykml.KML_Object.feature.Placemark;
import edu.napier.geo.easykml.KML_Object.feature.Tour;
import edu.napier.geo.easykml.KML_Object.stylesector.Style;
import edu.napier.geo.easykml.filemanagement.KMLFileCreator;
import edu.napier.geo.easykml.filemanagement.KMLFileSaver;
import edu.napier.geo.easykml.filemanagement.KMLFileWriter;

public class KML_Facade {

	private Document KML_Document;
	private KMLFileWriter fileWriter;

	public KML_Facade() {
	}

	// Call KMLFileCreator class to create a KML document.
	// Precondition for everything!
	public void createKMLDocument() {
		KML_Document = new KMLFileCreator().getKMLDoument();
		fileWriter = new KMLFileWriter(KML_Document);
	}

	public void createPlacemark(Placemark newPlacemark) {
		if (documentInitialized()) {
			fileWriter.appendObject(newPlacemark);
		}
	}

	public void createStyle(Style newStyle) {
		if (documentInitialized()) {
			fileWriter.appendObject(newStyle);
		}
	}

	public void createTour(Tour newTour) {
		if (documentInitialized()) {
			fileWriter.appendObject(newTour);
		}
	}

	// Invoke the saving of the document and finally produce a readable KML File
	public void saveKMLDocument(String destination) {
		new KMLFileSaver().saveFile(KML_Document, destination);
	}
	
	public void saveKMLDocument() {
		new KMLFileSaver().saveFile(KML_Document, "");
	}
	
	
	// check if the KML document was initialized
	private boolean documentInitialized() {
		if (KML_Document != null)
			return true;
		else
			return false;
	}



}
