package edu.napier.geo.publicTransport.ResponseTfL;

import java.io.Serializable;

public class Crowding implements Serializable {
	/**
	 * Created with https://timboudreau.com/blog/json/read under Creative
	 * Commons CC BY-NC-SA 3.0 license. Author of the used software: Tim Boudreau.  
	 * Changes: Jan-Niklas Keiner 2017/03/02
	 * Changes: separation of inner classes, adding getter methods and making
	 * objects compatible to objects of the public transport project. License:
	 * https://creativecommons.org/licenses/by-nc-sa/3.0/legalcode
	 *
	 */
	private static final long serialVersionUID = -713556270670160272L;
	private PassengerFlow passengerFlows[];
	private TrainLoading trainLoadings[];

	public Crowding(PassengerFlow[] passengerFlows, TrainLoading[] trainLoadings) {
		this.passengerFlows = passengerFlows;
		this.trainLoadings = trainLoadings;
	}



	public PassengerFlow[] getPassengerFlows() {
		return passengerFlows;
	}

	public TrainLoading[] getTrainLoadings() {
		return trainLoadings;
	}
	
}