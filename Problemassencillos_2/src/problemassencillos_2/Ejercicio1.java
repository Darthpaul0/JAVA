/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemassencillos_2;

import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Ejercicio1 {

    /**
     * Calcular la suma de todos los números pares por un lado, y por otro, la de los impares, desde 1 hasta N, siendo N un entero positivo introducido por teclado.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /**
         * Vamos a pedir el número por teclado Comprobaremos que es un número Crearemos dos bucles for, uno para mostrar los pares y otro para los impares
         */

        // Definimos las variables de entrada para el número y para leer datos por teclado
        Scanner teclado = new Scanner(System.in);
        int pares = 0, impares = 0;
        int valor;
        final int MIN = 1;

        // validamos que el valor introducido sea un número
        do {
            System.out.println("Introduzca un valor mayor o igual a 1");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            valor = teclado.nextInt();
        } while (valor <= MIN);

        // aseguramos que el número sea par
        if (valor % 2 == 0) {
            for (int i = 0; i <= valor; i += 2) {
                pares += i;
            }
            for (int i = 1; i <= valor; i += 2) {
                impares += i;
            }
        }
        //en caso de que sea impar
        if (valor % 2 != 0) {
            for (int i = 1; i <= valor; i = +2) {
                impares += i;
            }
            for (int i = 0; i <= valor; i = +2) {
                pares += i;
            }
        }
        System.out.println("SUMA NÚMEROS PARES: " + pares);
        System.out.println("SUMA NÚMEROS IMPARES: " + impares);
    }
}

// Podemos optimizar el código metiendo el bucle if dentro del for 
