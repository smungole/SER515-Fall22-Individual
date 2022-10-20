package product;

import java.io.IOException;

import menu.ProductMenu;
import person.Person;
import util.Util;

public class UserProduct {
    private final Person person;
    private final ProductMenu menu;

    public UserProduct(Person person) {
        this.person = person;
        this.menu = person.createProductMenu();
    }

    public void showMenu() throws IOException {
        menu.showMenu();

        boolean repeat = true;
        while (repeat) {
            try {
                String[] placeOrderStrings = person.placeOrderStrings();

                System.out.printf("\t%s", placeOrderStrings[0]);
                Integer selection = Integer.parseInt(System.console().readLine().trim());
                String product = menu.valueAt(selection - 1);
                if (product == null) {
                    throw new NumberFormatException();
                }

                System.out.printf("\t%s", placeOrderStrings[1]);
                Integer quantity = Integer.parseInt(System.console().readLine().trim());
                System.out.printf("\t%s", placeOrderStrings[2]);
                Double price = Double.parseDouble(System.console().readLine().trim());

                orderSummary(placeOrderStrings[3], product, quantity, price);
                repeat = false;
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid selection, please try again");
            }
        }
    }

    private void orderSummary(String label, String product, Integer quantity, Double price) throws IOException {
        System.out.printf(
                "\n\t%s ORDER SUMMARY %s\n",
                Util.dashes(10),
                Util.dashes(10));

        System.out.printf("\t%s\n", label);
        System.out.printf("\t\t- Name: %s\n", product);
        System.out.printf("\t\t- Quantity: %d\n", quantity);
        System.out.printf("\t\t- Price: $%.2f\n", price);

        UserProductDB.addProduct(person.getName(), product);
        UserProductDB.saveUserProducts();
    }
}
