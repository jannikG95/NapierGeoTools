package edu.napier.geo.diary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import edu.napier.geo.common.Location;


public class API_Demo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DiaryFacade df = new DiaryFacade();
		df.deleteAllEvents();
		scanner.nextLine();
		CalendarEntry ce = null;
		ArrayList<CalendarEntry> list = new ArrayList<>();
		String description1 = "Description 1";
		String description2 = "Description 2";
		String description3 = "Description 3";
		String summary1 = "Summary 1";
		String summary2 = "Summary 2";
		String summary3 = "Summary 3";
		Location location1 = df.createTextOnlyLocation("Location 1");
		Location location2 = df.createTextOnlyLocation("Location 2");
		Location location3 = df.createTextOnlyLocation("Location 3");
		Ressource ressource1 = df.createOrAccessRessource("Ressource 1");
		Ressource ressource2 = df.createOrAccessRessource("Ressource 2");
		Ressource ressource3 = df.createOrAccessRessource("Ressource 3");
		Ressource ressource4 = df.createOrAccessRessource("Ressource 4");
		
		ArrayList<Ressource> ressource_1 = new ArrayList<Ressource>();
		ressource_1.add(ressource1);
		ArrayList<Ressource> ressources3and4 = new ArrayList<Ressource>();
		ressources3and4.add(ressource3);
		ressources3and4.add(ressource4);
		ArrayList<Ressource> ressources1and2 = new ArrayList<Ressource>();
		ressources1and2.add(ressource1);
		ressources1and2.add(ressource2);
		ArrayList<Ressource> ressources2and3 = new ArrayList<Ressource>();
		ressources2and3.add(ressource2);
		ressources2and3.add(ressource3);
		
		scanner.nextLine();
		System.out.println("Test to check that no different Ressources with the same name are possible");
		scanner.nextLine();
		Ressource ressource5 = df.createOrAccessRessource("Ressource 1");
		System.out.println(ressource1==ressource5);
		scanner.nextLine();
		System.out.println("Create a single event");
		scanner.nextLine();
		try {
			ce = df.createCalendarEntry(2017, 3, 31, 15, 30, 2017, 3, 31, 16, 30, description1, summary1, location1, ressources1and2);
				} catch (StartEndException e) {
			e.printStackTrace();
		}
		System.out.println(ce);
		scanner.nextLine();
		System.out.println("Create 3 iterations of a weekly event, then print ALL events");
		scanner.nextLine();
		try {
			df.createWeeklyEvent(3, LocalDateTime.of(2017, 4, 20, 17, 30), LocalDateTime.of(2017, 4, 20, 19, 00), description2, summary2, location2, ressources2and3);
		} catch (StartEndException e) {
			e.printStackTrace();
		}
		df.printAllCalendarEntries();
		
		System.out.println("Create whole day event");
		scanner.nextLine();
		
		try {
			ce = df.createWholeDayEvent(LocalDate.of(2017, 1, 1), description3, summary3, location3, ressource_1);
			System.out.println(ce);
		} catch (StartEndException e) {
			e.printStackTrace();
		}
		scanner.nextLine();
		System.out.println("Get all events where Ressource 1 is involved");
		scanner.nextLine();
		list = df.getEventsAllocatedToRessource(ressource1);
		for (CalendarEntry c : list) {
			System.out.println(c);
		}
		scanner.nextLine();
		System.out.println("Add Ressources 3 and 4 to the whole day event ");
		scanner.nextLine();
		df.addRessourcesToEvent(ce, ressources3and4);
		System.out.println(ce);
		scanner.nextLine();
		System.out.println("Remove Ressource 1 from the event");
		ArrayList<Ressource> toRemove = new ArrayList<Ressource>();
		toRemove.add(ressource1);
		scanner.nextLine();
		System.out.println(ressource_1);
		df.removeRessourcesFromEvent(ce, toRemove);
		System.out.println(ce);
		scanner.nextLine();
		System.out.println("Get all events where Ressource 1 is involved");
		scanner.nextLine();
		list = df.getEventsAllocatedToRessource(ressource1);
		for (CalendarEntry c : list) {
			ce=c; 	//only to reference the last event found, for demonstration purposes
			System.out.println(c);
		}
		scanner.nextLine();
		System.out.println("Deleting the event, then getting all events where Ressource 1 is involved. (Should be none, in this case)");
		scanner.nextLine();
		df.deleteEvent(ce);
		list = df.getEventsAllocatedToRessource(ressource1);
		for (CalendarEntry c : list) {
			System.out.println(c);
		}
		scanner.nextLine();
		System.out.println("Events COMPLETELY between 20.April 2017 18:00 and 30.April 2017 18:00");
		scanner.nextLine();
		list = df.getEventsCompletelyWithinTimespan(LocalDateTime.of(2017,4,20,18,00), LocalDateTime.of(2017,4,30,18,00));
		for (CalendarEntry entry : list) {
			System.out.println(entry.toString());
		}
		scanner.nextLine();
		System.out.println("Events PARTIALLY between 20.April 2017 18:00 and 30.April 2017 18:00");
		scanner.nextLine();
		list = df.getEventsPartiallyWithinTimespan(LocalDateTime.of(2017,4,20,18,00), LocalDateTime.of(2017,4,30,18,00));
		for (CalendarEntry entry : list) {
			System.out.println(entry.toString());
		}
		scanner.nextLine();
		System.out.println("Change the second event to 21.April");
		scanner.nextLine();
		list.get(1).setStart(LocalDateTime.of(2017,4,21,17,30));
		list.get(1).setEnd(LocalDateTime.of(2017,4,21,19,00));
		System.out.println(list.get(1).toString());
		System.out.println("Free time between the last two events");
		scanner.nextLine();
		System.out.println(df.getFreeTimeBetween(list.get(0), list.get(1)));
		scanner.nextLine();
		System.out.println("Change the second event to 20.April - so there are two events overlapping");
		scanner.nextLine();
		list.get(1).setStart(LocalDateTime.of(2017,4,20,18,30));
		list.get(1).setEnd(LocalDateTime.of(2017,4,20,20,00));
		System.out.println(list.get(1).toString());
		scanner.nextLine();
		System.out.println("printing all events from res 2");
		scanner.nextLine();
		list = df.getEventsAllocatedToRessource(ressource2);
		for (CalendarEntry c : list) {
			System.out.println(c);
		}
		scanner.nextLine();
		System.out.println("Checking for conflicting events for Ressource 2");
		scanner.nextLine();
		list = df.checkRessourceForConflictingEvents(ressource2);
		for (CalendarEntry entry : list) {
			System.out.println(entry.toString());
		}
		scanner.nextLine();
		System.out.println("Checking if Ressource 2 is availiable between 20.April 2017 19:00 and 21:00");
		scanner.nextLine();
		System.out.println(df.ressourceIsAvailiableBetween(ressource2, LocalDateTime.of(2017,4,20,19,00), LocalDateTime.of(2017,4,20,21,00)));
		scanner.nextLine();
		System.out.println("Checking if Ressource 2 is availiable between 20.April 2017 20:00 and 21:00");
		scanner.nextLine();
		System.out.println(df.ressourceIsAvailiableBetween(ressource2, LocalDateTime.of(2017,4,20,20,00), LocalDateTime.of(2017,4,20,21,00)));
		scanner.nextLine();
		System.out.println("Printing all events, then writing them to an iCal file");
		scanner.nextLine();
		list=df.getAllEntries();
		for (CalendarEntry entry : list) {
			System.out.println(entry.toString());
		}
		df.exportToICAL(list, "API_Demo_ical_Export");
		scanner.nextLine();
		System.out.println("Clearing the saved events, printing all to show that there are none left");
		scanner.nextLine();
		df.deleteAllEvents();
		for (CalendarEntry entry : list) {
			System.out.println(entry.toString());
		}
		scanner.nextLine();
		System.out.println("Importing the ical file, printing all");
		scanner.nextLine();
		df.importEventsFromIcalFile("API_Demo_ical_Export.ics");
		for (CalendarEntry entry : list) {
			System.out.println(entry.toString());
		}
	}
}
