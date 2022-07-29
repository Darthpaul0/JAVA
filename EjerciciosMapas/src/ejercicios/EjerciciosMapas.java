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
public class EjerciciosMapas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int cantNumeros = 20;
        //Lista aleatoria de x enteros
        int lista[] = new int[cantNumeros];
        for (int i = 0; i < cantNumeros; i++) {
            lista[i] = (int) (Math.random() * 10);
        }

        //Declaración de HashMap
        HashMap<Integer, Integer> mapa = new HashMap<>();

        //Recorremos la lista y vamos añadiendo datos al mapa
        for (int i = 0; i < cantNumeros; i++) {
            if (!mapa.containsKey(lista[i])) {
                mapa.put(lista[i], 1);
            } else {
                mapa.put(lista[i], mapa.get(lista[i])+1);
            }
            
        }
        
        //mostramos la información del mapa
        for(int i: mapa.keySet()){
            System.out.println(i + " - " + mapa.get(i));
        }
        
    }

}
