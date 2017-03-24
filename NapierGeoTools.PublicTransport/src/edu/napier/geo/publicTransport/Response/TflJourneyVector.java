package edu.napier.geo.publicTransport.Response;

import java.io.Serializable;

public  class TflJourneyVector implements Serializable {
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
	private static final long serialVersionUID = 5659194568193047918L;
	private  String from;
    private  String to;
    private  String via;
    private  String uri;

    public TflJourneyVector(String from, String to, String via, String uri){
        this.from = from;
        this.to = to;
        this.via = via;
        this.uri = uri;
    }

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getVia() {
		return via;
	}

	public String getUri() {
		return uri;
	}
}