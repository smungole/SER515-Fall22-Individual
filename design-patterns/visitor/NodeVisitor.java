package visitor;

import offering.Offering;
import offering.Trading;

/**
 * Abstract class used to incorporte the visiter design pattern.
 */
public abstract class NodeVisitor {
    /**
     * visit the Trading object using the visiter design pattern
     * 
     * @param trading
     */
    public abstract void visitTrading(Trading trading);

    /**
     * visit the Offering object using the visiter design pattern
     * 
     * @param offering
     */
    public abstract void visitOffering(Offering offering);
}
