package edu.napier.geo.easykml.facade;

import java.awt.Color;
import java.util.ArrayList;

import edu.napier.geo.common.Location;
import edu.napier.geo.easykml.KML_Object.Playlist;
import edu.napier.geo.easykml.KML_Object.abstractView.Camera;
import edu.napier.geo.easykml.KML_Object.abstractView.LookAt;
import edu.napier.geo.easykml.KML_Object.feature.Placemark;
import edu.napier.geo.easykml.KML_Object.feature.Tour;
import edu.napier.geo.easykml.KML_Object.geometry.LineString;
import edu.napier.geo.easykml.KML_Object.geometry.LinearRing;
import edu.napier.geo.easykml.KML_Object.geometry.Point;
import edu.napier.geo.easykml.KML_Object.geometry.Polygon;
import edu.napier.geo.easykml.KML_Object.gx_TourPrimitive.AnimatedUpdate;
import edu.napier.geo.easykml.KML_Object.gx_TourPrimitive.FlyTo;
import edu.napier.geo.easykml.KML_Object.gx_TourPrimitive.SoundCue;
import edu.napier.geo.easykml.KML_Object.gx_TourPrimitive.TourControl;
import edu.napier.geo.easykml.KML_Object.gx_TourPrimitive.Wait;
import edu.napier.geo.easykml.KML_Object.stylesector.Style;
import edu.napier.geo.easykml.KML_Object.subStyle.colorStyle.IconStyle;
import edu.napier.geo.easykml.KML_Object.subStyle.colorStyle.LabelStyle;
import edu.napier.geo.easykml.KML_Object.subStyle.colorStyle.LineStyle;
import edu.napier.geo.easykml.KML_Object.subStyle.colorStyle.PolyStyle;
import edu.napier.geo.easykml.KML_Object.timePrimitive.Time;
import edu.napier.geo.easykml.KML_Object.timePrimitive.TimePrimitive;
import edu.napier.geo.easykml.KML_Object.timePrimitive.TimeStamp;
import edu.napier.geo.easykml.Update.Change;
import edu.napier.geo.easykml.Update.Update;
import edu.napier.geo.easykml.helperClasses.AltitudeModes;


public class Client {


	public static void main(String[] args) {
		KML_Facade simpleKML = new KML_Facade();

		// create Document
		simpleKML.createKMLDocument();

		// create Styles
		Style style = new Style();
		style.setId("TestStyle");
		IconStyle iconStyle = new IconStyle();
		iconStyle.setId("istyle");
		iconStyle.setScale(1.0f);
		iconStyle.setIconHttpAddress("http://maps.google.com/mapfiles/kml/pal3/icon21.png");
		style.setIconStyle(iconStyle);

		LineStyle lineStyle = new LineStyle();
		lineStyle.setColor(Color.RED);
		lineStyle.setWidth(5.0f);
		lineStyle.setTransparency(50);
		style.setLineStyle(lineStyle);

		PolyStyle polyStyle = new PolyStyle();
		polyStyle.setId("Pol");
		polyStyle.setColor(Color.GREEN);
		polyStyle.setTransparency(80);
		polyStyle.setFillPolygon(true);
		style.setPolyStyle(polyStyle);

		LabelStyle labelStyle = new LabelStyle();
		labelStyle.setScale(10.0f);
		labelStyle.setTransparency(50);
		labelStyle.setColor(Color.BLUE);
		style.setLabelStyle(labelStyle);

		simpleKML.createStyle(style);

		// create placemark
		Camera cameraPM = new Camera();
		cameraPM.setCoordinates(new Location(-43.671, 170.157, 9700.0));
		cameraPM.setHeading(-6.333);
		cameraPM.setTilt(33.5);
		cameraPM.setRoll(0.0);
		Placemark pm = new Placemark("Test", "test123",
				new Point(new Location(37.42228990140251, -122.0822035425683, 0.0)));
		pm.setStyleURL("TestStyle");
		pm.setAbstractView(cameraPM);
		pm.setId("alsfsasfa");

		simpleKML.createPlacemark(pm);

		// create path
		ArrayList<Location> coordinates = new ArrayList<>();
		coordinates.add(new Location(37.42228990140251, -122.0822035425683, 0.0));
		coordinates.add(new Location(37.42228990140251, -125.0822035425683, 0.0));
		coordinates.add(new Location(50.42228990140251, -126.0822035425683, 0.0));

		LineString lineString = new LineString(coordinates);

		Placemark path = new Placemark("Test", "", lineString);
		path.setStyleURL("TestStyle");

		simpleKML.createPlacemark(path);

		// create Polygone
		ArrayList<Location> outerBoundary = new ArrayList<>();
		outerBoundary.add(new Location(37.818844, -122.366278, 30.0));
		outerBoundary.add(new Location(37.819267, -122.365248, 30.0));
		outerBoundary.add(new Location(37.819861, -122.365640, 30.0));
		outerBoundary.add(new Location(37.819429, -122.366669, 30.0));
		outerBoundary.add(new Location(37.818844, -122.366278, 30.0));

		ArrayList<Location> innerBoundary = new ArrayList<>();
		innerBoundary.add(new Location(37.818977, -122.366212, 30.0));
		innerBoundary.add(new Location(37.819294, -122.365424, 30.0));
		innerBoundary.add(new Location(37.819731, -122.365704, 30.0));
		innerBoundary.add(new Location(37.819402, -122.366488, 30.0));
		innerBoundary.add(new Location(37.818977, -122.366212, 30.0));

		Polygon polygon = new Polygon();
		polygon.setOuterBoundry(new LinearRing(outerBoundary));
		polygon.addInnerBoundry(new LinearRing(innerBoundary));
		polygon.setExtruded(true);
		polygon.setAltitudeMode(AltitudeModes.RELATIVE_TO_GROUND);

		Placemark polygonPM = new Placemark("TestPoly", "3D Model", polygon);
		polygonPM.setStyleURL("TestStyle");

		simpleKML.createPlacemark(polygonPM);

		// create Tour

		Placemark placemark2 = new Placemark("New Placemark", "blabla",
				new Point(new Location(-43.61725568991338, 170.1426332867125, 0.0)));
		placemark2.setId("pin2");
		placemark2.setStyleURL("TestStyle");
		simpleKML.createPlacemark(placemark2);

		Tour tour = new Tour();
		tour.setId("TestID");
		tour.setName("FirstTour");

		Playlist playlist = new Playlist();

		SoundCue soundCue = new SoundCue();
		soundCue.setDelayedStart(2.0);
		soundCue.setSoundAddress("C:\\Users\\Jannik\\Google Drive\\Uni\\2. `Trimester\\Hon Project\\Sound.mp3");

		FlyTo flyTo1 = new FlyTo();
		flyTo1.setId("FirstFly");
		flyTo1.setDuration(5.0);
		Camera camera1 = new Camera();
		camera1.setCoordinates(new Location(-43.671, 170.157, 9700.0));
		camera1.setHeading(-6.0);
		camera1.setTilt(33.0);
		flyTo1.setAbstractView(camera1);

		Wait wait1 = new Wait();
		wait1.setId("WaitIDTest");
		wait1.setDuration(5.0);

		FlyTo flyTo2 = new FlyTo();
		flyTo2.setDuration(6.0);
		Camera camera2 = new Camera();
		TimeStamp t = new TimeStamp();
		t.setTimeStamp(new Time());
		camera2.setTimePrimitive(t);
		camera2.setId("CAM_ID");
		camera2.setCoordinates(new Location(-39.663, 174.063, 18275.0));
		camera2.setHeading(-5.0);
		camera2.setTilt(65.0);
		camera2.setAltitudeMode(AltitudeModes.ABSOLUT);
		flyTo2.setAbstractView(camera2);

		FlyTo flyTo3 = new FlyTo();
		flyTo3.setDuration(3.0);
		flyTo3.setFlyToMode(FlyTo.FLYTOMODE_SMOOTH);
		LookAt lookAt1 = new LookAt();
		lookAt1.setId("Lookatidtest");
		lookAt1.setCoordinates(new Location(-39.279, 174.007, 0.0));
		lookAt1.setHeading(112.817);
		lookAt1.setTilt(68.065);
		lookAt1.setRange(6811.884);
		lookAt1.setAltitudeMode(AltitudeModes.RELATIVE_TO_GROUND);
		flyTo3.setAbstractView(lookAt1);

		TourControl tourControl = new TourControl();
		tourControl.setId("hallo");

		FlyTo flyTo4 = new FlyTo();
		flyTo4.setDuration(3.0);
		flyTo4.setFlyToMode(FlyTo.FLYTOMODE_SMOOTH);
		LookAt lookAt2 = new LookAt();
		lookAt2.setCoordinates(new Location(-39.321, 174.064, 0.0));
		lookAt2.setHeading(-48.463);
		lookAt2.setTilt(67.946);
		lookAt2.setRange(4202.579);
		lookAt2.setAltitudeMode(AltitudeModes.RELATIVE_TO_GROUND);
		flyTo4.setAbstractView(lookAt2);

		AnimatedUpdate animatedUpdate = new AnimatedUpdate();
		animatedUpdate.setDuration(6.5);

		Change change = new Change();
		change.setKmlObjectName("IconStyle");
		change.setTargetID("istyle");
		change.setTag("scale");
		change.setNewText("10.0");

		Update update = new Update();
		update.setChange(change);
		animatedUpdate.setUpdate(update);

		FlyTo flyTo5 = new FlyTo();
		flyTo5.setDuration(4.1);
		Camera cam = new Camera();
		cam.setCoordinates(new Location(-43.671, 170.157, 9700.0));
		cam.setHeading(-6.333);
		cam.setTilt(33.5);
		cam.setRoll(0.0);
		flyTo5.setAbstractView(cam);

		Wait wait2 = new Wait();
		wait2.setDuration(8.0);

		playlist.addPrimitiveAction(soundCue);
		playlist.addPrimitiveAction(flyTo1);
		playlist.addPrimitiveAction(wait1);
		playlist.addPrimitiveAction(flyTo2);
		playlist.addPrimitiveAction(flyTo3);
		playlist.addPrimitiveAction(tourControl);
		playlist.addPrimitiveAction(flyTo4);
		playlist.addPrimitiveAction(animatedUpdate);
		playlist.addPrimitiveAction(flyTo5);
		playlist.addPrimitiveAction(wait2);

		tour.setPlaylist(playlist);

		simpleKML.createTour(tour);

		// save Document
		simpleKML.saveKMLDocument(
				"C:\\Users\\Jannik\\Google Drive\\Uni\\2. `Trimester\\Hon Project\\EasyKMLCreator.kml");
		

	}

}
