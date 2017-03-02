package edu.napier.geo.easykml.facade;

import org.jdom.Document;

import edu.napier.geo.easykml.KML_Object.feature.Placemark;
import edu.napier.geo.easykml.KML_Object.feature.Tour;
import edu.napier.geo.easykml.KML_Object.stylesector.Style;
import edu.napier.geo.easykml.filemanagement.KMLFileCreator;
import edu.napier.geo.easykml.filemanagement.KMLFileSaver;
import edu.napier.geo.easykml.filemanagement.KMLFileWriter;

public class KML_Facade {

	private Document KML_Document;
	private KMLFileWriter fileWriter;

	
	/**
	 * Creates a new instance of the EasyKMLCreator.
	 */
	public KML_Facade() {
	}

	/**
	 * createKMLDocment:
	 * 
	 * This function is used to create a JDOM XML document, which will be used
	 * to store KML code until the user saves the document by calling the
	 * function saveKMLDocument.
	 */
	private void createKMLDocument() {
		KML_Document = new KMLFileCreator().getKMLDoument();
		fileWriter = new KMLFileWriter(KML_Document);
	}

	/**
	 * createPlacemark invokes the creation of KML code for placemarks.
	 * 
	 * @param newPlacemark
	 */
	public void createPlacemark(Placemark newPlacemark) {
		if (!documentInitialized()) {
			this.createKMLDocument();
		}
		fileWriter.appendObject(newPlacemark);

	}

	/**
	 * createStyle invokes the creation of KML code for styles.
	 * 
	 * @param newStyle
	 */
	public void createStyle(Style newStyle) {
		if (!documentInitialized()) {
			this.createKMLDocument();
		}
		fileWriter.appendObject(newStyle);
	}

	/**
	 * createStyle invokes the creation of KML code for Touring.
	 * 
	 * @param newTour
	 */
	public void createTour(Tour newTour) {
		if (!documentInitialized()) {
			this.createKMLDocument();
		}
		fileWriter.appendObject(newTour);
	}

	/**
	 * saveKMLDocument Invoke the saving of the document and finally produce a
	 * readable KML File.
	 * 
	 * @param destination
	 *            - specifies the storage location of the file. Expects a string
	 *            similar to the following example:
	 *            C:\\Folder\\...\\Folder\\Filename
	 */
	// Invoke the saving of the document and finally produce a readable KML File
	public void saveKMLDocument(String destination) {
		new KMLFileSaver().saveFile(KML_Document, destination);
	}

	/**
	 * saveKMLDocument Invoke the saving of the document and finally produce a
	 * readable KML File. The file will be saved in the root path of the
	 * EasyKMLCreator.
	 */
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
