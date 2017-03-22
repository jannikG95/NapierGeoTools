package edu.napier.geo.publicTransport.InformationStorage;

import java.io.Serializable;
import java.util.ArrayList;

//import edu.napier.geo.publicTransport.General.Location;
import edu.napier.geo.common.Location;
import edu.napier.geo.publicTransport.Response.Leg;
import edu.napier.geo.publicTransport.Response.ResponseTfL;
import edu.napier.geo.publicTransport.Response.TflJourney;

public class InformationStorage implements Serializable {
	/**
	 * 2017/02/28
	 * 
	 * @author Jan-Niklas Keiner
	 * 
	 *         A class that contains all information, that should be stored
	 *         offline and persistent in a file. Information are stored as
	 *         JourneyInformation objects in an ArrayList in this object.
	 * 
	 *         This class contains the methods to get all information out of a
	 *         responseTfl object and store it in this storage.
	 */
	private static final long serialVersionUID = 3160066032542949431L;
	private ArrayList<JourneyInformation> storedJourneysInformation = new ArrayList<JourneyInformation>();

	/**
	 * Gets all information of a JourneyInformation out of this object for each
	 * journey of the given responseTfl object
	 * 
	 * @param responseTfL
	 *            a responseTfl Object that should be stored in the
	 *            informationStorage
	 */
	public void storeInformation(ResponseTfL responseTfL) {
		System.out.println("InformationStorage-calcAndStoreInformation(response)");
		if (responseTfL != null)
			storeJourneys(responseTfL.getTflJourneys());
	}

	/**
	 * Gets all information of a JourneyInformation out of this objets for each
	 * journey of the given Array
	 * 
	 * @param tflJourneys
	 *            Array of TflJourneys to store
	 */
	private void storeJourneys(TflJourney[] tflJourneys) {
		if (tflJourneys != null) {
			for (TflJourney tflJourney : tflJourneys) {
				storeJourney(tflJourney);
			}
		}
	}

	/**
	 * gets the information from the journey and stores it in the information
	 * Storage. If a journey from and to the start and end Locations exists, it
	 * adds the information, that are stored in ArrayLists, otherwise it creates
	 * a new JourneyInformation object and stores the information in it.
	 * RouteLocations are only stored for the first time by calling the
	 * constructor. To get the RouteLocations for other journeys, please use the
	 * getJourney method and seperate the locations out of it.
	 * 
	 * @param tflJourney
	 *            TflJourney to store
	 */
	private void storeJourney(TflJourney tflJourney) {
		// checking, if there is an already existing object from and to the
		// location
		JourneyInformation j = getJourneyInformation(tflJourney.getLegs()[0].getDeparturePoint(),
				tflJourney.getLegs()[tflJourney.getLegs().length - 1].getArrivalPoint());
		System.out.println("InformationStorage.storeJourneyInformation with from:"+tflJourney.getLegs()[0].getDeparturePoint()+" and to:"+tflJourney.getLegs()[tflJourney.getLegs().length - 1].getArrivalPoint());
		if (j != null) {
			System.out.println("Information Storage-storeJourney. match. add to route");
			j.addTime(tflJourney.getDurationMinutes());
			j.addLeg(tflJourney.getLegs().length);
			j.addDistance(getDistanceOfTflJourney(tflJourney));
		} else {
			System.out.println("Information Storage-storeJourney. no match. create new route");
			storedJourneysInformation.add(new JourneyInformation(tflJourney.getLegs()[0].getDeparturePoint(),
					tflJourney.getLegs()[tflJourney.getLegs().length - 1].getArrivalPoint(),
					tflJourney.getDurationMinutes(), tflJourney.getLegs().length, getDistanceOfTflJourney(tflJourney),
					tflJourney, getRouteLocationsOfJourney(tflJourney)));
		}
	}

	/**
	 * gives back an ArrayList of Locations. Uses Legs (departure and arrival
	 * point) and the list of coordinates of the path of the legs.
	 * 
	 * @param journey
	 *            TflJourney
	 * @return ArrayList of Locations objects of all Locations of this route
	 *         incl. Locations in the path.
	 */
	public ArrayList<Location> getRouteLocationsOfJourney(TflJourney journey) {
		if (journey != null) {
			ArrayList<Location> routeLocations = new ArrayList<Location>();
			System.out.println("get route locations of journey");
			for (Leg leg : journey.getLegs()) {
				System.out.println("leg: " + leg);
				if (routeLocations.size() == 0
						|| !routeLocations.get(routeLocations.size() - 1).hasSameLocationAs(leg.getDeparturePoint()))
					routeLocations.add(leg.getDeparturePoint());
				routeLocations = addRouteLocationsOfString(routeLocations, leg.getPath().getLineString());
				if (!routeLocations.get(routeLocations.size() - 1).hasSameLocationAs(leg.getArrivalPoint()))
					routeLocations.add(leg.getArrivalPoint());
			}
			return routeLocations;
		}
		return null;
	}

	/**
	 * internal method to add the Locations (which are in a string in the path)
	 * to the list of Locations of a route.
	 * 
	 * @param listToAddLocationsTo
	 *            List of Locations, where the Locations of the part should be
	 *            added to
	 * @param string
	 *            String of coordinates of the Locations which should be added
	 *            to the ArrayList. Coordinates have to be comma separated as
	 *            well as locations, "[", "]" and spaces in the string are
	 *            ignored. Coordinates in format: "lat,lon,lat,lon,..."
	 * @return ArrayList of Location objects that has been given. Contains the
	 *         objects it contained when given + the Locations from the String
	 */
	private ArrayList<Location> addRouteLocationsOfString(ArrayList<Location> listToAddLocationsTo, String string) {
		System.out.println("add route location of string. string=" + string);
		if (listToAddLocationsTo != null && string != null && string != "") {
			// replace all not needed symbols
			string = string.replace("[", "");
			string = string.replace("]", "");
			string = string.replace(" ", "");
			String[] coordinates = string.split(","); // create seperated
														// Strings
														// for each coordinate
			if (coordinates.length % 2 == 0) {
				// 2 coordinates are required for one Location. If the number of
				// coordinates is an odd number, the method cannot create
				// Locations
				// of it.
				System.out.println("coordinates %2 true. ccordinates length=" + coordinates.length);
				for (int x = 0; x < (coordinates.length - 1); x = x + 2) {
					Location loc = new Location(Double.parseDouble(coordinates[x]),
							Double.parseDouble(coordinates[x + 1]), "PublicTransport InformationStorage");
					System.out.println("new location=" + loc.toString());
					if (!listToAddLocationsTo.get(listToAddLocationsTo.size() - 1).hasSameLocationAs(loc))
						listToAddLocationsTo.add(loc);
				}
			} else
				return null;
		}
		return listToAddLocationsTo;
	}

	/**
	 * Gives back a ArrayList of TflJourneys of a Journey from and to a
	 * Location.
	 * 
	 * @param from
	 *            Location object
	 * @param to
	 *            Location object
	 * @return ArrayList of TflJourney objects of the Journey. Returns null, if
	 *         no JourneyInformation object from and to the given Locations in
	 *         the InformationStorage.
	 */
	public ArrayList<TflJourney> getTflJourneys(Location from, Location to) {
		JourneyInformation j = getJourneyInformation(from, to);
		if (j != null)
			return j.getTflJourneys();
		return null;
	}

	/**
	 * Gives back the distance of a given TflJourney
	 * 
	 * @param tflJourney
	 *            TflJourney of which the method should give the distance back
	 * @return Integer of the distance of a TflJourney in m
	 */
	private int getDistanceOfTflJourney(TflJourney tflJourney) {
		if (tflJourney != null) {
			int distance = 0;
			for (Leg leg : tflJourney.getLegs()) {
				distance = distance + (int) leg.getDistance();
				System.out.println("getDistanceOfTflJourney: from" + leg.getDeparturePoint().toString() + " to:"
						+ leg.getArrivalPoint().toString() + " distance:" + leg.getDistance());
			}
			return distance;
		}
		return -1;

	}

	/**
	 * Gives back the JourneyInformation object for a journey from and to a
	 * Location
	 * 
	 * @param from
	 *            Location object
	 * @param to
	 *            Location object
	 * @return the JourneyInformation object to a Journey from and to a
	 *         Location. Returns null, if there is no Journey from and to the
	 *         given Locations in the InformationStorage.
	 */
	public JourneyInformation getJourneyInformation(Location from, Location to) {
		if(from!=null && to!=null){
		for (JourneyInformation journeyInformation : storedJourneysInformation) {
			if (from.hasSameLocationAs(journeyInformation.getFrom())
					&& to.hasSameLocationAs(journeyInformation.getTo())) {
				return journeyInformation;
			}
		}}
		return null;
	}

	/**
	 * Gives back the average Walking distance in KM for a Journey from and to a
	 * Location
	 * 
	 * @param from
	 *            Location object
	 * @param to
	 *            Location object
	 * @return double of the average walking distance in KM. returns-1, if no
	 *         JourneyInformation for the given Locations in the
	 *         InformationStorage.
	 */
	public double getAverageWalkingDistanceKMForJourney(Location from, Location to) {
		JourneyInformation j = getJourneyInformation(from, to);
		if (j != null)
			return j.getDistanceKM();
		return -1;
	}

	/**
	 * Gives back the average time for a Journey (in MS) from and to a Location
	 * 
	 * @param from
	 *            Location object
	 * @param to
	 *            Location object
	 * @return double of the average time in MS for the Journey. Returns -1, if
	 *         no JourneyInformation object from and to the given Locations in
	 *         the InformationStorage.
	 */
	public double getAverageTimeMSForJourney(Location from, Location to) {
		JourneyInformation j = getJourneyInformation(from, to);
		if (j != null)
			return j.getAverageTimeMS();
		return -1;
	}

	/**
	 * gives back the average number of Legs of a Journey from and to a
	 * Location.
	 * 
	 * @param from
	 *            Location object
	 * @param to
	 *            Location object
	 * @return double of the average number of Legs. Returns -1, if no
	 *         JourneyInformation object from and to the given Locations in the
	 *         InformationStorage.
	 */
	public double getAverageNumberOfLegs(Location from, Location to) {
		JourneyInformation j = getJourneyInformation(from, to);
		if (j != null)
			return j.getAverageNumberOfLegs();
		return -1;
	}

	/**
	 * Gives back the Route of a Journey from and to a Location as an ArrayList
	 * of Locations
	 * 
	 * @param from
	 *            Location object
	 * @param to
	 *            Location object
	 * @return ArrayListy of Location objects of the Route of the Journey.
	 *         Returns null, if no JourneyInformation object from and to the
	 *         given Locations in the InformationStorage.
	 */
	public ArrayList<Location> getRouteLocationsOfJourney(Location from, Location to) {
		JourneyInformation j = getJourneyInformation(from, to);
		if (j != null)
			return j.getRouteLocations();
		return null;
	}

	/**
	 * Gives back all stored JourneyInformation of this InformationStorage as an
	 * ArrayList
	 * 
	 * @return ArrayList of JourneyInformation of all JourneyInformation of this
	 *         InformationStorage
	 */
	public ArrayList<JourneyInformation> getStoredJourneyInformation() {
		return storedJourneysInformation;
	}

	/**
	 * 
	 * @return String of information about this object incl. toString of all the
	 *         JourneyInformation stored in this object.
	 */
	public String toString() {
		String string = "InformationStorage. serialVersionUID=" + serialVersionUID + " number of stored Journeys="
				+ this.getStoredJourneyInformation().size();
		for (JourneyInformation journeyInformation : this.getStoredJourneyInformation()) {
			string = string + journeyInformation.toString();
		}
		return string;
	}

}
