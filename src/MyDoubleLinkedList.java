import java.util.Iterator;

public class MyDoubleLinkedList <T> implements Iterable<T> {

    NodeDouble<T> first;
    int size;

    public MyDoubleLinkedList() {
        first = null;
        size = 0;
    }


    public void insertFront(T info) {
        NodeDouble<T> tmp = this.first;

        if(tmp == null) {
            this.first = new NodeDouble<>(info, null, null);
        } else {
            this.first = new NodeDouble<>(info, null, tmp);

            tmp.setFormer(this.first);
        }
        size++;
    }

    public T extractFront() {
        if(first == null) {
            return null;
        }
        NodeDouble<T> tmp = first;

        first = first.getNext();

        first.setFormer(null);
        size--;
        return tmp.getInfo();
    }

    public boolean isEmpty() {
        return this.first == null;
    }
    // me pasan el indice y lo busco
    public T get(int index) {

        if(index < 0 || index >= size) {
            return null;
        }
        Iterator<T> iterator = this.iterator();

        for(int i = 0; i < index; i++) {
            iterator.next();
        }

        return iterator.next();
    }

    @Override
    public Iterator<T> iterator() {
        return new Myiteratordouble<>(this.first);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        Iterator<T> it = iterator();

        while(it.hasNext()) {
            sb.append(it.next());

            if(it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public int getSize() {
        return size;
    }
}

