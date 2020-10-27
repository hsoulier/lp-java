import java.util.ArrayList;
import java.util.Collections;

public class Joueur {
  private int points;
  private ArrayList<Carte> deck;

  public Joueur(ArrayList<Carte> deck) {
    this.deck = new ArrayList<Carte>(deck);
    this.points = 0;
  }

  /**
   * Tire une carte
   * 
   * @return Carte
   */
  public Carte tirer() {
    Collections.shuffle(deck);
    Carte carteTiree = deck.get(0);
    this.deck.remove(0);
    return carteTiree;
  }

  /**
   * Savoir si le joueur a assez de cartes pour continuer de jouer
   * 
   * @param bataille
   * @return boolean
   */
  public boolean possedeAssez(boolean bataille) {
    if (this.deck.size() > 1) {
      return true;
    }
    if (bataille && this.deck.size() > 2) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Ajouter une carte au paquet
   * 
   * @param carte1
   */
  public void ajouter(Carte carte1, Carte carte2) {
    this.points += 1;
    this.deck.add(this.deck.size(), carte1);
    this.deck.add(this.deck.size(), carte2);
  }

  /**
   * Recupérer le paquet du joueur
   * 
   * @return ArrayList<Carte>
   */
  public ArrayList<Carte> getDeck() {
    return this.deck;
  }

  /**
   * Récupérer les points
   * 
   * @return int
   */
  public int getPoints() {
    return this.points;
  }

}
