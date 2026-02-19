import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Listas desordenadas
        MySimpleLinkedList<Integer> unOrderList1 = new MySimpleLinkedList();

        MySimpleLinkedList<Integer> unOrderList2 = new MySimpleLinkedList();

        //Listas ordenadas
        MySimpleLinkedList<Integer> orderList1 = new MySimpleLinkedList();

        MySimpleLinkedList<Integer> orderList2 = new MySimpleLinkedList();



        //Agregador de nodos a las listas desordenadas

        unOrderList1.insertFront(3);
        unOrderList1.insertFront(1);
        unOrderList1.insertFront(4);
        unOrderList1.insertFront(2);

        unOrderList2.insertFront(5);
        unOrderList2.insertFront(3);
        unOrderList2.insertFront(1);
        unOrderList2.insertFront(4);
        unOrderList2.insertFront(2);


        //Agregador de nodos a las listas ordenadas

        orderList1.insertFront(10);
        orderList1.insertFront(8);
        orderList1.insertFront(5);
        orderList1.insertFront(3);

        orderList2.insertFront(10);
        orderList2.insertFront(9);
        orderList2.insertFront(5);
        orderList2.insertFront(2);


        /*


        //--------------------------------------------------------------------------------- Ejercicio 1 ----------------------------------------------------------------------------------//
        Implemente los métodos indicados del esqueleto de Lista desarrollado en Teoría (
        void insertFront(T), T extractFront(), boolean isEmpty(), int size(),
        String toString). Agregar también el método: T get(index).


         ExtractFront()
         */

      //System.out.println(list.extractFront());
/*
        System.out.println(list.extractFront());

        System.out.println(list.extractFront());

        System.out.println(list.extractFront());
*/

        // isEmpty()

        //System.out.println(list.isEmpty());

        // size()

        //System.out.println(list.size());

        //To String con iterator

        //Iterator<Integer> iterator = list1.iterator();

        /*
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

         */

        /*
         //--------------------------------------------------------------------------------- Ejercicio 2 ----------------------------------------------------------------------------------//

        Considerando la implementación de la lista vinculada realizada en el ejercicio anterior, comparar la
        complejidad computacional contra un array en las siguientes operaciones:

        1. Insertar al principio. La complejidad computacional es O(1).
        2. Buscar un elemento en una posición. La complejidad computacional es O(n).
        3. Determinar la cantidad de elementos. La complejidad computacional es O(1).
        4. Borrar un elemento de una posición determinada. O(n)

         */


        /*
         //--------------------------------------------------------------------------------- Ejercicio 3 ----------------------------------------------------------------------------------//
        A la implementación de la clase Lista realizada en el ejercicio 1, agregue un método
        int indexOf(T), que reciba un elemento y retorne el índice donde está almacenado ese
        elemento, o -1 si el elemento no existe en la lista.

         */

        //System.out.println(list.indexOf(2));


        /*
         //--------------------------------------------------------------------------------- Ejercicio 4 ----------------------------------------------------------------------------------//
        Ejercicio 4A partir de la clase Lista implementada en el ejercicio 1, implemente el patrón
        iterator-iterable, para que la lista sea iterable. ¿Existe alguna ventaja computacional a la hora
        de recorrer la lista de principio a fin si se cuenta con un iterador?

        No existe una ventaja computacional si recorro la lista nodo por nodo o con el iterarador pero la ventaja es que evita errores, es más seguro, más limpio y funciona igual para cualquier colección.

        */

        /*
         //--------------------------------------------------------------------------------- Ejercicio 5 ----------------------------------------------------------------------------------//
        Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,
        suponiendo que:

        a) Las listas están desordenadas y la lista resultante debe quedar ordenada.
        * */

        MySimpleLinkedList<Integer> orderList3 = commonDisordered(unOrderList1, unOrderList2);

        System.out.println(orderList3);

        //b) Las listas están ordenadas y la lista resultante debe mantenerse ordenadas

        MySimpleLinkedList<Integer> orderList4 = commonOrdered(orderList1, orderList2);

        System.out.println(orderList4);

        /*
         //--------------------------------------------------------------------------------- Ejercicio 6 ----------------------------------------------------------------------------------//
        Escriba una función que dadas dos listas construya otra con los elementos que están en la
        primera pero no en la segunda.
         */

        MySimpleLinkedList<Integer> orderList5 = elementsNotEqualToTheSecond(orderList1, orderList2);

        System.out.println(orderList5);



        /*
        //--------------------------------------------------------------------------------- Ejercicio 7 ----------------------------------------------------------------------------------//
        Considerando la implementación de Lista del ejercicio 1, realice una Lista doblemente vinculada.
        ¿Podemos ahora revisar la implementación inicial de nuestra lista para extender su funcionalidad
        y/o bajar la complejidad de los métodos ya implementados?
         */

        MyDoubleLinkedList<Integer> doubleList = new MyDoubleLinkedList<>();

        doubleList.insertFront(10);
        doubleList.insertFront(8);
        doubleList.insertFront(5);

        System.out.println(doubleList);

        System.out.println(doubleList.getIndex(2));


    }

    private static MySimpleLinkedList<Integer> elementsNotEqualToTheSecond(MySimpleLinkedList<Integer> orderList1, MySimpleLinkedList<Integer> orderList2) {
        MySimpleLinkedList<Integer> result = new MySimpleLinkedList();
        for(int i : orderList1){
            if(!search(i, orderList2)){
                result.insertOrdered(i);
            }
        }
        return result;
    }

    private static MySimpleLinkedList<Integer> commonOrdered(MySimpleLinkedList<Integer> orderList1, MySimpleLinkedList<Integer> orderList2) {

        Iterator<Integer> iterator1 = orderList1.iterator();
        Iterator<Integer> iterator2 = orderList2.iterator();

        MySimpleLinkedList<Integer> result = new MySimpleLinkedList<>();

        if(!iterator1.hasNext() || !iterator2.hasNext()){
            return result;
        }

        int val1 = iterator1.next();
        int val2 = iterator2.next();

        while (true) {
            if (val2 < val1) {
                if(!iterator2.hasNext()){
                    break;
                }
                val2 = iterator2.next();
            }else if (val1 < val2) {
                if(!iterator1.hasNext()){
                    break;
                }
                val1 = iterator1.next();
            } else {

                    result.insertOrdered(val1);

                    if (!iterator1.hasNext() || !iterator2.hasNext()) {
                        break;
                    }

                    val1 = iterator1.next();
                    val2 = iterator2.next();
                }
        }
        return result;
    }

    private static MySimpleLinkedList<Integer> commonDisordered(MySimpleLinkedList<Integer> unOrderList1, MySimpleLinkedList<Integer> unOrderList2) {
        MySimpleLinkedList<Integer> result = new MySimpleLinkedList();

        for(int i : unOrderList1){
            if (search(i, unOrderList2)){
                result.insertOrdered(i);
            }
        }
        return result;
    }

    public static boolean search(int i, MySimpleLinkedList<Integer> list){

        for(int u : list) {
            if (u == i){
                return true;
            }
        }
        return false;
    }




}