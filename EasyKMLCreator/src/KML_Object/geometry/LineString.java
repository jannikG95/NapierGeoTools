package KML_Object.geometry;

import java.util.ArrayList;

import HelperClasses.LinkedOutput;
import HelperClasses.StringBuilder;
import HelperClasses.TreeNode;
import KML_Object.KML_object;
import SharedClasses.Coordinates;

public class LineString extends KML_object implements KML_Geometry {

	private Double gxAltitudeOffset;
	private boolean extruded;
	private boolean tessellated;
	private String altitudeMode;
	private int gxDrawOrder;
	private ArrayList<Coordinates> coordinates;

	/*
	 * Information Area (Source: KML Reference Google Developers):
	 * 
	 * <extrude> Boolean value. Specifies whether to connect the LinearRing to
	 * the ground. To extrude this geometry, the altitude mode must be either
	 * relativeToGround, relativeToSeaFloor, or absolute. Only the vertices of
	 * the LinearRing are extruded, not the center of the geometry. The vertices
	 * are extruded toward the center of the Earth's sphere.
	 * 
	 * <tessellate> Boolean value. Specifies whether to allow the LinearRing to
	 * follow the terrain. To enable tessellation, the value for <altitudeMode>
	 * must be clampToGround or clampToSeaFloor. Very large LinearRings should
	 * enable tessellation so that they follow the curvature of the earth
	 * (otherwise, they may go underground and be hidden).
	 * 
	 * <altitudeMode> Specifies how altitude components in the <coordinates>
	 * element are interpreted. Further information are available in the
	 * AltitudeModes class.
	 */

	public LineString(ArrayList<Coordinates> coordinates) {
		this.coordinates = coordinates;
	}

	public Double getGxAltitudeOffset() {
		return gxAltitudeOffset;
	}

	public void setGxAltitudeOffset(Double gxAltitudeOffset) {
		this.gxAltitudeOffset = gxAltitudeOffset;
	}

	public int getGxDrawOrder() {
		return gxDrawOrder;
	}

	public void setGxDrawOrder(int gxDrawOrder) {
		this.gxDrawOrder = gxDrawOrder;
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

		if(gxAltitudeOffset != null)root.addChild(new LinkedOutput("gx:altitudeOffse", Double.toString(this.getGxAltitudeOffset()), true));
		root.addChild(new LinkedOutput("extrude", this.isExtruded(), false));
		root.addChild(new LinkedOutput("tessellate", this.isTessellated(), false));
		root.addChild(new LinkedOutput("altitudeMode", this.getAltitudeMode(), false));
		root.addChild(new LinkedOutput("gx:drawOrder", Integer.toString(this.getGxDrawOrder()), true));
		root.addChild(new LinkedOutput("coordinates", StringBuilder.buildCoordinateString(this.coordinates), false));

		return root; 
	}

//	private void checkExtrudedPreconditions(boolean extrudedValue, String altitudeMode) {
//		if (extrudedValue == true && (altitudeMode != AltitudeModes.RELATIVE_TO_GROUND
//				|| altitudeMode != AltitudeModes.RELATIVE_TO_SEA_FLOOR || altitudeMode != AltitudeModes.ABSOLUT)) {
//			this.extruded = false;
//		} else {
//			this.extruded = extrudedValue;
//		}
//	}
//
//	private void checkTesselatedPreconditions(boolean tesselatedValue, String altitudeMode) {
//		if (tesselatedValue == true && (altitudeMode != AltitudeModes.CLAMP_TO_GROUND
//				|| altitudeMode != AltitudeModes.CLAMP_TO_SEA_FLOOR)) {
//			this.tessellated = false;
//		} else {
//			this.extruded = tesselatedValue;
//		}
//	}

}
