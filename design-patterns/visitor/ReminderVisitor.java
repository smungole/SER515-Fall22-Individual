package visitor;

import offering.Offering;
import offering.Trading;

public class ReminderVisitor extends NodeVisitor {

    @Override
    public void visitTrading(Trading trading) {
        System.out.println("\t\tTrading visited.");
        trading.accept(this);
    }

    @Override
    public void visitOffering(Offering offering) {
        System.out.printf("\n\t\tOffering visited: timestamp = %s", offering.timeStamp);
    }

}
