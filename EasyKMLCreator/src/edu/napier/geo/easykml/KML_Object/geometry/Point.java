package edu.napier.geo.easykml.KML_Object.geometry;

import edu.napier.geo.common.Location;
import edu.napier.geo.easykml.KML_Object.KML_object;
import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.StringBuilder;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class Point extends KML_Geometry {

	private Location location;
	private String altitudeMode;
	private Boolean extruded;

	/**
	 * A point defines a geographical location on the map. For more information
	 * visit:
	 * {@link: https://developers.google.com/kml/documentation/kmlreference#point}
	 * 
	 * @param location
	 */
	public Point(Location location) {
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String isExtruded() {
		return (extruded) ? "1" : "0";
	}

	public void setExtruded(Boolean extruded) {
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

	public TreeNode<KML_element> getLinkedOutput() {

		TreeNode<KML_element> root = super.getLinkedOutput();

		if (this.extruded != null)
			root.addChild(new KML_element("extrude", this.isExtruded(), false));
		if (this.getAltitudeMode() != null)
			root.addChild(new KML_element("altitudeMode", this.getAltitudeMode(), false));
		if (this.getLocation() != null)
			root.addChild(new KML_element("coordinates", StringBuilder.buildCoordinateString(this.location), false));

		return root;
	}

}
