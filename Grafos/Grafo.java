package Grafos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Grafo<T> {

    private Map<T, List<T>> grafo;


    public Grafo() {
        grafo = new HashMap<>();
    }

    public void addVertice(T vertice){
        grafo.put(vertice, new LinkedList<T>());
    }

    public void addArista(T origen, T destino){
        if(!grafo.containsKey(origen))
            addVertice(origen);
        if(!grafo.containsKey(destino))
            addVertice(destino);

        //metodo get pide la llave y te devuelve el valor correspondiente a  dicha llave
        grafo.get(origen).add(destino); //para agregar un valor a la lista de adyacencia de un nodo
    }

    public void delVertice(T vertice){
        grafo.remove(vertice);
        
        for (T v : grafo.keySet()) {//keySet retorna una lista con las llaves del mapa(info del nodo)
            grafo.get(v).remove(vertice);
        }
    }

    public void delArista(T origen, T destino){
        grafo.get(origen).remove(destino);

    }

    public List<T> obtenerVertices(){
        return new LinkedList<T>(grafo.keySet());
    }

    public List<T> obtenerAdyacentes(T vertice){
        return new LinkedList<T>(grafo.get(vertice));
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
            for(T w : grafo.get(v)){
                sb.append(w.toString() + " ");
            }         
            sb.append("\n");
        }
        return sb.toString();
    }

    

}
