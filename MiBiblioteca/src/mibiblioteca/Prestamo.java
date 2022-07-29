/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mibiblioteca;

import java.util.Arrays;
import java.util.Calendar;

/**
 *
 * @author Pablo
 */
public class Prestamo {

    //ATRIBUTOS PRIVADOS
    private String dni; //El DNI del usuario al que se le presta el libro.
    private String[] isbn; //Lista de libros prestados al usuario.
    private Calendar fechaPrestamo = Calendar.getInstance(); //Fecha en que se realiza el préstamo.
    private int diasPrestamo; //Número de días que se podrán tener prestados los libros.

    //ATRIBUTOS PÚBLICOS 
    /*El número de días por defecto para el que se realiza el préstamo será de 15 días.*/
    public static final int DIAS_PRESTAMO_DEFAULT = 15;

    //CONSTRUCTORES
    /*Constructor que establece los días del préstamo a lo indicado por parámetro así como 
    el resto de atributos.*/
    public Prestamo(String dni, String[] isbn, int diasPrestamo, int dia, int mes, int año) {
        this.dni = dni;
        this.isbn = isbn;
        this.diasPrestamo = diasPrestamo;
        fechaPrestamo.set(año, mes, dia);
    }

    /*Constructor que establece los días del préstamo a lo indicado por parámetro. 
    La lista de isbn del préstamo se obtiene a través de un array de objetos Libro.*/
    public Prestamo(String dni, Libro[] libros, int diasPrestamo, int dia, int mes, int año) {
        this.dni = dni;
        this.isbn = new String[libros.length];
        for (int i = 0; i < libros.length; i++) {
            this.isbn[i] = libros[i].getISBN();
        }
        this.diasPrestamo = diasPrestamo;
        fechaPrestamo.set(año, mes, dia);
    }

    /*Constructor que establece los días del préstamo al valor por defecto, deberá hacer uso de this().*/
    public Prestamo(String dni, String[] isbn, int dia, int mes, int año) {
        this(dni, isbn, DIAS_PRESTAMO_DEFAULT, dia, mes, año);
    }

    /*Constructor que establece los días del préstamo al valor por defecto, deberá hacer uso de this().*/
    public Prestamo(String dni, Libro[] libros, int dia, int mes, int año) {
        this(dni, libros, DIAS_PRESTAMO_DEFAULT, dia, mes, año);
    }

    //GETTERS Y SETTERS 
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String[] getIsbn() {
        return isbn;
    }

    public void setIsbn(String[] isbn) {
        this.isbn = isbn;
    }

    public Calendar getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Calendar fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public int getDiasPrestamo() {
        return diasPrestamo;
    }

    public void setDiasPrestamo(int diasPrestamo) {
        this.diasPrestamo = diasPrestamo;
    }

    //MÉTODOS PÚBLICOS
    /*Devuelve verdadero si han pasado los días establecidos para el préstamo.*/
    public boolean prestamoCaducado() {
        boolean caducado = false;
        //Primero tenemos que saber qué día es hoy
        if (diasCaducaPrestamo() < 0) {
            caducado = true;
        }
        return caducado;
    }

    /*Devuelve el número de días que quedan para que caduque el préstamo.
    Devolverá un número negativo indicando cuántos días han transcurrido desde que caducó el préstamo.*/
    public long diasCaducaPrestamo() {
        long tiempo;
        Calendar fechahoy = Calendar.getInstance();
        long mili1 = fechahoy.getTimeInMillis();
        long mili2 = fechaPrestamo.getTimeInMillis();
        tiempo = ((mili1 - mili2) / 24 / 60 / 60 / 1000) - diasPrestamo;
        return tiempo;
    }

    /*Representación del objeto en cadena de caracteres.*/
    @Override
    public String toString() {
        return "El miembro con DNI " + this.dni + " tiene prestados los libros " + Arrays.toString(this.isbn) +
                " desde el día " + this.fechaPrestamo.getTime() + " y tiene " + this.diasPrestamo + " días para devolverlo.";

    }
}
