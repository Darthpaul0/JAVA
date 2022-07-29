/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorlistacanciones;

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

    public void escribirObjeto(Object o) {
        try {
            escritorObjetos = new ObjectOutputStream(new FileOutputStream("miObjeto.doc"));
            escritorObjetos.writeObject(o);
        } catch (FileNotFoundException e) {

        } catch (IOException ex) {
        }
    }

    public Object leerObjeto(String nombreArchivo) {
        Object devuelve = null;
        try {
            lectorObjetos = new ObjectInputStream(new FileInputStream(nombreArchivo));
            devuelve = lectorObjetos.readObject();
        } catch (FileNotFoundException e) {
        } catch (IOException | ClassNotFoundException ex) {
        }
        return devuelve;
    }
}
