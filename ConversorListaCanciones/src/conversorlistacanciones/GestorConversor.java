/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorlistacanciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author deifont
 */
public class GestorConversor {

    private static ArrayList<Cancion> listaCanciones;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //leemmos el nombre del fichero y comprobamos si existe
        String nombreFichero;
        File fichero;
        do {
            nombreFichero = leerStringTeclado("Escriba el nombre del fichero que desea leer");
            fichero = new File(nombreFichero);

        } while (!fichero.exists() && !fichero.isFile());

        //leemos el fihero según su tipo
        switch (menuLecturaFichero()) {
            case 1:
                listaCanciones = leerFicheroAntiguo(fichero);
                break;
            case 2:
                if (!cargarFicheroSerializando(fichero.getAbsolutePath())) {
                    System.out.println("Hubo un error al leer el fichero y no se puede recuperar el programa");
                    return;
                }
                break;
            default:
                System.out.println("Opción incorrecta");
        }

        //mostrar las canciones leídas
        mostrarCanciones();

        //Preguntamos si se desea guardar la lista de canciones (serializando)
        String respuesta = leerStringTeclado("¿Desea guardar la lista de canciones? [Sí | No]");
        if (respuesta.charAt(0) == 's' || respuesta.charAt(0) == 'S') {
            String nuevoFichero = leerStringTeclado("Introduzca el nombre del fichero donde desea guardar la lista: ");
            if (guardarFicheroSerializando(nuevoFichero)) {
                System.out.println("Los datos se han guardado correctamente");
            } else {
                System.out.println("Ha ocurrido un error y no se han podido guardar los datos");
            }

        }

        System.out.println("El programa ha terminado. Hasta pronto");

    }

    private static ArrayList<Cancion> leerFicheroAntiguo(File fichero) {
        ArrayList<Cancion> lista = new ArrayList<Cancion>();
        int numCanciones, duracion;
        String titulo, autor;

        try {
            BufferedReader bfr = new BufferedReader(new FileReader(fichero));

            //Leemos cuántas canciones hay en el fichero
            numCanciones = Integer.valueOf(bfr.readLine());

            //Leemos los datos de cada canción, creando el objeto y guardándolo en la lista
            for (int i = 0; i < numCanciones; i++) {
                titulo = bfr.readLine();
                autor = bfr.readLine();
                duracion = Integer.valueOf(bfr.readLine());

                lista.add(new Cancion(titulo, autor, duracion));
            }

            //cerramos el fichero y devolvemos la lista de canciones
            bfr.close();
            return lista;

        } catch (FileNotFoundException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    private static boolean cargarFicheroSerializando(String nombre) {

        try {
            ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(nombre));
            listaCanciones = (ArrayList<Cancion>) lectura.readObject();
            lectura.close();

            return true;

        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        } catch (ClassNotFoundException ex) {
            return false;
        }
    }

    private static boolean guardarFicheroSerializando(String nombre) {

        try {
            ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(nombre));
            escritura.writeObject(listaCanciones);
            escritura.close();

            return true;

        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }

    }

    private static void mostrarCanciones() {
        System.out.println("Lista de canciones disponible:");
        for (Cancion c : listaCanciones) {
            System.out.println(c);
        }

    }

    private static int menuLecturaFichero() {
        System.out.println("Tipo de fichero a leer");
        System.out.println("1. Fichero en modo texto (formato antiguo)");
        System.out.println("2. Fichero serializado (formato moderno)");
        return leerNumero("Introduzca la opción deseada [1,2]", 1, 2);
    }

    private static String leerStringTeclado(String mensaje) {
        Scanner sc = new Scanner(System.in);

        System.out.println(mensaje);
        return sc.nextLine();

    }

    private static int leerNumero(String mensaje, int min, int max) {

        Scanner sc = new Scanner(System.in);
        int numero;
//Leemos n
        do {
            System.out.println(mensaje);
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("Debe introducir un número");
            }
            numero = sc.nextInt();
        } while (numero < min || numero > max);

        return numero;
    }
}
