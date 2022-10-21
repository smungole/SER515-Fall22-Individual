package visitor;

import offering.Offering;
import offering.Trading;

/**
 * Implementation for the Abstract NodeVisitor class
 */
public class ReminderVisitor extends NodeVisitor {

    /*
     * (non-Javadoc)
     * 
     * @see visitor.NodeVisitor#visitTrading(offering.Trading)
     */
    @Override
    public void visitTrading(Trading trading) {
        System.out.println("\t\tTrading visited.");
        trading.accept(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see visitor.NodeVisitor#visitOffering(offering.Offering)
     */
    @Override
    public void visitOffering(Offering offering) {
        System.out.printf("\n\t\tOffering visited: %s = %s",
                offering.person,
                offering.timeStamp);
    }

}
