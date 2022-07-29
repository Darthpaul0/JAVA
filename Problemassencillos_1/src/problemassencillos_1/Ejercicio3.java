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
public class Ejercicio3 {

    //----------------------------------------------------------------------------------------------------------
    // Calcular la potencia y=Xn. La base X puede ser cualquier número real y el exponente n será de tipo
    // entero. X y n serán introducidos por teclado, debiendo calcular el valor de y. Utilizar un bucle Desde.
    //----------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

        // VARIABLES
        Scanner teclado = new Scanner(System.in);
        double numero;
        double resultado = 1;
        int exponente;
        final int MIN = 0;
        final int MINEXP = 0, MAXEXP = 50;

// Validación número real de la base
        do {
            System.out.println("Introduzca cualquier número excepto el 0");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            numero = teclado.nextInt();
        } while (numero == MIN);

// Validación número del exponente
        do {
            System.out.println("Introduzca un exponente entre 1 y 50");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            exponente = teclado.nextInt();
        } while (exponente < MINEXP || exponente > MAXEXP);

        // Cálculo del número
        
        for (int i = 0; i < exponente; i++){
            resultado = numero*resultado;
        }
        System.out.println("-----------------------------");
        System.out.println(numero + " al exponente " + exponente + " es igual a: " + resultado);
    }
}
