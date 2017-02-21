package KML_Object.gx_TourPrimitive;

import HelperClasses.LinkedOutput;
import HelperClasses.TreeNode;
import Update.Update;

public class AnimatedUpdate extends TourPrimitive{
	
	private double duration;
	private double delayedStart;
	private Update update;
	
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public double getDelayedStart() {
		return delayedStart;
	}
	public void setDelayedStart(double delayedStart) {
		this.delayedStart = delayedStart;
	}
	public Update getUpdate() {
		return update;
	}
	public void setUpdate(Update update) {
		this.update = update;
	}
	
	
	public TreeNode<LinkedOutput> getLinkedOutput (){
		
		TreeNode<LinkedOutput> root = super.getLinkedOutput();

		root.data.setName("gx:AnimatedUpdate");
		
		
		root.addChild(new LinkedOutput("gx:duration", Double.toString(this.getDuration()), true));
		if(update != null)root.addTreeNode(update.getLinkedOutput());

		root.addChild(new LinkedOutput("gx:delayedStart", Double.toString(this.getDelayedStart()), true));


		return root; 
	}
	
}
