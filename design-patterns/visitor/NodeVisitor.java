package visitor;

import offering.Offering;
import offering.Trading;

public abstract class NodeVisitor {
    public abstract void visitTrading(Trading trading);

    public abstract void visitOffering(Offering offering);
}
