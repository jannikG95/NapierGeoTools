package edu.napier.geo.easykml.KML_Object.geometry;

import java.util.ArrayList;

import edu.napier.geo.common.Location;
import edu.napier.geo.easykml.KML_Object.KML_object;
import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.StringBuilder;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class LinearRing extends KML_Geometry  {

	private Double gxAltitudeOffset;
	private boolean extruded;
	private boolean tessellated;
	private String altitudeMode;
	private ArrayList<Location> locations;

	public LinearRing(ArrayList<Location> locations) {
		this.locations = locations;
	}

	public Double getGxAltitudeOffset() {
		return gxAltitudeOffset;
	}

	public void setGxAltitudeOffset(Double gxAltitudeOffset) {
		this.gxAltitudeOffset = gxAltitudeOffset;
	}

	public String isExtruded() {
		return (extruded) ? "1" : "0";
	}

	public void setExtruded(boolean extruded) {
		this.extruded = extruded;
	}

	public String isTessellated() {
		return (tessellated) ? "1" : "0";
	}

	public void setTessellated(boolean tessellated) {
		this.tessellated = tessellated;
	}

	public String getAltitudeMode() {
		return altitudeMode;
	}

	public void setAltitudeMode(String altitudeMode) {
		this.altitudeMode = altitudeMode;
	}

	public ArrayList<Location> getCoordinates() {
		return locations;
	}

	public void setCoordinates(ArrayList<Location> locations) {
		this.locations = locations;
	}
	
	public TreeNode<KML_element> getLinkedOutput (){
		
		TreeNode<KML_element> root = super.getLinkedOutput();

		if(gxAltitudeOffset != null) root.addChild(new KML_element("gx:altitudeOffse", Double.toString(this.getGxAltitudeOffset()), true));
		root.addChild(new KML_element("extrude", this.isExtruded(), false));
		root.addChild(new KML_element("tessellate", this.isTessellated(), false));
		root.addChild(new KML_element("altitudeMode", this.getAltitudeMode(), false));
		root.addChild(new KML_element("coordinates", StringBuilder.buildCoordinateString(this.locations), false));

		return root; 
	}
	
}
