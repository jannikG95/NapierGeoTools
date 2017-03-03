package edu.napier.geo.publicTransport.ResponseTfL;

import java.io.Serializable;

public class RouteOption implements Serializable {
	/**
	 * Created with https://timboudreau.com/blog/json/read under Creative
	 * Commons CC BY-NC-SA 3.0 license. Author of the used software: Tim Boudreau.  
	 * Changes: Jan-Niklas Keiner 2017/03/02
	 * Changes: separation of inner classes, adding getter methods and making
	 * objects compatible to objects of the public transport project. License:
	 * https://creativecommons.org/licenses/by-nc-sa/3.0/legalcode
	 */
	private static final long serialVersionUID = 1241781746601241299L;
	private String id;
	private String name;
	private String[] directions;
	private LineIdentifier lineIdentifier;

	public RouteOption(String id, String name, String[] directions, LineIdentifier lineIdentifier) {
		this.id = id;
		this.name = name;
		this.directions = directions;
		this.lineIdentifier = lineIdentifier;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String[] getDirections() {
		return directions;
	}

	public LineIdentifier getLineIdentifier() {
		return lineIdentifier;
	}
}