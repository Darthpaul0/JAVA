/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymtonificate;

import java.util.Arrays;

/**
 *
 * @author Pablo
 */
public class Monitor extends Persona {

    //ATRIBUTOS PRIVADOS
    private String[] especialidad = new String[3]; //la especialidad debe estar ya incluida en la lista de especialidades
    private float sueldo; //mínimo de 950€
    private boolean activo;

    //CONSTRUCTOR
    public Monitor(String nombre, String DNI, String direccion, String localidad, String provincia,
            String codigoPostal, String telefono, int diaAlta, int mesAlta,
            int añoAlta, int diaNac, int mesNac, int añoNac, char sexo,
            String[] especialidad, float sueldo, boolean activo) {
        super(nombre, DNI, direccion, localidad, provincia, codigoPostal, telefono,
                diaAlta, mesAlta, añoAlta, diaNac, mesNac, añoNac, sexo);
        this.especialidad = especialidad;
        if (sueldo < 950) {
            throw new IllegalArgumentException("Un trabajador no puede cobrar menos del SMI.");
        } else {
            this.sueldo = sueldo;
        }
        this.activo = activo;
    }
    
    //GETTERS Y SETTERS
    public String[] getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String[] especialidad) {
        this.especialidad = especialidad;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        if (sueldo < 950) {
            throw new IllegalArgumentException("Un trbajador no puede cobrar menos del SMI.");
        } else {
            this.sueldo = sueldo;
        }
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public String toString() {
        return this.getNombre() + " con DNI " + this.getDNI() + 
                " es monitor de GymTonificate, siendo especialista en "
                + Arrays.toString(this.getEspecialidad());
    }
}
