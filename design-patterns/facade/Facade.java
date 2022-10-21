package facade;

import java.io.IOException;

import login.Login;
import offering.OfferingList;
import person.Person;
import product.UserProduct;
import visitor.Reminder;

public class Facade {
    private Person thePerson;

    public Person getThePerson() {
        return thePerson;
    }

    private UserProduct theUserProduct;

    private Reminder reminder;

    public Facade() {
        reminder = new Reminder();
    }

    public void login() throws IOException {
        thePerson = Login.login();
    }

    public void showProductTypeMenu() throws IOException {
        thePerson.setOfferings(new OfferingList());
        thePerson.showMenu();
    }

    public void showUserProductMenu() throws IOException {
        theUserProduct = new UserProduct(thePerson, thePerson.getOfferings());
        theUserProduct.showMenu();
    }

    public void remind() throws IOException {
        reminder.remind();
    }
}
