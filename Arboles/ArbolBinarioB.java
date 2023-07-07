package Arboles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.RootPaneContainer;

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

        @Override
        public String toString() {
            return "Node [key=" + key + "]";
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
        // si el arbol esta vacio, retorna un nuevo nodo o se llega al lugar de
        // insersion
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
        if (root == null) {
            return false;
        }

        if (root.key.compareTo(key) == 0) {
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

    private boolean isHoja(Node<T> obj) {
        return (obj.left == null && obj.right == null);
    }

    public List<T> recorridoProfundidad() {
        if (root == null) {
            return null;
        }

        List<T> recorrido = new LinkedList<>();

        Stack<Node<T>> pila = new Stack<>();
        pila.push(root);

        while (!pila.isEmpty()) {
            Node<T> actual = pila.pop();
            recorrido.add(actual.key);

            if (actual.right != null) {
                pila.push(actual.right);
            }

            if (actual.left != null) {
                pila.push(actual.left);
            }
        }

        return recorrido;
    }

    public List<T> preOrderTraversal() {
        List<T> lista = new ArrayList<>();
        preOrderTraversal(root, lista);
        return lista;
    }

    private void preOrderTraversal(Node<T> node, List<T> lista) {
        if (node != null) {
            lista.add(node.key);
            preOrderTraversal(node.left, lista); // Recorre el subárbol izquierdo
            preOrderTraversal(node.right, lista); // Recorre el subárbol derecho
        }
    }

    // Recorrido postorden recursivo
    public List<T> postOrderTraversal() {
        List<T> lista = new ArrayList<>();
        postOrderTraversal(root, lista);
        return lista;
    }

    private void postOrderTraversal(Node<T> node, List<T> lista) {
        if (node != null) {
            postOrderTraversal(node.left, lista); // Recorre el subárbol izquierdo
            postOrderTraversal(node.right, lista); // Recorre el subárbol derecho
            lista.add(node.key);
        }
    }

    // Recorrido en orden (inorden) recursivo
    public List<T> inOrderTraversal() {
        List<T> lista = new ArrayList<>();
        inOrderTraversal(root, lista);
        return lista;
    }

    private void inOrderTraversal(Node<T> node, List<T> lista) {
        if (node != null) {
            inOrderTraversal(node.left, lista); // Recorre el subárbol izquierdo
            lista.add(node.key);
            inOrderTraversal(node.right, lista); // Recorre el subárbol derecho
        }
    }

    public int getDepth() {
        return getDepth(root);
    }

    private int getDepth(Node<T> node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public List<T> recorridoAncho() {
        Queue<Node<T>> queue = new LinkedList<>();
        List<T> recorrido = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            recorrido.add(node.key);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return recorrido;
    }

    public boolean isDegenerado() {// devuelve verdadero cuando todos los hijos del arbol son izq o derechos
        boolean izq = false;
        boolean der = false;

        Node<T> actual = root;

        while (actual != null) {
            if (actual.left != null && actual.right == null) {
                izq = true;
                actual = actual.left;
            } else if (actual.right != null && actual.left == null) {
                der = true;
                actual = actual.right;
            } else if (isHoja(actual)) {
                return (izq != der);
            } else {
                return false;
            }
        }

        return (izq != der);
    }

    public List<T> caminoNodo(T info) {
        List<T> camino = new ArrayList<>();

        Node<T> actual = root;

        while (actual != null) {
            camino.add(actual.key);

            if (actual.key.compareTo(info) < 0) {
                actual = actual.right;
            } else if (actual.key.compareTo(info) > 0) {
                actual = actual.left;
            } else
                return camino;

        }

        return null;
    }

    // -------------------------------------------------------------------------------------

    public void writeFileTxt(String file_name, List<T> texto) throws IOException {// escribe texto en un
                                                                                  // archivo
        File f = new File(file_name);// crea o abre el archivo

        FileWriter fw = new FileWriter(f, true);// para preparar el archivo para escribir en el
        BufferedWriter bw = new BufferedWriter(fw);// para preparar el archivo para escribir en el

        for (T s : texto) {
            bw.append((String) s);
            bw.newLine();
        }

        bw.close();
        fw.close();

    }

    public void writeArbol() throws IOException {
        writeFileTxt("juana.txt", preOrderTraversal());
    }

    public void writeFileTxt(String file_name) throws IOException {// escribe texto en un
        // archivo
        List<T> orden = preOrderTraversal();
        File f = new File(file_name);// crea o abre el archivo

        FileWriter fw = new FileWriter(f, true);// para preparar el archivo para escribir en el
        BufferedWriter bw = new BufferedWriter(fw);// para preparar el archivo para escribir en el

        for (T s : orden) {
            bw.append((String) s);
            bw.newLine();
        }

        bw.close();
        fw.close();

    }

    // esciba como parametro el mombre del archivo y me cargar el arbol
    public List<T> readFileTxtList(String file_name) throws IOException {
        File f = new File(file_name);

        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        List<T> output = new ArrayList<>();
        String line = "";

        while ((line = br.readLine()) != null) {
            output.add((T) line);
        }

        br.close();
        fr.close();
        return output;

    }

    public void cargarArbol(String file_name) throws IOException {
        List<T> lista = readFileTxtList(file_name);
        for (T l : lista) {
            insert(l);
        }

    }

    // guardar contenido pre orden del arbol
    public void writeFileBin(String file_name, List<Object> obj) throws IOException {// write=escribir (en un
                                                                                     // archivo binario)
        File f = new File(file_name);

        OutputStream os = new FileOutputStream(f);
        ObjectOutputStream oops = new ObjectOutputStream(os);

        for (Object o : obj) {
            oops.writeObject(o);
        }

        oops.close();
        os.close();

    }

    public void writeArbolBin() throws IOException {
        writeFileBin("juana.txt", (List<Object>) preOrderTraversal());
    }

    // leer el contenido y cargarlo en el arbol
    public List<T> readFileBinList(String file_name) throws IOException, ClassNotFoundException { // leer archivo
                                                                                                  // binario
        File f = new File(file_name);

        InputStream os = new FileInputStream(f);
        ObjectInputStream oips = new ObjectInputStream(os);

        ArrayList<T> lista = new ArrayList<>();
        T e;

        try {
            while ((e = (T) oips.readObject()) != null) {// (Estudiante) se llama casteo y es para que trate el objeto
                                                         // que retorna el metodo readObject() como un estudiante
                lista.add(e);
            }

        } catch (EOFException a) {
            a.getSuppressed();
        }

        oips.close();
        os.close();
        return lista;

    }

    public void cargarArbolBin(String file_name) throws IOException, ClassNotFoundException {
        List<T> lista = readFileBinList(file_name);
        for (T l : lista) {
            insert(l);
        }

    }

}
