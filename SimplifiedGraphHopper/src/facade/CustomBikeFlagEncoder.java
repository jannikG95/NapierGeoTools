package facade;

import com.graphhopper.routing.util.BikeCommonFlagEncoder;

public class CustomBikeFlagEncoder extends BikeCommonFlagEncoder{

	private String name = "customBike";	

	public CustomBikeFlagEncoder(){
		super(4, 2, 1);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
