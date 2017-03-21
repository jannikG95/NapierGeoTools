package edu.napier.geo.publicTransport.ResponseTfL;

import java.io.Serializable;

              
public class LineGroup implements Serializable {
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
	private static final long serialVersionUID = 8488252049693950358L;
	private String naptanIdReference;
	private String stationAtcoCode;
	private String[] lineIdentifier;

	public LineGroup(String naptanIdReference, String stationAtcoCode, String[] lineIdentifier) {
		this.naptanIdReference = naptanIdReference;
		this.stationAtcoCode = stationAtcoCode;
		this.lineIdentifier = lineIdentifier;
	}

	public String getNaptanIdReference() {
		return naptanIdReference;
	}

	public String getStationAtcoCode() {
		return stationAtcoCode;
	}

	public String[] getLineIdentifier() {
		return lineIdentifier;
	}
}