/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Bisiestos {

    public static void main(String[] args) {
        System.out.println("--Función para comprobar años bisiestos--");
        esBisiesto(0);
    }

    public static boolean esBisiesto(int año) {
        // Variables
        Scanner teclado = new Scanner(System.in);
        final int MIN = 0;
        int year;

        // Validación del año introducido
        do {
            System.out.println("Introduzca un año");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            year = teclado.nextInt();
        } while (year < MIN);

        // Comprobación de año bisiesto
        if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) {
            System.out.println("El año " + year + " es bisiesto");
        } else {
            System.out.println("El año " + year + " no es bisiesto");
        }
        return false;
    }
}
