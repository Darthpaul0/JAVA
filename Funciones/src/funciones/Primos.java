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
public class Primos {

    public static void main(String[] args) {
        esPrimo(0);
    }

    public static boolean esPrimo(int numero) {
        // Definimos las variables
        int num;
        int raiz;
        boolean primo = true;
        Scanner teclado = new Scanner(System.in);

        //Pedimos el número por teclado
        System.out.println("Introduce un número");
        num = teclado.nextInt();

        // Calculamos la raíz del número primo y nos quedamos con el entero
        raiz = (int) Math.sqrt(num);

        // Para saber si un número es primo, dividimos usando un bucle for desde 2 hasta la raíz de ese número.
        for (int i = 2; i <= raiz; i++) {
            if (num % i == 0) {
                primo = false;
            }
        }
        if (primo == true) {
            System.out.println("El número " + num + " es primo");
        } else {
            System.out.println("El número " + num + " no es primo");
        }
        return false;
    }
}
