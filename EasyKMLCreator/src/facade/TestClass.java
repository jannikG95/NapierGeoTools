package facade;

import java.awt.Color;
import java.util.ArrayList;

import HelperClasses.AltitudeModes;
import HelperClasses.LinkedOutput;
import HelperClasses.TreeNode;
import KML_Object.Playlist;
import KML_Object.abstractView.Camera;
import KML_Object.abstractView.LookAt;
import KML_Object.feature.Placemark;
import KML_Object.feature.Tour;
import KML_Object.geometry.LineString;
import KML_Object.geometry.LinearRing;
import KML_Object.geometry.Point;
import KML_Object.geometry.Polygon;
import KML_Object.gx_TourPrimitive.AnimatedUpdate;
import KML_Object.gx_TourPrimitive.FlyTo;
import KML_Object.gx_TourPrimitive.SoundCue;
import KML_Object.gx_TourPrimitive.TourControl;
import KML_Object.gx_TourPrimitive.Wait;
import KML_Object.stylesector.Style;
import KML_Object.subStyle.colorStyle.IconStyle;
import KML_Object.subStyle.colorStyle.LabelStyle;
import KML_Object.subStyle.colorStyle.LineStyle;
import KML_Object.subStyle.colorStyle.PolyStyle;
import SharedClasses.Coordinates;
import Update.Change;
import Update.Update;

public class TestClass {

	public static void main(String[] args) {
		KML_Facade simpleKML = new KML_Facade();

		// create Document
		simpleKML.createKMLDocument();

		// create Styles
		Style style = new Style();
		style.setId("TestStyle");
		IconStyle iconStyle = new IconStyle();
		iconStyle.setId("istyle");
		iconStyle.setScale(1);
		iconStyle.setIconHttpAddress("http://maps.google.com/mapfiles/kml/pal3/icon21.png");
		style.setIconStyle(iconStyle);

		LineStyle lineStyle = new LineStyle();
		lineStyle.setColor(Color.RED);
		lineStyle.setWidth(5);
		lineStyle.setTransparency(50);
		style.setLineStyle(lineStyle);

		PolyStyle polyStyle = new PolyStyle();
		polyStyle.setId("Pol");
		polyStyle.setColor(Color.GREEN);
		polyStyle.setTransparency(80);
		polyStyle.setFillPolygon(false);
		style.setPolyStyle(polyStyle);

		LabelStyle labelStyle = new LabelStyle();
		labelStyle.setScale(10);
		labelStyle.setTransparency(50);
		labelStyle.setColor(Color.BLUE);
		style.setLabelStyle(labelStyle);

		simpleKML.createStyle(style);

		// create placemark
		Camera cameraPM = new Camera();
		cameraPM.setCoordinates(new Coordinates(170.157, -43.671, 9700.0));
		cameraPM.setHeading(-6.333);
		cameraPM.setTilt(33.5);
		cameraPM.setRoll(0);
		Placemark pm = new Placemark("Test", "test123",
				new Point(new Coordinates(-122.0822035425683, 37.42228990140251, 0.0)));
		pm.setStyleURL("TestStyle");
		pm.setAbstractView(cameraPM);
		pm.setId("alsfsasfa");

		simpleKML.createPlacemark(pm);

		// create path
		ArrayList<Coordinates> coordinates = new ArrayList<>();
		coordinates.add(new Coordinates(-122.0822035425683, 37.42228990140251, 0.0));
		coordinates.add(new Coordinates(-125.0822035425683, 37.42228990140251, 0.0));
		coordinates.add(new Coordinates(-126.0822035425683, 50.42228990140251, 0.0));

		LineString lineString = new LineString(coordinates);

		Placemark path = new Placemark("Test", "", lineString);
		path.setStyleURL("TestStyle");

		simpleKML.createPlacemark(path);

		// create Polygone
		ArrayList<Coordinates> outerBoundary = new ArrayList<>();
		outerBoundary.add(new Coordinates(-122.366278, 37.818844, 30.0));
		outerBoundary.add(new Coordinates(-122.365248, 37.819267, 30.0));
		outerBoundary.add(new Coordinates(-122.365640, 37.819861, 30.0));
		outerBoundary.add(new Coordinates(-122.366669, 37.819429, 30.0));
		outerBoundary.add(new Coordinates(-122.366278, 37.818844, 30.0));

		ArrayList<Coordinates> innerBoundary = new ArrayList<>();
		innerBoundary.add(new Coordinates(-122.366212, 37.818977, 30.0));
		innerBoundary.add(new Coordinates(-122.365424, 37.819294, 30.0));
		innerBoundary.add(new Coordinates(-122.365704, 37.819731, 30.0));
		innerBoundary.add(new Coordinates(-122.366488, 37.819402, 30.0));
		innerBoundary.add(new Coordinates(-122.366212, 37.818977, 30.0));

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
				new Point(new Coordinates(170.1426332867125, -43.61725568991338, 0.0)));
		placemark2.setId("pin2");
		placemark2.setStyleURL("TestStyle");
		simpleKML.createPlacemark(placemark2);

		Tour tour = new Tour();
		tour.setId("TestID");
		tour.setName("FirstTour");

		Playlist playlist = new Playlist();

		SoundCue soundCue = new SoundCue();
		soundCue.setDelayedStart(2);
		soundCue.setSoundAddress("C:\\Users\\Jannik\\Google Drive\\Uni\\2. `Trimester\\Hon Project\\Sound.mp3");

		FlyTo flyTo1 = new FlyTo();
		flyTo1.setDuration(5);
		Camera camera1 = new Camera();
		camera1.setCoordinates(new Coordinates(170.157, -43.671, 9700.0));
		camera1.setHeading(-6);
		camera1.setTilt(33);
		flyTo1.setAbstractView(camera1);

		Wait wait1 = new Wait();
		wait1.setDuration(5);

		FlyTo flyTo2 = new FlyTo();
		flyTo2.setDuration(6);
		Camera camera2 = new Camera();
		camera2.setCoordinates(new Coordinates(174.063, -39.663, 18275.0));
		camera2.setHeading(-5);
		camera2.setTilt(65);
		camera2.setAltitudeMode(AltitudeModes.ABSOLUT);
		flyTo2.setAbstractView(camera2);

		FlyTo flyTo3 = new FlyTo();
		flyTo3.setDuration(3);
		flyTo3.setFlyToMode(FlyTo.FLYTOMODE_SMOOTH);
		LookAt lookAt1 = new LookAt();
		lookAt1.setCoordinates(new Coordinates(174.007, -39.279, 0.0));
		lookAt1.setHeading(112.817);
		lookAt1.setTilt(68.065);
		lookAt1.setRange(6811.884);
		lookAt1.setAltitudeMode(AltitudeModes.RELATIVE_TO_GROUND);
		flyTo3.setAbstractView(lookAt1);

		TourControl tourControl = new TourControl();
		tourControl.setId("hallo");

		FlyTo flyTo4 = new FlyTo();
		flyTo4.setDuration(3);
		flyTo4.setFlyToMode(FlyTo.FLYTOMODE_SMOOTH);
		LookAt lookAt2 = new LookAt();
		lookAt2.setCoordinates(new Coordinates(174.064, -39.321, 0.0));
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
		cam.setCoordinates(new Coordinates(170.157, -43.671, 9700.0));
		cam.setHeading(-6.333);
		cam.setTilt(33.5);
		cam.setRoll(0);
		flyTo5.setAbstractView(cam);

		Wait wait2 = new Wait();
		wait2.setDuration(8);

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
