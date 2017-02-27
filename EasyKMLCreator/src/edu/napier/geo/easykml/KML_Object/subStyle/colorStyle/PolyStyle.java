package edu.napier.geo.easykml.KML_Object.subStyle.colorStyle;

import edu.napier.geo.easykml.helperClasses.KML_element;
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
	
	private Boolean fillPolygon;
	private Boolean outLine;
	
	public String isFillPolygon() {
		return (fillPolygon) ? "1" : "0";
	}
	public void setFillPolygon(Boolean fillPolygon) {
		this.fillPolygon = fillPolygon;
	}
	public String isOutLine() {
		return (outLine) ? "1" : "0";
	}
	public void setOutLine(Boolean outLine) {
		this.outLine = outLine;
	} 
	
	
	public TreeNode<KML_element> getLinkedOutput (){
		
		TreeNode<KML_element> root = super.getLinkedOutput();
	
		if(this.fillPolygon != null)root.addChild(new KML_element("fill", this.isFillPolygon(), false));
		if(this.outLine != null)root.addChild(new KML_element("outline", this.isOutLine(), false));

		
		return root; 
	}
	

}
