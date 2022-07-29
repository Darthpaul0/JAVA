/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemassencillos_2;

import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Ejercicio2 {

    /**
     * Pedir una hora de la forma hora, minutos y segundos, y mostrar la hora en el siguiente segundo.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Hay que leer por teclado la hora, minutos y segundos
        // Después pasamos todo a segundos 
        // Transformamos el tiempo al formato HH:MM:SS añadiéndole un segundo.
        // Hay que validar que cada introducción de datos por teclado tenga lógica

        Scanner teclado = new Scanner(System.in);
        int horas;
        final int MINH = 0, MAXH = 24; // Las constantes hay que ponerlas en mayúscula
        int minutos;
        final int MINM = 0, MAXM = 60;
        int segundos;
        final int MINS = 0, MAXS = 60;
        int totalsegundos;
        int nuevahora;
        int nuevosminutos;
        int nuevossegundos;

        // validación de las horas
        do {
            System.out.println("Introduce una hora entre las 0 y las 23");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            horas = teclado.nextInt();
        } while (horas >= MAXH || horas <= MINH);

        // validación de los minutos
        do {
            System.out.println("Introduce un minuto entre 0 y 59");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            minutos = teclado.nextInt();
        } while (minutos >= MAXM || minutos <= MINM);

        // validación de los segundos
        do {
            System.out.println("Introduce un segundo entre 0 y 59");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            segundos = teclado.nextInt();
        } while (segundos >= MAXS || segundos <= MINS);

        // calculamos el total de segundos sumándole 1
        totalsegundos = horas * 3600 + minutos * 60 + segundos + 1;
        nuevahora = (int)(totalsegundos / 3600);
        nuevosminutos = (int)((totalsegundos % 3600)/60);
        nuevossegundos = (int)(totalsegundos % 3600 % 60); // AQUÍ ESTÁ EL FALLO --> ¡Resuelto!
        
        // vamos a mostrar por pantalla la nueva hora
        System.out.println("Ahora son las " + nuevahora + ":" + nuevosminutos + ":" + nuevossegundos);
    }
}
