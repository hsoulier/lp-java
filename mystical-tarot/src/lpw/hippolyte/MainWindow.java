package lpw.hippolyte;

import lpw.hippolyte.arcane.Arcane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class MainWindow {

    private static ArrayList<Arcane> deck;
    private static JFrame window;
    private static JPanel viewArcanes, editArcanePanel;
    private static JLabel addArcane, nameLab, descLab, imgLab, delLab;
    private static JTextField nameInput, imgInput;
    private static JTextArea descInput;
    private static JButton addArcaneBtn, delArcaneBtn;
    private static JComboBox<Arcane> delInput;
    private static GridBagConstraints cFrame;
    private static GridBagConstraints c;

    public static void main(String[] args) {
        deck = new ArrayList<>();
        deck.add(new Arcane(1, "Le Bateleur", "description du magicien", "./img.png"));
        deck.add(new Arcane(2, "Le magicien", "description du magicien", "./img.png"));
        deck.add(new Arcane(3, "Le Spectre", "description du magicien", "./img.png"));
        deck.add(new Arcane(4, "L'ancien", "description du magicien", "./img.png"));


        // Init Window
        window = new JFrame("Tarot Divinatoire");
        window.setSize(1200, 600);
        window.setLayout(new GridBagLayout());
        viewArcanes = new JPanel(new BorderLayout());
        editArcanePanel = new JPanel(new GridBagLayout());
        cFrame = new GridBagConstraints();
        c = new GridBagConstraints();

        // Init JLabel
        addArcane = new JLabel("Créer une Arcane".toUpperCase(Locale.ROOT));
        nameLab = new JLabel("Nom de l'Arcane");
        descLab = new JLabel("Description");
        imgLab = new JLabel("Chemin de l'image de l'Arcane");
        delLab = new JLabel("Supprimer une Arcane".toUpperCase(Locale.ROOT));

        // Init JFormComponent
        nameInput = new JTextField();
        descInput = new JTextArea();
        imgInput = new JTextField();
//        JComboBox delInput = new JComboBox(deck.toArray());
        delInput = renderComboBox();
        // Init JButton
        addArcaneBtn = new JButton("Ajouter l'Arcane");
        delArcaneBtn = new JButton("Supprimer l'Arcane");

        // Display JComponents
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(40, 10, 20, 0);
        c.gridwidth = 2;
        addArcane.setFont(new Font(addArcane.getName(), Font.PLAIN, 20));
        delLab.setFont(new Font(delLab.getName(), Font.PLAIN, 20));
        editArcanePanel.add(addArcane, displayComponent(0, 0));

        c.insets = new Insets(0, 10, 5, 0);
        editArcanePanel.add(nameLab, displayComponent(0, 1));
        editArcanePanel.add(nameInput, displayComponent(0, 2));
        editArcanePanel.add(descLab, displayComponent(0, 3));
        editArcanePanel.add(descInput, displayComponent(0, 4));
        editArcanePanel.add(imgLab, displayComponent(0, 5));
        editArcanePanel.add(imgInput, displayComponent(0, 6));
        editArcanePanel.add(addArcaneBtn, displayComponent(0, 7));
        c.insets = new Insets(20, 10, 20, 0);
        editArcanePanel.add(delLab, displayComponent(0, 8));
        c.insets = new Insets(0, 10, 5, 0);
        c.gridwidth = 1;
        editArcanePanel.add(delInput, displayComponent(0, 9));
        editArcanePanel.add(delArcaneBtn, displayComponent(1, 9));

        // Listeners
        addArcaneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deck.add(new Arcane(deck.size() + 1, nameInput.getText(), descInput.getText(), imgInput.getText()));
                System.out.println(deck.get(deck.size() - 1));
                if (delInput.getItemCount() != deck.size()) {
                    delInput.removeAllItems();
                    for (Arcane arcane : deck) {
                        delInput.addItem(arcane);
                    }
                }
            }
        });
        delArcaneBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "";
                if (delInput.getSelectedIndex() != -1) {
                    data = "" + delInput.getItemAt
                            (delInput.getSelectedIndex());
                }
                for (int i = 0; i < deck.size(); i++) {
                    if (data.split(", ")[1].equals(deck.get(i).getName())) deck.remove(deck.get(i));
                }
                if (delInput.getItemCount() != deck.size()) {
                    delInput.removeAllItems();
                    for (Arcane arcane : deck) {
                        delInput.addItem(arcane);
                    }
                }
                System.out.println(deck);
            }
        });

        // Styling
        descInput.setBorder(BorderFactory.createLineBorder(Color.black));
        nameInput.setBorder(BorderFactory.createLineBorder(Color.black));
        imgInput.setBorder(BorderFactory.createLineBorder(Color.black));

        // Display Window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(viewArcanes);
        window.add(editArcanePanel);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    private static JComboBox<Arcane> renderComboBox() {
        DefaultComboBoxModel<Arcane> arcanesNames = new DefaultComboBoxModel<>();
        for (Arcane arcane : deck) {
            arcanesNames.addElement(arcane);
        }
        return new JComboBox<Arcane>(arcanesNames);
    }

    private static GridBagConstraints displayComponent(int gridx, int gridy) {
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = gridx;
        c.gridy = gridy;
        return c;
    }
}
