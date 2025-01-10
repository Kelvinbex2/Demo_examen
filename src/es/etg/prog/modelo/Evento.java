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
        for (Asiento[] asiento : asientos) {
            for (Asiento silla : asiento) {
                System.out.print(silla + " ");
            }
            System.out.println();

        }
    }

    public boolean indicarPremium(String nombre, String dni, int edad) {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                if (!asientos[i][j].ocupado) {
                    asientos[i][j].asignar(nombre, dni, edad);
                    System.out.println("Asiento asignado " + asientos[i][j].id + " (Premium)");
                    return true;
                }

            }
        }
        System.out.println("Ya esta ocupado este asiento por lo que no se puede vender este asiento");
        return false;
    }

    public boolean venderEntradas(int limite, String tipo, String nombre, String dni, int edad) throws Exception {

        if (limite <= 0) {
            System.out.println("Solo tiene que ser mayor");
            return false;
        }
        int entrada = 0;
        switch (tipo.toLowerCase()) {
            case "p":
                while (entrada < limite) {

                    if (!indicarPremium(nombre, dni, edad)) {
                        return false;
                    }
                    entrada++;
                }

                return true;
            default:
                return false;
        }

    }
}
