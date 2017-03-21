package edu.napier.geo.publicTransport.Response;

import java.io.Serializable;

public  class Time implements Serializable {
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
	private static final long serialVersionUID = 5226560175597841786L;
	private  String date;
    private  String time;
    private  String timeIs;
    private  String uri;

    public Time(String date, String time, String timeIs, String uri){
        this.date = date;
        this.time = time;
        this.timeIs = timeIs;
        this.uri = uri;
    }

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public String getTimeIs() {
		return timeIs;
	}

	public String getUri() {
		return uri;
	}
	public void print(){
		System.out.println(date + " " + time + " " + timeIs + " " + uri);
	}
    
}