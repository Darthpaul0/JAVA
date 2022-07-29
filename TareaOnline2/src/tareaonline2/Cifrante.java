/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaonline2;

import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Cifrante {

    public static void main(String[] args) {

        //Variables
        Scanner teclado = new Scanner(System.in);
        final String abecedario = "abcdefghijklmnñopqrstuvwxyz"; //a partir de aquí posicionamos las letras
        String cifrado = ""; //variable que almacena el mensaje cifrado
        String mensaje; //variable que almacena el mensaje original
        int k; //variable que almacena la clave para cifrar
        int letra; // posicion de las letras en el abecedario

        //Introducción y validación del mensaje introducido
        do {
            System.out.println("Mensaje que quieres cifrar");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNext()) {
                teclado.next(); //si lo que se ha introducido no es una cadena lo sacamos del buffer
                System.out.println("El valor introducido no es una cadena, vuelva a intentarlo:");
            }
            mensaje = teclado.next();

        } while (mensaje == "");

        //Introducción y validación de la clave introducida
        do {
            System.out.println("Clave de cifrado");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no un número, vuelva a intentarlo:");
            }
            k = teclado.nextInt();

        } while (k >= 26 || k <= 1);

        // paso a minúsculas del mensaje
        mensaje = mensaje.toLowerCase();

        // proceso de cifrado del mensaje
        for (int i = 0; i < mensaje.length(); i++) { //recorremos el mensaje original
            letra = abecedario.indexOf(mensaje.charAt(i)); //calculamos la posición de las letras en el abecedario
            if (letra >= 0) {
                cifrado += abecedario.charAt((letra + k) % abecedario.length()); //el módulo se utiliza en caso de que al cifrar sobrepasemos la última letra del alfabeto
            } else {
                cifrado += mensaje.charAt(i);
            }
        }
        System.out.println("El mensaje cifrado sería: " + cifrado);

    }
}
