/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import org.ieszadinvergeles.juegosdecartas.Baraja;
import org.ieszadinvergeles.juegosdecartas.Carta;
import org.ieszadinvergeles.juegosdecartas.RangoNaipe;


/**
 *
 * @author Pablo
 */
public class Blackjack implements Serializable{
    
    //ATRIBUTOS PRIVADOS

    private static Baraja baraja;
    private static ArrayList<Jugador> jugadores; 
    private static Banca banca; 
    //Constante para criterio de cierre de la banca
    private static int plantarse = 17;
    static final long serialVersionUID = 2L;
    

    //CONSTRUCTOR

    public Blackjack(Baraja baraja, ArrayList<Jugador> jugadores, Banca banca, int plantarse) {
        this.baraja = baraja; 
        this.jugadores = jugadores; 
        this.banca = banca;
        this.plantarse = plantarse;
    }
    
    public Blackjack() {
        this.baraja = baraja; 
        this.jugadores = new ArrayList<>(); 
        this.banca = new Banca(100000);
        this.plantarse = plantarse;
    }
    
    //GETTERS

    public Baraja getBaraja() {
        return baraja;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public Banca getBanca() {
        return banca;
    }

    public int getPlantarse() {
        return plantarse;
    }
    
    
    //MÉTODOS

    public void inicializarJugadores() {
        //Preguntamos cuántos jugadores habrá siendo el mínimo 1 y el máximo 7
        int jugadoresTotales = validarJugadores("Introduzca cuántos jugadores participan", 1, 7);
        //Creamos el número de jugadores que participará
        int contador = 1;
        while (contador <= jugadoresTotales) {
            Jugador nuevoJugador = new Jugador(leerString("Nombre del jugador " + contador), leerEntero("Bolsa inicial"));
            jugadores.add(nuevoJugador);
            contador++;
        }
    }

    public static void rondaApuestas() {
        for (Jugador j : jugadores) {
            System.out.println("Hola " + j.getNombre() + ",¿quiere apostar?");
            String respuesta = leerString("Introduzca S para confirmar la apuesta");
            if ("S".equals(respuesta)) {
                //Si quiere apostar, le preguntamos la cantidad
                int apostado = leerEntero("Introduzca su apuesta");
                //Si la cantidad cumple con las condiciones, apuesta...
                if (j.apostar(apostado)) {
                    System.out.println("Apuesta realizada con éxito");
                    //...y si no
                } else {
                    System.out.println("No puede apostar esa cantidad.");
                }
            } else {
                System.out.println("No se ha realizado ninguna apuesta.");
            }
        }
    }

    public static void repartir() {
        //Le repartimos a los jugadores
        for (Jugador j : jugadores) {
            if (j.getApuesta() != 0) {
                j.pedirCarta(baraja.sacarCarta());
                j.pedirCarta(baraja.sacarCarta());
            }
        }
        //Ahora le repartimos a la banca
        banca.pedirCarta(baraja.sacarCarta());
        banca.pedirCarta(baraja.sacarCarta());
    }

    public static void turnoJugadores() {
        //Recorremos la lista de jugadores
        for (Jugador j : jugadores) {
            if (j.getApuesta() != 0) {
                String respuesta;
                do {
                    System.out.println("La banca juega con " + banca.mostrarCarta());
                    System.out.println(j.getNombre() + ", " + j.getPuntuacion() + " es tu puntuación actual, ¿quieres otra carta?");
                    respuesta = leerString("Introduzca C para pedir otra carta");
                    if ("C".equals(respuesta)) {
                        Carta nueva = baraja.sacarCarta();
                        j.pedirCarta(nueva);
                        //Aquí es donde comprobamos si el AS vale 11 ó 1, según nos convenga
                        if (nueva.getValor() == RangoNaipe.AS && j.getPuntuacion() > 21) {
                            j.cambiarValorAs();
                        }
                    }
                } while (j.getPuntuacion() <= 21 && respuesta.equals("C"));
                //A los que se pasen se lo decimos y le restamos el dinero
                if (j.getPuntuacion() > 21) {
                    System.out.println("Has perdido, tienes " + j.getPuntuacion() + " puntos, más suerte en la próxima.");
                    j.apuestaPerdida();
                    j.reiniciarApuesta();
                    //Añadimos el dinero perdedor a la banca
                    banca.actualizoBolsa(j.getApuesta());
                }
            }
        }
    }

    public static void turnoBanca() {
        //La banca pide cartas hasta llegar a plantarse o superior, pero siempre por debajo o igual a Blackjack
        do {
            Carta nueva = baraja.sacarCarta();
            banca.pedirCarta(nueva);
            //Aquí es donde comprobamos si el AS vale 11 ó 1, según nos convenga
            if (nueva.getValor() == RangoNaipe.AS && banca.getPuntuacion() > 21) {
                banca.cambiarValorAs();
            }
        } while (banca.getPuntuacion() <= 17);

        //Recorremos los jugadores para ver si paga o no
        for (Jugador j : jugadores) {
            //comprobamos que los jugadores no se han pasado
            if (j.getPuntuacion() <= 21) {
                //si la banca se pasa o tiene una puntuación menor, paga
                if (banca.getPuntuacion() > 21 || banca.getPuntuacion() < j.getPuntuacion()) {
                    //restamos la apuesta del jugador de la bolsa de la banca
                    banca.actualizoBolsa(-j.getApuesta());
                    //sumamos la apuesta al jugador
                    j.apuestaGanada();
                    j.reiniciarApuesta();
                } else {
                    //cobramos a los que pierden
                    j.apuestaPerdida();
                    j.reiniciarApuesta();
                    banca.actualizoBolsa(j.getApuesta());
                }
            }
        }
    }

    public static void mostrarPartida() {
        System.out.println("<<<<JUGADORES>>>>");
        for (Jugador j : jugadores) {
            System.out.println("Nombre: " + j.getNombre() + "//"
                    + "Puntos: " + j.getPuntuacion() + "//"
                    + "Bolsa actual: " + j.getBolsa());
        }
        System.out.println("<<<<BANCA>>>>");
        System.out.println("Puntos: " + banca.getPuntuacion() + "//"
                + "Bolsa actual: " + banca.getBolsa());

    }

    //comprobamos que los jugadores tengan dinero: los que no, se eliminan de la lista de jugadores
    public static void comprobarBolsas() {
        //Se necesita crear una lista alternativa para los jugadores sin blanca como solución al error java.util.ConcurrentModificationException
        ArrayList<Jugador> arruinados = new ArrayList<>();

        //Recorremos la lista de jugadores y los añadimos a la nueva lista
        for (Jugador arruinado : jugadores) {
            if (arruinado.getBolsa() == 0) {
                arruinados.add(arruinado);
            }
        }
        //Eliminamos a los jugadores
        jugadores.removeAll(arruinados);
    }

    //recogemos las cartas de los jugadores para poder empezar una nueva ronda
    public static void recogerCartas() {
        for (Jugador j : jugadores) {
            j.cartasNuevas();
        }
        banca.cartasNuevas();
    }
    
    public void partidaBlackJack(){
        String respuesta = null;

        do {
            //Comprobamos la bolsa de los jugadores
            comprobarBolsas();
            //Antes de empezar la partida, comprobamos que la banca tiene dinero para jugar y quedan jugadores
            if (banca.getBolsa() != 0 && !jugadores.isEmpty()) {
                //Solicitamos a los participantes que realicen sus apuestas
                rondaApuestas();

                //Una vez que han apostado, les repartimos dos cartas a cada uno
                //Antes hay que barajar y recoger las cartas de los jugadores
                baraja = new Baraja();
                baraja.barajar();
                recogerCartas();
                repartir();

                //ahora es el turno de los jugadores
                turnoJugadores();

                //ahora le toca a la banca
                turnoBanca();

                //recogemos las cartas
                //al final, mostramos el estado de la partida
                mostrarPartida();

                //Preguntamos si quieren jugar otra ronda
                System.out.println("¿Otra ronda?");
                respuesta = leerString("Introduzca S para jugar otra ronda");
            } else {
                System.out.println("No se puede empezar otra partida: la banca no tiene dinero o no quedan jugadores.");
                respuesta = "";
            }
        } while (respuesta.equals("S"));
        System.out.println("¡Adiós, buena partida!");
    }

    public static int leerEntero(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        int num;
        do {
            System.out.print(mensaje + ": ");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número entero, vuelva a intentarlo:");
            }
            num = teclado.nextInt();
            if (num <= 0) {
                System.out.println("Debe ser un número entero positivo mayor que 0.");
            }

        } while (num <= 0);
        return num;
    }

    public static String leerString(String mensaje) {
        System.out.print(mensaje + ": ");
        Scanner sc = new Scanner(System.in);
        String texto;
        texto = sc.nextLine();
        return texto;
    }

    public static int validarJugadores(String mensaje, int minimo, int maximo) {
        Scanner teclado = new Scanner(System.in);
        int num;
        final int MIN = minimo;
        final int MAX = maximo;
        do {
            System.out.print(mensaje + ": ");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número entero, vuelva a intentarlo:");
            }
            num = teclado.nextInt();
            if (num < MIN || num > MAX) {
                System.out.println("El número de jugadores debe estar entre 1 y 7.");
            }
        } while (num < MIN || num > MAX);
        return num;
    }

    
    
}
