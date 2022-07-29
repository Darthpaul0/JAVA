/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosresueltos_tema1;

import java.util.Scanner;

/**
 *
 * @author Pablo 
 * 
 * Escribe un programa en Java que solicite la altura y la longitud del lado (en metros) de una pirámide de base cuadrángular y 
 * calcule su volumen en metros cúbicos.
 * Después de realizar ese cálculo, muestra a cuántas piscinas olímpicas equivale dicho volumen, 
 * teniendo en cuenta que una piscina olímpica tiene 2500 metros cúbicos.
 */
public class piramide {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Empezamos por definir las variables
        
        double altura;
        double lado;
        double volumen;
        int piscinas;
        Scanner teclado= new Scanner (System.in);
        
        // Ahora pedimos la altura de la pirámide
        System.out.println("Altura de la pirámide en metros");
        altura = teclado.nextDouble();
        
        // Pedimos el lado de la pirámide
        System.out.println("Lado de la pirámide en metros");
        lado = teclado.nextDouble();
        
        // Calculamos el volumen de la pirámide
        volumen = (1.0/3.0)*(lado*lado*altura);
        piscinas = (int)(volumen/2500);
        
        // Mostramos los resultados finales
        
        System.out.println("Altura de la pirámide: " + altura);
        System.out.println("Lado de la pirámide: " + lado);
        System.out.println("Volumen de la pirámide: " + volumen);
        System.out.println("Equivalencia en piscinas olímpicas: " + piscinas);
        
    }

}
