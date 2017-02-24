package edu.napier.geo.easykml.KML_Object.feature;

import edu.napier.geo.easykml.KML_Object.geometry.KML_Geometry;
import edu.napier.geo.easykml.helperClasses.LinkedOutput;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class Placemark extends Feature {

	private KML_Geometry geometryObject;

	public Placemark(String name, String description, KML_Geometry geometryObject) {
		setName(name);
		setDescription(description);
		this.geometryObject = geometryObject;
	}

	public KML_Geometry getPoint() {
		return geometryObject;
	}

	public void setPoint(KML_Geometry geometryObject) {
		this.geometryObject = geometryObject;
	}
	

	public TreeNode<LinkedOutput> getLinkedOutput (){
		
		TreeNode<LinkedOutput> root = super.getLinkedOutput();

		root.addTreeNode(geometryObject.getLinkedOutput());

		return root; 
	}
	

}