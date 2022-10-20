package product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import menu.ProductMenu;
import person.Person;

public class UserProduct {
    private final Person person;
    private final ProductMenu menu;

    public UserProduct(Person person, ProductMenu menu) {
        this.person = person;
        this.menu = menu;
    }

    public void showMenu() throws IOException {
        menu.showMenu();

        System.out.print("\n\tSelect all the products that you're interested in ");
        System.out.print("\t(eg. 1 3 4) - ");
        String selection = System.console().readLine().trim();

        List<Integer> options = new ArrayList<>();
        for (String s : selection.split(" ")) {
            try {
                options.add(Integer.parseInt(s) - 1);
            } catch (NumberFormatException e) {
                // * do nothing if the selected option is invalid
            }
        }

        List<String> selectedProducts = menu.filterProducts(options);
        if (selectedProducts.isEmpty()) {
            System.out.println("\n\tYou haven't selected any products.");
            return;
        }

        System.out.println("\n\tYou selected the following products:");
        for (int i = 0; i < selectedProducts.size(); i++) {
            String line = String.format("\t\t%d. %s", i + 1, selectedProducts.get(i));
            System.out.println(line);
            UserProductDB.addProduct(person.getName(), selectedProducts.get(i));
        }
        UserProductDB.saveUserProducts();
    }
}
