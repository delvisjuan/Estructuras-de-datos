package Grafos;

import java.util.ArrayList;
import java.util.List;

public class GrafoM<T> {
    private int matriz[][];
    private Object[] vertices;

    public GrafoM(int n, Object[] vertices) {//no se pueden agreagar ni eliminar vertices despues de creado el grafo
        matriz = new int[n][n];
        this.vertices = vertices;
    }

    // implementar
    private int find(Object o) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].equals(o)) {
                return i;
            }
        }

        return -1;
    }

    public boolean conectarArista(Object org, Object dest) {
        int posOrigen = find(org);
        int posDest = find(dest);

        if (posDest != -1 && posOrigen != -1) {
            matriz[posOrigen][posDest] = 1;
            return true;
        }

        return false;
    }

    public boolean eliminarArista(Object org, Object dest) {
        int posOrigen = find(org);
        int posDest = find(dest);

        if (posDest != -1 && posOrigen != -1) {
            matriz[posOrigen][posDest] = 0;
            return true;
        }

        return false;
    }

    // implementar
    public boolean exist(Object org) {
        return (find(org) != -1);
    }

    // implementar
    public boolean isAdy(Object a, Object b) {
        int org = find(a);
        int dest = find(b);

        if(org == -1 || dest == -1)
            return false;

        return (matriz[org][dest] == 1);
    }

    // implementar
    // cantidad de aristas
    public int size() {
        int count = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] == 1)
                    count++;
            }
        }

        return count;
    }

    // implementar
    // cantidad de vertices
    public int order() {
        return vertices.length;
    }

    // implementar
    public List<Object> findAdy(Object o) {
        List<Object> ady = new ArrayList<>();
        int org = find(o);

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[org][i] == 1) {
                ady.add(vertices[i]);
            }
        }
        return ady;
    }
    // implementar
    public int findAdy2(Object o) {
        int count = 0;
        int org = find(o);

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[org][i] == 1) {
                count++;
            }
        }
        return count;
    }
}
