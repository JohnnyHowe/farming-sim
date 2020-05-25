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
    private JButton humbleFarmButton;
    private JButton hardFarmButton;
    private JButton fieldFarmButton;
    private JButton ranchFarmButton;

    public static String finalFarmerName;
    public static String finalFarmName;
    public static int finalDays;

    public static float cropMul;
    public static float animalMul;

    public static boolean startGame = false;

    public IntroScreen() {
        daysSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                updateDaysLabel();
            }
        });
        updateDaysLabel();
        humbleFarmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cropMul = 1;
                animalMul = 1;
                startGame = checkName(getFarmName()) && checkName(getFarmerName());
                setFinals(getFarmerName(), getFarmName(), getNumDays());
            }
        });
        ranchFarmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cropMul = 0.5f;
                animalMul = 2;
                startGame = checkName(getFarmName()) && checkName(getFarmerName());
                setFinals(getFarmerName(), getFarmName(), getNumDays());
            }
        });
        fieldFarmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cropMul = 2;
                animalMul = 0.5f;
                startGame = checkName(getFarmName()) && checkName(getFarmerName());
                setFinals(getFarmerName(), getFarmName(), getNumDays());
            }
        });
        hardFarmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cropMul = 0.5f;
                animalMul = 0.5f;
                startGame = checkName(getFarmName()) && checkName(getFarmerName());
                setFinals(getFarmerName(), getFarmName(), getNumDays());
            }
        });
    }

    private void updateDaysLabel() {
        dayNumberLabel.setText(Integer.toString(getNumDays()));
    }

    public void endLoop() {
        IntroScreen.startGame = true;
    }

    public void run(JFrame frame) {
//        JFrame frame = new JFrame("Farming Simulator");
//        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setContentPane(new IntroScreen().mainPanel);
        frame.pack();

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
//        daysSlider = new JSlider(JSlider.HORIZONTAL, 5, 20, 7);
//        daysSlider.setMajorTickSpacing(5);
//        daysSlider.setMinorTickSpacing(1);
//        daysSlider.setPaintTicks(true);


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

