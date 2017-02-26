package facade;

import java.util.HashMap;

import com.graphhopper.routing.util.FlagEncoder;
import com.graphhopper.util.PMap;

import edu.napier.geo.common.Journey;
import edu.napier.geo.common.JourneyFactory;
import edu.napier.geo.common.Location;

/**
 * Facade class for the simplified use of the GraphHopper routing engine
 * 
 * Possibilities:
 * - create a Journey that GH can handle (call getOptionsMap() first)
 * - process the Journey object
 * - create your own routing profile (e.g. bus)
 * - create your own weighting for routing (e.g. eco efficient)
 * 
 * @author Jannik Enenkel
 */

/**
 * TO DO: 
 * - own weighting 
 * - cache hoppers 
 * - cache journey 
 * - enumerations 
 * - upload jar 
 * - tuesday 1300
 */

public class GHFacade implements JourneyFactory {

	private HashMap<String, Object> optionsMap;

	public GHFacade() {
		optionsMap = new HashMap<String, Object>();
		optionsMap.put("pathToOSM", null); // String
		optionsMap.put("pathToFolder", null); // String
		optionsMap.put("profilesForGraph", null); // FlagEncoder
		optionsMap.put("enableCH", null); // boolean
		optionsMap.put("maxVisitedNodes", null); // int
		optionsMap.put("includeElevation", null); // boolean
		optionsMap.put("algorithm", null); // String
		optionsMap.put("profileForRequest", null); // String equal to FlagEncoder.toString()
		optionsMap.put("weighting", null); // mal sehen
	}

	public HashMap<String, Object> getOptionsMap() {
		return optionsMap;
	}

	@Override
	public Journey getJourney(Location start, Location finish) {
		return null;
	}

	@Override
	public Journey getJourney(Location start, Location finish, HashMap<String, Object> options) {
		if (options.containsKey("pathToOSM") && options.containsKey("pathToFolder")
				&& options.containsKey("profilesForGraph") && options.containsKey("enableCH")
				&& options.containsKey("maxVisitedNodes") && options.containsKey("includeElevation")
				&& options.containsKey("profileForRequest") && options.containsKey("algorithm")
				&& options.containsKey("weighting")) {
			GHJourney j = new GHJourney(start, finish);
			j.setOptions(options);
			return j;
		} else
			throw new IllegalArgumentException("options parameter not ok");
	}

	public GHJourney route(GHJourney j) {
		GHRouting r = new GHRouting(j);
		GHJourney journey = r.processJourney();
		return journey;
	}

	public FlagEncoder getEncoder(String name) {
		MyFlagEncoderFactory factory = new MyFlagEncoderFactory();
		return factory.createFlagEncoder(name, new PMap());
	}

	// own weighting
}
