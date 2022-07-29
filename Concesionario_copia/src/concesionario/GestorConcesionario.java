/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class GestorConcesionario {

    public static void main(String[] args) {
        System.out.println("Bienvenido al Gestor del concesionario.");
        System.out.println("Le recordamos que debe cargar los datos si no lo ha hecho ya para acceder a la información.");
        Concesionario c = new Concesionario();
        
        //Instanciamos nuestra clase encargada de la serialización
        Serializar serializa = new Serializar();
        int opcion;
        do {
            opcion = generarMenuPrincipal();
            System.out.println("Ha elegido la opción: " + opcion);
            switch (opcion) {

                case 1:/*Contratar vendedor.*/
                    c.contratarVendedor();
                    break;

                case 2:/*Despedir vendedor.*/
                    c.despedirVendedor();
                    break;

                case 3:/*Gestionar vendedor.*/
                    gestionarVendedor(c);
                    break;

                case 4:/*Ver listado de vendedores*/
                    //Recorremos el ArrayList listaPersonal y mostramos su contenido
                    System.out.println("Plantilla actual del concesionario: ");
                    for (Persona listado : c.getListaPersonas()) {
                        System.out.println(listado.toString());
                    }
                    break;

                case 5:/*Buscar vehículo*/
                    c.buscarVehiculo();
                    break;

                case 6:/*Vender vehículo*/
                    c.venderVehiculo();
                    break;

                case 7:/*Añadir vehículo*/
                    c.añadirVehiculo();
                    break;

                case 8:/*Ver balance del concesionario*/
                    c.verBalance();
                    break;

                case 9:/*Cargar datos predeterminados*/
                    //Cargamos los datos 
                    c = (Concesionario) serializa.leerObjeto("predeterminados.dat");
                    break;

                case 10:/*Cargar datos*/
                    c = (Concesionario) serializa.leerObjeto("datosConcesionario.dat");
                    break;

                case 11:/*Guardar datos*/
                    //Ahora guardamos la información: los empleados, los vehículos, los ingresos y gastos
                    serializa.escribirObjeto(c, "datosConcesionario.dat");
                    break;

                case 12:/*Salir*/
                    System.out.println("¡Adiós!");
                    break;
            }

        } while (opcion
                != 12);

    }

    public static int generarMenuPrincipal() {
        // Estructura del menú

        int opcion = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("--Menú principal del Concesionario--");
            System.out.println("¿Qué operación quiere realizar hoy?");
            System.out.println("------");
            System.out.println("1. Contratar vendedor.");
            System.out.println("2. Despedir vendedor.");
            System.out.println("3. Gestionar vendedor.");
            System.out.println("4. Ver listado de vendedores.");
            System.out.println("5. Buscar vehículo.");
            System.out.println("6. Vender vehículo.");
            System.out.println("7. Añadir vehículo.");
            System.out.println("8. Ver balance del concesionario.");
            System.out.println("9. Cargar datos predeterminados.");
            System.out.println("10. Cargar datos.");
            System.out.println("11. Guardar datos.");
            System.out.println("12. Salir.");
            System.out.println("------");

            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }
            opcion = teclado.nextInt();

        } while (opcion < 1 || opcion > 13);

        return opcion;
    }

    public static int generarMenuAccionesVendedor() {
        // Estructura del menú

        int opcion = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("Menú de gestión de vendedores");
            System.out.println("------");
            System.out.println("1. Subir sueldo.");
            System.out.println("2. Bajar sueldo.");
            System.out.println("3. Cambiar vacaciones.");
            System.out.println("4. Dar un plus.");
            System.out.println("5. Volver al menú principal.");
            System.out.println("------");

            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }
            opcion = teclado.nextInt();

        } while (opcion < 1 || opcion > 5);

        return opcion;
    }

    public static int generarMenuAccionesBuscarVehiculo() {
        // Estructura del menú

        int opcion = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("Menú de búsqueda de vehículos.");
            System.out.println("------");
            System.out.println("1. Buscar por marca.");
            System.out.println("2. Buscar por precio.");
            System.out.println("5. Volver al menú principal.");
            System.out.println("------");

            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número, vuelva a intentarlo:");
            }
            opcion = teclado.nextInt();

        } while (opcion < 1 || opcion > 3);

        return opcion;
    }

    public static void gestionarVendedor(Concesionario concesionario) {
        boolean existeDNI = false;
        int accionesVendedor;
        do {
            accionesVendedor = generarMenuAccionesVendedor();
            switch (accionesVendedor) {
                case 1:
                    /*Subir sueldo.*/
                    String posibleSubida = leerDNI();
                    for (Persona posible : concesionario.getListaPersonas()) {
                        if (posible instanceof Vendedor) {
                            Vendedor vendedor = (Vendedor) posible;
                            if (vendedor.getDNI().equals(posibleSubida)) {
                                existeDNI = true;
                                vendedor.subirSueldo(leerEntero("Introduce el porcentaje de subida:"));
                                System.out.println("El nuevo sueldo de " + vendedor.getNombre() + " " + vendedor.getApellidos() + " es de " + vendedor.getSueldo());
                            }
                        }
                    }
                    //En caso de no tener ese DNI
                    if (!existeDNI) {
                        System.out.println("Ese DNI no está registrado.");
                    }
                    break;
                case 2:
                    /*Bajar sueldo.*/
                    String posibleBajada = leerDNI();
                    for (Persona posible : concesionario.getListaPersonas()) {
                        if (posible instanceof Vendedor) {
                            Vendedor vendedor = (Vendedor) posible;
                            if (vendedor.getDNI().equals(posibleBajada)) {
                                existeDNI = true;
                                int bajada = leerEntero("Introduce el porcentaje de bajada de sueldo: ");
                                double nuevoSueldo = vendedor.getSueldo() * (1 - bajada / 100);
                                if (nuevoSueldo < Vendedor.SALARIO_MINIMO) {
                                    System.out.println("No se le puede bajar más el sueldo.");
                                } else {
                                    vendedor.bajarSueldo(bajada);
                                    System.out.println("El nuevo sueldo de " + vendedor.getNombre() + " " + vendedor.getApellidos() + " es de " + vendedor.getSueldo());
                                }
                            }
                        }
                    }
                    //En caso de no tener ese DNI
                    if (!existeDNI) {
                        System.out.println("Ese DNI no está registrado.");
                    }
                    break;
                case 3:
                    /*Cambiar vacaciones.*/
                    String cambioVacaciones = leerDNI();
                    for (Persona posible : concesionario.getListaPersonas()) {
                        if (posible instanceof Vendedor) {
                            Vendedor dias = (Vendedor) posible;
                            if (dias.getDNI().equals(cambioVacaciones)) {
                                existeDNI = true;
                                int libres = leerEntero("Días de vacaciones que sumamos o restamos");
                                if (dias.getDiasVacaciones() + libres > Vendedor.VACACIONES_MINIMAS) {
                                    dias.modificarVacaciones(libres);
                                    System.out.println(dias.getNombre() + " " + dias.getApellidos() + " tiene " + dias.getDiasVacaciones() + " días de vacaciones");
                                } else {
                                    System.out.println("No puede tener menos de " + Vendedor.VACACIONES_MINIMAS + " días de vacaciones.");
                                }
                            }
                        }
                    }
                    //En caso de no tener ese DNI
                    if (!existeDNI) {
                        System.out.println("Ese DNI no está registrado.");
                    }
                    break;
                case 4:
                    /*Dar un plus.*/
                    String posiblePlus = leerDNI();
                    for (Persona posible : concesionario.getListaPersonas()) {
                        if (posible instanceof Vendedor) {
                            Vendedor sueldo = (Vendedor) posible;
                            if (sueldo.getDNI().equals(posiblePlus)) {
                                sueldo.fijarIncentivo();
                                System.out.println(sueldo.getNombre() + " " + sueldo.getApellidos() + " ha recibido un plus de 500€");
                            } else {
                                System.out.println("Ese DNI no está registrado.");
                            }
                        }
                    }
                    break;
                case 5:
                    /*Volver al menú principal.*/
                    break;

            }
        } while (accionesVendedor != 5);
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

    public static String leerString(String mensaje) {
        System.out.println(mensaje);
        Scanner sc = new Scanner(System.in);
        String texto;
        texto = sc.nextLine();
        return texto;
    }

    public static int leerEntero(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(mensaje);
        int num;

        //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
        //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
        while (!teclado.hasNextInt()) {
            teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
            System.out.println("El valor introducido no es un número entero, vuelva a intentarlo:");
        }
        num = teclado.nextInt();

        return num;
    }

    public static String leerMatricula() {
        // formato: 0000XXX 
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la matrícula del vehículo.");
        String expresion = sc.nextLine();
        while (!expresion.matches("([0-9]{4})([A-Z]{3})")) {
            System.out.println("La matrícula introducida no es correcta, prueba de nuevo.");
            expresion = sc.nextLine();
        }
        return expresion;

    }

    public static void generoPersonas(ArrayList<Persona> listaPersonas) {
        //Añadimos unos cuantos vendedores de prueba
        listaPersonas.add(new Vendedor(3000, 10, "Ciencias Políticas", 90, "Pedro", "Tima D'Or", "14151213M", 50));
        listaPersonas.add(new Vendedor(1000, 1, "Bellas Artes", 30, "Juan", "Tahúr Gordo", "55668899D", 40));
        listaPersonas.add(new Vendedor(1500, 3, "Finanzas", 45, "Margarita", "Flores del Campo", "77443311K", 30));
    }

    public static void generoVehiculos(ArrayList<Vehículo> listaVehiculos) {
        //Añadimos vehículos variados a la oferta del concesionario
        listaVehiculos.add(new Coche("BMW", "525", 2016, 400, 5, false, 1475, 175, 450, 150, "negro", 32000, "1523JTD", 10000, 4, 2500, 192, "Diésel"));
        listaVehiculos.add(new Coche("BMW", "320", 2010, 370, 5, false, 1325, 170, 375, 140, "azul", 16000, "4715HRF", 110000, 4, 2200, 150, "Gasolina"));
        listaVehiculos.add(new Coche("BMW", "730", 2002, 500, 5, false, 1700, 198, 500, 155, "azul oscuro", 6000, "4578BTD", 200000, 4, 3000, 241, "Diésel"));
        listaVehiculos.add(new Moto("BMW", "RT1200", 2010, false, 250, 90, 210, 160, "azul", 15000, "2358GDS", 20000, 2, 1200, 120, "Gasolina"));
        listaVehiculos.add(new Moto("BMW", "GS650", 2007, false, 180, 70, 200, 160, "negra", 11000, "4586DFT", 0, 2, 650, 50, "Gasolina"));
        listaVehiculos.add(new Moto("BMW", "F800GS", 2010, false, 180, 70, 200, 160, "verde oscuro", 10000, "6233GHB", 0, 2, 800, 84, "Gasolina"));

    }
}
