package edu.napier.geo.easykml.KML_Object.abstractView;

import edu.napier.geo.easykml.KML_Object.KML_object;
import edu.napier.geo.easykml.KML_Object.timePrimitive.TimePrimitive;
import edu.napier.geo.easykml.helperClasses.LinkedOutput;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public abstract class AbstractView extends KML_object{
	
	public static final String VOPTION_STREETVIEW = "streetview";
	public static final String VOPTION_HISTORUCALIMAGERY = "historicalimagery";
	public static final String VOPTION_SUNLIGHT = "sunlight";
	public static final String VOPTION_GROUNDNAVIGATION = "groundnavigation";

	private TimePrimitive timePrimitive = null; // Timespan or Timestamp
	private String viewerOption;
	
	public TimePrimitive getTimePrimitive() {
		return timePrimitive;
	}
	public void setTimePrimitive(TimePrimitive timePrimitive) {
		this.timePrimitive = timePrimitive;
	}
	public String getViewerOption() {
		return viewerOption;
	}
	public void setViewerOption(String viewerOption) {
		this.viewerOption = viewerOption;
	}
	
	public TreeNode<LinkedOutput> getLinkedOutput (){
		
		TreeNode<LinkedOutput> root = super.getLinkedOutput();

		if(getTimePrimitive() != null)root.addTreeNode(getTimePrimitive().getLinkedOutput());
		root.addChild(new LinkedOutput("gx:ViewerOptions", this.viewerOption, true));

		return root; 
	}

}
