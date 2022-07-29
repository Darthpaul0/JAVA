/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacioncuentabancaria;

/**
 * En esta clase definimos los métodos y atributos que serán posteriormente usados en la aplicación principal
 *
 * @author Pablo
 * @version 1.0
 */
public class CuentaBancaria {

    /**
     * Declaración de atributos públicos y privados
     */
    public static final int MAXTITULAR = 100;
    public static final int MINTITULAR = 10;
    private double saldo;
    private String titular;
    private String entidad;
    private String oficina;
    private String DC;
    private String numCuenta;

    // MÉTODOS PÚBLICOS
    /**
     * Constructor con los parámetros de la cuenta corriente de forma individual.
     * Si alguno de los parámetros y/o el CCC no es válido se lanzará la excepción IllegalArgumentException
     *
     * @param titular
     * @param entidad
     * @param oficina
     * @param DC
     * @param numCuenta
     */
    public CuentaBancaria(String titular, String entidad, String oficina, String DC, String numCuenta) {
        setTitular(titular);
        this.saldo = 0;
        this.entidad = entidad;
        this.oficina = oficina;
        this.DC = DC;
        this.numCuenta = numCuenta;
        // excepción para comprobar el CCC
        if (!comprobarCCC(this.getCCC())) {
            throw new IllegalArgumentException("El CCC generado no es correcto. Revisa los datos introducidos.");
        }
    }

    /**
     * Constructor con los parámetros titular y CCC sin descomponer.
     * Este constructor descompondrá el CCC y llamará al constructor básico mostrado anteriormente.
     *
     * @param titular
     * @param CCC
     */
    public CuentaBancaria(String titular, String CCC) {
        this(titular, CCC.substring(0, 4), CCC.substring(4, 8), CCC.substring(8, 10), CCC.substring(10, 20));
    }

    /*public CuentaBancaria() {

    }*/

    /**
     * Método ingresar.
     * Ingresará el dinero correspondiente al saldo de la cuenta. 
     * Este valor debe ser positivo, en caso contrario se lanzará la excepción IllegalArgumentException.
     *
     * @param cantidad
     */
    public void ingresar(double cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("No puedes ingresar una cantidad negativa de dinero.");
        }
        this.saldo += cantidad;
    }

    /**
     * Método retirar.
     * Se restará la cantidad indicada del saldo de la cuenta. 
     * Este valor debe ser positivo y nunca superior al saldo de la cuenta. 
     * De no ser así se lanzará la excepción IllegalArgumentException.
     *
     * @param cantidad
     */
    public void retirar(double cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("No puedes retirar una cantidad negativa de dinero.");
        }
        if (cantidad > this.saldo) {
            throw new IllegalArgumentException("No tienes saldo suficiente.");
        }
        this.saldo -= cantidad;
    }

    /**
     * Método comprobarCCC Lo utilizamos para comprobar la validez de un CCC.
     *
     * @param CCC
     * @return valido devolverá true o false indicando si el CCC es válido o no.
     */
    public static boolean comprobarCCC(String CCC) {
        // variable para devolver validez del CCC
        boolean valido = true;

        // antes de nada, comprobamos que el CCC tiene 20 dígitos
        if (CCC.length() != 20) {
            valido = false;
        } else {

            // Obtenemos variables locales string entidad, oficina, número de cuenta y dígitos de control
            String entidad = CCC.substring(0, 4);
            String oficina = CCC.substring(4, 8);
            String numCuenta = CCC.substring(10, 20);
            String DC = CCC.substring(8, 10);
            String dcCalculado = obtenerDigitosControl(entidad, oficina, numCuenta);

            // devuelve comparación
            valido = DC.equals(dcCalculado);
        }
        return valido;
    }

    /**
     * Método obtenerDigitosControl Calcular los dígitos de control de un CCC. El método devuelve los dos dígitos de control dado los códigos de entidad, oficina y número de cuenta.
     *
     * @param entidad
     * @param oficina
     * @param numCuenta
     * @return devuelve los dígitos de control
     */
    public static String obtenerDigitosControl(String entidad, String oficina, String numCuenta) {
        int primero;
        int segundo;
        // Obtención de dígitos de control
        // --Calculamos el primer dígito de control--
        // 1. Debemos multiplicar los dígitos por unos pesos en función de la posición que ocupan. Los pesos son
        // los siguiente: 1, 2, 4, 8, 5, 10, 9, 7, 3, 6 y sumar los productos obtenidos.
        // multiplicación de los dígitos de entidad y oficina 
        primero = Integer.parseInt((entidad.substring(0, 1))) * 4;
        primero += Integer.parseInt((entidad.substring(1, 2))) * 8;
        primero += Integer.parseInt((entidad.substring(2, 3))) * 5;
        primero += Integer.parseInt((entidad.substring(3, 4))) * 10;
        primero += Integer.parseInt((oficina.substring(0, 1))) * 9;
        primero += Integer.parseInt((oficina.substring(1, 2))) * 7;
        primero += Integer.parseInt((oficina.substring(2, 3))) * 3;
        primero += Integer.parseInt((oficina.substring(3, 4))) * 6;

        // dividimos la suma entre 11 y nos quedamos con el resto
        primero = primero % 11;

        // a 11 le restamos el resto anterior y ese será el dígito de control
        primero = 11 - primero;

        // comprobamos si suma tiene un dígito o dos
        if (primero == 11) {
            primero = 0;
        }
        if (primero == 10) {
            primero = 1;
        }

        // Calculamos el segundo dígito de control, siguiendo el mismo proceso que en el primer dígito, pero esta vez con diez números
        segundo = Integer.parseInt((numCuenta.substring(0, 1))) * 1;
        segundo += Integer.parseInt((numCuenta.substring(1, 2))) * 2;
        segundo += Integer.parseInt((numCuenta.substring(2, 3))) * 4;
        segundo += Integer.parseInt((numCuenta.substring(3, 4))) * 8;
        segundo += Integer.parseInt((numCuenta.substring(4, 5))) * 5;
        segundo += Integer.parseInt((numCuenta.substring(5, 6))) * 10;
        segundo += Integer.parseInt((numCuenta.substring(6, 7))) * 9;
        segundo += Integer.parseInt((numCuenta.substring(7, 8))) * 7;
        segundo += Integer.parseInt((numCuenta.substring(8, 9))) * 3;
        segundo += Integer.parseInt((numCuenta.substring(9, 10))) * 6;

        // dividimos la suma entre 11 y nos quedamos con el resto
        segundo = segundo % 11;

        // a 11 le restamos el resto anterior y ese será el dígito de control
        segundo = 11 - segundo;

        return String.valueOf(primero) + String.valueOf(segundo);
    }

    // Método String toString(). Devolverá una cadena con los datos del titular, CCC y saldo de la cuenta.
    public String toString() {
        String info = "";
        info = "Titular: " + this.titular + "\nCCC: " + this.getCCC() + "\nSaldo: " + this.saldo + "€"; // 
        return info;
    }

    // Creamos los métodos get y set para los atributos titular, entidad, saldo, oficina y numCuenta
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public void setDC(String DC) {
        this.DC = DC;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getDC() {
        return DC;
    }

    public String getTitular() {
        return titular;
    }

    /**
     * asignamos el titular y lo validamos
     * @param titular
     */
    public void setTitular(String titular) {
        if (!comprobarTitular(titular)) {
            throw new IllegalArgumentException("El nombre de titular es erróneo.");
        }
        this.titular = titular;

    }
    
    private boolean comprobarTitular (String titular){
        return (titular.length() >= MINTITULAR && titular.length() <= MAXTITULAR);
    }

    public String getEntidad() {
        return entidad;
    }

    public String getOficina() {
        return oficina;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    /**
     * generamos método getCCC para obtener CCC
     * @return devuelve el CCC 
     */
    public String getCCC() {
        return this.getEntidad() + this.getOficina() + this.getDC() + this.getNumCuenta();
    }

}
