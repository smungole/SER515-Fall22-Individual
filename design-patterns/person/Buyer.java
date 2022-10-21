package person;

import java.io.IOException;

import menu.MeatProductMenu;
import menu.ProduceProductMenu;
import menu.ProductMenu;

/**
 * Implementation of the Person abstract class, as a part of Bridge Design
 * Pattern as well as the Factory Design Pattern
 */
public class Buyer extends Person {

    public Buyer(String name) throws IOException {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see person.Person#showMenu()
     */
    @Override
    public void showMenu() throws IOException {
        showOfferings();

        System.out.println("\n\tWhat type of products are you looking to buy today?");
        System.out.println("\t\t1. Produce Products");
        System.out.println("\t\t2. Meat Products");
        System.out.print("\tPlease select one of the above: - ");

        String productTypeSelection = System.console().readLine().trim();
        Integer selectedProductMenu;
        try {
            selectedProductMenu = Integer.parseInt(productTypeSelection) >= 2
                    ? 2
                    : 1;
        } catch (NumberFormatException e) {
            selectedProductMenu = 1;
        }

        if (selectedProductMenu == 1) {
            super.setTheProductMenu(new ProduceProductMenu());
        } else {
            super.setTheProductMenu(new MeatProductMenu());
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see person.Person#createProductMenu()
     */
    @Override
    public ProductMenu createProductMenu() {
        return super.getTheProductMenu();
    }

    @Override
    public String[] placeOrderStrings() {
        return new String[] { "Select a product you'd like to make a bid - ",
                "How many products do you want? - ",
                "Enter the amount you're willing to pay (for each unit) - ",
                "You placed a buy order for the following product:" };
    }

}
