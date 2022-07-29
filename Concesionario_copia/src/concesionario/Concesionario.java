/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Concesionario implements Serializable {

    //ATRIBUTOS PRIVADOS
    private ArrayList<Vehículo> listaVehiculos;
    private ArrayList<Persona> listaPersonas;

    private double ingresos;
    private double gastos;

    static final long serialVersionUID = 1L;

    //CONSTRUCTOR
    public Concesionario(ArrayList<Vehículo> listaVehiculos, ArrayList<Persona> listaPersonas, double ingresos, double gastos) {
        this.listaVehiculos = listaVehiculos;
        this.listaPersonas = listaPersonas;
        this.ingresos = ingresos;
        this.gastos = gastos;
    }

    public Concesionario() {
        this.listaVehiculos = new ArrayList<>();
        this.listaPersonas = new ArrayList<>();
        this.ingresos = 0;
        this.gastos = 0;
    }

    //GETTERs
    public ArrayList<Vehículo> getListaVehiculos() {
        return listaVehiculos;
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public double getIngresos() {
        return ingresos;
    }

    public double getGastos() {
        return gastos;
    }

    //MÉTODOS
    public Vendedor crearVendedor() {
        return new Vendedor(
                leerSalario("Introduzca su salario"),
                leerEntero("Años de experiencia"),
                leerString("Introduzca sus estudios"),
                leerVacaciones("Días de vacaciones"),
                leerString("¿Nombre?"),
                leerString("¿Apellidos?"),
                leerDNI(),
                leerEdad("¿Edad?"));
    }

    public void contratarVendedor() {
        //Creamos al posible vendedor
        Vendedor nuevo = crearVendedor();

        //Comprobamos que no contratamos a la misma persona dos veces
        if (!listaPersonas.contains(nuevo)) {
            //Añadimos al nuevo vendedor a la plantilla
            listaPersonas.add(nuevo);
            System.out.println("-->>Vendedor añadido<<--");
            System.out.println(nuevo.toString());
        } else {
            System.out.println("Lo sentimos, esa persona ya está registrada.");
        }
    }

    public void despedirVendedor() {

        //Pedimos el DNI de la persona que queremos dar de baja
        String despedido = leerDNI();
        boolean existeDNI = false;
        //Si ese DNI existe en listaPersonal
        for (Persona nuevoParado : listaPersonas) {
            if (nuevoParado.getDNI().equals(despedido)) {
                existeDNI = true;
                System.out.println("¿Está seguro de que quiere despedir a " + nuevoParado.getNombre() + " " + nuevoParado.getApellidos() + "?");
                String respuesta = leerString("Introduzca S para confirmar.");
                if ("S".equals(respuesta)) {
                    listaPersonas.remove(despedido);
                    System.out.println("¡Despedido!");
                } else {
                    System.out.println("No se ha podido realizar el despido.");
                }
            }
        }
        //Si el DNI no se corresponde a ningún empleado
        if (!existeDNI) {
            System.out.println("No tenemos ese DNI registrado.");
        }
    }

    public void buscarVehiculo() {

        //Antes de nada, nos aseguramos que el concesionario tiene vehículos en venta
        if (listaVehiculos.isEmpty()) {
            System.out.println("Actualmente no hay vehículos en venta.");
        } else {
            //Pedimos la marca del vehículo que queremos buscar
            String marca = leerString("Introduzca la marca del vehículo");
            System.out.println("---------------------------------------");

            //Recorremos el array de vehículos 
            System.out.println("Coches y motos disponibles de esa marca:");
            for (Vehículo maquina : listaVehiculos) {
                if (maquina instanceof Coche) {
                    Coche auto = (Coche) maquina;
                    if (auto.getMarca().equals(marca)) {
                        System.out.println(auto.getMarca() + " " + auto.getModelo() + " " + auto.getPrecio() + "€");
                    }
                }

                if (maquina instanceof Moto) {
                    Moto miMoto = (Moto) maquina;
                    if (miMoto.getMarca().equals(marca)) {
                        System.out.println(miMoto.getMarca() + " " + miMoto.getModelo() + " " + miMoto.getPrecio() + "€");
                    }
                }
            }
        }
    }

    public void venderVehiculo() {

        //Antes de nada, nos aseguramos que el concesionario tiene vehículos en venta
        if (listaVehiculos.isEmpty()) {
            System.out.println("Actualmente no hay vehículos en venta.");
        } else {

            //Primero leemos la matrícula del vehículo que está en venta
            String matricula = leerMatricula();

            //Ahora comprobamos que esa matrícula coincide con algún vehículo en stock
            System.out.println("---------------------------------------");

            //Se necesita crear una lista alternativa para las ventas como solución al error java.util.ConcurrentModificationException
            ArrayList<Vehículo> vendidos = new ArrayList<>();
            boolean encontrado = false;
            //Recorremos el array de vehículos 
            for (Vehículo maquina : listaVehiculos) {
                //Si es coche
                if (maquina instanceof Coche) {
                    Coche auto = (Coche) maquina;
                    if (auto.getMatricula().equals(matricula)) {
                        encontrado = true;
                        System.out.println("Vendido un " + auto.getMarca() + " " + auto.getModelo() + " por " + auto.getPrecio() + "€");
                        //Ponemos el estado de la venta a true
                        auto.vendido = true;
                        //Añadimos el precio a la variable ingresos
                        ingresos += auto.getPrecio();
                        //Añadimos el vehículo vendido a la lista de vendidos
                        vendidos.add(auto);
                        //Finalmente, eliminamos las ventas de la lista de vehículos
                        listaVehiculos.remove(vendidos);
                    }
                }

                //Si es moto
                if (maquina instanceof Moto) {
                    Moto miMoto = (Moto) maquina;
                    if (miMoto.getMatricula().equals(matricula)) {
                        encontrado = true;
                        System.out.println("Vendida una " + miMoto.getMarca() + " " + miMoto.getModelo() + " tipo " + miMoto.tipoMoto() + " por " + miMoto.getPrecio() + "€");
                        //Ponemos el estado de la venta a true
                        miMoto.vendido = true;
                        //Añadimos el precio a la variable ingresos
                        ingresos += miMoto.getPrecio();
                        //Añadimos el vehículo vendido a la lista de vendidos
                        vendidos.add(miMoto);
                        //Finalmente, eliminamos las ventas de la lista de vehículos
                        listaVehiculos.remove(vendidos);
                    }
                }
            }
            //Si no encotramos el coche que queríamos vender
            if (!encontrado) {
                System.out.println("No hemos encontrado ese vehículo.");
            }
        }

    }

    public void añadirVehiculo() {

        //Creamos el vehículo
        Vehículo nuevo = crearVehiculo();

        //Comprobamos que el vehículo no está ya en stock antes de añadirlo a la lista
        if (listaVehiculos.contains(nuevo)) {
            System.out.println("Lo sentimos, ese vehículo ya está en stock.");
        } else {
            listaVehiculos.add(nuevo);
            System.out.println("Vehículo añadido con éxito.");
        }
    }

    public void verBalance() {

        //Hacemos aquí el cálculo de los gastos correspondientes a salarios
        for (Persona sueldo : listaPersonas) {
            gastos += ((Vendedor) sueldo).getSueldo();
        }
        double beneficios = ingresos - gastos;
        System.out.println("Ingresos del concesionario: " + ingresos + "€");
        System.out.println("Gastos del concesionario: " + gastos + "€");
        System.out.println("Balance final: " + beneficios + " € de beneficio.");
        if (beneficios > 0) {
            System.out.println("El negocio va bien.");
        } else {
            System.out.println("El negocio se hunde, hay que vender más.");
        }
    }

    public Vehículo crearVehiculo() {

        //Primero necesitamos saber qué clase de vehículo vamos a crear
        System.out.println("¿Qué vehículo vamos a crear?");
        String tipoVehiculo;
        do {
            tipoVehiculo = leerString("Escriba C para dar de alta un coche o M si se trata de una moto.");
        } while (!"C".equals(tipoVehiculo) && !"M".equals(tipoVehiculo));
        //Ahora, según lo que se haya elegido, se creará el tipo de persona especificado
        //Condición para crear socio
        if ("C".equals(tipoVehiculo)) {
            return crearCoche();
        }

        //Condición para crear empleado
        if ("M".equals(tipoVehiculo)) {
            return crearMoto();
        }

        return null;
    }

    public Coche crearCoche() {
        return new Coche(
                leerString("Marca"),
                leerString("Modelo"),
                leerEntero("Año"),
                leerEntero("Capacidad de carga"),
                leerEntero("Número de plazas"),
                false,
                leerEntero("Peso"),
                leerEntero("Ancho"),
                leerEntero("Largo"),
                leerEntero("Alto"),
                leerString("Color"),
                leerEntero("Precio"),
                leerMatricula(),
                leerEntero("Kilometraje"),
                4, //Ruedas
                leerEntero("Cilindrada"),
                leerEntero("Potencia"),
                leerString("Combustible"));
    }

    public Moto crearMoto() {
        return new Moto(
                leerString("Marca"),
                leerString("Modelo"),
                leerEntero("Año"),
                false,
                leerEntero("Peso"),
                leerEntero("Ancho"),
                leerEntero("Largo"),
                leerEntero("Alto"),
                leerString("Color"),
                leerEntero("Precio"),
                leerMatricula(),
                leerEntero("Kilometraje"),
                2, //Ruedas
                leerEntero("Cilindrada"),
                leerEntero("Potencia"),
                leerString("Combustible"));
    }

    public String leerDNI() {
        // formato00000000X (no válidas letras minúsculas ni la Ñ, I, O y U)
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce tu DNI.");
        String expresion = sc.nextLine();
        while (!expresion.matches("\\d{8}[A-HJ-NP-TV-Z]")) {
            System.out.println("El DNI introducido no es correcto, prueba de nuevo.");
            expresion = sc.nextLine();
        }
        return expresion;
    }

    public String leerString(String mensaje) {
        System.out.print(mensaje + ": ");
        Scanner sc = new Scanner(System.in);
        String texto;
        texto = sc.nextLine();
        return texto;
    }

    public int leerEntero(String mensaje) {
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

    public double leerSalario(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        double num;
        do {
            System.out.print(mensaje + ": ");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextDouble()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número entero, vuelva a intentarlo:");
            }
            num = teclado.nextDouble();
            if (num < Vendedor.SALARIO_MINIMO) {
                System.out.println("El salario debe ser mayor o igual al salario mínimo actual.");
            }
        } while (num < Vendedor.SALARIO_MINIMO);
        return num;
    }

    public int leerVacaciones(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        int num;
        do {
            System.out.print(mensaje + ": ");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número entero, vuelva a intentarlo:");
            }
            num = teclado.nextInt();
            if (num < Vendedor.VACACIONES_MINIMAS) {
                System.out.println("Dale al menos 30 días de vacaciones.");
            }
        } while (num < Vendedor.VACACIONES_MINIMAS);
        return num;
    }

    public int leerEdad(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        int num;
        final int MIN = 18;
        final int MAX = 99;
        do {
            System.out.print(mensaje + ": ");
            //Antes de leer hay que comprobar que el tipo de valor introducido se corresponde con el solicitado
            //Si no lo hacemos y leemos directamente un valor no válido se lanzaría la excepción InputMismatchException
            while (!teclado.hasNextInt()) {
                teclado.next(); //si lo que se ha introducido no es un número lo sacamos del buffer
                System.out.println("El valor introducido no es un número entero, vuelva a intentarlo:");
            }
            num = teclado.nextInt();
            if (num < MIN || num > MAX) {
                System.out.println("No contratamos a personas que no están ya en edad de conducir.");
            }
        } while (num <= MIN || num > MAX);
        return num;
    }

    public String leerMatricula() {
        // formato0000XXX 
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la matrícula del vehículo.");
        String expresion = sc.nextLine();
        while (!expresion.matches("([0-9]{4})([A-Z]{3})")) {
            System.out.println("La matrícula introducida no es correcta, prueba de nuevo.");
            expresion = sc.nextLine();
        }
        return expresion;

    }

}
