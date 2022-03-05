package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;

public class JetsApplication {
	private static JetsApplication app = new JetsApplication();
	private static AirField af = new AirField();

	public static void main(String[] args) {
		String fileName = "jets .java";
		af.buildAirField(fileName);
		app.menu();

	}
	
	public void menu() {
		boolean keepgoing = true;
		while(keepgoing) {
			
			Scanner kb = new Scanner(System.in);
			System.out.println("\n");
			System.out.println("1. List fleet");
			System.out.println("2. Launch all jets");
			System.out.println("3. View fastest jet");
			System.out.println("4. View jet with longest range");
			System.out.println("5. Load all Cargo Jets");
			System.out.println("6. DogFight!");
			System.out.println("7. Load Passengers");
			System.out.println("8. Add a jet to FLeet");
			System.out.println("9. Remove a jet Fleet");
			System.out.println("10. Quit");
			//try-catch for error handling
			String input = kb.next();
			
			switch(input) {
			case "1":
				af.listFleet();
				break;
			case "2":
				af.launchAlljets();
				break;
			case "3":
				af.viewFastestJet();
				break;
			case "4":
				af.viewJetWithLongestRange();
				break;
			case "5":
				af.loadCargo();
				break;
			case "6":
				af.dogFight();
				break;
			case "7":
				af.loadPassengers();
				break;
			case "8":
				af.addAJet();
				break;
			case "9":
				af.removeAJet();
				break;
			case "10":
				keepgoing =false;
				break;
			}
		}
	}


}
