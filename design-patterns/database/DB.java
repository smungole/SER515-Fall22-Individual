package database;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * DB is a singleton class which performs common file handling operations for
 * the PTBS system.
 */
public class DB {
    private static final String SEP = File.separator;
    private static DB instance = null;

    private DB() {
    }

    /**
     * Returns the singleton instance of DB class.
     * 
     * @return
     */
    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }

    /**
     * Responsible for reading contents of given text file.
     * 
     * @param fileName
     * @return
     * @throws IOException
     */
    public List<String> read(String fileName) throws IOException {
        Path path = Path.of(String.format("data%s%s", DB.SEP, fileName));
        return Files.exists(path) ? Files.readAllLines(path) : new ArrayList<>();
    }

    /**
     * Responsible for writing contents to given text file.
     * 
     * @param contents
     * @param fileName
     * @throws IOException
     */
    public void write(List<String> contents, String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contents.size(); i++) {
            sb.append(contents.get(i));
            sb.append('\n');
        }

        String content = sb.toString();
        Path path = Path.of(String.format("data%s%s", DB.SEP, fileName));
        Files.writeString(path, content);
    }
}
