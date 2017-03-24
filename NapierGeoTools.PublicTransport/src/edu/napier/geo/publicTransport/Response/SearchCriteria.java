package edu.napier.geo.publicTransport.Response;

import java.io.Serializable;

public  class SearchCriteria implements Serializable {
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
	private static final long serialVersionUID = 4605699731428925347L;
	private  String dateTime;
    private  String dateTimeType;
    private  TimeAdjustments timeAdjustments;

    public SearchCriteria(String dateTime, String dateTimeType, TimeAdjustments timeAdjustments){
        this.dateTime = dateTime;
        this.dateTimeType = dateTimeType;
        this.timeAdjustments = timeAdjustments;
    }

	public String getDateTime() {
		return dateTime;
	}

	public String getDateTimeType() {
		return dateTimeType;
	}

	public TimeAdjustments getTimeAdjustments() {
		return timeAdjustments;
	}
}