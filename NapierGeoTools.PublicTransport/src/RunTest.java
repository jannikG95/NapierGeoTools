import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import edu.napier.geo.common.Location;
import edu.napier.geo.publicTransport.InformationStorage.JourneyInformation;
import edu.napier.geo.publicTransport.Response.Leg;
import edu.napier.geo.publicTransport.Response.ResponseTfl;
import edu.napier.geo.publicTransport.Response.StopPoint;
import edu.napier.geo.publicTransport.Response.StopPointInPath;
import edu.napier.geo.publicTransport.Response.TflJourney;
import edu.napier.geo.publicTransport.facade.PublicTransportFacade;
import edu.napier.geo.publicTransport.main.PublicTransport;
import edu.napier.geo.publicTransport.main.RequestAndGetJsonFromServer;

public class RunTest {

	// private static PublicTransport publicTransport;
	private static PublicTransportFacade facade;
	private static Location locationWithoutFailure1;
	static Location locationWithoutFailure2;
	static Location locationWithoutFailure3;
	// static Location from = locationWithoutFailure1;
	// static Location to = locationWithoutFailure3;

	public static void main(String args[]) throws Exception {
		RunTest test = new RunTest();
		facade = new PublicTransportFacade();
		locationWithoutFailure1 = new Location(51.51100069912,-0.12300137615, facade.getSource());
		locationWithoutFailure2 = new Location(51.49839044663,-0.1301682292, facade.getSource());
		locationWithoutFailure3 = new Location(51.599577,-0.059587, facade.getSource());
		// from = locationWithoutFailure1;
		// to = locationWithoutFailure3;

		facade.createNewPublicTransport(true);

		// test.test();
		// test.testGetMethods();
		// test.testSteps();
//		test.testGetFromActualResponseWithFascade();
//		 test.testGetFromInformationStorage();
		 test.CompareWithTflWebsite();

	}

	private void test() throws Exception {
		ArrayList<String> preferencesTestList = new ArrayList<String>();
		preferencesTestList.add("fromName=DepartureLocationTestName");

		// try {

		// Location locationWithFailure = new Location();

		facade.createResponseJavaObject(locationWithoutFailure1, locationWithoutFailure2, preferencesTestList);

		// String responseString;
		// try {
		// responseString =
		// RequestAndGetJsonFromServer.getJSON(locationWithoutFailure3/*oldLocation*/,
		// locationWithoutFailure2,
		// preferencesTestList);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// responseString = null;
		// }

		// responseJavaObject = getResponseObjectFromJSONString(responseString);

		ResponseTfl responseJavaObject = facade.getResponseJavaObject();
		System.out.println("object x=:" + responseJavaObject.x());
		System.out.println("number of journeys=" + responseJavaObject.getTflJourneys().length);

		System.out.println(
				"with obj. !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("averageTime=" + facade.getInformationStorage()
				.getAverageTimeMSForJourney(locationWithoutFailure1, locationWithoutFailure2));
		System.out.println("obj.dep point lat="
				+ responseJavaObject.getTflJourneys()[0].getLegs()[0].getDeparturePoint().getLat());
		System.out.println("obj.dep point lon="
				+ responseJavaObject.getTflJourneys()[0].getLegs()[0].getDeparturePoint().getLon());
		System.out.println("locationWithoutFail1 lat=" + locationWithoutFailure1.getLat());
		System.out.println("locationWithoutFail1 lon=" + locationWithoutFailure1.getLon());
		System.out.println("obj.arr point lat="
				+ responseJavaObject.getTflJourneys()[responseJavaObject.getTflJourneys().length - 1]
						.getLegs()[responseJavaObject.getTflJourneys()[responseJavaObject.getTflJourneys().length - 1]
								.getLegs().length - 1].getArrivalPoint().getLat());
		System.out.println("obj.arr point lon="
				+ responseJavaObject.getTflJourneys()[responseJavaObject.getTflJourneys().length - 1]
						.getLegs()[responseJavaObject.getTflJourneys()[responseJavaObject.getTflJourneys().length - 1]
								.getLegs().length - 1].getArrivalPoint().getLon());
		System.out.println("locationWithoutFail2 lat=" + locationWithoutFailure2.getLat());
		System.out.println("locationWithoutFail2 lon=" + locationWithoutFailure2.getLon());

		for (TflJourney tflJourney : responseJavaObject.getTflJourneys()) {
			System.out.println("New Journey");
			for (Leg leg : tflJourney.getLegs()) {
				System.out.println("new Leg:");
				System.out
						.println("dep.=" + leg.getDeparturePoint().getLat() + " | " + leg.getDeparturePoint().getLon());
				System.out.println("arr.=" + leg.getArrivalPoint().getLat() + " | " + leg.getArrivalPoint().getLon());
			}
		}

		facade.getPublicTransport().printAllJourneyInformation();

		System.out.println("informationStorage.getStoredJourneys.size="
				+ facade.getInformationStorage().getStoredJourneyInformation().size());

		System.out.println("avg time from old location:" + facade.getInformationStorage()
				.getAverageTimeMSForJourney(locationWithoutFailure3, locationWithoutFailure2));

		facade.getPublicTransport().printAllJourneyInformation();

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

	public void testGetMethods() {
		System.out.println("duration first journey:" + facade.getDurationMinutesOfFirstJourney());
		System.out.println("dep point first journey:" + facade.getDeparturePointOfFirstJourney().toString());
		System.out.println("arr point first journey:" + facade.getArrivalPointOfFirstJourney().toString());
		System.out.println("number legs first journey:" + facade.getNumberOfLegsOfFirstJourney());
		System.out.println("first journey" + facade.getFirstJourney().toString());
		System.out.println("get all journeys:");
		for (TflJourney journey : facade.getAllJourneys()) {
			System.out.println("get all journeys function. journey:" + journey + " = " + journey.toString());
		}
		System.out.println("methods for each journey. number of journeys="
				+ facade.getResponseJavaObject().getTflJourneys().length);
		for (int x = 0; x < facade.getResponseJavaObject().getTflJourneys().length; x++) {
			System.out.println("journey number x=" + x);
			System.out.println("duration:" + facade.getDurationMinutsOfJourney(x));
			System.out.println("dep point" + facade.getDeparturePointOfJourney(x));
			System.out.println("arr point" + facade.getArrivalPointOfJourney(x));
			System.out.println("number legs:" + facade.getNumberOfLegsOfJourney(x));
			System.out.println("journey:" + facade.getJourney(x));
		}
		for (TflJourney journey : facade.getResponseJavaObject().getTflJourneys()) {
			System.out.println("Start with journey " + journey);
			System.out.println("duration:" + facade.getDurationMinutesOfJourney(journey));
			System.out.println("dep point" + facade.getDeparturePointOfJourney(journey));
			System.out.println("arr point" + facade.getArrivalPointOfJourney(journey));
			System.out.println("number legs:" + facade.getNumberOfLegsOfJourney(journey));
		}

	}

	public void testSteps() {
		System.out.println(
				"test" + facade.getResponseJavaObject().getTflJourneys()[0].getLegs()[0].getPath().getLineString());
		String string = facade.getResponseJavaObject().getTflJourneys()[0].getLegs()[0].getPath().getLineString();
		string = string.replace("[", "");
		string = string.replace("]", "");
		string = string.replace(" ", "");
		System.out.println(string);
		// for(StopPointInPath loc :
		// fascade.getResponseJavaObject().getTflJourneys()[0].getLegs()[0].getPath().getStopPoints()){
		// System.out.println(loc.toString());
		// }
		int x = 0;
		for (JourneyInformation journeyInformation : facade.getInformationStorage().getStoredJourneyInformation()) {
			System.out.println(
					"new journeyInfo!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			for (Location loc : journeyInformation.getRouteLocations()) {
				System.out.println(x + "  " + loc.toString());
				x++;
			}
		}
	}
	public void CompareWithTflWebsite() throws Exception{
		System.out.println("Compare with website:");
		Location from = new Location(51.51100069912,-0.12300137615, facade.getSource());
		Location to = new Location(51.49839044663,-0.1301682292, facade.getSource());
		ArrayList<String> list = new ArrayList<String>();
		list.add("time=1200");
		list.add("date=20170401");
		facade.createResponseJavaObject(from, to, list);
		TflJourney tflJourney = facade.getFirstJourney();
		this.getFromActualResponseObjectWithJourneyObject(tflJourney);
	}

	public void testGetFromActualResponseWithFascade() throws Exception {
		Location from = locationWithoutFailure2;
		Location to = locationWithoutFailure1;
		ArrayList<String> list = new ArrayList<String>();
		list.add("time=2200");
		facade.createResponseJavaObject(from, to, list);
		System.out.println("test GetFromActualResponse with methods of the fascade class:");
		System.out.println("DurationMinutesOfFirstJourney:" + facade.getDurationMinutesOfFirstJourney());
		System.out.println("getDeparturePointOfFirstJourney:" + facade.getDeparturePointOfFirstJourney());
		System.out.println("getArrivalPointOfFirstJourney:" + facade.getArrivalPointOfFirstJourney());
		System.out.println("getNumberOfLegsOfFirstJourney" + facade.getNumberOfLegsOfFirstJourney());
		System.out.println("getFirstJourney" + facade.getFirstJourney());
		System.out.println("getAllJourneys:" + facade.getAllJourneys());
		System.out.println(
				"the following methods of getxxx(TfLJourney tflJourney are done with the first journey from above.");
		TflJourney tflJourney = facade.getFirstJourney();
		this.getFromActualResponseObjectWithJourneyObject(tflJourney);
		this.getFromActualResponseObjectWithJourneyObject(null);
		
		System.out.println(
				"getNumberOfLegsOfJourney called with parameter null:" + facade.getNumberOfLegsOfJourney(null));
		this.getFromActualResponseObjectWithJourneyNumber(0);
		this.getFromActualResponseObjectWithJourneyNumber(1);
		this.getFromActualResponseObjectWithJourneyNumber(-5);
		this.getFromActualResponseObjectWithJourneyNumber(5000);
		
	}
	private void getFromActualResponseObjectWithJourneyObject(TflJourney tflJourney){
		System.out.println("getDurationMinutesOfJourney:" + facade.getDurationMinutesOfJourney(tflJourney));
		System.out.println("getDeparturePointOfJourney" + facade.getDeparturePointOfJourney(tflJourney));
		System.out.println("getArrivalPointOfJourney" + facade.getArrivalPointOfJourney(tflJourney));
		System.out.println("getNumberOfLegsOfJourney:" + facade.getNumberOfLegsOfJourney(tflJourney));
		System.out.println("getDepartureTime:" + facade.getDepartureTimeOfJourney(tflJourney));
		System.out.println("getArrivalTime:" + facade.getArrivalTimeOfJourney(tflJourney));
	}
	private void getFromActualResponseObjectWithJourneyNumber(int number){
		System.out.println("The following methods of getxx(int journeyNumber are done with the journey number "+number);
		System.out.println("getDeparturePointOfJourney:" + facade.getDeparturePointOfJourney(number));
		System.out.println("getArrivalPointOfJourney:" + facade.getArrivalPointOfJourney(number));
		System.out.println("getNumberOfLegsOfJourney:" + facade.getNumberOfLegsOfJourney(number));
		System.out.println("getDepartureTime:" + facade.getDepartureTimeOfJourney(number));
		System.out.println("getArrivalTime:" + facade.getArrivalTimeOfJourney(number));
		System.out.println("getJourney:" + facade.getJourney(number));
	}

	public void testGetFromInformationStorage() throws Exception {
		Location from = locationWithoutFailure1;
		Location to = locationWithoutFailure3;

		facade.createResponseJavaObject(from, to);
		Location fromTfl = facade.getDeparturePointOfFirstJourney();
		Location toTfl = facade.getArrivalPointOfFirstJourney();

		System.out.println(
				"Get Information From InformationStorage. with from and to Location objects of the Locations requested to TfL:");
		testGetFromInformationStorage(from, to);
		System.out
				.println("request to InformationStorage with the departure and arrival Locations of the TfL response:");
		testGetFromInformationStorage(fromTfl, toTfl);
		System.out.println("request to InformationStorage with null objects:");
		testGetFromInformationStorage(null, null);

	}

	private void testGetFromInformationStorage(Location from, Location to) {
		System.out.println("getAverageNumberOfLegs:" + facade.getAverageNumberOfLegs(from, to));
		if (facade.getPublicTransport().getInformationStorage().getJourneyInformation(from, to) != null)
			System.out.println("all number of legs:" + facade.getPublicTransport().getInformationStorage()
					.getJourneyInformation(from, to).getAllNumbersOfLegs());
		System.out.println("getAverageDistanceWalkingKM:" + facade.getAverageDistanceWalkingKM(from, to));
		if (facade.getPublicTransport().getInformationStorage().getJourneyInformation(from, to) != null)
			System.out.println("All walking distances:" + facade.getPublicTransport().getInformationStorage()
					.getJourneyInformation(from, to).getDistancesMeter());
		System.out.println("getAverageDurationMS:" + facade.getAverageDurationMSForJourney(from, to));
		if (facade.getPublicTransport().getInformationStorage().getJourneyInformation(from, to) != null)
			System.out.println("all durations:" + facade.getPublicTransport().getInformationStorage()
					.getJourneyInformation(from, to).getTimesMS());
		System.out.println("getRouteLocationsOfJourney:" + facade.getRouteLocationsOfJourney(from, to));

	}

}
