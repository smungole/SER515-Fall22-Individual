package person;

import util.Iterator;
import util.Util;

import java.io.IOException;

import menu.ProductMenu;
import offering.Offering;
import offering.OfferingList;

/**
 * Represents a user in the system, this is a part of the Bridge Design Pattern,
 * as well as the Factory Design Pattern
 */
public abstract class Person {
    protected String name;

    private ProductMenu theProductMenu;

    private OfferingList offerings;

    public String getName() {
        return name;
    }

    /**
     * Displays choices to select the category of Product they'd like to explore
     * 
     * @throws IOException
     */
    public abstract void showMenu() throws IOException;

    /**
     * This is a Factory Design Pattern for the ProductMenu objects.
     * Responsible for creating ProductMenu objects based on the type of user
     * as well the type of product that is selected by the user
     * 
     * @return
     */
    public abstract ProductMenu createProductMenu();

    public abstract String[] placeOrderStrings();

    public OfferingList getOfferings() {
        return offerings;
    }

    public void setOfferings(OfferingList offerings) {
        this.offerings = offerings;
    }

    /**
     * Uses Iterator Design Pattern to display the past orders of the current
     * user
     */
    public void showOfferings() {
        Iterator<Offering> iterator = offerings.getIterator();
        boolean showHeading = true;
        while (iterator.hasNext()) {
            Offering offering = iterator.next();
            if (offering.person.equals(name)) {
                if (showHeading) {
                    System.out.printf("\n\t%s PAST ORDERS %s\n",
                            Util.dashes(10),
                            Util.dashes(10));
                    showHeading = false;
                }

                System.out.printf("\t\t%s\n", offering.product);
                System.out.printf("\t\t- %d\n", offering.quantity);
                System.out.printf("\t\t- $%.2f\n", offering.price);
                System.out.printf("\t%s\n", Util.dashes(5));
            }
        }
    }

    protected ProductMenu getTheProductMenu() {
        return theProductMenu;
    }

    protected void setTheProductMenu(ProductMenu theProductMenu) {
        this.theProductMenu = theProductMenu;
    }
}
