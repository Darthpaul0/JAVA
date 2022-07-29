/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class MenuEstandar {

    public static void main(String[] args) {
        generarMenu();
    }

    // en este caso la función está así porque la creamos para la Tarea Online 3, la aplicación de banco
    public static int generarMenu() {
        // Estructura del menú

        int opcion = 0;
        Scanner teclado = new Scanner(System.in);

        do {

            System.out.println("Bienvenido a la aplicación del Banco Malo");
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
}
