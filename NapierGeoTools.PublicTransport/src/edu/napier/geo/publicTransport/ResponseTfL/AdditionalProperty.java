package edu.napier.geo.publicTransport.ResponseTfL;

import java.io.Serializable;

public  class AdditionalProperty implements Serializable {
    /**
     * 
	 * Created with https://timboudreau.com/blog/json/read under Creative
	 * Commons CC BY-NC-SA 3.0 license. Author of the used software: Tim Boudreau.  
	 * Changes: Jan-Niklas Keiner 2017/03/02
	 * Changes: separation of inner classes, adding getter methods and making
	 * objects compatible to objects of the public transport project. License:
	 * https://creativecommons.org/licenses/by-nc-sa/3.0/legalcode
	 *
	 */
	private static final long serialVersionUID = 9056151929296838274L;
	private  String category;
    private  String key;
    private  String sourceSystemKey;
    private  String value;
    private  String modified;

    public AdditionalProperty(String category, String key, String sourceSystemKey, String value, String modified){
        this.category = category;
        this.key = key;
        this.sourceSystemKey = sourceSystemKey;
        this.value = value;
        this.modified = modified;
    }

	public String getCategory() {
		return category;
	}

	public String getKey() {
		return key;
	}

	public String getSourceSystemKey() {
		return sourceSystemKey;
	}

	public String getValue() {
		return value;
	}

	public String getModified() {
		return modified;
	}
    
}