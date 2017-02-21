package KML_Object.stylesector;

import HelperClasses.LinkedOutput;
import HelperClasses.TreeNode;
import KML_Object.KML_object;
import KML_Object.subStyle.colorStyle.IconStyle;
import KML_Object.subStyle.colorStyle.LabelStyle;
import KML_Object.subStyle.colorStyle.LineStyle;
import KML_Object.subStyle.colorStyle.PolyStyle;

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
	
	public TreeNode<LinkedOutput> getLinkedOutput (){
		
		TreeNode<LinkedOutput> root = super.getLinkedOutput();
			
		if(iconStyle != null)root.addTreeNode(iconStyle.getLinkedOutput());
		if(labelStyle != null)root.addTreeNode(labelStyle.getLinkedOutput());
		if(lineStyle != null)root.addTreeNode(lineStyle.getLinkedOutput());
		if(polyStyle != null)root.addTreeNode(polyStyle.getLinkedOutput());

		return root; 
	}
	
}
