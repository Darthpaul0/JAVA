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
public class Ejercicio5 {

    //
    // Realiza un programa que lea dos valores reales y nos muestre los resultados de sumar, restar, dividir
    // y multiplicar dichos números. Para ello se mostrará al usuario un menú de opciones para elegir la
    // operación que desea realizar.
    //
    public static void main(String[] args) {

        // 
        // Pedimos dos números reales y los validamos 
        // Pedimos que se elija una operación
        // Mostramos por pantalla el resultado de la operación
        //
        // VARIABLES 
        Scanner teclado = new Scanner(System.in);
        float primero, segundo, suma, resta, multiplicación, división;
        int opción;
        final int MIN = 1, MAX = 4;

        // Validación del primer número real (comprobación de que es un número
        System.out.println("Introduzca el primer número");
        //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
        //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
        while (!teclado.hasNextInt()) {
            teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
            System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
        }

        primero = teclado.nextInt();

        // Validación del segundo número real (comprobación de que es un número
        System.out.println("Introduzca el segundo número");
        //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
        //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
        while (!teclado.hasNextInt()) {
            teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
            System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
        }

        segundo = teclado.nextInt();

        // Ofrecemos las opciones al usuario
        System.out.println("----------------------------------------");
        System.out.println("Puede realizar las siguientes opciones con los números: ");
        System.out.println("1. Sumarlos");
        System.out.println("2. Restarlos");
        System.out.println("3. Dividirlos");
        System.out.println("4. Multiplicarlos");

        // Validamos que la opción elegida no es válida
        do {
            System.out.println("¿Qué quiere hacer?");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            opción = teclado.nextInt();
        } while (opción < MIN || opción > MAX);

        // Mostramos qué opción ha elegido
        System.out.println("----------------------------------------");
        System.out.println("Ha elegido la opción " + opción);
        System.out.println("----------------------------------------");

        // Pasamos a la estructura switch
        switch (opción) {
            case 1:
                suma = primero + segundo;
                System.out.println("El resultado de la suma es " + suma);
                break;
            case 2:
                resta = primero - segundo;
                System.out.println("El resultado de la resta es " + resta);
                break;
            case 3:
                multiplicación = primero * segundo;
                System.out.println("El resultado de la multiplicación es " + multiplicación);
                break;
            case 4:
                división = primero / segundo;
                System.out.println("El resultado de la división es " + división);
                break;
                default:
                    System.out.println("¡Elige una opción válida!");
        }

    }
}
