package edu.napier.geo.easykml.KML_Object.gx_TourPrimitive;

import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class TourControl extends TourPrimitive{
	
	private final String PLAYMODE = "pause";
	
	/**
	 * TourContol pauses a Tour.
	 * For more information visit: 
	 * {@link: https://developers.google.com/kml/documentation/kmlreference#gxtourcontrol}
	 * 
	 * TourControl is part of the Google extension pack.
	 */
	public TourControl() {
		// TODO Auto-generated constructor stub
	}

	public String getPLAYMODE() {
		return PLAYMODE;
	}

	public TreeNode<KML_element> getLinkedOutput (){
		
		TreeNode<KML_element> root = super.getLinkedOutput();

		root.data.setgExtenstion(true);

		
		root.addChild(new KML_element("playMode", this.getPLAYMODE(), true));
	
		return root; 
	}
	
}
