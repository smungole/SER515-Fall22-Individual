package menu;

import java.util.List;

public class MeatProductMenu implements ProductMenu {

    private List<String> products;

    public MeatProductMenu() {
        this.products = ProductDB.getMeatProducts();
    }

    @Override
    public void showMenu() {
        System.out.println("\n     ---------- MEAT PRODUCTS ----------");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(String.format("          %d. %s", i + 1, products.get(i)));
        }
        System.out.println("     ---------- x --------- x ----------");
    }

}
