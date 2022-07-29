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
public class Punto {
// atributos privados

    private double x;
    private double y;

// PROGRAMA PRINCIPAL 
    public static void main(String[] args) {
        Punto p = new Punto();
        int opcion;

        do {
            opcion = menu();
            switch (opcion) {
                //Nuevo punto
                case 1:
                    p = crearPunto();
                    System.out.println("Punto creado");
                    System.out.println(p);
                    break;
                //Comparar puntos
                case 2:
                    // punto de prueba
                    if (crearPunto().equals(p)) {
                        System.out.println("Puntos equivalentes");
                    } else {
                        System.out.println("Puntos distintos");
                    }
                    break;
                // mostrar punto
                case 3:
                    System.out.println(p.toString());
                    break;
                // salir
                case 4:
                    System.out.println("¡Adiós!");
                    break;
            }

        } while (opcion != 4);
    }

    private static int menu() {
        System.out.println("--PUNTO--");
        System.out.println("1. Crear punto");
        System.out.println("2. Comparar punto.");
        System.out.println("3. Mostrar punto.");
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

    public static double leerNumeroDouble(double numero) {
        Scanner sc = new Scanner(System.in);
        double num;
        System.out.println("Introduzca un número");
        while (!sc.hasNextDouble()) {
            sc.next();
            System.out.println("No ha introducido un número. Vuelva a introducirlo: ");
        }
        num = sc.nextDouble();

        return num;
    }

    public static Punto crearPunto() {
        double x = 0, y = 0;
        return new Punto(leerNumeroDouble(x), leerNumeroDouble(y));
    }

// MÉTODOS PÚBLICOS
    // Constructor por defecto. Establece el Punto en el origen de coordenadas (0,0).
    public Punto() {
        this.x = 0;
        this.y = 0;
    }

    // Constructor que inicializa los atributos a los valores pasados por parámetro.
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Constructor que inicializa los atributos a los valores del objeto Punto pasado por parámetro.
    public Punto(Punto p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    // Métodos get y set para los dos atributos.
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Redefine el método String toString(): Para escribir el punto en pantalla.
    @Override
    public String toString() {
        String punto;
        punto = this.x + "," + this.y;
        return punto;
    }

    // Redefine el método boolean equals(Punto p). Para determinar si dos puntos son iguales.
    public boolean equals(Punto p) {
        return (this.getX() == p.getX() && this.getY() == p.getY());
    }
}
