package Update;

import HelperClasses.LinkedOutput;
import HelperClasses.TreeNode;

public class Update {

	private String targetHref;
	private Change change;
	private Create create; 
	private Delete delete;

	public String getTargetHref() {
		return targetHref;
	}

	public void setTargetHref(String targetHref) {
		this.targetHref = targetHref;
	}

	public Change getChange() {
		return change;
	}

	public void setChange(Change change) {
		this.change = change;
	}

	public Create getCreate() {
		return create;
	}

	public void setCreate(Create create) {
		this.create = create;
	}

	public Delete getDelete() {
		return delete;
	}

	public void setDelete(Delete delete) {
		this.delete = delete;
	}
	
	public TreeNode<LinkedOutput> getLinkedOutput (){
		
		TreeNode<LinkedOutput> root = new TreeNode<LinkedOutput>(new LinkedOutput("Update", "", false));

		root.data.setName("Update");
	
		root.addChild(new LinkedOutput("targetHref", this.getTargetHref(), false));

		
		if(change != null)root.addTreeNode(change.getLinkedOutput());
		if(create != null)root.addTreeNode(create.getLinkedOutput());
		if(delete != null)root.addTreeNode(delete.getLinkedOutput());

		return root; 
	}
	

}
