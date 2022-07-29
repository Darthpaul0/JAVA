/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymtonificate;

/**
 *
 * @author Pablo
 */
public class Socio extends Persona {

    //ATRIBUTOS PRIVADOS
    private int sesionesSemaneles; //mínimo 2 y máximo 6
    private double cuota; //sesionesSemanales*8
    private boolean pagado;//si paga religiosamente o no
    private String lesiones; // por si tiene alguna lesión

    //CONSTRUCTOR
    public Socio(String nombre, String DNI, String direccion, String localidad, String provincia,
            String codigoPostal, String telefono, int diaAlta, int mesAlta,
            int añoAlta, int diaNac, int mesNac, int añoNac, char sexo,
            int sesionesSemanales, boolean pagado, String lesiones) {
        super(nombre, DNI, direccion, localidad, provincia, codigoPostal, telefono,
                diaAlta, mesAlta, añoAlta, diaNac, mesNac, añoNac, sexo);
        this.sesionesSemaneles = sesionesSemanales;
        this.pagado = pagado;
        this.lesiones = lesiones;
    }

    //GETTERS Y SETTERS
    public int getSesionesSemaneles() {
        return sesionesSemaneles;
    }

    public void setSesionesSemaneles(int sesionesSemaneles) {
        this.sesionesSemaneles = sesionesSemaneles;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public String getLesiones() {
        return lesiones;
    }

    public void setLesiones(String lesiones) {
        this.lesiones = lesiones;
    }

    @Override
    public String toString() {
        return this.getNombre() + " con DNI " + this.getDNI() + " es socio de GymTonificate.";
    }

}
