package edu.napier.geo.common;

/*
 * An abstract class that defines a geographical location.
 * The basic coordinate system is lattitude and longitude.
 * 
 * Neil Urquhart 21/2/17
 * 
 */
public class Location {
	//Base location. Set by constructor and not changed
	protected double lat = 0;
	protected double lon =0;
	
	//A Desctiption of the point
	protected String description=null;
	
	//Holds a string that denotes what data source supplied the point
	protected String source=null;
	
	//Constructor
	/*
	 * Thorw an illegal argument exception, if we try to setup a location
	 * that is not legal within the lat/lon system
	 */
	public Location(double aLat, double aLon) throws IllegalArgumentException{
		//Validate
		if ((aLat < -90)||(aLat > 90))
			throw new IllegalArgumentException();
		
		if ((aLon < -180)||(aLon > 180))
			throw new IllegalArgumentException();
		lat = aLat;
		lon = aLon;
	}

	//Accessors
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}	
	
	/*
	 * To String
	 */
	public String toString(){
		String buffer;
		buffer = lat +"," + lon;
		
		if (description != null)
			buffer += ", " + description;
		
		if (source != null)
			buffer += ", " + source;
			
		return buffer;
	}
}
