package menu;

import java.util.ArrayList;
import java.util.List;

public class ProduceProductMenu implements ProductMenu {

    private List<String> products;

    public ProduceProductMenu() {
        this.products = ProductMenuDB.getProduceProducts();
    }

    @Override
    public void showMenu() {
        System.out.println("\n\t---------- PRODUCE PRODUCTS ----------");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(String.format("\t\t%d. %s", i + 1, products.get(i)));
        }
        System.out.println("\t---------- x ------------ x ----------");
    }

    @Override
    public List<String> filterProducts(List<Integer> options) {
        List<String> filtered = new ArrayList<>();
        for (Integer option : options) {
            if (option >= 0 && option < products.size()) {
                filtered.add(products.get(option));
            }
        }
        return filtered;
    }

}
