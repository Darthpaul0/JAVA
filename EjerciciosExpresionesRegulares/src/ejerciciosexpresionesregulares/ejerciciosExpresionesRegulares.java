/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosexpresionesregulares;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Pablo
 */
public class ejerciciosExpresionesRegulares {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la expresión a probar.");
        String expresion = sc.nextLine();
        if (validarDNI(expresion)) {
            System.out.println("Correcto.");
        } else {
            System.out.println("Incorrecto.");
        }
    }

    public static boolean validarNumeroEntero(String expresion) {

        return expresion.matches("-?[0-9]+");
    }
    
    public static boolean validarNumeroEnteroPositivo(String expresion) {

        return expresion.matches("[0-9]+");
    }
    
    public static boolean validarNumeroEnteroNegativo(String expresion) {

        return expresion.matches("-[0-9]+");
    }
    
    public static boolean validarDNI(String expresion) {
        // formato: 00000000X (no válidas letras minúsculas ni la ñ, i, o y u)
        return expresion.matches("\\d{8}[A-HJ-NP-TV-Z]");
    }
    
     
    public static boolean validarIP(String expresion) {
    // formato: Se divide en 4 octetos, que pueden tener un valor máximo de 255 y un mínimo de 1. Ejemplo: 192.168.255.254
        return expresion.matches("(([1-9]?[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]).){3}([1-9]?[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])");
    }

    public static boolean validarMatricula(String expresion) {
    // formato: 0000XXX
        return expresion.matches("([0-9]{4})([A-Z]{3})");
    }
    
    public static boolean validarNumeroBinario(String expresion) {
    // formato: 01
        return expresion.matches("[0-1]+");
    }
    
    public static boolean validarNumeroOctal(String expresion) {
        return expresion.matches("[0-7]+");
    }
    
    public static boolean validarNumeroHexadecimal(String expresion) {
        return expresion.matches("[0-9A-Z]+");
    }
    
    public static boolean validarNumeroReal(String expresion) {
        return expresion.matches("-?[0-9]+([\\.,][0-9]+)?");
    }
    
    public static boolean validarNumeroReal_positivo(String expresion) {
        return expresion.matches("[0-9]+([\\.,][0-9]+)?");
    }
    
    public static boolean validarNumeroReal_negativo(String expresion) {
        return expresion.matches("-[0-9]+([\\.,][0-9]+)?");
    }
}
