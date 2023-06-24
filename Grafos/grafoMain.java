package Grafos;

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
        grafo.addVertice('E');
        grafo.addVertice('F');
        grafo.addVertice('G');

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
        grafo.addArista('A', 'B', 2);
        grafo.addArista('A', 'F', 1);
        grafo.addArista('B', 'C', 4);
        grafo.addArista('B', 'E', 1);
        grafo.addArista('C', 'E', 4);
        grafo.addArista('C', 'D', 4);
        grafo.addArista('D', 'E', 1);
        grafo.addArista('D', 'G', 5);
        grafo.addArista('F', 'E', 2);
        grafo.addArista('F', 'G', 1);

        System.out.println(grafo);

        grafo.delVertice('E');

        System.out.println(grafo);

    }
}
