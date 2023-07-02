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

    

    private List<Vertice<T>> vertices = new ArrayList<Vertice<T>>();


    //implementar
    private Vertice<T> find(T o){
        for (Vertice<T> v : vertices) {
            if(v.info.equals(o)){
                return v;
            }
        }
        return null;
    }

    public boolean conectarArista(T org, T dest){
        Vertice<T> verticeOrigen = find(org);
        Vertice<T> verticeDestino = find(dest);

        if(verticeOrigen != null && verticeDestino != null){
            verticeOrigen.ady.add(dest);
            // verticeDestino.ady.add(org);//si no es direccional descomentar la linea
            return true;
        }
        
                
        return false;
    }

    public boolean eliminarArista(T org, T dest){
        Vertice<T> verticeOrigen = find(org);
        Vertice<T> verticeDestino = find(dest);

        if(verticeOrigen != null && verticeDestino != null){
            return verticeOrigen.ady.remove(dest);
        }
                
        return false;
    }

    //implementar
    public boolean exist(T vertice){
        return (find(vertice) != null);
    }

    //implementar
    public boolean isAdy(T org, T dest) {
        Vertice<T> orgVert = find(org); 
        Vertice<T> destVert = find(dest); 

        if(orgVert == null || destVert == null){
            return false;
        }

        return orgVert.ady.contains(dest);
    }

    //implementar
    //cantidad de aristas
    public int size() {
        int count = 0;
        for (Vertice<T> v : vertices) {
            count +=  v.ady.size();
        }
        return count;
    }

    //implementar
    //cantidad de vertices
    public int order() {
        return vertices.size();
    }

    //implementar
    //retorna la lista de adyacentes de un vertice
    public List<T> findAdy(T vertice) {
        Vertice<T> vert = find(vertice);

        if(vert == null)
            return null;
            
        return vert.ady;
    }
}
