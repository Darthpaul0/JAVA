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
public enum RangoNaipe implements Serializable {

    AS("As", 11), DOS("Dos", 2), TRES("Tres", 3), CUATRO("Cuatro", 4), CINCO("Cinco", 5),
    SEIS("Seis", 6), SIETE("Siete", 7), OCHO("Ocho", 8), NUEVE("Nueve", 9),
    DIEZ("Diez", 10), JACK("Jack", 10), QUEEN("Queen", 10), KING("King", 10);

//ATRIBUTOS
    private String nombre;
    private int valor;
    static final long serialVersionUID = 2L;

//CONSTRUCTOR
    private RangoNaipe(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

//MÉTODOS
    //Devuelve el nombre de la carta
    public String getName() {
        return nombre;
    }

    //Devuelve el valor de la carta
    public int getValue() {
        return valor;
    }

    @Override
    public String toString() {
        return "un " + nombre;
    }

}
