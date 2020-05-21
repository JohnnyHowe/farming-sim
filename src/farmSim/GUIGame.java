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
    int frameScale = 600;    // How objects are scaled - min(x, y)

    public GUIGame() {
        super();
        this.setUpWindow();
    }

    /**
     * Has the size of the window changed since the last frame?
     * To be called once per loop/frame
     * Sets frameX, frameY and frameScale
     * @return window size change
     */
    private boolean windowSizeChanged() {
        Dimension size = frame.getContentPane().getSize();
        boolean change = size.width != this.frameX || size.height != this.frameY;
        this.frameX = size.width;
        this.frameY = size.height;
        this.frameScale = Math.min(this.frameX, this.frameY);
        System.out.println(change);
        return change;
    }

    private void setUpWindow() {
        this.frame = new JFrame("Farming Simulator!");
        this.frame.setSize(this.frameX, this.frameY);
        this.frame.setLayout(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.frame.setVisible(true);
    }

    private void intoScreen() {
        this.clearFrame();

        JLabel title = new JLabel("Welcome to Farming Simulator!", JLabel.CENTER);
        this.setFontSize(title, 0.06f);
        this.scaleUp(title, 0.5f, 0.1f, 1f, 0.2f);
        this.frame.add(title);

        JButton continueButton = new JButton("Next");
        this.scaleUp(continueButton, 0.5f, 0.8f, 0.5f, 0.1f);
        this.frame.add(continueButton);

        JLabel nameLabel = new JLabel("Name:");
        this.setFontSize(nameLabel, 0.03f);
        this.scaleUp(nameLabel, 0.4f, 0.6f, 0.2f, 0.1f);
        this.frame.add(nameLabel);

        JTextField nameField = new JTextField();
        this.scaleUp(nameField, 0.6f, 0.6f, 0.2f, 0.1f);
        this.frame.add(nameField);

        this.frame.setVisible(true);
    }

    private void setFontSize(JComponent textItem, float relativeSize) {
        Font font = new Font(textItem.getFont().getName(), Font.PLAIN, Math.round(this.frameScale * relativeSize));
        textItem.setFont(font);
    }

    /**
     * Given a component and a rect scale it up.
     * x, y, w, h are all relative to the window size - between 0 and 1
     * So to centre a button on the screen, it's x and y would be 0.5f.
     * NOTE: The game is scaled st it is a square in the middle of the rectangle window
     * @param component component to scale up
     * @param x centre x position to place component
     * @param y centre y position to place component
     * @param w width to set component to
     * @param h height to set component to
     */
    private void scaleUp(JComponent component, float x, float y, float w, float h) {
        // Centered unscaled
        float cux = x - w / 2;
        float cuy = y - h / 2;
        // Centered pos (on window)
        float cx = (cux - 0.5f) * this.frameScale;
        float cy = (cuy - 0.5f) * this.frameScale;
        // Screen center (in pixels)
        float scx = ((float) this.frameX) / 2;
        float scy = ((float) this.frameY) / 2;
        // Pos to put things
        float sx = scx + cx;
        float sy = scy + cy;
        // size of things
        float sw = w * this.frameScale;
        float sh = h * this.frameScale;
        component.setBounds(Math.round(sx), Math.round(sy), Math.round(sw), Math.round(sh));
    }

    private void clearFrame() {
        this.frame.getContentPane().removeAll();
        this.frame.repaint();
    }

    public void runDay() {
//        System.out.println("Running day in GUI");
        if (this.windowSizeChanged()) {
            this.intoScreen();
        }
    }

    public static void main(String[] args) {
        GUIGame game = new GUIGame();
        game.setGameLength(10);
        game.intoScreen();
        game.run();
    }
}
