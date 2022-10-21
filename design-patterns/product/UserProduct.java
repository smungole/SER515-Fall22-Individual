package product;

import java.io.IOException;

import menu.ProductMenu;
import offering.Offering;
import offering.OfferingList;
import person.Person;
import util.Util;

/**
 * Displays the product menu from the user selected category and allows users to
 * place orders to the PTBS system
 */
public class UserProduct {
    private final Person person;
    private final ProductMenu menu;
    private final OfferingList offerings;

    public UserProduct(Person person, OfferingList offerings) throws IOException {
        this.person = person;
        this.menu = person.createProductMenu();
        this.offerings = offerings;
    }

    /**
     * Prompts user with product menu and asks for required information to go
     * ahead and place orders
     * 
     * @throws IOException
     */
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

                Offering offering = new Offering(person.getName(), product, quantity, price);
                offerings.add(offering);

                repeat = false;
            } catch (NumberFormatException e) {
                System.out.println("\n\tInvalid selection, please try again\n");
            }
        }
    }

    private void orderSummary(String label, String product, Integer quantity, Double price) {
        System.out.printf(
                "\n\t%s ORDER SUMMARY %s\n",
                Util.dashes(10),
                Util.dashes(10));

        System.out.printf("\t%s\n", label);
        System.out.printf("\t\t- Name: %s\n", product);
        System.out.printf("\t\t- Quantity: %d\n", quantity);
        System.out.printf("\t\t- Price: $%.2f\n", price);
    }
}
