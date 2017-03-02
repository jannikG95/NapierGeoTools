package edu.napier.geo.easykml.filemanagement;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.*;

import edu.napier.geo.easykml.KML_Object.KML_object;
import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class KMLFileWriter {

	private Document document;
	private Element KMLNamespaceDefinition;
	private Element rootElement;

	public KMLFileWriter(Document document) {
		this.document = document;
		defineBasicDocumentStructure();
	}

	public void appendObject(KML_object kml_object) {
		processLinkedOutputTree(kml_object);
	}

	// --------------------------------------------------------------------------------------------------------------
	// private method section
	// --------------------------------------------------------------------------------------------------------------

	private void defineBasicDocumentStructure() {
		KMLNamespaceDefinition = new Element("kml", Namespace.getNamespace("http://www.opengis.net/kml/2.2"));	
		document.setRootElement(KMLNamespaceDefinition);
		
		rootElement = new Element("Document");
		KMLNamespaceDefinition.addContent(rootElement);
	}

	private void addGoogleExtansionsPack(Element element) {
		List<Namespace> additional_Namespaces = KMLNamespaceDefinition.getAdditionalNamespaces();
		
		if (additional_Namespaces.size() == 0)
			KMLNamespaceDefinition.addNamespaceDeclaration(Namespace.getNamespace("gx", "http://www.google.com/kml/ext/2.2"));
		
		element.setNamespace((Namespace) KMLNamespaceDefinition.getAdditionalNamespaces().get(0));
	}

	private void processLinkedOutputTree(KML_object kml_object) {
		TreeNode<KML_element> treeRoot = kml_object.getLinkedOutput();

		System.out.println(treeRoot.data.getName());

		Element kml_object_RootElement = null;
		ArrayList<Element> ParentElementofLevel = new ArrayList<>();

		for (TreeNode<KML_element> node : treeRoot) {
			if (node.isRoot()) {
				kml_object_RootElement = new Element(treeRoot.data.getName());
				if(treeRoot.data.isgExtenstion())addGoogleExtansionsPack(kml_object_RootElement);
				rootElement.addContent(kml_object_RootElement);
				
				ParentElementofLevel.add(node.getLevel(), kml_object_RootElement);
			} else {

				if (!node.isLeaf()) {
					//System.err.println(node.getLevel());
					kml_object_RootElement = new Element(node.data.getName());
					ParentElementofLevel.get(node.getLevel() - 1).addContent(kml_object_RootElement);
					if(node.data.isgExtenstion())addGoogleExtansionsPack(kml_object_RootElement);

					ParentElementofLevel.add(node.getLevel(), kml_object_RootElement);
				} else {
					if (node.data.getName() == "id" && node.data.getText() != "")
						setElementID(kml_object_RootElement, "id", node.data.getText());
					else if (node.data.getName() == "targetId" && node.data.getText() != ""){
						setElementID(ParentElementofLevel.get(node.getLevel()), "targetId", node.data.getText());}
					else {
						kml_object_RootElement = new Element(node.data.getName());
						kml_object_RootElement.setText(node.data.getText());
						ParentElementofLevel.get(node.getLevel() - 1).addContent(kml_object_RootElement);
						if(node.data.isgExtenstion())addGoogleExtansionsPack(kml_object_RootElement);
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


}
