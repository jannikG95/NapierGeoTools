package edu.napier.geo.queryOsmAPI.osmFacade;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import org.xml.sax.SAXException;

import edu.napier.geo.common.Location;
import edu.napier.geo.queryOsmAPI.model.BoundingBox;
import edu.napier.geo.queryOsmAPI.model.OSMParser;
import edu.napier.geo.queryOsmAPI.model.Query;
/** 
 * @author Johannes Nguyen 
 * A class that summarizes the most important functions of this API
 */

public class QueryOsmFacade {
	OSMParser parser = new OSMParser();


	//Method that takes an OSM file and creates all the nodes and tags as Java Objects
//The parser object then contains a map with all the nodes and a treemap with all the tags
//The treemap is sorted after tags and references the corresponding node objects
	public void parseOSMFile (String filePath){
		
		File osmFile = new File(filePath);
		
		try {
			parser.parse(osmFile);								
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
// Method that returns a list of locations within the default range of 5km
// Before using this method it is necessary to have created a "parser" object and parse the OSM file
	public ArrayList <Location> findLocations( String tagForSearch, Location currentLocation, OSMParser parser){
		Query q = new Query (tagForSearch, currentLocation, parser);
		ArrayList <Location> locationList = q.conductQuery();
		
		return locationList;
	}
	
//Finding locations defining own search radius in km 
	public ArrayList <Location> findLocationsWithRadius(Double radius, String tagForSearch, Location currentLocation, OSMParser parser){
		Query q = new Query (radius, tagForSearch, currentLocation, parser);
		ArrayList <Location> locationList = q.conductQuery();
		
		return locationList;
	}

//Finding locations within BoundingBox
	//Finding locations defining own search radius in km 
		public ArrayList <Location> findLocationsWithinBoundingBox (BoundingBox box, String tagForSearch, OSMParser parser){
			Query q = new Query (box, tagForSearch, parser);
			ArrayList <Location> locationList = q.conductQueryWithBoundingBox(box);
			
			return locationList;
		}
	
//Finding locations using RegEx with default radius
	public ArrayList <Location> findLocationsWithRegEx( String regex, Location currentLocation, OSMParser parser ){
		
		//Collecting all matching tags in ArrayList
		ArrayList <String> matchingRegex = parser.getMatchingRegExStrings(parser.getTagList().getListOfTags(), regex);
		
		//Creating a super ArrayList to summarize all the found locations
		ArrayList <Location> locationList = new ArrayList <Location>();
		
		//For each tag that matches the RegEx conduct a query which each returns a list of Locations
		//then iterate through the returned list and if a location is not already included in the 
		//super ArrayList, add the following location
		for (String tagForSearch : matchingRegex){
			Query q = new Query (tagForSearch, currentLocation, parser);
			ArrayList <Location> foundLocations = q.conductQuery();
			for(Location l: foundLocations){
				if(locationList.contains(l) == false)
				locationList.add(l);
			}
		}		
		return locationList;
	}
	
//Finding locations using RegEx with own search radius
		public ArrayList <Location> findLocationsWithRegEx(Double radius, String regex, Location currentLocation, OSMParser parser ){
			
			//Collecting all matching tags in ArrayList
			ArrayList <String> matchingRegex = parser.getMatchingRegExStrings(parser.getTagList().getListOfTags(), regex);
			
			//Creating a super ArrayList to summarize all the found locations
			ArrayList <Location> locationList = new ArrayList <Location>();
			
			//For each tag that matches the RegEx conduct a query which each returns a list of Locations
			//then iterate through the returned list and if a location is not already included in the 
			//super ArrayList, add the following location
			for (String tagForSearch : matchingRegex){
				Query q = new Query (radius, tagForSearch, currentLocation, parser);
				ArrayList <Location> foundLocations = q.conductQuery();
				for(Location l: foundLocations){
					if(locationList.contains(l) == false)
					locationList.add(l);
				}
			}		
			return locationList;
		}
	
		
		//Finding locations using RegEx within BoundingBox
		public ArrayList <Location> findLocationsWithRegEx( String regex, BoundingBox box, OSMParser parser ){
			
			//Collecting all matching tags in ArrayList
			ArrayList <String> matchingRegex = parser.getMatchingRegExStrings(parser.getTagList().getListOfTags(), regex);
			
			//Creating a super ArrayList to summarize all the found locations
			ArrayList <Location> locationList = new ArrayList <Location>();
			
			//For each tag that matches the RegEx conduct a query which each returns a list of Locations
			//then iterate through the returned list and if a location is not already included in the 
			//super ArrayList, add the following location
			for (String tagForSearch : matchingRegex){
				Query q = new Query (box, tagForSearch, parser);
				ArrayList <Location> foundLocations = q.conductQueryWithBoundingBox(box);
				for(Location l: foundLocations){
					if(locationList.contains(l) == false)
					locationList.add(l);
				}
			}		
			return locationList;
		}	
		
		public void printTagsInConsole(OSMParser parser){
			parser.getTagList().printTagList();
		}
		
		public void printTagsToTxtFile (OSMParser parser, String newFilePath){
			try {
				parser.getTagList().printTagsToTxt(newFilePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
		
		public OSMParser getParser() {
			return parser;
		}
	
}
