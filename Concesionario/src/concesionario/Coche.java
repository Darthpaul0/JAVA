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
public class Coche extends Vehículo implements Serializable{

    //ATRIBUTOS PRIVADOS
    private String marca;
    private String modelo;
    private int añoFabricacion;
    private int capacidadCarga;
    private int plazas;
    boolean vendido = false;
    
    //CONSTRUCTOR

    public Coche(String marca, String modelo, int añoFabricacion, int capacidadCarga, int plazas, boolean vendido, int peso, int ancho, int largo, int altura, String color, double precio, String matricula, int km, int ruedas, int cilindrada, int potencia, String combustible) {
        super(peso, ancho, largo, altura, color, precio, matricula, km, ruedas, cilindrada, potencia, combustible);
        this.marca = marca;
        this.modelo = modelo;
        this.añoFabricacion = añoFabricacion;
        this.capacidadCarga = capacidadCarga;
        this.plazas = plazas;
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

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }
    
    //MÉTODOS
    public String tipoCoche(int plazas){
        if(plazas > 5){
            return "Es un monovolumen";
        }
        if(plazas < 3){
            return "Es un coche deportivo";
        }
        if(plazas > 3 && plazas < 6){
            return "Es un coche familiar";
        }
        return null;
    }
    
    @Override
    public String toString(){
        return "Marca: " + marca + "\n"
                + "Modelo: " + modelo + "\n"
                + "Fabricado en: " + añoFabricacion + "\n"
                + "Carga: " + capacidadCarga + "\n"
                + "Número de plazas: " + plazas + "\n"
                + "Vendido: " + vendido + "\n"
                + super.toString();
    }
}
