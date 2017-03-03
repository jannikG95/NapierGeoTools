package edu.napier.geo.publicTransport.ResponseTfL;

import java.io.Serializable;

public class Instruction implements Serializable {
	/**
	 * Created with https://timboudreau.com/blog/json/read under Creative
	 * Commons CC BY-NC-SA 3.0 license. Author of the used software: Tim Boudreau.  
	 * Changes: Jan-Niklas Keiner 2017/03/02
	 * Changes: separation of inner classes, adding getter methods and making
	 * objects compatible to objects of the public transport project. License:
	 * https://creativecommons.org/licenses/by-nc-sa/3.0/legalcode
	 *
	 */
	private static final long serialVersionUID = 5874347722989890899L;
	private String summary;
	private String detailed;
	private Step steps[];

	public Instruction(String summary, String detailed, Step[] steps) {
		this.summary = summary;
		this.detailed = detailed;
		this.steps = steps;
	}

	public String getSummary() {
		return summary;
	}

	public String getDetailed() {
		return detailed;
	}

	public Step[] getSteps() {
		return steps;
	}

}