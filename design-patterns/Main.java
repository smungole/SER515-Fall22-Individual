import java.io.IOException;

import login.Login;
import menu.ProductMenuDB;
import menu.ProductMenu;
import person.Person;

public class Main {
    public static void main(String[] args) throws IOException {
        // * 1. Initialize Database
        loadDB();

        // * 2. Add Login functionality
        System.out.println();
        Person person = Login.login();

        // * 3. Show product type selection menu based on the type of person
        person.showMenu();

        ProductMenu menu = person.createProductMenu();
        menu.showMenu();
    }

    /**
     * Loads data from all the text files into memory.
     * 
     * @throws IOException
     */
    private static void loadDB() throws IOException {
        Login.loadBuyers();
        Login.loadSellers();
        ProductMenuDB.loadProducts();
    }
}