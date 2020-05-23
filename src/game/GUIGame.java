package game;
import javax.swing.*;
import java.awt.*;


/**
 * I think you needa read this my man
 * 4.3 Implementing a Graphical Application
You will be implementing a graphical application for your game using Swing,
which will be explained in labs. For the purposes of this assignment, we do not
recommend writing the Swing code by hand, and instead using the interface
builder offered by the Eclipse IDE. This lets you build graphical interfaces in
Swing by dragging and dropping components onto a canvas onscreen, and it will
automatically generate the code to create the graphical application you built.
Please note, you are required to ensure that any automatically generated
code complies with the rest of your code style, so you will need to change
variable/method names and code layout.
Once you have built your interface, the next task is to wire up the graphical
components to the methods your command line application supplies, and to update the onscreen text fields with the new values of your class attributes/member
variables. Most of these functions are triggered on onClick() methods from
buttons. Start small, and complete Section 2.1 “Setting up the Game” first to
get used to GUI programming. You might need to slightly adjust your methods
to achieve this. Then move onto the main game.
Note that this is the largest task to complete and many students under
estimate how much time it will take. Try to be at this stage one week after the
term break if possible.

 */

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

        // Number of days input
        JLabel daysLabel = new JLabel("Days:");
        this.setFontSize(daysLabel, 0.04f);
        this.scaleUp(daysLabel, 0.4f, 0.6f, 0.2f, 0.08f);
        this.frame.add(daysLabel);

        JTextField daysField = new JTextField();
        this.scaleUp(daysField, 0.6f, 0.6f, 0.3f, 0.1f);
        this.setFontSize(daysField, 0.04f);
        this.frame.add(daysField);

        // Name text input
        float nameY = 0.5f;
        JLabel nameLabel = new JLabel("Name:");
        this.setFontSize(nameLabel, 0.04f);
        this.scaleUp(nameLabel, 0.4f, nameY, 0.2f, 0.08f);
        this.frame.add(nameLabel);

        JTextField nameField = new JTextField();
        this.scaleUp(nameField, 0.6f, nameY, 0.3f, 0.1f);
        this.setFontSize(nameField, 0.04f);
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
    	//may be a tad broken, may be best to start GUI from ground up with interface?
    	//see ConsoleGame on correct method of initialisation.
        GUIGame game = new GUIGame();
        game.setGameLength(10);
        game.intoScreen();
        game.run();
    }

    public void visitStore() {
		// TODO Auto-generated method stub
		
	}

	protected void end() {
		// TODO Auto-generated method stub
		
	}

	protected void displayHelp() {
		// TODO Auto-generated method stub
		
	}
}
