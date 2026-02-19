import java.util.Iterator;
import java.util.NoSuchElementException;

public class Myiteratordouble <T> implements Iterator<T> {

    private NodeDouble<T> cursor;

    public Myiteratordouble(NodeDouble<T> cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean hasNext() {

        return this.cursor != null;
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
