package facade;

import java.io.IOException;

import login.Login;
import offering.OfferingList;
import person.Person;
import product.UserProduct;
import visitor.Reminder;

/**
 * Implementation of the Facade Design Pattern
 */
public class Facade {
    private Person thePerson;

    private UserProduct theUserProduct;

    private Reminder reminder;

    public Facade() {
        reminder = new Reminder();
    }

    public Person getThePerson() {
        return thePerson;
    }

    /**
     * Responsible for logging the user into the PTBS system
     * 
     * @throws IOException
     */
    public void showLogin() throws IOException {
        thePerson = Login.showLogin();
    }

    /**
     * Prompts the user with product type selection
     * 
     * @throws IOException
     */
    public void showProductTypeMenu() throws IOException {
        thePerson.setOfferings(new OfferingList());
        thePerson.showMenu();
    }

    /**
     * Prompts the user with the product choices for creating a new order
     * 
     * @throws IOException
     */
    public void showUserProductMenu() throws IOException {
        theUserProduct = new UserProduct(thePerson, thePerson.getOfferings());
        theUserProduct.showMenu();
    }

    /**
     * Trigger for initiating the Visitor design pattern
     * 
     * @throws IOException
     */
    public void remind() throws IOException {
        reminder.remind();
    }

    public void setThePerson(Person thePerson) {
        this.thePerson = thePerson;
    }

    public UserProduct getTheUserProduct() {
        return theUserProduct;
    }

    public void setTheUserProduct(UserProduct theUserProduct) {
        this.theUserProduct = theUserProduct;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }
}
