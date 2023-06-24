package Arboles;

public class ArbolBinarioB<T extends Comparable<T>> {
    // insertar nodo
    // buscar nodo
    // buscar padre de un nodo
    // buscar hermano de un nodo
    // calc altura del arbol
    // registrar todas las hojas

    private class Node<T> {
        T key;
        Node<T> left, right;

        public Node(T item) {
            key = item;
            left = right = null;
        }

    }

    Node<T> root;

    public ArbolBinarioB() {
        root = null;
    }

    // insertar un nuevo nodo
    public void insert(T key) {
        root = insertRec(root, key);
    }

    // funcion recursiva para insertar
    private Node<T> insertRec(Node<T> root, T key) {
        // si el arbol esta vacio, retorna un nuevo nodo
        if (root == null) {
            root = new Node<T>(key);
            return root;
        }

        // de lo contrario, avanzar en el arbol
        if (key.compareTo(root.key) < 0)
            root.left = insertRec(root.left, key);
        else if (key.compareTo(root.key) > 0)
            root.right = insertRec(root.right, key);

        // return el nodo puntero (sin cambios)
        return root;

    }

    // buscar un nodo en el arbol
    public boolean search(T key) {
        return searchRec(root, key);
    }

    // metodo recursivo para buscar
    private boolean searchRec(Node<T> root, T key) {
        // casos base de parada
        if (root == null || root.key.compareTo(key) == 0)
            return root != null;

        // informacion menor que la info del root
        if (key.compareTo(root.key) < 0)
            return searchRec(root.left, key);
        else
            // informacion mayor que la info del root
            return searchRec(root.right, key);

    }

    // metodo para eliminar un nodo a partir de su info
    public void delete(T key) {
        root = deleteRec(root, key);
    }

    // metodo recursivo para eliminar un nodo a partir de su info
    private Node<T> deleteRec(Node<T> root, T key) {
        if (root == null)
            return root;

        if (key.compareTo(root.key) < 0)
            root.left = deleteRec(root.left, key);
        else if (key.compareTo(root.key) > 0)
            root.right = deleteRec(root.right, key);
        else {
            // nodo con un solo hijo o ninguno
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // nodo con dos hijos:

            root.key = minValueRec(root.right);// implementar

            root.right = deleteRec(root.right, key);
        }
        return root;
    }

    public T minValue() {
        return minValueRec(root);

    }

    private T minValueRec(Node<T> root) {
        // casos base de parada
        if (root.left == null)
            return root.key;

        // desplazarse a la izquiera en busca del menor valor
        return minValueRec(root.left);
    }

    public T maxValue() {
        return maxValueRec(root);

    }

    private T maxValueRec(Node<T> root) {
        // casos base de parada
        if (root.right == null)
            return root.key;

        // desplazarse a la derecha en busca del mayor valor
        return maxValueRec(root.right);
    }
    
    

    public boolean isHoja(T key) {
        return isHojaRec(root, key);
    }

    public boolean isHojaRec(Node<T> root, T key) {
        if ( root == null) {
            return false;
        }

        if (root.key.compareTo(key) == 0 ) {
            if (root.left == null && root.right == null)
                return true;
            else
                return false;
        }

        if (key.compareTo(root.key) < 0)
            return isHojaRec(root.left, key);
        else
            return isHojaRec(root.right, key);

    }
}
