package game.guiGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class introScreen {
    private JButton nextButton;
    private JPanel mainPanel;
    private JLabel introTitle;
    private JSlider daysSlider;
    private JLabel daysLabel;
    private JLabel dayNumberLabel;
    private JTextField nameField;
    private JLabel nameLabel;

    public introScreen() {
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, nameField.getText());
                // Is the name valid?
                if (checkName(nameField.getText())) {
                    System.out.println("STARTING GAME!");
                } else {
                    System.out.println("Bad name lol");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Farming Simulator");
        frame.setSize(600, 600);
        frame.setContentPane(new introScreen().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    private void createUIComponents() {
        daysSlider = new JSlider(JSlider.HORIZONTAL, 1, 20, 10);
        daysSlider.setMajorTickSpacing(5);
        daysSlider.setMinorTickSpacing(1);
        daysSlider.setPaintTicks(true);
        daysSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                dayNumberLabel.setText(Integer.toString(daysSlider.getValue()));
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
}

