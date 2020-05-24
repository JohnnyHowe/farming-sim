package game.guiGame;

import game.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryScreen {
    private JPanel mainPanel;
    private JPanel gameInfoPanel;
    private JPanel commandsPanel;
    private JPanel gamePanel;
    private JButton goToStoreButton;
    private JButton goToFarmButton;
    private JLabel commandsLabel;

    private JFrame mainFrame;


    public InventoryScreen() {
        goToFarmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Go to farm");
//                InventoryScreen inventoryScreen = new InventoryScreen();
//                inventoryScreen.draw(mainFrame);
            }
        });
        goToStoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Go to store");
                StoreScreen screen = new StoreScreen();
                screen.draw(mainFrame);
            }
        });
    }

    public void draw(JFrame frame) {
        mainFrame = frame;
//        frame.setContentPane(new InventoryScreen().mainPanel);
//        frame.pack();

        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.removeAll();
        contentPane.add(new InventoryScreen().mainPanel);
        contentPane.revalidate();
        contentPane.repaint();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
