/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuadradosmagicos;

import java.util.Arrays;

/**
 *
 * @author Pablo
 */
public class CuadradoMagico {

    //ATRIBUTOS PRIVADOS
    private int datos[][];

    //CONSTRUCTOR
    public CuadradoMagico() {
        this.datos = new int[3][3];
    }

    public CuadradoMagico(int N) {
        if (N < 3) {
            throw new IllegalArgumentException("El mínimo de filas y columnas es 3");
        } else {
            this.datos = new int[N][N];
        }
    }

    public CuadradoMagico(CuadradoMagico cm) {

        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[0].length; j++) {
                this.datos[i][j] = cm.datos[i][j];
            }
        }
    }

    //Métodos
    public int getNumero(int fila, int columna) {
        return this.datos[fila][columna];
    }

    public boolean ponerNumero(int fila, int columna, int numero) {
        boolean existe = false;
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[0].length; j++) {
                if (numero != datos[i][j]) {
                    this.datos[i][j] = this.getNumero(fila, columna);
                } else if (numero > Math.pow(datos.length, 2) || numero < 1) {
                    throw new IllegalArgumentException("El número debe estar entre 1 y " + Math.pow(datos.length, 2));
                } else {
                    existe = true;
                    System.out.println("Ese número ya está");
                }
            }
        }
        return existe;
    }

    public void quitarNumero(int fila, int columna) {
        datos[fila][columna] = 0;
    }

    public boolean comprobar() {
        boolean correcto = false;
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[0].length; j++) {
                if (datos[i][j] != 0) {

                }
            }
        }
        return correcto;
    }

    public int getConstanteMagica() {
        int constante = 0;

        return constante;

    }

    @Override
    public String toString() {
        String cuadrado = "--------------------------------\n";
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[0].length; j++) {
                cuadrado = cuadrado + this.datos[i][j] + "  | ";
            }
            cuadrado = cuadrado + "\n";
        }
        cuadrado = cuadrado.concat("--------------------------------");
        return cuadrado;
    }

    public boolean equals(CuadradoMagico cm) {
        if (this == cm) {
            return true;
        }
        if (cm == null) {
            return false;
        }
        if (getClass() != cm.getClass()) {
            return false;
        }
        final CuadradoMagico other = (CuadradoMagico) cm;
        if (!Arrays.deepEquals(this.datos, other.datos)) {
            return false;
        }
        return true;
    }

}
