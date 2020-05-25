package game.guiGame;

import crops.Crop;
import game.Game;
import javax.swing.*;


/**
 * Class to control the game with a GUI
 *
 * @author Jonathon Howe (Joh29)
 * @version 1.0
 * @see game.Game
 */
public class GUIGame extends game.Game {

    public GUIGame() {
        super(0);
    }

    /**
     * Placeholder
     * Game does not require the loop as it's run off events
     */
    public void runDay() {}

    /**
     * Placeholder
     * Store visiting is handled by MainScreen
     */
    public void visitStore() {}

    /**
     * Placeholder
     * MainScreen controls gameover for GUI
     */
    public void endGame() {}

    /**
     * Placeholder
     * Ran out of time
     */
    public void displayHelp() {}

    /**
     * Placeholder
     * Game does not require the loop as it's run off events
     */
    public void run() {}

    /**
     * Run the game (with GUI)
     * Show intro screen, then main game screen.
     * @param args default java args
     */
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
