public class Carte {
  public static final String[] VALEURS = { null, "As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame",
      "Roi" };
  public static final String[] COULEURS = { "Trèfle", "Carreau", "Coeur", "Pique" };
  private int valeur;
  private int couleur;

  public Carte(int valeur, int couleur) {
    this.valeur = valeur;
    this.couleur = couleur;
  }

  /**
   * Comparer une carte à une autre
   * 
   * @param autre
   * @return int
   */
  public int comparerA(Carte autre) {
    if (this.valeur == 1 && autre.valeur > 1) {
      return 1;
    } else if (this.valeur > 1 && autre.valeur == 1) {
      return -1;
    } else if (this.valeur < autre.valeur) {
      return -1;
    } else if (this.valeur > autre.valeur) {
      return 1;
    } else {
      return 0;
    }
  }

  /**
   * @return String
   */
  public String toString() {
    return VALEURS[this.valeur] + " de " + COULEURS[this.couleur];
  }

}
