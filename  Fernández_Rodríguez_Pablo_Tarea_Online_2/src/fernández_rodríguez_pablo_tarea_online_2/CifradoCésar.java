/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fernández_rodríguez_pablo_tarea_online_2;

import java.util.Scanner;
import java.lang.String;

/**
 *
 * @author Pablo
 */
public class CifradoCésar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // VARIABLES
        Scanner teclado = new Scanner(System.in);
        int opción;
        final int MIN = 1, MAX = 4;

        //LECTURA Y VALIDACIÓN DE LA OPCIÓN ELEGIDA
        do {
            // MENÚ DE OPCIONES PARA EL USUARIO
            System.out.println("----------------------------------------");
            System.out.println("Puede realizar las siguientes opciones con el mensaje: ");
            System.out.println("1.- Cifrar un mensaje.");
            System.out.println("2.- Descifrar un mensaje.");
            System.out.println("3.- Ataque de fuerza bruta.");
            System.out.println("4.- Salir.");
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
                        System.out.println("Ha elegido la opción 3.- Ataque de fuerza bruta.");
                        System.out.println("---------------------------------------------");
                        FuerzaBrutaCesar();
                        break;
                    case 4:
                        System.out.println("Ha elegido salir. ¡Adiós!");
                        break;
                }
            }

        } while (opción != MAX);
    }

    public static String Cifrador() {

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
        return null;
    }

    public static String Descifrador() {
        //Variables
        Scanner teclado = new Scanner(System.in);
        final String abecedario = "abcdefghijklmnñopqrstuvwxyz"; //a partir de aquí posicionamos las letras
        String descifrado = ""; //variable que almacena el mensaje descifrado
        String mensaje; //variable que almacena el mensaje original
        int k; //variable que almacena la clave para cifrar
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
            mensaje = teclado.next();

        } while (mensaje == "");

        //Introducción y validación de la clave introducida
        do {
            System.out.println("Clave de cifrado");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNext()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no un número, vuelva a intentarlo:");
            }
            k = teclado.nextInt();

        } while (k >= 26 || k <= 1);

        // paso a minúsculas del mensaje
        mensaje = mensaje.toLowerCase();

        // proceso de descifrado del mensaje
        for (int i = 0; i < mensaje.length(); i++) { //recorremos el mensaje original
            letra = abecedario.indexOf(mensaje.charAt(i)); //calculamos la posición de las letras en el abecedario
            if (letra >= 0) {
                descifrado += abecedario.charAt(Math.abs((letra - k)) % abecedario.length()); //el módulo se utiliza en caso de que al cifrar sobrepasemos la última letra del alfabeto
            } else {
                descifrado += mensaje.charAt(i);
            }
        }
        System.out.println("El mensaje descifrado sería: " + descifrado);
        return null;
    }
    
    public static String FuerzaBrutaCesar(){
        
        //Variables
        Scanner teclado = new Scanner(System.in);
        final String abecedario = "abcdefghijklmnñopqrstuvwxyz"; //a partir de aquí posicionamos las letras
        String descifrado = ""; //variable que almacena el mensaje descifrado
        String mensaje; //variable que almacena el mensaje original
        int k = 1; //variable que almacena la clave para cifrar
        int contador = 1;
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
            mensaje = teclado.next();

        } while (mensaje == "");

        // paso a minúsculas del mensaje
        mensaje = mensaje.toLowerCase();
        
        // proceso de descifrado del mensaje y muestra de todas las posibles claves
        while(k>0 && k<=27){
        for (int i = 0; i < mensaje.length(); i++) { //recorremos el mensaje original
            letra = abecedario.indexOf(mensaje.charAt(i)); //calculamos la posición de las letras en el abecedario
            if (letra >= 0) {
                descifrado += abecedario.charAt(Math.abs((letra - k + abecedario.length())) % abecedario.length()); //el módulo se utiliza en caso de que al cifrar sobrepasemos la última letra del alfabeto
            } else {
                descifrado += mensaje.charAt(i);
            }
        }
        System.out.println("El mensaje descifrado con clave " +k+ " sería: " + descifrado);
        descifrado = "";
        k++;
        }
        return null;
    }
}
