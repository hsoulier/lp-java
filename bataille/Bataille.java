import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Bataille {
  public static void main(String[] args) {
    ArrayList<Carte> deck = new ArrayList<Carte>();
    for (int couleur = 0; couleur <= 3; couleur++) {
      for (int valeur = 1; valeur <= 13; valeur++) {
        deck.add(new Carte(valeur, couleur));
      }
    }

    Collections.shuffle(deck);

    ArrayList<Carte> deck1 = new ArrayList<Carte>();
    ArrayList<Carte> deck2 = new ArrayList<Carte>();

    for (int i = 0; i < deck.size() / 2; i++) {
      deck1.add(deck.get(i));
      deck2.add(deck.get(i + deck.size() / 2));
    }

    Joueur j1 = new Joueur(deck1);
    Joueur j2 = new Joueur(deck2);

    partieBataille(j1, j2);
    if (j1.getPoints() < j2.getPoints()) {
      System.out.println(String.format("Le Joueur 2 gagne avec %s points", j2.getPoints()));
    } else {
      System.out.println(String.format("Le Joueur 1 gagne avec %s points", j1.getPoints()));
    }

  }

  /**
   * Lancer la partie
   * 
   * @param j1
   * @param j2
   */
  public static void partieBataille(Joueur j1, Joueur j2) {
    Carte carteJ1;
    Carte carteJ2;
    boolean match = true;
    while (match) {
      carteJ1 = j1.tirer();
      carteJ2 = j2.tirer();

      if (carteJ1.comparerA(carteJ2) == 1) {
        j1.ajouter(carteJ1, carteJ2);

      } else if (carteJ1.comparerA(carteJ2) == -1) {
        j2.ajouter(carteJ1, carteJ2);

      } else if (carteJ1.comparerA(carteJ2) == 0) {
        if (j1.possedeAssez(true) && j2.possedeAssez(true)) {
          egaliteBataille(j1, j2, new ArrayList<Carte>(Arrays.asList(carteJ1, j1.tirer(), j1.tirer())),
              new ArrayList<Carte>(Arrays.asList(carteJ2, j2.tirer(), j2.tirer())));
        }
      }

      match = j1.possedeAssez(false) && j2.possedeAssez(false);
    }
  }

  /**
   * Bataille !
   * 
   * @param j1
   * @param j2
   * @param arrJ1
   * @param arrJ2
   */
  public static void egaliteBataille(Joueur j1, Joueur j2, ArrayList<Carte> arrJ1, ArrayList<Carte> arrJ2) {
    int comparator = arrJ1.get(arrJ1.size() - 1).comparerA(arrJ2.get(arrJ2.size() - 1));
    if (comparator == 1) {
      for (int i = 0; i < arrJ1.size(); i++) {
        j1.ajouter(arrJ1.get(i), arrJ2.get(i));
      }
    } else if (comparator == -1) {
      for (int i = 0; i < arrJ2.size(); i++) {
        j2.ajouter(arrJ1.get(i), arrJ2.get(i));
      }
    } else {
      if (j1.possedeAssez(true) && j2.possedeAssez(true)) {
        arrJ1.add(j1.tirer());
        arrJ1.add(j1.tirer());
        arrJ2.add(j2.tirer());
        arrJ2.add(j2.tirer());
        egaliteBataille(j1, j2, arrJ1, arrJ2);
      }
    }
  }

  /**
   * Affiche le deck entier
   * 
   * @param cartes
   */
  public static void printDeck(ArrayList<Carte> cartes) {
    for (int i = 0; i < cartes.size(); i++) {
      System.out.println(cartes.get(i));
    }
  }
}
