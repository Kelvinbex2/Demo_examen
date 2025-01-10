package es.etg.prog.vista;

import java.util.Scanner;

import es.etg.prog.entrada.Entrada;
import es.etg.prog.modelo.Evento;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        Evento evento = new Evento(5, 9);
        do {
            System.out.print("1.Mostrar\n2.comprar\nEscribe: ");
            opc = Entrada.leerInt();
            
            switch (opc) {
                case 1:
                    evento.mostrar();
                    break;

                case 2:

                    gestionar(evento);
                    break;
                default:
                    throw new IndexOutOfBoundsException("Error");

            }
        } while (opc != 0);

    }

    public static void gestionar(Evento evento) throws Exception {
        System.out.print("Dni: ");
        String dni = Entrada.leerString();
        System.out.print("Tipo: ");
        String tipo = Entrada.leerString();

        System.out.print("Nombre: ");
        String nombre = Entrada.leerString();

        System.out.print("Edad: ");
        int edad = Entrada.leerInt();

        System.out.print("Limite: ");
        int limite = Entrada.leerInt();

        if (evento.venderEntradas(limite, tipo, nombre, dni, edad)) {
            System.out.println("Venta completa");

        } else {
            System.out.println("Venta no correcta");
        }

    }

}
