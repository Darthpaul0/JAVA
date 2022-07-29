/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Conjunto {

    public static void main(String[] args) {
        HashSet<Integer> nuevoConjunto = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int a;
        do {
            System.out.println("Introduce un número");
            while (!sc.hasNextInt()) {
                System.out.println("¡Números!");
                sc.next();
            }
            a = sc.nextInt();
            nuevoConjunto.add(a);
        } while (!(nuevoConjunto.add(a)) && nuevoConjunto.size() < 5);
        int total = 0;
        for (int s : nuevoConjunto) {
            total += s;
        }
        System.out.println("------"+"\n" + total);
    }
}
