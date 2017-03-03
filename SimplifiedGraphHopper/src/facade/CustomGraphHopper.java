package facade;

import com.graphhopper.GraphHopper;
import com.graphhopper.routing.util.FlagEncoder;
import com.graphhopper.routing.util.HintsMap;
import com.graphhopper.routing.weighting.Weighting;
import com.graphhopper.storage.Graph;

public class CustomGraphHopper extends GraphHopper {

	@Override
	public Weighting createWeighting(HintsMap hintsMap, FlagEncoder encoder, Graph graph) {
		String weighting = hintsMap.getWeighting().toLowerCase();
		if (weighting.equals("customWeighting"))
			return new CustomWeighting(encoder);
		else
			return super.createWeighting(hintsMap, encoder, graph);
	}
}
