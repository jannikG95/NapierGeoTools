package edu.napier.geo.publicTransport.Response;

import java.io.Serializable;
import edu.napier.geo.common.Location;

public class Step extends Location implements Serializable {
	/**
	 * Created with https://timboudreau.com/blog/json/read under Creative
	 * Commons CC BY-NC-SA 3.0 license. Author of the used software: Tim Boudreau.  
	 * Changes: Jan-Niklas Keiner 2017/03/02
	 * Changes: separation of inner classes, adding getter methods and making
	 * objects compatible to objects of the public transport project. License:
	 * https://creativecommons.org/licenses/by-nc-sa/3.0/legalcode
	 * 
	 * 
	 * Class based on JSON Response of the TfL API format with a few changes
	 * (like storing lon and lat in Locations). See empty example response in
	 * documentation.
	 *
	 */
	private static final long serialVersionUID = -5809255402033736238L;
//	private String description;
	private String turnDirection;
	private String streetName;
	private long distance;
	private long cumulativeDistance;
	private long skyDirection;
	private String skyDirectionDescription;
	private long cumulativeTravelTime;
	private Location location;
//	private double latitude;
//	private double longitude;
	private PathAttribute pathAttribute;
	private String descriptionHeading;
	private String trackType;

//	public Step(String description, String turnDirection, String streetName, long distance, long cumulativeDistance,
//			long skyDirection, String skyDirectionDescription, long cumulativeTravelTime, double latitude,
//			double longitude, PathAttribute pathAttribute, String descriptionHeading, String trackType) {
		public Step(String description, String turnDirection, String streetName, long distance, long cumulativeDistance,
				long skyDirection, String skyDirectionDescription, long cumulativeTravelTime, double lat,
				double lon, PathAttribute pathAttribute, String descriptionHeading, String trackType) {
		this.description = description;
		this.turnDirection = turnDirection;
		this.streetName = streetName;
		this.distance = distance;
		this.cumulativeDistance = cumulativeDistance;
		this.skyDirection = skyDirection;
		this.skyDirectionDescription = skyDirectionDescription;
		this.cumulativeTravelTime = cumulativeTravelTime;
		this.pathAttribute = pathAttribute;
		this.descriptionHeading = descriptionHeading;
		this.trackType = trackType;
	}

	public String getDescription() {
		return description;
	}

	public String getTurnDirection() {
		return turnDirection;
	}

	public String getStreetName() {
		return streetName;
	}

	public long getDistance() {
		return distance;
	}

	public long getCumulativeDistance() {
		return cumulativeDistance;
	}

	public long getSkyDirection() {
		return skyDirection;
	}

	public String getSkyDirectionDescription() {
		return skyDirectionDescription;
	}

	public long getCumulativeTravelTime() {
		return cumulativeTravelTime;
	}

	public Location getLocation() {
		return location;
	}

	public PathAttribute getPathAttribute() {
		return pathAttribute;
	}

	public String getDescriptionHeading() {
		return descriptionHeading;
	}

	public String getTrackType() {
		return trackType;
	}
}