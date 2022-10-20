package person;

import menu.MeatProductMenu;
import menu.ProduceProductMenu;
import menu.ProductMenu;

public class Seller extends Person {

    @Override
    public void showMenu() {
        System.out.println("\n     What type of products will you be selling today?");
        System.out.println("          1. Produce Products");
        System.out.println("          2. Meat Products");
        System.out.print("     Please select one of the above: - ");

        String productTypeSelection = System.console().readLine();
        Integer selectedProductMenu;
        try {
            selectedProductMenu = Integer.parseInt(productTypeSelection.trim());
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

}
