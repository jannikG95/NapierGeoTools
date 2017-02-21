package edu.napier.geo.easykml.KML_Object;

import java.util.ArrayList;

import edu.napier.geo.easykml.KML_Object.gx_TourPrimitive.TourPrimitive;
import edu.napier.geo.easykml.helperClasses.LinkedOutput;
import edu.napier.geo.easykml.helperClasses.TreeNode;

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
