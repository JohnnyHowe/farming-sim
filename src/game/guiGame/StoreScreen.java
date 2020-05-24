package game.guiGame;

import animals.Animal;
import crops.*;
import farm.Farm;
import farm.FarmItem;
import farm.ItemFactory;
import game.Game;
import items.Item;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class StoreScreen {
    private JPanel panel1;
    private JLabel storeLabel;
    private JButton nextButton;
    private JButton previousButton;
    private JLabel itemNumberLabel;
    private JLabel itemNameLabel;

    private JFrame frame;
    private int currentSlot = 0;

    public StoreScreen() {
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeSelectedSlot(-1);
                updateItemNumberLabel();
                updateCurrentItem();
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
    }

    private void updateCurrentItem() {
        List<Crop> crops = Collections.list(ItemFactory.GetAllCrops().elements());
        List<Animal> animals = Collections.list(ItemFactory.GetAllAnimals().elements());
        List<Item> items = Collections.list(ItemFactory.GetAllItems().elements());
        if (currentSlot < crops.size()) {
            itemNameLabel.setText(crops.get(currentSlot).getName());
        } else if (currentSlot < crops.size() + animals.size()) {
            itemNameLabel.setText(animals.get(currentSlot - crops.size()).getName());
        } else {
            itemNameLabel.setText(items.get(currentSlot - crops.size() - animals.size()).getName());
        }
    }

    /**
     * Increase the selected slot number by change
     * Clamps it between 0 and 14 (inclusive)
     * @param change
     */
    private void changeSelectedSlot(int change) {
        currentSlot = Math.max(Math.min(currentSlot + change, 14), 0);
        previousButton.setEnabled(true);
        nextButton.setEnabled(true);
        if (currentSlot == 0) {
            previousButton.setEnabled(false);
        } else if (currentSlot == 14) {
            nextButton.setEnabled(false);
        }
    }

    /**
     * Update the item number label to
     * "Showing Paddock Slow currentslot+1/9"
     */
    private void updateItemNumberLabel() {
        itemNumberLabel.setText("Showing Item " + (currentSlot + 1) + "/x");
    }

    public static void make() {
        StoreScreen screen = new StoreScreen();
        screen.frame = new JFrame("ASS");
        screen.frame.setContentPane(screen.panel1);
        screen.frame.setVisible(true);
        screen.frame.pack();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        itemNameLabel = new JLabel();
    }
}
