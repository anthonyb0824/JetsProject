package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fight() {
		System.out.println("Off we go into the wild blue yonder,\n" + "\n" + "Climbing high into the sun;\n" + "\n"
				+ "Here they come zooming to meet our thunder, \n" + "\n"
				+ "At 'em, boys, Give 'er the gun! (Give 'er the gun now!) \n" + "\n"
				+ "Down we dive, spouting our flame from under,\n" + "\n" + "Off with one helluva roar! \n" + "\n"
				+ "We live in fame or go down in flame. Hey! \n" + "\n" + "Nothing will stop the U.S. Air Force!\n"
				+ "");
		System.out.println("                                         |\n"
				+ "                  |                      |\n" + "                  |                    -/_\\-\n"
				+ "                -/_\\-   ______________(/ . \\)______________\n"
				+ "   ____________(/ . \\)_____________    \\___/     <>\n" + "   <>           \\___/      <>    <>\n"
				+ "\n" + "      ||\n" + "      <>\n" + "                            ||\n"
				+ "                            <>\n" + "                                        |\n"
				+ "                                       ||            BIG\n"
				+ "        _____               __         <>      (^)))^ BOOM!\n"
				+ "  BOOM!/((  )\\       BOOM!((  )))            (     ( )\n"
				+ " ---- (__()__))          (() ) ))           (  (  (   )\n"
				+ "     ||  |||____|------    \\  (/   ___     (__\\     /__)\n"
				+ "      |__|||  |     |---|---|||___|   |___-----|||||\n"
				+ "  |  ||.  |   |       |     |||                |||||\n"
				+ "      |__|||  |     |---|---|||___|   |___-----|||||\n"
				+ "  |  ||.  |   |       |     |||                |||||  \n"
				+ " __________________________________________________________\n");
		System.out.println("\n");
	}

	@Override
	public void fly() {
		System.out.println("Im a " + this.getModel() + ".");
		System.out.println("    __!__    ");
		System.out.println("_____(_)_____");
		System.out.println("   !  !  !   ");
		System.out.println("\n");
	}

}
