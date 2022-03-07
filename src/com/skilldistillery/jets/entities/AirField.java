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

	public String listFleet() {
		StringBuilder sb = new StringBuilder("AirField contains: \n");
		for(int i = 0; i<jets.size();i++) {
		sb.append(jets.get(i).toString());
		}
		String listFleet = sb.toString();
		return listFleet;
	}

	public void launchAlljets() {
		for (int i = 0; i < jets.size(); i++) {
			double time = (jets.get(i).getRange()) / jets.get(i).getSpeed();
			jets.get(i).fly();
			System.out.println("This jet can fly " + jets.get(i).getRange() + " miles at a speed of "
					+ jets.get(i).getSpeed() + "MPH");
			System.out.println("It will be out of fuel in " + time + " hours" + "\n");

		}
	}

	public void viewFastestJet() {
		Jet fastest = new Jet(null, 0, 0, 0);
		for (int i = 0; i < jets.size(); i++) {
			if (jets.get(i).getSpeed() > fastest.getSpeed()) {
				fastest = jets.get(i);

			}
		}
		System.out.println("The Jet with the highest speed is :" + fastest.getModel() + ".");
		System.out.println("It has a range of: " + fastest.getRange() + " miles.");
		System.out.println("It has a price of: $" + fastest.getPrice() + " million.");
		System.out.println("It has a range of: " + fastest.getSpeed() + "mph");
	}

	public void viewJetWithLongestRange() {
		Jet longestRange = new Jet(null, 0, 0, 0);
		for (int i = 0; i < jets.size(); i++) {
			if (jets.get(i).getRange() > longestRange.getRange()) {
				longestRange = jets.get(i);
			}
		}
		System.out.println("The Jet with the longest range is :" + longestRange.getModel() + ".");
		System.out.println("It has a range of: " + longestRange.getRange() + " miles.");
		System.out.println("It has a price of: $" + longestRange.getPrice() + " million.");
		System.out.println("It has a speed of: " + longestRange.getSpeed() + "mph.");

	}

	public void loadCargo() {
		for (Jet o : jets) {
			if (o instanceof CargoJet) {
				System.out.print(((CargoJet) o).getModel() + " ");
				((CargoJet) o).loadCargo();
			}
		}
	}

	public void dogFight() {
		for (Jet o : jets) {
			if (o instanceof FighterJet) {
				//System.out.print(((FighterJet) o).getModel() + " ");
				((FighterJet) o).fight();
			}
		}
	}

	public void loadPassengers() {
		for (Jet o : jets) {
			if (o instanceof PassengerJet) {
				System.out.print(((PassengerJet) o).getModel() + " ");
				((PassengerJet) o).loadPassengers();
			}
		}
	}

	public void addAJet() {
		boolean validInput = false;
		String type = "";
		double speed = 0;
		int range = 0;
		long price = 0;

		System.out.println("What type would you like to add?");
		while (!validInput) {
			System.out.println("EX: Cargo, Fighter, Passenger");
			type = (kb.next()).toLowerCase();
			if (type.toLowerCase().equals("cargo") || type.toLowerCase().equals("fighter")
					|| type.toLowerCase().equals("passenger")) {
				validInput = true;
			} else {
				System.err.println("Invalid  input! Try again");
			}

		}
		System.out.println("Enter the model: ");
		String model = kb.next();
		System.out.println("Enter the Speed:");
		validInput = false;
		while (!validInput) {
			try {
				speed = Double.parseDouble(kb.next());
				validInput = true;

			} catch (NumberFormatException e) {
				System.err.println("Invalid input! Try again");
			}

		}
		validInput = false;
		System.out.println("Enter the range:");
		while (!validInput) {
			try {
				range = Integer.parseInt(kb.next());
				validInput = true;

			} catch (NumberFormatException e) {
				System.err.println("Invalid input! Try again");
			}
		}
		validInput = false;
		System.out.println("Enter the price:");
		while (!validInput) {
			try {
				price = Long.parseLong(kb.next());
				validInput = true;
			} catch (Exception e) {
				System.err.println("Invalid input! Try again");
			}
		}

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
