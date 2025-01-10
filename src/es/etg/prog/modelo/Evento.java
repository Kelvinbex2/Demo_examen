package es.etg.prog.modelo;

import es.etg.prog.factoria.FactoriaAsiento;

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
                System.out.print(silla + "");
            }

        }
    }

    public boolean indicarPremium(String nombre, String dni, int edad) {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                if (!asientos[i][j].ocupado) {
                    asientos[i][j].asignar(nombre, dni, edad);
                    return true;
                }

            }
        }
        System.out.println("Ya esta ocupado este asiento por lo que no se puede vender este asiento");
        return false;
    }


    public boolean venderEntradas(int limite,String tipo,String nombre, String dni, int edad){
        int entrada=0;

        
        try {
            switch (tipo) {
                case "p":
                   
                    break;
            
                default:
                    break;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;

    }
}
