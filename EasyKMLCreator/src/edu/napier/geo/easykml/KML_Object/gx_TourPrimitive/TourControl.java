package edu.napier.geo.easykml.KML_Object.gx_TourPrimitive;

import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class TourControl extends TourPrimitive{
	
	private final String PLAYMODE = "pause";

	public String getPLAYMODE() {
		return PLAYMODE;
	}

	public TreeNode<KML_element> getLinkedOutput (){
		
		TreeNode<KML_element> root = super.getLinkedOutput();

		root.data.setName("gx:TourControl");
	
		root.addChild(new KML_element("gx:playMode", this.getPLAYMODE(), true));
	
		return root; 
	}
	
}
