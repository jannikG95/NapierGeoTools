package edu.napier.geo.publicTransport.InformationStorage;

import java.io.Serializable;
import java.util.ArrayList;

//import edu.napier.geo.publicTransport.General.Location;
import edu.napier.geo.common.Location;
import edu.napier.geo.publicTransport.Response.TflJourney;

public class JourneyInformation extends edu.napier.geo.common.Journey implements Serializable {
	/**
	 * @author Jan-Niklas Keiner
	 * 
	 *         2017/03/01
	 * 
	 *         This is a class to store information about Journeys from and to a
	 *         Location. Objects of this class contain the information. It
	 *         provides several methods to add information and calculates the
	 *         average where necessary by using the given add methods instead of
	 *         the ArrayLists methods.
	 * 
	 * 
	 * 
	 */
	private static final long serialVersionUID = 862989431123992144L;
	private ArrayList<Integer> timesMS;
	private ArrayList<Integer> legs;
	private double averageNumberOfLegs;
	private ArrayList<Integer> distancesMeter;
	private ArrayList<TflJourney> tflJourneys;
	private ArrayList<Location> routeLocations; // only set from constructor, so
												// not updated and only one path
												// of the first Journey
												// is stored.

	/**
	 * Constructor of a JourneyInformation. Used for ccreating a new
	 * JourneyInformation. If there is a Journey from and to the same Location,
	 * this Location should be used and the information added. A new
	 * JourneyInformation should only be created, if there is no Journey from
	 * and to the same Location.
	 * 
	 * @param from
	 *            Location object
	 * @param to
	 *            Location object
	 * @param timeMinutes
	 *            Integer of the duration in Minutes.
	 * @param numberOfLegs
	 *            Integer of the number of legs of this Journey.
	 * @param distanceMeter
	 *            Integer of the distance in Meter
	 * @param tflJourney
	 *            TflJourney object of this Journey.
	 * @param routeLocations
	 *            ArrayList of Locations between the Departure and Arrival
	 *            Location
	 */
	public JourneyInformation(Location from, Location to, int timeMinutes, int numberOfLegs, int distanceMeter,
			TflJourney tflJourney, ArrayList<Location> routeLocations) {
		super(from, to);
		this.setSource(
				"PublicTransport InformationStorage. Distance is walkingDistance, distance and time are average values.");
		this.locationB = to;
		this.timesMS = new ArrayList<Integer>();
		this.addTime(timeMinutes);
		this.legs = new ArrayList<Integer>();
		this.addLeg(numberOfLegs);
		this.distancesMeter = new ArrayList<Integer>();
		this.addDistance(distanceMeter);
		System.out.println("constructor journeyInformation: " + toString());
		this.tflJourneys = new ArrayList<TflJourney>();
		this.tflJourneys.add(tflJourney);
		this.routeLocations = routeLocations;
	}

	/**
	 * Method to add a duration time to the List of duration times. Average
	 * duration is calculated and updated automatically.
	 * 
	 * @param timeInMinutes
	 *            Integer of duration time in minutes
	 */
	public void addTime(int timeInMinutes) {
		this.timesMS.add(timeInMinutes * 3600);
		setAverageTimeMS(calcAverage(timesMS));
	}

	/**
	 * Method to add a distance in meter to the list of distances. Uses the
	 * Walking distance of a Journey, because the user needs only the time for
	 * using public transport, not the distance a vehicle of public transport
	 * goes. Average distance is calculated and updated automatically.
	 * 
	 * @param distanceMeter
	 *            Integer of the walking distance of this Journey in Meter.
	 */
	public void addDistance(int distanceMeter) {
		this.distancesMeter.add(distanceMeter);
		setDistanceKM(calcAverage(distancesMeter) / 1000);
	}

	public double getAverageNumberOfLegs() {
		return averageNumberOfLegs;
	}

	private void setAverageNumberOfLegs(double averageNumberOfLegs) {
		this.averageNumberOfLegs = averageNumberOfLegs;
	}

	/**
	 * Method to add a number of legs to the list of number of legs. Average
	 * number of legs is calculated and updated automatically.
	 * 
	 * @param numberOfLegs
	 *            int of number of Legs that should be added to the list of all
	 *            number of legs to create the average
	 */
	public void addLeg(int numberOfLegs) {
		this.legs.add(numberOfLegs);
		System.out.println("averageNumberOfLegsForRoute-addNumberOfLegs. NumberOfLegs=" + numberOfLegs);
		setAverageNumberOfLegs(calcAverage(legs));
	}

	/**
	 * Method to calculate the average of a ArrayList of Integer.
	 * 
	 * @param list
	 *            ArrayList of Integers to calculate its average
	 * @return double of the average value of the Integers in the given
	 *         ArrayList.
	 */
	private double calcAverage(ArrayList<Integer> list) {
		if (list != null) {
			double avg = 0;
			int count = 0;
			for (Integer x : list) {
				avg = avg + x;
				count++;
			}
		return (avg / count);
		}
		return -1;
	}

	public Location getFrom() {
		return super.locationA;
	}

	public void setFrom(Location from) {
		this.locationA = from;
	}

	public Location getTo() {
		return super.locationB;
	}

	public void setTo(Location to) {
		this.locationB = to;
	}

	public ArrayList<Integer> getTime() {
		return timesMS;
	}

	public void setTime(ArrayList<Integer> time) {
		this.timesMS = time;
	}

	public ArrayList<Integer> getTimesMS() {
		return timesMS;
	}

	public ArrayList<Integer> getLegs() {
		return legs;
	}

	public ArrayList<Integer> getDistancesMeter() {
		return distancesMeter;
	}

	public ArrayList<TflJourney> getTflJourneys() {
		return tflJourneys;
	}

	public double getAverageTimeMS() {
		return travelTimeMS;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ArrayList<Location> getRouteLocations() {
		return routeLocations;
	}

	private void setAverageTimeMS(double averageTime) {
		this.travelTimeMS = averageTime;
	}

	/**
	 * ToString(), includes the following information: from, to, average time,
	 * list of all times, average number of legs, list of all number of legs,
	 * average distance, all distances, number of TflJourney Objects
	 */
	public String toString() {
		String string = "from:" + this.getFrom().toString() + " to:" + this.getTo().toString() + " averageTime:"
				+ this.getAverageTimeMS() + " all times:" + timesMS + " averageNumberOfLegs=" + averageNumberOfLegs
				+ " all numbersOfLegs=" + legs + "distanceKMAvg=" + distanceKM + " distances=" + distancesMeter
				+ "numberOfTflJourney Objects:";
		return string;
	}
}
