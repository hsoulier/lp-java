package lpw.hippolyte;

import lpw.hippolyte.arcane.Arcane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;

public class MainWindow {

    private static ArrayList<Arcane> deck;
    private static JFrame window;
    private static JPanel leftPanel, rightPanel, viewPanel, mainPanel, addPanel, delPanel, editPanel;
    private static JLabel addArcane, nameLab, descLab, imgLab, delLab, allArcanesLab, editLab;
    private static JTextField nameInput, imgInput;
    private static JTextArea descInput;
    private static JButton addArcaneBtn, delArcaneBtn, chooseEditBtn, editBtn;
    private static JComboBox<Arcane> selectInput;
    private static GridBagConstraints c;
    private static ArrayList<JPanel> viewsArcanes;

    public static void main(String[] args) {
        deck = new ArrayList<>();
        deck.add(new Arcane(1, "Le Bateleur", "description du magicien", "./img.png"));
        deck.add(new Arcane(2, "Le magicien", "description du magicien", "./img.png"));
        deck.add(new Arcane(3, "Le Spectre", "description du magicien", "./img.png"));
        deck.add(new Arcane(4, "L'ancien", "description du magicien", "./img.png"));


        // ** Init Window
        window = new JFrame("Tarot Divinatoire");
        window.setSize(1200, 600);
        c = new GridBagConstraints();

        // ** Init JPanel
        // General JPanel
        mainPanel = new JPanel();
        leftPanel = new JPanel(new GridBagLayout());
        viewPanel = new JPanel(new GridLayout(6, 4));
        rightPanel = new JPanel(new GridBagLayout());
        addPanel = new JPanel(new GridLayout(8, 1, 10, 10));
        delPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        editPanel = new JPanel(new GridLayout(11, 1, 10, 10));


        JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);


        // JPanel Arcane
        for (int i = 0; i < deck.size(); i++) {
            viewPanel.add(new JButton("Test " + i));
        }

        // ** Init JLabel
        addArcane = new JLabel("Créer une Arcane".toUpperCase(Locale.ROOT));
        nameLab = new JLabel("Nom de l'Arcane");
        descLab = new JLabel("Description");
        imgLab = new JLabel("Chemin de l'image de l'Arcane");
        delLab = new JLabel("Supprimer une Arcane".toUpperCase(Locale.ROOT));
        allArcanesLab = new JLabel("Les Arcanes".toUpperCase(Locale.ROOT));
        editLab = new JLabel("Editer une Arcane".toUpperCase(Locale.ROOT));

        // ** Init JFormComponent
        nameInput = new JTextField();
        descInput = new JTextArea();
        imgInput = new JTextField();
        selectInput = renderComboBox();
        JTextField  = new JTextField();
        descInput = new JTextArea();
        imgInput = new JTextField();
        selectInput = renderComboBox();

        // ** Init JButton
        addArcaneBtn = new JButton("Ajouter l'Arcane");
        delArcaneBtn = new JButton("Supprimer l'Arcane");
        chooseEditBtn = new JButton("Chosir l'Arcane");
        editBtn = new JButton("Editer l'Arcane");

        // ** Display JComponents
        c.insets = new Insets(20, 10, 20, 10);
        c.fill = GridBagConstraints.BOTH;

        // Left Panel
        allArcanesLab.setFont(new Font(allArcanesLab.getName(), Font.PLAIN, 20));
        leftPanel.add(allArcanesLab, displayComponent(0, 0));
        leftPanel.add(viewPanel, displayComponent(0, 1));

        // Right Panel
        rightPanel.add(tabs);
        c.gridwidth = 1;
        addArcane.setFont(new Font(addArcane.getName(), Font.PLAIN, 20));
        delLab.setFont(new Font(delLab.getName(), Font.PLAIN, 20));
        editLab.setFont(new Font(editLab.getName(), Font.PLAIN, 20));
        addPanel.add(addArcane);
        addPanel.add(nameLab);
        addPanel.add(nameInput);
        addPanel.add(descLab);
        addPanel.add(descInput);
        addPanel.add(imgLab);
        addPanel.add(imgInput);
        addPanel.add(addArcaneBtn);

        delPanel.add(delLab);
        delPanel.add(selectInput);
        delPanel.add(delArcaneBtn);

        editPanel.add(editLab);
        editPanel.add(selectInput);
        editPanel.add(new JComboBox<String>(new String[]{"Nom", "Description", "Image"}));
        editPanel.add(chooseEditBtn);
        editPanel.add(nameLab);
        editPanel.add(nameInput);
        editPanel.add(descLab);
        editPanel.add(descInput);
        editPanel.add(imgLab);
        editPanel.add(imgInput);
        editPanel.add(editBtn);

        tabs.addTab("Ajouter", addPanel);
        tabs.addTab("Supprimer", delPanel);
        tabs.addTab("Editer", editPanel);

        // Main Panel
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        // ** Listeners
        addArcaneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deck.add(new Arcane(deck.size() + 1, nameInput.getText(), descInput.getText(), imgInput.getText()));
                System.out.println(deck.get(deck.size() - 1));
                if (selectInput.getItemCount() != deck.size()) {
                    selectInput.removeAllItems();
                    for (Arcane arcane : deck) {
                        selectInput.addItem(arcane);
                    }
                }
            }
        });
        delArcaneBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "";
                if (selectInput.getSelectedIndex() != -1) {
                    data = "" + selectInput.getItemAt
                            (selectInput.getSelectedIndex());
                }
                for (int i = 0; i < deck.size(); i++) {
                    if (data.split(", ")[1].equals(deck.get(i).getName())) deck.remove(deck.get(i));
                }
                if (selectInput.getItemCount() != deck.size()) {
                    selectInput.removeAllItems();
                    for (Arcane arcane : deck) {
                        selectInput.addItem(arcane);
                    }
                }
                System.out.println(deck);
            }
        });

        // ** Styling
        descInput.setBorder(BorderFactory.createLineBorder(Color.black));
        nameInput.setBorder(BorderFactory.createLineBorder(Color.black));
        imgInput.setBorder(BorderFactory.createLineBorder(Color.black));
        mainPanel.setBackground(new Color(35, 35, 35));

        // ** Display Window
        window.add(mainPanel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.pack();
        window.revalidate();
        window.repaint();
        System.out.println(mainPanel.getWidth());
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
