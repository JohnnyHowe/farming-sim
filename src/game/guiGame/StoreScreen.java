package game.guiGame;

import animals.Animal;
import crops.*;
import exceptions.InsufficientFundsException;
import farm.Farm;
import farm.FarmItem;
import farm.ItemFactory;
import game.Game;
import items.Bonemeal;
import items.Fertiliser;
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
    private JButton buyButton;
    private JLabel itemCostLabel;
    private JLabel itemSellLabel;
    private JLabel moneyLabel;
    private JLabel brokeLabel;
    private JLabel itemDescLabel;

    private JFrame frame;
    private int currentSlot = 0;

    public StoreScreen() {
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeSelectedSlot(-1);
                updateAll();
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeSelectedSlot(1);
                updateAll();
            }
        });
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAll();
                try {
                    Game.getStore().buy(getSelectedItem());
                } catch (InsufficientFundsException error) {
                    brokeLabel.setVisible(true);
                }
                updateMoneyLabel();
            }
        });
    }

    private FarmItem getSelectedItem() {
//        List<Crop> crops = Collections.list(ItemFactory.GetAllCrops().elements());
//        List<Animal> animals = Collections.list(ItemFactory.GetAllAnimals().elements());
//        List<Item> items = Collections.list(ItemFactory.GetAllItems().elements());
        ArrayList<Crop> crops = Game.getStore().getCrops();
        ArrayList<Animal> animals = Game.getStore().getAnimals();
        ArrayList<Item> items = Game.getStore().getItems();

        if (currentSlot < crops.size()) {
            return (FarmItem) crops.get(currentSlot);
        } else if (currentSlot < crops.size() + animals.size()) {
            return (FarmItem) animals.get(currentSlot - crops.size());
        } else {
            return (FarmItem) items.get(currentSlot - crops.size() - animals.size());
        }
    }

    private void updateAll() {
        updateCurrentItem();
        updateMoneyLabel();
    }

    private void updateMoneyLabel() {
        moneyLabel.setText("Money: $" + Game.getFarmer().getMoney());
    }

    private void updateCurrentItem() {
        FarmItem selection = getSelectedItem();
        itemNameLabel.setText(selection.getName());
        itemCostLabel.setText("Buy Price: $" + selection.getBuyPrice());
        itemSellLabel.setText("Sell Price: $" + selection.getSellPrice());
        itemDescLabel.setText("<html>" + selection.getDescription() + "</html>");
    }

    /**
     * Increase the selected slot number by change
     * Clamps it between 0 and 14 (inclusive)
     * @param change
     */
    private void changeSelectedSlot(int change) {
        brokeLabel.setVisible(false);
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
