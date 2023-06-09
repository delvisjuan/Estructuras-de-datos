package Ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Operaciones {
    public static void Ejercicio1() {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Nombre del Fichero: ");
            String file_name = sc.next();

            File file = new File(file_name);

            Scanner sc_file = new Scanner(file);

            String line;

            while ((line = sc_file.next()) != null) {
                System.out.println(line);
            }

            sc_file.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void Ejercicio2() {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Nombre del Fichero: ");
            String file_name = sc.next();

            File file = new File(file_name.trim());

            PrintWriter pw = new PrintWriter(file);

            String line;

            while ((line = sc.next()) != null) {
                pw.write(line);
            }

            pw.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void Ejercicio3() {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Nombre del Fichero: ");
            String fn = sc.next();
            // String fn = "data.csv";

            System.out.print("Delimitador: ");
            String delimitador = sc.next();

            // String delimitador = ",";
            FileReader fr = new FileReader(fn);
            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimitador);
                for (String v : values) {
                    System.out.print(v + "\t");
                }
                System.out.println("");
            }
            br.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void escribirTeclado() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el nombre del Archivo ");
        String file_name = sc.nextLine();// no se puede recibir una lista solo variales primitivas

        File f = new File(file_name);// crea o abre el archivo

        FileWriter fw = new FileWriter(f, true);// para preparar el archivo para escribir en el
        BufferedWriter bw = new BufferedWriter(fw);// para preparar el archivo para escribir en el

        String line = null;

        Character a = sc.nextLine().charAt(0);
        System.out.println(a.charValue());

        while (line != "") {
            System.out.print("Escribe el contindo: ");
            line = sc.nextLine().trim();
            bw.append(line);
            bw.newLine();
            System.out.println((line == ""));
        }

        bw.close();
        fw.close();
    }

    public static void objetosStudent(){
        Scanner sc = new Scanner(System.in);
        List<Estudiante> lista = new LinkedList<>();

        int opc = 0;

        while (opc == 0) {
            System.out.print("Edad: ");
            int edad = sc.nextInt();
            System.out.print("Nombre: ");
            String name = sc.next();


            lista.add(new Estudiante(name, edad));

            System.out.print("introduce 0 para otro estudiante y otro num para cancelar: ");
            opc = sc.nextInt();
        }

        try {
            IOUtility.writeFileBin("estudiante.txt", lista);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
