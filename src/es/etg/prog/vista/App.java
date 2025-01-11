package es.etg.prog.vista;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import es.etg.prog.entrada.Entrada;
import es.etg.prog.modelo.Asiento;
import es.etg.prog.modelo.Evento;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        Evento evento = new Evento(5, 9);

        do {
            try {
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
                        throw new IndexOutOfBoundsException("Error no exite ese numero ");

                }
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        } while (opc != 0);

    }

    public static void gestionar(Evento evento) throws Exception {
        System.out.print("Dni: ");
        String dni = Entrada.leerString();
        System.out.print("Tipo: ");
        String tipo = Entrada.leerString();
        while (!tipo.equals("p")) {
            System.out.print("Debe ser p/l: ");
            tipo = Entrada.leerString();
        }

        System.out.print("Nombre: ");
        String nombre = Entrada.leerString();

        System.out.print("Edad: ");
        int edad = Entrada.leerInt();

        System.out.print("Limite: ");
        int limite = Entrada.leerInt();

        int puntosActualizados = 0;
        if (evento.venderEntradas(limite, tipo, nombre, dni, edad, puntosActualizados)) {
            puntosActualizados = evento.obtenerPuntos(nombre, dni);
            System.out.println("Venta completa");
            guardaTicket(nombre, dni, edad, limite, puntosActualizados);

        } else {
            System.out.println("Venta no correcta");
        }

    }

    public static void guardaTicket(String nombre, String dni, int edad, int entradas, int puntos) {
        File ficFile = new File("Ticket.txt");
        int ticketNumber = contarTickets(ficFile) + 1;
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(ficFile, true))) {
            fw.write("**********Ticket " + ticketNumber + "***********" + System.lineSeparator());
            fw.write("Nombre: " + nombre + System.lineSeparator());
            fw.write("Dni: " + dni + System.lineSeparator());
            fw.write("Edad: " + edad + System.lineSeparator());
            fw.write("Puntos: " + puntos + System.lineSeparator());
            fw.write("Entradas Compardo: " + entradas + System.lineSeparator());
            fw.write("***************************" + System.lineSeparator());
            fw.write(System.lineSeparator());
            fw.write(System.lineSeparator());

            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int contarTickets(File ficFile) {
        int count = 0;
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(ficFile))) {
            while ((line = br.readLine()) != null) {
                if (line.startsWith("**********Ticket")) {
                    count++;
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return count;
    }

}
