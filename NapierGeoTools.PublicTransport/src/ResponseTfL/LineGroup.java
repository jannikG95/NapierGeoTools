package ResponseTfL;

              
public class LineGroup {
	private String naptanIdReference;
	private String stationAtcoCode;
	private String[] lineIdentifier;

	public LineGroup(String naptanIdReference, String stationAtcoCode, String[] lineIdentifier) {
		this.naptanIdReference = naptanIdReference;
		this.stationAtcoCode = stationAtcoCode;
		this.lineIdentifier = lineIdentifier;
	}

	public String getNaptanIdReference() {
		return naptanIdReference;
	}

	public String getStationAtcoCode() {
		return stationAtcoCode;
	}

	public String[] getLineIdentifier() {
		return lineIdentifier;
	}
}