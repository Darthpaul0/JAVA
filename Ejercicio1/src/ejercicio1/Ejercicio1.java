/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //VARIABLES
        Scanner teclado = new Scanner(System.in);
        final int MIN = 1;
        int numero;

        // validación de datos introducidos
        do {
            System.out.println("Introduzca un número");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }
            numero = teclado.nextInt();

        } while (numero <= MIN);
        
        // explicación de lo que vamos a mostrar
        System.out.println("Secuencia de Ullman para el número " + numero + ":");
        System.out.println("---------------------------------------------");
        System.out.println(numero);
        
        // proceso de cálculo
        while (numero != 1) { // mientras el número no sea igual a 1, permanecemos en el bucle

            if (numero % 2 == 0) { // vemos si es impar
                numero = numero / 2;
            } else { // si es impar
                numero = numero * 3 + 1;
            }
            System.out.println(numero); //mostramos los números por pantalla
        }
        
    }
    
}
