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

    private JPanel paddockPanel;
    private ArrayList<JPanel> paddockPanels;
    private JPanel paddockPanel0;
    private JPanel paddockPanel1;
    private JPanel paddockPanel2;
    private JPanel paddockPanel3;
    private JPanel paddockPanel4;
    private JPanel paddockPanel5;
    private JPanel paddockPanel6;
    private JPanel paddockPanel7;
    private JPanel paddockPanel8;

//    private enum paddockSlots {
//        SLOT0, SLOT1, SLOT2, SLOT3, SLOT4, SLOT5, SLOT6, SLOT7, SLOT8;
//    }
//
//    private JPanel getPaddockPanel(paddockSlots slot) {
//        switch (slot) {
//            case SLOT0: return paddockPanel0;
//            case SLOT1: return paddockPanel1;
//            case SLOT2: return paddockPanel2;
//            case SLOT3: return paddockPanel3;
//            case SLOT4: return paddockPanel4;
//            case SLOT5: return paddockPanel5;
//            case SLOT6: return paddockPanel6;
//            case SLOT7: return paddockPanel7;
//            case SLOT8: return paddockPanel8;
//            default: return paddockPanel0;  // TODO write exception
//        }
//    }

    public MainScreen() {

        paddockPanels = new ArrayList<JPanel>();
        paddockPanels.add(paddockPanel0);
        paddockPanels.add(paddockPanel1);
        paddockPanels.add(paddockPanel2);
        paddockPanels.add(paddockPanel3);
        paddockPanels.add(paddockPanel4);
        paddockPanels.add(paddockPanel5);
        paddockPanels.add(paddockPanel6);
        paddockPanels.add(paddockPanel7);
        paddockPanels.add(paddockPanel8);

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
    }

    /**
     * Draw the items in the paddock panel
     * Draws out everything in the farm paddock items array
     */
    private void drawPaddockPanel() {
        for (int i = 0; i < 9; i ++) {
//            FarmItem item = Game.getFarm().getPaddockItems().get(i);
            JLabel label = new JLabel("HOES");
            paddockPanels.get(i).add(label);
        }
    }

    /**
     * Draw the item onto the paddock panel
     */
    private void drawPaddockItem() {
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

        drawPaddockPanel();
        frame.pack();
    }

    private void createUIComponents() {

        // Paddock Panels
        paddockPanel0 = new JPanel();
        paddockPanel1 = new JPanel();
        paddockPanel2 = new JPanel();
        paddockPanel3 = new JPanel();
        paddockPanel4 = new JPanel();
        paddockPanel5 = new JPanel();
        paddockPanel6 = new JPanel();
        paddockPanel7 = new JPanel();
        paddockPanel8 = new JPanel();
    }
}

