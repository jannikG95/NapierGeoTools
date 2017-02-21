package Update;

import HelperClasses.LinkedOutput;
import HelperClasses.TreeNode;

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
	
	public TreeNode<LinkedOutput> getLinkedOutput (){
		
		TreeNode<LinkedOutput> root = new TreeNode<LinkedOutput>(new LinkedOutput("Update", "", false));

		root.data.setName("Change");
	
		root.addChild(new LinkedOutput(kmlObjectName, "", false)).addChild(new LinkedOutput(tag, newText, false));
		root.addChild(new LinkedOutput("targetID", this.getTargetID(), false));

		

		return root; 
	}
	
		
}
