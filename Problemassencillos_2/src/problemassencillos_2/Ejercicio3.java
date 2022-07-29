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
public class Ejercicio3 {

    /**
     * Pedir el día, mes y año de una fecha e indicar si la fecha es correcta. Con meses de 28/29, 30 y 31 días (habrá que comprobar si el año es bisiesto).
     */
    public static void main(String[] args) {
        /**
         * Primero pedimos los datos y después comprobamos si la fecha es correcta Hay que comprobar si el año es bisiesto Usaremos un switch para los meses
         */
        // Validamos que los datos introducidos sean números
        // 
        Scanner teclado = new Scanner(System.in);
        int dias;
        final int MINDIAS = 1, MAXDIAS = 31;
        int mes;
        final int MINM = 1, MAXM = 12;
        int año;
        final int MINS = 0;

        do {
            System.out.println("Introduce un día entre 1 y 31");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            dias = teclado.nextInt();
        } while (dias > MAXDIAS || dias < MINDIAS);

        // validación de los meses
        do {
            System.out.println("Introduce un mes entre 1 y 12");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            mes = teclado.nextInt();
        } while (mes > MAXM || mes < MINM);

        // validación de los años
        do {
            System.out.println("Introduce un año");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            año = teclado.nextInt();
        } while (año < MINS);

        // pasamos a la comprobación de los datos
        switch (mes) {
            // meses con 31 días
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (dias > 31) {
                    System.out.println("La fecha es incorrecta");
                } else {
                    System.out.println("La fecha es correcta");
                }
                break;
            case 2:
                // comprobación de año bisiesto
                if ((año % 4 == 0) && ((año % 100 != 0) || (año % 400 == 0))) {
                    if (dias > 29) {
                        System.out.println("La fecha es incorrecta");
                    } else {
                        System.out.println("La fecha es correcta");
                    }
                } else if (dias < 29) {
                    System.out.println("La fecha es correcta");
                } else {
                    System.out.println("La fecha es incorrecta");
                }
                break;
            //meses con 30 días    
            case 4:
            case 6:
            case 9:
            case 11:
                if (dias > 30) {
                    System.out.println("La fecha es incorrecta");
                } else {
                    System.out.println("La fecha es correcta");
                }
                break;

        }
    }
}
