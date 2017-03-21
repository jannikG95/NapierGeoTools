package edu.napier.geo.publicTransport.ResponseTfL;

import java.io.Serializable;

public  class TrainLoading implements Serializable {
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
	private static final long serialVersionUID = 4506059362529463983L;
	private  String line;
    private  String lineDirection;
    private  String platformDirection;
    private  String direction;
    private  String naptanTo;
    private  String timeSlice;
    private  long value;

    public TrainLoading(String line, String lineDirection, String platformDirection, String direction, String naptanTo, String timeSlice, long value){
        this.line = line;
        this.lineDirection = lineDirection;
        this.platformDirection = platformDirection;
        this.direction = direction;
        this.naptanTo = naptanTo;
        this.timeSlice = timeSlice;
        this.value = value;
    }

	public String getLine() {
		return line;
	}

	public String getLineDirection() {
		return lineDirection;
	}

	public String getPlatformDirection() {
		return platformDirection;
	}

	public String getDirection() {
		return direction;
	}

	public String getNaptanTo() {
		return naptanTo;
	}

	public String getTimeSlice() {
		return timeSlice;
	}

	public long getValue() {
		return value;
	}
}