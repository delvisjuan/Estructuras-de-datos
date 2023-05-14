import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkList<Integer> list = new LinkList<>();
       // List<Integer> list = new DoubleLinkList<>();

        // Repaso.agregarNumerosAleatorios(list, 5);

        // for (Integer a : list) {
        //     System.out.println(a);
        // }

        // List<Integer> lista = new LinkList<>();

        list.add(6);
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(4);

        System.out.println(list.elementoK(3));

        // lista.add(34);
        // lista.add(5432);
        // lista.add(34);
        // lista.add(23);
        // lista.add(124);
        // lista.add(12);
        // lista.add(23);

        // list.addAll(6,lista);
        
        // for (Integer a : list) {
        //     System.out.println(a);
        // }
        
        // list.remove((Integer) 5);
        // System.out.println("\n\n");
        // for (int i = 0; i < list.size(); i++) {
        // System.out.println(list.get(i));
        // }

        // for (Integer in : list) {
        // System.out.println(in);
        // }

        // System.out.println(Notaciones.operar("2+5+6"));

        //determinar si una cadena de caracteres es un palindromo con una pila y una cola

        // System.out.println(Repaso.isPalindromo("reconocer"));
        // System.out.println(Repaso.isPalindromoCola("reconocer"));
    }
}
