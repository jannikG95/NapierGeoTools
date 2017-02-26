package facade;

import com.graphhopper.routing.util.FootFlagEncoder;

public class CustomFootFlagEncoder extends FootFlagEncoder{

	private String name = "customFoot";
	
	public CustomFootFlagEncoder() {
		super(4, 1);
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
