package es.etg.prog.modelo;

public class Evento {

    private Asiento[][] asientos;

    public Evento(int filla, int columna) {
        asientos = new Asiento[filla][columna];
        char letra = 'A';
        for (int i = 0; i < filla; i++) {
            for (int j = 0; j < columna; j++) {
                asientos[i][j] = new Asiento((i + 1) + "" + (char) (j + letra));
            }
        }

    }

    public void mostrar() {

        for (Asiento[] asientos2 : asientos) {
            for (Asiento asiento : asientos2) {
                System.out.print(asiento + "");

            }
            System.out.println();
        }
    }

    public boolean indicarPremium(String nombre, String dni, int edad, int puntos) {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {

                if (!asientos[i][j].ocupado) {
                    puntos += 15;
                    asientos[i][j].setPuntos(puntos);
                    asientos[i][j].asignar(nombre, dni, edad, puntos);
                    System.out.println("Asiento asignado " + asientos[i][j].id + " a " + nombre + " (Premium)");
                    return true;
                }
            }
        }
        System.out.println("Asiento no disponible");
        return false;

    }

    public boolean venderEntradas(int limite, String tipo, String nombre, String dni, int edad, int puntos)
            throws Exception {

        if (limite <= 0) {
            System.out.println("Debe ser mayor que 0 ");
        }
        int entradaVendidas = 0;

        try {
            switch (tipo.toLowerCase()) {
                case "p":
                    
                    while (entradaVendidas < limite) {
                        if (!indicarPremium(nombre, dni, edad, puntos)) {
                            return false;
                        }
                        entradaVendidas++;

                    }
                    return true;

                default:
                    throw new Exception("No valida");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public int obtenerPuntos(String nombre, String dni) {
        for (Asiento[] fila : asientos) {
            for (Asiento asiento : fila) {
                if (asiento.ocupado && asiento.nombre.equals(nombre) && asiento.dni.equals(dni)) {
                    return asiento.puntos;
                }
            }
        }
        return 0;  
    }
}
