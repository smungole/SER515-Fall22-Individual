package menu;

import java.util.List;

public interface ProductMenu {
    public void showMenu();

    public List<String> filterProducts(List<Integer> options);
}
