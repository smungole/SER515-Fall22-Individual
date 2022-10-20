import java.io.IOException;

import login.Login;
import menu.ProductMenuDB;
import menu.ProductMenu;
import person.Person;
import product.UserProduct;
import product.UserProductDB;
import util.Util;

public class Main {
    public static void main(String[] args) throws IOException {
        // * 1. Initialize Database
        loadDB();

        // * 2. Add Login functionality
        System.out.println();
        Person person = Login.login();

        while (true) {
            // * 3. Show product type selection menu based on the type of person
            person.showMenu();

            // * 4. Show product options to the user
            ProductMenu menu = person.createProductMenu();
            UserProduct userProduct = new UserProduct(person, menu);
            userProduct.showMenu();

            showEOL(person.getName().length());
        }
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
        UserProductDB.loadUserProducts();
    }

    private static void showEOL(int size) {
        System.out.printf(
                "\n\t%s x %s x %s\n",
                Util.dashes(20),
                Util.dashes(11 + size),
                Util.dashes(20));
    }
}