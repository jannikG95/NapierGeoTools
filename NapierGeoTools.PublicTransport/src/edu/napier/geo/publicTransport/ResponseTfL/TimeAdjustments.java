package edu.napier.geo.publicTransport.ResponseTfL;

import java.io.Serializable;

public  class TimeAdjustments implements Serializable {
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
	private static final long serialVersionUID = -4011571634618605751L;
	private  Time earliest;
    private  Time earlier;
    private  Time later;
    private  Time latest;

    public TimeAdjustments(Time earliest, Time earlier, Time later, Time latest){
        this.earliest = earliest;
        this.earlier = earlier;
        this.later = later;
        this.latest = latest;
    }

	public Time getEarliest() {
		return earliest;
	}

	public Time getEarlier() {
		return earlier;
	}

	public Time getLater() {
		return later;
	}

	public Time getLatest() {
		return latest;
	}
}