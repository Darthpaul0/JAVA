/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotrivial1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Pablo
 */
public class Pregunta implements Serializable {

    //Atributos privados
    private String enunciado;
    private String respuestas[];
    private int correcta;

    //Constructor
    public Pregunta(String enunciado, String[] respuestas, int correcta) {
        this.enunciado = enunciado;
        this.respuestas = respuestas;
        this.correcta = correcta;
    }

    //Getters y setters
    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(String[] respuestas) {
        this.respuestas = respuestas;
    }

    public int getCorrecta() {
        return correcta;
    }

    public void setCorrecta(int correcta) {
        this.correcta = correcta;
    }

    //Métodos públicos
    public boolean esRespuestaCorrecta(int indice) {
        return indice == correcta;
    }

    @Override
    public String toString() {
        return this.getEnunciado() + "\n" + Arrays.toString(this.respuestas) + "\n" +"correcta= " + this.getCorrecta();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pregunta other = (Pregunta) obj;
        if (this.correcta != other.correcta) {
            return false;
        }
        if (!Objects.equals(this.enunciado, other.enunciado)) {
            return false;
        }
        if (!Arrays.deepEquals(this.respuestas, other.respuestas)) {
            return false;
        }
        return true;
    }

}
