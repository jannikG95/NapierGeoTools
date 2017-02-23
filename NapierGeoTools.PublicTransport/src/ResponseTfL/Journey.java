package ResponseTfL;

public class Journey {
	private String startDateTime;
	private int duration;
	private String arrivalDateTime;
	private Leg legs[];

	public Journey(String startDateTime, int duration, String arrivalDateTime, Leg[] legs) {
		this.startDateTime = startDateTime;
		this.duration = duration;
		this.arrivalDateTime = arrivalDateTime;
		this.legs = legs;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public int getDuration() {
		return duration;
	}

	public String getArrivalDateTime() {
		return arrivalDateTime;
	}

	public Leg[] getLegs() {
		return legs;
	}
}