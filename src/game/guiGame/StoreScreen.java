package game.guiGame;

import crops.*;
import game.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreScreen {
    private JPanel panel1;
    private JLabel storeLabel;
    private JButton buyWheatButton;
    private JButton buyMelonButton;
    private JButton buyCactusButton;
    private JButton buySugarCaneButton;
    private JButton buyPumpkinButton;
    private JButton buyMushroomButton;

    private JFrame frame;

    public StoreScreen() {
        buyWheatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.getFarm().addFarmItem(new Wheat());
            }
        });
        buyMushroomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.getFarm().addFarmItem(new Mushroom());
            }
        });
        buyPumpkinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.getFarm().addFarmItem(new Pumpkin());
            }
        });
        buySugarCaneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.getFarm().addFarmItem(new SugarCane());
            }
        });
        buyCactusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.getFarm().addFarmItem(new Cactus());
            }
        });
        buyMelonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.getFarm().addFarmItem(new Melon());
            }
        });
    }

    public static void make() {
        StoreScreen screen = new StoreScreen();
        screen.frame = new JFrame("ASS");
        screen.frame.setContentPane(screen.panel1);
        screen.frame.setVisible(true);
        screen.frame.pack();
    }
}
