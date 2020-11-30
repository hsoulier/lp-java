package lpw.hippolyte;

import java.util.*;

public class MapGame {
    final int WIDTH = 16;
    final int HEIGHT = 8;
    private int[] posPlayer = {1, 1};
    private int[] oldPosPlayer = {1, 1};
    private String[][] map = new String[HEIGHT][WIDTH];

    public MapGame() {
        generateMap();
    }

    public void generateMap() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                boolean borders = y == 0 || x == 0 || x == WIDTH - 1 || y == HEIGHT - 1;
                if (borders) {
                    map[y][x] = ".";
                } else if ((x == posPlayer[0] && y == posPlayer[1])) {
                    map[y][x] = "X";
                } else {
                    map[y][x] = " ";
                }
            }
        }
        if (!checkForValue("X")) {
            map[oldPosPlayer[1]][oldPosPlayer[0]] = "X";
            posPlayer = oldPosPlayer;
        }
        printMap();
    }

    private void printMap() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.print(map[y][x]);
            }
            System.out.println();
        }
    }

    public void movePlayer(String direction) {
        direction.toLowerCase();
        switch (direction) {
            case "z" -> posPlayer[1]--;
            case "s" -> posPlayer[1]++;
            case "q" -> posPlayer[0]--;
            default -> posPlayer[0]++;
        }
        generateMap();
    }

    private boolean checkForValue(String val) {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (map[i][j].equals(val)) return true;
            }
        }
        return false;
    }


}
