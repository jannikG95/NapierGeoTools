package edu.napier.geo.queryOsmAPI.model;

/** 
 * @author Johannes Nguyen 
 * A class that holds the tags sorted TreeMap for the search
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class TagList {
	TreeMap <String, ArrayList<String>> listOfTags = new TreeMap <String, ArrayList<String>>();
	
	public void addTag(String tagToAdd, String node){
		if (listOfTags.containsKey(tagToAdd)&& listOfTags.get(tagToAdd).contains(node)== false){
			
			listOfTags.get(tagToAdd).add(node);
		}
		else{
			ArrayList<String> nodeList = new ArrayList<String> ();
			nodeList.add(node);
			listOfTags.put(tagToAdd, nodeList);
		}
	}

	
	public TreeMap<String, ArrayList<String>> getListOfTags() {
		return listOfTags;
	}
	
	public void printTagList(){
		for(Map.Entry<String,ArrayList<String>> entry : listOfTags.entrySet()) {
			  String key = entry.getKey();

			  System.out.println("Tag: "+key+ " ("+getListOfTags().get(key).size()+")");
			  
			}
	}
	
	public void printTagsToTxt (String outFilePath) throws IOException{
		//Example of outFilePath: "C:/Users/username/Desktop/tagsOut.txt"
		//A "tagsOut.txt" file is being created containing all tags
		FileWriter writer = new FileWriter(outFilePath); 
		for(Map.Entry<String,ArrayList<String>> entry : listOfTags.entrySet()) {
			  String key = entry.getKey();
			  writer.append("\n" + "Tag: "+key + " ("+getListOfTags().get(key).size()+")");
			  
			}
		
		writer.close();
	}
	
}
