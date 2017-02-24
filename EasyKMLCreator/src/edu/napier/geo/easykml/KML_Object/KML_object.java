package edu.napier.geo.easykml.KML_Object;

import edu.napier.geo.easykml.helperClasses.LinkedOutput;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public abstract class KML_object {

	private String id = "";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TreeNode<LinkedOutput> getLinkedOutput() {
		
		TreeNode<LinkedOutput> root = new TreeNode<LinkedOutput>(new LinkedOutput(this.getClass().getSimpleName(), "", false));
		root.addChild(new LinkedOutput("id", this.getId(), false));
		
		return root;
	}


	
	
	
}