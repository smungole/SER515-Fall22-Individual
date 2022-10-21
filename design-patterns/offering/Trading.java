package offering;

import java.io.IOException;
import util.Iterator;

import visitor.NodeVisitor;

/**
 * Trading class created to show the working of visitor design pattern
 */
public class Trading {
    private final OfferingList offerings;

    public Trading() throws IOException {
        offerings = new OfferingList();
    }

    /**
     * Accepts the visitor's request and is iterating over OfferingList using
     * the iterator design pattern to delegate requests back to visitor for
     * visiting the Offering objects.
     * 
     * @param visitor
     */
    public void accept(NodeVisitor visitor) {
        Iterator<Offering> iterator = offerings.getIterator();
        while (iterator.hasNext()) {
            visitor.visitOffering(iterator.next());
        }
    }
}
