/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ieszadinvergeles.juegosdecartas;

import java.io.Serializable;

/**
 *
 * @author Pablo
 */
public class Carta implements Comparable<Carta>, Serializable {

    //ATRIBUTOS PRIVADOS
    private RangoNaipe valor;
    private PaloNaipe palo;
    static final long serialVersionUID = 2L;

    //CONSTRUCTOR
    public Carta(RangoNaipe valor, PaloNaipe palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public RangoNaipe getValor() {
        return valor;
    }

    public PaloNaipe getPalo() {
        return palo;
    }

    //MÉTODOS
    public boolean equals(Carta carta) {
        Carta nueva = (Carta) carta;
        return (nueva.getPalo() == this.getPalo() && nueva.getValor() == this.getValor());
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }
    @Override
    public int compareTo(Carta o) {
        int resultado = 0;
        if (this.getValor().getValue()<o.getValor().getValue()) {
            resultado = -1;
        }
        if (this.getValor().getValue() > o.getValor().getValue()) {
            resultado = 1;
        }
        return resultado;
    }
}
