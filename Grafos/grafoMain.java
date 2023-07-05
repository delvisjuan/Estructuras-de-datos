package Grafos;

import java.util.Map;

public class grafoMain {
    public static void main(String[] args) {

        // grafo no ponderado
        // Grafo<Character> grafo = new Grafo<>();
        // grafo ponderado
        GrafoPonderado<Character> grafo = new GrafoPonderado<>();

        grafo.addVertice('A');
        grafo.addVertice('B');
        grafo.addVertice('C');
        grafo.addVertice('D');
       

        // Para el no ponderado

        // grafo.addArista('A', 'B');
        // grafo.addArista('A', 'F');
        // grafo.addArista('B', 'C');
        // grafo.addArista('B', 'E');
        // grafo.addArista('C', 'E');
        // grafo.addArista('C', 'D');
        // grafo.addArista('D', 'E');
        // grafo.addArista('D', 'G');
        // grafo.addArista('F', 'E');
        // grafo.addArista('F', 'G');

        // Para el ponderado
        grafo.addArista('A', 'B', 1);
        grafo.addArista('A', 'D', 1);
        grafo.addArista('B', 'D', 3);
        grafo.addArista('C', 'B', 1);
        grafo.addArista('C', 'A', 2);
        grafo.addArista('D', 'C', 2);
        

        Map<Character, Integer> map = grafo.caminosMin('A');

        for (Character c : map.keySet()) {
            System.out.println(c + "=>" + map.get(c));            
        }

        //-----------------------------------------------------
        System.out.println();
        Map<Character, Arista<Character>> map2 = grafo.caminosMinRuta('A');

        for (Character c : map2.keySet()) {
            System.out.println(c + "=>" + map2.get(c));            
        }
    }
}
