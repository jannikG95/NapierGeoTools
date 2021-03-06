package edu.napier.geo.publicTransport.Response;

import java.io.Serializable;

public class TflJourney implements Serializable{
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
	private static final long serialVersionUID = -3904682688521542643L;
	private String startDateTime;
	private int duration;
	private String arrivalDateTime;
	private Leg legs[];

	public TflJourney(String startDateTime, int duration, String arrivalDateTime, Leg[] legs) {
		this.startDateTime = startDateTime;
		this.duration = duration;
		this.arrivalDateTime = arrivalDateTime;
		this.legs = legs;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public int getDurationMinutes() {
		return duration;
	}

	public String getArrivalDateTime() {
		return arrivalDateTime;
	}

	public Leg[] getLegs() {
		return legs;
	}
}