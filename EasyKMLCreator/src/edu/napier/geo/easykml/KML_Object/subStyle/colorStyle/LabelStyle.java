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
	
	private float scale;

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public TreeNode<KML_element> getLinkedOutput (){
		
		TreeNode<KML_element> root = super.getLinkedOutput();
	
		root.addChild(new KML_element("scale", Float.toString(this.getScale()), false));
		
		return root; 
	}
	
}
