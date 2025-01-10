package es.etg.prog.modelo;

public class Asiento {
    public String id;
    public boolean ocupado;
    public String nombre;
    public String dni;
    public int edad;

    public Asiento(String id) {
        this.id = id;
        this.ocupado = false;
    }

    public void asignar(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.ocupado = true;

    }

    @Override
    public String toString() {
        return ocupado ? id + "(Ocupado)" : id + "(Libre)";
    }

}