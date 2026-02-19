/*
Ejercicio 1
Implemente los métodos indicados del esqueleto de Lista desarrollado en Teoría (
void insertFront(T), T extractFront(), boolean isEmpty(), int size(),
String toString). Agregar también el método: T get(index).

 */

import java.util.Iterator;

public class MySimpleLinkedList<T extends Comparable <T>> implements Iterable<T> {

    private Node<T> first;
    private int size;

    public MySimpleLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info,null);
        tmp.setNext(this.first);
        this.first = tmp;

        this.size++;
    }

    public void insertOrdered(T info) {
        Node<T> tmp = this.first;
        Node<T> actual = new Node<T>(info,null);

        if(tmp == null || tmp.getInfo().compareTo(info) >= 0 ) {
            insertFront(info);
        } else if(tmp.getNext() == null) {
            tmp.setNext(actual);
        } else {
            while(tmp.getNext().getInfo().compareTo(info) <= 0) {
                tmp = tmp.getNext();
            }
            if(tmp.getNext() == null) {
                tmp.setNext(actual);
            } else {
                Node<T> aux = tmp.getNext();
                tmp.setNext(actual);
                actual.setNext(aux);
            }

        }
    }

    public T extractFront() {
        try {

            Node<T> tmp = this.first;

            this.first = this.first.getNext();

            if(this.first != null) {
                this.size--;
            }

            return tmp.getInfo();
        }
        catch (Exception e) {
            //System.out.print("La lista esta vacia, el primero es ");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public T get(int index) {
        int i = 1;

        if(index < 1 || index >= this.size) {
            return null;
        }

        Iterator<T> iterator = this.iterator();
        while(index != i){

            T next = iterator.next();
            i++;
        }
        return iterator.next();

    }

    public int size() {
        return this.size;
    }

    public int indexOf(T info) {
        //Me pasan por parametro la info.
        int index = 1;

        //variable para llevar el nodo
        Node<T> tmp = this.first;

        if(tmp == null) {
            return -1;
        }

        while(tmp.getInfo() != info && index < this.size) {
            tmp = tmp.getNext();
            index++;
        }
        if(tmp.getInfo() == info) {
            return index;
        }

        return -1;

    }

    @Override
    public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("[");

    Iterator<T> iterator = this.iterator();

    while(iterator.hasNext()) {
        sb.append(iterator.next());
        if(iterator.hasNext()) {
            sb.append(", ");
        }
    }

    sb.append("]");
    return sb.toString();

    }

    @Override
    public Iterator<T> iterator() {
        return new Myiterator<>(this.first);
    }


}