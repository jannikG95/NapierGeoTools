package edu.napier.geo.easykml.KML_Object.gx_TourPrimitive;

import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class SoundCue extends TourPrimitive{


	private String soundAddress;
	private Double delayedStart;
	
	public String getSoundAddress() {
		return soundAddress;
	}
	public void setSoundAddress(String soundAddress) {
		this.soundAddress = soundAddress;
	}
	public Double getDelayedStart() {
		return delayedStart;
	}
	public void setDelayedStart(Double delayedStart) {
		this.delayedStart = delayedStart;
	}	
	
	public TreeNode<KML_element> getLinkedOutput (){
		
		TreeNode<KML_element> root = super.getLinkedOutput();

		root.data.setgExtenstion(true);

		
		if(this.getSoundAddress() != null)root.addChild(new KML_element("href", this.getSoundAddress(), false));
		if(this.getDelayedStart() != null)root.addChild(new KML_element("delayedStart", Double.toString(this.getDelayedStart()), true));

		return root; 
	}
}
