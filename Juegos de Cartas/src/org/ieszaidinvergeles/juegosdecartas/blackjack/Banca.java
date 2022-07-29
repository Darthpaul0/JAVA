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
public class Banca implements Serializable{

    //ATRIBUTOS PRIVADOS
    private int bolsa = 100000;
    private ArrayList<Carta> cartas = new ArrayList<>();
    static final long serialVersionUID = 2L;

//CONSTRUCTORES
    public Banca(int bolsa) {
        this.bolsa = bolsa;
    }

//MÉTODOS
    public int getBolsa() {
        return bolsa;
    }

    public int getPuntuacion() {
        int puntuacion = 0;
        //Recorremos las cartas sumándolas
        for (Carta misCartas : cartas) {
            puntuacion += misCartas.getValor().getValue();
        }
        return puntuacion;
    }
    
    //Para reflejar que el AS puede valer 1, le restamos 10 a la puntuación total
    public int cambiarValorAs(){
        return this.getPuntuacion() - 10;
    }

    public void pedirCarta(Carta c) {
        cartas.add(c);
    }
    
    //Método para sumar o restar las apuestas 
    public void actualizoBolsa(int cantidad){
        bolsa += cantidad;
    }
    
    //Recogemos las cartas de la ronda
    public void cartasNuevas(){
        cartas.clear();
    }
    
    //Método para mostrar la primera carta de la banca
    public String mostrarCarta(){
        return cartas.get(0).toString();
    }

    @Override
    public String toString() {
        return "La banca cuenta con una bolsa de " + bolsa;
    }
}
