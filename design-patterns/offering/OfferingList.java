package offering;

import java.io.IOException;
import java.util.List;

import util.Iterator;
import util.PTBSList;

public class OfferingList implements PTBSList<Offering> {
    private List<Offering> offerings;

    public void add(Offering offering) throws IOException {
        offerings.add(offering);
        OfferingDB.saveOfferings();
    }

    public List<Offering> getOfferings() {
        return offerings;
    }

    public OfferingList() throws IOException {
        OfferingDB.loadOfferings();
        this.offerings = OfferingDB.getOfferings();
    }

    @Override
    public Iterator<Offering> getIterator() {
        return new OfferingIterator();
    }

    private class OfferingIterator implements Iterator<Offering> {
        int index;

        @Override
        public boolean hasNext() {
            return index < offerings.size();
        }

        @Override
        public Offering next() {
            return offerings.get(index++);
        }

        @Override
        public void moveToHead() {
            index = 0;
        }

        @Override
        public void remove(int index) {
            offerings.remove(index);
        }
    }

}
