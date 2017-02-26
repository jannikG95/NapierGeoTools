package edu.napier.geo.easykml.KML_Object.timePrimitive;

import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class TimeSpan extends TimePrimitive{

	private TimePrimitive beginStamp;
	private TimePrimitive endStamp;
	
	
	public TimePrimitive getBeginStamp() {
		return beginStamp;
	}
	public void setBeginStamp(TimePrimitive beginStamp) {
		this.beginStamp = beginStamp;
	}
	public TimePrimitive getEndStamp() {
		return endStamp;
	}
	public void setEndStamp(TimePrimitive endStamp) {
		this.endStamp = endStamp;
	}
	
	public TreeNode<KML_element> getLinkedOutput (){
		
		TreeNode<KML_element> root = super.getLinkedOutput();

		root.addChild(new KML_element("begin", this.getBeginStamp().getFormattedString(), false));
		root.addChild(new KML_element("end", this.getEndStamp().getFormattedString(), false));

		return root; 
	}

}
