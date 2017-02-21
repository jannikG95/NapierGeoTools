package KML_Object.timePrimitive;

import HelperClasses.LinkedOutput;
import HelperClasses.TreeNode;

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
	
	public TreeNode<LinkedOutput> getLinkedOutput (){
		
		TreeNode<LinkedOutput> root = super.getLinkedOutput();

		root.addChild(new LinkedOutput("begin", this.getBeginStamp().getFormattedString(), false));
		root.addChild(new LinkedOutput("end", this.getEndStamp().getFormattedString(), false));

		return root; 
	}

}
