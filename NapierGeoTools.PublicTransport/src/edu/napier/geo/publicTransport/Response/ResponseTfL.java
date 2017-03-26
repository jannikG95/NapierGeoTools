package edu.napier.geo.publicTransport.Response;

import java.io.Serializable;

public class ResponseTfL implements Serializable {
	

	/**
	 * Created with https://timboudreau.com/blog/json/read under Creative
	 * Commons CC BY-NC-SA 3.0 license. Author of the used software: Tim Boudreau.  
	 * Changes: Jan-Niklas Keiner 2017/03/02
	 * Changes: separation of inner classes, adding getter methods and making
	 * objects compatible to objects of the public transport project. License:
	 * https://creativecommons.org/licenses/by-nc-sa/3.0/legalcode
	 * 
	 * 
	 * Class based on JSON Response of the TfL API format with a few changes
	 * (like storing lon and lat in Locations). See empty example response in
	 * documentation.
	 *
	 */
	private static final long serialVersionUID = 8124741540587098503L;
	private TflJourney journeys[];
	private Line lines[];
	private CycleHireDockingStationData cycleHireDockingStationData;
	private String[] stopMessages;
	private long recommendedMaxAgeMinutes;
	private SearchCriteria searchCriteria;
	private TflJourneyVector tflJourneyVector;
	
	public ResponseTfL(TflJourney[] journeys, Line[] lines, CycleHireDockingStationData cycleHireDockingStationData,
			String[] stopMessages, long recommendedMaxAgeMinutes, SearchCriteria searchCriteria,
			TflJourneyVector tflJourneyVector) {
		this.journeys = journeys;
		this.lines = lines;
		this.cycleHireDockingStationData = cycleHireDockingStationData;
		this.stopMessages = stopMessages;
		this.recommendedMaxAgeMinutes = recommendedMaxAgeMinutes;
		this.searchCriteria = searchCriteria;
		this.tflJourneyVector = tflJourneyVector;
	}
	public String x() {
		String x = "";
		if(journeys!=null){
		for (TflJourney tflJourney : journeys) {
			x = x + "startDateTime=" + tflJourney.getStartDateTime() + "arrivalDateTime=" + tflJourney.getArrivalDateTime() + "duration"
					+ tflJourney.getDurationMinutes();
		}}
		return x;
	}

	public TflJourney[] getTflJourneys() {
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

	public TflJourneyVector getTflJourneyVector() {
		return tflJourneyVector;
	}
}
