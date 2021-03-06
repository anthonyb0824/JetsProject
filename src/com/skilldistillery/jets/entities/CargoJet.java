package com.skilldistillery.jets.entities;

public class CargoJet extends Jet implements CargoCarrier {

	public CargoJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void loadCargo() {
		System.out.println("Loading Cargo!");
		System.out.println("\n");
	}
	
	@Override
	public void fly() {
		System.out.println("Ima cargo jet flying and stuff");
		System.out.println("       __|__       ");
		System.out.println("--o--o--(_)--o--o--");
		System.out.println("\n");
	}

}
