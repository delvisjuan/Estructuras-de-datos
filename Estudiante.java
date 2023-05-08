//vscode crtl + . generar codigo
//netbeans alt + insert generar codigo

public class Estudiante implements Comparable<Estudiante>{
    String nombre;
    char sexo;
    int edad;

    public Estudiante(String nombre, char sexo, int edad) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int compareTo(Estudiante o) {
        if(this.edad < o.edad)
            return -1;
        if(this.edad > o.edad)
            return 1;
        return 0;
    }

    // @Override
    // public int compareTo(Estudiante o) {
    //     return this.nombre.compareTo(o.nombre);
    // }

    
}
