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
        for (Vertice v : vertices) {
            if(v.info.equals(o)){
                return v;
            }
        }
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
        Vertice a = find(org);
        Vertice b = find(dest);

        if(a != null && b != null){
            return a.ady.remove(b);
        }
                
        return false;
    }

    //implementar
    public boolean exist(T o){
        return (find(o) != null);
    }

    //implementar
    public boolean isAdy(T a, T b) {
        Vertice aVert = find(a); 
        Vertice bVert = find(b); 

        if(aVert == null || bVert == null){
            return false;
        }

        return aVert.ady.contains(bVert);
    }

    //implementar
    //cantidad de aristas
    public int size() {
        int count = 0;
        for (Vertice v : vertices) {
            count += v.ady.size();
        }
        return count;
    }

    //implementar
    //cantidad de vertices
    public int order() {
        return vertices.size();
    }

    //implementar
    private List<Object> findAdy(T o) {
        Vertice vert = find(o);

        if(vert == null)
            throw new IllegalStateException();
        return vert.ady;
    }
}
