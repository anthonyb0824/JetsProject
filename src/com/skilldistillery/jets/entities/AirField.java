package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AirField {
	ArrayList<Jet> jets = new ArrayList<>();
	Scanner kb = new Scanner(System.in);

	public AirField() {

	}

	public void buildAirField(String fileName) {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] result = line.split(",");
				if (result[0].equals("FighterJet")) {
					String model = result[1];
					double speed = Double.parseDouble(result[2]);
					int range = Integer.parseInt(result[3]);
					long price = Long.parseLong(result[4]);
					FighterJet alpha = new FighterJet(model, speed, range, price);
					jets.add(alpha);

				} else if (result[0].equals("CargoJet")) {
					String model = result[1];
					double speed = Double.parseDouble(result[2]);
					int range = Integer.parseInt(result[3]);
					long price = Long.parseLong(result[4]);
					CargoJet bravo = new CargoJet(model, speed, range, price);
					jets.add(bravo);

				} else if (result[0].equals("PassengerJet")) {
					String model = result[1];
					double speed = Double.parseDouble(result[2]);
					int range = Integer.parseInt(result[3]);
					long price = Long.parseLong(result[4]);
					PassengerJet charlie = new PassengerJet(model, speed, range, price);
					jets.add(charlie);

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "AirField [jets=" + jets.toString() + "]";
	}

	public void listFleet() {
		System.out.println(jets.toString());

	}

	public void launchAlljets() {
		// iterate though the arraylist jets and call .fly() on each
		for (int i = 0; i < jets.size(); i++) {
			double time = (jets.get(i).getRange())/jets.get(i).getSpeed();
			jets.get(i).fly();
			System.out.println("This jet can fly "+jets.get(i).getRange()+" miles at a speed of "+jets.get(i).getSpeed()+"MPH");
			System.out.println("Ill be out of fuel in "+time+" hours"+"\n");
			
		}
	}

	public void viewFastestJet() {
		// iterate though the arrylist and compare jets.get(i).getSpeed()
		for(int i = 0; i<jets.size(); i++) {
			
		}
	}

	public void viewJetWithLongestRange() {
		// TODO Auto-generated method stub

	}

	public void loadCargo() {
		for (Jet o : jets) {
			if (o instanceof CargoJet) {
				((CargoJet) o).loadCargo();
			}
		}
	}

	public void dogFight() {
		for (Jet o : jets) {
			if (o instanceof FighterJet) {
				((FighterJet) o).fight();
			}
		}
	}

	public void loadPassengers() {
		// call loadP for passenger jets
		for (Jet o : jets) {
			if (o instanceof PassengerJet) {
				((PassengerJet) o).loadPassengers();
			}
		}
	}

	public void addAJet() {
		System.out.println("What type would you like to add?");
		System.out.println("EX: Cargo, Fighter, Passenger");
		String type = (kb.next()).toLowerCase();
		System.out.println("Enter the model: ");
		String model = kb.next();
		System.out.println("Enter the Speed:");
		double speed = Double.parseDouble(kb.next());
		System.out.println("Enter the range:");
		int range = Integer.parseInt(kb.next());
		System.out.println("Enter the prce:");
		long price = Long.parseLong(kb.next());

		switch (type) {
		case "fighter":
			FighterJet alpha = new FighterJet(model, speed, range, price);
			jets.add(alpha);
			break;
		case "cargo":
			CargoJet bravo = new CargoJet(model, speed, range, price);
			jets.add(bravo);
			break;
		case "passenger":
			PassengerJet charlie = new PassengerJet(model, speed, range, price);
			jets.add(charlie);
			break;
		}
	}

	public void removeAJet() {
		int input;
		// iterate though the array and print them 1,2,3,4 and have the user pick to
		// delete one
		System.out.println("Please pick a jet to remove.");
		for (int i = 0; i < jets.size(); i++) {
			System.out.println((i + 1) + ": " + jets.get(i).getModel());
		}
		boolean goodInput = false;
		while (!goodInput) {
			try {
				input = kb.nextInt();
				goodInput = true;
				System.out.println("Jet: " + (jets.get(input - 1).getModel()) + " has been removed!");
				jets.remove(input - 1);

			} catch (Exception e) {
				System.out.println(e);
				System.err.println("Invalid input");
				System.out.println("Please enter the number of jet you would like to remove.");
			}
		}

	}

}
