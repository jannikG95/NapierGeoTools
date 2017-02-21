package edu.napier.geo.easykml.KML_Object.subStyle.colorStyle;

import edu.napier.geo.easykml.helperClasses.LinkedOutput;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class PolyStyle extends ColorStyle {
	
	/*
	 * Information area (Source: KML Reference Google):
	 * 
	 * <fill> 
	 * Boolean value. Specifies whether to fill the polygon.
	 * 
	 * <outline> 
	 * Boolean value. Specifies whether to outline the polygon. Polygon outlines use the current LineStyle.
	 */
	
	private boolean fillPolygon;
	private boolean outLine;
	
	public String isFillPolygon() {
		return (fillPolygon) ? "1" : "0";
	}
	public void setFillPolygon(boolean fillPolygon) {
		this.fillPolygon = fillPolygon;
	}
	public String isOutLine() {
		return (outLine) ? "1" : "0";
	}
	public void setOutLine(boolean outLine) {
		this.outLine = outLine;
	} 
	
	
	public TreeNode<LinkedOutput> getLinkedOutput (){
		
		TreeNode<LinkedOutput> root = super.getLinkedOutput();
	
		root.addChild(new LinkedOutput("fill", this.isFillPolygon(), false));
		root.addChild(new LinkedOutput("width", this.isOutLine(), false));

		
		return root; 
	}
	

}
