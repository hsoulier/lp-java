package lpw.hippolyte;

import lpw.hippolyte.entity.Monster;
import lpw.hippolyte.entity.Obstacle;
import lpw.hippolyte.entity.Player;
import lpw.hippolyte.entity.races.Warrior;

import javax.swing.text.html.parser.Entity;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean quit = false;
        Warrior player = new Warrior();
        Obstacle obstacle = new Obstacle();
        Monster monster = new Monster();

        printRules();

        MapGame map = new MapGame(player, obstacle, monster);
        while (!quit) {
            Scanner inputDirection = new Scanner(System.in);
            System.out.print("Se déplacer avec ZQSD (p pour quitter) : ");
            String direction = inputDirection.nextLine();

            switch (direction) {
                case "p" -> quit = true;
                case "i" -> printRules();
                default -> map.updateEntities(direction);
            }
        }
    }


    public static void printRules() {
        System.out.println("**** Mini-RPG Game ****\n *** Règles");
        System.out.println("→ Lisibilité de la carte");
        System.out.println("- \"X\" désigne le joueur");
        System.out.println("- \"M\" désigne les monstres");
        System.out.println("- \"O\" désigne les obstacles");
        System.out.println("\n→ Se déplacer dans la map");
        System.out.println("\t Z\n   Q S D");
        System.out.println("Puis appuyer sur Entrée pour valider");
        System.out.println("Pour quitter appuyer sur la touche p");
        System.out.println("Pour revoir les informations, appuyer sur la touche i");
    }

}
