package edu.napier.geo.easykml.KML_Object.timePrimitive;

import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class TimeStamp extends TimePrimitive{

	private Time timeStamp;

	
	public Time getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Time timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public TreeNode<KML_element> getLinkedOutput (){
		
		TreeNode<KML_element> root = super.getLinkedOutput();

		if(this.getTimeStamp() != null)root.addChild(new KML_element("when", this.getTimeStamp().getFormattedString(), false));

		return root; 
	}
	
}
