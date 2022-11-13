/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class CRUDTest {
    
    public CRUDTest() {
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
     * Test of setear method, of class CRUD.
     */
    @Test
    public void testSetear() {
        System.out.println("setear");
        CRUD instance = new CRUD();
        instance.setear();
       
    }

    /**
     * Test of guardardatos method, of class CRUD.
     */
    @Test
    public void testGuardardatos() {
        System.out.println("guardardatos");
        CRUD instance = new CRUD();
        instance.guardardatos();
       
    }

    /**
     * Test of listar method, of class CRUD.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        CRUD instance = new CRUD();
        instance.listar();
        
    }

    /**
     * Test of actualizardatos method, of class CRUD.
     */
    @Test
    public void testActualizardatos() {
        System.out.println("actualizardatos");
        CRUD instance = new CRUD();
        instance.actualizardatos();
       
    }

    /**
     * Test of eliminar method, of class CRUD.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        CRUD instance = new CRUD();
        instance.eliminar();
      
    }

    /**
     * Test of filtrardatos method, of class CRUD.
     */
    @Test
    public void testFiltrardatos() {
        System.out.println("filtrardatos");
        String valor = "";
        CRUD instance = new CRUD();
        instance.filtrardatos(valor);
      
    }

    /**
     * Test of main method, of class CRUD.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CRUD.main(args);
      
    }
    
}
