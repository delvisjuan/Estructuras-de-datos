
public class Pila<T> { // FILO First In Last Out

    private class Node<T> {

        T info;
        Node<T> prev = null;

        public Node(T info) {
            this.info = info;

        }
    }

    private Node<T> top = null;
    private int ce = 0;

    public Pila() {

    }

    // inserta en el top
    public void push(T info) {
        Node<T> nuevo = new Node<T>(info);
        if (isEmpty()) {
            top = nuevo;
        } else {
            nuevo.prev = top;
            top = nuevo;
        }
        ce++;
    }

    // elimina y retorna la info
    public T pop() {
        if (isEmpty()) {
            return null;
        } else {
            T temp = top.info;
            top = top.prev;
            ce--;
            return temp;
        }
    }

    // te dice la cant de elementos de la pila
    public int size() {
        return ce;
    }

    // te devuelve true si esta vacia la pila
    public boolean isEmpty() {
        return ce == 0;
    }
    // retorna la info de la pila en el top

    public T peek() {
        return (isEmpty()) ? null : top.info;
    }

    // Retorna true si contiene el elemento sino false

    public boolean contains(Object o) {
        if (isEmpty()) {
            return false;
        }
        
        Node<T> aux = top;
        while (aux != null) {
            if (aux.info.equals(o)) {
                return true;
            }
            aux = aux.prev;
        }
        return false;

    }

    // imprime la info que tiene el nodo dentro
    public String toString() {
        String salida = "";
        Node<T> aux = top;
        while (aux != null) {
            salida += "\n" + aux.info;
            aux = aux.prev;
        }
        return salida;
    }
}
