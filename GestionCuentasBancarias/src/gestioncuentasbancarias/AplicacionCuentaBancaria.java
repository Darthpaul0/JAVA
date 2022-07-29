/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncuentasbancarias;

import java.util.Scanner;
import java.util.regex.Pattern;

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
        int opcion;
        // creamos el array que contendrá las cuentas bancarias
        CuentaBancaria cuentasBancarias[];
        cuentasBancarias = new CuentaBancaria[10];
        // método para poder probar el programa
        rellenarCuentas(cuentasBancarias);
        // Menú de opciones para el usuario
        do {
            String identificador;
            int posicion;
            opcion = generarMenuGestion();
            System.out.println("Ha elegido la opción: " + opcion);
            switch (opcion) {
                case 1:

                    int cuentasExistentes = contarCuentasBancarias(cuentasBancarias);

                    // primero comprobamos que el array no está lleno
                    if (cuentasExistentes == 10) {
                        System.out.println("No se pueden crear más cuentas.");
                    } else {
                        CuentaBancaria nuevaCuenta = pedirDatosBancarios();
                        // el método localizarCuenta devolverá -1 en caso de que la cuenta no exista
                        if (localizarCuenta(nuevaCuenta.getNif(), cuentasBancarias) == -1) {
                            cuentasBancarias[cuentasExistentes] = nuevaCuenta;
                            System.out.println("Cuenta creada con éxito.");
                        } else {
                            System.out.println("Cuenta ya asociada a ese NIF/NIE/CIF.");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Indique el NIF/NIE/CIF de la cuenta que desea eliminar.");
                    identificador = pedirIdentificacionValida();
                    posicion = localizarCuenta(identificador, cuentasBancarias);
                    if (posicion == -1) {
                        System.out.println("No existe ninguna cuenta asociada a ese NIF/NIE/CIF.");
                    } else {
                        System.out.println("Se eliminará la cuenta: " + cuentasBancarias[posicion].getCCC());
                        eliminarCuentaBancaria(posicion, cuentasBancarias);
                        System.out.println("Cuenta bancaria eliminada con éxito.");
                    }
                    break;
                case 3:
                    System.out.println("Indique el NIF/NIE/CIF de la cuenta que desea gestionar.");
                    identificador = pedirIdentificacionValida();
                    posicion = localizarCuenta(identificador, cuentasBancarias);
                    if (posicion == -1) {
                        System.out.println("No existe ninguna cuenta asociada a ese NIF/NIE/CIF.");
                    } else {
                        gestionCuenta(cuentasBancarias[posicion]);
                    }
                    break;
                case 4:
                    System.out.println("La suma de los depósitos es: " + Math.round(consultarDepositos(cuentasBancarias) * 100.0) / 100.0 + "€");
                    break;
                case 5:
                    System.out.println("Ha salido del programa. ¡Adiós!");
                    break;
            }

        } while (opcion
                != 5);

    }

    // función para generar el menú
    public static int generarMenuGestion() {
        // Estructura del menú

        int opcion = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("--Menú principal--");
            System.out.println("¿Qué operación quiere realizar hoy?");
            System.out.println("------");
            System.out.println("1. Crear cuenta bancaria");
            System.out.println("2. Eliminar cuenta bancaria.");
            System.out.println("3. Gestionar cuenta bancaria.");
            System.out.println("4. Consultar depósitos.");
            System.out.println("5. Salir del programa.");
            System.out.println("------");

            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }
            opcion = teclado.nextInt();

        } while (opcion < 1 || opcion > 10);

        return opcion;
    }

    public static int generarMenuCuenta() {
        // Estructura del menú

        int opcion = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("--Menú principal--");
            System.out.println("¿Qué operación quiere realizar hoy?");
            System.out.println("------");
            System.out.println("1. Ver el número de cuenta completo (CCC – Código Cuenta Cliente");
            System.out.println("2. Ver el titular de la cuenta.");
            System.out.println("3. Ver el nif de la cuenta.");
            System.out.println("4. Modificar contraseña.");
            System.out.println("5. Realizar un ingreso.");
            System.out.println("6. Retirar efectivo.");
            System.out.println("7. Consultar saldo.");
            System.out.println("8. Volver al menú principal.");
            System.out.println("------");

            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }
            opcion = teclado.nextInt();

        } while (opcion < 1 || opcion > 10);

        return opcion;
    }

    public static void gestionCuenta(CuentaBancaria miCuenta) {
        int opcion;
        do {
            opcion = generarMenuCuenta();
            System.out.println("Ha elegido la opción: " + opcion);
            switch (opcion) {
                case 1:
                    System.out.println("Su número de cuenta es: " + miCuenta.getCCC());
                    break;
                case 2:
                    System.out.println("El titular de la cuenta es: " + miCuenta.getTitular());
                    break;
                case 3:
                    System.out.println("El NIF/NIE/CIF del titular es: " + miCuenta.getNif());
                    break;
                case 4:
                    modificarPassword(miCuenta);
                    break;
                case 5:
                    double cantidad = pedirImporte();
                    if (cantidad < 0) {
                        System.out.println("No se puede ingresar una cantidad negativa de dinero.");
                    } else {
                        miCuenta.ingresar(cantidad);
                        System.out.println("Ingreso realizado.");
                    }
                    break;
                case 6:
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
                    System.out.println(miCuenta.getSaldo() + "€");
                    break;
                case 7:
                    System.out.println("El saldo de la cuenta es: " + miCuenta.getSaldo() + "€");
                    break;
                case 8:
                    System.out.println("Va a salir de la cuenta. ¡Hasta pronto!");
                    break;
            }
        } while (opcion != 8);
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
        String identificador;
        String password;
        String entidad = "";
        String oficina = "";
        String digitos = "";
        String numCuenta = "";
        boolean correcto;
        do {
            correcto = true;
            // pedimos los datos, que son comprobados en el try-catch del main
            System.out.println("Introduzca el nombre del titular de la cuenta (mínimo de 10 y máximo de 100 caracteres).");
            titular = pedirTitular();
            identificador = pedirIdentificacionValida();
            password = pedirPasswordValido();
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
        return new CuentaBancaria(titular, identificador, password, entidad, oficina, digitos, numCuenta);
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

    public static String pedirTitular() {
        boolean correcto = false;
        Scanner teclado = new Scanner(System.in);
        String titular = "";

        System.out.println("Introduzca una titular. Recuerde, mínimo 10 caracteres y máximo 100.");
        do {
            titular = teclado.nextLine();
            correcto = Pattern.matches("^.{10,100}$", titular);
            if (!correcto) {
                System.out.println("Titular no válido, inténtelo de nuevo.");
            }
        } while (!correcto);

        return titular;
    }

// método para pedir identifición y validarla (sea NIF, CIF o NIE)
    public static String pedirIdentificacionValida() {
        boolean correcto = false;
        Scanner teclado = new Scanner(System.in);
        String identificador = "";
        System.out.println("Introduzca una identificación: NIF, NIE o CIF. Recuerde, letras mayúsculas y sin espacios.");
        do {
            identificador = teclado.nextLine();
            correcto = Pattern.matches("^\\d{8}[A-Z]$", identificador) // comprobar NIF
                    || Pattern.matches("^[A-Z]{1}\\d{7}[A-Z0-9]{1}$", identificador) // comprobar CIF
                    || Pattern.matches("^[XTYZ]{1}[0-9]{7}[A-Z]{1}$", identificador); // comprobar NIE
            if (!correcto) {
                System.out.println("Identificador no válido, inténtelo de nuevo.");
            }
        } while (!correcto);

        return identificador;
    }

    public static String pedirPasswordValido() {
        boolean correcto = false;
        Scanner teclado = new Scanner(System.in);
        String password = "";

        System.out.println("Introduzca una contraseña válida, debe tener al menos: 1 mayúscula, 1 minúscula, dos dígitos y un largor mínimo de 8.");
        do {
            password = teclado.nextLine();
            correcto = Pattern.matches("^(?=.*[0-9]{2})(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$", password); // comprobar password

            if (!correcto) {
                System.out.println("Identificador no válido, inténtelo de nuevo.");
            }
        } while (!correcto);

        return password;
    }

    public static void rellenarCuentas(CuentaBancaria lista[]) {
        lista[0] = new CuentaBancaria("mariano rodriguez", "12345678A", "Aa123456", "00491500051234567892");
        lista[1] = new CuentaBancaria("mariano rodriguez", "12345678B", "Aa123456", "21000418401234567891");
        lista[2] = new CuentaBancaria("mariano rodriguez", "12345678C", "Aa123456", "00491500051234567892");
        lista[3] = new CuentaBancaria("mariano rodriguez", "12345678D", "Aa123456", "20805801101234567891");
        lista[4] = new CuentaBancaria("mariano rodriguez", "12345678E", "Aa123456", "00246912501234567891");
        lista[5] = new CuentaBancaria("mariano rodriguez", "12345678F", "Aa123456", "00302053091234567895");
        lista[6] = new CuentaBancaria("mariano rodriguez", "12345678G", "Aa123456", "00492352082414205416");
        lista[7] = new CuentaBancaria("mariano rodriguez", "12345678H", "Aa123456", "20852066623456789011");
        lista[8] = new CuentaBancaria("mariano rodriguez", "12345678I", "Aa123456", "20852066623456789011");
        lista[9] = new CuentaBancaria("mariano rodriguez", "12345678X", "Aa123456", "20852066623456789011");
        // saldo al azar
        for (CuentaBancaria cuenta : lista) {
            cuenta.ingresar(Math.round((Math.random() * 1000) * 100.0) / 100.0);
        }
    }

    // método para saber cuántas cuentas hay
    public static int contarCuentasBancarias(CuentaBancaria lista[]) {
        int contador = 0;

        for (int i = 0; i < 10; i++) {
            if (lista[contador] != null) {
                contador++;
            }
        }
        return contador;
    }

    public static int localizarCuenta(String identificador, CuentaBancaria lista[]) {
        int posicion = -1;
        int largor = contarCuentasBancarias(lista);

        for (int i = 0; i < largor; i++) {
            if (lista[i].getNif().equals(identificador)) {
                posicion = i;
            }
        }
        return posicion;
    }

    public static void eliminarCuentaBancaria(int posicion, CuentaBancaria lista[]) {

        int largor = contarCuentasBancarias(lista);

        // con este bucle compactamos los objetos dentro del array
        for (int i = posicion; i < largor - 1; i++) {
            lista[i] = lista[i + 1];
        }

        //ponemos el último a null
        lista[largor - 1] = null;

    }

    public static double consultarDepositos(CuentaBancaria lista[]) {

        double suma = 0;
        // recorremos el array comprobando el saldo de cada elemento y acumulándolo
        for (CuentaBancaria cuenta : lista) {
            if (cuenta != null) {
                suma += cuenta.getSaldo();
            }
        }
        return suma;
    }

    public static void modificarPassword(CuentaBancaria cuenta) {
        Scanner teclado = new Scanner(System.in);
        String cadena;
        System.out.println("Introduzca la contraseña actual");
        cadena = teclado.nextLine();
        if (cadena.equals(cuenta.getPassword())) {
            System.out.println("Introduce una nueva contraseña válida.");
            String nuevaClave = pedirPasswordValido();
            if (nuevaClave.equals(cadena)) {
                System.out.println("La nueva clave debe ser diferente de la anterior.");
            } else {
                cuenta.setPassword(nuevaClave);
                System.out.println("Clave cambiada con éxito.");
            }
        }
    }
}
