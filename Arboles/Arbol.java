package Arboles;

import java.util.ArrayList;

public class Arbol<T extends Comparable<T>> {

    // implementar los metodos eliminar, getFather(T info), ancestros(info) todos
    // los padres de un nodo

    // Clase Privada para el nodo padre
    private class Padre<T extends Comparable<T>> {
        public T info;
        public ArrayList<T> hijos = new ArrayList<>();

        public Padre(T info) {
            this.info = info;
        }

    }

    // lista para almacenar nodos padres
    private ArrayList<Padre> padres = new ArrayList<>();
    private Padre<T> raiz = null;

    // constructor de la clase por default no se necesita implementar
    

    /**
     * Metodo para saber si el arbol esta vacio
     * 
     * @return boolean
     */
    public boolean isEmpty() {
        return raiz == null;
    }

    /**
     * Metodo para retornar el padre que contiene la info
     * 
     * @param info
     * @return objeto Padre
     */
    private Padre<T> findPadre(T info) {
        for (Padre<T> p : padres) {
            if(p.info.equals(info))
                return p;
        }
        // Iterator<Padre> iterator = padres.iterator();
        // while (iterator.hasNext()) {
        //     Padre next = iterator.next();
        //     if (next.info.equals(info)) {
        //         return next;
        //     }
        // }

        return null;
    }

    public boolean exist(T info) {
        return findPadre(info) != null;
    }

    /**
     * Metodo para insertar un nuevo nodo a partir dde un padre
     * 
     * @param info
     * @param padre
     * @return boolean
     */
    public boolean add(T info, T padre) {
        if (isEmpty()) {
            Padre<T> nuevo = new Padre<T>(info); // creando el nuevo padre
            padres.add(nuevo); // insertando el nuevo padre a la lista de padres
            raiz = nuevo; // el nodo nuevo se convierte en la raiz del arbol
            return true;
        } else {
            Padre<T> p = findPadre(padre); // encontrar el padre del nuevo nodo

            if (p != null) {
                Padre<T> nuevo = new Padre<T>(info); // Creando el nuevo nodo
                padres.add(nuevo); // insertando el padre a la lista de padres
                p.hijos.add(info);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para obtener el padre de un nodo
     * 
     * @param info
     * @return objeto Padre
     */
    private Padre<T> getFather(T info) {

        for (Padre p : padres) {
            if (p.hijos.contains(info)) {
                return p;
            }
        }

        return null;
    }

    /**
     * Metodo que retorna la info del padre de un nodo
     * @param info
     * @return la info del padre
     */
    public T findPadreInfo(T info) {

        for (Padre<T> p : padres) {
            if (p.hijos.contains(info)) {
                return p.info;
            }
        }

        return null;
    }

    /**
     * Metodo que elimina un nodo y los hijos del nodo a borrar pasan como hijos del
     * padre
     * 
     * @param info
     * @return boolean
     */
    public boolean remove(T info) {
        Padre<T> padre = getFather(info);
        Padre<T> hijo = findPadre(info);
        
        if (hijo != null) {
            if (hijo.equals(raiz)) {
                padres.clear();
                raiz = null;
            } else {
                padre.hijos.addAll(hijo.hijos);
                padre.hijos.remove(info);
                padres.remove(hijo);
            }
            return true;
        }

        return false;

    }

    /**
     * Metodo que elimina un nodo y los hijos del nodo a borrar
     * 
     * @param info
     * @return boolean
     */
    public boolean remove1(T info) {
        Padre<T> padre = getFather(info);
        Padre<T> hijo = findPadre(info);

        if (hijo != null) {
            if (hijo.equals(raiz)) {
                padres.clear();
            } else {
                padres.remove(hijo);
                padre.hijos.remove(info);

            }
            return true;
        }

        return false;
    }

    /**
     * Metodo para devolver la info del nodo raiz
     * 
     * @return info del nodo
     */
    public T raiz() {
        return (raiz == null) ? null : raiz.info;
    }

    /**
     * Metodo que retorna una lista con todos los ancestros de un nodo
     * @param info
     * @return lista de ancestros
     */
    public ArrayList<T> ancestros(T info) {
        ArrayList<T> lista = new ArrayList<>();
        
        Padre<T> padre = findPadre(info);

        if (padre != null) {
            while (!padre.equals(raiz)) {
                padre = getFather(padre.info);
                lista.add(padre.info);
            }
            
        }
        return lista;

    }


    //Metodos de repaso no dados en el aula
    public T menor(){
        T menor = raiz.info;

        for (Padre p : padres) {
            if(p.info.compareTo(menor) < 0)
                menor = (T) p.info;
            
        }

        return menor;
    }


    public boolean remplace(T org, T nueva){
        Padre<T> obj = findPadre(org);

        if(obj == null)
            return false;
        
        obj.info = nueva;
        return true;

    }
}
