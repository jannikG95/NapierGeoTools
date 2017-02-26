package edu.napier.geo.easykml.KML_Object.gx_TourPrimitive;

import edu.napier.geo.easykml.helperClasses.KML_element;
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
	
	public TreeNode<KML_element> getLinkedOutput (){
		
		TreeNode<KML_element> root = super.getLinkedOutput();

		root.data.setName("gx:SoundCue");
		
		root.addChild(new KML_element("href", this.getSoundAddress(), false));
		root.addChild(new KML_element("gx:delayedStart", Double.toString(this.getDelayedStart()), true));

		return root; 
	}
}
