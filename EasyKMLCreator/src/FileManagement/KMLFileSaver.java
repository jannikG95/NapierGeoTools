package FileManagement;

import java.io.File;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class KMLFileSaver {
	
	public void saveFile(Document document, String destination){
        TransformerFactory transformerFactory =
        TransformerFactory.newInstance();
        Transformer transformer;
		try {
			transformer = transformerFactory.newTransformer();
	        DOMSource source = new DOMSource(document);
	        StreamResult result = new StreamResult(new File(destination));
	        transformer.transform(source, result);
	         // Output to console for testing
	         StreamResult consoleResult =
	         new StreamResult(System.out);
	         transformer.transform(source, consoleResult);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
