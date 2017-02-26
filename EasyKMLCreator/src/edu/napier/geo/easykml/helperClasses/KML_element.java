package edu.napier.geo.easykml.helperClasses;


public class KML_element {

	private String name;
	private String text;
	private boolean gExtenstion;

	public KML_element(String name, String text, boolean gExtension) {
		this.name = name;
		this.text = text;
		this.gExtenstion = gExtension;
	}

	public boolean isgExtenstion() {
		return gExtenstion;
	}

	public void setgExtenstion(boolean gExtenstion) {
		this.gExtenstion = gExtenstion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getName() + "--" + this.getText();
	}

}
