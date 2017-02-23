package ResponseTfL;

public class PassengerFlow {
	private String timeSlice;
	private long value;

	public PassengerFlow(String timeSlice, long value) {
		this.timeSlice = timeSlice;
		this.value = value;
	}

	public String getTimeSlice() {
		return timeSlice;
	}

	public long getValue() {
		return value;
	}
}