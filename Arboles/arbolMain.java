package Arboles;

public class arbolMain {
    public static void main(String[] args) {
        ArbolBinarioB<Integer> arbol = new ArbolBinarioB<>();

        arbol.insert(10);
        arbol.insert(12);
        arbol.insert(11);
        arbol.insert(9);
        arbol.insert(4);
        arbol.insert(5);
        arbol.insert(20);
        arbol.insert(25);
        arbol.insert(30);
        arbol.insert(1);

        System.out.println(arbol.minValue());
        System.out.println(arbol.maxValue());

        System.out.println(arbol.isHoja(12));
        

    


    }
}
