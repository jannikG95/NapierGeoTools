package ResponseTfL;

public class Path {
	private String lineString;
	private StopPointInPath stopPoints[];
	private Elevation elevation[];

	public Path(String lineString, StopPointInPath[] stopPoints, Elevation[] elevation) {
		this.lineString = lineString;
		this.stopPoints = stopPoints;
		this.elevation = elevation;
	}

	public String getLineString() {
		return lineString;
	}

	public StopPointInPath[] getStopPoints() {
		return stopPoints;
	}

	public Elevation[] getElevation() {
		return elevation;
	}
}