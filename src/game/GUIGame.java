package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIGame {
    private JButton nextButton;
    private JPanel mainPanel;

    public GUIGame() {
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Big Booty Hoes");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Farming Simulator");
        frame.setContentPane(new GUIGame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
