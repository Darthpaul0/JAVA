/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // VARIABLES
        Scanner teclado = new Scanner(System.in);
        int opción;
        final int MIN = 1, MAX = 3;

        //LECTURA Y VALIDACIÓN DE LA OPCIÓN ELEGIDA
        do {
            // MENÚ DE OPCIONES PARA EL USUARIO
            System.out.println("----------------------------------------");
            System.out.println("Puede realizar las siguientes opciones con el mensaje: ");
            System.out.println("1.- Cifrar un mensaje.");
            System.out.println("2.- Descifrar un mensaje.");
            System.out.println("3.- Salir.");
            System.out.println("¿Qué quiere hacer?");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }
            opción = teclado.nextInt();

            // Si el usuario elige alguna opción no válida, no entramos a valorarla
            if (opción < MIN || opción > MAX) {
                System.out.println("------------------------");
                System.out.println("La opción elegida no es válida.");
            } else {

                // ESTRUCTURA SWITCH 
                switch (opción) {
                    case 1:
                        System.out.println("Ha elegido la opción 1.- Cifrar el mensaje.");
                        System.out.println("---------------------------------------------");
                        Cifrador();
                        break;
                    case 2:
                        System.out.println("Ha elegido la opción 2.- Descifrar el mensaje.");
                        System.out.println("---------------------------------------------");
                        Descifrador();
                        break;
                    case 3:
                        System.out.println("Ha elegido salir. ¡Adiós!");
                        break;
                }
            }

        } while (opción != MAX);

    }

    public static String Cifrador() {

        //Variables
        //Variables
        Scanner teclado = new Scanner(System.in);
        final String abecedario = "abcdefghijklmnñopqrstuvwxyz";
        String clave; // clave de cifrado utilizada por el usuario
        String cifrado = ""; //variable que almacena el mensaje cifrado
        String mensaje; //variable que almacena el mensaje original
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
            mensaje = teclado.nextLine();
            mensaje = mensaje.replaceAll(" ", "");

        } while (mensaje == "");

        //Introducción y validación de la clave introducida
        do {
            System.out.println("Introduzca la clave de cifrado.Recuerde que debe cubrir todo el abecedario.");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNext()) {
                teclado.next(); //si lo que se ha introducido no es una cadena lo sacamos del buffer
                System.out.println("El valor introducido no es una cadena, vuelva a intentarlo:");
            }
            clave = teclado.next();

        } while (clave.length() != 27);

        // paso a minúsculas del mensaje
        mensaje = mensaje.toLowerCase();

        // proceso de cifrado del mensaje
        for (int i = 0; i < mensaje.length(); i++) { //recorremos el mensaje original
            letra = abecedario.indexOf(mensaje.charAt(i)); //calculamos la posición de las letras en el abecedario normal
            cifrado += clave.charAt(letra); // traducimos al nuevo alfabeto  
        }
        System.out.println("El mensaje cifrado sería: " + cifrado);
        return null;
    }

    public static String Descifrador() {
        Scanner teclado = new Scanner(System.in);
        final String abecedario = "abcdefghijklmnñopqrstuvwxyz";
        String clave; // clave de cifrado utilizada por el usuario
        String descifrado = ""; //variable que almacena el mensaje descifrado
        String mensaje; //variable que almacena el mensaje original
        int letra; // posicion de las letras en el abecedario

        //Introducción y validación del mensaje introducido
        do {
            System.out.println("Mensaje que quieres descifrar");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNext()) {
                teclado.next(); //si lo que se ha introducido no es una cadena lo sacamos del buffer
                System.out.println("El valor introducido no es una cadena, vuelva a intentarlo:");
            }
            mensaje = teclado.nextLine();
            mensaje = mensaje.replaceAll(" ", "");

        } while (mensaje == "");

        //Introducción y validación de la clave introducida
        do {
            System.out.println("Introduzca la clave de cifrado. Recuerde que debe cubrir todo el abecedario.");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNext()) {
                teclado.next(); //si lo que se ha introducido no es una cadena lo sacamos del buffer
                System.out.println("El valor introducido no es una cadena, vuelva a intentarlo:");
            }
            clave = teclado.next();

        } while (clave.length() != 27);

        // paso a minúsculas del mensaje
        mensaje = mensaje.toLowerCase();

        // proceso de cifrado del mensaje
        for (int i = 0; i < mensaje.length(); i++) { //recorremos el mensaje original
            letra = clave.indexOf(mensaje.charAt(i)); //calculamos la posición de las letras en el abecedario normal
            descifrado += abecedario.charAt(letra); // traducimos al nuevo alfabeto  
        }
        System.out.println("El mensaje cifrado sería: " + descifrado);
        return null;
    }
}
