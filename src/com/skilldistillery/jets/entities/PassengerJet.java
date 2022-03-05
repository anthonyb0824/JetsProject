package com.skilldistillery.jets.entities;

public class PassengerJet extends Jet implements PassengerReady {

	public PassengerJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void loadPassengers() {
		System.out.println("Loading Passengers");
		System.out.println("Boarding group A!!");
	}
	
	@Override
	public void fly() {
		System.out.println("Fasten seatbelt light is on... off we go");
	}
	

}
