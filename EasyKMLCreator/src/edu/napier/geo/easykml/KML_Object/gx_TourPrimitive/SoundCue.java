package edu.napier.geo.easykml.KML_Object.gx_TourPrimitive;

import edu.napier.geo.easykml.helperClasses.LinkedOutput;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class SoundCue extends TourPrimitive{


	private String soundAddress;
	private double delayedStart;
	
	public String getSoundAddress() {
		return soundAddress;
	}
	public void setSoundAddress(String soundAddress) {
		this.soundAddress = soundAddress;
	}
	public double getDelayedStart() {
		return delayedStart;
	}
	public void setDelayedStart(double delayedStart) {
		this.delayedStart = delayedStart;
	}	
	
	public TreeNode<LinkedOutput> getLinkedOutput (){
		
		TreeNode<LinkedOutput> root = super.getLinkedOutput();

		root.data.setName("gx:SoundCue");
		
		root.addChild(new LinkedOutput("href", this.getSoundAddress(), false));
		root.addChild(new LinkedOutput("gx:delayedStart", Double.toString(this.getDelayedStart()), true));

		return root; 
	}
}
