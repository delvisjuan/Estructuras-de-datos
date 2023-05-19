package Grafos;

import java.util.List;

public class GrafoM<T>{
    private int matriz[][];
    private Object[] vertices;

    public GrafoM(int n, Object[] vertices) {
        matriz = new int[n][n];
        this.vertices = vertices;
    }

    //implementar
    private int find(Object o){
        return -1;
    }

    public boolean conectarArista(Object org, Object dest){
        int posOrigen = find(org);
        int posDest = find(dest);

        if(posDest != -1 && posOrigen != -1){
            matriz[posOrigen][posDest] = 1;
            return true;
        }
                
        return false;
    }

    public boolean eliminarArista(Object org, Object dest){
        int posOrigen = find(org);
        int posDest = find(dest);

        if(posDest != -1 && posOrigen != -1){
            matriz[posOrigen][posDest] = 0;
            return true;
        }

        return false;
    }

    //implementar
    public boolean exist(Object org){
        return false;
    }

    //implementar
    public boolean isAdy(Object a, Object b) {
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
    private List<Object> findAdy(Object o) {
        return null;
    }
}
