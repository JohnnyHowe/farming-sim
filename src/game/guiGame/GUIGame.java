package game.guiGame;


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

    private void runGUI() {
        JFrame frame = new JFrame("Farming Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        IntroScreen introScreen = new IntroScreen();
        introScreen.draw(frame);
    }

    public static void main(String[] args) {
        // Make frame
        GUIGame game = new GUIGame();
        game.runGUI();
    }
}
