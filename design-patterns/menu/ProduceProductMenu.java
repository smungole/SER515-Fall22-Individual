package menu;

import java.util.List;

public class ProduceProductMenu implements ProductMenu {

    private List<String> products;

    public ProduceProductMenu() {
        this.products = ProductDB.getProduceProducts();
    }

    @Override
    public void showMenu() {
        System.out.println("\n     ---------- PRODUCE PRODUCTS ----------");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(String.format("          %d. %s", i + 1, products.get(i)));
        }
        System.out.println("     ---------- x ------------ x ----------");
    }

}
