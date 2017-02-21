package KML_Object;

import java.util.ArrayList;

import HelperClasses.LinkedOutput;
import HelperClasses.TreeNode;
import KML_Object.gx_TourPrimitive.TourPrimitive;

public class Playlist extends KML_object {

	private ArrayList<TourPrimitive> actionList = new ArrayList<>();

	public ArrayList<TourPrimitive> getActionList() {
		return actionList;
	}

	public void addPrimitiveAction(TourPrimitive primitiveAction) {
		actionList.add(primitiveAction);
	}

	public TreeNode<LinkedOutput> getLinkedOutput() {

		TreeNode<LinkedOutput> root = super.getLinkedOutput();

		root.data.setName("gx:Playlist");
		
		if (actionList.size() > 0){
			for (TourPrimitive tourPrimitive : actionList) {
				root.addTreeNode(tourPrimitive.getLinkedOutput());
			}
		}

		return root;
	}

}
