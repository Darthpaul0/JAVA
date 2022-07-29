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
public class Ejercicio5 {

    /**
     *
     * Calcula el número de años, meses, semanas y días, dado un determinado número de días introducido por teclado.
     */
    public static void main(String[] args) {
        // Validamos
        // Calculamos
        // Mostramos por pantalla

// VARIABLES
        Scanner teclado = new Scanner(System.in);
        int numdias;
        final int MINDIAS = 0;
        int años, meses, semanas, dias;

// VALIDACIÓN
        do {
            System.out.println("Introduce un número de días");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            numdias = teclado.nextInt();
        } while (numdias < MINDIAS);

// CÁLCULO DE AÑOS, MESES, SEMANAS Y DÍAS
        // Cálculo de años
        años = (int) (numdias / 365);
        // Cálculo de meses
        meses = (int) (numdias % 365) / 30;
        // Cálculo de semanas
        semanas = (int) ((numdias % 365 % 30) / 7);
        // Cálculo de dias
        dias = (int)(numdias % 365 % 30 % 7);

// RESULTADO FINAL
        System.out.println("---------------------------------------------");
        System.out.println(numdias + " días equivalen a:");
        System.out.println("AÑOS: " + años);
        System.out.println("MESES: " + meses);
        System.out.println("SEMANAS: " + semanas);
        System.out.println("DÍAS: " + dias);

    }
}
