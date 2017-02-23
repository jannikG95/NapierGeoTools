package ResponseTfL;

public class RouteSectionNaptanEntrySequence {
	private long ordinal;
	private StopPoint stopPoint;

	public RouteSectionNaptanEntrySequence(long ordinal, StopPoint stopPoint) {
		this.ordinal = ordinal;
		this.stopPoint = stopPoint;
	}

	public long getOrdinal() {
		return ordinal;
	}

	public StopPoint getStopPoint() {
		return stopPoint;
	}

}