package edu.napier.geo.easykml.KML_Object.gx_TourPrimitive;

import edu.napier.geo.easykml.KML_Object.abstractView.AbstractView;
import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class FlyTo extends TourPrimitive{
	
	public final static String FLYTOMODE_SMOOTH = "smooth"; 
	public final static String FLYTOMODE_BOUNCE = "bounce"; 


	private Double duration;
	private String flyToMode;
	private AbstractView abstractView;
	
	

	public Double getDuration() {
		return duration;
	}
	public void setDuration(Double duration) {
		this.duration = duration;
	}
	public String getFlyToMode() {
		return flyToMode;
	}
	public void setFlyToMode(String flyToMode) {
		this.flyToMode = flyToMode;
	}
	public AbstractView getAbstractView() {
		return abstractView;
	}
	public void setAbstractView(AbstractView abstractView) {
		this.abstractView = abstractView;
	}
	
	public TreeNode<KML_element> getLinkedOutput (){
		
		TreeNode<KML_element> root = super.getLinkedOutput();

		root.data.setName("gx:FlyTo");
		
		
		if(this.getDuration() != null)root.addChild(new KML_element("gx:duration", Double.toString(this.getDuration()), true));
		if(this.getFlyToMode() != null)root.addChild(new KML_element("gx:flyToMode", this.getFlyToMode(), true));
		if(abstractView != null)root.addTreeNode(abstractView.getLinkedOutput());

		return root; 
	}
	
}
