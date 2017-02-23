package ResponseTfL;

public class Response {
	

	private Journey journeys[];
	private Line lines[];
	private CycleHireDockingStationData cycleHireDockingStationData;
	private String[] stopMessages;
	private long recommendedMaxAgeMinutes;
	private SearchCriteria searchCriteria;
	private JourneyVector journeyVector;

	public Response(Journey[] journeys, Line[] lines, CycleHireDockingStationData cycleHireDockingStationData,
			String[] stopMessages, long recommendedMaxAgeMinutes, SearchCriteria searchCriteria,
			JourneyVector journeyVector) {
		this.journeys = journeys;
		this.lines = lines;
		this.cycleHireDockingStationData = cycleHireDockingStationData;
		this.stopMessages = stopMessages;
		this.recommendedMaxAgeMinutes = recommendedMaxAgeMinutes;
		this.searchCriteria = searchCriteria;
		this.journeyVector = journeyVector;
	}
	public String x() {
		String x = "";
		for (Journey journey : journeys) {
			x = x + "startDateTime=" + journey.getStartDateTime() + "arrivalDateTime=" + journey.getArrivalDateTime() + "duration"
					+ journey.getDuration();
		}
		return x;
	}

	public Journey[] getJourneys() {
		return journeys;
	}


	public Line[] getLines() {
		return lines;
	}

	public CycleHireDockingStationData getCycleHireDockingStationData() {
		return cycleHireDockingStationData;
	}

	public String[] getStopMessages() {
		return stopMessages;
	}

	public long getRecommendedMaxAgeMinutes() {
		return recommendedMaxAgeMinutes;
	}

	public SearchCriteria getSearchCriteria() {
		return searchCriteria;
	}

	public JourneyVector getJourneyVector() {
		return journeyVector;
	}
}
