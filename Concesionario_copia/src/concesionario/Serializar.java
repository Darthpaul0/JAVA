/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author Pablo
 */
public class Serializar {

    private ObjectInputStream lectorObjetos;
    private ObjectOutputStream escritorObjetos;

    public void escribirObjeto(Object o, String nombreArchivo) {
        try {
            escritorObjetos = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            escritorObjetos.writeObject(o);
            escritorObjetos.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Object leerObjeto(String nombreArchivo) {
        Object devuelve = null;
        try {
            lectorObjetos = new ObjectInputStream(new FileInputStream(nombreArchivo));
            devuelve = lectorObjetos.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return devuelve;
    }
}
