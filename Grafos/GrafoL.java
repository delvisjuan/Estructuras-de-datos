package Grafos;

import java.util.ArrayList;
import java.util.List;

public class GrafoL<T>{

    private class Vertice<T>{
        T info;
        List<T> ady = new ArrayList<T>();

        public Vertice(T info) {
            this.info = info;
        }

        
    }

    private List<Vertice> vertices = new ArrayList<Vertice>();


    //implementar
    private Vertice find(T o){
        return null;
    }

    public boolean conectarArista(T org, T dest){
        Vertice a = find(org);
        Vertice b = find(dest);

        if(a != null && b != null){
            a.ady.add(b);
            return true;
        }
        
                
        return false;
    }

    public boolean eliminarArista(T org, T dest){
       

        return false;
    }

    //implementar
    public boolean exist(T org){
        return false;
    }

    //implementar
    public boolean isAdy(T a, T b) {
        return false;
    }
    //implementar
    //cantidad de aristas
    public int size() {
        return -1;
    }

    //implementar
    //cantidad de vertices
    public int order() {
        return -1;
    }

    //implementar
    private List<Object> findAdy(T o) {
        return null;
    }
}
