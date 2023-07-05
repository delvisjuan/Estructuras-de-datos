package Grafos;

public class Arista<T> implements Comparable<Arista<T>> {

    T node;
    Integer peso;

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
