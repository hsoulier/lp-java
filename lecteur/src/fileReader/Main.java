package fileReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        FileFormatTxt test = new FileFormatTxt("info.txt");
        FileFormatTxt test2 = new FileFormatTxt("test.txt");
        test.printFile(test.readInReverseFile());
    }
}
