package visitor;

import java.io.IOException;

import offering.Trading;

/**
 * Reminder class will trigger the visitor's visit functions
 */
public class Reminder {
    private final NodeVisitor visitor;

    public Reminder() {
        this.visitor = new ReminderVisitor();
    }

    /**
     * trigger for the visitor's visit function
     * 
     * @throws IOException
     */
    public void remind() throws IOException {
        visitor.visitTrading(new Trading());
    }
}
