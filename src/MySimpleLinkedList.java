/*
Ejercicio 1
Implemente los métodos indicados del esqueleto de Lista desarrollado en Teoría (
void insertFront(T), T extractFront(), boolean isEmpty(), int size(),
String toString). Agregar también el método: T get(index).

 */

import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T> {

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

    @Override
    public String toString() {
        return this.first.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Myiterator<>(this.first);
    }


}