/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemassencillos_3;

import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Ejercicio4 {

    //
    // Realizar una aplicación que escriba en pantalla los valores de una progresión geométrica utilizando
    // un bucle mientras (while). Se introducirá por teclado el número de elementos de la progresión (N), la
    // razón (r) o factor de la progresión y el término inicial (ti).
    // Por ejemplo: ti = 3, r = 2 y N = 5 la progresión sería: 3 6 12 24 48...
    //
    public static void main(String[] args) {
        // 
        // Empezamos por validar los datos introducidos por teclado
        // Creamos el bucle while con los cálculos
        // Mostramos el resultado por pantalla
        //

        // VARIABLES
        Scanner teclado = new Scanner(System.in);
        int N; // elementos de la progresión
        int r; // factor de progresión o razón
        int ti; // término inicial
        int contador = 0;
        final int MIN = 1; // mínimo aceptado

        // VALIDACIÓN DEL TÉRMINO INICIAL DE LA PROGRESIÓN
        do {
            System.out.println("Término inicial de la progresión");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            ti = teclado.nextInt();
        } while (ti < MIN);

        // VALIDACIÓN DEL FACTOR DE PROGRESIÓN
        do {
            System.out.println("Razón de la progresión");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            r = teclado.nextInt();
        } while (r < MIN);

        // VALIDACIÓN DEL NÚMERO DE ELEMENTOS DE LA PROGRESIÓN
        do {
            System.out.println("Número de elementos de la progresión");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            N = teclado.nextInt();
        } while (N < MIN);
        System.out.println("--PROGRESIÓN--");
        // CÁLCULO DE LA PROGRESIÓN Y MUESTRA POR PANTALLA 
        while (contador < N) {
            System.out.println("Término " + contador + ": " + ti + " ");
            ti *= r;
            contador++;

        }
    }
}
