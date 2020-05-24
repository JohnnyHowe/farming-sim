package game.guiGame;


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
        // Make frame
        new GUIGame();
        JFrame frame = new JFrame("Farming Simulator");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Intro screen
//        IntroScreen introScreen = new IntroScreen();
//        introScreen.run(frame);
//        Game.getInstance().setGameLength(introScreen.finalDays);
//        Game.getInstance().getFarmer().setName(introScreen.finalFarmerName);
//        Game.getInstance().getFarm().setName(introScreen.finalFarmName);
        Game.getInstance().setGameLength(10);
        Game.getInstance().getFarmer().setName("RC");
        Game.getInstance().getFarm().setName("Ur Mom");

        // Run game
        MainScreen mainScreen = new MainScreen();
        frame.getContentPane().removeAll();
        frame.repaint();
        mainScreen.draw(frame);
    }
}
