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
public class Ejercicio5 {

    //
    // Realizar un juego para adivinar un número entero N entre 1 y 100. Para generar números aleatorios
    // disponemos del método Math.random() (busca información de cómo usarlo). Una vez generado el
    // número a adivinar, el programa irá pidiendo números al usuario, indicándole “mayor” o “menor” según
    // el número a adivinar sea mayor o menor con respecto al introducido. El proceso termina cuando el
    // usuario acierta el número.
    //
    public static void main(String[] args) {

        /* Avisamos al usuario de lo que tiene que hacer
        El usuario va introduciendo números por teclado, que deben ser validados cada vez
        Si el número introducido es mayor, se le avisa y vuelve a probar 
        Ídem si es menor
        Así hasta que acierta */
        //--------------------------------------------------------------------------------------
        // VARIABLES 
        Scanner teclado = new Scanner(System.in);
        final int MIN = 1;
        final int MAX = 100;
        int num;
        int alea = (int) Math.floor(Math.random() * (MIN - MAX) + MAX);

        // EXPLICACIÓN DEL JUEGO
        System.out.println("Debes adivinar un número al azar del 1 al 100. Yo te iré dando pistas de lo cerca que estás del número.");
        System.out.println("-------------");

        // EL JUEGO EN SÍ
        do {
            System.out.println("¿Qué número es?");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException

            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("¡Tienes que introducir un número!");
            }

            num = teclado.nextInt();

            if (num >= 100 || num <= 1) {
                System.out.println("El número tiene que estar entre 1 y 100");
            } else {
                if (num > alea) {
                    System.out.println("---------");
                    System.out.println("Es menor. Prueba otra vez.");
                    System.out.println("---------");

                } else {
                    System.out.println("---------");
                    System.out.println("Es mayor. Prueba otra vez.");
                    System.out.println("---------");
                }
                if (num == alea) {
                    System.out.println("¡Acertaste! El número era el " + alea);
                }
            }
        } while (num != alea);

    }
}
