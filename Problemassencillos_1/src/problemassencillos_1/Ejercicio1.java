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
 *
 * Mostrar el mayor y el menor de una serie de cinco números que vamos introduciendo por teclado.
 *
 */
public class Ejercicio1 {

    /**
     * Mostrar el mayor y el menor de una serie de cinco números que vamos introduciendo por teclado.
     */
    public static void main(String[] args) {

        // Declaración de variables
        Scanner teclado = new Scanner(System.in);
        int num, max = 0, min = 0;
        final int limite = 5;

        for (int i = 1; i <= limite; i++) {
            // Pedimos el número
            System.out.print(i + " Introduzca un numero: ");

            num = teclado.nextInt();

            // Estructura condicional para números distintos de 0
            if (min != 0 && max != 0) {
                if (num > max) {
                    max = num;
                }

                if (num < min) {
                    min = num;
                }
            }

            // Estructura condicional para 0
            if (min == 0 || max == 0) {
                if (num > max) {
                    max = num;
                }
                if (num < min) {
                    min = num;
                }
            }
        }

        System.out.println("Numero Maximo: " + max);

        System.out.println("Numero Minimo: " + min);

    }

}
