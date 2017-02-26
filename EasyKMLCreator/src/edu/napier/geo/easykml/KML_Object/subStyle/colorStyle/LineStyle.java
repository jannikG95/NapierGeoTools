package edu.napier.geo.easykml.KML_Object.subStyle.colorStyle;

import java.awt.Color;

import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class LineStyle extends ColorStyle {

	/*
	 * Information area (Source: KML Reference Google):
	 * 
	 * <width> 
	 * Width of the line, in pixels.
	 * 
	 * <gx:outerColor> 
	 * Color of the portion of the line defined by
	 * <gx:outerWidth>. Note that the <gx:outerColor> and <gx:outerWidth>
	 * elements are ignored when <LineStyle> is applied to <Polygon> and
	 * <LinearRing>.
	 * 
	 * <gx:outerWidth> 
	 * A value between 0.0 and 1.0 that specifies the proportion
	 * of the line that uses the <gx:outerColor>. Only applies to lines setting
	 * width with <gx:physicalWidth>; it does not apply to lines using <width>.
	 * See also <gx:drawOrder> in <LineString>. A draw order value may be
	 * necessary if dual-colored lines are crossing each other�for example, for
	 * showing freeway interchanges.
	 * 
	 * <gx:physicalWidth> 
	 * Physical width of the line, in meters.
	 * 
	 * <gx:labelVisibility> 
	 * A boolean defining whether or not to display a text
	 * label on a LineString. A LineString's label is contained in the <name>
	 * element that is a sibling of <LineString> (i.e. contained within the same
	 * <Placemark> element).
	 * 
	 */

	private float width;
	private Color gxOuterColor;
	private float gxOuterWidth;
	private float gxPhysicalWidth;
	private boolean gxLabelVisibility;
	
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public String getGxOuterColor() {
		if (this.gxOuterColor != null) {
			String hexString = "ff" + String.format("%02x", gxOuterColor.getBlue() & 0x00FF)
					+ String.format("%02x", gxOuterColor.getGreen() & 0x00FF) + String.format("%02x", gxOuterColor.getRed() & 0x00FF);
			return hexString;
		}
		return "ffffffff";
	}
	public void setGxOuterColor(Color gxOuterColor) {
		this.gxOuterColor = gxOuterColor;
	}
	public float getGxOuterWidth() {
		return gxOuterWidth;
	}
	public void setGxOuterWidth(float gxOuterWidth) {
		this.gxOuterWidth = gxOuterWidth;
	}
	public float getGxPhysicalWidth() {
		return gxPhysicalWidth;
	}
	public void setGxPhysicalWidth(float gxPhysicalWidth) {
		this.gxPhysicalWidth = gxPhysicalWidth;
	}
	public String isGxLabelVisibility() {
		
		return (gxLabelVisibility) ? "1" : "0";
	}
	public void setGxLabelVisibility(boolean gxLabelVisibility) {
		this.gxLabelVisibility = gxLabelVisibility;
	}
	
	public TreeNode<KML_element> getLinkedOutput (){
		
		TreeNode<KML_element> root = super.getLinkedOutput();
	
		root.addChild(new KML_element("width", Float.toString(this.getWidth()), false));
		root.addChild(new KML_element("gx:outerColor", getGxOuterColor(), true));
		root.addChild(new KML_element("gx:outerWidth", Float.toString(this.getGxOuterWidth()), true));
		root.addChild(new KML_element("gx:physicalWidth", Float.toString(this.getGxPhysicalWidth()), true));

		root.addChild(new KML_element("gx:labelVisibility", this.isGxLabelVisibility(), true));

		return root; 
	}
	
	

}
