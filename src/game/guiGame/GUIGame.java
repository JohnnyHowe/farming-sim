package game.guiGame;


import animals.Cow;
import crops.Wheat;
import game.Game;

import javax.swing.*;

public class GUIGame extends game.Game {

    public GUIGame() {
        super(0);
    }

    public void runDay() {
        System.out.println("Running day");
    }

    public void visitStore() {
        System.out.println("At Store");
    }

    public void endGame() {
        System.out.println("Game Over");
//        System.exit(0);
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
        // Make frame
        new GUIGame();
        JFrame frame = new JFrame("Farming Simulator");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Intro screen
        IntroScreen introScreen = new IntroScreen();
        introScreen.run(frame);

        Game.getInstance().setGameLength(introScreen.finalDays);
        Game.getInstance().getFarmer().setName(introScreen.finalFarmerName);
        Game.getInstance().getFarm().setName(introScreen.finalFarmName);
        Game.getFarm().setHappiness(introScreen.animalMul);
        Game.getFarm().setGrowth(introScreen.cropMul);

        // Run game
        MainScreen mainScreen = new MainScreen();
        frame.getContentPane().removeAll();
        frame.repaint();
        mainScreen.draw(frame);
    }
}
