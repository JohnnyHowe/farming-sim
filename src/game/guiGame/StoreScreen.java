package game.guiGame;

import animals.Animal;
import crops.*;
import exceptions.InsufficientFundsException;
import farm.FarmItem;
import game.Game;
import items.Item;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class StoreScreen {
    // If eclipse complains about these it's wrong
    // The UI was made with the help of IntelliJ IDEA, this is the format for that (kinda)
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
        updateAll();
    }

    /**
     * Get the item that's selected ASSUMING IT EXISTS
     * @return item selected
     */
    private FarmItem getSelectedItem() {
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

    /**
     * Update all the bits that can change on the screen
     * includes money and current item (name desc etc)
     */
    private void updateAll() {
        updateCurrentItem();
        updateMoneyLabel();
    }

    /**
     * set the money label to "Money :$x" where x is the players money
     */
    private void updateMoneyLabel() {
        moneyLabel.setText("Money: $" + Game.getFarmer().getMoney());
    }

    /**
     * Update the name, description income etc of the selected item being displayed
     */
    private void updateCurrentItem() {
        FarmItem selection = getSelectedItem();
        itemNameLabel.setText(selection.getName());
        itemCostLabel.setText("Buy Price: $" + selection.getBuyPrice());
        itemDescLabel.setText("<html>" + selection.getDescription() + "</html>");
        if (selection instanceof Animal) {
            itemSellLabel.setText("Daily Income: $" + ((Animal) selection).getDailyProfit());
        } else if (selection instanceof Crop) {
            itemSellLabel.setText("Harvest Income: $" + ((Crop) selection).getIncome());
        } else {
            itemSellLabel.setText("");
        }
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

    /**
     * Make the store window
     */
    public static void make() {
        StoreScreen screen = new StoreScreen();
        screen.frame = new JFrame("Store");
        screen.frame.setContentPane(screen.panel1);
        screen.frame.setVisible(true);
        screen.frame.pack();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        itemNameLabel = new JLabel();
    }
}
