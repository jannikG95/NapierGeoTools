package HelperClasses;

import java.util.ArrayList;

import SharedClasses.Coordinates;

public class StringBuilder {

	public static String buildCoordinateString(ArrayList<Coordinates> coordinates)
	{
		String coordinateString = "";
		
		for (Coordinates coordinatesInstance : coordinates) {
			coordinateString += coordinatesInstance.getLongitude() + "," + coordinatesInstance.getLatitude() +","+ coordinatesInstance.getAltitude() + " " ; 
		}
		
		return coordinateString;
	}
	
}
