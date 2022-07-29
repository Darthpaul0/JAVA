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
public class Capicúa {

    public static void main(String[] args) {
        esCapicua(0);
    }

    public static boolean esCapicua(int numero) {
        // Empezamos por validar el número introducido
        // Descomponemos el número diviendo en centésimas, décimas, unidades
        // Guardamos el valor de la primera y la última división
        // Comparamos esos valores y en caso de ser iguales el número será capicúa

// VARIABLES
        Scanner teclado = new Scanner(System.in);
        int num;
        final int MINNUM = 0;
        int primerdigito;
        int ultimodigito = 0;

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

// DESCOMPOSICIÓN
// Obtención del último dígito
        primerdigito = num % 10;

        // Obtención del primer dígito
        for (int i = 1; i < num; i *= 10) {
            ultimodigito = num / i;

        }

// COMPROBACIÓN DE QUE EL PRIMER Y EL ÚLTIMO DÍGITO SON IGUALES
        if (primerdigito - (ultimodigito) == 0) {
            System.out.println("El número es capicúa");
        } else {
            System.out.println("El número no es capicúa");
        }
        return false;
    }
}
