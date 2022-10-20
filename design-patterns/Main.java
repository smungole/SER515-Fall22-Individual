import java.io.IOException;

import login.Login;

public class Main {
    public static void main(String[] args) throws IOException {
        // * 1. Initialize Database
        loadDB();

        // * 2. Add Login functionality
        Login.login();

        // TODO: Next steps
        // * 3. Create skeletons for all design patterns
        // * 4. Add implementions for the design patterns
        // * 5. Combine all the design patterns
        // * 6. Add proper documentation and traceability to the design patterns
    }

    /**
     * Loads data from all the text files into memory.
     * 
     * @throws IOException
     */
    private static void loadDB() throws IOException {
        Login.loadBuyers();
        Login.loadSellers();
    }
}