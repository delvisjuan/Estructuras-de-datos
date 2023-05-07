import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoubleLinkList<T> implements List<T> {

    private class Node<T> {
        T info;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T info) {
            this.info = info;
        }
    }

    private Node<T> first = null;
    private Node<T> last = null;
    
    private int ce = 0;

    private class ListIter implements ListIterator {

        Node<T> next;
        Node<T> lastReturn;
        int nextIndex;

        public ListIter(int index) {
            next = (index == ce) ? null : getNode(index);
            nextIndex = index;
            lastReturn = null;
        }

        @Override
        public void add(Object e) {
            Node<T> newNode = new Node<>((T) e);
            if (next == null) {
                if (last != null) {
                    last.next = newNode;
                    newNode.prev = last;
                    last = newNode;
                } else {
                    first = newNode;
                    last = newNode;
                }
            } else {
                Node<T> prev = next.prev;
                newNode.next = next;
                next.prev = newNode;
                if (prev != null) {
                    prev.next = newNode;
                    newNode.prev = prev;
                } else {
                    first = newNode;
                }
            }
            ce++;
            lastReturn = null;

        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public boolean hasPrevious() {
            return next.prev != null;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();

            lastReturn = next;
            next = next.next;
            nextIndex++;

            return lastReturn.info;

        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public Object previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (next == null) {
                lastReturn = last;
                next = last;
            } else {
                lastReturn = next.prev;
                next = next.prev;
            }
            nextIndex--;
            return lastReturn.info;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            if (lastReturn == null) {
                throw new IllegalStateException();
            }
            Node<T> prev = lastReturn.prev;
            Node<T> next = lastReturn.next;
            if (prev != null) {
                prev.next = next;
            } else {
                first = next;
            }
            if (next != null) {
                next.prev = prev;
            } else {
                last = prev;
            }
            if (next == null) {
                this.next = last;
            } else {
                this.next = next;
            }
            ce--;
            lastReturn = null;
        }

        @Override
        public void set(Object e) {
            if (lastReturn == null) {
                throw new IllegalStateException();
            }
            lastReturn.info = (T) e;
        }

    }

    private class DoubleLinkListIterator implements Iterator<T> {
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

    public DoubleLinkList() {
    }

    @Override
    public boolean add(T info) {
        Node<T> nuevo = new Node(info);
        if (isEmpty()) {
            first = nuevo;
            last = first;
        } else {
            //sin referencia de last
            // Node<T> aux = first;

            // while (aux.next != null) {
            //     aux = aux.next;
            // }

            // aux.next = nuevo;
            
            //con referencia de last

            nuevo.prev = last;
            last.next = nuevo;
            last = nuevo;
        }
        ce++;
        return true;
    }

    @Override
    public void add(int index, T info) {
        if(index < 0 || index > ce)
            throw new IndexOutOfBoundsException();
        
            Node nuevo = new Node<T>(info);

            if (isEmpty()) {
                first = nuevo;
                last = first;
            } else if(index == size()){
                nuevo.prev = last;
                last.next = nuevo;
                last = nuevo;
            }else if (index != 0) {
                int pos = 0;
               
                Node aux = first;
    
                while (pos < index) {
                    aux = aux.next;
                    pos++;
                }
                
                nuevo.next = aux;
                nuevo.prev = aux.prev;
                aux.prev.next = nuevo;
                aux.prev = nuevo;

                
    
            }else {
                nuevo.next = first;
                first = nuevo;
    
            }
    
            ce++;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
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

    private boolean checkIndex(int index) {
        return (index >= 0 && index < ce) ? true : false;
    }

    @Override
    public T get(int index) {
        if (!checkIndex(index)) {
            throw new ArrayIndexOutOfBoundsException("Index no válido");
        }

        if (first != null) {
            int pos = 0;
            Node aux = first;
            while (pos++ < index) {
                aux = aux.next;
            }
            return (T) aux.info;
        }

        return null;
    }

    public Node getNode(int index) {
        if (!checkIndex(index)) {
            throw new ArrayIndexOutOfBoundsException("Index no válido");
        }

        if (first != null) {
            int pos = 0;
            Node aux = first;
            while (pos++ < index) {
                aux = aux.next;
            }
            return aux;
        }

        return null;
    }

    @Override
    public int indexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return ce == 0;
        // return first == null;
        // return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkListIterator();
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListIter(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new ListIter(index);
    }

    @Override
    public boolean remove(Object info) {
        Node aux = first;

        while (aux != null) {
            if (aux.info.equals(info)) {
                if(aux.prev != null && aux.next == null){ // eliminar ultima pos
                    last = last.prev;
                    last.next = null;
                }else if (aux.prev != null) {// eliminer pos intermedia
                    aux.prev.next = aux.next; 
                    aux.next.prev = aux.prev;
                } else {// eliminar primera pos
                    first = aux.next; 
                    first.prev = null;
                }

                aux.next = null;
                ce--;
                return true;
            } else {
                aux = aux.next;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        // TODO Auto-generated method stub
        return null;
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
    public T set(int index, T element) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        return ce;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        return null;
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
