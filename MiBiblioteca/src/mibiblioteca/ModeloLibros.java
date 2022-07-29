/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mibiblioteca;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Pablo
 */
public class ModeloLibros {

    //ATRIBUTOS PRIVADOS
    private Libro[] lista; //Array con los libros que contiene el modelo.
    private int elementos; //Número de elementos que contiene el array.

    //ATRIBUTOS PÚBLICOS
    /*Número de elementos máximos que pueden almacenarse. Será de 100.*/
    public static final int MAX_ELEMENTOS = 100;

    //CONSTRUCTORES
    /*Constructor que inicializa el array de elementos con la capacidad por defecto. 
    Hará uso de this().*/
    public ModeloLibros() {
        this(MAX_ELEMENTOS);
    }

    /*Constructor que inicializa el array de elementos con la capacidad indicada por parámetro.*/
    public ModeloLibros(int elementos) {
        lista = new Libro[elementos];
    }

    //MÉTODOS PÚBLICOS
    /*Devuelve el número de libros que hay almacenados.*/
    public int getElementos() {
        return elementos;
    }

    /*Añade un libro a la lista y devuelve true si se añadió correctamente.
    Devuelve false si no pudo añadirse por no haber más espacio.*/
    public boolean añadir(Libro l) {
        //Primero se comprueba que haya espacio de almacenamiento
        if (elementos == lista.length) {
            return false;
        }
        //si hay espacio, guardamos el libro en una posición libre
        int libre = 0;
        while (lista[libre] != null) {
            libre++;
        }
        this.lista[libre] = l;
        elementos++;
        return true;

    }

    /*Se elimina el libro de la lista. Tras la eliminación debe compactar la lista de elementos.*/
    public boolean eliminar(String isbn) {
        //Buscamos el libro
        Libro l = buscar(isbn);

        //Si encuentra el libro
        if (l != null) {
            int posicion = 0;
            //Usamos condicional OR simple para que evalúe la condición necesaria
            while ((lista[posicion]== null) || (!lista[posicion].equals(l))) {
                posicion++;
            }
            //Eliminamos el libro de la lista
            lista[posicion] = null;
            elementos--;
            return true;
        }

        return false;
    }

    /*Devuelve el objeto libro que coincide con el isbn indicado por parámetro. 
    Si la búsqueda no tiene éxito devuelve null.*/
    public Libro buscar(String isbn) {
        for (Libro l : lista) {
            if (l != null) {
                if (l.getISBN().equals(isbn)) {
                    return l;
                }
            }
        }
        return null;
    }

    /*Devuelve un array de libros cuyo título contiene la cadena de búsqueda indicada por parámetro. 
    Si la búsqueda no tiene éxito devuelve null.*/
    public Libro[] buscarTitulo(String titulo) {
        ArrayList<Libro> iguales = new ArrayList<>();
        for (int i = 0; i < getElementos(); i++) {
            if ((lista[i] != null) && (lista[i].getTitulo().contains(titulo))) {
                iguales.add(lista[i]);
            }
        }
        if (iguales.isEmpty()) {
            return null;
        } else {
            Libro[] mismo = new Libro[iguales.size()];
            mismo = iguales.toArray(mismo);
            return mismo;
        }
    }

    /*Devuelve un array de libros cuyo autor coincide con el parámetro buscado. 
    Si la búsqueda no tiene éxito devuelve null.*/
    //Debería devolver un array de libros existentes en nuestra biblioteca donde se incluyan todos los libros escritos por todos los autores que hayan escrito el libro pasado por parámetro

    public Libro[] buscarAutor(String titulo) {
        ArrayList<Libro> librosAutores = new ArrayList<>();
        //Buscamos el titulo de referencia
        Libro[] librosReferencia = buscarTitulo(titulo);
        //contiene la lista de autores de referencia
        ArrayList<String> listaAutores = new ArrayList<>();
        //rellenamos la lista de autores
        for(Libro ejemplar: librosReferencia){
            for(String autor: ejemplar.getAutores()){
                listaAutores.add(autor);
            }
        }
        //Para cada autor de la lista de autores, cargamos sus libros
        //Empezamos por recorrer los autores que tenemos
        for (Libro libro : lista) {
            if (libro != null) {
                //Después, en cada libro, buscamos los autores
                for (String autor : libro.getAutores()) {
                    //Si el nombre del autor coincide con la búsqueda, lo añadimos al array
                    if (listaAutores.contains(autor)) {
                        librosAutores.add(libro);
                    }
                }
            }
        }
        //convertimos el ArrayList a Array
        if (librosAutores.isEmpty()) {
            return null;
        } else {
            Libro[] mismo = new Libro[librosAutores.size()];
            mismo = librosAutores.toArray(mismo);
            return mismo;
        }

    }
}
