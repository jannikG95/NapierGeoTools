package edu.napier.geo.easykml.KML_Object.feature;

import edu.napier.geo.easykml.KML_Object.Playlist;
import edu.napier.geo.easykml.helperClasses.KML_element;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public class Tour extends Feature {
	
	private Playlist playlist = null;
	
	public Playlist getPlaylist() {
		return playlist;
	}
	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}
	
	public TreeNode<KML_element> getLinkedOutput (){
		
		TreeNode<KML_element> root = super.getLinkedOutput();

		root.data.setName("gx:Tour");
		
		if(playlist != null)root.addTreeNode(playlist.getLinkedOutput());

		return root; 
	}
	
}
