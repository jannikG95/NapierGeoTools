package edu.napier.geo.publicTransport.ResponseTfL;

import java.io.Serializable;

public class Line implements Serializable {
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
	 
	private static final long serialVersionUID = -5052037762366090470L;
	private String id;
	private String name;
	private String modeName;
	private Disruption disruptions[];
	private String created;
	private String modified;
	private LineStatuse lineStatuses[];
	private RouteSection routeSections[];
	private ServiceType serviceTypes[];
	private Crowding crowding;

	public Line(String id, String name, String modeName, Disruption[] disruptions, String created, String modified,
			LineStatuse[] lineStatuses, RouteSection[] routeSections, ServiceType[] serviceTypes, Crowding crowding) {
		this.id = id;
		this.name = name;
		this.modeName = modeName;
		this.disruptions = disruptions;
		this.created = created;
		this.modified = modified;
		this.lineStatuses = lineStatuses;
		this.routeSections = routeSections;
		this.serviceTypes = serviceTypes;
		this.crowding = crowding;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getModeName() {
		return modeName;
	}

	public Disruption[] getDisruptions() {
		return disruptions;
	}

	public String getCreated() {
		return created;
	}

	public String getModified() {
		return modified;
	}

	public LineStatuse[] getLineStatuses() {
		return lineStatuses;
	}

	public RouteSection[] getRouteSections() {
		return routeSections;
	}

	public ServiceType[] getServiceTypes() {
		return serviceTypes;
	}

	public Crowding getCrowding() {
		return crowding;
	}

}