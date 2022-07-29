/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosrefuerzotema3;

import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Asignatura {

// ATRIBUTOS PRIVADOS
    private String nombre;
    private int horas;

// PROGRAMA PRINCIPAL
    public static void main(String[] args) {
        Asignatura a = crearAsignatura();
        int opcion;

        do {
            opcion = menu();
            switch (opcion) {
                //Nuevo punto
                case 1:
                    a = crearAsignatura();
                    System.out.println("Se ha creado la asignatura " + a.getNombre());
                    break;
                //Comparar asignaturas
                case 2:
                    if (crearAsignatura().equals(a)) {
                        System.out.println("Asignaturas equivalentes");
                    } else {
                        System.out.println("Asignaturas distintas");
                    }
                    break;
                // mostrar asignatura
                case 3:
                    System.out.println(a.toString());
                    break;
                // salir
                case 4:
                    System.out.println("¡Adiós!");
                    break;
            }

        } while (opcion != 4);
    }

    private static int menu() {
        System.out.println("--ASIGNATURA--");
        System.out.println("1. Crear asignatura");
        System.out.println("2. Comparar asignaturas.");
        System.out.println("3. Mostrar asignatura.");
        System.out.println("4. Salir");

        int opcion = leerNumeroEntero("Introduzca la opción de menú", 1, 4);
        return opcion;
    }

    public static int leerNumeroEntero(String mensaje, int minimo, int maximo) {
        Scanner sc = new Scanner(System.in);
        int numero;
        do {
            System.out.println(mensaje);
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("No ha introducido un número. Vuelva a introducirlo: ");
            }
            numero = sc.nextInt();
        } while (numero < minimo || numero > maximo);

        return numero;
    }

    public static int leerHoras(String mensaje, int minimo) {
        Scanner sc = new Scanner(System.in);
        int numero;
        do {
            System.out.println(mensaje);
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("No ha introducido un número. Vuelva a introducirlo: ");
            }
            numero = sc.nextInt();
        } while (numero <= minimo);

        return numero;
    }

    public static String leerString(String string) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre de la asignatura.");
        String texto;
        texto = sc.nextLine();
        return texto;
    }

    public static Asignatura crearAsignatura() {
        String nombre = "";
        int horas = 0;
        return new Asignatura(leerString(nombre), leerHoras("Introduzca el número de horas", horas));
    }

// MÉTODOS PÚBLICOS
    //Constructor que establece los valores de los atributos. 
    //Si el valor de horas no es correcto se lanzará la excepción correspondiente.
    public Asignatura(String nombre, int horas) {
        this.nombre = nombre;
        if (horas <= 0) {
            throw new IllegalArgumentException("Las horas no pueden ser 0.");
        } else {
            this.horas = horas;
        }
    }

    //Constructor que establece los valores de los atributos a los del objeto pasado por parámetro.
    public Asignatura(Asignatura a) {
        this.nombre = a.getNombre();
        this.horas = a.getHoras();
    }

    //Métodos get y set para los dos atributos.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    //Redefine el método String toString(): Para escribir la asignatura en pantalla.
    @Override
    public String toString() {
        String asignatura;
        asignatura = "ASIGNATURA: " + nombre + "\n" + "HORAS LECTIVAS: " + horas;
        return asignatura;
    }

    //Redefine el método boolean equals(Asignatura a). Para determinar si dos asignaturas son iguales.
    public boolean equals(Asignatura a) {
        return (this.getNombre().equals(a.getNombre()));
    }
}
