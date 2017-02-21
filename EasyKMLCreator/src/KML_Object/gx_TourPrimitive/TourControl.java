package KML_Object.gx_TourPrimitive;

import HelperClasses.LinkedOutput;
import HelperClasses.TreeNode;

public class TourControl extends TourPrimitive{
	
	private final String PLAYMODE = "pause";

	public String getPLAYMODE() {
		return PLAYMODE;
	}

	public TreeNode<LinkedOutput> getLinkedOutput (){
		
		TreeNode<LinkedOutput> root = super.getLinkedOutput();

		root.data.setName("gx:TourControl");
	
		root.addChild(new LinkedOutput("gx:playMode", this.getPLAYMODE(), true));
	
		return root; 
	}
	
}
