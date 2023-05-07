import java.util.Collection;
import java.util.Iterator;
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
        if (!isEmpty()) {
            return first.info;
        }
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
        Iterator itr = c.iterator();

        while(itr.hasNext()){
            add( (T) itr.next());
        }
        return false;
    }

    @Override
    public void clear() {
        first = null;
        ce = 0;

    }

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

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEmpty() {
        return ce == 0;
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
        return ce;
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
