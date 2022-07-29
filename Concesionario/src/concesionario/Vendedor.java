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
public class Vendedor extends Persona implements Serializable {

    //ATRIBUTOS PRIVADOS
    private double sueldo; //mayor que 0
    private int añosExperiencia; //mayor o igual que 0
    private String estudios; //formación
    private int diasVacaciones; //mínimo de 30 días
    final static int VACACIONES_MINIMAS = 30;
    final static int SALARIO_MINIMO = 950;

    //CONSTRUCTOR
    public Vendedor(double sueldo, int añosExperiencia, String estudios, int diasVacaciones, String nombre, String apellidos, String DNI, int Edad) {
        super(nombre, apellidos, DNI, Edad);
        if (sueldo < SALARIO_MINIMO) {
            throw new IllegalArgumentException("No se puede cobrar menos de " + SALARIO_MINIMO + "€");
        } else {
            this.sueldo = sueldo;
        }
        if (añosExperiencia < 0) {
            System.out.println("No se puede tener un número negativo de años de experiencia");
        } else {
            this.añosExperiencia = añosExperiencia;
        }
        this.estudios = estudios;
        if (diasVacaciones < VACACIONES_MINIMAS) {
            throw new IllegalArgumentException("Ningún empleado del concesionario puede tener menos de 30 días de vacaciones");
        } else {
            this.diasVacaciones = diasVacaciones;
        }
    }

    //GETTERS Y SETTERS 
    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public int getDiasVacaciones() {
        return diasVacaciones;
    }

    public void setDiasVacaciones(int diasVacaciones) {
        this.diasVacaciones = diasVacaciones;
    }

    //MÉTODOS
    //Método para subir el sueldo
    public void subirSueldo(double porcentaje) {
        this.sueldo = this.sueldo * (1 + porcentaje / 100);
    }

    //Método para bajar el sueldo
    public void bajarSueldo(double porcentaje) {
        this.sueldo = this.sueldo * (1 - porcentaje / 100);
    }

    //Método para cambiar los días de vacaciones del vendedor.
    public int modificarVacaciones(int vacaciones) {
        this.diasVacaciones = diasVacaciones + vacaciones;
        return diasVacaciones;
    }

    //Método para añadir un plus al sueldo de los vendedores. No puede ser negativo. 
    public double fijarIncentivo() {
        this.sueldo = sueldo + 500;
        return sueldo;
    }

    @Override
    public String toString() {
        return super.toString()
                + "Sueldo: " + sueldo + "\n"
                + "Experiencia: " + añosExperiencia + " años de experiencia" + "\n"
                + "Estudios: " + estudios + "\n"
                + "Días de vacaciones: " + diasVacaciones + "\n";
    }
}
