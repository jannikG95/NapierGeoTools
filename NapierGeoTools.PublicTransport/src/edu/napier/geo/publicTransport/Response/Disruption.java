package edu.napier.geo.publicTransport.ResponseTfL;

import java.io.Serializable;

public class Disruption implements Serializable {
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
	private static final long serialVersionUID = 2970422519281775298L;
	private String category;
	private String type;
	private String categoryDescription;
	private String description;
	private String additionalInfo;
	private String created;
	private String lastUpdate;
	private AffectedRoute affectedRoutes[];
	private AffectedStop affectedStops[];
	private boolean isBlocking;
	private boolean isWholeLine;
	private String closureText;

	public Disruption(String category, String type, String categoryDescription, String description,
			String additionalInfo, String created, String lastUpdate, AffectedRoute[] affectedRoutes,
			AffectedStop[] affectedStops, boolean isBlocking, boolean isWholeLine, String closureText) {
		this.category = category;
		this.type = type;
		this.categoryDescription = categoryDescription;
		this.description = description;
		this.additionalInfo = additionalInfo;
		this.created = created;
		this.lastUpdate = lastUpdate;
		this.affectedRoutes = affectedRoutes;
		this.affectedStops = affectedStops;
		this.isBlocking = isBlocking;
		this.isWholeLine = isWholeLine;
		this.closureText = closureText;
	}

	public String getCategory() {
		return category;
	}

	public String getType() {
		return type;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public String getDescription() {
		return description;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public String getCreated() {
		return created;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public AffectedRoute[] getAffectedRoutes() {
		return affectedRoutes;
	}

	public AffectedStop[] getAffectedStops() {
		return affectedStops;
	}

	public boolean isBlocking() {
		return isBlocking;
	}

	public boolean isWholeLine() {
		return isWholeLine;
	}

	public String getClosureText() {
		return closureText;
	}
	
}