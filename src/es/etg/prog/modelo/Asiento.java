package es.etg.prog.modelo;

public class Asiento {
    public String id;
    public boolean ocupado;
    public String nombre;
    public String dni;
    public int edad;
    public int puntos;

    public Asiento(String id) {
        this.id = id;
        this.ocupado = false;
    }

    public Asiento() {

    }

    public void asignar(String nombre, String dni, int edad, int puntos) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.puntos = puntos;
        this.ocupado = true;

    }

    @Override
    public String toString() {
        return ocupado ? id + "(Ocupado)" : id + "(Libre)";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

}