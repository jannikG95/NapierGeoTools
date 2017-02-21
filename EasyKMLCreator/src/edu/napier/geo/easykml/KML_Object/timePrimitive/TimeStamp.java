package edu.napier.geo.easykml.KML_Object.timePrimitive;

import edu.napier.geo.easykml.helperClasses.LinkedOutput;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class TimeStamp extends TimePrimitive{

	private TimePrimitive timeStamp;

	
	public TimePrimitive getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(TimePrimitive timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public TreeNode<LinkedOutput> getLinkedOutput (){
		
		TreeNode<LinkedOutput> root = super.getLinkedOutput();

		root.addChild(new LinkedOutput("when", this.getTimeStamp().getFormattedString(), false));

		return root; 
	}
	
}
