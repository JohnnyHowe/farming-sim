package farmSim;
import javax.swing.*;
import java.awt.*;


/**
 * Game class - acts as game environment.
 * Runs game through GUI window
 */
public class GUIGame extends Game {

    JFrame frame;
    int frameX = 600;
    int frameY = 600;

    public GUIGame() {
        super();
        this.setUpWindow();
    }

    private void setUpWindow() {
        this.frame = new JFrame("Farming Simulator!");
        this.frame.setSize(this.frameX, this.frameY);
        this.frame.setLayout(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.frame.setVisible(true);
    }

    private void intoScreen() {
        JLabel title = new JLabel("Welcome to Farming Simulator!", JLabel.CENTER);
        Font titleFont = new Font(title.getFont().getName(), Font.PLAIN, 35);
        title.setFont(titleFont);
        this.scaleUp(title, 0.5f, 0.1f, 1f, 0.2f);
        this.frame.add(title);

        JButton continueButton = new JButton("Next");
        this.scaleUp(continueButton, 0.5f, 0.8f, 0.5f, 0.1f);
        this.frame.add(continueButton);

        this.frame.setVisible(true);
    }

    /**
     * Given a component and a rect scale it up.
     * x, y, w, h are all relative to the window size - between 0 and 1
     * So to centre a button on the screen, it's x and y would be 0.5f.
     * NOTE: (0, 0) is top left of the screen.
     * @param component component to scale up
     * @param x centre x position to place component
     * @param y centre y position to place component
     * @param w width to set component to
     * @param h height to set component to
     */
    private void scaleUp(JComponent component, float x, float y, float w, float h) {
        int sx = Math.round((x - w / 2) * this.frameX);
        int sy = Math.round((y - h / 2) * this.frameY);
        int sw = Math.round(w * this.frameX);
        int sh = Math.round(h * this.frameY);
        component.setBounds(sx, sy, sw, sh);
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
