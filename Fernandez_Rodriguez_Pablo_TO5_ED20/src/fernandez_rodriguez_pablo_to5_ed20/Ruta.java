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
public class Ruta {
    
    //ATRIBUTOS
    private String tipo;
    private String codigo_ruta;
    
    //CONSTRUCTOR
    public Ruta(String tipo, String codigo) {
        this.tipo = tipo;
        this.codigo_ruta = codigo;
    }
    
    //GETTERS y SETTERS
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo_ruta() {
        return codigo_ruta;
    }

    public void setCodigo_ruta(String codigo) {
        this.codigo_ruta = codigo;
    }
    

}
