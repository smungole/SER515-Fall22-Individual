package util;

/**
 * Makes is necessary for the implementors of Iterator Design Pattern to provide
 * a getter for the iterator object
 */
public interface PTBSList<T> {
    public Iterator<T> getIterator();
}
