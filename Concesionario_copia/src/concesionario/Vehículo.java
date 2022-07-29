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
public abstract class Vehículo implements Serializable {
    
    //ATRIBUTOS PRIVADOS
    private int peso; //entero positivo
    private int ancho; //entero positivo
    private int largo; //entero positivo
    private int altura; //entero positivo
    private String color;
    private double precio; // número positivo
    private String matricula; //Se debe validar
    private int km; //entero positivo
    private int ruedas; //mínimo 2 y máximo 4
    private int cilindrada; //entero positivo
    private int potencia; //entero positivo
    private String combustible;
    static final long serialVersionUID = 1L;
    

    //CONSTRUCTOR//CONSTRUCTOR
    public Vehículo(int peso, int ancho, int largo, int altura, String color, double precio, String matricula, int km, int ruedas, int cilindrada, int potencia, String combustible) {
        this.peso = peso;
        this.ancho = ancho;
        this.largo = largo;
        this.altura = altura;
        this.color = color;
        this.precio = precio;
        this.matricula = matricula;
        this.km = km;
        this.ruedas = ruedas;
        this.cilindrada = cilindrada;
        this.potencia = potencia;
        this.combustible = combustible;
    }

    //GETTERS Y SETTERS
    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        if (peso < 0) {
            throw new IllegalArgumentException("El peso del vehículo no puede ser negativo");
        } else {
            this.peso = peso;
        }
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        if (ancho < 0) {
            throw new IllegalArgumentException("El ancho del vehículo no puede ser negativo");
        } else {
            this.ancho = ancho;
        }
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        if (largo < 0) {
            throw new IllegalArgumentException("El largo del vehículo no puede ser negativo");
        } else {
            this.largo = largo;
        }
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        if (altura < 0) {
            throw new IllegalArgumentException("La altura del vehículo no puede ser negativa");
        } else {
            this.altura = altura;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio del vehículo no puede ser negativo");
        } else {
            this.precio = precio;
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (!matricula.matches("([0-9]{4})([A-Z]{3})")) {
            throw new IllegalArgumentException("La matrícula debe tener el formato 0000XXX");
        } else {
            this.matricula = matricula;
        }
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        if (km < 0) {
            throw new IllegalArgumentException("Los kilómetros del vehículo no pueden ser negativo");
        } else {
            this.km = km;
        }
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        if (ruedas < 2 || ruedas > 4) {
            throw new IllegalArgumentException("Un vehículo debe tener entre dos ruedas y cuatro ruedas.");
        } else {
            this.ruedas = ruedas;
        }
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        if (cilindrada < 0) {
            throw new IllegalArgumentException("La cilindrada del vehículo no puede ser negativa");
        } else {
            this.cilindrada = cilindrada;
        }
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        if (potencia < 0) {
            throw new IllegalArgumentException("La potencial del vehículo no puede ser negativa");
        } else {
            this.potencia = potencia;
        }
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    //MÉTODOS
    @Override
    public String toString() {
        return "Peso: " + peso + "\n"
                + "Ancho: " + ancho + "\n"
                + "Largo: " + largo + "\n"
                + "Altura: " + altura + "\n"
                + "Color: " + color + "\n"
                + "Precio: " + precio + "\n"
                + "Matrícula: " + matricula + "\n"
                + "Kilometraje: " + km + "\n"
                + "Cilindrada: " + cilindrada + "\n"
                + "Potencia: " + potencia + "\n"
                + "Combustible: " + combustible + "\n";
    }
    
    //Para comparar a dos vehículo. Dos vehículos con la misma matrícula serán considerados iguales.
    @Override
    public boolean equals(Object v) {
        Vehículo v2 = (Vehículo) v;
        return (v2.getMatricula().equals(this.getMatricula()));
    }

}
