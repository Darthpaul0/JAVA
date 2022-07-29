/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mibiblioteca;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Pablo
 */
public class Libro {

    //ATRIBUTOS PRIVADOS
    private String titulo; //El título del libro.
    private String ISBN; //El código ISBN del libro. Puede ser un ISBN-10 o ISBN-13.
    private String[] autores; //Un libro puede tener uno o varios autores.

    //CONSTRUCTORES
    /*El constructor de la clase inicializa los atributos del objeto con los datos pasados por parámetro.
    Es importante comprobar que el objeto se genera adecuadamente por lo que si el ISBN pasado por 
    parámetro no es válido se lanzará la excepción IllegalArgumentException.*/
    public Libro(String titulo, String ISBN, String[] autores) {
        this.titulo = titulo;
        if (!compruebaISBN10(ISBN) && !compruebaISBN13(ISBN)) {
            throw new IllegalArgumentException("El ISBN del libro no es correcto. No se puede crear el objeto.");
        } else {
            this.ISBN = ISBN;
        }
        this.autores = autores;
    }

    /*Constructor de copia, crea un nuevo libro con los mismos atributos que
    el objeto pasado por parámetro.*/
    public Libro(Libro l) {
        this.titulo = l.titulo;
        this.ISBN = l.ISBN;
        this.autores = l.autores;
    }

    // GETTERS Y SETTERS
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String[] getAutores() {
        return autores;
    }

    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    //MÉTODOS PÚBLICOS
    /*Devolverá una cadena de caracteres con la representación del objeto en cadena de caracteres.*/
    @Override
    public String toString() {
        return "El libro  " + this.titulo + " fue escrito por " + Arrays.toString(this.getAutores()) + " y su ISBN es " + this.getISBN();

    }

    /* Este método se utilizará en el constructor y en setIsbn() para comprobar la validez del ISBN. 
    Devolverá true si el parámetro es un ISBN-10 válido y false en caso contrario. 
    Antes de comprobar si el ISBN es correcto se utilizarán expresiones regulares para validar 
    que el formato de la cadena es válido.*/
    public static boolean compruebaISBN10(String ISBN) {
        Pattern p = Pattern.compile("84[0-9]{8}");
        Matcher m = p.matcher(ISBN);
        if (!m.matches()) {
            return false;
        }
        int suma = 0;
        int digito;
        for (int i = 0; i < ISBN.length(); i++) {
            digito = Integer.valueOf(ISBN.charAt(i) + "") * (i + 1);
            suma += digito;
        }

        return (suma % 11 == 0);

    }

    /*Este método se utilizará en el constructor y en setIsbn() para comprobar la validez del ISBN. 
    Devolverá true si el parámetro es un ISBN-13 válido y false en caso contrario. 
    Antes de comprobar si el ISBN es correcto se utilizarán expresiones regulares para validar 
    que el formato de la cadena es válido.*/
    public static boolean compruebaISBN13(String ISBN) {
        Pattern p = Pattern.compile("97[8|9][0-9]{10}");
        Matcher m = p.matcher(ISBN);
        if (!m.matches()) {
            return false;
        }
        int suma = 0;
        int digito;
        for (int i = 0; i < ISBN.length() - 1; i++) {
            digito = Integer.valueOf(ISBN.charAt(i) + "");
            if (i % 2 != 0) {
                digito = digito * 3;
            }
            suma += digito;
        }

        int control = 10 - (suma % 10);
        digito = Integer.valueOf(ISBN.charAt(ISBN.length() - 1) + "");

        return (digito == control);

    }
}
