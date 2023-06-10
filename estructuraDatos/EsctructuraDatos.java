package estructuraDatos;

import Arboles.Arbol;

public class EsctructuraDatos {
    public static void main(String[] args) {
        Arbol<String> ceiba = new Arbol<>();


        boolean insertado = ceiba.add("Maura", "");
        System.out.println("Fue insertado: " + insertado);

        insertado = ceiba.add("Alvaro", "Maura");
        System.out.println("Fue insertado: " + insertado);

        insertado = ceiba.add("Elizabeth", "Maura");
        System.out.println("Fue insertado: " + insertado);

        insertado = ceiba.add("Delvis", "Elizabeth");
        System.out.println("Fue insertado: " + insertado);

        //Quien es la raiz del arbol
        System.out.println("La mama de todos los pollitos " + ceiba.raiz());


    }
}
