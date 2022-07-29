/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bombillas;

/**
 *
 * @author Pablo
 */
public class Bombilla {

    //ATRIBUTOS
    private boolean estado;
    private int encendidas;

    //CONSTRUCTORES
    public Bombilla(boolean estado) {
        this.estado = estado;
    }

    public Bombilla() {
        estado = false;
    }

    //Getters y setters
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getEncendidas() {
        return encendidas;
    }

    public void setEncendidas(int encendidas) {
        this.encendidas = encendidas;
    }

    //Método toString
    public String toString() {
        if (encendidas < 1 && estado == false) {
            System.out.println("Bombilla apagada. Se ha encendido 0 veces.");
        }
        if (encendidas < 1 && estado == true) {
            System.out.println("Bombilla encendida. Se ha encendido 0 veces.");
        }
        if (encendidas == 1 && estado == true) {
            System.out.println("Bombilla encendida. Se ha encendido 0 veces.");
        }
        if (encendidas == 1 && estado == false) {
            System.out.println("Bombilla apagada. Se ha encendido 0 veces.");
        }
        if (encendidas > 1 && estado == true) {
            System.out.println("Bombilla encendida. Se ha encendido " + encendidas + "veces");
        }
        if (encendidas > 1 && estado == false) {
            System.out.println("Bombilla apagada. Se ha encendido " + encendidas + "veces");
        }
        return null;
    }

    //Métodos públicos
    //Para encender la bombilla
    public boolean encenderBombilla(boolean estado) {
        estado = true;
        return estado;
    }

    //Para apagar la bombilla
    public static boolean apagarBombilla(boolean estado) {
        estado = false;
        return estado;
    }
    
    //Conmutador, cambiar encendido a apagado y viceverse.
    public static boolean conmutadorBombilla (boolean estado){
        estado = !estado;
        return estado;
    }

}
