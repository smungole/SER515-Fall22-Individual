package person;

import menu.ProductMenu;

public abstract class Person {
    protected String name;

    public String getName() {
        return name;
    }

    private ProductMenu theProductMenu;

    protected ProductMenu getTheProductMenu() {
        return theProductMenu;
    }

    protected void setTheProductMenu(ProductMenu theProductMenu) {
        this.theProductMenu = theProductMenu;
    }

    public abstract void showMenu();

    public abstract ProductMenu createProductMenu();
}
