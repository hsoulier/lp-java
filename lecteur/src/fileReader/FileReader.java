package fileReader;

import java.io.*;
import java.nio.charset.StandardCharsets;

public interface FileReader {
    /**
     * Create a BufferedReader to read the file
     * @param file
     * @return BufferedReader
     * @throws FileNotFoundException
     */
    public default BufferedReader openFile(String file) throws FileNotFoundException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
    };

    /**
     * Close BufferedReader to empty the memory
     * @param reader
     * @throws IOException
     */
    public default void closeFile(BufferedReader reader) throws IOException {
        reader.close();
    };
}
