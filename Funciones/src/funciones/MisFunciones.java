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
public class MisFunciones {

    public static boolean esBisiesto(int año) {
        // Variables
        Scanner teclado = new Scanner(System.in);
        final int MIN = 0;
        int year;

        // Validación del año introducido
        do {
            System.out.println("Introduzca un año");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            year = teclado.nextInt();
        } while (year < MIN);

        // Comprobación de año bisiesto
        if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) {
            System.out.println("El año " + year + " es bisiesto");
        } else {
            System.out.println("El año " + year + " no es bisiesto");
        }
        return false;
    }

    public static double potencia(double base, int exponente) {
        // VARIABLES
        Scanner teclado = new Scanner(System.in);
        double numero;
        double resultado = 1;
        int exp;
        final int MIN = 0;
        final int MINEXP = 0, MAXEXP = 50;

// Validación número real de la base
        do {
            System.out.println("Introduzca cualquier número excepto el 0");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            numero = teclado.nextInt();
        } while (numero == MIN);

// Validación número del exponente
        do {
            System.out.println("Introduzca un exponente entre 1 y 50");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            exp = teclado.nextInt();
        } while (exp < MINEXP || exp > MAXEXP);

        // Cálculo del número
        for (int i = 0; i < exp; i++) {
            resultado = numero * resultado;
        }
        System.out.println("-----------------------------");
        System.out.println(numero + " al exponente " + exp + " es igual a: " + resultado);
        return 0;
    }

    public static boolean esPrimo(int numero) {
        // Definimos las variables
        int num;
        int raiz;
        boolean primo = true;
        Scanner teclado = new Scanner(System.in);

        //Pedimos el número por teclado
        System.out.println("Introduce un número");
        num = teclado.nextInt();

        // Calculamos la raíz del número primo y nos quedamos con el entero
        raiz = (int) Math.sqrt(num);

        // Para saber si un número es primo, dividimos usando un bucle for desde 2 hasta la raíz de ese número.
        for (int i = 2; i <= raiz; i++) {
            if (num % i == 0) {
                primo = false;
            }
        }
        if (primo == true) {
            System.out.println("El número " + num + " es primo");
        } else {
            System.out.println("El número " + num + " no es primo");
        }
        return false;
    }

    public static boolean fechaCorrecta(int dia, int mes, int año) {
        /**
         * Primero pedimos los datos y después comprobamos si la fecha es correcta Hay que comprobar si el año es bisiesto Usaremos un switch para los meses
         */
        // Validamos que los datos introducidos sean números
        // 
        Scanner teclado = new Scanner(System.in);
        int day;
        final int MINDIAS = 1, MAXDIAS = 31;
        int month;
        final int MINM = 1, MAXM = 12;
        int year;
        final int MINS = 0;

        do {
            System.out.println("Introduce un día entre 1 y 31");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            day = teclado.nextInt();
        } while (day > MAXDIAS || day < MINDIAS);

        // validación de los meses
        do {
            System.out.println("Introduce un mes entre 1 y 12");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            month = teclado.nextInt();
        } while (month > MAXM || month < MINM);

        // validación de los años
        do {
            System.out.println("Introduce un año");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            year = teclado.nextInt();
        } while (year < MINS);

        // pasamos a la comprobación de los datos
        switch (month) {
            // meses con 31 días
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day > 31) {
                    System.out.println("La fecha es incorrecta");
                } else {
                    System.out.println("La fecha es correcta");
                }
                break;
            case 2:
                // comprobación de año bisiesto
                if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) {
                    if (day > 29) {
                        System.out.println("La fecha es incorrecta");
                    } else {
                        System.out.println("La fecha es correcta");
                    }
                } else if (day < 29) {
                    System.out.println("La fecha es correcta");
                } else {
                    System.out.println("La fecha es incorrecta");
                }
                break;
            //meses con 30 días    
            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 30) {
                    System.out.println("La fecha es incorrecta");
                } else {
                    System.out.println("La fecha es correcta");
                }
                break;
        }
        return false;
    }

    public static boolean esCapicua(int numero) {
        // Empezamos por validar el número introducido
        // Descomponemos el número diviendo en centésimas, décimas, unidades
        // Guardamos el valor de la primera y la última división
        // Comparamos esos valores y en caso de ser iguales el número será capicúa

// VARIABLES
        Scanner teclado = new Scanner(System.in);
        int num;
        final int MINNUM = 0;
        int primerdigito;
        int ultimodigito = 0;

// VALIDACIÓN
        do {
            System.out.println("Introduce un número positivo");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            num = teclado.nextInt();
        } while (num < MINNUM);

// DESCOMPOSICIÓN
// Obtención del último dígito
        primerdigito = num % 10;

        // Obtención del primer dígito
        for (int i = 1; i < num; i *= 10) {
            ultimodigito = num / i;

        }

// COMPROBACIÓN DE QUE EL PRIMER Y EL ÚLTIMO DÍGITO SON IGUALES
        if (primerdigito - (ultimodigito) == 0) {
            System.out.println("El número es capicúa");
        } else {
            System.out.println("El número no es capicúa");
        }
        return false;
    }

    public static boolean esPerfecto(int numero) {
        // Para comprobar que es perfecto tendremos que usar un booleano
// En un bucle for podemos comprobar qué números son divisores de otro número, y su sumatoria. 
// Tendremos que anidar bucles for
// VARIABLES
        Scanner teclado = new Scanner(System.in);
        int suma = 0;
        int num;
        final int MINNUM = 0; // si se quieren calcular números perfectos más allá de 1000 se puede modificar aquí.

        // VALIDACIÓN
        do {
            System.out.println("Introduce un número positivo");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }

            num = teclado.nextInt();
        } while (num < MINNUM);

        // Calcular un número perfecto
        for (int i = 1; i < num && i >= 1; i++) {
            if (num % i == 0) {
                suma += i;
            }
        }

        System.out.println("----------------------------------------------");

        if (num == suma) {
            System.out.println("El número " + num + " es perfecto");
        }
        return false;
    }
    
    public static int validarEntero (int numero) {
        Scanner teclado = new Scanner(System.in);
        int num;
        final int MIN = 0;
        do {
            System.out.println("Introduzca un número");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }
            num = teclado.nextInt();

        } while (num <= MIN);
        return num;
    }

}
