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
public enum PaloNaipe implements Serializable{

    PICAS("Picas"), CORAZONES("Corazones"), TREBOLES("Tréboles"),DIAMANTES("Diamantes");
    
    
//ATRIBUTOS
    private String palo;
    static final long serialVersionUID = 2L;
    
//CONSTRUCTOR
    private PaloNaipe(String palo) {
        this.palo = palo;
    }
    
//MÉTODOS
    public String getName(){
        return palo;
    }

    @Override
    public String toString() {
        
        return palo;
    }
    
    
}
