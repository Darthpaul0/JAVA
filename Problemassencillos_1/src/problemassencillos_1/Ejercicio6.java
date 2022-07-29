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
public class Ejercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num = 1; // contador
        Scanner teclado = new Scanner(System.in);
        final int MIN = 1;
        // proceso de cálculo
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
        if (esPrimo(num)==true){
            System.out.println("El número "+ num + " es primo");
        } else {
            System.out.println("El número "+ num + " no es primo");
        }
    }

    public static boolean esPrimo(int numero) {
        // Definimos las variables
        int raiz;
        boolean primo = true;
        Scanner teclado = new Scanner(System.in);

        
        // Calculamos la raíz del número primo y nos quedamos con el entero
        raiz = (int) Math.sqrt(numero);

        // Para saber si un número es primo, dividimos usando un bucle for desde 2 hasta la raíz de ese número.
        for (int i = 2; i <= raiz; i++) {
            if (numero % i == 0) {
                primo = false;
            }
        }
        return primo;
    }
}
