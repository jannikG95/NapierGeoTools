package edu.napier.geo.easykml.KML_Object.geometry;

import edu.napier.geo.easykml.KML_Object.KML_object;
import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public abstract class KML_Geometry extends KML_object{

	public TreeNode<KML_element> getLinkedOutput (){
		
		TreeNode<KML_element> root = super.getLinkedOutput();

		return root; 
	}
	
}
