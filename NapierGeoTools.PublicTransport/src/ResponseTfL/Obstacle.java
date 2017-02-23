package ResponseTfL;

public class Obstacle {
	private String type;
	private String incline;
	private long stopId;
	private String position;

	public Obstacle(String type, String incline, long stopId, String position) {
		this.type = type;
		this.incline = incline;
		this.stopId = stopId;
		this.position = position;
	}

	public String getType() {
		return type;
	}

	public String getIncline() {
		return incline;
	}

	public long getStopId() {
		return stopId;
	}

	public String getPosition() {
		return position;
	}
}