/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurso;

/**
 *
 * @author Pablo
 */
import java.util.Scanner;

public class Concurso {
 
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes
        final char DISTANCIA= 'a' - 'A';

        // Variables de entrada
        String nombre, apellido1, apellido2;
        
        // Variables de salida
        String resultado;


        // Variables auxiliares
        // aquí, inicializamos la variable nombreApto en false
        boolean nombreApto=false, apellidosAptos, concursanteApto;
        
        
        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("CONCURSO DE TV");
        System.out.println("--------------");
        System.out.println();
        System.out.println("Nombre del concursante: ");
        nombre= teclado.nextLine();
        System.out.println("Primer apellido del concursante: ");
        apellido1= teclado.nextLine();
        System.out.println("Segundo apellido del concursante: ");
        apellido2= teclado.nextLine();

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        //
        // para ver si acaba vocal
            if ((nombre.charAt(nombre.length()-1)=='a') || (nombre.charAt(nombre.length()-1)=='e') || (nombre.charAt(nombre.length()-1)=='i') || (nombre.charAt(nombre.length()-1)=='o') || (nombre.charAt(nombre.length()-1)=='u')){
                //de esta forma, convertimos el false en true si el nombre cumple las condiciones
                nombreApto = true; 
            }
        
        /* la condición de que los apellidos tengan la misma longitud
        la cambiamos por la comprobación de si ambos son pares o impares*/
        apellidosAptos= apellido1.length()%2 == apellido2.length()%2;
                // 
        concursanteApto= nombreApto && apellidosAptos;
        // ternario para deteminar si un concursante es apto
        resultado= concursanteApto ? "APTA" : "NO APTA";
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------        
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println ("La persona es " + resultado + " para el concurso.");
        
        System.out.println ();
        System.out.println ("Fin del programa. Bye!");
    }    
}
