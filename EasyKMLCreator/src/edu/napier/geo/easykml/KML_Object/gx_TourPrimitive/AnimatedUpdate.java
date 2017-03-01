package edu.napier.geo.easykml.KML_Object.gx_TourPrimitive;

import edu.napier.geo.easykml.Update.Update;
import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class AnimatedUpdate extends TourPrimitive{
	
	private Double duration;
	private Double delayedStart;
	private Update update;
	
	public Double getDuration() {
		return duration;
	}
	public void setDuration(Double duration) {
		this.duration = duration;
	}
	public Double getDelayedStart() {
		return delayedStart;
	}
	public void setDelayedStart(Double delayedStart) {
		this.delayedStart = delayedStart;
	}
	public Update getUpdate() {
		return update;
	}
	public void setUpdate(Update update) {
		this.update = update;
	}
	
	
	public TreeNode<KML_element> getLinkedOutput (){
		
		TreeNode<KML_element> root = super.getLinkedOutput();

		root.data.setgExtenstion(true);

		if(this.getDuration() != null)root.addChild(new KML_element("duration", Double.toString(this.getDuration()), true));
		if(this.getUpdate() != null)root.addTreeNode(update.getLinkedOutput());

		if(this.getDelayedStart() != null)root.addChild(new KML_element("delayedStart", Double.toString(this.getDelayedStart()), true));


		return root; 
	}
	
}
