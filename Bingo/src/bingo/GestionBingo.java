/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author deifont
 */
public class GestionBingo {

    private static final Random bombo = new Random();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean cantaBingo=false, cantaFila=false;
        
        ArrayList<Carton> jugadores = crearJugadores();
        
        Scanner sc = new Scanner(System.in);
        
        
        //mostrar los cartones generados
        System.out.println("CARTONES DE LOS JUGADORES");
        System.out.println("-------------------------");
        for(Carton c:jugadores){
            System.out.println(c);
            System.out.println("-------------------------");
        }
        
        int i=1;
        int bola;
        int filaCantada=0, bingoCantado=0;
        //Bucle principal del juego
        do{
            bola = sacarBola();
            System.out.println("Bola "+i+" = "+bola);
            for(Carton c:jugadores){
                if(c.marcarCasilla(bola)){
                    System.out.println("Se ha marcado una casilla en este cartón");
                    System.out.println(c);
                    if(!cantaFila && c.cantarFila()){
                        System.out.println("¡El cartón canta fila!");
                        filaCantada++;
                    } else if(cantaFila && c.cantarBingo()){
                        System.out.println("¡El cartón canta bingo!");
                        bingoCantado++;
                    }
                }
            }
            
            if(filaCantada>0){
                cantaFila=true;
            }
            if(bingoCantado>0){
                cantaBingo=true;
            }
            
            i++;
            System.out.println("Pulse una tecla para continuar....");
            sc.next();
        }while(!cantaBingo);
        
    }

    private static ArrayList<Carton> crearJugadores() {
     
        int numJugadores = leerNumero("Introduzca cuántos jugadores van a jugar al bingo [2,6]", 2, 6);
        ArrayList<Carton> listaJugadores = new ArrayList<>();
        for(int i=0;i<numJugadores;i++){
            listaJugadores.add(new Carton());
        }
        
        return listaJugadores;
        
    }
    
    private static int sacarBola(){
        return bombo.nextInt(50)+1;
    }


    private static int leerNumero(String mensaje, int min, int max) {

        Scanner sc = new Scanner(System.in);
        int numero;
//Leemos n
        do {
            System.out.println(mensaje);
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("Debe introducir un número");
            }
            numero = sc.nextInt();
        } while (numero < min || numero > max);

        return numero;
    }    
}
