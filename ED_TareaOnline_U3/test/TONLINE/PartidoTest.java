/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TONLINE;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pablo
 */
public class PartidoTest {


    /**
     * Test of introducir_resultado method, of class Partido.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testIntroducir_resultado() throws Exception {
        System.out.println("introducir_resultado");
        int g_local = 0;
        int g_visitante = 0;
        Partido instance = new Partido();
        instance.introducir_resultado(g_local, g_visitante);
    }

}
