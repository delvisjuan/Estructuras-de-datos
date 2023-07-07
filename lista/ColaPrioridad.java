package lista;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class ColaPrioridad<T extends Comparable<T>> implements Queue<T> {

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

    

    public ColaPrioridad() {
    }

    @Override
    public boolean add(T info) {
        Node<T> nuevo = new Node(info);
        if(!isEmpty()){
            Node<T> aux = first;
            Node<T> back = null;
            while(aux != null && aux.info.compareTo(info) <= 0){
                back = aux;
                aux = aux.next;
            }
            back.next = nuevo;
            nuevo.next = aux;
        }else{
            first = nuevo;
            last = first;
        }
        ce++;
        return true;
    }

    @Override
    public T element() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean offer(T e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T poll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T remove() {
        if (!isEmpty()) {
            T info = first.info;
            first = first.next;
            ce--;
            return info;
        }
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
