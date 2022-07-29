/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego3enraya;

import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Juego3enRaya {
// ATRIBUTOS PRIVADOS
    //constantes que representan a los jugadores

    private static final String[] TIPO_FICHA = {"-", "X", "O"};
    //nombre de los jugadores
    private static final String[] jugadores = new String[2];
    //boolean para determinar el turno
    private static int turno = 1;
    //tablero donde jugamos
    private static int [][]tablero;
    
//PROGRAMA PRINCIPAL

    public static void main(String[] args) {
        // inicializamos el tablero de 3x3 
        tablero = new int[3][3];
        inicializarTablero(tablero);
        System.out.println("Introduce el nombre de los jugadores.");
        System.out.println("Jugador 1: ");
        jugadores[0] = leerString();
        System.out.println("Jugador 2: ");
        jugadores[1] = leerString();
        System.out.println("Juegan " + jugadores[0] + " vs " + jugadores[1]);
        // variable para determinar el ganador, incluyendo cuando no gana nadie(tablero completo, 0)
        int ganador = 0;
        do {
            mostrarTablero(tablero);
            System.out.println("Le toca a " + jugadores[turno - 1]);
            int x, y;
            do {
                x = leerNumeroEntero("Introduzca la fila", 0, 4);
                y = leerNumeroEntero("Introduzca la columna", 0, 4);
            } while (!colocarFicha(tablero, turno, x, y));
            if (hayGanador(tablero)) {
                ganador = turno;
            }
            //para cambiar el turno
            turno = (turno == 1) ? 2 : 1;

        } while ((ganador == 0) && !juegoTerminado(tablero));
        mostrarTablero(tablero);
        if (ganador != 0) {
            System.out.println("El ganador es " + jugadores[ganador - 1]);
        } else {
            System.out.println("No hay ganador, tablero completo.");
        }
    }

    public static String leerString() {
        Scanner sc = new Scanner(System.in);
        String texto;
        while (sc.hasNextInt()) {
            sc.next();
            System.out.println("El nombre solo puede estar compuesto de caracteres. Vuelva a introducirlo: ");
        }
        texto = sc.nextLine();
        return texto;
    }

    public static int leerNumeroEntero(String mensaje, int minimo, int maximo) {
        Scanner sc = new Scanner(System.in);
        int numero;
        do {
            System.out.println(mensaje);
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("No ha introducido un número. Vuelva a introducirlo: ");
            }
            numero = sc.nextInt();
        } while (numero < minimo || numero > maximo);

        return numero;
    }

//FUNCIONES DEL JUEGO (Métodos públicos)
    //Tablero inicial vacío
    private static void inicializarTablero(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = 0;
            }
        }
    }

    // Visualizará el tablero en pantalla de forma apropiada para que el usuario lo entienda, 
    // habrá que escribir O o X para representar las fichas de los jugadores, en lugar de valores numéricos.
    public static void mostrarTablero(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(TIPO_FICHA[tablero[i][j]]);
            }
            System.out.println("");
        }
    }

    // Coloca la ficha en la posición indicada por las coordenadas x,y. 
    // Devuelve true si ha habido éxito y false si no.
    public static boolean colocarFicha(int[][] tablero, int ficha, int x, int y) {
        //comprobamos que la posición está libre 
        boolean libre = (tablero[x][y] == 0);
        //si está libre asignamos la posición
        if (libre) {
            tablero[x][y] = ficha;
        }
        return libre;
    }

    // Devuelve true si en el tablero hay tres fichas en línea o false en caso contrario.
    public static boolean hayGanador(int[][] tablero) {
        boolean ganador = false;

        //Comprobación de filas
        for (int x = 0; x < 3; x++) {
            if ((tablero[x][0] == tablero[x][1]) && (tablero[x][0] == tablero[x][2]) && (tablero[x][0] != 0)) {
                ganador = true;
            }
        }
        //Comprobación de columnas
        for (int y = 0; y < 3; y++) {
            if ((tablero[0][y] == tablero[1][y]) && (tablero[2][y] == tablero[0][y]) && (tablero[0][y] != 0)) {
                ganador = true;
            }
        }

        //Comprobación de diagonal (de 0,0 a 2,2)
        if ((tablero[0][0] == tablero[1][1]) && (tablero[2][2] == tablero[0][0]) && (tablero[0][0] != 0)) {
            ganador = true;
        }

        //Comprobación de diagonal inversa
        if ((tablero[0][2] == tablero[1][1]) && (tablero[2][0] == tablero[0][2]) && (tablero[2][0] != 0)) {
            ganador = true;
        }

        return ganador;

    }

    // Devuelve true si el tablero está completo y false si aún quedan casillas vacías.
    public static boolean juegoTerminado(int[][] tablero) {
        boolean terminado = true;

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 0) {
                    terminado = false;
                }
            }
        }
        return terminado;

    }
}