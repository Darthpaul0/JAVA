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
public class Ejercicio3 {

    //
    // Escribe un programa que determine el elemento n-ésimo de la Serie de Fibonacci. El número n será
    // introducido por teclado. La Serie de Fibonacci se calcula así:
    // F(0) = 0
    // F(1)=1
    // F(n) = F(n-1)+F(n-2), para n>1
    //
    public static void main(String[] args) {
        // Pedimos y validamos que los datos introducidos por teclado sean un número entero y no caracteres
        // Aplicamos la fórmula teniendo en cuenta las excepciones
        // Lo que haremos será calcular el número anterior al original, y así ir sumando.
        // Mostramos por pantalla el resultado

        // VARIABLES
        Scanner teclado = new Scanner(System.in);

        int num = 1, anterior = 0, siguiente = 1;
        final int MIN = 0;

        // VALIDACIÓN DE DATOS
        do {
            System.out.println("Introduzca un número");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            num = teclado.nextInt();
        } while (num < MIN);
        
        //  CALCULAMOS EL NÚMERO SEGÚN LA FÓRMULA
        
        if (num > 1) {
            for (int i = 2; i <= num; i++) {
                siguiente = anterior + siguiente;
                anterior = siguiente - anterior;
            }
            System.out.println("POSICIÓN: " + num);
            System.out.println("NÚMERO FIBONACCI: " + siguiente);
        }
        if (num == 0) {
            System.out.println("POSICIÓN: " + num);
            System.out.println("NÚMERO FIBONACCI: " + anterior);
        } else if (num == 1) {
            System.out.println("POSICIÓN: " + num);
            System.out.println("NÚMERO FIBONACCI: " + siguiente);
        }

    }
}
