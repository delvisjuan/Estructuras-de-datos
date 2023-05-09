
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkList<T> implements List<T> {

    private class Node<T> {
        T info;
        Node<T> next = null;

        public Node(T info) {
            this.info = info;
        }
    }

    private class LinkListIterator implements Iterator<T> {
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

    private Node<T> first = null;

    private int size = 0;

    public LinkList() {
    }

    // para agregar un nuevo objeto a la lista en la ultima pos

    @Override
    public boolean add(T info) {
        Node<T> nuevo = new Node(info);

        if (isEmpty()) {
            first = nuevo;

        } else {
            Node<T> aux = first;

            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = nuevo;
        }
        size++;
        return true;
    }

    // para agregar un nuevo objeto dada una pos
    @Override
    public void add(int index, T info) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Posición no válida");

        Node<T> nuevo = new Node<T>(info);

        if (isEmpty()) {
            first = nuevo;
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

        size++;

    }

    // agrega a la lista todos los elementos de una coleccion
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

    // agrega a la lista todos los elementos de una coleccion en una pos dada
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (c == null || c.isEmpty()) {
            return false;
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> prev = null;
        Node<T> aux = first;
        int pos = 0;

        while (pos < index) {
            prev = aux;
            aux = aux.next;
            pos++;
        }

        for (T element : c) {
            Node<T> nuevo = new Node<>(element);
            nuevo.next = aux;

            if (prev == null) {
                first = nuevo;
            } else {
                prev.next = nuevo;
            }
            prev = nuevo;
            size++;
        }

        return true;
    }

    // elimina todos los elementos de la lista
    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    // verifica si el objeto se encuentra en la lista
    @Override
    public boolean contains(Object o) {
        Node<T> aux = first;

        while (aux != null) {
            if (aux.info.equals(o)) {
                return true;
            }
            aux = aux.next;
        }

        return false;
    }

    // verifica si una lista de objetos se encuentra en la lista
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    // obtener la info dada una pos
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (!isEmpty()) {
            Node<T> aux = first;
            int pos = 0;
            while (pos < index) {
                aux = aux.next;
                pos++;
            }

            return aux.info;
        } else
            return null;
    }

    //comprueba si la posicion es valida
    private boolean checkIndex(int index) {
        return (index >= 0 && index < size) ? true : false;
    }

    //retorna un nodo  especifico dado un index
    public Node<T> getNode(int index) {
        if (!checkIndex(index)) {
            throw new ArrayIndexOutOfBoundsException("Index no válido");
        }

        if (first != null) {
            int pos = 0;
            Node<T> aux = first;
            while (pos++ < index) {
                aux = aux.next;
            }
            return aux;
        }

        return null;
    }

    // retorna la primera pos del objeto dado
    @Override
    public int indexOf(Object o) {
        if (!isEmpty()) {
            Node<T> aux = first;
            int pos = 0;
            while (aux != null) {
                if (aux.info.equals(o)) {
                    return pos;
                }
                aux = aux.next;
                pos++;
            }
            return -1;
        } else
            return -1;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkListIterator();
    }

    // retorna la ultima pos del objeto dado
    @Override
    public int lastIndexOf(Object o) {
        if (!isEmpty()) {
            Node<T> aux = first;
            int pos = 0;
            int posRet = -1;
            while (aux != null) {
                if (aux.info.equals(o)) {
                    posRet = pos;
                }
                aux = aux.next;
                pos++;
            }
            return posRet;
        } else
            return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    // elimina el objeto dado
    @Override
    public boolean remove(Object info) {
        Node<T> auxBack = null;
        Node<T> aux = first;
        

        while (aux != null) {
            if (aux.info.equals(info)) {
                if (auxBack != null && aux.next == null) { // eliminer ultima pos
                    auxBack.next = null;
                } else if (auxBack != null) {
                    auxBack.next = aux.next; // eliminer pos intermedia
                } else {
                    first = aux.next; // eliminar primera pos
                }
                aux.next = null;
               
                size--;
                return true;
            } else {
                auxBack = aux;
                aux = aux.next;
            }
        }
        return false;
    }

    // eliminar una pos dada y retornar la info
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (!isEmpty()) {
            T info = null;
            Node<T> auxBack = null;
            Node<T> aux = first;
            int pos = 0;

            while (pos < index) {
                auxBack = aux;
                aux = aux.next;
                pos++;
            }

            if (auxBack != null && aux.next == null) { // eliminer ultima pos
                info =  aux.info;
                auxBack.next = null;

            } else if (auxBack != null) {
                info = aux.info;
                auxBack.next = aux.next; // eliminer pos intermedia
            } else {
                info =  aux.info;
                first = aux.next; // eliminar primera pos
            }

            size--;
            return info;

        } else
            return null;

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

    // cambiar la info de una pos
    @Override
    public T set(int index, T info) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (!isEmpty()) {
            Node<T> aux = first;
            int pos = 0;
            T oldInfo = null;

            while (pos < index) {
                aux = aux.next;
            }

            oldInfo = aux.info;
            aux.info = info;
            return oldInfo;
        } else
            return null;
    }

    @Override
    public int size() {
        return size;

    }

    // retorna una lista entre las posiciones especificadas
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || fromIndex >= size || toIndex > fromIndex || toIndex >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (!isEmpty()) {
            List<T> subList = new LinkList<>();
            while (fromIndex <= toIndex) {
                subList.add(get(fromIndex));
                fromIndex++;
            }
            return subList;
        } else
            return null;
    }

    //guarda la info de la lista en un arreglo
    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node<T> aux = first;
        int i = 0;
        while (aux != null) {
            arr[i++] = aux.info;
            aux = aux.next;
        }
        return arr;
    }

    //guarda la info de la lista en un arreglo dado
    @Override
    public <T> T[] toArray(T[] a) {
        
        if (a.length < size) {
            a = Arrays.copyOf(a, size);
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

}