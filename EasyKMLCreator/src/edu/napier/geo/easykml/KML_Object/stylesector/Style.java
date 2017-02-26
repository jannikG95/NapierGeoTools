package edu.napier.geo.easykml.KML_Object.stylesector;

import edu.napier.geo.easykml.KML_Object.KML_object;
import edu.napier.geo.easykml.KML_Object.subStyle.colorStyle.IconStyle;
import edu.napier.geo.easykml.KML_Object.subStyle.colorStyle.LabelStyle;
import edu.napier.geo.easykml.KML_Object.subStyle.colorStyle.LineStyle;
import edu.napier.geo.easykml.KML_Object.subStyle.colorStyle.PolyStyle;
import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class Style extends KML_object{
	
	private IconStyle iconStyle;
	private LabelStyle labelStyle;
	private LineStyle lineStyle;
	private PolyStyle polyStyle;
	

	public IconStyle getIconStyle() {
		return iconStyle;
	}
	public void setIconStyle(IconStyle iconStyle) {
		this.iconStyle = iconStyle;
	}
	public LabelStyle getLabelStyle() {
		return labelStyle;
	}
	public void setLabelStyle(LabelStyle labelStyle) {
		this.labelStyle = labelStyle;
	}
	public LineStyle getLineStyle() {
		return lineStyle;
	}
	public void setLineStyle(LineStyle lineStyle) {
		this.lineStyle = lineStyle;
	}
	public PolyStyle getPolyStyle() {
		return polyStyle;
	}
	public void setPolyStyle(PolyStyle polyStyle) {
		this.polyStyle = polyStyle;
	}
	
	public TreeNode<KML_element> getLinkedOutput (){
		
		TreeNode<KML_element> root = super.getLinkedOutput();
			
		if(iconStyle != null)root.addTreeNode(iconStyle.getLinkedOutput());
		if(labelStyle != null)root.addTreeNode(labelStyle.getLinkedOutput());
		if(lineStyle != null)root.addTreeNode(lineStyle.getLinkedOutput());
		if(polyStyle != null)root.addTreeNode(polyStyle.getLinkedOutput());

		return root; 
	}
	
}
