package UD4;

/**
 *
 * @author Pablo Fernández Rodríguez
 * @version 2.0
 */
public class Moto {

    private String modelo;
    private int numeroRuedas;
    private int cilindrada;
    private int velocidadMaxima;
    private int peso;
    private String color;
    private int precio;
    private int stock;//Cantidad de motos de las que se disponen

    /**
     *
     */
    public Moto() {
    }

    /**
     *
     * @param modelo
     * @param color
     * @param stock
     */
    public Moto(String modelo, String color, int stock) {
        this.modelo = modelo;
        this.color = color;
        this.stock = stock;
    }

    /**
     *
     * @param modelo
     * @param numeroRuedas
     * @param cilindrada
     * @param velocidadMaxima
     * @param peso
     * @param color
     * @param precio
     * @param stock
     */
    public Moto(String modelo, int numeroRuedas, int cilindrada, int velocidadMaxima, int peso, String color, int precio, int stock) {
        this.modelo = modelo;
        this.numeroRuedas = numeroRuedas;
        this.cilindrada = cilindrada;
        this.velocidadMaxima = velocidadMaxima;
        this.peso = peso;
        this.color = color;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the numeroRuedas
     */
    public int getNumeroRuedas() {
        return numeroRuedas;
    }

    /**
     * @param numeroRuedas the numeroRuedas to set
     */
    public void setNumeroRuedas(int numeroRuedas) {
        this.numeroRuedas = numeroRuedas;
    }

    /**
     * @return the cilindrada
     */
    public int getCilindrada() {
        return cilindrada;
    }

    /**
     * @param cilindrada the cilindrada to set
     */
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    /**
     * @return the velocidadMaxima
     */
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    /**
     * @param velocidadMaxima the velocidadMaxima to set
     */
    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    /**
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     *
     * @param cantidad
     * @throws Exception
     * Este método se utiliza para añadir motos al total del stock
     */
    public void comprar(int cantidad) throws Exception {
        if (cantidad < 0) {
            throw new Exception("No se puede comprar un nº negativo de motos");
        }
        setStock(getStock() + cantidad);
    }
}
