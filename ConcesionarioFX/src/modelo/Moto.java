/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Pablo
 */
public class Moto extends Vehículo implements Serializable{

    //ATRIBUTOS PRIVADOS
    private String marca;
    private String modelo;
    private int añoFabricacion;
    public boolean vendido = false;

    //CONSTRUCTOR
    public Moto(String marca, String modelo, int añoFabricacion, boolean vendido, int peso, int ancho, int largo, int altura, String color, double precio, String matricula, int km, int ruedas, int cilindrada, int potencia, String combustible) {
        super(peso, ancho, largo, altura, color, precio, matricula, km, ruedas, cilindrada, potencia, combustible);
        this.marca = marca;
        this.modelo = modelo;
        this.añoFabricacion = añoFabricacion;
        this.vendido = vendido;
    }

    //GETTERS Y SETTERS 
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setAñoFabricacion(int añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    //MÉTODOS
    
    public String tipoMoto() {
        String mensaje = "scooter";
        if (this.getCilindrada() > 600) {
            mensaje = "deportiva";
        }
        if (this.getCilindrada() > 50 && this.getCilindrada() < 600) {
            mensaje = "de carretera";
        }
        return mensaje;
    }

    @Override
    public String toString(){
        return "Marca: " + marca + "\n"
                + "Modelo: " + modelo + "\n"
                + "Fabricado en: " + añoFabricacion + "\n"
                + "Vendida: " + vendido + "\n"
                + super.toString();
    }
}
