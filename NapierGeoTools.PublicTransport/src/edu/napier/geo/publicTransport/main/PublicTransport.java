package edu.napier.geo.publicTransport.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import edu.napier.geo.common.Journey;
import edu.napier.geo.common.Location;
import edu.napier.geo.publicTransport.InformationStorage.InformationStorage;
import edu.napier.geo.publicTransport.InformationStorage.JourneyInformation;
import edu.napier.geo.publicTransport.Response.ResponseFactory;
import edu.napier.geo.publicTransport.Response.ResponseTfl;
import edu.napier.geo.publicTransport.Response.TflJourney;

/**
 * 2017/02/27
 * 
 * @author Jan-Niklas Keiner
 * 
 * Licensed under the Creative Commons BY-NC-SA License. 
 * https://creativecommons.org/licenses/by-nc-sa/3.0/legalcode			
 * The edu.napier.geo.publicTransport.ResponseTfl Package Code is based on a JSON to POJO converter 
 * (https://timboudreau.com/blog/json/read) under this license.
 * 
 *         Uses GSON, which is licensed under the Apache 2.0 License:
 *         http://www.apache.org/licenses/LICENSE-2.0
 * 
 * 
 *         Objects of this class can get request TfL API and convert the
 *         response (JSON) to Pojo (plain old java object) and get information
 *         out of it. Furthermore it stores some information of each journey in
 *         the informationStorage object, which is stored locally and persistent
 *         (ObjectFileInput/Output stream) is imported again each time an object
 *         of this class is created (if there is an informationStorage.ser
 *         file). It uses Google GSON for converting JSON to POJO. It provides
 *         methods to get information out of the information storage. It
 *         provides methods to get information out of the last response Object,
 *         which was created by GSON out of a JSON from TfL. 
 *         
 *         
 *         
 *         
 *          
 */

/**
 * This API uses only Latitude and Longitude for Locations and no Altitude.
 *
 */

public class PublicTransport {
	private InformationStorage informationStorage;
	String informationStorageFilePath;
	public static String informationStorageFilePathDefault = "informationStorage.ser";
	private ArrayList<Journey> responseJavaObject;
	private Gson gson;
	// InformationStorage informationStorageObject; // only ffor test
	private String source = "PublicTransport";

	/**
	 * * Constructor for an Object of PublicTransport. This object will be
	 * necessary to use all functions of the PublicTransport API.
	 * 
	 * @param resetInformationStorage
	 *            if true, the persistent stored InformationStorage is not
	 *            loaded and the new generated object of this class generates a
	 *            new empty InformationStorage object, which will be written to
	 *            the file of the old one, when the first responseObject of a
	 *            response from a public transport provider API is set.
	 * @param informationStorageFilePath
	 *            path of the file of the InformationStorage object to import
	 */
	public PublicTransport(boolean resetInformationStorage, String informationStorageFilePath) {
		gson = new Gson();
		if (informationStorageFilePath != null && informationStorageFilePath.endsWith(".ser"))
			this.informationStorageFilePath = informationStorageFilePath;
		else
			this.informationStorageFilePath = informationStorageFilePathDefault;
		if (resetInformationStorage = false) {
			InputStream fis = null;
			try {
				fis = new FileInputStream(this.informationStorageFilePath);
				@SuppressWarnings("resource")
				ObjectInputStream o = new ObjectInputStream(fis);
				informationStorage = (InformationStorage) o.readObject();
				System.out.println(
						"informationStorage read in try block:" + informationStorage + informationStorage.toString());
			} catch (IOException e) {
				System.err.println(e);
			} catch (ClassNotFoundException e) {
				System.err.println(e);
			} finally {
				try {
					fis.close();
				} catch (Exception e) {
				}
			}
		} else {
			resetInformationStorage(); // this method resets the
			// informationStorage object to a new one.
		}

		// JUST FOR DEMONSTRATION:
		printAllJourneyInformation();
		System.out.println(informationStorage);
		// JUST FOR DEMONSTRATION

	}

	public PublicTransport(boolean resetInformationStorage) {
		this(resetInformationStorage, informationStorageFilePathDefault);

	}

	/**
	 * Method for demonstration only This method prints out all Journeys of the
	 * InformationStorage object.
	 */
	public void printAllJourneyInformation() {
		System.out.println("with information Storage obj. !");
		if (informationStorage != null) {
			for (JourneyInformation journeyInformation : informationStorage.getStoredJourneyInformation()) {
				System.out.println("for each informationStoage.storedJourneys journeyInformation.print. "
						+ journeyInformation.toString());
			}
		}
	}

	/**
	 * /**
	 * 
	 * @param string
	 *            of the JSON response from the API of the TfL public Transport
	 *            API
	 * @return ResponseTfL object of all information in the JSON
	 * 
	 *         creates Response object out of JSON String and gives the new
	 *         object to the informationStorage to update it.
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws JsonSyntaxException
	 */
	private ArrayList<Journey> getResponseObjectFromJSONString(String string,Location start, Location end)
			throws JsonSyntaxException, FileNotFoundException, IOException {

		System.out.println("JSONtoJava-getResponseOBjectFromJSONString(string)");

		if (string != null) {
			System.out.println(string);
			//ResponseTfl obj = gson.fromJson(string, ResponseTfl.class);
			return ResponseFactory.parse(string,start, end);
			//System.out.println("object=" + obj);
		//	if (obj.getTflJourneys() != null) {
		//		informationStorage.storeInformation(obj);
	//			storeInformationStoragePersistent();
		//		return obj;
		//	}
			//System.out.println("no Journeys in response Object.");
		//	throw new IllegalArgumentException();

		}
		System.out.println("responseString=null, no JSON code responded!");
		throw new IllegalArgumentException();

	}

	// Get Information from the actual Response Object
	/**
	 * This method gives back the duration of the first Journey of the actual
	 * ResponseTfl Object in minutes. returns -1, if Response Object is null.
	 * 
	 * @return Duration of the first Journey of the actual ResponseTfL Object in
	 *         minutes
	 */
	/*
	public int getDurationMinutesOfFirstJourney() {
		return this.getDurationMinutsOfJourney(0);
	}

	/**
	 * Method to get the Departure Time of the First Journey of the actual
	 * response object
	 * 
	 * @return String DepartureTime
	 */
	/*
	public String getDepartureTimeOfFirstJourney() {
		return this.getDepartureTimeOfJourney(0);
	}

	/**
	 * Method to get the Arrival Time of the First Journey of the actual
	 * response object
	 * 
	 * @return String ArrivalTime
	 */
	/*
	public String getArrivalTimeOfFirstJourney() {
		return this.getArrivalTimeOfJourney(0);
	}

	/**
	 * gives back a publicTransport-Location of the departure Point of the first
	 * Journey (Data of the Response Object). returns null, if response Object
	 * is null.
	 * 
	 * @return Location of Departure of the first Journey
	 */
	/*
	public Location getDeparturePointOfFirstJourney() {
		return this.getDeparturePointOfJourney(0);
	}

	/**
	 * This method gives back the Arrival Point of the first Journey of the
	 * actual ResponseTfL Object
	 * 
	 * @return Location Object of the Arrival Point of the first Journey of the
	 *         actual ResponseTfL Object
	 */
	/*public Location getArrivalPointOfFirstJourney() {
		if (this.getResponseJavaObject() != null)
			return this.getResponseJavaObject().getTflJourneys()[0]
					.getLegs()[this.getResponseJavaObject().getTflJourneys()[0].getLegs().length - 1].getArrivalPoint();
		return null;
	}*

	/**
	 * Gives back the number of Legs of the first Journey of the actual
	 * ResponseTfL Object returns -1, if response Object is null.
	 * 
	 * @return Integer of the number of Legs of the first Journey of the actual
	 *         ResponseTfL Object
	 */
	/*public int getNumberOfLegsOfFirstJourney() {
		if (this.getResponseJavaObject() != null)
			return this.getResponseJavaObject().getTflJourneys()[0].getLegs().length;
		return -1;
	}*/

	/**
	 * Gives back the first Journey of the actual Response Object
	 * 
	 * @return TfLJourney Object of the first Journey of the actual Response
	 *         Object
	 */
	/*
	public TflJourney getFirstJourney() {
		return this.getJourney(0);
	}

	/**
	 * Gives back an Array of all TfLJourneys of the actual ResponseTfL Object
	 * 
	 * @return an Array of TfLJourney Objects of all TfLJourneys of the actual
	 *         ResponseTfL Object
	 */
	public ArrayList<Journey> getAllJourneys() {
		if (this.getResponseJavaObject() != null)
			return this.getResponseJavaObject();
		return null;
	}

	/**
	 * Gives back the duration of a TfLJourney
	 * 
	 * @param tflJourney
	 *            TflJourney object
	 * @return Integer of the duration of the given TfLJourney Object
	 */
	public int getDurationMinutesOfJourney(TflJourney tflJourney) {
		if (tflJourney != null)
			return tflJourney.getDurationMinutes();
		return -1;
	}

	/**
	 * Gives back the Departure Time of a given TflJourney object
	 * 
	 * @param tflJourney
	 *            TflJourney object
	 * @return String of Departure Time
	 */
	public String getDepartureTimeOfJourney(TflJourney tflJourney) {
		if (tflJourney != null)
			return tflJourney.getStartDateTime();
		return null;
	}

	/**
	 * Gives back the Arrival Time of a given TflJourney object
	 * 
	 * @param tflJourney
	 *            TflJourney object
	 * @return String of Arrival Time
	 */
	public String getArrivalTimeOfJourney(TflJourney tflJourney) {
		if (tflJourney != null)
			return tflJourney.getArrivalDateTime();
		return null;
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
		if (tflJourney != null)
			return tflJourney.getLegs()[0].getDeparturePoint();
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
		if (tflJourney != null)
			return tflJourney.getLegs()[tflJourney.getLegs().length - 1].getArrivalPoint();
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
		if (tflJourney != null)
			return tflJourney.getLegs().length;
		return -1;
	}

	/**
	 * Gives back the duration of a given Journey in minutes
	 * 
	 * @param journeyNumber
	 *            index of the Journey in the Response Object
	 * @return Integer of the duration of the given Journey in minutes
	 */
	/*
	public int getDurationMinutsOfJourney(int journeyNumber) {
		if (this.getResponseJavaObject() != null) {
			if (this.getResponseJavaObject().getTflJourneys().length >= journeyNumber && journeyNumber >= 0)
				return this.getResponseJavaObject().getTflJourneys()[journeyNumber].getDurationMinutes();
		}
		return -1;
	}*/

	/**
	 * Gives back the Departure Time of a Journey with a given index.
	 * 
	 * @param journeyNumber
	 *            index of the Journey in the Response Object
	 * @return String of Departure Time
	 */
	/*public String getDepartureTimeOfJourney(int journeyNumber) {
		if (this.getResponseJavaObject() != null) {
			if (this.getResponseJavaObject().getTflJourneys().length >= journeyNumber && journeyNumber >= 0)
				return this.getResponseJavaObject().getTflJourneys()[journeyNumber].getStartDateTime();
		}
		return null;
	}*/

	/**
	 * Gives back the Arrival Time of a Journey with a given index.
	 * 
	 * @param journeyNumber
	 *            index of the Journey in the Response Object
	 * @return String of Arrival Time
	 */
	/*
	public String getArrivalTimeOfJourney(int journeyNumber) {
		if (this.getResponseJavaObject() != null) {
			if (this.getResponseJavaObject().getTflJourneys().length >= journeyNumber && journeyNumber >= 0)
				return this.getResponseJavaObject().getTflJourneys()[journeyNumber].getArrivalDateTime();
		}
		return null;
	}*/

	/**
	 * Gives back the Departure Point of a Journey with a given index.
	 * 
	 * @param journeyNumber
	 *            index of the Journey in the response Object
	 * @return Location Object of the Departure Point of a Journey with a given
	 *         index.
	 */
	/*
	public Location getDeparturePointOfJourney(int journeyNumber) {
		if (this.getResponseJavaObject() != null) {
			if (this.getResponseJavaObject().getTflJourneys().length >= journeyNumber && journeyNumber >= 0)
				return this.getResponseJavaObject().getTflJourneys()[journeyNumber].getLegs()[0].getDeparturePoint();
		}
		return null;
	}*/

	/**
	 * Gives back the Arrival Point of the Journey with the given index.
	 * 
	 * @param journeyNumber
	 *            index of the Journey in the response Object
	 * @return Location Object of the Arrival Point of the Journey with the
	 *         given index.
	 */
	/*
	public Location getArrivalPointOfJourney(int journeyNumber) {
		// returns the Location of the Arrival Point of the journey (with the
		// given index) (Data of the Response Object)
		if (this.getResponseJavaObject() != null) {
			if (this.getResponseJavaObject().getTflJourneys().length >= journeyNumber && journeyNumber >= 0)
				return this.getResponseJavaObject().getTflJourneys()[journeyNumber]
						.getLegs()[this.getResponseJavaObject().getTflJourneys()[journeyNumber].getLegs().length - 1]
								.getArrivalPoint();
		}
		return null;
	}

	/**
	 * Gives back the number of Legs of a Journey with a given index.
	 * 
	 * @param journeyNumber
	 *            index of the Journey in the response Object
	 * @return Integer of the number of Legs of a Journey with a given index.
	 */
	/*
	public int getNumberOfLegsOfJourney(int journeyNumber) {
		if (this.getResponseJavaObject() != null) {
			if (this.getResponseJavaObject().getTflJourneys().length >= journeyNumber && journeyNumber >= 0)
				return this.getResponseJavaObject().getTflJourneys()[journeyNumber].getLegs().length;
		}
		return -1;
	}

	/**
	 * Gives back a TfLJourney of the response object with a given index.
	 * 
	 * @param journeyNumber
	 *            index of the Journey in the response Object
	 * @return a TfLJourney Object of the response object with a given index.
	 */
	public Journey getJourney(int journeyNumber) {
		if (this.getResponseJavaObject() != null) {
			return this.responseJavaObject.get(journeyNumber);
		}
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
		if (informationStorage != null)
			return informationStorage.getAverageTimeMSForJourney(from, to);
		return -1;
	}

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
		if (informationStorage != null)
			return informationStorage.getAverageNumberOfLegs(from, to);
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
		if (informationStorage != null)
			return informationStorage.getAverageWalkingDistanceKMForJourney(from, to);
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
		if (informationStorage != null)
			return informationStorage.getTflJourneys(from, to);
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
	public ArrayList<Location> getRouteLocationsOfJourney(Location from, Location to) {
		if (informationStorage != null)
			return informationStorage.getRouteLocationsOfJourney(from, to);
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
	public void createResponseJavaObject(Location from, Location to, ArrayList<String> userPreferences)
			throws Exception {
		if (from != null && to != null)
			this.setResponseJavaObject(
					getResponseObjectFromJSONString(RequestAndGetJsonFromServer.getJSON(from, to, userPreferences),from,to));
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
	public void createResponseJavaObject(Location from, Location to) throws Exception {
		if (from != null && to != null)
			this.setResponseJavaObject(getResponseObjectFromJSONString(RequestAndGetJsonFromServer.getJSON(from, to),from, to));
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
	//public void createResponseJavaObject(double fromLat, double fromLon, double toLat, double toLon,
	//		ArrayList<String> userPreferences) throws Exception {
	//	this.setResponseJavaObject(getResponseObjectFromJSONString(
	//			RequestAndGetJsonFromServer.getJSON(fromLat, fromLon, toLat, toLon, userPreferences)));
	//}

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
	//public void createResponseJavaObject(double fromLat, double fromLon, double toLat, double toLon) throws Exception {
	//	this.setResponseJavaObject(
	//			getResponseObjectFromJSONString(RequestAndGetJsonFromServer.getJSON(fromLat, fromLon, toLat, toLon)));
	//}

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
	public void storeInformationStoragePersistent() throws IOException, FileNotFoundException {
		if (informationStorageFilePath != null && informationStorageFilePath != ""
				&& informationStorageFilePath.endsWith("ser")) {
			FileOutputStream fos = null;
			fos = new FileOutputStream(informationStorageFilePath);
			@SuppressWarnings("resource")
			ObjectOutputStream o = new ObjectOutputStream(fos);
			o.writeObject(informationStorage);
		}
	}

	public ArrayList<Journey> getResponseJavaObject() {
		return responseJavaObject;
	}

	/**
	 * This method could be used to replace the InformationStorage Object of
	 * this Object with a new empty InformationStorage Object
	 */
	public void resetInformationStorage() {
		this.informationStorage = new InformationStorage();
	}

	/**
	 * sets the ResponseJavaObject of this object to the given ResponseTfl
	 * Object
	 * 
	 * @param responseJavaObject
	 *            Object of ResponseTfl type (Response from TfL (JSON) converted
	 *            to POJO object)
	 */
	public void setResponseJavaObject(ArrayList<Journey> responseJavaObject) {
		this.responseJavaObject = responseJavaObject;
	}

	/**
	 * gives back the informationStorage object of this class
	 * 
	 * @return InformationStorage object of this class
	 */
	public InformationStorage getInformationStorage() {
		return informationStorage;
	}

	/**
	 * Gives back the Source String, which is used to identify this API as
	 * source for Objects like Location
	 * 
	 * @return String with this API name
	 */
	public String getSource() {
		return source;
	}

	/**
	 * Gives back the File Path of the informationStorage
	 * 
	 * @return File path as String
	 */
	public String getInformationStorageFilePath() {
		return informationStorageFilePath;
	}

	/**
	 * Sets the informationStorage File path
	 * 
	 * @param informationStorageFilePath
	 *            File Path as String
	 */

	public void setInformationStorageFilePath(String informationStorageFilePath) {
		this.informationStorageFilePath = informationStorageFilePath;
	}

	/**
	 * Sets the Source String
	 * 
	 * @param source
	 *            String which describes the object of this class, when a new
	 *            Location objet is created.
	 */
	public void setSource(String source) {
		if (source != null && source != "")
			this.source = source;
	}

}