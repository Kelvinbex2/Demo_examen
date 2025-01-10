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


    public void mostrar(){
        for (Asiento[] asiento : asientos) {
            for (Asiento silla : asiento) {
                System.out.print(silla + "");
            }
            
        }
    }
}
