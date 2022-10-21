package offering;

import java.io.IOException;
import java.util.List;

import util.Iterator;
import util.PTBSList;

/**
 * Implementation for the Iterator Design Pattern
 */
public class OfferingList implements PTBSList<Offering> {

    /**
     * Implementation for the iterator
     */
    private class OfferingIterator implements Iterator<Offering> {
        int index;

        /*
         * (non-Javadoc)
         * 
         * @see util.Iterator#hasNext()
         */
        @Override
        public boolean hasNext() {
            return index < offerings.size();
        }

        /*
         * (non-Javadoc)
         * 
         * @see util.Iterator#next()
         */
        @Override
        public Offering next() {
            return offerings.get(index++);
        }

        /*
         * (non-Javadoc)
         * 
         * @see util.Iterator#moveToHead()
         */
        @Override
        public void moveToHead() {
            index = 0;
        }

        /*
         * (non-Javadoc)
         * 
         * @see util.Iterator#remove(int)
         */
        @Override
        public void remove(int index) {
            offerings.remove(index);
        }
    }

    private List<Offering> offerings;

    public OfferingList() throws IOException {
        OfferingDB.loadOfferings();
        this.offerings = OfferingDB.getOfferings();
    }

    public void add(Offering offering) throws IOException {
        offerings.add(offering);
        OfferingDB.saveOfferings();
    }

    public List<Offering> getOfferings() {
        return offerings;
    }

    @Override
    public Iterator<Offering> getIterator() {
        return new OfferingIterator();
    }

}
