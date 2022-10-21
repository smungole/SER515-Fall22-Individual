package menu;

import java.io.IOException;
import java.util.List;

import util.Util;

public class ProduceProductMenu implements ProductMenu {

    private List<String> products;

    public ProduceProductMenu() throws IOException {
        ProductMenuDB.loadProducts();
        this.products = ProductMenuDB.getProduceProducts();
    }

    @Override
    public void showMenu() {
        System.out.printf(
                "\n\t%s PRODUCE PRODUCTS %s\n",
                Util.dashes(10),
                Util.dashes(10));

        for (int i = 0; i < products.size(); i++) {
            System.out.println(String.format("\t\t%d. %s", i + 1, products.get(i)));
        }
    }

    @Override
    public String valueAt(Integer index) {
        if (index < 0 || index >= products.size()) {
            return null;
        }
        return products.get(index);
    }

}
