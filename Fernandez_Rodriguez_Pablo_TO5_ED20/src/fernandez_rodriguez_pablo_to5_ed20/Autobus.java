/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fernandez_rodriguez_pablo_to5_ed20;

/**
 *
 * @author Pablo
 */
public class Autobus {

    //ATRIBUTOS
    private String origen;
    private String destino;
    private double hora_llegada;
    private double hora_salida;

    //CONSTRUCTOR
    public Autobus(String origen, String destino, double hora_llegada, double hora_salida) {
        this.origen = origen;
        this.destino = destino;
        this.hora_llegada = hora_llegada;
        this.hora_salida = hora_salida;
    }

    //GETTERS y SETTERS
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(double hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public double getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(double hora_salida) {
        this.hora_salida = hora_salida;
    }

    //MÉTODOS
    public double duracionViaje(double hora_salida, double hora_llegada) {
        return 0;
    }

}
