import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularCollection<E> implements Iterable<E> {

    private E[] q;
    private int n = 0;
    private int capacity = 16;

    public CircularCollection() {
        q = (E[]) new Object[capacity];
    }

    public CircularCollection(int capacity) {
        this.capacity = capacity;
        q = (E[]) new Object[capacity];
    }

    public int size() {
        return n;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public E findByIndex(int ind) {
        if (isEmpty())
            throw new NoSuchElementException("Коллекция пустая");

        if (ind < 0 || ind >= n)
            throw new IndexOutOfBoundsException("Индекс за пределами диапозона");

        return q[ind];
    }

    //добавление
    public void add(E item) {

        if (n < capacity) {
            q[n++] = item;
        } else {
            for (int i = 1; i < n; i++) {
                q[i - 1] = q[i];
            }

            q[n - 1] = item;
        }
    }

    public Iterator<E> iterator() {
        return new CircularColIterator();
    }

    private class CircularColIterator implements Iterator<E> {
        private int i = 0;

        public boolean hasNext() {
            return i < n;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public E next() {
            if (!hasNext()) throw new NoSuchElementException();

            E item = q[i];
            i++;

            return item;
        }
    }
}
