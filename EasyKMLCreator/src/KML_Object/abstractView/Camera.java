package KML_Object.abstractView;

import HelperClasses.LinkedOutput;
import HelperClasses.TreeNode;
import SharedClasses.Coordinates;

public class Camera extends AbstractView {

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
	private Coordinates coordinates;

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
	 * <roll> 
	 * Rotation, in degrees, of the camera around the Z axis. Values
	 * range from -180 to +180 degrees.
	 */
	private double roll;
	
	/*
	 * <altitudeMode>
	 * Specifies how the <altitude> specified for the LookAt point is
	 * interpreted.
	 */
	private String altitudeMode;

	
	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public double getHeading() {
		return heading;
	}

	public void setHeading(double heading) {
		if (heading <= 360 && heading >= -360)
			this.heading = heading;
	}

	public double getTilt() {
		return tilt;
	}

	public void setTilt(double tilt) {
		if (tilt <= 180 && tilt >= 0)
			this.tilt = tilt;
	}

	public double getRoll() {
		return roll;
	}

	public void setRoll(double roll) {
		if (roll <= 180 && roll >= -180)
			this.roll = roll;
	}

	public String getAltitudeMode() {
		return altitudeMode;
	}

	public void setAltitudeMode(String altitudeMode) {
		this.altitudeMode = altitudeMode;
	}
	
	
	public TreeNode<LinkedOutput> getLinkedOutput (){
		
		TreeNode<LinkedOutput> root = new TreeNode<LinkedOutput>(new LinkedOutput(this.getClass().getSimpleName(), "", false));
		root.addChild(new LinkedOutput("id", this.getId(), false));

		root.addChild(new LinkedOutput("longitude", Double.toString(this.getCoordinates().getLongitude()), false));
		root.addChild(new LinkedOutput("latitude", Double.toString(this.getCoordinates().getLatitude()), false));
		root.addChild(new LinkedOutput("altitude", Double.toString(this.getCoordinates().getAltitude()), false));
		root.addChild(new LinkedOutput("heading", Double.toString(this.getHeading()), false));
		root.addChild(new LinkedOutput("tilt", Double.toString(this.getTilt()), false));
		root.addChild(new LinkedOutput("roll", Double.toString(this.getRoll()), false));
		root.addChild(new LinkedOutput("altitudeMode", this.getAltitudeMode(), false));


		return root; 
	}
	
	
	
	
}
