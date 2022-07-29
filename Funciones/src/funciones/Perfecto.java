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
public class Perfecto {

    public static void main(String[] args) {
        esPerfecto(0);
    }

    public static boolean esPerfecto(int numero) {
        // Para comprobar que es perfecto tendremos que usar un booleano
// En un bucle for podemos comprobar qué números son divisores de otro número, y su sumatoria. 
// Tendremos que anidar bucles for
// VARIABLES
        Scanner teclado = new Scanner(System.in);
        int suma = 0;
        int num;
        final int MINNUM = 0; // si se quieren calcular números perfectos más allá de 1000 se puede modificar aquí.

        // VALIDACIÓN
        do {
            System.out.println("Introduce un número positivo");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            num = teclado.nextInt();
        } while (num < MINNUM);

        // Calcular un número perfecto
        for (int i = 1; i < num && i >= 1; i++) {
            if (num % i == 0) {
                suma += i;
            }
        }

        System.out.println("----------------------------------------------");

        if (num == suma) {
            System.out.println("El número " + num + " es perfecto");
        }
        return false;
    }
}
