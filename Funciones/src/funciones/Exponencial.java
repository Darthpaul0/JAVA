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
public class Exponencial {

    public static void main(String[] args) {
        System.out.println("--Función para calcular números exponenciales--");
        potencia(0, 0);
    }

    public static double potencia(double base, int exponente) {
        // VARIABLES
        Scanner teclado = new Scanner(System.in);
        double numero;
        double resultado = 1;
        int exp;
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

            exp = teclado.nextInt();
        } while (exp < MINEXP || exp > MAXEXP);

        // Cálculo del número
        for (int i = 0; i < exp; i++) {
            resultado = numero * resultado;
        }
        System.out.println("-----------------------------");
        System.out.println(numero + " al exponente " + exp + " es igual a: " + resultado);
        return 0;
    }
}
