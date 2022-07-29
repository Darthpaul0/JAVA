/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coeficientesbinomiales;

import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class CoeficientesBinomiales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = validarEntero("Introduzca el valor de n");
        int k = validarEntero("Introduzca el valor de k");
        System.out.println("Coeficiente binomial para los números " + n + " y "
                + k + " es igual a " + coeficienteBinomial(n, k));
    }

    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Número negativo.");
        }
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;

    }

    public static int coeficienteBinomial(int n, int k) {

        if (n < 0 || k < 0) {
            throw new IllegalArgumentException("Número negativo.");
        }
        if (n < k) {
            throw new IllegalArgumentException("Número negativo.");
        }
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

   public static int validarEntero(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(mensaje);
        int num;
        final int MIN = 0;
        do {
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
