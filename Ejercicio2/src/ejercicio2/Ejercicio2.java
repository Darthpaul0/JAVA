/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num = 1; // contador
        int sophie; // número de Sophie German
        System.out.println("Números de Sophie Germain hasta 100:");
        // proceso de cálculo
        while (num <= 100) {
            sophie = num * 2 + 1;
            if (esPrimo(num) == true && esPrimo(sophie) == true) {
                System.out.println(num);
            }
            num++;
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
