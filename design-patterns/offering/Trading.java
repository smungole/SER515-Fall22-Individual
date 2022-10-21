package offering;

import java.io.IOException;
import util.Iterator;

import visitor.NodeVisitor;

public class Trading {
    private final OfferingList offerings;

    public Trading() throws IOException {
        offerings = new OfferingList();
    }

    public void accept(NodeVisitor visitor) {
        Iterator<Offering> iterator = offerings.getIterator();
        while (iterator.hasNext()) {
            visitor.visitOffering(iterator.next());
        }
    }
}
