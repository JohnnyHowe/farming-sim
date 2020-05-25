package game.guiGame;

import game.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndScreen {
    private JButton quitButton;
    private JLabel scoreLabel;
    private JPanel mainPanel;
    private JLabel durationLabel;

    private JFrame frame;

    public EndScreen() {
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        // Set the values
        updateAll();
    }

    /**
     * Update the information on the endScreen
     * Specifically the farm name, farmer name, total profit and the days the game was played for
     */
    private void updateAll() {
        scoreLabel.setText("Farm " + Game.getInstance().getFarm().getName() + " managed by " +
                Game.getInstance().getFarmer().getName() + " made a total profit of $" +
                Game.getInstance().getFarmer().getTotalProfit());
        durationLabel.setText("Game lasted for " + Game.getInstance().getCurrentDay() + " days.");
    }

    /**
     * Draw the end screen
     */
    public static void make() {
        EndScreen screen = new EndScreen();
        screen.frame = new JFrame("Farming Simulator! - End Screen");
        screen.frame.setContentPane(screen.mainPanel);
        screen.frame.setVisible(true);
        screen.frame.pack();
    }
}
