package SharedClasses;

public class Coordinates {

	private Double longitude;
	private Double latitude;
	private Double altitude;
	
	public Coordinates(Double longitude,Double latitude,Double altitude) {
		this.longitude = longitude;
		this.latitude = latitude; 
		this.altitude = altitude;
	}

	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getAltitude() {
		return altitude;
	}
	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}

}
