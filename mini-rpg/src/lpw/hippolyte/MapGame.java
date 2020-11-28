package lpw.hippolyte;

import java.util.Arrays;

public class MapGame {
    final int WIDTH = 96;
    final int HEIGHT = 36;
    private String[][] map = new String[HEIGHT][WIDTH];

    public MapGame() {
        generateMap();
    }

    private void generateMap() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (y == 0 || x == 0 || x == WIDTH - 1 || y == HEIGHT - 1) {
                    map[y][x] = ".";
                } else if (y == 1 && x == 1) {
                    map[y][x] = "X";
                } else {
                    map[y][x] = " ";
                }
            }
        }
        printMap();
    }

    public void printMap() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.print(map[y][x]);
            }
            System.out.println();
        }
    }
}
