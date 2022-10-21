package menu;

/**
 * Interface required to implement the Bridge Design Pattern
 */
public interface ProductMenu {
    /**
     * Displays product type menu to the user
     */
    public void showMenu();

    public String valueAt(Integer index);
}
