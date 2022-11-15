/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */


import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Clases.Coneccion;

/**
 *
 * @author Sebas
 */
public class ConeccionTest {
    
    public ConeccionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of conectar method, of class Coneccion.
     */
    @Test
    public void testConectar() {
        System.out.println("conectar");
        Connection expResult = null;
        Connection result = Coneccion.conectar();
        assertNotEquals(expResult, result);
        assertTrue(result.toString().contains("com.mysql.jdbc.JDBC4Connection@"));
    }
    
}
