package es.etg.prog.factoria;
import es.etg.prog.modelo.Asiento;
import es.etg.prog.modelo.Premium;

public class FactoriaAsiento {
    
    public static Asiento crearAsiento(int opc,String id) throws IllegalAccessException {

        switch (opc) {
            case 1:
                if (opc == 1) {
                    return new Premium(id);
                } 
            default:
            throw  new IllegalAccessException("Error en crear asiento");

        }
      

    }

}
