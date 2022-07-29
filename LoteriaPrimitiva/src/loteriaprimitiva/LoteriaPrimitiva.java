/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loteriaprimitiva;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class LoteriaPrimitiva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] usuario = leerCombinacionTeclado();
        int[] ganadora = combinacionAleatoria();
        mostrarCombinacion("Combinación del usuario", usuario);
        mostrarCombinacion("Combinación ganadora", ganadora);
        
        System.out.println("Ha tenido " + aciertos(ganadora, usuario) + " aciertos");
    }

    public static int[] combinacionAleatoria() {
        int[] usuario = new int[6];
        int numero;
        for (int i = 0; i < usuario.length; i++) {
            do {
                numero = numeroAleatorio("Introduzca un número entre 1 y 49", 1, 49);
                if (buscarNumero(usuario, numero)) {
                    System.out.println("Número inválido o repetido.");
                }
            } while (buscarNumero(usuario, numero));

            usuario[i] = numero;
        }
        return usuario;
    }

    public static int[] leerCombinacionTeclado() {

        int[] usuario = new int[6];
        int numero;
        for (int i = 0; i < usuario.length; i++) {
            do {
                numero = validarEntero("Introduzca un número entre 1 y 49", 1, 49);
                if (buscarNumero(usuario, numero)) {
                    System.out.println("Número inválido o repetido.");
                }
            } while (buscarNumero(usuario, numero));

            usuario[i] = numero;
        }
        return usuario;

    }

    public static int aciertos(int[] ganadora, int[] usuario) {

        int aciertos = 0;

        for (int i = 0; i < ganadora.length - 1; i++) {
            //le restamos 1 porque son 7 números
            if (buscarNumero(usuario, ganadora[i])) {
                aciertos++;
                //para buscar el complementario
            }
            if (aciertos == 6) {
                aciertos++;
            } else if (aciertos == 5) {
                if (buscarNumero(usuario, ganadora[ganadora.length - 1])) {
                    aciertos++;
                }
            }
        }
        return aciertos;

    }

    public static void mostrarCombinacion(String mensaje, int[] c) {
        System.out.println(mensaje);
        for (int numero : c) {
            System.out.print(numero + ", ");
        }
        System.out.println("");
    }

    private static boolean buscarNumero(int[] combinacion, int n) {
        boolean encontrado = false;
        for (int i = 0; i < combinacion.length; i++) {
            if (combinacion[i] == n) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    public static int validarEntero(String mensaje, int minimo, int maximo) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(mensaje);
        int num;
        do {
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }
            num = teclado.nextInt();

        } while (num < minimo || num > maximo);
        return num;
    }
    
    public static int numeroAleatorio(String mensaje, int min, int max){
        System.out.println(mensaje);
        Random r  = new Random();
        return r.nextInt(49)+1;
    }
}
