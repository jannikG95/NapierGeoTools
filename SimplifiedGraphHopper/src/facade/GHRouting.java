package facade;

import java.util.ArrayList;
import java.util.List;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.PathWrapper;
import com.graphhopper.routing.util.EncodingManager;
import com.graphhopper.routing.util.FlagEncoder;
import com.graphhopper.util.PointList;
import com.graphhopper.util.shapes.GHPoint3D;

import edu.napier.geo.common.Location;

/**
 * handles GraphHopper, especially routing
 * 
 * @author Jannik Enenkel
 */

public class GHRouting {

	private CustomGraphHopper hopper;
	private GHJourney journey;
	
	public GHRouting(GHJourney journey){
		this.journey = journey;
	}
	
	public GHJourney getJourney() {
		return journey;
	}

	public void setJourney(GHJourney journey) {
		this.journey = journey;
	}
	
	public GHJourney processJourney(){
		selectOSMFile();
		setGHOptions();
		hopper.importOrLoad();
		makeRequest();
		hopper.close();
		return journey;
	}
	
	/**
	 * reads in the OSM file and specifies the location for local storage
	 */
	private void selectOSMFile() {
		hopper = new CustomGraphHopper();
		hopper.forDesktop();
		
		String pathToOSM = (String) journey.getOptions().get("pathToOSM");
		hopper.setDataReaderFile(pathToOSM);
		
		String pathToFolder = (String) journey.getOptions().get("pathToFolder");
		hopper.setGraphHopperLocation(pathToFolder);
	}

	/**
	 * Most important graphhopper options. Must be defined before generating the graph. 
	 */
	private void setGHOptions() {
//		String[] profiles = (String[]) journey.getOptions().get("profilesForGraph");
//		String em = "";
//		for (int i = 0; i < profiles.length; i++)
//			em += profiles[i] + ",";
		FlagEncoder[] fe = (FlagEncoder[]) journey.getOptions().get("profilesForGraph");
		hopper.setEncodingManager(new EncodingManager(fe));
		
		boolean enableCH = (boolean) journey.getOptions().get("enableCH");
		hopper.getCHFactoryDecorator().setEnabled(enableCH);
		
		int maxVisitedNodes = (int) journey.getOptions().get("maxVisitedNodes");
		if (!enableCH)			
			hopper.setMaxVisitedNodes(maxVisitedNodes);
		
		boolean includeElevation = (boolean) journey.getOptions().get("includeElevation");
		hopper.setElevation(includeElevation);
	}

	/**
	 * calculates the route. 
	 */
	private void makeRequest() {
		GHRequest req = getRequest();
		
		String profile = (String) journey.getOptions().get("profileForRequest");
		req.setVehicle(profile);
		
		String algorithm = (String) journey.getOptions().get("algorithm");
		req.setAlgorithm(algorithm);
		
		String weighting = (String) journey.getOptions().get("weighting");
		req.setWeighting(weighting);

		GHResponse rsp = getGHResponse(req);

		PathWrapper bestPath = rsp.getBest();

		journey.setTravelTimeMS(bestPath.getTime());
		journey.setDistanceKM(bestPath.getDistance() / 1000);
		journey.setWaypoints(getWaypoints(bestPath));
	}

	/**
	 * helper class for using a Journey object to make a request
	 */
	private GHRequest getRequest() {
		double latFrom = journey.getPointA().getLat();
		double lonFrom = journey.getPointA().getLon();
		double latTo = journey.getPointB().getLat();
		double lonTo = journey.getPointB().getLon();

		return new GHRequest(latFrom, lonFrom, latTo, lonTo);
	}

	/**
	 * creates the response and handles possible errors in it.
	 */
	private GHResponse getGHResponse(GHRequest req) {
		GHResponse rsp = hopper.route(req);
		if (rsp.hasErrors()) {
			List<Throwable> errors = rsp.getErrors();
			for (Throwable t : errors)
				System.out.println(t.getMessage());
		}
		return rsp;
	}

	/**
	 * converts graphhopper points to location objects
	 */
	private List<Location> getWaypoints(PathWrapper path) {
		List<Location> wp = new ArrayList<Location>();
		PointList points = path.getPoints();
		for (GHPoint3D p : points) {
			wp.add(new Location(p.getLat(), p.getLon(), p.getEle()));
		}
		return wp;
	}
}
