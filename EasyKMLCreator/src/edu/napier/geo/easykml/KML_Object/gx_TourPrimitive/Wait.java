package edu.napier.geo.easykml.KML_Object.gx_TourPrimitive;

import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class Wait extends TourPrimitive{
	
	private Double duration;
	
	
	public Double getDuration() {
		return duration;
	}
	public void setDuration(Double duration) {
		this.duration = duration;
	}
	
	public TreeNode<KML_element> getLinkedOutput (){
		
		TreeNode<KML_element> root = super.getLinkedOutput();

		root.data.setName("gx:Wait");
	
		if(this.getDuration() != null)root.addChild(new KML_element("gx:duration", Double.toString(this.getDuration()), true));
	
		return root; 
	}
}
