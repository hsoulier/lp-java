package lpw.hippolyte;

import lpw.hippolyte.arcane.Arcane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonAdding implements ActionListener {
    private ArrayList<Arcane> deck;
    private JLabel label;

    public ButtonAdding(ArrayList<Arcane> deck) {
        this.deck = deck;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass() == JButton.class) {
            JButton btn = ((JButton) e.getSource());
            System.out.println(btn.getText());
        }
    }
}
