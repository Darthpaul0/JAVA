/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacioncuentabancaria;

import java.util.Scanner;

/**
 * Esta clase contiene la ejecución de la aplicación
 *
 * @author Pablo
 * @version 1.0
 * @see CuentaBancaria
 */
public class AplicacionCuentaBancaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //DECLARACIÓN DE VARIABLES
        //Scanner teclado = new Scanner(System.in);
        //String titular;
        int opcion;
        // instancia de la clase CuentaBancaria
        CuentaBancaria miCuenta;
        miCuenta = pedirDatosBancarios();
        System.out.println("Datos de la cuenta: \n" + miCuenta.toString());

        // Menú de opciones para el usuario
        do {
            opcion = generarMenu();
            System.out.println("Ha elegido la opción: " + opcion);
            switch (opcion) {
                case 1:
                    System.out.println("Su número de cuenta es: " + miCuenta.getCCC());
                    break;
                case 2:
                    System.out.println("El titular de la cuenta es: " + miCuenta.getTitular());
                    break;
                case 3:
                    System.out.println("El código de la entidad es: " + miCuenta.getEntidad());
                    break;
                case 4:
                    System.out.println("El código de la oficina es: " + miCuenta.getOficina());
                    break;
                case 5:
                    System.out.println("El número de cuenta es: " + miCuenta.getNumCuenta());
                    break;
                case 6:
                    System.out.println("Los dígitos de control son: " + miCuenta.getDC());
                    break;
                case 7:
                    double cantidad = pedirImporte();
                    if (cantidad < 0) {
                        System.out.println("No se puede ingresar una cantidad negativa de dinero.");
                    } else {
                        miCuenta.ingresar(cantidad);
                        System.out.println("Ingreso realizado.");
                    }
                    break;
                case 8:
                    double importe = pedirImporte();
                    if (importe < 0) {
                        System.out.println("No se puede retirar una cantidad negativa de dinero.");
                    } else {
                        if (importe > miCuenta.getSaldo()) {
                            System.out.println("No tienes fondos suficientes.");
                        } else {
                            miCuenta.retirar(importe);
                            System.out.println("Ha retirado dinero con éxito.");
                        }
                    }

                    break;
                case 9:
                    System.out.println("El saldo de la cuenta es: " + miCuenta.getSaldo() + "€");
                    break;
                case 10:
                    System.out.println("Va a salir de la aplicación. ¡Hasta pronto!");
                    break;
            }

        } while (opcion
                != 10);

    }

    // función para generar el menú
    public static int generarMenu() {
        // Estructura del menú

        int opcion = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("--Menú principal--");
            System.out.println("¿Qué operación quiere realizar hoy?");
            System.out.println("------");
            System.out.println("1. Ver el número de cuenta completo (CCC – Código Cuenta Cliente");
            System.out.println("2. Ver el titular de la cuenta.");
            System.out.println("3. Ver el código de la entidad.");
            System.out.println("4. Ver el código de la oficina.");
            System.out.println("5. Ver el número de la cuenta.");
            System.out.println("6. Ver los dígitos de control de la cuenta.");
            System.out.println("7. Realizar un ingreso.");
            System.out.println("8. Retirar efectivo.");
            System.out.println("9. Consultar saldo.");
            System.out.println("10. Salir de la aplicación.");
            System.out.println("------");

            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }
            opcion = teclado.nextInt();

        } while (opcion < 1 || opcion > 10);

        return opcion;
    }

// función para pedir el importe en la opción 7
    public static double pedirImporte() {
        Scanner teclado = new Scanner(System.in);
        double importe;
        System.out.println("Introduzca un importe");
        //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
        //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
        while (!teclado.hasNextDouble()) {
            teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
            System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
        }
        importe = teclado.nextDouble();

        return importe;
    }

    public static CuentaBancaria pedirDatosBancarios() {
        // con esta función creamos el objeto CuentaBancaria
        // en primer lugar tenemos que pedir los datos de la cuenta, que son introducidos por teclado
        // por el usuario
        // variables locales
        String titular;
        String entidad = "";
        String oficina = "";
        String digitos = "";
        String numCuenta = "";
        boolean correcto;
        do {
            correcto = true;
            // pedimos los datos, que son comprobados en el try-catch del main
            System.out.println("Introduzca el nombre del titular de la cuenta (mínimo de 10 y máximo de 100 caracteres).");
            titular = leerCadenaTexto(CuentaBancaria.MINTITULAR, CuentaBancaria.MAXTITULAR);
            System.out.println("Introduzca el número de entidad. (4 dígitos)");
            entidad = leerCadenaNumerica(0, 9999);
            System.out.println("Introduzca el número de oficina. (4 dígitos)");
            oficina = leerCadenaNumerica(0, 9999);
            System.out.println("Introduzca los dígitos de control. (2 dígitos)");
            digitos = leerCadenaNumerica(0, 99);
            System.out.println("Introduzca el número de cuenta. (10 dígitos)");
            numCuenta = leerCadenaNumerica(0, 9999999999L);
            if (!CuentaBancaria.comprobarCCC(entidad + oficina + digitos + numCuenta)) {
                correcto = false;
                System.out.println("El CCC no es válido, revise la información introducida y vuelva a intentarlo:");
            }
        } while (!correcto);
        return new CuentaBancaria(titular, entidad, oficina, digitos, numCuenta);
    }

    public static String leerCadenaNumerica(long min, long max) {
        Scanner teclado = new Scanner(System.in);
        int numdigitos = String.valueOf(max).length();
        String formato = "%0" + String.valueOf(numdigitos) + "d";
        long num;
        do {
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextLong()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }
            num = teclado.nextLong();

        } while (num < min || num > max);
        return String.format(formato, num);
    }

    public static String leerCadenaTexto(int min, int max) {
        Scanner teclado = new Scanner(System.in);
        String cadena;
        boolean correcto;
        do {
            correcto = true;
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextLine()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es válido, vuelva a intentarlo:");
            }
            cadena = teclado.nextLine();
            if (cadena.length() < min || cadena.length() > max) {
                correcto = false;
                System.out.println("El valor introducido no es válido, vuelva a intentarlo:");
            }
        } while (!correcto);
        return String.valueOf(cadena);
    }
}
