/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Pablo
 */
public class MetodosGenericos {
    public static void main(String[] args) {
        ArrayList<Integer> enteros = new ArrayList<>();
        ArrayList<String> cadenas = new ArrayList<>();
        
        enteros.add(1);
        enteros.add(2);
        enteros.add(3);
        
        cadenas.add("A");
        cadenas.add("B");
        cadenas.add("C");
        
        System.out.println(enteros);
        System.out.println(cadenas);
        
        Integer [] ent = new Integer[enteros.size()];
        ent = enteros.toArray(ent);
                
        swap(ent, 0, 2);
        System.out.println(Arrays.toString(ent));
    }
    
    public static <T> void swap(T[]a, int i, int j){
        T aux = a[i];
        a[i] = a[j];
        a[j]=aux;
    }
}
