package Ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    public static void writeFileTxt(String file_name, String texto) throws IOException {
        File f = new File(file_name);

        FileWriter fw = new FileWriter(f, true);

        BufferedWriter bw = new BufferedWriter(fw);
        bw.append(texto);
        bw.newLine();

        bw.close();
        fw.close();

    }

    public static String readFileTxt(String file_name) throws IOException {
        File f = new File(file_name);

        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String line = "", output = "";

        while((line = br.readLine()) != null){
            output += line + "\n";
        }

        br.close();
        fr.close();
        return output;

    }

    public static void writeFileBin(String file_name, Object obj) throws IOException {
        File f  = new File(file_name);

        OutputStream os = new FileOutputStream(f, true);
        ObjectOutputStream oops = new ObjectOutputStream(os);

        oops.writeObject(obj);

        oops.close();
        os.close();

    }

    public static List<Estudiante> readFileBin(String file_name) throws IOException, ClassNotFoundException {
        File f  = new File(file_name);

        InputStream os = new FileInputStream(f);
        ObjectInputStream oips = new ObjectInputStream(os);


        ArrayList<Estudiante> lista = new ArrayList<>();
        Estudiante e;

        while((e = (Estudiante) oips.readObject()) != null){
            System.out.println(e);
            lista.add(e);
        }

        oips.close();
        os.close();
        return lista;

    }
}