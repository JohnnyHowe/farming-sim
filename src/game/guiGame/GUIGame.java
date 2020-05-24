package game.guiGame;


import game.Game;

public class GUIGame extends game.Game {

    public GUIGame() {
        super(0);
    }

    public void runDay() {
        System.out.println("Running day");
    }

    public void visitStore() {

    }

    public void endGame() {

    }

    public void displayHelp() {

    }

    public void run() {

        while (Game.getInstance().getCurrentDay() < Game.getInstance().getGameLength()) {
            this.runDay();
        }
        this.endGame();
    }

    public static void main(String[] args) {
        // Setup
        new GUIGame();
        IntroScreen introScreen = new IntroScreen();
        introScreen.run();
        Game.getInstance().setGameLength(introScreen.finalDays);
        Game.getInstance().getFarmer().setName(introScreen.finalFarmerName);
        Game.getInstance().getFarm().setName(introScreen.finalFarmName);
    }
}
