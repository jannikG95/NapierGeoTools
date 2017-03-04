package edu.napier.geo.publicTransport.ResponseTfL;

import java.io.Serializable;

public  class LineModeGroup implements Serializable {
    /**
	 * Created with https://timboudreau.com/blog/json/read under Creative
	 * Commons CC BY-NC-SA 3.0 license. Author of the used software: Tim Boudreau.  
	 * Changes: Jan-Niklas Keiner 2017/03/02
	 * Changes: separation of inner classes, adding getter methods and making
	 * objects compatible to objects of the public transport project. License:
	 * https://creativecommons.org/licenses/by-nc-sa/3.0/legalcode
	 *
	 */
	private static final long serialVersionUID = 771505922606056801L;
	private  String modeName;
    private  String[] lineIdentifier;

    public LineModeGroup(String modeName, String[] lineIdentifier){
        this.modeName = modeName;
        this.lineIdentifier = lineIdentifier;
    }

	public String getModeName() {
		return modeName;
	}

	public String[] getLineIdentifier() {
		return lineIdentifier;
	}
}