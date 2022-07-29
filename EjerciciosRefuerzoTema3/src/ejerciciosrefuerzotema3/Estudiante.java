/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosrefuerzotema3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Estudiante {

    //ATRIBUTOS PRIVADOS
    private String nombre;
    private String apellido1;
    private String apellido2;
    private ArrayList<Asignatura> listaAsignaturas;

//PROGRAMA PRINCIPAL
    public static void main(String[] args) {
        Estudiante e = crearEstudiante();
        int opcion;
        System.out.println(e);
        do {
            opcion = menu();
            switch (opcion) {
                //Añadir asignatura
                case 1:
                    Asignatura a = Asignatura.crearAsignatura();
                    e.añadeAsignatura(a);
                    break;

                //Ver número de asignaturas
                case 2:
                    System.out.println("Número actual de asignaturas matriculadas: " + e.getNumeroAsignaturasMatriculadas());
                    break;
                // ver horas matriculadas
                case 3:
                    System.out.println("El estudiante " + e.getNombre() + " tiene " + e.getNumeroHorasMatriculadas() + " horas de clase.");
                    break;
                // ver posición de una asignatura
                case 4:
                    int lugar = leerNumeroEntero("Introduzca una posición", 1, e.listaAsignaturas.size());
                    System.out.println(e.getAsignatura(lugar));
                    break;
                // ver datos de un estudiante
                case 5:
                    System.out.println(e.toString());
                    break;
                // comparar estudiantes
                case 6:
                    if (crearEstudiante().equals(e)) {
                        System.out.println("Ese estudiante ya existe.");
                    } else {
                        System.out.println("No son el mismo estudiante.");
                    }
                    break;
                // salir
                case 7:
                    System.out.println("¡Adiós!¡Estudia!");
                    break;
            }

        } while (opcion != 7);
    }

    private static int menu() {
        System.out.println("--ESTUDIANTE--");
        System.out.println("1. Añadir asignatura.");
        System.out.println("2. Ver número de asignaturas matriculadas.");
        System.out.println("3. Ver horas matriculadas.");
        System.out.println("4. Ver qué posición ocupa una asignatura.");
        System.out.println("5. Ver datos de un estudiante.");
        System.out.println("6. Comparar estudiantes.");
        System.out.println("7. Salir.");

        int opcion = leerNumeroEntero("Introduzca la opción de menú", 1, 7);
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
        System.out.println("Introduzca un nombre, primer y segundo apellido.");
        String texto;
        while (sc.hasNextInt()) {
            sc.next();
            System.out.println("El nombre solo puede estar compuesto de caracteres. Vuelva a introducirlo: ");
        }
        texto = sc.nextLine();
        return texto;
    }

    public static Estudiante crearEstudiante() {
        String nombre = "";
        String apellido1 = "";
        String apellido2 = "";

        return new Estudiante(leerString(nombre), leerString(apellido1), leerString(apellido2));

    }

//MÉTODOS PÚBLICOS
    //Constructor que establece los valores de los atributos nombre y apellidos.
    public Estudiante(String nombre, String apellido1, String apellido2) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.listaAsignaturas = new ArrayList<>();
    }

    //Constructor que establece los valores de los atributos a los del objeto pasado por parámetro.
    public Estudiante(Estudiante e) {
        this.nombre = e.getNombre();
        this.apellido1 = e.getApellido1();
        this.apellido2 = e.getApellido2();
    }

    //Métodos get y set para los atributos.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public ArrayList<Asignatura> getListaAsignaturas() {
        return listaAsignaturas;
    }

    public void setListaAsignaturas(ArrayList<Asignatura> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }

    //Añade la asignatura a la lista de asignaturas matriculadas. 
    //Un alumno no puede estar matriculado de más de 30 horas, por lo que se debe
    //comprobar que no se supera este límite antes de añadir la asignatura. 
    //Devuelve true si la asignatura se añade correctamente y false en caso contrario.
    public boolean añadeAsignatura(Asignatura a) {
        boolean correcto = true;

        int totalHoras = 0;
        for (Asignatura materia : listaAsignaturas) {
            totalHoras += materia.getHoras();
        }
        if (totalHoras > 30) {
            correcto = false;
            System.out.println("Se ha alcanzado el límite de 30 horas lectivas, el alumno no da para más.");
        } else {
            listaAsignaturas.add(a);
            System.out.println("Asignatura añadida con éxito.");
        }

        return correcto;

    }

    //Devuelve el número de asignaturas matriculadas.
    public int getNumeroAsignaturasMatriculadas() {
        int total = this.listaAsignaturas.size();
        return total;
    }

    //Devuelve el número de horas matriculadas.
    public int getNumeroHorasMatriculadas() {
        int total = 0;
        for (Asignatura a : listaAsignaturas) {
            total += a.getHoras();
        }

        return total;

    }

    //Devuelve la asignatura que ocupa la posición indicada por parámetro en la lista de asignaturas.
    public Asignatura getAsignatura(int posicion) {

        return this.listaAsignaturas.get(posicion - 1);

    }
    //Redefine el método String toString(): Para escribir el Estudiante en pantalla.

    public String toString() {
        String alumno;
        alumno = "NOMBRE: " +this.nombre + "\n" + "PRIMER APELLIDO: " + this.apellido1 + "\n" + "SEGUNDO APELLIDO: " + this.apellido2;
        return alumno;

    }

    //Redefine el método boolean equals(Estudiante e). Para determinar si dos estudiantes son iguales (son iguales si se llaman igual).
    public boolean equals(Estudiante e) {
        return (this.getNombre().equals(e.getNombre()) && this.getApellido1().equals(e.getApellido1()) && this.getApellido2().equals(e.getApellido2()));
    }
}
