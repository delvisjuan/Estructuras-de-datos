package Ficheros;

import java.io.Serializable;

public class Estudiante implements Serializable{
    
    public String name;
    public int edad;
    
    public Estudiante(String name, int edad) {
        this.name = name;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Estudiante [name=" + name + ", edad=" + edad + "]";
    }

    
}
