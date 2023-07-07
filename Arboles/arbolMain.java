package Arboles;



public class arbolMain {
    public static void main(String[] args) {
        ArbolBinarioB<Integer> arbol = new ArbolBinarioB<>();
        Arbol<String> noBinario = new Arbol<>();

        arbol.insert(15);
        arbol.insert(12);
        arbol.insert(25);
        arbol.insert(10);
        arbol.insert(13);
        arbol.insert(19);
        arbol.insert(26);
        arbol.insert(11);

        noBinario.add("Maura", null);
        noBinario.add("Delvis", "Maura");
        noBinario.add("Maels", "Maura");
        noBinario.add("Eliza", "Maels");
        noBinario.add("Alvaro", "Eliza");
        noBinario.add("Elena", "Alvaro");

        System.out.println(noBinario.calcularAltura("Maura"));

        // System.out.println(arbol.minValue());
        // System.out.println(arbol.maxValue());

        // arbol.delete(2);

        // System.out.println(arbol.isHoja(3));

        // List<Integer> lista = arbol.recorridoProfundidad();

        // for (Integer i : lista) {
        // System.out.println(i);
        // }

        // System.out.println("Pre Orden\n");

        // List<Integer> qwr = arbol.preOrderTraversal();

        // for (Integer a : qwr) {
        // System.out.print(a + "\t");
        // }

        // System.out.println("\nPost Orden\n");

        // List<Integer> asd = arbol.postOrderTraversal();

        // for (Integer a : asd) {
        // System.out.print(a + "\t");
        // }

        // System.out.println("\nIn Orden\n");

        // List<Integer> zxc = arbol.inOrderTraversal();

        // for (Integer a : zxc) {
        // System.out.print(a + "\t");
        // }

        // System.out.println(arbol.getDepth());

        // List<Integer> recorrido = arbol.recorridoAncho();

        // for (Integer i : recorrido) {
        //     System.out.println(i);
        // }

        ArbolBinarioB<Integer> arbol2  = new ArbolBinarioB<>();
        arbol2.insert(10);
        arbol2.insert(9);
        arbol2.insert(8);
        arbol2.insert(7);

        System.out.println(arbol2.isDegenerado());
    }
}
