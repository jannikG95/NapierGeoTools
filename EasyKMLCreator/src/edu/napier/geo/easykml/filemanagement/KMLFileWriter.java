package edu.napier.geo.easykml.filemanagement;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import edu.napier.geo.easykml.KML_Object.KML_object;
import edu.napier.geo.easykml.KML_Object.feature.Placemark;
import edu.napier.geo.easykml.KML_Object.feature.Tour;
import edu.napier.geo.easykml.KML_Object.stylesector.Style;
import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class KMLFileWriter {

	private Document document;
	private Element KMLNamespaceDefinition;
	private Element rootElement;

	public KMLFileWriter() {
		this.document = KMLFileCreator.getKMLDoument();
		defineBasicDocumentStructure();
	}

	public void appendObject(KML_object kml_object) {
		processLinkedOutputTree(kml_object);
	}


	// --------------------------------------------------------------------------------------------------------------
	// private method section
	// --------------------------------------------------------------------------------------------------------------
	
	
	private void defineBasicDocumentStructure() {
		KMLNamespaceDefinition = this.document.createElementNS("http://www.opengis.net/kml/2.2", "kml");
		document.appendChild(KMLNamespaceDefinition);

		rootElement = document.createElement("Document");
		KMLNamespaceDefinition.appendChild(rootElement);
	}

	private void addGoogleExtansionsPack() {
		if (KMLNamespaceDefinition.getAttribute("xmlns:gx") != null)
			KMLNamespaceDefinition.setAttribute("xmlns:gx", "http://www.google.com/kml/ext/2.2");
	}

	private void processLinkedOutputTree(KML_object kml_object) {
		TreeNode<KML_element> treeRoot = kml_object.getLinkedOutput();

		System.out.println(treeRoot.data.getName());

		Element kml_object_RootElement = null;
		ArrayList<Element> ParentElementofLevel = new ArrayList<>();

		for (TreeNode<KML_element> node : treeRoot) {
			if (node.isRoot()) {
				kml_object_RootElement = creatDomElement(treeRoot.data.getName(), null, rootElement,
						treeRoot.data.isgExtenstion());
				ParentElementofLevel.add(node.getLevel(), kml_object_RootElement);
			} else {

				if (!node.isLeaf()) {
					System.err.println(node.getLevel());
					kml_object_RootElement = creatDomElement(node.data.getName(), null,
							ParentElementofLevel.get(node.getLevel()-1), node.data.isgExtenstion());
					ParentElementofLevel.add(node.getLevel(), kml_object_RootElement);
				} else {
					if (node.data.getName() == "id" && node.data.getText() != "")
						setElementID(kml_object_RootElement,"id" , node.data.getText());
					else if (node.data.getName() == "targetID" && node.data.getText() != "")
						setElementID(kml_object_RootElement,"targetId" , node.data.getText());
					else {
						creatDomElement(node.data.getName(), document.createTextNode(node.data.getText()),
								ParentElementofLevel.get(node.getLevel()-1), node.data.isgExtenstion());
					}
				}
			}
		}
	}


	private void setElementID(Element element, String attr_Name, String attr_Text) {
		if (attr_Text != null) {
			element.setAttribute(attr_Name, attr_Text);
		}
	}

	private Element creatDomElement(String elementName, Text textNode, Element parentElement, boolean gExtension) {
		Element innerElement = null;

		if (gExtension == true) {
			this.addGoogleExtansionsPack();
		}
		if (textNode == null) {
			innerElement = document.createElement(elementName);
			parentElement.appendChild(innerElement);
		} else {
			String textInNode = textNode.getWholeText();
			//if (!textInNode.equals("") && !textInNode.equals("0.0") && !textInNode.equals("0")) {
				innerElement = document.createElement(elementName);
				innerElement.appendChild(textNode);
				parentElement.appendChild(innerElement);
			//}
		}

		return innerElement;
	}

}
