package edu.napier.geo.queryOsmAPI.model;

/** 
 * @author Johannes Nguyen 
 * A class to conduct the queries
 */
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import edu.napier.geo.common.Location;


public class Query {
	BoundingBox range;
	String tagForSearch;
	double radius; 							//in kilometers
	Location currentLocation;
	OSMParser parser;
	BoundingBox box;
	
	public Query (String tagForSearch, Location currentLocation, OSMParser parser){
		this.radius = 5.0;					//default 5km
		this.tagForSearch = tagForSearch;
		this.currentLocation = currentLocation;
		this.parser = parser;
	}

	public Query (double radius, String tagForSearch, Location currentLocation, OSMParser parser){
		this.radius = radius;
		this.tagForSearch = tagForSearch;
		this.currentLocation = currentLocation;
		this.parser = parser;
	}
	
	public Query (BoundingBox box, String tagForSearch, OSMParser parser){
		this.box = box;
		this.tagForSearch = tagForSearch;
		this.parser = parser;
	}

	public ArrayList <Location> conductQuery(){
		ArrayList <Location> locationList = new ArrayList <Location>();
		TreeMap<String, ArrayList<String>> tagList = parser.getTagList().getListOfTags();
		Map<String,Element> nodeList = parser.getElements();
		
		for( String s : tagList.get(tagForSearch)){
			Node n = (Node) nodeList.get(s);
			Location l = n.getLocation();
			Boolean withinRange = withinRange(radius, currentLocation, n);
			if (withinRange == true)
			locationList.add(l);
			
		}
		
		return locationList;
	}
	
	public ArrayList <Location> conductQueryWithBoundingBox(BoundingBox box){
		ArrayList <Location> locationList = new ArrayList <Location>();
		TreeMap<String, ArrayList<String>> tagList = parser.getTagList().getListOfTags();
		Map<String,Element> nodeList = parser.getElements();
		
		for( String s : tagList.get(tagForSearch)){
			Node n = (Node) nodeList.get(s);
			Location l = n.getLocation();
			Boolean withinRange = withinBoundingBox(box, n);
			if (withinRange == true)
			locationList.add(l);
			
		}
		
		return locationList;
	}
	
	
	public Boolean withinRange(double radius, Location currentLocation, Node node){
		// calculation using Haversine formula
		double lat1 = currentLocation.getLat();
		double lon1 = currentLocation.getLon();
		double lat2 = node.getLocation().getLat();
		double lon2 = node.getLocation().getLon();
		
		double distance = haversine(lat1, lon1, lat2, lon2);
		System.out.println("Distance between currentLocation and foundLocation: "+distance + " NodeID: "+node.getId());
		
		if (distance <= radius)
			return true;
		
		else 
			return false;
	}
	
	//Harversine distance calculation
	 public static final double R = 6372.8; // In kilometers
	 public static double haversine(double lat1, double lon1, double lat2, double lon2) {
	        double dLat = Math.toRadians(lat2 - lat1);
	        double dLon = Math.toRadians(lon2 - lon1);
	        lat1 = Math.toRadians(lat1);
	        lat2 = Math.toRadians(lat2);
	 
	        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
	        double c = 2 * Math.asin(Math.sqrt(a));
	        return R * c;
	    }
	 
	 
 public Boolean withinBoundingBox (BoundingBox box, Node node ){
	 Location nodeLocation = node.getLocation();
	 if(nodeLocation.getLat() <=  box.maxlat && nodeLocation.getLat()>= box.getMinlat() 
			 && nodeLocation.getLon()<= box.getMaxlon() && nodeLocation.getLon()>= box.getMinlon())
		 return true;
	 
	 else
		 return false;
 }
	
	public BoundingBox getRange() {
		return range;
	}

	public void setRange(BoundingBox range) {
		this.range = range;
	}

	public String getSearchForTag() {
		return tagForSearch;
	}

	public void setSearchForTag(String searchForTag) {
		this.tagForSearch = searchForTag;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Location getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}

	
	
}
