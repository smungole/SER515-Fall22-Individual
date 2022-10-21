import java.io.IOException;

import facade.Facade;
import util.Util;

public class Main {
    public static void main(String[] args) throws IOException {
        // * 1. Initialize Facade object
        Facade facade = new Facade();

        // * 2. Add Login functionality
        System.out.println();
        facade.login();

        while (true) {
            // * 3. Show product type selection menu based on the type of person
            facade.showProductTypeMenu();

            // * 4. Show product options to the user
            facade.showUserProductMenu();

            showEOL(facade.getThePerson().getName().length());

            System.out.println("\t\tReminder triggered:");
            facade.remind();

            showEOL(facade.getThePerson().getName().length());
        }
    }

    private static void showEOL(int size) {
        System.out.printf(
                "\n\t%s x %s x %s\n",
                Util.dashes(20),
                Util.dashes(11 + size),
                Util.dashes(20));
    }
}