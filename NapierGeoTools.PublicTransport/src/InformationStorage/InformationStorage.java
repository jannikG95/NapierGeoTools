package InformationStorage;

import java.io.Serializable;
import java.util.ArrayList;

import General.Location;
import ResponseTfL.Journey;
import ResponseTfL.Leg;
import ResponseTfL.Response;

public class InformationStorage implements Serializable {
	private ArrayList<JourneyInformation> storedJourneys = new ArrayList<JourneyInformation>();

	// public static void addRouteWithTimes(AverageTimeForRoute
	// averageTimeForRoute){
	// routesWithTimes.add(averageTimeForRoute);
	// }

	public double getAverageTimeForRoute(Location from, Location to) {
		JourneyInformation j = getJourney(from, to);
		if (j != null)
			return j.getAverageTime();
		return 0;
	}

	public void storeInformation(Response response) {
		System.out.println("InformationStorage-calcAndStoreInformation(response)");
		storeJourneys(response.getJourneys());
	}

	private void storeJourneys(Journey[] journeys) {
		for (Journey journey : journeys) {
			storeJourney(journey);
		}
	}

	private JourneyInformation getJourney(Location from, Location to) {
		for (JourneyInformation journeyInformation : storedJourneys) {
			if (from.hasSameLocationAs(journeyInformation.getFrom())
					&& to.hasSameLocationAs(journeyInformation.getTo())) {
				return journeyInformation;
			}
		}
		return null;
	}

	private void storeJourney(Journey journey) {
		// adds times of journeys to an object of AverageTimeForRoute (if there
		// is one for this route, otherwise it creates one)
		// System.out.println("InformationStorage-calcRoutesWithTimes(journey)");
		// boolean routeExists = false;
		// for (JourneyInformation journeyInforation : storedJourneys) {
		// if
		// (journey.getLegs()[0].getDeparturePoint().hasSameLocationAs(journeyInforation.getFrom())
		// && journey.getLegs()[journey.getLegs().length - 1].getArrivalPoint()
		// .hasSameLocationAs(journeyInforation.getTo())) {
		// journeyInforation.addTime(journey.getDuration());
		// journeyInforation.addLeg(journey.getLegs().length);
		// routeExists = true;
		// System.out.println("match with route:
		// dep:"+journeyInforation.getFrom().print()+"arr:"+journeyInforation.getTo().print());
		// }
		// if(routeExists)
		// break;
		// }
		JourneyInformation j = getJourney(journey.getLegs()[0].getDeparturePoint(),
				journey.getLegs()[journey.getLegs().length - 1].getArrivalPoint());
		if (j != null) {
			j.addTime(journey.getDuration());
			j.addLeg(journey.getLegs().length);
		} else {
			System.out.println("no match. create new route");
			storedJourneys.add(new JourneyInformation(journey.getLegs()[0].getDeparturePoint(),
					journey.getLegs()[journey.getLegs().length - 1].getArrivalPoint(), journey.getDuration(),
					journey.getLegs().length));
		}
	}

	public double getAverageTimeForJourney(Location from, Location to) {
		JourneyInformation j = getJourney(from, to);
		if (j != null)
			return j.getAverageTime();
		return 0;
	}

	public double getAverageNumberOfLegs(Location from, Location to) {
		JourneyInformation j = getJourney(from, to);
		if (j != null)
			return j.getAverageNumberOfLegs();
		return 0;
	}

	public ArrayList<JourneyInformation> getStoredJourneys() {
		return storedJourneys;
	}

	public String print() {
		return "InformationStorageObject with storedJourneys.size=" + this.getStoredJourneys().size();
	}

	// private static boolean TwoLocationsHaveSameoordinates(Location location1,
	// Location location2) {
	// if (location1.getLat() == location2.getLat() && location1.getLon() ==
	// location2.getLon())
	// return true;
	// return false;
	// }

}
