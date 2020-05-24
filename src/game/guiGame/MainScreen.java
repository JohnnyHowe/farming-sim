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
    private JPanel gamePanel;
    private JPanel paddockNavPanel;
    private JPanel paddockItemPanel;
    private JButton previousButton;
    private JButton nextButton;
    private JLabel itemNumberLabel;
    private JLabel paddockItemName;
    private JButton goToFarmButton;
    private JPanel titlePanel;
    private JLabel gamePanelTitle;

    private JPanel paddockPanel;

    private int currentSlot = 0;

    public MainScreen() {

        // Listeners
        visitStoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Go to Store");
                StoreScreen.make();
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
                updateCurrentItem();
            }
        });
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeSelectedSlot(-1);
                updateItemNumberLabel();
                updateCurrentItem();
            }
        });
    }

    /**
     * Update the shown item in the visible slot
     */
    private void updateCurrentItem() {
        ArrayList<FarmItem> items = Game.getInstance().getFarm().getPaddockItems();
        if (currentSlot < items.size()) {
            FarmItem item = items.get(currentSlot);
            paddockItemName.setText(item.getName());
        } else {
            paddockItemName.setText("Slot Empty");
        }
    }

    /**
     * In the display slot, draw the FarmItem with the crop layout
     * @param item item to draw info of
     */
    private void drawCropItem(FarmItem item) {
    }

    /**
     * Update the item number label to
     * "Showing Paddock Slow currentslot+1/9"
     */
    private void updateItemNumberLabel() {
        itemNumberLabel.setText("Showing Paddock Slot " + (currentSlot + 1) + "/9");
    }

    /**
     * Increase the selected slot number by change
     * Clamps it between 0 and 8 (inclusive)
     * @param change
     */
    private void changeSelectedSlot(int change) {
        currentSlot = Math.max(Math.min(currentSlot + change, 8), 0);
        previousButton.setEnabled(true);
        nextButton.setEnabled(true);
        if (currentSlot == 0) {
            previousButton.setEnabled(false);
        } else if (currentSlot == 8) {
            nextButton.setEnabled(false);
        }
    }

    /**
     * Draw the MainScreen GUI
     * Has "info" panel across the top
     * "Commands" panel down the left
     * The remaining section is the paddock panel
     *
     * @param frame JFrame to draw things to
     */
    public void draw(JFrame frame) {
        frame.setContentPane(new MainScreen().mainPanel);

        // Test items
        Game.getFarm().addFarmItem(new Wheat());
//        Game.getFarm().addFarmItem(new Melon());
//        Game.getFarm().addFarmItem(new Sheep());
//        Game.getFarm().addFarmItem(new SugarCane());
        frame.pack();
    }
}

