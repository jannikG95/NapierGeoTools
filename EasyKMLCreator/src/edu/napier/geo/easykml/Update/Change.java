package edu.napier.geo.easykml.Update;

import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class Change {

	private String targetID;
	private String kmlObjectName;
	private String tag;
	private String newText;
	
	
	public String getTargetID() {
		return targetID;
	}
	public void setTargetID(String targetID) {
		this.targetID = targetID;
	}
	public String getKmlObjectName() {
		return kmlObjectName;
	}
	public void setKmlObjectName(String kmlObjectName) {
		this.kmlObjectName = kmlObjectName;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getNewText() {
		return newText;
	}
	public void setNewText(String newText) {
		this.newText = newText;
	}
	
	public TreeNode<KML_element> getLinkedOutput (){
		
		TreeNode<KML_element> root = new TreeNode<KML_element>(new KML_element("Update", "", false));

		root.data.setName("Change");
	
		root.addChild(new KML_element(kmlObjectName, "", false)).addChild(new KML_element(tag, newText, false));
		root.addChild(new KML_element("targetID", this.getTargetID(), false));

		

		return root; 
	}
	
		
}
