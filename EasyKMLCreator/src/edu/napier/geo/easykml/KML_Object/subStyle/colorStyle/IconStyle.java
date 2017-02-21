package edu.napier.geo.easykml.KML_Object.subStyle.colorStyle;

import edu.napier.geo.easykml.helperClasses.LinkedOutput;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class IconStyle extends ColorStyle {

	/*
	 * Information area (Source: KML Reference Google):
	 * 
	 * <scale> Resizes the icon.
	 * 
	 * <heading> Direction (that is, North, South, East, West), in degrees.
	 * Default=0 (North). Values range from 0 to 360 degrees.
	 * 
	 * <Icon> 
	 * A custom Icon. In <IconStyle>, the only child element of <Icon> is
	 * <href>: 
	 * 		<href>: An HTTP address or a local file specification used to
	 * 		load an icon.
	 */

	private float scale;
	private float heading; // Value range from 0 to 360
	private String iconHttpAddress;

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public float getHeading() {
		return heading;
	}

	public void setHeading(float heading) {
		if (this.heading > 360 || this.heading < 0) this.heading = 0;
		else this.heading = heading;
	}

	public String getIconHttpAddress() {
		return iconHttpAddress;
	}

	public void setIconHttpAddress(String iconHttpAddress) {
		this.iconHttpAddress = iconHttpAddress;
	}

	public TreeNode<LinkedOutput> getLinkedOutput (){
		
		TreeNode<LinkedOutput> root = super.getLinkedOutput();
	
		root.addChild(new LinkedOutput("scale", Float.toString(this.getScale()), false));
		root.addChild(new LinkedOutput("heading", Float.toString(this.getHeading()), false));
		root.addChild(new LinkedOutput("Icon", null, false)).addChild(new LinkedOutput("href", this.getIconHttpAddress(), false));

		return root; 
	}

	
}
