package ResponseTfL;

public class Crowding {
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