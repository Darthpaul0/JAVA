/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Pablo
 */
public class HolaMundo implements Serializable{

    public static void main(String[] args) {
       ArrayList<String> miArrayList = new ArrayList<>();
       
        miArrayList.add("A");
        miArrayList.add("B");
        miArrayList.add("C");
        miArrayList.add("D");
        
        Collections.shuffle(miArrayList);
        
        System.out.println(miArrayList);
        
        System.out.println((int) (Math.random() * 52));
    }

}
