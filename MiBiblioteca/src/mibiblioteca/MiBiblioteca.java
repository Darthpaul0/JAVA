/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mibiblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class MiBiblioteca {

    //ATRIBUTOS PRIVADOS
    private static ModeloLibros biblioteca = new ModeloLibros();
    private static ArrayList<Prestamo> prestamos = new ArrayList<>();

    public static void main(String[] args) {
        //Algunos libros de ejemplo para llenar la biblioteca
        ejemploLibros();

        int opcion;
        do {
            opcion = generarMenuPrincipal();
            System.out.println("Ha elegido la opción: " + opcion);
            switch (opcion) {

                case 1:/*Añadir nuevo libro. */
                    añadirNuevoLibro();
                    break;

                case 2:/*Eliminar un libro. */
                    eliminarLibro();
                    break;

                case 3://Buscar libro. Mostrará al usuario el siguiente submenú de opciones:
                    buscarLibro();
                    break;

                case 4:/*Prestar libros.*/
                    prestarLibro();
                    break;

                case 5:/*Devolver libros.*/
                    devolverLibro();
                    break;

                case 6:/*Prorrogar préstamo.*/
                    prorrogarPrestamo();
                    break;

                case 7:/*Consultar préstamos.*/
                    consultarPrestamos();
                    break;
                case 8://Salir del programa
                    break;
            }
        } while (opcion != 8);
    }

    public static int generarMenuPrincipal() {
        // Estructura del menú

        int opcion = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("--Menú principal de la bibliteca--");
            System.out.println("¿Qué operación quiere realizar hoy?");
            System.out.println("------");
            System.out.println("1. Añadir nuevo libro");
            System.out.println("2. Eliminar un libro.");
            System.out.println("3. Buscar un libro.");
            System.out.println("4. Prestar libros.");
            System.out.println("5. Devolver libros.");
            System.out.println("6. Prorrogar préstamo.");
            System.out.println("7. Consultar préstamos.");
            System.out.println("8. Salir del programa.");
            System.out.println("------");

            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }
            opcion = teclado.nextInt();

        } while (opcion < 1 || opcion > 9);

        return opcion;
    }

    public static int generarMenuBusqueda() {
        // Estructura del menú

        int opcion = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("--Menú de búsquedas--");
            System.out.println("¿Qué operación quiere realizar?");
            System.out.println("------");
            System.out.println("1. Buscar libro por título.");
            System.out.println("2. Buscar libro por autor.");
            System.out.println("3. Buscar libro por ISBN.");
            System.out.println("4. Volver al menú principal.");
            System.out.println("------");

            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }
            opcion = teclado.nextInt();

        } while (opcion < 1 || opcion > 5);

        return opcion;
    }

    public static int generarMenuConsulta() {
        // Estructura del menú

        int opcion = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("--Menú de consultas--");
            System.out.println("¿Qué operación quiere realizar?");
            System.out.println("------");
            System.out.println("1. Consultar todos los préstamos.");
            System.out.println("2. Consultar préstamos caducados.");
            System.out.println("3. Consultar préstamos con fecha de vencimiento cercana.");
            System.out.println("4. Volver al menú principal.");
            System.out.println("------");

            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }
            opcion = teclado.nextInt();

        } while (opcion < 1 || opcion > 5);

        return opcion;
    }

    public static int generarMenuAccionesLibro() {
        // Estructura del menú

        int opcion = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("¿Qué quiere hacer con los libros mostrados?");
            System.out.println("------");
            System.out.println("1. Eliminar libros.");
            System.out.println("2. Realizar un préstamo.");
            System.out.println("3. Volver al submenú de búsqueda.");
            System.out.println("------");

            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }
            opcion = teclado.nextInt();

        } while (opcion < 1 || opcion > 3);

        return opcion;
    }

    public static String leerDNI() {
        // formato: 00000000X (no válidas letras minúsculas ni la Ñ, I, O y U)
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce tu DNI.");
        String expresion = sc.nextLine();
        while (!expresion.matches("\\d{8}[A-HJ-NP-TV-Z]")) {
            System.out.println("El DNI introducido no es correcto, prueba de nuevo.");
            expresion = sc.nextLine();
        }
        return expresion;
    }

    public static String leerISBN() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ISBN del libro.");
        String ISBN = sc.nextLine();
        while (!Libro.compruebaISBN10(ISBN) && !Libro.compruebaISBN13(ISBN)) {
            System.out.println("El ISBN introducido no es correcto, prueba de nuevo.");
            ISBN = sc.nextLine();
        }
        return ISBN;
    }

    public static String leerString() {
        Scanner sc = new Scanner(System.in);
        String texto;
        texto = sc.nextLine();
        return texto;
    }

    public static Libro crearLibro() {
        System.out.println("Introduce el título del libro");
        String titulo = leerString();
        String ISBN = leerISBN();
        ArrayList<String> autores = new ArrayList<>();

        //Pedimos autores hasta que meta uno en blanco
        String autor;
        do {
            System.out.println("Introduce al menos un autor o autores del libro. "
                    + "\nSi no se introduce nada finaliza.");
            autor = leerString();
            if (!"".equals(autor)) {
                autores.add(autor);
            }
        } while (!autor.isEmpty() || autores.isEmpty());
        String[] escritores = new String[autores.size()];
        escritores = autores.toArray(escritores);
        return new Libro(titulo, ISBN, escritores);

    }

    public static void añadirNuevoLibro() {

        //Creamos el objeto libro siempre y cuando el DNI sea correcto
        Libro l = crearLibro();
        //Lo añadimos a la biblioteca
        biblioteca.añadir(l);
        System.out.println("Libro añadido con éxito a la biblioteca.");
    }

    public static void eliminarLibro() {
        //Pedimos el ISBN del libro que queremos eliminar.
        System.out.println("Introduzca el ISBN del libro que quiere eliminar.");
        String ISBN = leerISBN();
        //Comprobamos que no está prestado
        boolean prestado = false;
        for (Prestamo prestamo : prestamos) {
            //recorremos los ISBN de cada objeto préstamo
            for (String s : prestamo.getIsbn()) {
                if (s.equals(ISBN)) {
                    prestado = true;
                }
            }
        }
        if (prestado) {
            System.out.println("Se siente, ese libro se encuentra ahora mismo en préstamo.");
        } else {
            biblioteca.eliminar(ISBN);
            System.out.println("Libro eliminado con éxito.");
        }
    }

    public static void buscarLibro() {
        int opcionbusqueda;
        Libro[] librosBuscados;
        do {
            opcionbusqueda = generarMenuBusqueda();
            switch (opcionbusqueda) {

                case 1:/*Buscar libro por título.*/

                    System.out.println("Introduzca el título del libro a buscar.");
                    String titulo = leerString();
                    //Buscamos el libro en la biblioteca
                    librosBuscados = biblioteca.buscarTitulo(titulo);
                    if (librosBuscados == null) {
                        System.out.println("Lo sentimos, no encontramos ningún libro que contenga ese título.");
                    } else {
                        accionesBuscarLibro(librosBuscados);
                    }
                    break;

                case 2:/*Buscar libro por autor.*/

                    System.out.println("Introduzca el título del libro de los autores a buscar.");
                    String nombreLibro = leerString();
                    //Buscamos el libro en la biblioteca
                    if (biblioteca.buscarAutor(nombreLibro) == null) {
                        System.out.println("Lo sentimos, no encontramos ningún libro asociado a ese autor.");
                    } else {
                        //Recogemos la lista de libros buscados
                        librosBuscados = biblioteca.buscarAutor(nombreLibro);
                        //Mostramos menú de acciones
                        accionesBuscarLibro(librosBuscados);
                    }
                    break;

                case 3:/*Buscar libro por ISBN.*/

                    String isbn = leerISBN();
                    Libro nuevoLibro = biblioteca.buscar(isbn);
                    if (nuevoLibro == null) {
                        System.out.println("Ningún libro corresponde a ese ISBN.");
                    } else {
                        System.out.println("Libro encontrado: ");
                        librosBuscados = new Libro[1];
                        librosBuscados[0] = nuevoLibro;
                        accionesBuscarLibro(librosBuscados);
                    }

                    break;

                case 4://Vuelve al menú principal.
                    break;
            }
        } while (opcionbusqueda != 4);
    }

    public static void prestarLibro() {
        //Pedimos DNI
        String DNI = leerDNI();
        //Pedimos ISBN de los libros que se prestarán
        ArrayList<String> ISBNes = new ArrayList<>();
        ArrayList<String> ISBNesBuenos = new ArrayList<>();
        String continuar;
        do {
            ISBNes.add(leerISBN());
            System.out.println("¿Quiere sacar algún libro más (N) para salir)?");
            continuar = leerString();
        } while (!"N".equals(continuar));
        //Nos quedamos con los ISBN que se pueden prestar y  que existan en la biblioteca
        for (String isbn : ISBNes) {
            //Comprobamos que el libro no esté prestado, exista y no esté repetido
            if ((!comprobarPrestado(isbn)) && ((biblioteca.buscar(isbn)) != null) && (!ISBNesBuenos.contains(isbn))) {
                ISBNesBuenos.add(isbn);
            }
        }
        System.out.println(ISBNesBuenos.toString());
        if (ISBNesBuenos.isEmpty()) {
            System.out.println("No se ha podido hacer el préstamo: ISBN inexistentes o no disponibles.");
        } else {
            String[] listaPrestados = new String[ISBNesBuenos.size()];
            listaPrestados = ISBNesBuenos.toArray(listaPrestados);
            Calendar hoyes = Calendar.getInstance();
            Prestamo nuevo = new Prestamo(DNI, listaPrestados, Prestamo.DIAS_PRESTAMO_DEFAULT,
                    hoyes.get(Calendar.DAY_OF_MONTH), hoyes.get(Calendar.MONTH), hoyes.get(Calendar.YEAR));
            prestamos.add(nuevo);
        }
    }

    public static void devolverLibro() {
        //Pedimos el dni al usuario
        String dni = leerDNI();
        int posicion = -1;
        //Recorremos el array de prestamos
        for (int i = 0; i < prestamos.size(); i++) {
            //En cada elemento del array vemos si algún libro en préstamo coincide con el array
            if (prestamos.get(i).getDni().equals(dni)) {
                posicion = i;
            }
        }
        //Si la posición ha cambiado significa que hemos encontrado el préstamo
        if (posicion != -1) {
            Prestamo prestado = prestamos.get(posicion);
            //Comprobamos el plazo de entrega
            if (prestado.prestamoCaducado()) {
                System.out.println("El préstamo caducó hace " + prestado.diasCaducaPrestamo() * -1 + " días");
                //La sanción en días es igual al número de libros prestados por la cantidad de días que se retrasó en su devolución.
                System.out.println("La sanción asciende a " + prestado.diasCaducaPrestamo() * (prestado.getIsbn().length * -1)
                        + " días sin poder sacar libros de la biblioteca.");
            } else {
                System.out.println("Préstamo entregado en plazo.");
            }
            prestamos.remove(prestado);
            System.out.println("Préstamo devuelto con éxito.");
        } else {
            System.out.println("No hay ningún préstamo correspondiente a ese DNI.");
        }
    }

    public static void prorrogarPrestamo() {
        //Pedimos el dni al usuario
        String dni = leerDNI();
        //Buscamos el préstamo a devolver en la lista de préstamos
        for (Prestamo prestado : prestamos) {
            if (prestado.getDni().equals(dni)) {
                //Antes de nada comprobamos que no supera el plazo máximo de 60 días de préstamo
                if (prestado.diasCaducaPrestamo() + 10 > 60) {
                    System.out.println("No podemos prorrogar más el préstamo, se ha alcanzado el máximo de días permitidos.");
                } else {
                    prestado.setDiasPrestamo(10);
                    Calendar fechaentrega = Calendar.getInstance();
                    fechaentrega = (Calendar) prestado.getFechaPrestamo().clone();
                    fechaentrega.add(Calendar.DAY_OF_YEAR, 10);
                    System.out.println("Préstamo prorrogado con éxito." + "Próxima fecha: " + fechaentrega.getTime());
                }
            } else {
                System.out.println("No hay ningún libro prestado correspondiente a ese ISBN.");
            }
        }
    }

    public static void consultarPrestamos() {
        int opcionprestamo;
        do {
            opcionprestamo = generarMenuConsulta();
            switch (opcionprestamo) {

                case 1://Consultar todos los préstamos.
                    if (prestamos.isEmpty()) {
                        System.out.println("Actualmente no hay libros en préstamo.");
                    } else {
                        for (Prestamo dejados : prestamos) {
                            System.out.println(dejados.toString());
                        }
                    }
                    break;

                case 2://Consultar préstamos caducados
                    for (Prestamo caducados : prestamos) {
                        if (caducados.prestamoCaducado()) {
                            System.out.println("Han caducado los siguientes préstamos: " + caducados.getDni());
                        } else {
                            System.out.println("No hay préstamos caducados.");
                        }
                    }
                    break;

                case 3:// Consultar préstamos próximos a caducar
                    for (Prestamo caducados : prestamos) {
                        if (caducados.diasCaducaPrestamo() < 6) {
                            System.out.println("Caducarán en los próximos 5 días los siguientes préstamos: " + caducados.getDni());
                        } else {
                            System.out.println("No hay préstamos próximos a caducar.");
                        }
                    }
                    break;
                case 4:// Volver al menú principal
                    break;
            }
        } while (opcionprestamo != 4);

    }

    public static void accionesBuscarLibro(Libro[] librosBuscados) {
        //Mostramos los libros
        System.out.println(Arrays.toString(librosBuscados));
        int opcionsubautor;
        do {
            opcionsubautor = generarMenuAccionesLibro();
            switch (opcionsubautor) {

                case 1://Eliminar libros encontrados
                    for (Libro encontrado : librosBuscados) {
                        biblioteca.eliminar(encontrado.getISBN());
                    }
                    System.out.println("Libros eliminados.");
                    break;

                case 2://Préstamo de los libros encontrados
                    System.out.println("Introduce el DNI: ");
                    String dni = leerString();
                    // Creamos el préstamo de los libros comprobando que no están ya prestado
                    ArrayList<Libro> librosparaPrestamos = new ArrayList<>();
                    // recorremos libros que se pueden prestar
                    for (Libro posiblePrestado : librosBuscados) {
                        //si no está prestado se añade a los libros que se VAN a prestar
                        if (!comprobarPrestado(posiblePrestado.getISBN())) {
                            librosparaPrestamos.add(posiblePrestado);
                        }
                    }

                    //Si hay libros que prestar, creamos el objeto préstamo y lo añadimos a la lista
                    if (!librosparaPrestamos.isEmpty()) {
                        Libro[] prestoLibros = new Libro[librosparaPrestamos.size()];
                        prestoLibros = librosparaPrestamos.toArray(prestoLibros);
                        prestamos.add(new Prestamo(dni, prestoLibros, Prestamo.DIAS_PRESTAMO_DEFAULT, Calendar.DAY_OF_MONTH, Calendar.MONTH, Calendar.YEAR));
                        System.out.println("Libros prestados: " + librosparaPrestamos.toString());
                    } else {
                        System.out.println("No hay libros para prestar.");
                    }
                    break;

                case 3://Vuelve al menú principal.
                    break;
            }
        } while (opcionsubautor != 3);
    }

    public static void ejemploLibros() {
        String escritor1[] = {"Pérez-Reverte"};
        String escritor2[] = {"George R.R. Martin"};
        String escritor3[] = {"Andrzej Zapkowski"};
        String escritor4[] = {"Menganito", "Fulanito"};

        Libro ejemplar1 = new Libro("El Club Dumas", "8428324891", escritor1);
        Libro ejemplar2 = new Libro("Juego de Tronos", "8420681865", escritor2);
        Libro ejemplar3 = new Libro("Libro prueba", "8420685623", escritor4);
        Libro ejemplar4 = new Libro("El último deseo", "9788447356027", escritor3);
        Libro ejemplar5 = new Libro("La esp+ada del destino", "8448103351", escritor3);
        biblioteca.añadir(ejemplar1);
        biblioteca.añadir(ejemplar2);
        biblioteca.añadir(ejemplar3);
        biblioteca.añadir(ejemplar4);
        biblioteca.añadir(ejemplar5);
    }

    public static boolean comprobarPrestado(String isbn) {
        // recorremos libros que se pueden prestar
        boolean prestado = false;
        // rcorremos si están ya prestados
        for (Prestamo prestamoHecho : prestamos) {
            // para cada libro del préstamo hecho miramos el ISBN
            for (String isbnPrest : prestamoHecho.getIsbn()) {
                if (isbnPrest.equals(isbn)) {
                    prestado = true;
                }
            }
        }
        return prestado;
    }

}
