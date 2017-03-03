package edu.napier.geo.publicTransport.ResponseTfL;

import java.io.Serializable;

public class Obstacle implements Serializable {
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
	 *
	 */
	private static final long serialVersionUID = -7394598504002139248L;
	private String type;
	private String incline;
	private long stopId;
	private String position;

	public Obstacle(String type, String incline, long stopId, String position) {
		this.type = type;
		this.incline = incline;
		this.stopId = stopId;
		this.position = position;
	}

	public String getType() {
		return type;
	}

	public String getIncline() {
		return incline;
	}

	public long getStopId() {
		return stopId;
	}

	public String getPosition() {
		return position;
	}
}