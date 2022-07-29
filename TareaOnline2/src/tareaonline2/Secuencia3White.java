/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaonline2;

/**
 *
 * @author Pablo
 */
public class Secuencia3White {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // VARIABLES

        String numString;
        String parte1String;
        int parte1 = 0;
        String parte2String;
        int parte2 = 0;
        String parte3String;
        int parte3 = 0;
        String parte4String;
        int parte4 = 0;
        int suma;
        double cifra = 0;
        long num = 0;
        int white = 100;
        final int MAX = 2000;

        //Proceso de comprobación 3white
        while (white <= MAX) {
            cifra = white;
            cifra = Math.pow(cifra, 3);
            num = (long) cifra;
            numString = String.valueOf(num);
            // Primer bloque de números
            parte1String = numString.substring(numString.length() - 3, numString.length());
            parte1 = Integer.parseInt(parte1String);
            numString = numString.substring(0, numString.length() - 3);
            // Segundo bloque de números
            parte2String = numString.substring(numString.length() - 3, numString.length());
            parte2 = Integer.parseInt(parte2String);
            numString = numString.substring(0, numString.length() - 3);
            // Tercer bloque de números
            if (numString.length() >= 3) {
                parte3String = numString.substring(numString.length() - 3, numString.length());
                parte3 = Integer.parseInt(parte3String);
                numString = numString.substring(0, numString.length() - 3);
            } else {
                parte3String = numString;
                parte3 = Integer.parseInt(numString);
                numString = "";
            }
            // Comprobamos que el bloque 3 tenga el largo suficiente antes de entrar en el bloque 4

            //Cuarto bloque de números si hay
            if (numString.length() > 0) {
                parte4 = Integer.parseInt(numString);

            } else {
                parte4 = 0;
            }

            // Suma de los bloques del número
            suma = parte1 + parte2 + parte3 + parte4;

            // Si el número es igual a la suma, entonces es parte de la secuencia 3White
            if (suma == white) {
                System.out.println("El número " + white + " es parte de la secuencia 3White");
            }
            white++;
        }
    }

}
