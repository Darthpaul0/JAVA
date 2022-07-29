/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorlistacanciones;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class GestionConversor {

    public static void main(String[] args) {

        //Pedimos el nombre del fichero
        ArrayList<Cancion> lista = new ArrayList<>();
        String linea;
        String fichero = leerString("Introduzca el nombre del fichero.");
        //Creamos las canciones
        Cancion cancion1 = new Cancion("Stairway to Heaven", "Led Zeppelin", 480);
        Cancion cancion2 = new Cancion("Money For Nothing", "Dire Straits", 504);
        Cancion cancion3 = new Cancion("Shine On You Crazy Diamond", "Pink Floyd", 1380);
        //Añadimos las canciones a la lista
        lista.add(cancion1);
        lista.add(cancion2);
        lista.add(cancion3);
        Serializar serializo = new Serializar();
        //Serializamos la lista
        serializo.escribirObjeto(lista);
        
        //Ahora pasamos a leer la lista
        ArrayList<Cancion> nuevaLista;
        nuevaLista = (ArrayList<Cancion>) serializo.leerObjeto(fichero);
        
        //Mostramos el autor, título y duración de las canciones de la lista
        for(Cancion cancion: nuevaLista){
            System.out.println(cancion.getTitulo());
            System.out.println(cancion.getAutor());
            System.out.println(cancion.getDuracion());
        }
    }

    public static String leerString(String mensaje) {
        System.out.println(mensaje);
        Scanner sc = new Scanner(System.in);
        String texto;
        texto = sc.nextLine();
        return texto;
    }
}
