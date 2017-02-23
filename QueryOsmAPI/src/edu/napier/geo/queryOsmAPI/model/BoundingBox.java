package edu.napier.geo.queryOsmAPI.model;

public class BoundingBox {
	double minlon;
	double maxlon;
	double minlat;
	double maxlat;
	
	public BoundingBox (double minlat, double minlon, double maxlat, double maxlon){
		this.minlon = minlon;
		this.maxlon = maxlon;
		this.minlat = minlat;
		this.maxlat = maxlat;
	}
	
	public double getMinlon() {
		return minlon;
	}
	public void setMinlon(double minlon) {
		this.minlon = minlon;
	}
	public double getMaxlon() {
		return maxlon;
	}
	public void setMaxlon(double maxlon) {
		this.maxlon = maxlon;
	}
	public double getMinlat() {
		return minlat;
	}
	public void setMinlat(double minlat) {
		this.minlat = minlat;
	}
	public double getMaxlat() {
		return maxlat;
	}
	public void setMaxlat(double maxlat) {
		this.maxlat = maxlat;
	}
}
