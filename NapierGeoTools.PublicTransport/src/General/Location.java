package General;

import java.io.Serializable;

public class Location implements Serializable {

	double lat;
	double lon;
	String information;

	// public Location (Node n){
	// this.lat = n.getLat();
	// this.lon = n.getLon();
	// }

	public Location(double lat, double lon) {
		this.lat = lat;
		this.lon = lon;

	}

	public Location() {
		// TODO Auto-generated constructor stub
	}

	public boolean hasSameLocationAs(Location location) {
		System.out.println("Location-lasSameLocationAs");
		if (location.getLat() == this.getLat() && location.getLon() == this.getLon()) {
			System.out.println("true");
			return true;
		}
		System.out.println("false");
		return false;
	}

	public String print() {
		return "lat=" + this.getLat() + " long=" + this.getLon() + " information=" + this.getInformation();
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}
}
