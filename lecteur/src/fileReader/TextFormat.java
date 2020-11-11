package fileReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

abstract class TextFormat implements FileReader {
    protected String file;

    /**
     * Constructor of abstract Class TextFormat
     * @param file
     */
    public TextFormat(String file) {
        this.file = file;
    }

    /**
     * Read a file from a BufferedReader
     * @return
     * @throws IOException
     */
    public ArrayList readFile() throws IOException {
        BufferedReader reader = openFile(this.file);
        String line = reader.readLine();
        ArrayList<String> content = new ArrayList<String>();
        while (line != null) {
            content.add(line);
            line = reader.readLine();
        }
        closeFile(reader);
        return content;
    };

    /**
     * Read a file line by line from a BufferedReader
     * @return
     * @throws IOException
     */
    public ArrayList readByLineInReverseFile() throws IOException {
        ArrayList<String> content = readFile();
        Collections.reverse(content);
        return content;
    };

    /**
     * Read a file in reverse from a BufferedReader
     * @return
     * @throws IOException
     */
    public ArrayList readInReverseFile() throws IOException {
        ArrayList<String> fileContent = readByLineInReverseFile();
        String reversedString = null;
        for (int i = 0; i < fileContent.size(); i++) {
            reversedString = new StringBuffer(fileContent.get(i)).reverse().toString();
            fileContent.set(i, reversedString);
        }
        return fileContent;
    };

    /**
     * Print an ArrayList of String
     * @param content
     */
    public void printFile(ArrayList<String> content) {
        for (int i = 0; i < content.size(); i++) {
            System.out.println(content.get(i));
        }
    }
}
