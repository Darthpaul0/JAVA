/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuadradosmagicos;

import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class GestionCM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //pedimos N
        int N = leerEntero("Introduzca el largor del cuadrado mágico: ");

        //creamos el cuadrado
        CuadradoMagico nuevo = new CuadradoMagico(N);

        //pedimos los números del potencial cuadrado mágico
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nuevo.ponerNumero(i, j, leerEntero("Introduzca un número: "));
            }
        }
        
        //mostramos el cuadrado
        System.out.println(nuevo.toString());
        
        //comprobamos si es mágico
        if(nuevo.comprobar()){
            System.out.println("Tu cuadrado es mágico");
            System.out.println("CONSTANTE MÁGICA: " + nuevo.getConstanteMagica());
        } else {
            System.out.println("Tu cuadrado no es mágico.");
        }

    }

    public String leerString(String mensaje) {
        System.out.print(mensaje + ": ");
        Scanner sc = new Scanner(System.in);
        String texto;
        texto = sc.nextLine();
        return texto;
    }

    public static int leerEntero(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        int num;
        do {
            System.out.print(mensaje);
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número entero, vuelva a intentarlo:");
            }
            num = teclado.nextInt();
            if (num < 0) {
                System.out.println("Debe ser un número entero positivo");
            }

        } while (num < 0);
        return num;
    }
}
