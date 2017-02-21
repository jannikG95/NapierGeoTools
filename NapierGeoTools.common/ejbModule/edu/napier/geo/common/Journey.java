package edu.napier.geo.common;
/*
 * A basic class to represent a journey that links two locations
 * 
 * Neil Urquhart 21/2/17
 */
public class Journey {
	
	/*
	* The journey takes place between A and B 
	*/
	protected Location locationA;
	protected Location locationB;
	
	protected double distanceKM=-1; 
	// The distance travelled in KM 
	protected double travelTimeMS=-1; 
	// Traveltime in MSecs

	protected String description=null; 
	// An optional description of the journey
	protected String source=null; 
	//An optional source of the journey data 
	
	/*
	* Constructor
	*/
	public Journey(Location a, Location b){
		locationA = a;
		locationB = b;
	}

	/*
	 * Accessor Methods
	 * 
	 */
	public double getDistanceKM() {
		return distanceKM;
	}

	public void setDistanceKM(double distanceKM) {
		this.distanceKM = distanceKM;
	}

	public double getTravelTimeMS() {
		return travelTimeMS;
	}

	public void setTravelTimeMS(double travelTimeMS) {
		this.travelTimeMS = travelTimeMS;
	}

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

	public Location getPointA() {
		return locationA;
	}

	public Location getPointB() {
		return locationB;
	}
	
	/*
	 * ToString
	 * 
	 */
	public String toString(){
		String buffer ="";
		
		buffer = locationA + " : " + locationB;
		
		if (description != null)
			buffer += ", " +description;
		
		if (source != null)
			buffer += ", " +source;
		
		return buffer;
	}
}
