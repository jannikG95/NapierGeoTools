package facade;

import com.graphhopper.routing.util.CarFlagEncoder;

public class CustomCarFlagEncoder extends CarFlagEncoder{

	private String name = "customCar";
	
	public CustomCarFlagEncoder(){
		super(5, 5, 0);
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
