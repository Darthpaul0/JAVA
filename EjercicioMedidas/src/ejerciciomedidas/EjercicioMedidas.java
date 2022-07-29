/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejerciciomedidas;

/**
 *
 * @author Pablo
 */

import java.util.Scanner;

public class EjercicioMedidas {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        double grados; //cambiamos metros por grados

        // Variables de salida
        double kelvin, fahrenheit; //las medidas que queremos obtener
       
        // Variables auxiliares
        // Clase Scanner para petición de datos por teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("TRANSFORMACIÓN DE UNIDADES");
        System.out.println("--------------------------");
        System.out.println(" ");
        System.out.print("Introduzca la temperatura en grados que desea transformar: "); //ahora pedimos metros
        grados = teclado.nextDouble();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        //
        // Pasamos a calcular la temperatura en grados Kelvin y Celsius, respectivamente
        //
        // Sistema Kelvin
        kelvin = grados + 273.15;
       
        // Sistema Fahrenheit
        fahrenheit = (grados*9/5) + 32;

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        //
        // Mostramos por pantalla el resultado del cálculo
        //
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println();
        System.out.println("SISTEMA KELVIN");
        System.out.println("---------------------");
        System.out.println("Una temperatura de " + grados + " en grados Celsius equivale a:");
        System.out.println(kelvin + " grados Kelvin");
        System.out.println();
        System.out.println("SISTEMA FAHRENHEIT");
        System.out.println("------------------");
        System.out.println("Una temperatura de " + grados + " en grados Celsius equivale a:");
        System.out.println(fahrenheit + " grados Fahrenheit");
        System.out.println();
        System.out.println("Fin del programa. Bye!");
    }
}