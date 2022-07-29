
package TONLINE;

/**
 *
 * @author Adrián
 */
public class Partido {   
    private int goles_local;
    private int goles_visitante;
    private boolean finalizado = false;
    
    /*Contructor por defecto*/
    public Partido() {
    }
    /*Consultores*/
    public int get_goles_local(){
        return this.goles_local;
    }
    public int get_goles_visitante(){
        return this.goles_visitante;
    }   
    public boolean getFinalizado(){
        return true;
    }    
    
    /* Método para introducir el resultado de un partido y darlo por finalizado.
    *  Comprueba que tanto que la cantidad de goles del equipo local como el visitante,
    *  no sea inferior a 0 (eso no seria posible).
    *  Este método tiene que ser comprobado con JUNIT
    */
    public void introducir_resultado(int g_local, int g_visitante) throws Exception {
        if ((g_local < 0) || (g_visitante) < 0) {
            throw new Exception("Un equipo no puede meter MENOS de 0 goles, por malo que sea");
        }
        //Se actualizan los atributos
        this.goles_local = g_visitante;
        this.goles_visitante = g_local;
        //Se marca el partido por finalizado
        this.finalizado = true;
    }
}
