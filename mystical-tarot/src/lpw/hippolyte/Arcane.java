package lpw.hippolyte;

import java.util.TreeMap;

public class Arcane {
    private final String number;
    private final String name;
    private final String image;
    private String description;
    private static final TreeMap<Integer, String> treemap = new TreeMap<>();

    static {
        treemap.put(1000, "M");
        treemap.put(900, "CM");
        treemap.put(500, "D");
        treemap.put(400, "CD");
        treemap.put(100, "C");
        treemap.put(90, "XC");
        treemap.put(50, "L");
        treemap.put(40, "XL");
        treemap.put(10, "X");
        treemap.put(9, "IX");
        treemap.put(5, "V");
        treemap.put(4, "IV");
        treemap.put(1, "I");

    }


    public Arcane(int number, String name, String description, String image) {
        this.number = integerToRoman(number);
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String addDescription(String newDesc) {
        this.description = newDesc;
        return this.description;
    }

    public boolean delete() {
        return true;
    }

    private static String integerToRoman(int number) {
        int l = treemap.floorKey(number);
        if (number == l) {
            return treemap.get(number);
        }
        return treemap.get(l) + integerToRoman(number - l);
    }

    public String toString() {
        return String.format("Vous avez pioché l'Arcane n°%s, %s", this.number, this.name);
    }
}
