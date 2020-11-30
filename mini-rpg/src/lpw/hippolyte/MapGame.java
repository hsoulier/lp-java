package lpw.hippolyte;

import lpw.hippolyte.entity.*;
import lpw.hippolyte.entity.races.Warrior;

import java.util.*;

public class MapGame {
    final int ROWS = 10;
    final int COLS = 20;
    final String emptyCell = "   ";
    private final String[][] map = new String[ROWS][COLS];
    private final ArrayList<int[]> listEntitiesPosition = new ArrayList<>();

    public MapGame(Warrior player, Obstacle obstacle, Monster monster) {
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
        for (int i = 0; i < listEntitiesPosition.size(); i++) {
            String entity;
            switch (i) {
                case 0 -> entity = " X ";
                case 1 -> entity = " O ";
                default -> entity = " M ";
            }

            x = listEntitiesPosition.get(i)[0];
            y = listEntitiesPosition.get(i)[1];
            map[x][y] = entity;
        }

        printMap();
    }

    public void updateEntities(String direction) {
        int[] playerPos = listEntitiesPosition.get(0);
        map[playerPos[0]][playerPos[1]] = emptyCell;
        switch (direction) {
            case "z" -> playerPos[0] = ((playerPos[0] - 1) > 0) ? playerPos[0] - 1 : playerPos[0];
            case "s" -> playerPos[0] = ((playerPos[0] + 2) < ROWS) ? playerPos[0] + 1 : playerPos[0];
            case "q" -> playerPos[1] = ((playerPos[1] - 1) > 0) ? playerPos[1] - 1 : playerPos[1];
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
    }

}
