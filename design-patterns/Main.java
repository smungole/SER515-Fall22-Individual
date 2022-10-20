import java.io.IOException;

import login.Login;
import menu.ProductMenuDB;
import menu.ProductMenu;
import person.Person;
import product.UserProduct;
import product.UserProductDB;

public class Main {
    public static void main(String[] args) throws IOException {
        // * 1. Initialize Database
        loadDB();

        // * 2. Add Login functionality
        System.out.println();
        Person person = Login.login();

        // * 3. Show product type selection menu based on the type of person
        person.showMenu();

        // * 4. Show product options to the user
        ProductMenu menu = person.createProductMenu();
        UserProduct userProduct = new UserProduct(person, menu);
        userProduct.showMenu();
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
}