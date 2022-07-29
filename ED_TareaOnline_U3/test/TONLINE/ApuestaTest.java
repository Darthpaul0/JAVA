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
public class ApuestaTest {

    /**
     * Test of cobrar_apuesta method, of class Apuesta.
     * @throws java.lang.Exception
     */
    @Test
    public void testCobrar_apuesta() throws Exception {
        System.out.println("cobrar_apuesta");
        Partido p = new Partido();
        Apuesta instance = new Apuesta();
        instance.cobrar_apuesta(p);
    }
}
