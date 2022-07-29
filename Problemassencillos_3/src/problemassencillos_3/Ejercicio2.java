/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemassencillos_3;

/**
 *
 * @author Pablo
 */
public class Ejercicio2 {
//
// Realiza un programa que con todos los números comprendidos entre -50 y +50 (ambos incluidos)
// calcule la suma de todos los múltiplos de 5, la cantidad de números pares y el producto de los números
// negativos.
//    

    public static void main(String[] args) {

        // Definimos un máximo y un mínimo, que serán constantes.
        // Calculamos la suma de los múltiplos de 5
        // Calculamos cúantos números pares hay
        // Hacemos el producto de los números negativos, es decir, multiplicamos desde -1 hasta -50.
        // Mostramos los cálculos por pantalla.
        // Declaración de variables
        final int MAX = 50, MIN = -50; // máximo y mínimo
        int suma = 0; // variable para sumar múltiplos
        int pares; // variable para contar pares
        long producto = -1; // variable para calcular el producto de los números negativos hasta mínimo, usando int se desborda

        // CÁLCULO DE LA SUMA DE LOS MÚLTIPLOS DE 5
        for (int i = 5; i <= MAX; i += 5) {
            // vamos calculando la suma, con cuidado de que tome el valor absoluto
            suma += i;
        }
        suma *= 2; // de esta forma incluimos los números negativos
        // Mostramos por pantalla el resultado
        System.out.println("La suma de los múltiplos de 5 desde " + MIN + " hasta " + MAX + " es: " + suma);

        // CÁLCULO DE LA CANTIDAD DE NÚMEROS PARES
        pares = (int) (Math.abs(MIN) + MAX) / 2;
        // mostramos por pantalla la cantidad de números pares
        System.out.println("Tenemos " + pares + " números pares");

        // CÁLCULO DEL PRODUCTO DE LOS NÚMEROS NEGATIVOS
        for (int i = -1; i >= MIN; i--) {
            producto *= i;
        }
        // mostramos por pantalla el producto de los números negativos

        System.out.println("El producto de los números negativos equivale a " + producto);

    }
}
