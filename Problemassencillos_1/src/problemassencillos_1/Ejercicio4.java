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
public class Ejercicio4 {

    //
    // Pedir un número entre 0 y 9.999 y decir cuántas cifras tiene. No se pueden usar métodos de la clase String.
    //
    public static void main(String[] args) {

        // Variables
        Scanner teclado = new Scanner(System.in);
        int numero;
        final int MIN = 0, MAX = 9999;
        int contador = 0;

        // Validación del número introducido
        do {
            System.out.println("Introduzca un número entre 0 y 9999");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            numero = teclado.nextInt();
        } while (numero < MIN || numero > MAX);

        // Cálculo de los dígitos del número usando for 
        if (numero == 0) {
            System.out.println("El número " + numero + " tiene 1 dígito");
        } else {
            for (int i = 1; i <= numero; i *= 10) {
                if (numero / i > 0) {
                    ++contador;
                }
            }
            System.out.println("El número " + numero + " tiene " + contador + " dígitos");
        }

        
    }
}
