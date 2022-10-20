package menu;

import java.util.ArrayList;
import java.util.List;

import util.Util;

public class MeatProductMenu implements ProductMenu {

    private List<String> products;

    public MeatProductMenu() {
        this.products = ProductMenuDB.getMeatProducts();
    }

    @Override
    public void showMenu() {
        System.out.printf(
                "\n\t%s MEAT PRODUCTS %s\n",
                Util.dashes(10),
                Util.dashes(10));

        for (int i = 0; i < products.size(); i++) {
            System.out.println(String.format("\t\t%d. %s", i + 1, products.get(i)));
        }

        System.out.printf(
                "\t%s x %s x %s\n",
                Util.dashes(10),
                Util.dashes(9),
                Util.dashes(10));
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
