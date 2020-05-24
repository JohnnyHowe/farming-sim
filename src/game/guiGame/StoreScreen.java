package game.guiGame;

import javax.swing.*;
import java.awt.*;

public class StoreScreen {
    private JLabel commandsLabel;
    private JButton goToFarmButton;
    private JButton goToStoreButton;
    private JPanel mainPanel;
    private JPanel commandsPanel;
    private JPanel infoPanel;

    private JFrame mainFrame;

    public void draw(JFrame frame) {
        mainFrame = frame;

        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.removeAll();
        contentPane.add(new StoreScreen().mainPanel);
        contentPane.revalidate();
        contentPane.repaint();

//        frame.setContentPane(new StoreScreen().mainPanel);
//        frame.pack();
    }
}
