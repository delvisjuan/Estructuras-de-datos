package Arboles;

public class arbolMain {
    public static void main(String[] args) {
        ArbolBinarioB<Integer> arbol = new ArbolBinarioB<>();

        arbol.insert(4);
        arbol.insert(2);
        arbol.insert(5);
        arbol.insert(3);
        arbol.insert(1);
        arbol.insert(6);

        System.out.println(arbol.minValue());
        System.out.println(arbol.maxValue());

        arbol.delete(2);

        System.out.println(arbol.isHoja(3));

        

    


    }
}
