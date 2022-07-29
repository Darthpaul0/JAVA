/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Operaciones {

    private int a;
    private int b;

    //CONSTRUCTOR
    public Operaciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    //getters y setters
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    //Métodos
    public int suma() {
        return a + b;
    }

    public int resta() {
        return a - b;
    }

    public int multiplica() {
        return a * b;
    }

    public double divide() {
        return (double) a / b;
    }

}
