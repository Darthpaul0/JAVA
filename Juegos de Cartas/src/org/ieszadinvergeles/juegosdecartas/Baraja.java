/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ieszadinvergeles.juegosdecartas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Pablo
 */
public class Baraja implements Serializable{

    //ATRIBUTOS PRIVADOS
    private ArrayList<Carta> mazo = new ArrayList<>();
    static final long serialVersionUID = 2L;

    //CONSTRUCTORES
    public Baraja() {
        //Bucle para sacar los palos
        for (PaloNaipe palos : PaloNaipe.values()) {
            //Bucle para los valores de las cartas
            for(RangoNaipe valores: RangoNaipe.values()){
                mazo.add(new Carta(valores, palos));
            }
        }
    }

    //MÉTODOS
    public Carta sacarCarta() {
        Carta miCarta = null;
        //Comprobamos que el mazo no esté vacío
        if (!mazo.isEmpty()) {
            //Sacamos la carta
            miCarta = mazo.get(0);
            //La eliminamos de la baraja
            mazo.remove(0);
        }
        return miCarta;
    }

    public void barajar() {
        Collections.shuffle(mazo);
    }

}
