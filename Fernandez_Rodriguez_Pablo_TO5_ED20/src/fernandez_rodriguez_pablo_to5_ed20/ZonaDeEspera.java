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
public class ZonaDeEspera extends Darsena {
    
    //ATRIBUTOS
    private int capacidad;
    
    //CONSTRUCTOR

    public ZonaDeEspera(int capacidad, boolean semaforo, String codigo_darsena, int numero_anden) {
        super(semaforo, codigo_darsena, numero_anden);
        this.capacidad = capacidad;
    }
    
    //GETTERS y SETTERS

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    //MÉTODOS
    public boolean hayCapacidad(int capacidad){
        return false;
    }
    
}
