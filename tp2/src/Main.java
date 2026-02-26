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

        // System.out.println(searchElement(list, 0, 1));
        //System.out.println(searchElement(0, list.size()-1, 8,list));

        convertBinary(26);

        System.out.println(" ");

        ArrayList<Integer> binario = new ArrayList<>();

        binario = cconvertBinary(26, binario);

        System.out.println(binario);

        fibonacci(6);



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
    //Esta es una forma pero es O(n)
    public static int searchElement(ArrayList<Integer> list, int pos, int element) {

        if(pos == list.size() || list.get(pos) > element){
            return -1;
        }

        if(list.get(pos) != element){
            return searchElement(list, pos + 1, element);
        } else if (list.get(pos) == element) {
            return pos;
        }else {
            return -1;
        }

    }

    //Esta forma de buscar el elemento en una lista ordenada es mas eficiente porque la complejidad computacional es O(log2n)
    public static int searchElement(int start, int end, int element, ArrayList<Integer> list) {


        if(start > end){
            return -1;
        }else{
           int medio = (start + end) / 2;

            if(list.get(medio) > element){
                return searchElement(start, medio-1, element, list);
            }else if(list.get(medio) < element){
                return searchElement(medio+1, end, element, list);
            }else {
                return medio;
            }
        }

    }

    /*
    Ejercicio 3
    Implemente un algoritmo recursivo que convierta un número en notación decimal a su
    equivalente en notación binaria.
    Recordatorio, por ejemplo convertir el 26 a binario:

     */

    public static String convertBinary(int x){
        int resto;
        if(x < 2){
           return String.valueOf(x);
        }else {
            return convertBinary(x / 2) + (x % 2);
        }
    }

    public static ArrayList<Integer> cconvertBinary(int x, ArrayList<Integer> list){

        int resto;
        if(x < 2){
            list.add(x);
        }else {
            resto = x % 2;
            cconvertBinary(x / 2, list);
            list.add(resto);
        }
        return list;
    }
    /*
    Ejercicio 4
    Implemente un algoritmo recursivo que presente los primeros N términos de la secuencia de
    Fibonacci.
    Por ej. los 6 primeros términos son: 0 1 1 2 3 5
            */
    public static void fibonacci(int n){

        imprimirSecuenciaFibonacci(0, 1, n);
    }

    public static void imprimirSecuenciaFibonacci(int a, int b, int n){
        if(n == 0){
            return;
        }else {
            System.out.print(a + " ");
            imprimirSecuenciaFibonacci(b, a+b, n-1);
        }
    }
    /*
    Ejercicio 5
    Dado un arreglo ordenado de números distintos A se desea construir un algoritmo que
    determine si alguno de los elementos de dicho arreglo contiene un valor igual a la posición en la
    cuál se encuentra, es decir, A[i] = i.
    1. Construir un algoritmo recursivo que responda a dicha verificación.
    2. Mostrar la pila de ejecución para la invocación algoritmo([-3, -1, 0, 2, 4, 6, 10])
     */

   //De esta forma encontrar el valor es O(n)
    public static boolean mismoValorPos(ArrayList<Integer> list, int pos){

        if(pos > list.size()-1){
            return false;
        }else {
            if(list.get(pos) == pos){
                return true;
            }else {
                return mismoValorPos(list, pos + 1);
            }
        }
    }

    /*
    Ejercicio 6
    Implemente un algoritmo de ordenamiento por selección en un arreglo.
    Implemente un algoritmo de ordenamiento por burbujeo en un arreglo.
    ● ¿Qué complejidad big-O tienen estos algoritmos?
     */

    public static void ordenamientoSeleccion(ArrayList<Integer> list){
        int fin = list.size();
        for(int i = 0; i < fin -1 ; i++){
            int posMin = i;

            for(int j = i + 1; j < fin; j++){
                if(list.get(posMin) > list.get(j)) {
                    posMin = j;
                }
            }
            int temp = list.get(i);
            list.set(i, list.get(posMin));
            list.set(posMin, temp);

        }
    }

    public static void ordenamientoBurbujeo(ArrayList<Integer> list){
        int fin = list.size();

        for(int i = 0; i < fin -1 ; i++){

            for(int j = 0; j < fin-1-i; j++){

                if(list.get(j) > list.get(j+1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
    }

    public static void ordenamientoBurbujeoPro(ArrayList<Integer> list){
        int n = list.size();
        int i = 0;
        boolean swapped = true;
        while(swapped){
            swapped = false;

            for(int j = 0; j < n-1-i; j++){

                if(list.get(j) > list.get(j+1)) {
                    swapped = true;
                    int temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
            i++;
        }
    }

}












