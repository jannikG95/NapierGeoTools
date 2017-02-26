package edu.napier.geo.easykml.KML_Object.timePrimitive;

import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class TimeStamp extends TimePrimitive{

	private TimePrimitive timeStamp;

	
	public TimePrimitive getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(TimePrimitive timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public TreeNode<KML_element> getLinkedOutput (){
		
		TreeNode<KML_element> root = super.getLinkedOutput();

		root.addChild(new KML_element("when", this.getTimeStamp().getFormattedString(), false));

		return root; 
	}
	
}
