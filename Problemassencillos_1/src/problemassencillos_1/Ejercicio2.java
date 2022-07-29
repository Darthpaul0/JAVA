/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemassencillos_1;

import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Ejercicio2 {
    //
    //------------------------------------------------------------------------------------------------------------
    // Escribe un programa que lea del teclado un año e indique si es bisiesto o no (Un año es bisiesto si es
    // divisible por 4, excepto el último de cada siglo, aquellos divisibles por 100, que para ser bisiestos,
    // también deben ser divisibles por 400).
    //------------------------------------------------------------------------------------------------------------
    //
    public static void main(String[] args) {

        // Variables
        Scanner teclado = new Scanner(System.in);
        final int MIN = 0;
        int año;

        // Validación del año introducido
        do {
            System.out.println("Introduzca un año");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            año = teclado.nextInt();
        } while (año < MIN);

        // Comprobación de año bisiesto
        if ((año % 4 == 0) && ((año % 100 != 0) || (año % 400 == 0))) {
            System.out.println("El año " + año + " es bisiesto");
        } else {
            System.out.println("El año " + año + " no es bisiesto");
        }

    }
}
