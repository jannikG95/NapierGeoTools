package KML_Object.feature;

import HelperClasses.LinkedOutput;
import HelperClasses.TreeNode;
import KML_Object.Playlist;

public class Tour extends Feature {
	
	private Playlist playlist = null;
	
	public Playlist getPlaylist() {
		return playlist;
	}
	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}
	
	public TreeNode<LinkedOutput> getLinkedOutput (){
		
		TreeNode<LinkedOutput> root = super.getLinkedOutput();

		root.data.setName("gx:Tour");
		
		if(playlist != null)root.addTreeNode(playlist.getLinkedOutput());

		return root; 
	}
	
}
