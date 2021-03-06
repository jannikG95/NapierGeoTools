package edu.napier.geo.publicTransport.Response;

import java.io.Serializable;

public class PlannedWork implements Serializable {
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
	private static final long serialVersionUID = 4895469514888889614L;
	private String id;
	private String description;
	private String createdDateTime;
	private String lastUpdateDateTime;

	public PlannedWork(String id, String description, String createdDateTime, String lastUpdateDateTime) {
		this.id = id;
		this.description = description;
		this.createdDateTime = createdDateTime;
		this.lastUpdateDateTime = lastUpdateDateTime;
	}

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getCreatedDateTime() {
		return createdDateTime;
	}

	public String getLastUpdateDateTime() {
		return lastUpdateDateTime;
	}
}