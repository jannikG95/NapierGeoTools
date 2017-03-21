import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;







import edu.napier.geo.common.Location;
import edu.napier.geo.publicTransport.InformationStorage.JourneyInformation;
import edu.napier.geo.publicTransport.Response.Leg;
import edu.napier.geo.publicTransport.Response.ResponseTfL;
import edu.napier.geo.publicTransport.Response.StopPoint;
import edu.napier.geo.publicTransport.Response.StopPointInPath;
import edu.napier.geo.publicTransport.Response.TflJourney;
import edu.napier.geo.publicTransport.fascade.PublicTransportFascade;
import edu.napier.geo.publicTransport.main.PublicTransport;
import edu.napier.geo.publicTransport.main.RequestAndGetJsonFromServer;

public class RunTest {
	
//	private static PublicTransport publicTransport;
	private static PublicTransportFascade fascade;

	
	public static void main(String args[]) throws Exception{
		RunTest test = new RunTest();
		fascade=new PublicTransportFascade();
		
		fascade.createNewPublicTransport(false);
		test.test();
		test.testGetMethods();
		test.testSteps();
		test.testGetFromActualResponseWithFascade();
		
	}
	
	private void test() throws Exception{
		ArrayList<String> preferencesTestList = new ArrayList<String>();
		preferencesTestList.add("fromName=DepartureLocationTestName");

		// try {
		
		Location locationWithoutFailure1 = new Location(51.51100069912, -0.12300137615, fascade.getSource());
		Location locationWithoutFailure2 = new Location(51.49839044663, -0.1301682292, fascade.getSource());
		Location locationWithoutFailure3 = new Location(51.599577, -0.059587, fascade.getSource());
//		Location locationWithFailure = new Location();

		fascade.createResponseJavaObject(locationWithoutFailure1, locationWithoutFailure2, preferencesTestList);
		
		
//		String responseString;
//		try {
//			responseString = RequestAndGetJsonFromServer.getJSON(locationWithoutFailure3/*oldLocation*/, locationWithoutFailure2,
//					preferencesTestList);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			responseString = null;
//		}

		
//		responseJavaObject = getResponseObjectFromJSONString(responseString);

		ResponseTfL responseJavaObject= fascade.getResponseJavaObject();
		System.out.println("object x=:" + responseJavaObject.x());
		System.out.println("number of journeys=" + responseJavaObject.getTflJourneys().length);
		

		System.out.println(
				"with obj. !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("averageTime="
				+ fascade.getInformationStorage().getAverageTimeMSForJourney(locationWithoutFailure1, locationWithoutFailure2));
		System.out.println(
				"obj.dep point lat=" + responseJavaObject.getTflJourneys()[0].getLegs()[0].getDeparturePoint().getLat());
		System.out.println(
				"obj.dep point lon=" + responseJavaObject.getTflJourneys()[0].getLegs()[0].getDeparturePoint().getLon());
		System.out.println("locationWithoutFail1 lat=" + locationWithoutFailure1.getLat());
		System.out.println("locationWithoutFail1 lon=" + locationWithoutFailure1.getLon());
		System.out.println(
				"obj.arr point lat=" + responseJavaObject.getTflJourneys()[responseJavaObject.getTflJourneys().length - 1]
						.getLegs()[responseJavaObject.getTflJourneys()[responseJavaObject.getTflJourneys().length - 1]
								.getLegs().length - 1].getArrivalPoint().getLat());
		System.out.println(
				"obj.arr point lon=" + responseJavaObject.getTflJourneys()[responseJavaObject.getTflJourneys().length - 1]
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

		fascade.getPublicTransport().printAllJourneyInformation();

		System.out
				.println("informationStorage.getStoredJourneys.size=" + fascade.getInformationStorage().getStoredJourneyInformation().size());

		System.out.println("avg time from old location:"+fascade.getInformationStorage().getAverageTimeMSForJourney(locationWithoutFailure3, locationWithoutFailure2));

		fascade.getPublicTransport().printAllJourneyInformation();


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
	
	public void testGetMethods(){
		System.out.println("duration first journey:"+fascade.getDurationMinutesOfFirstJourney());
		System.out.println("dep point first journey:"+fascade.getDeparturePointOfFirstJourney().toString());
		System.out.println("arr point first journey:"+fascade.getArrivalPointOfFirstJourney().toString());
		System.out.println("number legs first journey:"+fascade.getNumberOfLegsOfFirstJourney());
		System.out.println("first journey"+fascade.getFirstJourney().toString());
		System.out.println("get all journeys:");
		for(TflJourney journey: fascade.getAllJourneys()){
			System.out.println("get all journeys function. journey:"+journey+" = "+journey.toString());
		}
		System.out.println("methods for each journey. number of journeys="+fascade.getResponseJavaObject().getTflJourneys().length);
		for(int x=0; x<fascade.getResponseJavaObject().getTflJourneys().length;x++ ){
			System.out.println("journey number x="+x);			
			System.out.println("duration:"+fascade.getDurationMinutsOfJourney(x));
			System.out.println("dep point"+fascade.getDeparturePointOfJourney(x));
			System.out.println("arr point"+fascade.getArrivalPointOfJourney(x));
			System.out.println("number legs:"+fascade.getNumberOfLegsOfJourney(x));
			System.out.println("journey:"+fascade.getJourney(x));
		}
		for(TflJourney journey : fascade.getResponseJavaObject().getTflJourneys()){
			System.out.println("Start with journey "+journey);
			System.out.println("duration:"+fascade.getDurationMinutesOfJourney(journey));
			System.out.println("dep point"+fascade.getDeparturePointOfJourney(journey));
			System.out.println("arr point"+fascade.getArrivalPointOfJourney(journey));
			System.out.println("number legs:"+fascade.getNumberOfLegsOfJourney(journey));
		}
		
		
		
	}
	public void testSteps(){
		System.out.println("test"+fascade.getResponseJavaObject().getTflJourneys()[0].getLegs()[0].getPath().getLineString());
		String string= fascade.getResponseJavaObject().getTflJourneys()[0].getLegs()[0].getPath().getLineString();
		string=string.replace("[", "");
		string=string.replace("]", "");
		string=string.replace(" ", "");
		System.out.println(string);
//		for(StopPointInPath loc : fascade.getResponseJavaObject().getTflJourneys()[0].getLegs()[0].getPath().getStopPoints()){
//			System.out.println(loc.toString());
//		}
		int x=0;
		for (JourneyInformation journeyInformation : fascade.getInformationStorage().getStoredJourneyInformation()){
			System.out.println("new journeyInfo!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			for (Location loc : journeyInformation.getRouteLocations()){
				System.out.println(x+"  "+loc.toString());
				x++;
			}
		}
	}
	public void testGetFromActualResponseWithFascade(){
		System.out.println("testGetFromActualResponseWithFascade");
		System.out.println("DurationMinutesOfFirstJourney:"+fascade.getDurationMinutesOfFirstJourney());
		System.out.println("getDeparturePointOfFirstJourney:"+fascade.getDeparturePointOfFirstJourney());
		System.out.println("getArrivalPointOfFirstJourney:"+fascade.getArrivalPointOfFirstJourney());
		System.out.println("getNumberOfLegsOfFirstJourney"+fascade.getNumberOfLegsOfFirstJourney());
		System.out.println("getFirstJourney"+fascade.getFirstJourney());
		System.out.println("getAllJourneys:"+fascade.getAllJourneys());
		System.out.println("the following methods of getxxx(TfLJourney tflJourney are done with the first journey from above.");
		TflJourney tflJourney= fascade.getFirstJourney();
		System.out.println("getDurationMinutesOfJourney:"+fascade.getDurationMinutesOfJourney(tflJourney));
		System.out.println("getDeparturePointOfJourney"+fascade.getDeparturePointOfJourney(tflJourney));
		System.out.println("getArrivalPointOfJourney"+fascade.getArrivalPointOfJourney(tflJourney));
		System.out.println("getNumberOfLegsOfJourney:"+fascade.getNumberOfLegsOfJourney(tflJourney));
		System.out.println("getNumberOfLegsOfJourney called with parameter null:"+fascade.getNumberOfLegsOfJourney(null));
		System.out.println("The following methods of getxx(int journeyNumber are done with the journey number 1");
		System.out.println("getDeparturePointOfJourney:"+fascade.getDeparturePointOfJourney(1));
		System.out.println("getArrivalPointOfJourney:"+fascade.getArrivalPointOfJourney(1));
		System.out.println("getNumberOfLegsOfJourney:"+fascade.getNumberOfLegsOfJourney(1));
		System.out.println("getJourney:"+fascade.getJourney(1));
		System.out.println("getJourney with negative number (-5):"+fascade.getJourney(-5));
		System.out.println("getJourney with high number (1000):"+fascade.getJourney(1000));
	}

}
