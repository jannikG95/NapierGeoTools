package facade;

import java.util.HashMap;
import java.util.List;

import edu.napier.geo.common.Journey;
import edu.napier.geo.common.Location;

/**
 * Journey class for the use with GraphHopper
 * 
 * @author Jannik Enenkel
 *
 */

public class GHJourney extends Journey {
	
	private final String origin = "GraphHopper";
	private HashMap<String, Object> options;
	protected List<Location> waypoints; // contains routing information

	public GHJourney(Location a, Location b) {
		super(a, b);
	}

	/**
	 * 
	 * @return the origin of this journey (here: GraphHopper)
	 */
	public String getOrigin() {
		return origin;
	}
	
	public void setOptions(HashMap<String, Object> options){
		this.options = options;
	}
	
	public HashMap<String, Object> getOptions(){
		return options;
	}		
	
	public List<Location> getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(List<Location> waypoints) {
		this.waypoints = waypoints;
	}

}
