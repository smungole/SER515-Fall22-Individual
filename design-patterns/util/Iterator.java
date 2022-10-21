package util;

/**
 * Interface for the Iterator Design Pattern
 */
public interface Iterator<T> {
    /**
     * Checks if there is another element in the list.
     * 
     * @return
     */
    public boolean hasNext();

    /**
     * Returns the next element from the list
     * 
     * @return
     */
    public T next();

    /**
     * Resets the iterator head to the starting position of the list
     */
    public void moveToHead();

    /**
     * Removes element at the given index from the list
     * 
     * @param index
     */
    public void remove(int index);
}
