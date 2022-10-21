package util;

public interface Iterator<T> {
    public boolean hasNext();

    public T next();

    public void moveToHead();

    public void remove(int index);
}
