package visitor;

import java.io.IOException;

import offering.Trading;

public class Reminder {
    private final NodeVisitor visitor;

    public Reminder() {
        this.visitor = new ReminderVisitor();
    }

    public void remind() throws IOException {
        visitor.visitTrading(new Trading());
    }
}
