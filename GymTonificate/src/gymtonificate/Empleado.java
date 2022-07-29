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
public class Empleado extends Persona {

    //ATRIBUTOS PRIVADOS
    private String tipoTrabajo;
    private float sueldo; //mínimo de 950
    private String extension;

    //CONSTRUCTOR
    public Empleado(String tipoTrabajo, float sueldo, String extension, String nombre, String DNI,
            String direccion, String localidad, String provincia, String codigoPostal,
            String telefono, int diaAlta, int mesAlta, int añoAlta, int diaNac, int mesNac, int añoNac, char sexo) {
        super(nombre, DNI, direccion, localidad, provincia, codigoPostal, telefono,
                diaAlta, mesAlta, añoAlta, diaNac, mesNac, añoNac, sexo);
        this.tipoTrabajo = tipoTrabajo;
        if (sueldo < 950) {
            throw new IllegalArgumentException("Un trabajador no puede cobrar menos del SMI.");
        } else {
            this.sueldo = sueldo;
        }
        this.extension = extension;
    }

    //GETTERS Y SETTERS
    public String getTipoTrabajo() {
        return tipoTrabajo;
    }

    public void setTipoTrabajo(String tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        if (sueldo < 950) {
            throw new IllegalArgumentException("Un trabajador no puede cobrar menos del SMI.");
        } else {
            this.sueldo = sueldo;
        }
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return this.getNombre() + " con DNI " + this.getDNI()
                + " es empleado de GymTonificate, trabaja como personal de "
                + this.getTipoTrabajo() + ". Número interno: " + this.getTelefono() + this.getExtension();
    }
}
