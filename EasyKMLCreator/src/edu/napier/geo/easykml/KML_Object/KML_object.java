package edu.napier.geo.easykml.KML_Object;

import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public abstract class KML_object {

	private String id;

	/**
	 * @return id - get id attribute, which allows unique identification of a KML
	 *         element
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id - set id attribute, which allows unique identification of a KML
	 *         element
	 */
	public void setId(String id) {
		this.id = id;
	}

	public TreeNode<KML_element> getLinkedOutput() {

		TreeNode<KML_element> root = new TreeNode<KML_element>(
				new KML_element(this.getClass().getSimpleName(), "", false));
		if (this.getId() != null)
			root.addChild(new KML_element("id", this.getId(), false));

		return root;
	}

}
