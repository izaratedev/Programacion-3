//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MySimpleLinkedList list = new MySimpleLinkedList();


        //Ejercicio 1
        list.insertFront(2);
        list.insertFront(3);
        list.insertFront(4);

        System.out.println(list.extractFront());

        System.out.println(list.extractFront());

        System.out.println(list.extractFront());

        System.out.println(list.extractFront());

    }
}