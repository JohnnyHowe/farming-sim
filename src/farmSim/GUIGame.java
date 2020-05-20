package farmSim;
import javax.swing.*;
import java.awt.*;


/**
 * Game class - acts as game environment.
 * Runs game through GUI window
 */
public class GUIGame extends Game {

    JFrame window;

    public GUIGame() {
        super();
        this.setUpWindow();
    }

    private void setUpWindow() {
        this.window = new JFrame("Farming Simulator!");
        this.window.setSize(600, 600);
        this.window.setVisible(true);
    }

    private void intoScreen() {
        JLabel title = new JLabel("Welcome to Farming Simulator!", JLabel.CENTER);
        Font titleFont = new Font(title.getFont().getName(), Font.PLAIN, 40);
        title.setVerticalAlignment(SwingConstants.TOP);
        title.setFont(titleFont);
        this.window.add(title);
    }

    public void runDay() {
        System.out.println("Running day in GUI");
    }

    public static void main(String[] args) {
        GUIGame game = new GUIGame();
        game.intoScreen();
//        game.run();
    }
}
