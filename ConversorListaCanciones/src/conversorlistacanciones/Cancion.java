/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorlistacanciones;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author deifont
 */
public class Cancion implements Serializable{
    private String titulo;
    private String autor;
    private int duracion;
    
    public Cancion(String titulo, String autor, int duracion){
        if(!validarCancion(duracion)){
            throw new IllegalArgumentException("La duración de la canción debe ser un valor positivo");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if(!validarCancion(duracion)){
            throw new IllegalArgumentException("La duración de la canción debe ser un valor positivo");
        }        
        this.duracion = duracion;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cancion other = (Cancion) obj;
        if (this.duracion != other.duracion) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        return true;
    }
    
    public boolean equals(Cancion cancion){
        return equals((Object)cancion);
    }

    @Override
    public String toString() {
        return "Cancion{" + "titulo=" + titulo + ", autor=" + autor + ", duracion=" + duracion + '}';
    }
    

    private boolean validarCancion(int duracion) {
        return (duracion>0);
    }
    
}
