/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ieszaidinvergeles.juegosdecartas.blackjack;

import java.io.Serializable;
import java.util.ArrayList;
import org.ieszadinvergeles.juegosdecartas.Carta;

/**
 *
 * @author Pablo
 */
public class Jugador implements Comparable<Jugador>, Serializable {

//ATRIBUTOS PRIVADOS
    private String nombre;
    private int bolsa;
    private int apuesta;
    private ArrayList<Carta> cartas = new ArrayList<>();
    static final long serialVersionUID = 2L;

//CONSTRUCTORES
    public Jugador(String nombre, int bolsa) {
        this.nombre = nombre;
        this.bolsa = bolsa;
    }

//MÉTODOS
    public String getNombre() {
        return nombre;
    }

    public int getBolsa() {
        return bolsa;
    }

    public int getApuesta() {
        return apuesta;
    }

    public int getPuntuacion() {
        int puntuacion = 0;
        //Recorremos las cartas sumándolas
        for (Carta misCartas : cartas) {
            puntuacion += misCartas.getValor().getValue();
        }
        return puntuacion;
    }
    
    //Método para volver a poner a 0 las apuestas
    public int reiniciarApuesta(){
        return apuesta = 0;
    }
    
    //Para reflejar que el AS puede valer 1, le restamos 10 a la puntuación total
    public int cambiarValorAs(){
        return this.getPuntuacion() - 10;
    }

    public void pedirCarta(Carta c) {
        cartas.add(c);
    }

    public boolean apostar(int apuesta) {
        boolean correcto = false;
        if (this.bolsa >= apuesta && apuesta > 0) {
            this.apuesta = apuesta;
            correcto = true;
        }
        return correcto;
    }

    public void apuestaGanada() {
        bolsa += apuesta;
    }

    public void apuestaPerdida() {
        bolsa -= apuesta;
    }
    
    //Recogemos las cartas de la ronda
    public void cartasNuevas(){
        cartas.clear();
    }

    @Override
    public String toString() {
        return nombre
                + ", con una bolsa de " + bolsa + "€";
    }

    @Override
    public int compareTo(Jugador j) {
        int resultado = 0;
        if (this.getPuntuacion() > j.getPuntuacion()) {
            resultado = -1;
        }
        if (this.getPuntuacion() < j.getPuntuacion()) {
            resultado = 1;
        }
        return resultado;
    }
}
