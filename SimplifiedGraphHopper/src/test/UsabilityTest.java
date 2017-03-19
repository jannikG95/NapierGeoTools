package test;

import java.util.HashMap;
import java.util.List;

import com.graphhopper.routing.util.BikeFlagEncoder;
import com.graphhopper.routing.util.FlagEncoder;
import edu.napier.geo.common.Location;
import facade.CustomCarFlagEncoder;
import facade.GHFacade;
import facade.GHJourney;

public class UsabilityTest {

	public static void main(String[] args) {
		String osmFile = "C:\\Users\\Jannik\\Desktop\\map.osm";
		String folderPath = "C:\\Users\\Jannik\\Desktop\\myFolder";
		Location a = new Location(55.95095 ,-3.20272,0);
		Location b = new Location(55.95343, -3.19738,0);
		
		GHFacade facade = new GHFacade();
		
		CustomCarFlagEncoder bus = (CustomCarFlagEncoder) facade.getEncoder(GHFacade.CUSTOMCAR);
		bus.setName("bus");
		// myCar.getAbsoluteBarriers().add("anything");
		
		FlagEncoder bike = (BikeFlagEncoder) facade.getEncoder(GHFacade.BIKE);
				
		FlagEncoder[] encoders = {bus, bike};
		
		HashMap<String, Object> options = facade.getOptionsMap();
		options.put("pathToOSM", osmFile);
		options.put("pathToFolder", folderPath);
		options.put("profilesForGraph", encoders);
		options.put("enableCH", false);
		options.put("maxVisitedNodes", 500);
		options.put("includeElevation", false);
		options.put("algorithm", GHFacade.DIJKSTRA);
		options.put("profileForRequest", "bus");
		options.put("weighting", GHFacade.FASTEST);
		
		GHJourney journey = (GHJourney) facade.getJourney(a, b, options);
		
		journey = facade.route(journey);
		
		System.out.println("Journey Origin: " + journey.getOrigin());
		System.out.println("Distance in KM: " + journey.getDistanceKM());
		System.out.println("Time in MS: " + journey.getTravelTimeMS());
		System.out.println("Waypoints:");
		List<Location> l = journey.getWaypoints();
		for(Location loc : l){
			System.out.println(loc.getLat()+" "+ loc.getLon());
		}
	}
}
