package edu.napier.geo.easykml.KML_Object.abstractView;

import edu.napier.geo.common.Location;
import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class LookAt extends AbstractView {

	/*
	 * <longitude> Longitude of the point the camera is looking at. Angular
	 * distance in degrees, relative to the Prime Meridian. Values west of the
	 * Meridian range from -180 to 0 degrees. Values east of the Meridian range
	 * from 0 to 180 degrees.
	 * 
	 * <latitude> Latitude of the point the camera is looking at. Degrees north
	 * or south of the Equator (0 degrees). Values range from -90 degrees to 90
	 * degrees.
	 * 
	 * <altitude> Distance from the earth's surface, in meters. Interpreted
	 * according to the LookAt's altitude mode.
	 */
	private Location coordinates;

	/*
	 * <heading> Direction (that is, North, South, East, West), in degrees.
	 * Default=0 (North). (See diagram below.) Values range from 0 to 360
	 * degrees.
	 */
	private double heading;

	/*
	 * <tilt> Angle between the direction of the LookAt position and the normal
	 * to the surface of the earth. (See diagram below.) Values range from 0 to
	 * 90 degrees. Values for <tilt> cannot be negative. A <tilt> value of 0
	 * degrees indicates viewing from directly above. A <tilt> value of 90
	 * degrees indicates viewing along the horizon.
	 */
	private double tilt;

	/*
	 * <range>(required) Distance in meters from the point specified by
	 * <longitude>, <latitude>, and <altitude> to the LookAt position. (See
	 * diagram below.)
	 */
	private double range;

	/*
	 * <altitudeMode> Specifies how the <altitude> specified for the LookAt
	 * point is interpreted.
	 */
	private String altitudeMode;
	

	public Location getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Location coordinates) {
		this.coordinates = coordinates;
	}

	public double getHeading() {
		return heading;
	}

	public void setHeading(double heading) {
		if (heading <= 360 && heading >= 0)
			this.heading = heading;
	}

	public double getTilt() {
		return tilt;
	}

	public void setTilt(double tilt) {
		if (tilt <= 90 && tilt >= 0)
			this.tilt = tilt;
	}

	public double getRange() {
		return range;
	}

	public void setRange(double range) {
		this.range = range;
	}

	public String getAltitudeMode() {
		return altitudeMode;
	}

	public void setAltitudeMode(String altitudeMode) {
		this.altitudeMode = altitudeMode;
	}
	
	public TreeNode<KML_element> getLinkedOutput (){
		
		TreeNode<KML_element> root = new TreeNode<KML_element>(new KML_element(this.getClass().getSimpleName(), "", false));
		root.addChild(new KML_element("id", this.getId(), false));

		root.addChild(new KML_element("longitude", Double.toString(this.getCoordinates().getLon()), false));
		root.addChild(new KML_element("latitude", Double.toString(this.getCoordinates().getLat()), false));
		root.addChild(new KML_element("altitude", Double.toString(this.getCoordinates().getAlt()), false));
		root.addChild(new KML_element("heading", Double.toString(this.getHeading()), false));
		root.addChild(new KML_element("tilt", Double.toString(this.getTilt()), false));
		root.addChild(new KML_element("range", Double.toString(this.getRange()), false));
		root.addChild(new KML_element("altitudeMode", this.getAltitudeMode(), false));


		return root; 
	}
	

}
