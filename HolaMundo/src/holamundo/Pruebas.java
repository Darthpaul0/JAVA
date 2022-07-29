/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundo;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Pruebas {

    public static void main(String[] args) {
        HashSet<Integer> nuevoConjunto = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        Integer numero;
        int suma = 0;

        while (nuevoConjunto.size() < 6) {
            System.out.println("Introduzca un número");
            numero = sc.nextInt();
            for (Integer i: nuevoConjunto) {
                if (nuevoConjunto.contains(i)) {
                    System.out.println("Ese número ya está");
                } else {
                    nuevoConjunto.add(numero);
                    suma += numero;
                }
            }
            
        }
        
        System.out.println(suma);
    }
}
