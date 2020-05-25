package game.guiGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndScreen {
    private JButton quitButton;
    private JLabel scoreLabel;
    private JPanel mainPanel;

    private JFrame frame;

    public EndScreen() {
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        scoreLabel = new JLabel("AAAAAAAAAAAAAA");
    }

    public static void make() {
        EndScreen screen = new EndScreen();
        screen.frame = new JFrame("Farming Simulator! - End Screen");
        screen.frame.setContentPane(screen.mainPanel);
        screen.frame.setVisible(true);
        screen.frame.pack();
    }
}
