package lpw.hippolyte;

import lpw.hippolyte.entity.*;
import lpw.hippolyte.entity.races.Warrior;

import java.util.*;

public class MapGame {
    final int ROWS = 10;
    final int COLS = 20;
    final String emptyCell = "   ";
    private final Obstacle obstacle;
    private final Monster monster;
    private final Warrior player;
    private boolean isFight = false;
    private final String[][] map = new String[ROWS][COLS];
    private final ArrayList<int[]> listEntitiesPosition = new ArrayList<>();

    public MapGame(Warrior player, Obstacle obstacle, Monster monster) {
        this.player = player;
        this.obstacle = obstacle;
        this.monster = monster;
        this.listEntitiesPosition.add(player.getPosition());
        this.listEntitiesPosition.add(obstacle.getPosition());
        this.listEntitiesPosition.add(monster.getPosition());
        generateMap();
    }

    public void generateMap() {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (row == 0 || col == 0 || col == COLS - 1 || row == ROWS - 1) {
                    map[row][col] = "...";
                } else {
                    map[row][col] = emptyCell;
                }
            }
        }
        AddEntities();
    }

    private void AddEntities() {
        int y;
        int x;
        String intersectionPlayer = player.isIntersect(obstacle, monster);

        for (int i = 0; i < listEntitiesPosition.size(); i++) {
            String entity;

            if (intersectionPlayer == "obstacle") {
                isFight = true;
                switch (i) {
                    case 0 -> entity = " X ";
                    case 1 -> entity = " ⯏ ";
                    default -> entity = " M ";
                }

            } else if (intersectionPlayer == "monster") {
                isFight = true;
                switch (i) {
                    case 0 -> entity = " X ";
                    case 1 -> entity = " O ";
                    default -> entity = " ⯏ ";
                }
            } else {
                isFight = false;
                switch (i) {
                    case 0 -> entity = " X ";
                    case 1 -> entity = " O ";
                    default -> entity = " M ";
                }
            }
            y = listEntitiesPosition.get(i)[0];
            x = listEntitiesPosition.get(i)[1];
            map[x][y] = entity;
        }
        if (isFight) {
            Enemy fightWith;
            if (intersectionPlayer == "obstacle") {
                fightWith = this.obstacle;
            } else {
                fightWith = this.monster;
            }
            System.out.println("Un combat est engagé");
            while (!(fightWith.isDead())) {
                player.attack(fightWith);
                fightWith.attack(player);
                System.out.println("pts de vie adversaire " + fightWith.getLife());
                System.out.println("pts vie j1 " + player.getLife());
                if (fightWith.isDead()) {
                    System.out.println("Combat fini, l'ennemi a été tué");
                    System.out.println("Il reste " + player.getLife() + " pts de vie");
                }
                if (player.isDead()) {
                    System.out.println("Le joueur est mort");
                    System.exit(1);
                }
            }
        }
        printMap();
    }

    public void updateEntities(String direction) {
        int[] playerPos = listEntitiesPosition.get(0);
        map[playerPos[1]][playerPos[0]] = emptyCell;
        switch (direction) {
            case "q" -> playerPos[0] = ((playerPos[0] - 1) > 0) ? playerPos[0] - 1 : playerPos[0];
            case "d" -> playerPos[0] = ((playerPos[0] + 2) < ROWS) ? playerPos[0] + 1 : playerPos[0];
            case "z" -> playerPos[1] = ((playerPos[1] - 1) > 0) ? playerPos[1] - 1 : playerPos[1];
            default -> playerPos[1] = ((playerPos[1] + 2) < COLS) ? playerPos[1] + 1 : playerPos[1];
        }
        listEntitiesPosition.set(0, playerPos);
        AddEntities();
    }

    private void printMap() {
        for (String[] row : map) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
        System.out.println("\n\n\n\n");
    }

}
