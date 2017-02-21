package edu.napier.geo.easykml.KML_Object.feature;

import edu.napier.geo.easykml.KML_Object.KML_object;
import edu.napier.geo.easykml.KML_Object.abstractView.AbstractView;
import edu.napier.geo.easykml.KML_Object.stylesector.Style;
import edu.napier.geo.easykml.KML_Object.timePrimitive.TimePrimitive;
import edu.napier.geo.easykml.helperClasses.LinkedOutput;
import edu.napier.geo.easykml.helperClasses.TreeNode;

public abstract class Feature extends KML_object {
	
	private String name = "";
	private boolean visibility = true;
	private boolean open = false; 
	private String author = "" ; 
	private String description = ""; 
	private AbstractView abstractView = null;
	private TimePrimitive timePrimitive = null;
	private String styleURL = "";
	private Style style = null;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String isVisibility() {
		return (visibility) ? "1" : "0";
	}
	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}
	public String isOpen() {
		return (open) ? "1" : "0";
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public AbstractView getAbstractView() {
		return abstractView;
	}
	public void setAbstractView(AbstractView abstractView) {
		this.abstractView = abstractView;
	}
	public TimePrimitive getTimePrimitive() {
		return timePrimitive;
	}
	public void setTimePrimitive(TimePrimitive timePrimitive) {
		this.timePrimitive = timePrimitive;
	}
	public String getStyleURL() {
		return styleURL;
	}
	public void setStyleURL(String styleURL) {
		this.styleURL = styleURL;
	}
	public Style getStyle() {
		return style;
	}
	public void setStyle(Style style) {
		this.style = style;
	}
	
	
	public TreeNode<LinkedOutput> getLinkedOutput (){
		
		
		TreeNode<LinkedOutput> root = super.getLinkedOutput();

		root.addChild(new LinkedOutput("name", this.getName(), false));
		root.addChild(new LinkedOutput("visibility", this.isVisibility(), false));
		root.addChild(new LinkedOutput("open", this.isOpen(), false));
		root.addChild(new LinkedOutput("atom:author", this.getAuthor(), false));
		root.addChild(new LinkedOutput("description", this.getDescription(), false));
		if(getAbstractView() != null)root.addTreeNode(getAbstractView().getLinkedOutput()) ;
		if(getTimePrimitive() != null)root.addTreeNode(getTimePrimitive().getLinkedOutput());
		if(getStyle() != null)root.addTreeNode(getStyle().getLinkedOutput());
		root.addChild(new LinkedOutput("styleUrl", this.getStyleURL(), false));


		return root; 
	}
}
