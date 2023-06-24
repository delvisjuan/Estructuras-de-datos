package Grafos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GrafoPonderado<T> {

    private class Arista<T>{
        T node;
        int peso;

        public Arista(T node, int peso) {
            this.node = node;
            this.peso = peso;
        }

        @Override
        public String toString() {
            return "[" + node + "=>" + peso +"]";
        }   

    }

    private Map<T, List<Arista<T>>> grafo;


    public GrafoPonderado() {
        grafo = new HashMap<>();
    }

    public void addVertice(T vertice){
        grafo.put(vertice, new LinkedList<Arista<T>>());
    }

    public void addArista(T origen, T destino, int peso){
        if(!grafo.containsKey(origen))
            addVertice(origen);
        if(!grafo.containsKey(destino))
            addVertice(destino);

        //metodo get pide la llave y te devuelve el valor correspondiente a  dicha llave
        grafo.get(origen).add(new Arista<T>(destino, peso)); //para agregar un valor a la lista de adyacencia de un nodo
    }

    public void delVertice(T vertice){
        grafo.remove(vertice);
        
        for (T v : grafo.keySet()) {//keySet retorna una lista con las llaves del mapa(info del nodo)
            for (Arista<T> c : grafo.get(v)) {
                if(c.node.equals(vertice))
                    grafo.get(v).remove(c);
            }
        }
    }

    public void delArista(T origen, T destino){
        for (Arista<T> c : grafo.get(origen)) {
                if(c.node.equals(destino))
                    grafo.get(origen).remove(c);
            }

    }

    public List<T> obtenerVertices(){
        return new LinkedList<T>(grafo.keySet());
    }

    public List<T> obtenerAdyacentes(T vertice){
        LinkedList<T> adyacentes = new LinkedList<>();

        for (Arista<T> c : grafo.get(vertice)) {
            adyacentes.add(c.node);
        }
       
        return adyacentes;
    }
    
    //Implementar

    public int gradoEntrada(T vertice){//numeros de nodos desde los que se puede llegar a el
        int grado =0;

        for (T v : grafo.keySet()) {
            if(grafo.get(v).contains(vertice))
                grado++;
        }

        return grado;
    }

    public int gradoSalida(T vertice){//numeros de nodos desde los que se ir desde el
        return grafo.get(vertice).size();
    }

    public Map<T, Integer> caminosMin(T vertice){
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T v : grafo.keySet()) {
            sb.append(v.toString() + ":"); 
            for(Arista<T> c : grafo.get(v)){
                sb.append(c.toString() + " ");
            }         
            sb.append("\n");
        }
        return sb.toString();
    }

    

}
