/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymtonificate;

import java.util.Calendar;

/**
 *
 * @author Pablo
 */
public abstract class Persona implements Comparable<Persona> {

    //ATRIBUTOS PRIVADOS
    private String nombre;
    private String DNI;//comprobar mediante regex
    private String direccion; //calle, nº, piso...
    private String localidad;
    private String provincia;
    private String codigoPostal; //5 dígitos
    private String telefono; //9 dígitos
    private Calendar fechaAlta = Calendar.getInstance();
    private Calendar fechaNacimiento = Calendar.getInstance(); //Una persona no puede ser mayor de 99 años
    private char sexo;// H para hombre y M para mujer

    //CONSTRUCTOR
    public Persona(
            String nombre,
            String DNI,
            String direccion,
            String localidad,
            String provincia,
            String codigoPostal,
            String telefono,
            int diaAlta, int mesAlta, int añoAlta,
            int diaNac, int mesNac, int añoNac,
            char sexo) {
        this.nombre = nombre;
        if (!DNI.matches("\\d{8}[A-HJ-NP-TV-Z]")) {
            throw new IllegalArgumentException("El DNI introducido no es válido.");
        } else {
            this.DNI = DNI;
        }
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        if (!codigoPostal.matches("\\d{5}")) {
            throw new IllegalArgumentException("El código postal no es válido.");
        } else {
            this.codigoPostal = codigoPostal;
        }
        if (!telefono.matches("\\d{9}")) {
            throw new IllegalArgumentException("El teléfono no es válido.");
        } else {
            this.telefono = telefono;
        }
        fechaAlta.set(añoAlta, mesAlta, diaAlta);
        fechaNacimiento.set(añoNac, mesNac, diaNac);
    }

    //GETTERS Y SETTERS 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        if (!DNI.matches("\\d{8}[A-HJ-NP-TV-Z]")) {
            throw new IllegalArgumentException("El DNI introducido no es válido.");
        } else {
            this.DNI = DNI;
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        if (codigoPostal.matches("\\d{5}")) {
            throw new IllegalArgumentException("El código postal no es válido.");
        } else {
            this.codigoPostal = codigoPostal;
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono.matches("\\d{9}")) {
            throw new IllegalArgumentException("El teléfono no es válido.");
        } else {
            this.telefono = telefono;
        }
    }

    public Calendar getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Calendar fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    //Para determinar la edad de la persona restamos el año actual con el de nacimiento
    public long getEdad() {
        long edad;
        Calendar hoy = Calendar.getInstance();
        long añoHoy = hoy.getTimeInMillis();
        long añoNac = fechaNacimiento.getTimeInMillis();
        edad = ((añoHoy - añoNac) / 24 / 60 / 60 / 1000 / 365);
        return edad;
    }

    @Override
    public int compareTo(Persona humano) {
        int resultado = 0;
        if (this.getEdad() < humano.getEdad()) {
            resultado = -1;
        } else if (this.getEdad() > humano.getEdad()) {
            resultado = 1;
        }
        return resultado;
    }

    //Para comparar a dos personas. Dos personas con el mismo DNI serán consideradas iguales.
    public boolean equals() {
        boolean mismo = false;
        //Pedimos el DNI de la persona a comparar
        String posible = GymTonificate.leerDNI();
        if (posible.equals(this.DNI)) {
            mismo = true;
        }
        return mismo;
    }

    @Override
    public String toString() {
        return "Nombre completo " + nombre + "\n"
                + "DNI: " + DNI + "\n"
                + "Dirección: " + direccion + "\n"
                + "Localidad: " + localidad + "\n"
                + "Provincia: " + provincia + "\n"
                + "Código Postal: " + codigoPostal + "\n"
                + "Teléfono: " + telefono;
    }
}
