package lpw.hippolyte;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("**** Mini-RPG Game ****\n *** Règles");
        System.out.println("→ Lisibilité de la carte");
        System.out.println("- \"X\" désigne le joueur");
        System.out.println("- \"M\" désigne les monstres");
        System.out.println("- \"O\" désigne les obstacles");
        System.out.println("\n→ Se déplacer dans la map");
        System.out.println("\t Z\n   Q S D");
        System.out.println("Puis appuyer sur Entrée pour valider \n\n\n\n");

        MapGame map = new MapGame();
        Scanner inputDirection = new Scanner(System.in);
        System.out.println("Direction");
        String direction = inputDirection.nextLine();


    }
}
