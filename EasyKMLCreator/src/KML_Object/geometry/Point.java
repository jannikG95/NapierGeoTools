package KML_Object.geometry;

import HelperClasses.LinkedOutput;
import HelperClasses.TreeNode;
import KML_Object.KML_object;
import SharedClasses.Coordinates;

public class Point extends KML_object implements KML_Geometry{

	private Coordinates coordinates;
	private String altitudeMode;
	private boolean extruded = false;


	public Point(Coordinates coordinates) {
		this.coordinates = coordinates;
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
		return coordinates.getLongitude() + "," + coordinates.getLatitude() + "," + coordinates.getAltitude() + " ";
	}
	
	public TreeNode<LinkedOutput> getLinkedOutput (){
		
		TreeNode<LinkedOutput> root = super.getLinkedOutput();

		root.addChild(new LinkedOutput("extrude", this.isExtruded(), false));
		root.addChild(new LinkedOutput("altitudeMode", this.getAltitudeMode(), false));
		root.addChild(new LinkedOutput("coordinates", this.toString(), false));

		return root; 
	}
	
}
