package edu.napier.geo.easykml.KML_Object.timePrimitive;

import java.text.DecimalFormat;
import java.util.Calendar;

import edu.napier.geo.easykml.KML_Object.KML_object;
import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class TimePrimitive extends KML_object{


	
	public TreeNode<KML_element> getLinkedOutput (){
		
		TreeNode<KML_element> root = super.getLinkedOutput();

		return root; 
	}

}
