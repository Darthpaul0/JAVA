/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemassencillos_3;

import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Ejercicio6 {

    /* 
    La cuota mensual de una hipoteca de h euros a pagar a lo largo de n años a un interés compuesto del
i por cien anual se calcula con la fórmula siguiente:
    cuotaMensual= hr / 1−(1+r )−12n
donde r se calcula así: 
    r= i / 100∗12
Se pide, dados el importe de la hipoteca h, la cantidad de años para pagarla (n) y el interés anual (i),
calcular el importe total que habremos pagado finalmente al banco.*/
    public static void main(String[] args) {
        /*
        Pedimos por teclado el montante de la hipoteca, cuantos años y qué interés nos dieron en el banco.
        Hay que validar todos estos datos, teniendo en cuenta que hipoteca e interés pueden ser double y los años son int.
        Hacemos el cálculo de la cuotaMensual y del interés mensual (r)
        Mostramos por pantalla los resultados.
         */

        // VARIABLES
        Scanner teclado = new Scanner(System.in);
        int n; // duración de la hipoteca
        double r;  // interés mensual 
        double i;  // interés anual 
        double h; // montante de la hipoteca
        double cuotaMensual; // montante de la hipoteca
        double intereses; // intereses de la hipoteca
        double total; // montante final de la hipoteca
        final int MIN = 0; // mínimo para poner a la hipoteca y al interés

        // VALIDACIÓN DEL MONTANTE DE LA HIPOTECA
        do {
            System.out.println("Montante de la hipoteca");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            h = teclado.nextInt();
        } while (h < MIN);

        // VALIDACIÓN DEL INTERÉS DE LA HIPOTECA
        do {
            System.out.println("Interés anual de la hipoteca (en porcentaje)");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            i = teclado.nextInt();
        } while (i < MIN);

        // VALIDACIÓN DE LA TIEMPO DE LA HIPOTECA
        do {
            System.out.println("Duración de la hipoteca en años");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            n = teclado.nextInt();
        } while (n < MIN);

        // CÁLCULO DEL INTERÉS MENSUAL
        r = i / (100 * 12);

        // CÁLCULO DE LA CUOTA MENSUAL
        cuotaMensual = (h * r) / Math.pow(1 + r, -12 * n);
        
        // CALCULAMOS LOS INTERESES DE LA HIPOTECA
        
        intereses = n*12*cuotaMensual;
        
        // CALCULAMOS LO QUE TENEMOS QUE PAGARLE AL BANCO
        
        total = Math.round((h + intereses)*100)/100;
        
        // MOSTRAMOS CUÁNTO DINERO TENDREMOS QUE PAGAR FINALMENTE
        
        System.out.println("Montante incial de la hipoteca: "+h);
        System.out.println("Cuota mensual a pagar: " + cuotaMensual);
        System.out.println("Intereses de la hipoteca "+ intereses);
        System.out.println("------------------");
        System.out.println("TOTAL HIPOTECA: " + total + "€");
    }
}
