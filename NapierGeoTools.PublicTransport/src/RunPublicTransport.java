import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.stream.FileImageInputStream;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import General.Location;
import InformationStorage.JourneyInformation;
import InformationStorage.InformationStorage;
import ResponseTfL.*;

/*
Copyright 2017 Jan-Niklas Keiner

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
// GSON license: https://github.com/google/gson/blob/master/LICENSE

public class RunPublicTransport {

	private InformationStorage informationStorage;
	private Response responseJavaObject;
	private Gson gson;
	InformationStorage informationStorageObject; // only for test

	public RunPublicTransport() /*
								 * throws JsonSyntaxException, JsonIOException,
								 * FileNotFoundException
								 */ {
		gson = new Gson();
//		informationStorage = new InformationStorage();

		InputStream fis = null;
		try
		{
		  fis = new FileInputStream( "informationStorage.ser" );
		  ObjectInputStream o = new ObjectInputStream( fis );
		  informationStorage = (InformationStorage) o.readObject();
//		  Date date     = (Date) o.readObject();
		  System.out.println("informationStorage read in try block:"+informationStorage+informationStorage.print() );
//		  System.out.println( date );
		}
		catch ( IOException e ) { System.err.println( e ); }
		catch ( ClassNotFoundException e ) { System.err.println( e ); }
		finally { try { fis.close(); } catch ( Exception e ) { } }
		
//		 try {
//		 informationStorage = gson.fromJson(new
//		 FileReader("informationStorage.json"), InformationStorage.class);
//		 } catch (JsonSyntaxException e) {
//		 // TODO Auto-generated catch block
//		 e.printStackTrace();
//		 System.out.println("syntax error");
//		 } catch (JsonIOException e) {
//		 // TODO Auto-generated catch block
//		 e.printStackTrace();
//		 System.out.println("JSON IO error");
//		 } catch (FileNotFoundException e) {
//		 // TODO Auto-generated catch block
//		 e.printStackTrace();
//		 System.out.println("File not found error");
//		 }

		System.out.println(informationStorage);
	}

	public static void main(String args[]) throws IOException {
		RunPublicTransport jsoNtoJavaTest = new RunPublicTransport();
		jsoNtoJavaTest.runTest();

	}

	public void runTest() {

		ArrayList<String> testList = new ArrayList<String>();
		testList.add("fromName=DepartureLocationTestName");

		// try {
		Location oldLocation = new Location(51.50100069912, -0.18300137615);
		Location locationWithoutFailure1 = new Location(51.59100069912, -0.12300137615);
		Location locationWithoutFailure2 = new Location(51.49839044663, -0.1301682292);
		Location locationWithFailure = new Location();

		String responseString;
		try {
			responseString = RequestAndGetJsonFromServer.getJSON(locationWithoutFailure1/*oldLocation*/, locationWithoutFailure2,
					testList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseString = null;
		}

		responseJavaObject = getResponseObjectFromJSONString(responseString);

		System.out.println("object x=:" + responseJavaObject.x());
		System.out.println("number of journeys=" + responseJavaObject.getJourneys().length);
		// System.out.println("dep. point="
		// +
		// GetInformationFromResponseObject.getDeparturePoint(responseJavaObject.getJourneys()[0]).print());
		// System.out.println("arr. point="
		// +
		// GetInformationFromResponseObject.getArrivalPoint(responseJavaObject.getJourneys()[0]).print());
		// System.out.println("duration="
		// +
		// GetInformationFromResponseObject.getDurationInMinutes(responseJavaObject.getJourneys()[0]));
		// System.out.println(
		// "dep time=" +
		// GetInformationFromResponseObject.getDepartureTime(responseJavaObject.getJourneys()[0]));
		// System.out.println(
		// "arr time=" +
		// GetInformationFromResponseObject.getArrivalTime(responseJavaObject.getJourneys()[0]));
		// System.out.println(obj.x());

		System.out.println(
				"with obj. !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("averageTime="
				+ informationStorage.getAverageTimeForRoute(locationWithoutFailure1, locationWithoutFailure2));
		System.out.println(
				"obj.dep point lat=" + responseJavaObject.getJourneys()[0].getLegs()[0].getDeparturePoint().getLat());
		System.out.println(
				"obj.dep point lon=" + responseJavaObject.getJourneys()[0].getLegs()[0].getDeparturePoint().getLon());
		System.out.println("locationWithoutFail1 lat=" + locationWithoutFailure1.getLat());
		System.out.println("locationWithoutFail1 lon=" + locationWithoutFailure1.getLon());
		System.out.println(
				"obj.arr point lat=" + responseJavaObject.getJourneys()[responseJavaObject.getJourneys().length - 1]
						.getLegs()[responseJavaObject.getJourneys()[responseJavaObject.getJourneys().length - 1]
								.getLegs().length - 1].getArrivalPoint().getLat());
		System.out.println(
				"obj.arr point lon=" + responseJavaObject.getJourneys()[responseJavaObject.getJourneys().length - 1]
						.getLegs()[responseJavaObject.getJourneys()[responseJavaObject.getJourneys().length - 1]
								.getLegs().length - 1].getArrivalPoint().getLon());
		System.out.println("locationWithoutFail2 lat=" + locationWithoutFailure2.getLat());
		System.out.println("locationWithoutFail2 lon=" + locationWithoutFailure2.getLon());

		for (Journey journey : responseJavaObject.getJourneys()) {
			System.out.println("New Journey");
			for (Leg leg : journey.getLegs()) {
				System.out.println("new Leg:");
				System.out
						.println("dep.=" + leg.getDeparturePoint().getLat() + " | " + leg.getDeparturePoint().getLon());
				System.out.println("arr.=" + leg.getArrivalPoint().getLat() + " | " + leg.getArrivalPoint().getLon());
			}
		}

		System.out.println(
				"with information Storage obj. !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		for (JourneyInformation journeyInformation : informationStorage.getStoredJourneys()) {
			System.out.println("for each informationStoage.storedJourneys journeyyInformation.print. "
					+ journeyInformation.print());
		}

		System.out
				.println("informationStorage.getStoredJourneys.size=" + informationStorage.getStoredJourneys().size());

		System.out.println("avg time from old location:"+informationStorage.getAverageTimeForJourney(oldLocation, locationWithoutFailure2));
//		String jsonString=gson.toJson(informationStorage);
//		System.out.println("jsonString:"+jsonString);
//		try {
//			int x=0;
//			gson.toJson(informationStorage, new FileWriter("informationStorage.json"));
//		} catch (JsonIOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			informationStorageObject = gson.fromJson(new FileReader("informationStorage.json"),
//					InformationStorage.class);
//		} catch (JsonSyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonIOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		FileOutputStream fos = null;
		try{
			fos=new FileOutputStream("informationStorage.ser");
			ObjectOutputStream o = new ObjectOutputStream(fos);
			o.writeObject(informationStorage);
		}catch ( IOException e ) { System.err.println( e ); }
		finally { try { fos.close(); } catch ( Exception e ) { e.printStackTrace(); } }
		

//		System.out.println("INforationStorageObject written in JSON and back to Java. JourneyInformation.length="
//				+ informationStorageObject.getStoredJourneys().size());
//		for (JourneyInformation journeyInformation : informationStorageObject.getStoredJourneys()) {
//			System.out.println("informationStorageObject=" + journeyInformation.print());
//		}
//
//		System.out.println("End of method, InformationStorage: JourneyInformation.length="
//				+ informationStorageObject.getStoredJourneys().size());
//		for (JourneyInformation journeyInformation : informationStorage.getStoredJourneys()) {
//			System.out.println("informationStorage=" + journeyInformation.print());
//		}

		// // Test: 2 Locations
		//
		// String responseString2 =
		// PublicTransportRequest.getJSON(locationWithoutFailure1,
		// locationWithoutFailure2 , testList);
		//
		// if (responseString2 != null) { Response obj =
		// gson.fromJson(responseString2, Response.class);
		//
		// System.out.println(obj);
		//
		// System.out.println(obj.x()); System.out.println(responseString2);
		// }else{
		// System.out.println("responseString=null, no JSON code responded!"); }
		//
		//
		//
		// //Test: one location has no lon and lat:
		//
		// String responseString3 =
		// PublicTransportRequest.getJSON(locationWithoutFailure1,
		// locationWithFailure, testList);
		//
		// if (responseString3 != null) { Response obj =
		// gson.fromJson(responseString3, Response.class);
		//
		// System.out.println(obj);
		//
		// System.out.println(obj.x()); System.out.println(responseString3);
		// }else{
		// System.out.println("responseString=null, no JSON code responded!"); }

	}

	private Response getResponseObjectFromJSONString(String string) {
		// creates Respond object out of JSON String and gives the new object to
		// the informationStorage to update it.
		System.out.println("JSONtoJava-getResponseOBjectFromJSONString(string)");

		if (string != null) {
			System.out.println(string);
			Response obj = gson.fromJson(string, Response.class);
			System.out.println("object=" + obj);
			informationStorage.storeInformation(obj);
			return obj;
		} else {
			System.out.println("responseString=null, no JSON code responded!");
			return null;
		}
	}

// Requests to object (return null (0 bei number objects), if object is not
// created yet)
	public int getDurationOfFirstJourney() {
		return this.getDurationOfJourney(0);
	}

	public Location getDeparturePointOfFirstJourney() {
		return this.getDeparturePointOfJourney(0);
	}

	public Location getArrivalPointOfFirstJourney() {
		if (this.getResponseJavaObject() != null)
			return this.getResponseJavaObject().getJourneys()[0]
					.getLegs()[this.getResponseJavaObject().getJourneys()[0].getLegs().length - 1].getArrivalPoint();
		return null;
	}

	public int getNumberOfLegsOfFirstJourney() {
		if (this.getResponseJavaObject() != null)
			return this.getResponseJavaObject().getJourneys()[0].getLegs().length;
		return 0;
	}

	public Journey getFirstJourney() {
		return this.getJourney(0);
	}

	public Journey[] getAllJourneys() {
		if (this.getResponseJavaObject() != null)
			return this.getResponseJavaObject().getJourneys();
		return null;
	}

	public int getDurationOfJourney(int journey) {
		if (this.getResponseJavaObject() != null) {
			if (this.getResponseJavaObject().getJourneys().length >= journey)
				return this.getResponseJavaObject().getJourneys()[journey].getDuration();
		}
		return 0;
	}

	public Location getDeparturePointOfJourney(int journey) {
		if (this.getResponseJavaObject() != null) {
			if (this.getResponseJavaObject().getJourneys().length >= journey)
				return this.getResponseJavaObject().getJourneys()[journey].getLegs()[0].getDeparturePoint();
		}
		return null;
	}

	public Location getArrivalPointOfJourney(int journey) {
		if (this.getResponseJavaObject() != null) {
			if (this.getResponseJavaObject().getJourneys().length >= journey)
				return this.getResponseJavaObject().getJourneys()[journey]
						.getLegs()[this.getResponseJavaObject().getJourneys()[journey].getLegs().length - 1]
								.getArrivalPoint();
		}
		return null;
	}

	public int getNumberOfLegsOfJourney(int journey) {
		if (this.getResponseJavaObject() != null) {
			if (this.getResponseJavaObject().getJourneys().length >= journey)
				return this.getResponseJavaObject().getJourneys()[journey].getLegs().length;
		}
		return 0;
	}

	public Journey getJourney(int journey) {
		if (this.getResponseJavaObject() != null) {
			if (this.getResponseJavaObject().getJourneys().length >= journey)
				return this.getResponseJavaObject().getJourneys()[journey];
		}
		return null;
	}

// Get infos from InformationStorage
	public double getAverageDurationForJourney(Location from, Location to){
		return informationStorage.getAverageTimeForJourney(from, to);
	}
	
	public double getAverageNumberOfLegs(Location from, Location to){
		return informationStorage.getAverageNumberOfLegs(from, to);
	}
	
	
	
// Creating Response Java Object from request
	public void createResponseJavaObject(Location from, Location to, ArrayList<String> userPreferences) {
		try {
			this.setResponseJavaObject(
					getResponseObjectFromJSONString(RequestAndGetJsonFromServer.getJSON(from, to, userPreferences)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createResponseJavaObject(Location from, Location to) {
		try {
			this.setResponseJavaObject(getResponseObjectFromJSONString(RequestAndGetJsonFromServer.getJSON(from, to)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createResponseJavaObject(double fromLat, double fromLon, double toLat, double toLon,
			ArrayList<String> userPreferences) {
		try {
			this.setResponseJavaObject(getResponseObjectFromJSONString(
					RequestAndGetJsonFromServer.getJSON(fromLat, fromLon, toLat, toLon, userPreferences)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createResponseJavaObject(double fromLat, double fromLon, double toLat, double toLon) {
		try {
			this.setResponseJavaObject(getResponseObjectFromJSONString(
					RequestAndGetJsonFromServer.getJSON(fromLat, fromLon, toLat, toLon)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// public InformationStorage getInformationStorage() {
	// return informationStorage;
	// }
	//
	//
	// public void setInformationStorage(InformationStorage informationStorage)
	// {
	// this.informationStorage = informationStorage;
	// }

	public Response getResponseJavaObject() {
		return responseJavaObject;
	}

	public void setResponseJavaObject(Response responseJavaObject) {
		this.responseJavaObject = responseJavaObject;
	}
}