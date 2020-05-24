package game.guiGame;

import exceptions.InvalidItemException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.IntToDoubleFunction;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class IntroScreen {
    private JButton nextButton;
    private JPanel mainPanel;
    private JLabel introTitle;
    private JSlider daysSlider;
    private JLabel daysLabel;
    private JLabel dayNumberLabel;
    private JTextField farmNameField;
    private JLabel farmNameLabel;
    private JTextField farmerNameField;
    private JLabel farmerNameLabel;

    public static String finalFarmerName;
    public static String finalFarmName;
    public static int finalDays;

    public static boolean startGame = false;

    public IntroScreen() {
//        nextButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
                // Is the name valid?
//                endLoop();
//                if (checkName(getFarmerName()) && checkName(getFarmName())) {
//                    endLoop();
//                } else {
//                    System.out.println("Bad name lol");
//                }
//            }
//        });
    }

    public void endLoop() {
        IntroScreen.startGame = true;
    }

    public void run() {
        JFrame frame = new JFrame("Farming Simulator");
        frame.setSize(600, 600);
        frame.setContentPane(new IntroScreen().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Intro screen loop
        while (!startGame) {

            boolean check = false;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                check = true;
            }

            if (check && checkName(getFarmerName()) && checkName(getFarmName())) {
                break;
            }
        }

        frame.getContentPane().removeAll();
        frame.repaint();
    }

    public int getNumDays() {
        return daysSlider.getValue();
    }

    public String getFarmerName() {
        return farmerNameField.getText();
    }

    public String getFarmName() {
        return farmNameField.getText();
    }

    public void setFinals(String farmerName, String farmName, int days) {
        finalFarmerName = farmerName;
        finalFarmName = farmName;
        finalDays = days;
    }

    private void createUIComponents() {
        daysSlider = new JSlider(JSlider.HORIZONTAL, 1, 20, 10);
        daysSlider.setMajorTickSpacing(5);
        daysSlider.setMinorTickSpacing(1);
        daysSlider.setPaintTicks(true);
        daysSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                dayNumberLabel.setText(Integer.toString(getNumDays()));
            }
        });

        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setFinals(getFarmerName(), getFarmName(), getNumDays());
                startGame = checkName(getFarmName()) && checkName(getFarmerName());
            }
        });
    }

    /**
     * Is the name valid?
     * Cannot be empty string
     * @param name string to check
     */
    private boolean checkName(String name) {
        return !name.replace(" ", "").equals("");
    }

    public static void main(String[] args) {

    }
}

