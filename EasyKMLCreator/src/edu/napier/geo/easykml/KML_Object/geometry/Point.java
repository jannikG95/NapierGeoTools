package edu.napier.geo.easykml.KML_Object.geometry;


import edu.napier.geo.common.Location;
import edu.napier.geo.easykml.KML_Object.KML_object;
import edu.napier.geo.easykml.helperClasses.LinkedOutput;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class Point extends KML_Geometry{

	private Location location;
	private String altitudeMode;
	private boolean extruded = false;


	public Point(Location location) {
		this.location = location;
	}
	
	public String isExtruded() {
		return (extruded) ? "1" : "0";
	}

	public void setExtruded(boolean extruded) {
		this.extruded = extruded;
	}
	
	public String getAltitudeMode() {
		return altitudeMode;
	}

	public void setAltitudeMode(String altitudeMode) {
		this.altitudeMode = altitudeMode;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return location.getLon() + "," + location.getLat() + "," + location.getAlt() + " ";
	}
	
	public TreeNode<LinkedOutput> getLinkedOutput (){
		
		TreeNode<LinkedOutput> root = super.getLinkedOutput();

		root.addChild(new LinkedOutput("extrude", this.isExtruded(), false));
		root.addChild(new LinkedOutput("altitudeMode", this.getAltitudeMode(), false));
		root.addChild(new LinkedOutput("coordinates", this.toString(), false));

		return root; 
	}
	
}
