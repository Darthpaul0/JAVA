/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo
 */
public class MetodosGenericos2 {

    public static void main(String[] args) {
        List<Integer> miLista = new ArrayList<>();
        System.out.println(max(miLista, 0, 8));
    }

    public static <T extends Comparable<T>> T max(List<T> list, int begin, int end) {
        T mayor = null;
        for (int i = begin; i < end; i++) {
            
        }
        for (T elemento : list) {
            if (mayor.compareTo(elemento) == 1) {
                mayor = elemento;
            }
        }
        return mayor;
    }
}
