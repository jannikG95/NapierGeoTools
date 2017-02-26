package facade;

import com.graphhopper.routing.util.FlagEncoder;
import com.graphhopper.routing.util.FlagEncoderFactory;
import com.graphhopper.util.PMap;

public class MyFlagEncoderFactory implements FlagEncoderFactory {

	@Override
	public FlagEncoder createFlagEncoder(String name, PMap configuration) {
		if(name.equals(CAR))
			return FlagEncoderFactory.DEFAULT.createFlagEncoder(CAR, configuration);
		if(name.equals(BIKE))
			return FlagEncoderFactory.DEFAULT.createFlagEncoder(BIKE, configuration);
		if(name.equals(CAR4WD))
			return FlagEncoderFactory.DEFAULT.createFlagEncoder(CAR4WD, configuration);
		if(name.equals(MOUNTAINBIKE))
			return FlagEncoderFactory.DEFAULT.createFlagEncoder(MOUNTAINBIKE, configuration);
		if(name.equals(MOTORCYCLE))
			return FlagEncoderFactory.DEFAULT.createFlagEncoder(MOTORCYCLE, configuration);
		if(name.equals(RACINGBIKE))
			return FlagEncoderFactory.DEFAULT.createFlagEncoder(RACINGBIKE, configuration);
		if(name.equals(HIKE))
			return FlagEncoderFactory.DEFAULT.createFlagEncoder(HIKE, configuration);
		if(name.equals(FOOT))
			return FlagEncoderFactory.DEFAULT.createFlagEncoder(FOOT, configuration);
		if(name.equals(BIKE2))
			return FlagEncoderFactory.DEFAULT.createFlagEncoder(BIKE2, configuration);
		if(name.equals("customCar"))
			return new CustomCarFlagEncoder();
		if(name.equals("customBike"))
			return new CustomBikeFlagEncoder();
		if(name.equals("customFoot"))
			return new CustomFootFlagEncoder();
		return null;
	}

}
