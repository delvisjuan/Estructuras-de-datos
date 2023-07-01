package Grafos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class GrafoPonderado<T> {

    private class Arista<T> implements Comparable<Arista<T>> {
        T node;
        int peso;

        public Arista(T node, int peso) {
            this.node = node;
            this.peso = peso;
        }

        @Override
        public int compareTo(Arista<T> o) {
            if (this.peso > o.peso)
                return 1;
            if (this.peso < o.peso)
                return -1;
            return 0;
        }

        @Override
        public String toString() {
            return "[" + node + "=>" + peso + "]";
        }

    }

    private Map<T, List<Arista<T>>> grafo;

    public GrafoPonderado() {
        grafo = new HashMap<>();
    }

    public void addVertice(T vertice) {
        grafo.put(vertice, new LinkedList<Arista<T>>());
    }

    public void addArista(T origen, T destino, int peso) {
        if (!grafo.containsKey(origen))
            addVertice(origen);
        if (!grafo.containsKey(destino))
            addVertice(destino);

        // metodo get pide la llave y te devuelve el valor correspondiente a dicha llave
        grafo.get(origen).add(new Arista<T>(destino, peso)); // para agregar un valor a la lista de adyacencia de un
                                                             // nodo
    }

    public void delVertice(T vertice) {
        grafo.remove(vertice);

        for (T v : grafo.keySet()) {// keySet retorna una lista con las llaves del mapa(info del nodo)
            List<Arista<T>> lista = grafo.get(v);
            for (Arista<T> c : lista) {
                if (c.node.equals(vertice))
                    lista.remove(c);
            }
        }

    }

    public void delArista(T origen, T destino) {
        List<Arista<T>> lista = grafo.get(origen);
        for (Arista<T> c : lista) {
            if (c.node.equals(destino))
                lista.remove(c);
        }

    }

    public List<T> obtenerVertices() {
        return new LinkedList<T>(grafo.keySet());
    }

    public List<T> obtenerAdyacentes(T vertice) {
        LinkedList<T> adyacentes = new LinkedList<>();

        for (Arista<T> c : grafo.get(vertice)) {
            adyacentes.add(c.node);
        }

        return adyacentes;
    }

    // Implementar

    public int gradoEntrada(T vertice) {// numeros de nodos desde los que se puede llegar a el
        int grado = 0;

        for (T v : grafo.keySet()) {
            for (Arista<T> c : grafo.get(v)) {
                if (c.node.equals(vertice))
                    grado++;
            }
        }

        return grado;
    }

    public int gradoSalida(T vertice) {// numeros de nodos desde los que se ir desde el
        return grafo.get(vertice).size();
    }

    public Map<T, Integer> caminosMin(T origen) {
        LinkedList<T> visitados = new LinkedList<>();
        PriorityQueue<Arista<T>> cola = new PriorityQueue<>();
        Map<T, Integer> distancias = new HashMap<>();

        for (T v : grafo.keySet()) {
            distancias.put(v, null);
        }

        cola.add(new Arista<>(origen, 0));
        
        distancias.put(origen, 0);

        while (!cola.isEmpty()) {
            Arista<T> aristaActual = cola.poll();
            T nodoActual = aristaActual.node;
            int distanciaActual = aristaActual.peso;

            // Verificar si el nodo actual ya ha sido visitado
            if (visitados.contains(nodoActual)) {
                continue;// detiene la ejecucion de la iteracion actual del bulce y comienza la proxima
                         // iteracion
            }

            // Marcar el nodo actual como visitado
            visitados.add(nodoActual);

            // Obtener las aristas adyacentes al nodo actual
            List<Arista<T>> aristas = grafo.get(nodoActual);

            for (Arista<T> arista : aristas) {
                T nodoDestino = arista.node;
                int pesoArista = arista.peso;

                // Calcular la nueva distancia desde el origen hasta el nodo destino a través
                // del nodo actual
                int nuevaDistancia = distanciaActual + pesoArista;

                // Actualizar la distancia mínima si es menor que la distancia actual almacenada
                // en el mapa
                if (distancias.get(nodoDestino) == null || nuevaDistancia < distancias.get(nodoDestino)) {
                    distancias.put(nodoDestino, nuevaDistancia);

                    // Agregar el nodo destino a la cola de prioridad para considerarlo en los
                    // siguientes pasos
                    cola.add(new Arista<>(nodoDestino, nuevaDistancia));
                }
            }
        }

        return distancias;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T v : grafo.keySet()) {
            sb.append(v.toString() + ":");
            for (Arista<T> c : grafo.get(v)) {
                sb.append(c.toString() + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
