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
public class Circulo {

    //atributos privados
    private Punto centro;
    private double radio;

//PROGRAMA PRINCIPAL
    public static void main(String[] args) {
        Circulo c = new Circulo();
        int opcion;

        do {
            opcion = menu();
            switch (opcion) {
                //Nuevo círculo
                case 1:
                    c = crearCirculo();
                    System.out.println("Círculo creado");
                    System.out.println(c);
                    break;
                //Comparar puntos
                case 2:
                    // círculo de prueba
                    if (crearCirculo().equals(c)) {
                        System.out.println("Círculos equivalentes");
                    } else {
                        System.out.println("Círculos distintos");
                    }
                    break;
                // mostrar círculo
                case 3:
                    System.out.println(c.toString());
                    break;
                // salir
                case 4:
                    System.out.println("¡Adiós!");
                    break;
            }

        } while (opcion != 4);
    }

    private static int menu() {
        System.out.println("--CÍRCULO--");
        System.out.println("1. Crear círculo");
        System.out.println("2. Comparar círculo.");
        System.out.println("3. Mostrar círculo.");
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

    public static Circulo crearCirculo() {
        double x = 0, y = 0, radio = 0;
        return new Circulo(leerNumeroDouble(x), leerNumeroDouble(y), leerNumeroDouble(radio));
    }

//MÉTODOS PÚBLICOS
    //----------------
    //Constructor por defecto. Establece el centro en el origen de coordenadas (0,0) y el radio a cero.
    public Circulo() {
        this.centro = new Punto(0, 0);
        this.radio = 0;
    }

    //Constructor que inicializa los atributos a los valores pasados por parámetro. Si el radio es negativo se lanzará la excepción IllegalArgumentException.
    public Circulo(Punto p, double radio) {
        centro = p;
        if (radio < 0) {
            throw new IllegalArgumentException("El radio no puede ser negativo.");
        } else {
            this.radio = radio;
        }
    }

    //Constructor que inicializa los atributos a los valores del objeto Circulo pasado por parámetro.
    public Circulo(Circulo c) {
        this.centro = c.getCentro();
        this.radio = c.getRadio();
    }

    //Constructor que inicializa los atributos a los valores pasados por parámetro. Si el radio es negativo se lanzará la excepción IllegalArgumentException.
    public Circulo(double origen_x, double origen_y, double radio) {
        this.centro = new Punto(origen_x, origen_y);
        if (radio < 0) {
            throw new IllegalArgumentException("El radio no puede ser negativo");
        } else {
            this.radio = radio;
        }
    }

    //Métodos get y set para los dos atributos.
    public Punto getCentro() {
        return centro;
    }

    public void setCentro(Punto centro) {
        this.centro = centro;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    //Devuelve el valor del área del círculo.
    double getArea() {
        double area = radio * radio * Math.PI;
        return area;
    }

    //Devuelve la longitud de la circunferencia.
    double getCircunfenrencia() {
        double circunferencia = 2 * radio * Math.PI;
        return circunferencia;
    }

    //Para escribir el círculo en pantalla.
    @Override
    public String toString() {
        String circulo;
        circulo = "Centro: " + this.centro + "\n" + "Radio: " + this.radio;
        return circulo;
    }

    //Para determinar si dos círculos son iguales.
    public boolean equals(Circulo c) {
        //comparamos los puntos con equals
        // comparamos los radios normalmente
        return (this.getCentro().equals(c.getCentro()) && this.getRadio() == c.getRadio());
    }
}
