import java.util.Iterator;
import java.util.NoSuchElementException;

public class Myiterator <T> implements Iterator<T> {

    private Node<T> cursor;

    public Myiterator(Node<T> cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean hasNext() {
        return cursor != null;
    }

    @Override
    public T next() {

        if (!hasNext()) {
            throw new NoSuchElementException();
        }


        T info = this.cursor.getInfo();

        this.cursor = this.cursor.getNext();

        return info;
    }


}
