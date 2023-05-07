import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Repaso {

    // LinkedList
    // Queue //cola
    // Stack //pila
    //ver si una palabra es un palindromo usando una pila
    public static boolean isPalindromo(String palabra){
        Pila<Character> pila = new Pila<>();
        
        
        for (int i = 0; i < palabra.length(); i++) {
            pila.push(palabra.charAt(i));
        }

        for (int i = 0; i < palabra.length(); i++) {
            if(palabra.charAt(i) != pila.pop()){
                return false;
            } 
        }
        return true;
    }

    //ver si una palabra es un palindromo usando una cola
    public static boolean isPalindromoCola(String plabra){
        Cola<Character> cola = new Cola<>();

        for (int i = plabra.length() - 1; i >= 0; i--) {
            cola.add(plabra.charAt(i));
        }

        for (int i = 0; i < plabra.length(); i++) {
            if(plabra.charAt(i) != cola.remove())
                return false;

        }

        return true;
    }

    //invertir el orden de una pila
    public static <T> Pila<T> invertirPila(Pila<T> entra) {
        Pila<T> devolver = new Pila<>();

        // int size = entra.size();

        // for (int i = 0; i < size ; i++) {
        //     devolver.push(entra.pop());
        // }

        while (entra.size() != 0) {
            devolver.push(entra.pop());
        }

        return devolver;
    }

    //invertir el orden de una cola
    public static <T> Cola<T> invertirCola(Cola<T> cola) {
        Pila<T> pila = new Pila<>();

        while (cola.size() != 0) {
            pila.push(cola.remove());
        }

        while (pila.size() != 0) {
            cola.add(pila.pop());
        }

        return cola;
    }

    //agregar cierta cantidad de numeros aleatorios a una lista dada
    public static void agregarNumerosAleatorios(List<Integer> lista, int cantidad) {
        Random rand = new Random();

        for (int i = 0; i < cantidad; i++) {
            lista.add(rand.nextInt(100));
        }
        
    }
    
    //agregar a una lista(a) solo los numeros positivos que se encuentren en otra lista(b)
    public static void agregarNumerosPositivo(LinkList<Integer> a, LinkList<Integer> b) {
        for (Integer i : b) {
            if(i >= 0){
                a.add(i);
            }
        }       
    }
    //agregar a una lista(a) un maximo de 5 # pos y 5 neg que se encuentren en otra lista(b)
    public static void agregarNumerosPosNeg(LinkList<Integer> a, LinkList<Integer> b) {
        int pos = 0;
        int neg = 0;

        for (Integer i : b) {
            if(i >= 0 && pos < 5){
                a.add(i);
                pos++;
            }
            if(i < 0 && neg < 5){
                a.add(i);
                neg++;
            }
        }       
    }
}
