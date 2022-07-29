/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundo;

import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Pruebas2 {
    public static void main(String[] args) {
        leerEdad("Edad: ");
    }
    
    public static int leerEdad(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        int num;
        final int MIN = 18;
        final int MAX = 99;
        do {
            System.out.print(mensaje);
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()){
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número entero, vuelva a intentarlo:");
            }
            num = teclado.nextInt();
            if(num < MIN || num > MAX){
                System.out.println("No contratamos a personas que no están ya en edad de conducir.");
            }
        } while (num <= MIN || num > MAX);
        return num;
    }
}
