package test;

import java.util.HashMap;
import java.util.List;

import edu.napier.geo.common.Location;
import facade.GHFacade;
import facade.GHJourney;

public class Test {
	
	
	public static void main(String[] args) {
		String osmFile = "C:\\Users\\Jannik\\Documents\\Uni\\6. Sem (Schottland)\\Honours Project\\Tomcat\\map.osm";
		String folderPath = "C:\\Users\\Jannik\\Desktop\\gh";
		String[] vehicles = {"car", "bike", "foot"};
		Location a = new Location(55.95095 ,-3.20272,0);
		Location b = new Location(55.95343, -3.19738,0);
		
		GHFacade facade = new GHFacade();
		
		HashMap<String, Object> optionsMap = facade.getOptionsMap();
		optionsMap.put("pathToOSM", osmFile);
		optionsMap.put("pathToFolder", folderPath );
		optionsMap.put("profilesForGraph", facade.getEncoder("car"));
		optionsMap.put("enableCH", false);
		optionsMap.put("maxVisitedNodes", 100);
		optionsMap.put("includeElevation", true);
		optionsMap.put("profileForRequest", "car");
		optionsMap.put("algorithm", "dijkstra");
		optionsMap.put("weighting", "fastest");
		
		GHJourney j = (GHJourney) facade.getJourney(a, b, optionsMap);
		
		j = facade.route(j);
		
		List<Location> l = j.getWaypoints();
		for(Location loc : l){
			System.out.println(loc.getLat()+" "+ loc.getLon() +" "+ loc.getAlt());
		}
		System.out.println(j.getDistanceKM());
		System.out.println(j.getTravelTimeMS());
	}
}
