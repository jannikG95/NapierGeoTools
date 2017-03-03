package edu.napier.geo.publicTransport.ResponseTfL;

import java.io.Serializable;

public class Path implements Serializable {
	/**
	 * Created with https://timboudreau.com/blog/json/read under Creative
	 * Commons CC BY-NC-SA 3.0 license. Author of the used software: Tim Boudreau.  
	 * Changes: Jan-Niklas Keiner 2017/03/02
	 * Changes: separation of inner classes, adding getter methods and making
	 * objects compatible to objects of the public transport project. License:
	 * https://creativecommons.org/licenses/by-nc-sa/3.0/legalcode
	 *
	 */
	private static final long serialVersionUID = 724258036827721261L;
	private String lineString;
	private StopPointInPath stopPoints[];
	private Elevation elevation[];

	public Path(String lineString, StopPointInPath[] stopPoints, Elevation[] elevation) {
		this.lineString = lineString;
		this.stopPoints = stopPoints;
		this.elevation = elevation;
	}

	public String getLineString() {
		return lineString;
	}

	public StopPointInPath[] getStopPoints() {
		return stopPoints;
	}

	public Elevation[] getElevation() {
		return elevation;
	}
}