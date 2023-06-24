package Grafos;

public class grafoMain {
    public static void main(String[] args) {
        Grafo<Character> grafo = new Grafo<>();

        grafo.addVertice('A');
        grafo.addVertice('B');
        grafo.addVertice('C');
        grafo.addVertice('D');
        grafo.addVertice('E');
        grafo.addVertice('F');
        grafo.addVertice('G');
       


        grafo.addArista('A', 'B');
        grafo.addArista('A', 'F');
        grafo.addArista('B', 'C');
        grafo.addArista('B', 'E');
        grafo.addArista('C', 'E');
        grafo.addArista('C', 'D');
        grafo.addArista('D', 'E');
        grafo.addArista('D', 'G');
        grafo.addArista('F', 'E');
        grafo.addArista('F', 'G');

        System.out.println(grafo);
    }
}
