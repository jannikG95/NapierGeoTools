package edu.napier.geo.easykml.KML_Object.timePrimitive;

import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class TimeSpan extends TimePrimitive{

	private Time beginStamp;
	private Time endStamp;
	
	
	public Time getBeginStamp() {
		return beginStamp;
	}
	public void setBeginStamp(Time beginStamp) {
		this.beginStamp = beginStamp;
	}
	public Time getEndStamp() {
		return endStamp;
	}
	public void setEndStamp(Time endStamp) {
		this.endStamp = endStamp;
	}
	
	public TreeNode<KML_element> getLinkedOutput (){
		
		TreeNode<KML_element> root = super.getLinkedOutput();

		if (this.getBeginStamp() != null && this.getEndStamp() != null){
			root.addChild(new KML_element("begin", this.getBeginStamp().getFormattedString(), false));
			root.addChild(new KML_element("end", this.getEndStamp().getFormattedString(), false));
		}

		return root; 
	}

}
