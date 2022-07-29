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
public class validarNumero {

    public static int validarEntero (int numero) {
        Scanner teclado = new Scanner(System.in);
        int num;
        final int MIN = 1;
        do {
            System.out.println("Introduzca un número");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }
            num = teclado.nextInt();

        } while (num <= MIN);
        return num;
    }
}
