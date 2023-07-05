package Ficheros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class fihcerosMian {
    public static void main(String[] args) {
        // Operaciones.Ejercicio1();
        // Operaciones.Ejercicio2();
        // Operaciones.Ejercicio3();

        try {
            //Escritura de texto
            // String text = "Otro texto dfdf";
            // IOUtility.writeFileTxt("data.txt", text);

            //Lectura de texto
            // String line = IOUtility.readFileTxt("data.txt");
            // System.out.println(line);

            //Escritura binaria
            // Estudiante e1 = new Estudiante("Delvis", 20);
            // Estudiante e2 = new Estudiante("Maura", 20);
            // Estudiante e3 = new Estudiante("Eliza", 20);

            // IOUtility.writeFileBin("data.dat", e1);
            // IOUtility.writeFileBin("data.dat", e2);
            // IOUtility.writeFileBin("data.dat", e3);

            //lectura binaria
            List<Estudiante> lista =  IOUtility.readFileBin("data.dat");

            for (Estudiante estudiante : lista) {
                System.out.println(estudiante);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            System.out.println("here");
            e.printStackTrace();
        }
    }
}
