package edu.napier.geo.publicTransport.ResponseTfL;

import java.io.Serializable;

public class AffectedRoute implements Serializable {
	/**
	 * Created with https://timboudreau.com/blog/json/read under Creative
	 * Commons CC BY-NC-SA 3.0 license. Author of the used software: Tim Boudreau.  
	 * Changes: Jan-Niklas Keiner 2017/03/02
	 * Changes: separation of inner classes, adding getter methods and making
	 * objects compatible to objects of the public transport project. License:
	 * https://creativecommons.org/licenses/by-nc-sa/3.0/legalcode
	 */
	private static final long serialVersionUID = 1302793574501099922L;
	private String id;
	private String lineId;
	private String routeCode;
	private String name;
	private String direction;
	private String lineString;
	private String originationName;
	private String destinationName;
	private RouteSectionNaptanEntrySequence routeSectionNaptanEntrySequence[];

	public AffectedRoute(String id, String lineId, String routeCode, String name, String direction,
			String lineString, String originationName, String destinationName,
			RouteSectionNaptanEntrySequence[] routeSectionNaptanEntrySequence) {
		this.id = id;
		this.lineId = lineId;
		this.routeCode = routeCode;
		this.name = name;
		this.direction = direction;
		this.lineString = lineString;
		this.originationName = originationName;
		this.destinationName = destinationName;
		this.routeSectionNaptanEntrySequence = routeSectionNaptanEntrySequence;
	}


	public String getId() {
		return id;
	}

	public String getLineId() {
		return lineId;
	}

	public String getRouteCode() {
		return routeCode;
	}

	public String getName() {
		return name;
	}

	public String getDirection() {
		return direction;
	}

	public String getLineString() {
		return lineString;
	}

	public String getOriginationName() {
		return originationName;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public RouteSectionNaptanEntrySequence[] getRouteSectionNaptanEntrySequence() {
		return routeSectionNaptanEntrySequence;
	}
	
	
}