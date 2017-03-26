package edu.napier.geo.publicTransport.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

import edu.napier.geo.common.Location;

/**
 * 
 * @author Jan-Niklas Keiner 
 * 
 * 2017/02/28
 * 
 *         This class has static methods for giving back JSON Strings from TfL
 *         for requests with the different static methods
 *
 */
public class RequestAndGetJsonFromServer {

	/**
	 * This method is used for converting the ArrayList of Strings with the user
	 * preferences to one long String, separated by and symbol
	 * 
	 * @param preferences
	 *            UserPreferences in the Format that TfL API requires
	 * @return String in URL format
	 */
	private static String userPreferencesToString(ArrayList<String> preferences) {
		String res = "";
		for (String string : preferences) {
			if (string != null && string != "") {
				res = res + string + "&";
			}
		}
		return res;
	}

	/**
	 * Method to check, if Longitude and Latitude of a Location are not null
	 * 
	 * @param location Location object
	 * @return Boolean. true, if both values are not 0.0, else false
	 */
	private static boolean locationLonAndLatNotNull(Location location) {
		// this method checks, if lat and lon of a Location object are not null
		if (location.getLat() != 0.0 && location.getLon() != 0.0)
			return true;
		return false;
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
		if (locationLonAndLatNotNull(from) && locationLonAndLatNotNull(to)) {
			String userPreferences = "";
			if (from.getDescription() != null) {
				userPreferences = userPreferences + "fromName="
						+ from.getDescription();
			}
			if (to.getDescription() != null) {
				userPreferences = userPreferences + "toName="
						+ to.getDescription();
			}
			return getJSON(from.getLat(), from.getLon(), to.getLat(),
					to.getLon(), userPreferences);
		}
		return null;
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
		if (locationLonAndLatNotNull(from) && locationLonAndLatNotNull(to)) {
			String userPreferences = userPreferencesToString(preferences);
			if (from.getDescription() != null
					&& !userPreferences.startsWith("fromName=")) {
				userPreferences = userPreferences + "fromName="
						+ from.getDescription();
			}
			if (to.getDescription() != null
					&& !userPreferences.startsWith("toName=")) {
				userPreferences = userPreferences + "toName="
						+ to.getDescription();
			}
			return getJSON(from.getLat(), from.getLon(), to.getLat(),
					to.getLon(), userPreferences);
		}
		return null;
	}

	/**
	 * this method gives back a string of the JSON response from TfL for request
	 * for a Journey from and to coordinates (decimal) without further user Preferences
	 * 
	 * @param fromLat
	 *            decimal
	 * @param fromLon
	 *            decimal
	 * @param toLat
	 *            decimal
	 * @param toLon
	 *            decimal
	 * @return String of the TfL Response (in JSON format)
	 * @throws IOException IOException of getJSON(lat, lon, lat, lon, preferences)
	 */
	public static String getJSON(double fromLat, double fromLon, double toLat,
			double toLon) throws IOException {
		return getJSON(fromLat, fromLon, toLat, toLon, "");
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
		// this method gives back a string of the JSON response from TfL for
		// request for a Journey from and to coordinates with the preferences
		// (given as ArrayList of Strings)
		return getJSON(fromLat, fromLong, toLat, toLong,
				userPreferencesToString(preferences));
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
			double toLong, String preferences) throws MalformedURLException, 
			IOException, ProtocolException {
		String from = fromLat + "," + fromLon;
		String to = toLat + "," + toLong;
		from = from.replace(" ", "%20");
		to = to.replace(" ", "%20");

		URL url = new URL("https://api.tfl.gov.uk/Journey/JourneyResults/"
				+ from + "/to/" + to + "?" + preferences
				+ "app_id=f094fea0&app_key=81dc2ce2a1aecb999b15294a9aa3595a");

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setUseCaches(false);
		connection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));

		String response = "";
		for (String line; (line = reader.readLine()) != null;) {
			response = response + line + "\n";
		}
		response.replace("latitude", "lat");
		response.replace("longitude", "lon");
		System.out.println(response);
		return response;
	}

}
