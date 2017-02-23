package ResponseTfL;

public class Elevation {
	private long distance;
	private double startLat;
	private double startLon;
	private double endLat;
	private double endLon;
	private long heightFromPreviousPoint;
	private long gradient;

	public Elevation(long distance, double startLat, double startLon, double endLat, double endLon,
			long heightFromPreviousPoint, long gradient) {
		this.distance = distance;
		this.startLat = startLat;
		this.startLon = startLon;
		this.endLat = endLat;
		this.endLon = endLon;
		this.heightFromPreviousPoint = heightFromPreviousPoint;
		this.gradient = gradient;
	}

	public long getDistance() {
		return distance;
	}

	public double getStartLat() {
		return startLat;
	}

	public double getStartLon() {
		return startLon;
	}

	public double getEndLat() {
		return endLat;
	}

	public double getEndLon() {
		return endLon;
	}

	public long getHeightFromPreviousPoint() {
		return heightFromPreviousPoint;
	}

	public long getGradient() {
		return gradient;
	}

}