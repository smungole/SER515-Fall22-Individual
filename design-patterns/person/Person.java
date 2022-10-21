package person;

import util.Iterator;
import util.Util;

import java.io.IOException;

import menu.ProductMenu;
import offering.Offering;
import offering.OfferingList;

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

    public abstract void showMenu() throws IOException;

    public abstract ProductMenu createProductMenu();

    public abstract String[] placeOrderStrings();

    private OfferingList offerings;

    public OfferingList getOfferings() {
        return offerings;
    }

    public void setOfferings(OfferingList offerings) {
        this.offerings = offerings;
    }

    public void showOfferings() {
        Iterator<Offering> iterator = offerings.getIterator();
        if (iterator.hasNext()) {
            System.out.printf("\n\t%s PAST ORDERS %s\n",
                    Util.dashes(10),
                    Util.dashes(10));
        }

        while (iterator.hasNext()) {
            Offering offering = iterator.next();
            if (offering.person.equals(name)) {
                System.out.printf("\t\t%s\n", offering.product);
                System.out.printf("\t\t- %d\n", offering.quantity);
                System.out.printf("\t\t- $%.2f\n", offering.price);
                System.out.printf("\t%s\n", Util.dashes(5));
            }
        }
    }
}
