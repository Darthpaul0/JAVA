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
public class Darsena extends Anden{
    
    //ATRIBUTOS
    private boolean semaforo;
    private String codigo_darsena;
    
    //CONSTRUCTOR

    public Darsena(boolean semaforo, String codigo_darsena, int numero_anden) {
        super(numero_anden);
        this.semaforo = semaforo;
        this.codigo_darsena = codigo_darsena;
    }
    
    //GETTERS and SETTERS

    public boolean isSemaforo() {
        return semaforo;
    }

    public void setSemaforo(boolean semaforo) {
        this.semaforo = semaforo;
    }

    public String getCodigo_darsena() {
        return codigo_darsena;
    }

    public void setCodigo_darsena(String codigo_darsena) {
        this.codigo_darsena = codigo_darsena;
    }
    
    
}
