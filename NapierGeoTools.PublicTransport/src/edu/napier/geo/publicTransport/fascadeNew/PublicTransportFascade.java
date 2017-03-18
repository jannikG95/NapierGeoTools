package edu.napier.geo.publicTransport.fascadeNew;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

import edu.napier.geo.common.Location;
import edu.napier.geo.publicTransport.*;
import edu.napier.geo.publicTransport.InformationStorage.InformationStorage;
import edu.napier.geo.publicTransport.ResponseTfL.ResponseTfL;
import edu.napier.geo.publicTransport.ResponseTfL.TflJourney;
import edu.napier.geo.publicTransport.main.PublicTransport;
import edu.napier.geo.publicTransport.main.RequestAndGetJsonFromServer;

public class PublicTransportFascade {

	public PublicTransport publicTransport;

	public PublicTransportFascade() {
	}

	public void createNewPublicTransport(boolean resetInformationStorage,
			String informationStorageFilePath) {
		this.publicTransport = new PublicTransport(resetInformationStorage,
				informationStorageFilePath);
	}

	public void createNewPublicTransport(boolean resetInformationStorage) {
		this.publicTransport = new PublicTransport(resetInformationStorage);
	}

	/**
	 * This method gives back the duration of the first Journey of the actual
	 * ResponseTfl Object in minutes. returns -1, if Response Object is null.
	 * 
	 * @return Duration of the first Journey of the actual ResponseTfL Object in
	 *         minutes
	 */
	public int getDurationMinutesOfFirstJourney() {
		if (this.publicTransport != null)
			return publicTransport.getDurationMinutsOfJourney(0);
		return 0;
	}

	/**
	 * gives back a publicTransport-Location of the departure Point of the first
	 * Journey (Data of the Response Object). returns null, if response Object
	 * is null.
	 * 
	 * @return Location of Departure of the first Journey
	 */
	public Location getDeparturePointOfFirstJourney() {
		if (this.publicTransport != null)
			return publicTransport.getDeparturePointOfFirstJourney();
		return null;
	}

	/**
	 * This method gives back the Arrival Point of the first Journey of the
	 * actual ResponseTfL Object
	 * 
	 * @return Location Object of the Arrival Point of the first Journey of the
	 *         actual ResponseTfL Object
	 */
	public Location getArrivalPointOfFirstJourney() {
		if (this.publicTransport != null)
			return publicTransport.getArrivalPointOfFirstJourney();
		return null;
	}

	/**
	 * Gives back the number of Legs of the first Journey of the actual
	 * ResponseTfL Object returns -1, if response Object is null.
	 * 
	 * @return Integer of the number of Legs of the first Journey of the actual
	 *         ResponseTfL Object
	 */
	public int getNumberOfLegsOfFirstJourney() {
		if (this.publicTransport != null)
			return publicTransport.getNumberOfLegsOfFirstJourney();
		return -1;
	}

	/**
	 * Gives back the first Journey of the actual Response Object
	 * 
	 * @return TfLJourney Object of the first Journey of the actual Response
	 *         Object
	 */
	public TflJourney getFirstJourney() {
		if (this.publicTransport != null)
			return publicTransport.getFirstJourney();
		return null;
	}

	/**
	 * Gives back an Array of all TfLJourneys of the actual ResponseTfL Object
	 * 
	 * @return an Array of TfLJourney Objects of all TfLJourneys of the actual
	 *         ResponseTfL Object
	 */
	public TflJourney[] getAllJourneys() {
		if (this.publicTransport != null)
			return publicTransport.getAllJourneys();
		return null;
	}

	/**
	 * Gives back the duration of a TfLJourney
	 * 
	 * @param tflJourney
	 *            TflJourney object
	 * @return Integer of the duration of the given TfLJourney Object
	 */
	public int getDurationOfJourney(TflJourney tflJourney) {
		if (this.publicTransport != null)
			return publicTransport.getDurationOfJourney(tflJourney);
		return -1;
	}

	/**
	 * Gives back the Departure Point of a given TfLJourney Object
	 * 
	 * @param tflJourney
	 *            TflJourney object
	 * @return Location Object of the Departure Point of a given TfLJourney
	 *         Object
	 */
	public Location getDeparturePointOfJourney(TflJourney tflJourney) {
		if (this.publicTransport != null)
			return publicTransport.getDeparturePointOfJourney(tflJourney);
		return null;
	}

	/**
	 * Gives back the Arrival Point of a given TfLJourney Object
	 * 
	 * @param tflJourney
	 *            TflJourney object
	 * @return Location Object of the Arrival Point of a given TfLJourney Object
	 */
	public Location getArrivalPointOfJourney(TflJourney tflJourney) {
		if (this.publicTransport != null)
			return publicTransport.getArrivalPointOfJourney(tflJourney);
		return null;
	}

	/**
	 * Gives back the number of Legs of a given TfLJourney Object
	 * 
	 * @param tflJourney
	 *            TflJourney object
	 * @return Integer of the number of Legs of a given TfLJourney Object
	 */
	public int getNumberOfLegsOfJourney(TflJourney tflJourney) {
		if (this.publicTransport != null)
			return publicTransport.getNumberOfLegsOfJourney(tflJourney);
		return -1;
	}

	/**
	 * Gives back the duration of a given Journey in minutes
	 * 
	 * @param journeyNumber
	 *            index of the Journey in the Response Object
	 * @return Integer of the duration of the given Journey in minutes
	 */
	public int getDurationMinutsOfJourney(int journeyNumber) {
		if (publicTransport.getResponseJavaObject() != null)
			return publicTransport.getDurationMinutsOfJourney(journeyNumber);
		return -1;
	}

	/**
	 * Gives back the Departure Point of a Journey with a given index.
	 * 
	 * @param journeyNumber
	 *            index of the Journey in the response Object
	 * @return Location Object of the Departure Point of a Journey with a given
	 *         index.
	 */
	public Location getDeparturePointOfJourney(int journeyNumber) {
		if (publicTransport.getResponseJavaObject() != null)
			return publicTransport.getDeparturePointOfJourney(journeyNumber);
		return null;
	}

	/**
	 * Gives back the Arrival Point of the Journey with the given index.
	 * 
	 * @param journeyNumber
	 *            index of the Journey in the response Object
	 * @return Location Object of the Arrival Point of the Journey with the
	 *         given index.
	 */
	public Location getArrivalPointOfJourney(int journeyNumber) {
		// returns the Location of the Arrival Point of the journey (with the
		// given index) (Data of the Response Object)
		if (publicTransport.getResponseJavaObject() != null)
			return publicTransport.getArrivalPointOfJourney(journeyNumber);
		return null;
	}

	/**
	 * Gives back the number of Legs of a Journey with a given index.
	 * 
	 * @param journeyNumber
	 *            index of the Journey in the response Object
	 * @return Integer of the number of Legs of a Journey with a given index.
	 */
	public int getNumberOfLegsOfJourney(int journeyNumber) {
		if (this.publicTransport != null)
			return publicTransport.getNumberOfLegsOfJourney(journeyNumber);
		return -1;
	}

	/**
	 * Gives back a TfLJourney of the response object with a given index.
	 * 
	 * @param journeyNumber
	 *            index of the Journey in the response Object
	 * @return a TfLJourney Object of the response object with a given index.
	 */
	public TflJourney getJourney(int journeyNumber) {
		if (this.publicTransport != null)
			return publicTransport.getJourney(journeyNumber);
		return null;
	}

	// Get infos from InformationStorage
	/**
	 * Gives back the average duration of a Journey in ms Uses the data of the
	 * persistent InformationStorage
	 * 
	 * @param from
	 *            Location (Lon + Lat is compared)
	 * @param to
	 *            Location (Lon + Lat is compared)
	 * @return double of the average walking time for a Journey from and to a
	 *         given Location (Lat+Lon) in ms
	 */
	public double getAverageDurationMSForJourney(Location from, Location to) {
		// returns the average duration for a Journey from and to a given
		// Location (Data from persistent local InformationStorage)
		if (this.publicTransport != null)
			return publicTransport.getAverageDurationMSForJourney(from, to);
		return -1;
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Gives back the average number of Legs of all stored Journeys from and to
	 * given Locations Uses the data of the persistent InformationStorage
	 * 
	 * @param from
	 *            Location
	 * @param to
	 *            Location
	 * @return double of the average number of Legs of a Journey from and to a
	 *         Location
	 */
	public double getAverageNumberOfLegs(Location from, Location to) {
		// returns the average number of legs for a Journey from and to a given
		// Location (Data from persistent local InformationStorage)
		if (this.publicTransport != null)
			return publicTransport.getAverageNumberOfLegs(from, to);
		return -1;
	}

	/**
	 * Gives back the Average walking distance of all in the persistent
	 * InformationStorage stored Journeys from and to Locations in KM Uses the
	 * data of the persistent InformationStorage
	 * 
	 * @param from
	 *            Location object
	 * @param to
	 *            Location object
	 * @return double of the Average walking distance of all in the persistent
	 *         InformationStorage stored Journeys from and to Locations in KM
	 */
	public double getAverageDistanceWalkingKM(Location from, Location to) {
		if (this.publicTransport != null)
			return publicTransport.getAverageDistanceWalkingKM(from, to);
		return -1;
	}

	/**
	 * Gives back an ArrayList of TflJourneys Objects of a Journey from and to a
	 * Location. Uses the data of the persistent InformationStorage
	 * 
	 * @param from
	 *            Location object
	 * @param to
	 *            Location object
	 * @return ArrayList of TflJourney Objects of a Journey from and to a
	 *         Location
	 */
	public ArrayList<TflJourney> getTflJourneys(Location from, Location to) {
		if (this.publicTransport != null)
			return publicTransport.getTflJourneys(from, to);
		return null;
	}

	/**
	 * Gives back an ArrayList of all Locations on the way of the Journey Uses
	 * the data of the persistent InformationStorage
	 * 
	 * @param from
	 *            Location object
	 * @param to
	 *            Location object
	 * @return ArrayList of all Locations on the way of the Journey
	 */
	public ArrayList<Location> getRouteLocationsOfJourney(Location from,
			Location to) {
		if (this.publicTransport != null)
			return publicTransport.getRouteLocationsOfJourney(from, to);
		return null;
	}

	// Creating Response Java Object from request
	/**
	 * This method creates a POJO (Plain old java object) ResponseTfl for
	 * Journeys from and to a Location and with an ArrayList of Strings with the
	 * user preferences (must be in the format, that TfL requires:
	 * "variable=value" for most variables. All Variables that TfL provides can
	 * be used. Then it sets the response object of this object to the new given
	 * response object from TfL.
	 * 
	 * @param from
	 *            Location object
	 * @param to
	 *            Location object
	 * @param userPreferences
	 *            Strings must be in the format that the TfL API requires
	 *            ("variable=value" for most of the variables).
	 * @throws Exception
	 *             Exception of setResponseJavaObject()
	 */
	public void createResponseJavaObject(Location from, Location to,
			ArrayList<String> userPreferences) throws Exception {
		if (this.publicTransport != null)
			publicTransport.createResponseJavaObject(from, to, userPreferences);
	}

	/**
	 * creates the POJO (plain old Java object) response object for a Journey
	 * from and to a given Location. Then it sets the response object of this
	 * object to the new given response object from TfL.
	 * 
	 * @param from
	 *            Location object
	 * @param to
	 *            Location object
	 * @throws Exception
	 *             Exception of setResponseJavaOBject()
	 */
	public void createResponseJavaObject(Location from, Location to)
			throws Exception {
		if (this.publicTransport != null)
			publicTransport.createResponseJavaObject(from, to);
	}

	/**
	 * creates the POJO response Object for a Journey from and to the given
	 * coordinates and with an ArrayList of Strings with the user preferences
	 * (must be in the format, that TfL requires: "variable=value". All
	 * Variables that TfL provides can be used. Then it sets the response object
	 * of this object to the new given response object from TfL.
	 * 
	 * @param fromLat
	 *            decimal
	 * @param fromLon
	 *            decimal
	 * @param toLat
	 *            decimal
	 * @param toLon
	 *            decimal
	 * @param userPreferences
	 *            ArrayList of Strings in the format that the TfL API requires.
	 *            One String per parameter
	 * @throws Exception
	 *             Exception of setResponseJavaObject()
	 */
	public void createResponseJavaObject(double fromLat, double fromLon,
			double toLat, double toLon, ArrayList<String> userPreferences)
			throws Exception {
		if (this.publicTransport != null)
			publicTransport.createResponseJavaObject(fromLat, fromLon, toLat,
					toLon, userPreferences);
	}

	/**
	 * creates the POJO response Object for a Journey from and to the given
	 * coordinates. Then it sets the response object of this object to the new
	 * given response object from TfL.
	 * 
	 * @param fromLat
	 *            decimal
	 * @param fromLon
	 *            decimal
	 * @param toLat
	 *            decimal
	 * @param toLon
	 *            decimal
	 * @throws Exception
	 *             Exception of setResponseJavaObject()
	 */
	public void createResponseJavaObject(double fromLat, double fromLon,
			double toLat, double toLon) throws Exception {
		if (this.publicTransport != null)
			publicTransport.createResponseJavaObject(fromLat, fromLon, toLat,
					toLon);
	}

	/**
	 * updates the local persistent file of the stored Information
	 * (InformationStorage). Is automatically called, when a new Response object
	 * is set as response object in an object of this class after automatically
	 * updating the InformationStorage. Not necessary for normal usage, but
	 * public provided for possible special use of a User.
	 * 
	 * @throws IOException
	 *             of ObjectOutputStream
	 * @throws FileNotFoundException
	 *             of FileOutputStream
	 */
	public void storeInformationStoragePersistent() throws IOException,
			FileNotFoundException {
		if (this.publicTransport != null)
			publicTransport.storeInformationStoragePersistent();
	}

	public ResponseTfL getResponseJavaObject() {
		if (this.publicTransport != null)
			return publicTransport.getResponseJavaObject();
		return null;
	}

	/**
	 * This method could be used to replace the InformationStorage Object of
	 * this Object with a new empty InformationStorage Object
	 */
	public void resetInformationStorage() {
		if (this.publicTransport != null)
			publicTransport.resetInformationStorage();
	}

	/**
	 * sets the ResponseJavaObject of this object to the given ResponseTfl
	 * Object
	 * 
	 * @param responseJavaObject
	 *            Object of ResponseTfl type (Response from TfL (JSON) converted
	 *            to POJO object)
	 */
	public void setResponseJavaObject(ResponseTfL responseJavaObject) {
		if (this.publicTransport != null)
			publicTransport.setResponseJavaObject(responseJavaObject);
	}

	/**
	 * gives back the informationStorage object of this class
	 * 
	 * @return InformationStorage object of this class
	 */
	public InformationStorage getInformationStorage() {
		if (this.publicTransport != null)
			return publicTransport.getInformationStorage();
		return null;
	}

	/**
	 * Gives back the Source String, which is used to identify this API as
	 * source for Objects like Location
	 * 
	 * @return String with this API name
	 */
	public String getSource() {
		if (this.publicTransport != null)
			return publicTransport.getSource();
		return null;

	}
	
	/**
	 * this method gives back a string of the JSON response from TfL for request
	 * for a Journey from and to a Location
	 * 
	 * @param from Location object
	 * @param to Location object
	 * @return String of the TfL Response (in JSON format)
	 * @throws IOException IOException of getJSON(lat, lon, lat, lon, userPreferences)
	 */
	public static String getJSON(Location from, Location to) throws IOException {
		return RequestAndGetJsonFromServer.getJSON(from, to);
	}


	/**
	 *  this method gives back a string of the JSON response from TfL for request
	 * for a Journey from and to a Location with user Preferences
	 * 
	 * @param from Location object
	 * @param to Location object
	 * @param preferences ArrayList of Strings with the user Preferences in the format that the TfL API requires
	 * @return String of the TfL Response (in JSON format)
	 * @throws IOException IOException of getJSON(lat, lon, lat, lon, userPreferences)
	 * 
	 * 
	 */
	public static String getJSON(Location from, Location to,
			ArrayList<String> preferences) throws IOException {
		return RequestAndGetJsonFromServer.getJSON(from, to, preferences);
	}

	/**
	 * this method gives back a string of the JSON response from TfL for request
	 * for a Journey from and to coordinates (decimal) without further user Preferences
	 * 
	 * @param fromLat
	 *            decimal
	 * @param fromLong
	 *            decimal
	 * @param toLat
	 *            decimal
	 * @param toLong
	 *            decimal
	 * @return String of the TfL Response (in JSON format)
	 * @throws IOException IOException of getJSON(lat, lon, lat, lon, preferences)
	 */
	public static String getJSON(double fromLat, double fromLon, double toLat,
			double toLong) throws IOException {
		return RequestAndGetJsonFromServer.getJSON(fromLat, fromLon, toLat, toLong);
	}

	/**
	 * this method gives back a string of the JSON response from TfL for request
	 * for a Journey from and to coordinates (decimal) with user Preferences
	 * 
	 * 
	 * @param fromLat
	 *            decimal
	 * @param fromLong
	 *            decimal
	 * @param toLat
	 *            decimal
	 * @param toLong
	 *            decimal
	 * @param preferences
	 *            ArrayList of Strings with the user preferences (must be in the
	 *            format, that TfL requires: "variable=value". All Variables
	 *            that TfL provides can be used.
	 * @return String of the TfL Response (in JSON format)
	 * @throws IOException IOException of getJSON(lat, lon, lat, lon, preferences)
	 */
	public static String getJSON(double fromLat, double fromLong, double toLat,
			double toLong, ArrayList<String> preferences) throws IOException {
		return RequestAndGetJsonFromServer.getJSON(fromLat, fromLong, toLat, toLong, preferences);
	}

	/**
	 * this method gives back a String of the JSON response from TfL for a
	 * request for a Journey from and to coordinates and with all preferences in
	 * one String (separated by the and symbol). 
	 * 
	 * @param fromLat
	 *            decimal
	 * @param fromLon
	 *            decimal
	 * @param toLat
	 *            decimal
	 * @param toLong
	 *            decimal
	 * @param preferences
	 *            ArrayList of Strings with the user preferences (must be in the
	 *            format, that TfL requires: "variable=value". All Variables
	 *            that TfL provides can be used.
	 * @return  String of the TfL Response (in JSON format)
	 * @throws MalformedURLException  MalformedURLException of URL
	 * @throws ProtocolException ProtocolException of HttpURLConnection connection.setRequestMethod(GET)
	 * @throws IOException IOException of url.openConnection
	 */
	public static String getJSON(double fromLat, double fromLon, double toLat,
			double toLong, String preferences) throws MalformedURLException, IOException, ProtocolException {
	return RequestAndGetJsonFromServer.getJSON(fromLat, fromLon, toLat, toLong, preferences);	
	}
	
	
}
