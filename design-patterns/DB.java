import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

// DB is a singleton class which performs common file handling operations for the
// PTBS system.
public class DB {
    private static DB instance = null;

    private DB() {
    }

    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }

    public List<String> read(String fileName) throws IOException {
        Path path = Path.of(String.format("data/%s", fileName));
        return Files.readAllLines(path);
    }

    public void write(List<String> contents, String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contents.size(); i++) {
            sb.append(contents.get(i));
            sb.append('\n');
        }

        Path path = Path.of(String.format("data/%s", fileName));
        Files.writeString(path, sb.toString().stripTrailing());
    }
}