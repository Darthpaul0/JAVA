package TONLINE;


public class Apuesta {
    private int dinero_total;
    private int dinero_apostado;
    private int apuesta_local;
    private int apuesta_visitante;

    /*Contructor por defecto*/
    public Apuesta() {
    }

    /*Contructor por parámetros*/
    public Apuesta(int dinero) {
        this.dinero_total = 1000;
        this.dinero_apostado = 0;
    }
    /*Método para obtener el valor del atributo dinero_disp*/
    public int get_dinero_total() {
        return this.dinero_total;
    }
    //Método para modificar el valor del atributo dinero_disp
    public void set_dinero_total(int dinero) {
        this.dinero_total = dinero;
    }

    /* Método para apostar.
     * Permite elegir la cantidad a apostar, no pudiendo ser inferior a 1 ni superior a tu saldo disponible
     * Este método tiene que ser comprobado con JUNIT
     */
    public void apostar(int dinero, int apuesta_local, int apuesta_visitante) throws Exception {
        //Comprobaciones:
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1€");
        }
        if (dinero > this.dinero_total) {
            throw new Exception("No se puede apostar más de lo que tienes");
        }      
        //Se guarda la nueva apuesta:
        this.apuesta_local = apuesta_local;
        this.apuesta_visitante = apuesta_visitante;
        
        //Se actualiza el dinero de la apuesta        
         this.dinero_apostado = dinero;
         this.dinero_total = this.dinero_total - dinero;     
    }    

    /* Método para cobrar la apuesta.
     * Comprueba que se acertó el resultado y, en ese caso:
     * al dinero total se le suma el dinero apostado multiplicado por 10     
     * Este método tiene que ser comprobado con JUNIT
     */
    void cobrar_apuesta(Partido p) throws Exception {
        //Datos a comprobar
        boolean partidoFinalizado = p.getFinalizado();        
        
        //Comprobaciones:
        if(partidoFinalizado == false){
            throw new Exception("No se puede cobrar una apuesta de un partido que aún no ha terminado");
        }
        if (comprobar_resultado(p) == false) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        } else {
            System.out.println("Apuesta acertada.");
        }
        //Se actuliza el dinero total;        
        this.dinero_total = this.dinero_total * 10;
        //El dinero apostado se reinicia
        this.dinero_apostado = 0;
    }
    
    /* Método que comprueba si se ha acertado el resultado del partido
     * En caso de que lo haya acertado devuelve true.
     */
    public boolean comprobar_resultado(Partido p) throws Exception {
        boolean acertado = false;
        //Realizo comprobación:
        if (this.apuesta_local == p.get_goles_local() && this.apuesta_visitante == p.get_goles_visitante()) {
            acertado = true;
        }
        return acertado;
    }    
}
