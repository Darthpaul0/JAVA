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
public class Ejercicio6 {

    //
    // Hacer un programa que calcule e imprima los números perfectos menores de 1000. 
    // Un número es perfecto si la suma de sus divisores, excepto él mismo, es igual al propio número. 
    // Ejemplo: Los divisores de 6 son 6, 3, 2, 1 y la suma de todos su divisores excepto él mismo es 3+2+1 = 6. Luego 6 es un número perfecto.
    //
    public static void main(String[] args) {

// Para comprobar que es perfecto tendremos que usar un booleano
// En un bucle for podemos comprobar qué números son divisores de otro número, y su sumatoria. 
// Tendremos que anidar bucles for
// VARIABLES
        int suma = 0;
        int numero = 1000; // si se quieren calcular números perfectos más allá de 1000 se puede modificar aquí.

        // Calcular un número perfecto
        for (int i = 1; i < numero && i >= 1; i++) {
            if (numero % i == 0) {
                suma += i;
            }
        }

        System.out.println("----------------------------------------------");

        if (numero == suma) {
            System.out.println("El número " + numero + " es perfecto");
        }

    }
}
