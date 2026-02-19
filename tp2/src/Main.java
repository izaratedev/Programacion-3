package src;

import java.util.ArrayList;


//--------------------------------------------------Trabajo práctico N° 2 - Recursión y ordenamiento---------------------------------------------------------------------//

/*
Trabajo práctico N° 2 - Recursión y ordenamiento
Primera parte
Ejercicio 1
Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado y
responda:
1. ¿Qué complejidad O tiene? (La complejidad en el peor caso)
2. ¿Trae algún problema hacerlo recursivo? ¿Cuál?
3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?

Ejercicio 2
Implemente un algoritmo recursivo para buscar un elemento en un arreglo ordenado
ascendentemente.

Ejercicio 3
Implemente un algoritmo recursivo que convierta un número en notación decimal a su
equivalente en notación binaria.
Recordatorio, por ejemplo convertir el 26 a binario:

Ejercicio 4
Implemente un algoritmo recursivo que presente los primeros N términos de la secuencia de
Fibonacci.
Por ej. los 6 primeros términos son: 0 1 1 2 3 5
 */

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list);

        if(isOrdered(list, 0)){
            System.out.println("Esta ordenada");
        }else {
            System.out.println("No esta ordenada");
        }

        System.out.println(searchElement(list, 0, 1));
    }


    public static boolean isOrdered(ArrayList<Integer> list, int pos){

        if(pos == list.size()-1){
            return true;
        } else if (list.get(pos) < list.get(pos+1)) {
            return isOrdered(list, pos + 1);
        }else {
            return false;
        }
    }

    /*
    Ejercicio 2
    Implemente un algoritmo recursivo para buscar un elemento en un arreglo ordenado
    ascendentemente.
    */
    //Esta es una forma pero es On
    public static boolean searchElement(ArrayList<Integer> list, int pos, int element) {

        if(pos == list.size() || list.get(pos) > element){
            return false;
        }

        if(list.get(pos) != element){
            return searchElement(list, pos + 1, element);
        } else if (list.get(pos) == element) {
            return true;
        }else {
            return false;
        }

    }
}












