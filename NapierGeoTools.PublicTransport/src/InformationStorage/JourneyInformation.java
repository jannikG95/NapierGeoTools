package InformationStorage;

import java.io.Serializable;
import java.util.ArrayList;

import General.Location;

public class JourneyInformation implements Serializable {
	private Location from;
	private Location to;
	private ArrayList<Integer> times;
	private double averageTime;
	private ArrayList<Integer> legs;
	private double averageNumberOfLegs;
	
	public JourneyInformation(Location from, Location to, int time, int numberOfLegs){
		this.from=from;
		this.to=to;
		this.times=new ArrayList<Integer>();
		this.addTime(time);
		this.legs=new ArrayList<Integer>();
		this.addLeg(numberOfLegs);
	}

	public Location getFrom() {
		return from;
	}

	public void setFrom(Location from) {
		this.from = from;
	}

	public Location getTo() {
		return to;
	}

	public void setTo(Location to) {
		this.to = to;
	}

	public ArrayList<Integer> getTime() {
		return times;
	}

	public void setTime(ArrayList<Integer> time) {
		this.times = time;
	}
	
	

	public double getAverageTime() {
		return averageTime;
	}

	public void setAverageTime(double averageTime) {
		this.averageTime = averageTime;
	}

	public void addTime(int time){
		this.times.add(time);
		System.out.println("averageTimeForRoute-addTime. Time="+time);
		calcAverageTime();
	}
	
	
	private void calcAverageTime(){
		System.out.println("AverageTimeForRoute - calcAverageTime(). Old average="+this.getAverageTime());
		double average=0;
		int count=0;
		for(Integer x : times){
			average=average+x;
			count++;
		}
		setAverageTime(average/count);
		System.out.println("AverageTimeForRoute-calcAverageTime() set to:"+ this.averageTime);
	}
	
	public double getAverageNumberOfLegs() {
		return averageNumberOfLegs;
	}

	public void setAverageNumberOfLegs(double averageNumberOfLegs) {
		this.averageNumberOfLegs = averageNumberOfLegs;
	}

	public void addLeg(int numberOfLegs){
		this.legs.add(numberOfLegs);
		System.out.println("averageNumberOfLegsForRoute-addNumberOfLegs. NumberOfLegs="+numberOfLegs);
		calcAverageNumberOfLegs();
	}
	
	
	private void calcAverageNumberOfLegs(){
		System.out.println("AverageNumberOfLegsForRoute - calcAverageNumberOfLegs(). Old average="+this.getAverageNumberOfLegs());
		double average=0;
		int count=0;
		for(Integer x : legs){
			average=average+x;
			count++;
		}
		setAverageNumberOfLegs(average/count);
		System.out.println("AverageTimeForRoute-calcAverageTime() set to:"+ this.averageTime);
	}
	
	
	public String print(){
		return "from:"+this.getFrom().print()+" to:"+this.getTo().print()+" averageTime:"+averageTime+" all times:"+times + " averageNumberOfLegs="+averageNumberOfLegs+" all numbersOfLegs="+legs;
	}
}
