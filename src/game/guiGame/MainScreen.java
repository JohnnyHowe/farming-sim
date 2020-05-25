package game.guiGame;

import animals.Animal;
import crops.Crop;
import exceptions.InvalidActionException;
import exceptions.InvalidItemException;
import exceptions.OutOfActionsException;
import farm.FarmItem;
import game.ActionHandler;
import game.Game;
import items.Bonemeal;
import items.Fertiliser;
import items.Item;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyListener;
import java.lang.reflect.Array;
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
    private JButton endDayButton;
    private JLabel growthLabel;
    private JButton harvestButton;
    private JLabel moneyLabel;
    private JButton shampooButton;
    private JButton brushButton;
    private JButton grainButton;
    private JButton feedBagButton;
    private JPanel playPanel;
    private JButton fertiliserButton;
    private JButton bonemealButton;
    private JPanel tendPanel;
    private JPanel feedPanel;
    private JButton tendNothingButton;
    private JButton playNothingButton;
    private JButton feedNothingButton;
    private JLabel extraInfoLabel0;
    private JLabel extraInfoLabel1;

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
                try {
                    ActionHandler.handle(Game.Actions.TEND_FARM);
                } catch (OutOfActionsException error) {
                    System.out.println("OUT OF ACTIONS");
                }
                updateAll();
            }
        });
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAll();
                System.out.println("Help!");
            }
        });
        endGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endGame();
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeSelectedSlot(1);
                updateAll();
            }
        });
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeSelectedSlot(-1);
                updateAll();
            }
        });
        endDayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ActionHandler.handle(Game.Actions.END_DAY);
                    if (Game.getInstance().getCurrentDay() >= Game.getInstance().getGameLength()) {
                        endGame();
                    }
                    setInfoPanel();
                } catch (OutOfActionsException ignore) {
                }
                updateAll();
            }
        });
        harvestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Crop crop = (Crop) getSelectedItem();   // Button only pressed when it's a crop
                crop.harvest();
                updateAll();
            }
        });
        tendNothingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tendCurrentCrop();
            }
        });
        playNothingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Animal animal = (Animal) getSelectedItem();
                try {
                    ActionHandler.handle(Game.Actions.PLAY_ANIMALS, animal);
                } catch (OutOfActionsException | InvalidActionException ignore) {}
                updateAll();
            }
        });
        feedNothingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Animal animal = (Animal) getSelectedItem();
                try {
                    ActionHandler.handle(Game.Actions.FEED_ANIMALS, animal);
                } catch (OutOfActionsException | InvalidActionException ignore) {}
            updateAll();
            }
        });
        bonemealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tendCurrentCrop(FarmItem.FarmItems.BONEMEAL);
            }
        });
        fertiliserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tendCurrentCrop(FarmItem.FarmItems.FERTILISER);
            }
        });
        brushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tendCurrentAnimal(FarmItem.FarmItems.BRUSH);
            }
        });
        shampooButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tendCurrentAnimal(FarmItem.FarmItems.SHAMPOO);
            }
        });
        feedBagButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tendCurrentAnimal(FarmItem.FarmItems.FEED_BAG);
            }
        });
        grainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tendCurrentAnimal(FarmItem.FarmItems.GRAIN);
            }
        });
    }

    /**
     * Assuming a crop is selected, tend it with no item
     */
    private void tendCurrentCrop() {
        Crop crop = (Crop) getSelectedItem();
        try {
            ActionHandler.handle(Game.Actions.TEND_CROPS, crop);
        } catch (OutOfActionsException | InvalidActionException ignore) {
        }
        updateAll();
    }

    /**
     * Assuming a crop is selected, tend it with the item given
     * @param item item to tend with
     */
    private void tendCurrentCrop(FarmItem.FarmItems item) {
        Crop crop = (Crop) getSelectedItem();
        try {
            ActionHandler.handle(Game.Actions.TEND_CROPS, crop, item);
        } catch (OutOfActionsException | InvalidActionException | InvalidItemException ignore) {
        }
        updateAll();
    }

    /**
     * Assuming an animal is selected, tend to it with item
     * @param item item to tend with
     */
    private void tendCurrentAnimal(FarmItem.FarmItems item) {
        Animal animal = (Animal) getSelectedItem();
        try {
            if (item == FarmItem.FarmItems.BRUSH || item == FarmItem.FarmItems.SHAMPOO) {
                ActionHandler.handle(Game.Actions.PLAY_ANIMALS, animal, item);
            } else {
                ActionHandler.handle(Game.Actions.FEED_ANIMALS, animal, item);
            }
        } catch (OutOfActionsException | InvalidActionException | InvalidItemException ignore) { }
        updateAll();
    }

    /**
     * Update the money label to
     * "Money: $x" where x is the players money
     */
    private void updateMoneyLabel() {
        moneyLabel.setText("Money: $" + Game.getFarmer().getMoney());
    }

    /**
     * Get the selected farm item
     * An empty farmitem is returned if no item is selected
     * @return item in selected paddock slot
     */
    private FarmItem getSelectedItem() {
        ArrayList<FarmItem> items = Game.getInstance().getFarm().getPaddockItems();
        return items.get(currentSlot);
    }

    /**
     * Is there an item in the current slot?
     * @return whether an item is selected
     */
    private boolean itemIsSelected() {
        return currentSlot < Game.getInstance().getFarm().getPaddockItems().size();
    }

    /**
     * Update the shown item in the visible slot
     */
    private void updateCurrentItem() {
        if (itemIsSelected()) {
            FarmItem item = getSelectedItem();
            paddockItemName.setText(item.getName());
            if (item instanceof Crop) {
                Crop crop = (Crop) item;
                showCrop(crop);
            } else {
                showAnimal((Animal) item);
            }
        } else {
            showEmptySlot();
        }
    }

    private void showAnimal(Animal animal) {
        harvestButton.setVisible(false);
        growthLabel.setVisible(true);
        extraInfoLabel0.setVisible(true);
        extraInfoLabel1.setVisible(true);
        growthLabel.setText("Mood: " + animal.getMoodString());
        extraInfoLabel0.setText("Daily Profit: " + animal.getCurrentProfit());
        extraInfoLabel1.setText("Health: " + animal.getHealth());

    }

    private void showCrop(Crop crop) {
        int growthPercent = Math.round(100 * crop.getGrowth() / ((float) crop.getGrowTime()));
        growthLabel.setText("Grown: " + growthPercent + "%");
        extraInfoLabel0.setVisible(false);
        extraInfoLabel1.setVisible(false);
        growthLabel.setVisible(true);
        harvestButton.setVisible(true);
        harvestButton.setText("Harvest for $" + crop.getIncome());
        if (crop.isGrown()) {
            harvestButton.setEnabled(true);
        } else {
            harvestButton.setEnabled(false);
        }
    }

    private void showEmptySlot() {
        paddockItemName.setText("Slot Empty");
        growthLabel.setVisible(false);
        harvestButton.setVisible(false);
        extraInfoLabel0.setVisible(false);
        extraInfoLabel1.setVisible(false);
    }

    private void updateAll() {
        updateMoneyLabel();
        updateItemNumberLabel();
        updateCurrentItem();
        setInfoPanel();
        updateConsumablePanels();
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

    private void endGame() {
        try {
            EndScreen.make();
            ActionHandler.handle(Game.Actions.END_GAME);
        } catch (OutOfActionsException ignore) {
            // Will never happen
        }
    }

    private void setInfoPanel() {
        daysLabel.setText("Day: " + (Game.getInstance().getCurrentDay() + 1) + "/" + Game.getInstance().getGameLength());
        actionsLeftLabel.setText((2 - Game.getInstance().getFarmer().getActions()) + "/2 Daily Actions Left");
        farmerInfoLabel.setText(Game.getFarm().toString());
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
        frame.pack();
    }

    private void updateConsumablePanels() {
        tendPanel.setVisible(false);
        feedPanel.setVisible(false);
        playPanel.setVisible(false);
        if (itemIsSelected()) {
            updateTendPanel();
            updatePlayFeedPanel();
        }
    }

    /**
     * Is item in the consumables inventory?
     * @param item instance of item to check for
     * @return whether item exists in the inventory
     */
    private boolean itemInConsumables(FarmItem.FarmItems item) {
        for (FarmItem i : Game.getFarm().getConsumables()) {
            if (item == i.getEnum()) {
                return true;
            }
        }
        return false;
    }

    private void updateTendPanel() {
        FarmItem item = getSelectedItem();
        if (item instanceof Crop) {
            tendPanel.setVisible(true);

            bonemealButton.setEnabled(false);
            fertiliserButton.setEnabled(false);
            if (itemInConsumables(FarmItem.FarmItems.BONEMEAL)) {
                bonemealButton.setEnabled(true);
            }
            if (itemInConsumables(FarmItem.FarmItems.FERTILISER)) {
                fertiliserButton.setEnabled(true);
            }
        }
    }

    private void updatePlayFeedPanel() {
        FarmItem item = getSelectedItem();
        if (item instanceof Animal) {
            playPanel.setVisible(true);
            feedPanel.setVisible(true);

            brushButton.setEnabled(false);
            shampooButton.setEnabled(false);
            feedBagButton.setEnabled(false);
            grainButton.setEnabled(false);

            if (itemInConsumables(FarmItem.FarmItems.BRUSH)) {brushButton.setEnabled(true);}
            if (itemInConsumables(FarmItem.FarmItems.SHAMPOO)) {shampooButton.setEnabled(true);}
            if (itemInConsumables(FarmItem.FarmItems.FEED_BAG)) {feedBagButton.setEnabled(true);}
            if (itemInConsumables(FarmItem.FarmItems.GRAIN)) {grainButton.setEnabled(true);}
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

