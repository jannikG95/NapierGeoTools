package edu.napier.geo.easykml.xmlunittest;

import java.awt.Color;

import edu.napier.geo.common.Location;
import edu.napier.geo.easykml.KML_Object.Playlist;
import edu.napier.geo.easykml.KML_Object.abstractView.LookAt;
import edu.napier.geo.easykml.KML_Object.feature.Placemark;
import edu.napier.geo.easykml.KML_Object.feature.Tour;
import edu.napier.geo.easykml.KML_Object.geometry.LineString;
import edu.napier.geo.easykml.KML_Object.geometry.Point;
import edu.napier.geo.easykml.KML_Object.gx_TourPrimitive.FlyTo;
import edu.napier.geo.easykml.KML_Object.gx_TourPrimitive.Wait;
import edu.napier.geo.easykml.KML_Object.stylesector.Style;
import edu.napier.geo.easykml.KML_Object.subStyle.colorStyle.LineStyle;
import edu.napier.geo.easykml.facade.EasyKMLCreator;
import edu.napier.geo.easykml.helperClasses.AltitudeModes;

public class UsabilityTest {

	public static void main(String[] args) {
		
		EasyKMLCreator easyKmlCreator = new EasyKMLCreator();
		
		LookAt lookAt = new LookAt();
		lookAt.setCoordinates(new Location(-39.279, 174.007, 0.0));
		
		FlyTo flyTo = new FlyTo(2.0, lookAt);
		Wait wait = new Wait(3.0);
		
		Playlist playlist = new Playlist();
		playlist.addPrimitiveAction(flyTo);
		playlist.addPrimitiveAction(wait);
		
		Tour tour = new Tour(playlist);
		easyKmlCreator.createTour(tour);
		
		
		Point p = new Point(new Location(-43.61725568991338, 170.1426332867125, 0.0));
		easyKmlCreator.createSimplePoint(p);
		
		Point point = new Point(new Location(-43.61725568991338, 170.1426332867125, 0.0));
		Placemark placemark = new Placemark("Name", "Description", point);
		placemark.setId("Point 1");
		easyKmlCreator.createPlacemark(placemark);
		
		Style style = new Style();
		LineStyle lineStyle = new LineStyle();
		lineStyle.setColor(Color.CYAN);
		style.setLineStyle(lineStyle);
		easyKmlCreator.createStyle(style);
		
		try {
			easyKmlCreator.saveKMLDocument();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
