package KML_Object.gx_TourPrimitive;

import HelperClasses.LinkedOutput;
import HelperClasses.TreeNode;

public class Wait extends TourPrimitive{
	
	private double duration;
	
	
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	public TreeNode<LinkedOutput> getLinkedOutput (){
		
		TreeNode<LinkedOutput> root = super.getLinkedOutput();

		root.data.setName("gx:Wait");
	
		root.addChild(new LinkedOutput("gx:duration", Double.toString(this.getDuration()), true));
	
		return root; 
	}
}
