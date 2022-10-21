package person;

import java.io.IOException;

import menu.MeatProductMenu;
import menu.ProduceProductMenu;
import menu.ProductMenu;

public class Seller extends Person {

    public Seller(String name) throws IOException {
        this.name = name;
    }

    @Override
    public void showMenu() throws IOException {
        showOfferings();

        System.out.println("\n\tWhat type of products will you be selling today?");
        System.out.println("\t\t1. Produce Products");
        System.out.println("\t\t2. Meat Products");
        System.out.print("\tPlease select one of the above: - ");

        String productTypeSelection = System.console().readLine();
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

    @Override
    public ProductMenu createProductMenu() {
        return super.getTheProductMenu();
    }

    @Override
    public String[] placeOrderStrings() {
        return new String[] { "Select a product you'd like to make an offering for - ",
                "How much stock do you have? - ",
                "Enter the offerring price (for each unit) - ",
                "You placed a sell order for the following product:" };
    }

}
