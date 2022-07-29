/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_tarea2;

import javax.swing.JOptionPane;

/**
 *
 * @author Pablo
 */
/* Aplicación que convierte un número en decimal a su correspondiente en binario */
public class ED_Tarea2 {

    public static void main(String[] args) {
        String texto = JOptionPane.showInputDialog("Introduce un numero");
        int numero = Integer.parseInt(texto);
        String binario = decimalBinario(numero);
        System.out.println("El numero " + numero + " en binario es " + binario);
    }

    public static String decimalBinario(int numero) {
        String binario = "";
        String digito;
        for (int i = numero; i >= 0; i /= 2) {
            if (i % 2 == 1) {
                digito = "1";
            } else {
                digito = "0";
            }
            binario = digito + binario;
        }
        return binario;
    }
}
