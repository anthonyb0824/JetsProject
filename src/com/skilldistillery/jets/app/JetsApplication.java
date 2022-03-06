package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;

public class JetsApplication {
	private static JetsApplication app = new JetsApplication();
	private static AirField af = new AirField();

	public static void main(String[] args) {
		String fileName = "jets.java";
		af.buildAirField(fileName);
		app.menu();

	}

	public void menu() {
		boolean keepgoing = true;
		Scanner kb = new Scanner(System.in);
		while (keepgoing) {

			System.out.println("1. List fleet");
			System.out.println("2. Launch all jets");
			System.out.println("3  View fastest jet");
			System.out.println("4  View jet with longest range");
			System.out.println("5. Load all Cargo Jets");
			System.out.println("6. DogFight!");
			System.out.println("7. Load Passengers	");
			System.out.println("8. Add a jet to FLeet");
			System.out.println("9. Remove a jet Fleet");
			System.out.println("10. Quit");
			String input = kb.next();
			System.out.println("\n");

			switch (input) {
			case "1":
				System.out.print(af.listFleet());
				System.out.println("\n");
				break;
			case "2":
				af.launchAlljets();
				System.out.println("\n");
				break;
			case "3":
				af.viewFastestJet();
				System.out.println("\n");
				break;
			case "4":
				af.viewJetWithLongestRange();
				System.out.println("\n");
				break;
			case "5":
				af.loadCargo();
				System.out.println("\n");
				break;
			case "6":
				af.dogFight();
				System.out.println("\n");
				break;
			case "7":
				af.loadPassengers();
				System.out.println("\n");
				break;
			case "8":
				af.addAJet();
				System.out.println("\n");
				break;
			case "9":
				af.removeAJet();
				System.out.println("\n");
				break;
			case "10":
				keepgoing = false;
				System.out.println("\n");
				break;
			}
		}
		kb.close();
	}

}
