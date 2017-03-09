package edu.napier.geo.publicTransport.ResponseTfL;

import java.io.Serializable;

public class LineStatuse implements Serializable {
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
	private static final long serialVersionUID = -8123336807052058357L;
	private long id;
	private String lineId;
	private long statusSeverity;
	private String statusSeverityDescription;
	private String reason;
	private String created;
	private String modified;
	private ValidityPeriod validityPeriods[];
	private Disruption disruption;

	public LineStatuse(long id, String lineId, long statusSeverity, String statusSeverityDescription,
			String reason, String created, String modified, ValidityPeriod[] validityPeriods,
			Disruption disruption) {
		this.id = id;
		this.lineId = lineId;
		this.statusSeverity = statusSeverity;
		this.statusSeverityDescription = statusSeverityDescription;
		this.reason = reason;
		this.created = created;
		this.modified = modified;
		this.validityPeriods = validityPeriods;
		this.disruption = disruption;
	}

	public long getId() {
		return id;
	}

	public String getLineId() {
		return lineId;
	}

	public long getStatusSeverity() {
		return statusSeverity;
	}

	public String getStatusSeverityDescription() {
		return statusSeverityDescription;
	}

	public String getReason() {
		return reason;
	}

	public String getCreated() {
		return created;
	}

	public String getModified() {
		return modified;
	}

	public ValidityPeriod[] getValidityPeriods() {
		return validityPeriods;
	}

	public Disruption getDisruption() {
		return disruption;
	}
}