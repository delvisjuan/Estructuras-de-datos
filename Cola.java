import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

//cola de prioridad es lo mismo menos el metodo add
//FIFO First In First Out
public class Cola<T> implements Queue<T> {

    private class Node<T> {

        private T info;
        private Node<T> next;

        public Node(T info) {
            this.info = info;
            next = null;
        }
    }

    private Node<T> first = null;
    private Node<T> last = null;
    private int ce = 0;

    public Cola() {
    }

    private class ColaIterator implements Iterator<T> {
        private Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T info = current.info;
            current = current.next;
            return info;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // agerga un nuevo elemento a la cola al principio
    @Override
    public boolean add(T info) {
        Node<T> nuevo = new Node<T>(info);
        if (isEmpty()) {
            first = nuevo;
            last = first;
        } else {
            last.next = nuevo;
            last = nuevo;
        }
        ce++;
        return true;
    }

    // retorna la info del 1er elemento si esta vacia la cola una exepcion
    @Override
    public T element() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cola vacia");
        }

        return first.info;
    }

    // KSJDNFLKJAHLSKDVNHDFHLAKJ
    // agerga un nuevo elemento de ser psoible debido a las restricciones de
    // capacidad a la cola al principio
    @Override
    public boolean offer(T e) {
        // TODO Auto-generated method stub
        return false;
    }

    // retorna la informacion del 1er elemento
    @Override
    public T peek() {
        if (!isEmpty()) {
            return first.info;
        }
        return null;
    }

    // elimina el 1er elemento de la cola. Y retorna su informacion. Null si la
    // lista esta vacia
    @Override
    public T poll() {
        if (!isEmpty()) {
            T info = first.info;
            first = first.next;
            ce--;
            return info;
        }
        return null;
    }

    // elimina el 1er elemento de la cola. Y retorna su informacion. excepcion si la
    // lista esta vacia
    @Override
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T info = first.info;
        first = first.next;
        ce--;
        return info;
    }

    // agrega a la cola todos los elementos de una coleccion
    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c == null || c.isEmpty()) {
            return false;
        }
        for (T info : c) {
            add(info);
        }
        return true;
    }

    // vacia la lista
    @Override
    public void clear() {
        first = null;
        ce = 0;

    }

    // verifica si existe el elemento en la cola
    @Override
    public boolean contains(Object o) {
        if (!isEmpty()) {
            Node aux = first;
            while (aux != null) {
                if (o.equals(aux.info)) {
                    return true;
                } else {
                    aux = aux.next;
                }
            }
            return false;
        }
        return false;
    }

    // verifica si existen todos los elementos de la coleccion en la cola
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    // si esta vacia o no
    @Override
    public boolean isEmpty() {
        return ce == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ColaIterator();
    }

    // elimina el elemento que coincida con la informacion dada
    @Override
    public boolean remove(Object info) {
        Node<T> auxBack = null;
        Node<T> aux = first;

        while (aux != null) {
            if (aux.info.equals(info)) {
                if (auxBack != null && aux.next == null) { // eliminer ultima pos
                    last = auxBack;
                    last.next = null;

                } else if (auxBack != null) {
                    auxBack.next = aux.next; // eliminer pos intermedia
                } else {
                    first = aux.next; // eliminar primera pos
                }
                aux.next = null;

                ce--;
                return true;
            } else {
                auxBack = aux;
                aux = aux.next;
            }
        }
        return false;
    }

    // elimina todos los objetos que esten en la coleccion dadda
    @Override
    public boolean removeAll(Collection<?> c) {
        if (!isEmpty() && !c.isEmpty()) {
            boolean retorno = false;
            for (Object o : c) {
                if (remove(o))
                    retorno = true;
            }
            return retorno;
        } else
            return false;
    }

    // la lista conserva solo los elementos que estan en la coleccion
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean cambio = false;
        Node<T> aux = first;

        while (aux != null) {
            if (!c.contains(aux.info)) {
                remove(aux.info);
                cambio = true;
            }
        }

        return cambio;
    }

    @Override
    public int size() {
        return ce;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[ce];
        Node<T> aux = first;
        int i = 0;
        while (aux != null) {
            arr[i++] = aux.info;
            aux = aux.next;
        }
        return arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < ce) {
            a = Arrays.copyOf(a, ce);
        }

        Node<T> aux = (Node<T>) first;

        int i = 0;
        while (aux != null) {
            a[i++] = aux.info;
            aux = aux.next;
        }
        if (i < a.length) {
            a[i] = null;
        }
        return a;
    }

    // Repaso
    // insertar un elemento en una cola en una pos determinada sin alterar el orden
    // actual. (No es un metodo nativo de las colas)
    public void add(int index, T info) {
        if (index < 0 || index > ce)
            throw new IndexOutOfBoundsException("Posición no válida");

        Node<T> nuevo = new Node<T>(info);

        if (isEmpty()) {
            first = nuevo;
            last = first;
        } else if (index != 0) {
            int pos = 0;
            Node<T> auxBack = null;
            Node<T> aux = first;

            while (pos < index) {
                auxBack = aux;
                aux = aux.next;
                pos++;
            }

            nuevo.next = aux;
            auxBack.next = nuevo;

        } else {
            nuevo.next = first;
            first = nuevo;

        }

        ce++;

    }

    // eliminar todas las ocurrencias de un elemento en la cola
    public void removeElemento(Object info) {
        Node<T> auxBack = null;
        Node<T> aux = first;

        while (aux != null) {
            if (aux.info.equals(info)) {
                if (auxBack != null && aux.next == null) { // eliminer ultima pos
                    last = auxBack;
                    last.next = null;
                    
                } else if (auxBack != null) {
                    auxBack.next = aux.next; // eliminer pos intermedia
                } else {
                    first = aux.next; // eliminar primera pos
                }
                aux.next = null;

                ce--;

            } else {
                auxBack = aux;
                aux = aux.next;
            }
        }

    }

}
