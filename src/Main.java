import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MySimpleLinkedList list = new MySimpleLinkedList();


/*
        list.insertFront(2); //pos 3
        list.insertFront(3); //pos 2
        list.insertFront(4); //pos 1

        //Ejercicio 1 ExtractFront()

      //System.out.println(list.extractFront());
/*
        System.out.println(list.extractFront());

        System.out.println(list.extractFront());

        System.out.println(list.extractFront());
*/

        //Ejercicio 1 isEmpty()

        //System.out.println(list.isEmpty());

        //Ejercicio 1 size()

        //System.out.println(list.size());

        //To String con iterator

        //Iterator<Integer> iterator = list.iterator();

        /*
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

         */

        /*
        Ejercicio 2

        Considerando la implementación de la lista vinculada realizada en el ejercicio anterior, comparar la
        complejidad computacional contra un array en las siguientes operaciones:

        1. Insertar al principio. La complejidad computacional es O(1).
        2. Buscar un elemento en una posición. La complejidad computacional es O(n).
        3. Determinar la cantidad de elementos. La complejidad computacional es O(1).
        4. Borrar un elemento de una posición determinada. O(n)

         */
        /*
        Ejercicio 3
        A la implementación de la clase Lista realizada en el ejercicio 1, agregue un método
        int indexOf(T), que reciba un elemento y retorne el índice donde está almacenado ese
        elemento, o -1 si el elemento no existe en la lista.

         */

        System.out.println(list.indexOf(2));
    }
}