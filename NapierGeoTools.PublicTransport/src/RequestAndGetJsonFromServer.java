
//import org.apache.commons.httpclient.*;
//import org.apache.commons.httpclient.methods.*;
//import org.apache.commons.httpclient.params.HttpMethodParams;
//import org.apache.httpcomponents.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import General.Location;
//import Response.Journey;

/*
 * 2do: VIA adden
 * auskommentierte variable
 * mode: wie add/delete
 * 
 */
public class RequestAndGetJsonFromServer {

	// private static ArrayList<String> preferences;
	// private static String nationalSearch;
	// private static String timeIs;
	// private static String date;
	// private static String time;
	// private static String journeyPreference;
	// private static String mode;
	// private static String accessibilityPreference;
	// private static String fromName;
	// private static String toName;
	// private static String viaName;
	// private static String maxTransferMinutes;
	// private static String maxWalkingMinutes;
	// private static String walkingSpeed;
	// private static String cyclePreference;
	// private static String adjustment;
	// private static String bikeProficiency;
	// private static String alternativeCycle;
	// private static String alternativeWalking;
	// private static String useMultiModelCall;
	// private static String walkingOptimization;

	// public void createArrayList(){
	// preferences.add(nationalSearch);
	// preferences.add(timeIs);
	// preferences.add(date);
	// preferences.add(time);
	// preferences.add(journeyPreference);
	// preferences.add(mode);
	// preferences.add(accessibilityPreference);
	// preferences.add(fromName);
	// preferences.add(toName);
	// preferences.add(viaName);
	// preferences.add(maxTransferMinutes);
	// preferences.add(maxWalkingMinutes);
	// preferences.add(walkingSpeed);
	// preferences.add(cyclePreference);
	// preferences.add(adjustment);
	// preferences.add(bikeProficiency);
	// preferences.add(alternativeCycle);
	// preferences.add(alternativeWalking);
	// preferences.add(useMultiModelCall);
	// preferences.add(walkingOptimization);
	//
	// setAllAttributesToDefault();
	// }
	//
	// public static void setAllAttributesToDefault(){
	// nationalSearch="False";
	// timeIs="Departing";
	// journeyPreference="LeastTime";
	// mode="public-bus,overground,train,tube,coach,dlr,cablecar,tram,river,walking,cycle";
	// accessibilityPreference=null;
	// fromName=null;
	// toName=null;
	// viaName=null;
	// maxTransferMinutes=null;
	// maxWalkingMinutes=null;
	// walkingSpeed="Aveage";
	// adjustment=null;
	// bikeProficiency=null;
	// alternativeCycle="True";
	// alternativeWalking="True";
	// useMultiModelCall="False";
	// walkingOptimization="True";
	// }

	public static String userPreferencesToString(ArrayList<String> preferences) {
		String res = "";
		for (String string : preferences) {
			if (string != null && string != "") {
				res = res + string + "&";
			}
		}
		return res;
	}

	public static boolean locationLonAndLatNotNull(Location location) {
		if (location.getLat() != 0.0 && location.getLon() != 0.0)
			return true;
		return false;
	}

	public static String getJSON(Location from, Location to) throws IOException {
		if (locationLonAndLatNotNull(from) && locationLonAndLatNotNull(to)) {
			String userPreferences = "";
			if (from.getInformation() != null) {
				userPreferences = userPreferences + "fromName=" + from.getInformation();
			}
			if (to.getInformation() != null) {
				userPreferences = userPreferences + "toName=" + to.getInformation();
			}
			return getJSON(from.getLat(), from.getLon(), to.getLat(), to.getLon(), userPreferences);
		}
		return null;
	}

	public static String getJSON(Location from, Location to, ArrayList<String> preferences) throws IOException {
		if (locationLonAndLatNotNull(from) && locationLonAndLatNotNull(to)) {
			String userPreferences = userPreferencesToString(preferences);
			if (from.getInformation() != null && !userPreferences.contains("fromName=")) {
				userPreferences = userPreferences + "fromName=" + from.getInformation();
			}
			if (to.getInformation() != null && !userPreferences.contains("toName=")) {
				userPreferences = userPreferences + "toName=" + to.getInformation();
			}
			return getJSON(from.getLat(), from.getLon(), to.getLat(), to.getLon(), userPreferences);
		}
		return null;
	}

	public static String getJSON(double fromLat, double fromLon, double toLat, double toLong)
			throws IOException/* , ClientProtocolException */ {
		return getJSON(fromLat, fromLon, toLat, toLong, "");
	}

	public static String getJSON(double fromLat, double fromLong, double toLat, double toLong,
			ArrayList<String> preferences) throws IOException/* , ClientProtocolException */ {
		return getJSON(fromLat, fromLong, toLat, toLong, userPreferencesToString(preferences));
	}

	public static String getJSON(double fromLat, double fromLon, double toLat, double toLong, String userPreferences)
			throws IOException/* , ClientProtocolException */ {
		String from = fromLat + "," + fromLon;
		String to = toLat + "," + toLong;
		from = from.replace(" ", "%20");
		to = to.replace(" ", "%20");

		URL url = new URL("https://api.tfl.gov.uk/Journey/JourneyResults/" + from + "/to/" + to + "?" + userPreferences
				+ "app_id=f094fea0&app_key=81dc2ce2a1aecb999b15294a9aa3595a");

		// URL url = new URL( "https://api.tfl.gov.uk/Journey/JourneyResults/" +
		// from + "/to/" + to
		// +
		// "?"/*nationalSearch=False&timeIs=Departing&journeyPreference=LeastTime&walkingSpeed=Average&cyclePreference=None&alternativeCycle=False&alternativeWalking=True&applyHtmlMarkup=False&useMultiModalCall=False&*/+"app_id=f094fea0&app_key=81dc2ce2a1aecb999b15294a9aa3595a");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setUseCaches(false);
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		// connection.setRequestProperty( "Content-Length",
		// String.valueOf(body.length()) );

		// OutputStreamWriter writer = new OutputStreamWriter(
		// connection.getOutputStream() );
		// writer.write( body );
		// writer.flush();

		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		String response = "";
		for (String line; (line = reader.readLine()) != null;) {
			response = response + line + "\n";
		}

		// test:
		// Response obj = new Response(str);

		// JsonObject object = Json.parse(input).asObject();
		//
		// Gson gson = new Gson();
		//
		//// try {
		//
		//// BufferedReader br = new BufferedReader(
		//// new FileReader("c:\\file.json"));
		//
		// //convert the json string back to object
		// Response obj = gson.fromJson(response, Response.class);
		//
		//
		// System.out.println(obj);
		//
		// System.out.println(obj.x());

		// Response message= new ObjectMapper().readValue(response,
		// Response.class);
		// }

		return response;

		// HttpClient client = new DefaultHttpClient();
		//
		// String url = "https://api.tfl.gov.uk/Journey/JourneyResults/" + from
		// + "/to/" + to
		// +
		// "?nationalSearch=False&timeIs=Departing&journeyPreference=LeastTime&walkingSpeed=Average&cyclePreference=None&alternativeCycle=False&alternativeWalking=True&applyHtmlMarkup=False&useMultiModalCall=False&app_id=f094fea0&app_key=81dc2ce2a1aecb999b15294a9aa3595a";
		//
		// System.out.println(url);
		// HttpGet request = new HttpGet(url);
		// HttpResponse response = client.execute(request);
		// BufferedReader rd = new BufferedReader(new
		// InputStreamReader(response.getEntity().getContent()));
		// String line = "";
		// String res = "";
		// while (line != null) {
		// line = rd.readLine();
		// res = res + line;
		// }
		// return res;
	}

}
