package test;

import java.util.HashMap;
import java.util.List;

import com.graphhopper.routing.util.*;
import com.graphhopper.routing.util.FlagEncoder;

import edu.napier.geo.common.Location;
import facade.CustomCarFlagEncoder;
import facade.GHFacade;
import facade.GHJourney;

public class UsabilityTest {
	
	public static void main(String[] args) {
		String osmFile = "C:\\Users\\Jannik\\Documents\\Uni\\6. Sem (Schottland)\\Honours Project\\Tomcat\\map (2).osm";
		String folderPath = "C:\\Users\\Jannik\\Desktop\\gh";
		Location a = new Location(55.95095 ,-3.20272,1);
		Location b = new Location(55.95343, -3.19738,2);
		
		GHFacade facade = new GHFacade();
		
		CustomCarFlagEncoder myCar = (CustomCarFlagEncoder) facade.getEncoder(GHFacade.CUSTOMCAR);
		myCar.setName("bus");
		// myCar.getAbsoluteBarriers().add("anything");
		
		FlagEncoder bike = (BikeFlagEncoder) facade.getEncoder(GHFacade.BIKE);
		FlagEncoder foot = (FootFlagEncoder) facade.getEncoder(GHFacade.FOOT);
				
		FlagEncoder[] encoders = {myCar, bike, foot};
		
		HashMap<String, Object> options = facade.getOptionsMap();
		options.put("pathToOSM", osmFile); // String
		options.put("pathToFolder", folderPath); // String
		options.put("profilesForGraph", encoders); // FlagEncoder[] from getEncoder()
		options.put("enableCH", false); // boolean
		options.put("maxVisitedNodes", 500); // int
		options.put("includeElevation", true); // boolean
		options.put("algorithm", GHFacade.DIJKSTRABI); // String
		options.put("profileForRequest", GHFacade.FOOT); // String equal to FlagEncoder.toString()
		options.put("weighting", GHFacade.FASTEST); // String
		
		GHJourney journey = (GHJourney) facade.getJourney(a, b, options);
		System.out.println(System.currentTimeMillis());
		GHJourney journey2 = facade.route(journey);
		System.out.println(System.currentTimeMillis());
		System.out.println(journey2.getOrigin());
		System.out.println(journey2.getDistanceKM());
		System.out.println(journey2.getTravelTimeMS());
		
		List<Location> l = journey2.getWaypoints();
		for(Location loc : l){
			System.out.println(loc.getLat()+" "+ loc.getLon() +" "+ loc.getAlt());
		}
		
	}
	
}
