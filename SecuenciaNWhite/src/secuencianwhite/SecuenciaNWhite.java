/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secuencianwhite;

import java.util.Scanner;

/**
 *
 * @author deifont
 */
public class SecuenciaNWhite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int N, limite = 1000;

        N = leerNumeroEntero("Introduzca qué secuencia quiere calcular (>=2)", 2);
        limite = leerNumeroEntero("Introduzca hasta qué número quiere comprobar la secuencia (mayor que 0)", 1);
        System.out.println("------");

        
        //perteneceSecuenciaWhite(4950, 4);
                
        for (int i = 1; i <= limite; i++) {
            if (perteneceSecuenciaWhite(i, N)) {
                System.out.println(i);
            }
        }

    }

    public static boolean perteneceSecuenciaWhite(int numero, int N) {

        double potencia = Math.pow(numero, N);
        
        if(potencia > Long.MAX_VALUE){ //con esto lo que hacemos es comprobar que la potencia no supera la capacidad de almacenaje del tipo LONG.
            throw new IllegalArgumentException("La potencia "+N+" de "+numero+" no se puede almacenar en un tipo long");
        }
        
        long nwhite = (long)potencia; // hacemos un casting a potencia
        int divisor = (int) Math.pow(10, N); // casting a N
        long suma = 0;        
        
        while (nwhite > 0){ //mientras que nwhite se mayor que 0, podremos aplicar el método de la secuencia
            suma = suma + (nwhite % divisor);
            nwhite = nwhite / divisor;
            
        }
        
        return (suma == numero); 
    }

    public static int leerNumeroEntero(String mensaje, int minimo) {
        Scanner sc = new Scanner(System.in);
        int numero;
        do {
            System.out.println(mensaje);
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("No ha introducido un número. Pruebe de nuevo: ");
            }
            numero = sc.nextInt();
        } while (numero < minimo);

        return numero;
    }
}
