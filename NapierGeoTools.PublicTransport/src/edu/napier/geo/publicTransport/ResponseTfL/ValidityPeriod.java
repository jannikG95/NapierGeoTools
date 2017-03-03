package edu.napier.geo.publicTransport.ResponseTfL;

import java.io.Serializable;

public class ValidityPeriod implements Serializable {
	/**
	 * Created with https://timboudreau.com/blog/json/read under Creative
	 * Commons CC BY-NC-SA 3.0 license. Author of the used software: Tim Boudreau.  
	 * Changes: Jan-Niklas Keiner 2017/03/02
	 * Changes: separation of inner classes, adding getter methods and making
	 * objects compatible to objects of the public transport project. License:
	 * https://creativecommons.org/licenses/by-nc-sa/3.0/legalcode
	 */
	private static final long serialVersionUID = -1618769253513354475L;
	private String fromDate;
	private String toDate;
	private boolean isNow;

	public ValidityPeriod(String fromDate, String toDate, boolean isNow) {
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.isNow = isNow;
	}

	public String getFromDate() {
		return fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public boolean isNow() {
		return isNow;
	}
}