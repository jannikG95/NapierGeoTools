package edu.napier.geo.easykml.KML_Object.subStyle.colorStyle;

import edu.napier.geo.easykml.helperClasses.LinkedOutput;
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

	public TreeNode<LinkedOutput> getLinkedOutput (){
		
		TreeNode<LinkedOutput> root = super.getLinkedOutput();
	
		root.addChild(new LinkedOutput("scale", Float.toString(this.getScale()), false));
		
		return root; 
	}
	
}
