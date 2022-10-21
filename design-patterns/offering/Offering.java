package offering;

/**
 * Data Model that stores the orders placed by the user
 */
public class Offering {
    public final String person;
    public final String product;
    public final Integer quantity;
    public final Double price;
    public final long timeStamp;

    public Offering(String person, String product, Integer quantity, Double price) {
        this(person, product, quantity, price, System.currentTimeMillis());
    }

    public Offering(String person, String product, Integer quantity, Double price, long timeStamp) {
        this.person = person;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return String.format("%s:%s:%d:%.2f:%d",
                person,
                product,
                quantity,
                price,
                timeStamp);
    }
}
