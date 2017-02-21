package KML_Object.geometry;

import java.util.ArrayList;

import HelperClasses.LinkedOutput;
import HelperClasses.StringBuilder;
import HelperClasses.TreeNode;
import KML_Object.KML_object;
import SharedClasses.Coordinates;

public class LinearRing extends KML_object implements KML_Geometry {

	private Double gxAltitudeOffset;
	private boolean extruded;
	private boolean tessellated;
	private String altitudeMode;
	private ArrayList<Coordinates> coordinates;

	public LinearRing(ArrayList<Coordinates> coordinates) {
		this.coordinates = coordinates;
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

	public ArrayList<Coordinates> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(ArrayList<Coordinates> coordinates) {
		this.coordinates = coordinates;
	}
	
	public TreeNode<LinkedOutput> getLinkedOutput (){
		
		TreeNode<LinkedOutput> root = super.getLinkedOutput();

		if(gxAltitudeOffset != null) root.addChild(new LinkedOutput("gx:altitudeOffse", Double.toString(this.getGxAltitudeOffset()), true));
		root.addChild(new LinkedOutput("extrude", this.isExtruded(), false));
		root.addChild(new LinkedOutput("tessellate", this.isTessellated(), false));
		root.addChild(new LinkedOutput("altitudeMode", this.getAltitudeMode(), false));
		root.addChild(new LinkedOutput("coordinates", StringBuilder.buildCoordinateString(this.coordinates), false));

		return root; 
	}
	
}
