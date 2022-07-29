/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotrivial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class JuegoTrivial {

    private static ArrayList<String> listaJugadores = new ArrayList<>();
    private static ArrayList<Pregunta> listaPreguntas = new ArrayList<>();

    public static void main(String[] args) {
        Serializar serializa = new Serializar();
        int opcion;
        do {
            opcion = generarMenuPrincipal();
            switch (opcion) {
                case 1://Listar preguntas
                    listarPreguntas();
                    break;
                case 2://Añadir pregunta
                    añadirPregunta();
                    break;
                case 3://Modificar preguntas
                    modificarPregunta();
                    break;
                case 4://Eliminar pregunta
                    eliminarPregunta();
                    break;
                case 5://Cargar serializado
                    listaPreguntas = (ArrayList<Pregunta>) serializa.leerObjeto(leerString("Introduce el nombre del archivo que quieres cargar"));
                    break;
                case 6://Guardar serializado
                    serializa.escribirObjeto(listaPreguntas, leerString("Introduce el nombre del archivo donde quieres guardar"));
                    break;
                case 7://Carga GIFT
                    break;
                case 8://Guardado GIFT
                    break;
                case 9://Jugar al trivial
                    partidaTrivial();
                    break;
                case 10:
                    System.out.println("¡Adiós!");
                    break;
            }
        } while (opcion != 10);
    }

    public static int generarMenuPrincipal() {
        // Estructura del menú

        int opcion = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("--TRIVIAL--");
            System.out.println("¿Qué quieres hacer?");
            System.out.println("------");
            System.out.println("1. Listar preguntas.");
            System.out.println("2. Añadir pregunta.");
            System.out.println("3. Modificar pregunta.");
            System.out.println("4. Eliminar pregunta.");
            System.out.println("5. Cargar.");
            System.out.println("6. Guardar.");
            System.out.println("7. Cargar GIFT.");
            System.out.println("8. Guardar GIFT.");
            System.out.println("9. Jugar partida individual.");
            System.out.println("10. Salir.");
            System.out.println("------");

            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }
            opcion = teclado.nextInt();

        } while (opcion < 1 || opcion > 13);

        return opcion;
    }

    public static void listarPreguntas() {
        if (!listaPreguntas.isEmpty()) {
            for (Pregunta p : listaPreguntas) {
                System.out.println(p.toString());
            }
        } else {
            System.out.println("Aún no se ha añadido ninguna pregunta.");
        }

    }

    public static void añadirPregunta() {
        Pregunta nueva = crearPregunta();

        //no queremos repetir preguntas
        if (listaPreguntas.contains(nueva)) {
            System.out.println("Lo sentimos, esa pregunta ya está.");
        } else {
            listaPreguntas.add(nueva);
            System.out.println("Pregunta añadida con éxito.");
        }
    }

    public static void modificarPregunta() {
        int indice = leerEntero("Introduce la posición de la pregunta quieres modificar");
        //Borramos la pregunta anterior
        listaPreguntas.remove(listaPreguntas.get(indice));
        //Ponemos la nueva en el índice de la anterior
        listaPreguntas.add(indice, crearPregunta());
    }

    public static void eliminarPregunta() {
        int borrada = leerEntero("Introduce la posición de la pregunta quieres borrar");
        listaPreguntas.remove(listaPreguntas.get(borrada));
    }

    public static void partidaTrivial() {
        Scanner sc = new Scanner(System.in);
        preguntasEjemplo();
        int preguntas = leerEntero("¿Cuántas preguntas quieres responder? ");
        Pregunta[] preguntasTrivial = new Pregunta[preguntas];
        int correctas;
        correctas = 0;
        for (int i = 0; i < preguntasTrivial.length; i++) {
            //Desordenamos las preguntas para sacarlas aleatoriamente
            Collections.shuffle(listaPreguntas);
            preguntasTrivial[i] = listaPreguntas.get(i);
            //Vamos mostrando las preguntas
            System.out.println(preguntasTrivial[i].getEnunciado());
            System.out.println(Arrays.toString(preguntasTrivial[i].getRespuestas()));
            int respuesta = leerEntero("Introduce tu respuesta" + "\n" + "(Cuidado, van del 0 al 3, la 0 es la 1)");
            if(preguntasTrivial[i].getCorrecta() == respuesta){
                correctas += 1; 
            }
            System.out.println("Pulse una tecla para mostrar la siguiente pregunta....");
            sc.next();
        }
        System.out.println("Respuestas correctas: " + correctas);
    }

    public static Pregunta crearPregunta() {
        String[] misRespuestas;
        misRespuestas = new String[4];
        String enunciado = leerString("Introduce el enunciado de la pregunta");
        for (int i = 0; i < misRespuestas.length; i++) {
            misRespuestas[i] = leerString("Introduce la respuesta número " + i + 1);
        }
        return new Pregunta(enunciado, misRespuestas, leerEntero("¿Cuál es la correcta? (Número)"));
    }

    public static String leerString(String mensaje) {
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

    public static void preguntasEjemplo() {
        String[] respuesta1 = {"Nilo", "Genil", "Támesis", "Guadalquivir"};
        String[] respuesta2 = {"Azul", "Negro", "Bayo", "Blanco"};
        String[] respuesta3 = {"Muchos", "Ninguno", "1", "8"};
        String[] respuesta4 = {"4", "8", "0", "22"};
        String[] respuesta5 = {"Madrid", "Ceuta", "Barcelona", "La Habana"};
        listaPreguntas.add(new Pregunta("Río que pasa por Sevilla", respuesta1, 3));
        listaPreguntas.add(new Pregunta("Color del caballo blanco de Santiago", respuesta2, 3));
        listaPreguntas.add(new Pregunta("¿Cuántos mundiales de fútbol ha ganado España?", respuesta3, 2));
        listaPreguntas.add(new Pregunta("Suma 2 + 2", respuesta4, 0));
        listaPreguntas.add(new Pregunta("Ciudad más poblada de España", respuesta5, 0));
    }

}
