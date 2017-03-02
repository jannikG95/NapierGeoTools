package edu.napier.geo.easykml.KML_Object.subStyle.colorStyle;

import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class LabelStyle extends ColorStyle {
	
	/*
	 * Information area (Source: KML Reference Google):
	 * 
	 * <scale> 
	 * Resizes the label.
	 */
	
	private Float scale;
	
	
	/**
	 * Labelstyle specifies how Labels are drawn.
	 * For more information visit: 
	 * {@link: https://developers.google.com/kml/documentation/kmlreference#labelstyle}
	 */
	public LabelStyle() {
		// TODO Auto-generated constructor stub
	}

	public Float getScale() {
		return scale;
	}

	public void setScale(Float scale) {
		this.scale = scale;
	}

	public TreeNode<KML_element> getLinkedOutput (){
		
		TreeNode<KML_element> root = super.getLinkedOutput();
	
		if(this.getScale() != null)root.addChild(new KML_element("scale", Float.toString(this.getScale()), false));
		
		return root; 
	}
	
}
