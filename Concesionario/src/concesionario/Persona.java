/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

import java.io.Serializable;

/**
 *
 * @author Pablo
 */
public abstract class Persona implements Serializable, Comparable<Persona> {

    //ATRIBUTOS PRIVADOS
    private String nombre;
    private String apellidos;
    private String DNI; //el DNI debe ser válido
    private int Edad; //la edad debe ser mayor de 18
    static final long serialVersionUID = 1L;

    //CONSTRUCTOR
    public Persona(String nombre, String apellidos, String DNI, int Edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        if (!DNI.matches("\\d{8}[A-HJ-NP-TV-Z]")) {
            throw new IllegalArgumentException("El DNI introducido no es válido.");
        } else {
            this.DNI = DNI;
        }
        if (Edad < 18) {
            throw new IllegalArgumentException("No se admiten menores de 18 años");
        } else {
            this.Edad = Edad;
        }
    }

    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        if (!DNI.matches("\\d{8}[A-HJ-NP-TV-Z]")) {
            throw new IllegalArgumentException("El DNI introducido no es válido.");
        } else {
            this.DNI = DNI;
        }
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        if (Edad < 18) {
            throw new IllegalArgumentException("No se admiten menores de 18 años");
        } else {
            this.Edad = Edad;
        }
    }

    //MÉTODOS
    //Para comparar a dos personas. Dos personas con el mismo DNI serán consideradas iguales.
    @Override
    public boolean equals(Object p) {
        Persona p1 = (Persona) p;
        return (p1.getDNI().equals(this.getDNI()));
    }

    //Método para saber si una persona es mayor que otra
    @Override
    public int compareTo(Persona humano) {
        int resultado = 0;
        if (this.getEdad() < humano.getEdad()) {
            resultado = -1;
        } else if (this.getEdad() > humano.getEdad()) {
            resultado = 1;
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n"
                + "Apellidos: " + apellidos + "\n"
                + "DNI: " + DNI + "\n"
                + "Edad: " + Edad + "\n";
    }

    
}
