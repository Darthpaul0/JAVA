/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ieszaidinvergeles.juegosdecartas.blackjack;

import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class JuegosDeCartas {}

//    public static void main(String[] args) {

        /*//Instanciamos la clase Blackjack
        Blackjack miBlackjack = new Blackjack();

        // Instancia de la clase encargada de serializar 
        Serializar serializo = new Serializar();

        int opcion;
        do {
            opcion = generarMenuPrincipal();
            System.out.println("Ha elegido la opción: " + opcion);
            switch (opcion) {
                case 1://Jugar al blackjack
                    if (miBlackjack.getJugadores().isEmpty()) {
                        //Empezamos la partida añadiendo los jugadores
                        miBlackjack.inicializarJugadores();
                    }

                    //Desarrollamos el juego
                    miBlackjack.partidaBlackJack();

                    break;

                case 2: {
                    int opcionCarga;
                    //Cargar una partida
                    do {
                        opcionCarga = generarMenuCargaPartidas();
                        switch (opcionCarga) {
                            case 1://Partida nueva
                                miBlackjack = (Blackjack) serializo.leerObjeto("CargarNuevaPartida.dat");
                                System.out.println("Carga realizada con éxito.");
                                break;
                            case 2://Última partida guardada
                                miBlackjack = (Blackjack) serializo.leerObjeto("PartidaGuardada.dat");
                                System.out.println("Carga realizada con éxito.");
                                break;
                            case 3://Máximo de jugadores
                                miBlackjack = (Blackjack) serializo.leerObjeto("CargarPartidaMaximoJugadores.dat");
                                System.out.println("Carga realizada con éxito.");
                                break;
                            case 4:
                                break;
                        }
                    } while (opcionCarga != 4);
                }
                break;

                case 3://Guardar la partida actual
                    String respuesta = leerString("Pulse S para guardar la partida actual");
                    if ("S".equals(respuesta)) {
                        serializo.escribirObjeto(miBlackjack, "PartidaGuardada.dat");
                        System.out.println("Guardado con éxito.");
                    } else {
                        System.out.println("La partida no será guardada.");
                    }
                    break;

                case 4://Salir
                    System.out.println("¡Hasta la próxima!");
                    break;
            }
        } while (opcion != 4);
    }

    public static int generarMenuPrincipal() {
        // Estructura del menú

        int opcion = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("-->>Menú de Juegos De Cartas<<--");
            System.out.println("Estas son las opciones disponibles.");
            System.out.println("------");
            System.out.println("1. Jugar al blackjack.");
            System.out.println("2. Cargar partida.");
            System.out.println("3. Guardar la partida actual.");
            System.out.println("4. Salir.");
            System.out.println("------");

            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }
            opcion = teclado.nextInt();

        } while (opcion < 1 || opcion > 5);

        return opcion;
    }

    public static int generarMenuCargaPartidas() {
        // Estructura del menú

        int opcionCarga = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("Aquí puede seleccionar alguna partida para cargar.");
            System.out.println("------");
            System.out.println("1. PartidaCargada1: Comenzar una nueva partida.");
            System.out.println("2. PartidaCargada2: Carga la última partida guardada.");
            System.out.println("3. PartidaCargada3: Carga una partida con el máximo de jugadores.");
            System.out.println("4. Volver al menú principal.");
            System.out.println("------");

            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }
            opcionCarga = teclado.nextInt();

        } while (opcionCarga < 1 || opcionCarga > 5);

        return opcionCarga;
    }

    public static String leerString(String mensaje) {
        System.out.print(mensaje + ": ");
        Scanner sc = new Scanner(System.in);
        String texto;
        texto = sc.nextLine();
        return texto;
    }

}*/
