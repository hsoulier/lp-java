package lpw.hippolyte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenersBtn implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());

        if (e.getActionCommand().equals("Ajouter l'Arcane")) {
            System.out.println("Add Arcane");
        } else if (e.getActionCommand().equals("Supprimer Arcane")) {
            System.out.println("Supp Arcane");
        }
    }
}
