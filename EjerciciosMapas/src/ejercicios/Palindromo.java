/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Palindromo {
    //No es una solución óptima, ¿y si fueran 1000 palabras?
    public static void main(String[] args) {
        
        ArrayList<String> words = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Escribe 3 palabras.");
        words.add(scan.next());
        words.add(scan.next());
        words.add(scan.next());
        
        if(isPalindrome(words)){
            System.out.println("Es un palíndromo.");
        } else {
            System.out.println("No es un palíndromo.");
        }
    }
    
    static boolean isPalindrome(ArrayList<String> w){
        boolean correcto = false;
        //Usamos el método get para decirle que compare posiciones
        if(w.get(0).equals(w.get(2))){
            correcto = true;
        } 
        return correcto;
    }
}
