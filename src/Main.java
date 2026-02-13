//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MySimpleLinkedList list = new MySimpleLinkedList();



        list.insertFront(2);
        list.insertFront(3);
        list.insertFront(4);

        //Ejercicio 1 ExtractFront()

      System.out.println(list.extractFront());
/*
        System.out.println(list.extractFront());

        System.out.println(list.extractFront());

        System.out.println(list.extractFront());
*/

        //Ejercicio 1 isEmpty()

        System.out.println(list.isEmpty());

        //Ejercicio 1 size()

        System.out.println(list.size());

    }
}