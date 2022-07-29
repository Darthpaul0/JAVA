/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymtonificate;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class GymTonificate {

    private static ArrayList<Persona> listaPersonal = new ArrayList<>();
    private static ArrayList<String> listaEspecialidades = new ArrayList<>();
    private static ArrayList<String> listaTrabajos = new ArrayList<>();

    public static void main(String[] args) {
        //relleno para especialidades de monitor
        ejemploEspecialidades();

        //relleno para tipos de trabajos
        ejemploOficios();

        //relleno para personas, para que no esté el gimnasio vacío crearemos tres de cada tipo
        generoPersonas(listaPersonal);

        int opcion;
        do {
            opcion = generarMenuPrincipal();
            System.out.println("Ha elegido la opción: " + opcion);
            switch (opcion) {

                case 1:/*Alta personas.*/
                    altaPersonas();
                    break;

                case 2:/*Baja personas.*/
                    bajaPersonas();
                    break;

                case 3:/*Modificar personas.*/
                    modificarPersonas();
                    break;

                case 4:/*Listar personas existentes.*/
                    //Recorremos el ArrayList listaPersonal y mostramos su contenido
                    System.out.println("Gymtonificate: ");
                    for (Persona listado : listaPersonal) {
                        System.out.println(listado.toString());
                    }
                    break;

                case 5:/*Listar personas por tipo.*/
                    listarPorTipo();
                    break;

                case 6:/*Gestionar especialidades.*/
                    gestionarEspecialidades();
                    break;

                case 7:/*Gestionar trabajos.*/
                    gestionarTrabajos();
                    break;

                case 8://Salir del programa
                    System.out.println("¡Adiós!");
                    break;
            }
        } while (opcion != 8);
    }

    public static int generarMenuPrincipal() {
        // Estructura del menú

        int opcion = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("--Menú principal de GymTonificate--");
            System.out.println("¿Qué operación quiere realizar hoy?");
            System.out.println("------");
            System.out.println("1. Alta personas(socios, empleados,monitores)");
            System.out.println("2. Baja personas.");
            System.out.println("3. Modificar personas.");
            System.out.println("4. Listar personas existentes.");
            System.out.println("5. Lista personas por tipo.");
            System.out.println("6. Gestionar especialidades.");
            System.out.println("7. Gestionar trabajos.");
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

    public static String leerString(String mensaje) {
        System.out.println(mensaje);
        Scanner sc = new Scanner(System.in);
        String texto;
        texto = sc.nextLine();
        return texto;
    }

    public static char comprobarSexo(String mensaje) {
        System.out.println(mensaje);
        Scanner sc = new Scanner(System.in);
        char sexo = sc.next().charAt(0);
        while (sexo != 'H' && sexo != 'M') {
            System.out.println("El DNI introducido no es correcto, prueba de nuevo.");
            sexo = sc.next().charAt(0);
        }
        return sexo;
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

    public static Persona crearPersona() {
        //Primero preguntamos qué tipo de persona se quiere dar de alta
        System.out.println("¿A quién va a dar de alta?");
        String tipoPersona;
        do {
            tipoPersona = leerString("Escriba S para dar de alta a un socio, E para empleado y M para monitor.");
        } while (!"S".equals(tipoPersona) && !"M".equals(tipoPersona) && !"E".equals(tipoPersona));
        //Ahora, según lo que se haya elegido, se creará el tipo de persona especificado
        //Condición para crear socio
        if ("S".equals(tipoPersona)) {
            return crearSocio();
        }

        //Condición para crear empleado
        if ("E".equals(tipoPersona)) {
            return crearEmpleado();
        }

        //Condición para crear monitor
        if ("M".equals(tipoPersona)) {
            return crearMonitor();
        }
        return null;
    }

    public static String leerCodPostal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce tu código postal.");
        String expresion = sc.nextLine();
        while (!expresion.matches("\\d{5}")) {
            System.out.println("El código postal introducido no es correcto, prueba de nuevo.");
            expresion = sc.nextLine();
        }
        return expresion;
    }

    public static String leerTelefono() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce tu número de teléfono.");
        String expresion = sc.nextLine();
        while (!expresion.matches("\\d{9}")) {
            System.out.println("El teléfono introducido no es correcto, prueba de nuevo.");
            expresion = sc.next();
        }
        return expresion;
    }

    public static void ejemploEspecialidades() {
        listaEspecialidades.add("Yoga");
        listaEspecialidades.add("Crossfit");
        listaEspecialidades.add("Kickboxing");
        listaEspecialidades.add("Boxeo");
        listaEspecialidades.add("Culturismo");
    }

    public static void ejemploOficios() {
        listaTrabajos.add("Administrativo");
        listaTrabajos.add("Limpieza");
        listaTrabajos.add("Mantenimiento");
        listaTrabajos.add("Secretaria");
        listaTrabajos.add("Directiva");
    }

    public static Socio crearSocio() {
        return new Socio(leerString("Introduzca el nombre"), leerDNI(), leerString("Introduzca la dirección"), leerString("¿Localidad?"), leerString("¿Provincia?"), leerCodPostal(),
                leerTelefono(), validarEntero("Día de alta"), validarEntero("Mes de alta"), validarEntero("Año de alta"), validarEntero("Día de nacimiento"),
                validarEntero("Mes de nacimiento"), validarEntero("Año de nacimiento"), comprobarSexo("Introduzca su género. H para hombre y M para mujer."),
                validarEntero("¿A cuántas sesiones asistirá a la semana?"), true, leerString("¿Alguna lesión o enfermedad?"));
    }

    public static Empleado crearEmpleado() {
        return new Empleado(leerTrabajo(), validarFloat("Sueldo"), leerString("Extensión telefónica"), leerString("Nombre completo"),
                leerDNI(), leerString("Dirección"), leerString("Localidad"), leerString("¿Provincia?"), leerCodPostal(), leerTelefono(), validarEntero("Día de alta"),
                validarEntero("Mes de alta"), validarEntero("Año de alta"), validarEntero("Día de nacimiento"), validarEntero("Mes de nacimiento"),
                validarEntero("Año de nacimiento"), comprobarSexo("Introduzca su género. H para hombre y M para mujer."));
    }

    public static Monitor crearMonitor() {

        return new Monitor(leerString("Nombre completo"), leerDNI(), leerString("Dirección"), leerString("Localidad"),
                leerString("¿Provincia?"), leerCodPostal(), leerTelefono(), validarEntero("Día de alta"), validarEntero("Mes de alta"), validarEntero("Año de alta"),
                validarEntero("Día de nacimiento"), validarEntero("Mes de nacimiento"), validarEntero("Año de nacimiento"),
                comprobarSexo("Introduzca su género. H para hombre y M para mujer."), leerEspecialidad(), validarFloat("Sueldo"), true);
    }

    public static void altaPersonas() {
        Persona nueva = crearPersona();
        //Antes de añadir a una persona a la lista correspondiente, comprobamos que no existe ya
        if (!nueva.equals()) {
            listaPersonal.add(nueva);
            System.out.println(nueva.toString());
        } else {
            System.out.println("Lo sentimos, esa persona ya está registrada.");
        }
    }

    public static void bajaPersonas() {
        //Pedimos el DNI de la persona que queremos dar de baja
        String baja = leerDNI();
        boolean tengoDNI = false;
        //Comprobamos que ese DNI exista en listaPersonal
        for (Persona posibleBaja : listaPersonal) {
            if (posibleBaja.getDNI().equals(baja)) {
                tengoDNI = true;
                System.out.println("¿Está seguro de que quiere dar de baja a esta persona?");
                String respuesta = leerString("Introduzca S para confirmar la baja.");
                if ("S".equals(respuesta)) {
                    listaPersonal.remove(baja);
                    System.out.println("Baja realizada con éxito.");
                } else {
                    System.out.println("La persona no será dada de baja.");
                }
            } 
        }
        if(!tengoDNI){
            System.out.println("No tenemos ese DNI registrado.");
        }
    }

    public static void modificarPersonas() {
        //Primero comprobamos que la persona existe
        String modificado = leerString("Introduce el DNI de la persona a modificar.");
        for (Persona posibleModificacion : listaPersonal) {
            if (posibleModificacion.getDNI().equals(modificado)) {
                //En caso de que exista
                System.out.println("Introduce los nuevos datos de la persona.");
                posibleModificacion = crearPersona();
                System.out.println("Modificación realizada con éxito.");
                System.out.println(posibleModificacion.toString());
            }

        }
        if (!listaPersonal.contains(modificado)) {
            System.out.println("Esa persona no está registrada.");
        }

    }

    public static void listarPorTipo() {
        //Primero preguntamos qué personas quiere listar
        String alistar = leerString("¿Qué personas quiere ver? S para socios, E para empleados, M para monitores");
        //Listado de socios
        if ("S".equals(alistar)) {
            for (Persona listado : listaPersonal) {
                if (listado instanceof Socio) {
                    System.out.println(listado.toString());
                }
            }
        }
        //Listado de empleados
        if ("E".equals(alistar)) {
            for (Persona listado : listaPersonal) {
                if (listado instanceof Empleado) {
                    System.out.println(listado.toString());
                }
            }
        }
        //Listado de monitores
        if ("M".equals(alistar)) {
            for (Persona listado : listaPersonal) {
                if (listado instanceof Monitor) {
                    System.out.println(listado.toString());
                }
            }
        }
    }

    public static int generarMenuAccionesLista() {
        // Estructura del menú

        int opcion = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("¿Qué quiere hacer con la lista?");
            System.out.println("------");
            System.out.println("1. Ver lista.");
            System.out.println("2. Añadir a la lista.");
            System.out.println("3. Eliminar de la lista.");
            System.out.println("4. Volver al menú principal.");
            System.out.println("------");

            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }
            opcion = teclado.nextInt();

        } while (opcion < 1 || opcion > 4);

        return opcion;
    }

    public static void gestionarEspecialidades() {
        int opcionEspecialidad;
        do {
            opcionEspecialidad = generarMenuAccionesLista();
            switch (opcionEspecialidad) {
                case 1://Listar especialidades
                    System.out.println("Estas son las especialidades actuales: ");
                    for (String arte : listaEspecialidades) {
                        System.out.println(arte);
                    }
                    break;
                case 2://Añadir especialidad
                    //Pedimos la especialidad que se quiere añadir
                    String nuevaEspecialidad = leerString("Introduce la nueva especialidad.");
                    //comprobamos que no está ya incluida
                    if (listaEspecialidades.contains(nuevaEspecialidad)) {
                        System.out.println("Esa especialidad ya la tenemos.");
                    } else {
                        listaEspecialidades.add(nuevaEspecialidad);
                        System.out.println("La especialidad " + nuevaEspecialidad + " se ha añadido con éxito.");
                    }
                    break;
                case 3://Eliminar especialidad
                    //Pedimos la especialidad que se quiere añadir
                    String eliminaEspecialidad = leerString("Introduce la especialidad a eliminar.");
                    //comprobamos que no está ya incluida
                    if (!listaEspecialidades.contains(eliminaEspecialidad)) {
                        System.out.println("Esa especialidad no la tenemos.");
                    } else {
                        listaEspecialidades.remove(eliminaEspecialidad);
                        System.out.println("La especialidad " + eliminaEspecialidad + " se ha eliminado con éxito.");
                    }
                case 4:
                    break;
            }
        } while (opcionEspecialidad != 4);
    }

    public static void gestionarTrabajos() {
        int OpcionTrabajos;
        do {
            OpcionTrabajos = generarMenuAccionesLista();
            switch (OpcionTrabajos) {
                case 1://Listar trabajos
                    System.out.println("Estos son los empleos actuales: ");
                    for (String oficios : listaTrabajos) {
                        System.out.println(oficios);
                    }
                    break;
                case 2://Añadir trabajo
                    //Pedimos el trabajo que se quiere añadir
                    String nuevoOficio = leerString("Introduce el nuevo trabajo.");
                    //comprobamos que no está ya incluida
                    if (listaTrabajos.contains(nuevoOficio)) {
                        System.out.println("Ese trabajo ya existe.");
                    } else {
                        listaTrabajos.add(nuevoOficio);
                        System.out.println(nuevoOficio + " se ha añadido con éxito.");
                    }
                    break;
                case 3://Eliminar trabajo
                    //Pedimos el trabajo que se quiere añadir
                    String eliminaOficio = leerString("Introduce el trabajo a eliminar.");
                    //Comprobamos que tenemos un empleo como el especificado
                    if (!listaTrabajos.contains(eliminaOficio)) {
                        System.out.println("Esa especialidad no la tenemos.");
                    } else {
                        listaTrabajos.remove(eliminaOficio);
                        System.out.println("El empleo de " + eliminaOficio + " se ha eliminado con éxito.");
                    }
                case 4:
                    break;
            }
        } while (OpcionTrabajos != 4);
    }

    public static void generoPersonas(ArrayList<Persona> listaPersonal) {
        //Primero añadimos socios
        listaPersonal.add(new Socio("Homer", "12345678J", "Evergreen Terrace 742", "Springfield", "Missouri", "20151",
                "555888666", 14, 2, 2020, 19, 7, 1970, 'H', 2, true, "Obesidad mórbida, color extraño"));
        listaPersonal.add(new Socio("Marge", "98745612B", "Evergreen Terrace 742", "Springfield", "Missouri", "20151",
                "555888666", 14, 2, 2020, 27, 9, 1970, 'M', 2, true, "Color extraño"));
        listaPersonal.add(new Socio("Bart", "25143687G", "Evergreen Terrace 742", "Springfield", "Missouri", "20151",
                "555888666", 14, 2, 2020, 19, 7, 1970, 'H', 2, true, "Color extraño, gamberrismo crónico"));

        //Ahora añadimos monitores
        String[] especialidades1 = {"Yoga", "Culturismo"};
        String[] especialidades2 = {"Kickboxing", "Boxeo"};
        String[] especialidades3 = {"Crossfit", "Culturismo"};
        listaPersonal.add(new Monitor("Moe", "57481241L", "Calle Falsa 255", "Springfield", "Missouri", "20000", "555111222", 11, 5, 2018, 15, 2, 1969, 'H', especialidades1, 951, true));
        listaPersonal.add(new Monitor("Barnie", "99481241H", "Calle Falsa 5", "Springfield", "Missouri", "20005", "555131222", 13, 8, 2010, 15, 7, 1978, 'H', especialidades2, 1200, true));
        listaPersonal.add(new Monitor("McBain", "87481241S", "Calle Falsa 25", "Springfield", "Missouri", "20000", "555111222", 19, 5, 2008, 31, 5, 1980, 'H', especialidades3, 3000, true));

        //Añadimos empleados
        listaPersonal.add(new Empleado("Mantenimiento", 951, "01", "Lenny", "85251535M", "Calle Falsa 111", "Springfield",
                "Missouri", "20014", "888444222", 25, 3, 2001, 11, 5, 1973, 'H'));
        listaPersonal.add(new Empleado("Dirección", 5000, "00", "Burns", "00000001B", "Calle Falsa 1", "Springfield",
                "Missouri", "20010", "000000001", 15, 3, 1950, 11, 5, 1893, 'H'));
        listaPersonal.add(new Empleado("Administrativo", 1150, "03", "Selma", "75251535M", "Calle Falsa 111", "Springfield",
                "Missouri", "20017", "777444111", 8, 1, 1995, 11, 9, 1999, 'M'));
    }

    public static String[] leerEspecialidad() {
        ArrayList<String> especialidades = new ArrayList<>();

        //Pedimos especialidades hasta que meta una en blanco
        String especialidad;
        do {
            especialidad = leerString("Introduce al menos una especialidad. "
                    + "\nSi no se introduce nada finaliza.");
            if (!"".equals(especialidad) && listaEspecialidades.contains(especialidad)) {
                especialidades.add(especialidad);
            } else {
                System.out.println("Esa especialidad no está disponible.");
            }
        } while (!especialidad.isEmpty() || especialidades.isEmpty() && listaEspecialidades.contains(especialidad));
        String[] listado = new String[especialidades.size()];
        listado = especialidades.toArray(listado);
        return listado;
    }

    public static int validarEntero(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(mensaje);
        int num;
        final int MIN = 0;
        do {
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

    public static float validarFloat(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(mensaje);
        float num;
        final int MIN = 950;
        do {
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextFloat()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }
            num = teclado.nextFloat();

        } while (num < MIN);
        return num;
    }

    public static String leerTrabajo() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el trabajo.");
        String trabajo = sc.nextLine();
        while (!listaTrabajos.contains(trabajo)) {
            System.out.println("Ese trabajo no está disponible, prueba de nuevo.");
            trabajo = sc.next();
        }
        return trabajo;
    }

}
