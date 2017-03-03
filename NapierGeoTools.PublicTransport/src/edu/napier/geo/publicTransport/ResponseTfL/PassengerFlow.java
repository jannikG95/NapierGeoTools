package edu.napier.geo.publicTransport.ResponseTfL;

import java.io.Serializable;

public class PassengerFlow implements Serializable {
	/**
	 * Created with https://timboudreau.com/blog/json/read under Creative
	 * Commons CC BY-NC-SA 3.0 license. Author of the used software: Tim Boudreau.  
	 * Changes: Jan-Niklas Keiner 2017/03/02
	 * Changes: separation of inner classes, adding getter methods and making
	 * objects compatible to objects of the public transport project. License:
	 * https://creativecommons.org/licenses/by-nc-sa/3.0/legalcode
	 *
	 */
	private static final long serialVersionUID = 8553733278250893582L;
	private String timeSlice;
	private long value;

	public PassengerFlow(String timeSlice, long value) {
		this.timeSlice = timeSlice;
		this.value = value;
	}

	public String getTimeSlice() {
		return timeSlice;
	}

	public long getValue() {
		return value;
	}
}