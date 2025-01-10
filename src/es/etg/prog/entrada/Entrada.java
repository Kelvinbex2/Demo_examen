package es.etg.prog.entrada;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
    static Scanner sc = new Scanner(System.in);

    public static int leerInt() {
        int num = 0;
        boolean esValido = false;
        

        while (!esValido) {
            try {
                num = sc.nextInt();
                if (num < 0) {
                    esValido = false;
                    throw new InputMismatchException("Debes introducir un numero mayor que 0");

                } else {
                    esValido = true;
                }

            } catch (InputMismatchException e) {
                System.out.print("Error.\nVuelve a introducir un numero valido: ");
                esValido = false;

            } finally {
                sc.nextLine();
            }
        }
        return num;
    }

    public static String leerString() {
        String num = "";
        boolean esValido = false;
        
        while (!esValido) {
            try {
                num = sc.nextLine();
                if (num.matches(".*[1234567890].*")) {
                    esValido = false;
                    throw new IllegalArgumentException("Este campo no puede contener un numero");
                } else {
                    esValido = true;
                }
            } catch (Exception e) {
                System.out.print("Error.\nVuelve a escribir una letra valid: ");
                esValido = false;
            }
        }
        return num;

    }
}
