package game.guiGame;

import game.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class IntroScreen {
    private JPanel mainPanel;
    private JLabel introLabel;
    private JPanel infoPanel;
    private JPanel nextButtonPanel;
    private JButton nextButton;
    private JLabel nameLabel;
    private JTextField nameField;

    private static JFrame mainFrame;

    public IntroScreen() {
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Go to next screen
                Game.getInstance().getFarmer().setName(nameField.getText());
                InventoryScreen inventoryScreen = new InventoryScreen();
                inventoryScreen.draw(mainFrame);
            }
        });
    }

    public void draw(JFrame frame) {
        mainFrame = frame;
        frame.setContentPane(new IntroScreen().mainPanel);
        frame.pack();
    }
}
