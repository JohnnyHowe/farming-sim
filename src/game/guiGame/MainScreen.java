package game.guiGame;

import animals.Sheep;
import crops.Melon;
import crops.SugarCane;
import crops.Wheat;
import farm.Farm;
import farm.FarmItem;
import game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainScreen {
    private JPanel commandsPanel;
    private JLabel daysLabel;
    private JLabel commandsLabel;
    private JButton endGameButton;
    private JButton helpButton;
    private JButton tendFarmButton;
    private JButton visitStoreButton;
    private JPanel mainPanel;
    private JLabel farmerInfoLabel;
    private JLabel actionsLeftLabel;
    private JPanel paddockPanelContainer;
    private JButton previousButton;
    private JButton nextButton;
    private JLabel itemNumberLabel;

    private JPanel paddockPanel;

    private int currentSlot = 0;

    public MainScreen() {

        // Listeners
        visitStoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Go to Store");
            }
        });
        tendFarmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tend Farm");
            }
        });
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Help!");
            }
        });
        endGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("End Game");
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeSelectedSlot(1);
                updateItemNumberLabel();
            }
        });
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeSelectedSlot(-1);
                updateItemNumberLabel();
            }
        });
    }

    /**
     * Update the item number label to
     * "Showing Paddock Slow currentslot+1/9"
     */
    public void updateItemNumberLabel() {
        itemNumberLabel.setText("Showing Paddock Slot " + (currentSlot + 1) + "/9");
    }

    /**
     * Increase the selected slot number by change
     * Clamps it between 0 and 8 (inclusive)
     * @param change
     */
    public void changeSelectedSlot(int change) {
        currentSlot = Math.max(Math.min(currentSlot + change, 8), 0);
    }

    /**
     * Draw the MainScreen GUI
     * Has "info" panel across the top
     * "Commands" panel down the left
     * The remaining section is the paddoc panel
     *
     * @param frame JFrame to draw things to
     */
    public void draw(JFrame frame) {
        frame.setContentPane(new MainScreen().mainPanel);

        // Test items
        Game.getFarm().addFarmItem(new Wheat());
        Game.getFarm().addFarmItem(new Melon());
        Game.getFarm().addFarmItem(new Sheep());
        Game.getFarm().addFarmItem(new SugarCane());

        frame.pack();
    }
}

