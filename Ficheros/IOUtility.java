package Ficheros;

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
import java.util.List;

public class IOUtility {

        // ----------------------------------archivos de texro-------------------------------------------------
    public static void writeFileTxt(String file_name, String texto) throws IOException {// escribe texto en un archivo
        File f = new File(file_name);// crea o abre el archivo

        FileWriter fw = new FileWriter(f, true);// para preparar el archivo para escribir en el
        BufferedWriter bw = new BufferedWriter(fw);// para preparar el archivo para escribir en el

        bw.append(texto);// escribe el contenido en el archivo
        bw.newLine();// crea una nueva line

        // cerrar los recursos
        bw.close();
        fw.close();

    }

    public static void writeFileTxt(String file_name, List<String> texto) throws IOException {// escribe texto en un
                                                                                              // archivo
        File f = new File(file_name);// crea o abre el archivo

        FileWriter fw = new FileWriter(f, true);// para preparar el archivo para escribir en el
        BufferedWriter bw = new BufferedWriter(fw);// para preparar el archivo para escribir en el

        for (String s : texto) {
            bw.append(s);
            bw.newLine();
        }

        bw.close();
        fw.close();

    }

    public static String readFileTxt(String file_name) throws IOException {//retorna un string con el contenido del fichero
        File f = new File(file_name);

        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String line = "", output = "";

        while ((line = br.readLine()) != null) {
            output += line + "\n";
        }

        br.close();
        fr.close();
        return output;

    }

    public static void readFileTxtConsola(String file_name) throws IOException {//muestra el contenido del fichero por consola
        File f = new File(file_name);

        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String line = "", output = "";

        while ((line = br.readLine()) != null) {
            output += line + "\n";
        }

        System.out.println(output);

        br.close();
        fr.close();

    }

    public static List<String> readFileTxtList(String file_name) throws IOException {//retorna en una lista el contenido del fichero
        File f = new File(file_name);

        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        List<String> output = new ArrayList<>();
        String line = "";

        while ((line = br.readLine()) != null) {
            output.add(line);
        }

        br.close();
        fr.close();
        return output;

    }

    // ----------------------------------archivos binarios-------------------------------------------------
    public static void writeFileBin(String file_name, List<Object> obj) throws IOException {// write=escribir (en un
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

    public static void writeFileBin(String file_name, Object obj) throws IOException {// write=escribir (en un archivo
                                                                                      // binario)
        File f = new File(file_name);

        OutputStream os = new FileOutputStream(f);
        ObjectOutputStream oops = new ObjectOutputStream(os);

        oops.writeObject(obj);

        oops.close();
        os.close();

    }

    public static Object readFileBin(String file_name) throws IOException, ClassNotFoundException { // leer archivo binario
        File f = new File(file_name);

        InputStream os = new FileInputStream(f);
        ObjectInputStream oips = new ObjectInputStream(os);

        Object e = null;
        
        try {
            e = oips.readObject();

        } catch (EOFException a) {
            a.getSuppressed();
        }

        oips.close();
        os.close();
        return e;

    }

    public static List<Estudiante> readFileBinList(String file_name) throws IOException, ClassNotFoundException { // leer archivo binario
        File f = new File(file_name);

        InputStream os = new FileInputStream(f);
        ObjectInputStream oips = new ObjectInputStream(os);

        ArrayList<Estudiante> lista = new ArrayList<>();
        Estudiante e;
        
        try {
            while ((e = (Estudiante) oips.readObject()) != null) {//(Estudiante) se llama casteo y es para que trate el objeto que retorna el metodo readObject() como un estudiante
                lista.add(e);
            }

        } catch (EOFException a) {
            a.getSuppressed();
        }

        oips.close();
        os.close();
        return lista;

    }

}