/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.util.HashMap;

/**
 *
 * @author Pablo
 */
public class Split {

    public static void main(String[] args) {
        HashMap<String, String> mapa = new HashMap<>();
        String emails = "blanca@gmail.com;pepe@gmail.com;Vanessa@hotmail.com; francis@correo.ugr.es; Fernando@gmail.com";
        String[] dividido = emails.split(";");
        for (int i = 0; i < dividido.length; i++) {
            mapa.put(dividido[i].split("@")[0],dividido[i]);
        }
        for(String i: mapa.keySet()){
            System.out.println(i + " - " + mapa.get(i));
        }
    }
}
