/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
        boolean res= instance.setear();
        assertTrue(res);
    }

    
    @Test
    public void testGuardardatos() {
        System.out.println("guardardatos");
        CRUD instance = new CRUD();
        String marca="ideal";
        Integer indexCategoria=1;
        String descripcion="leche de marca que no conozco pero existe";
        Integer stock=17;
        Integer estado =1;
        String fecha="2022-11-12";
        
        assertNotEquals("", marca);
        assertNotEquals("", indexCategoria);
        assertNotEquals("", descripcion);
        assertNotEquals("", stock);
        assertNotEquals("", estado);
        assertNotEquals("", fecha);
        assertTrue(stock>=0);
        assertTrue(descripcion.length()>10);
        
        int res =instance.guardardatos(marca,indexCategoria,descripcion,stock,estado,fecha);
        
        assertEquals("Producto registrado exitosamente", 1, res);
        
    }

    
    
    @Test
    public void testListar() {
        System.out.println("listar");
        CRUD instance = new CRUD();
        int res= instance.listar();
        assertEquals("Producto listados exitosamente", 1, res);
        assertTrue(res==1);
    }

    
    @Test
    public void testActualizardatos() {
        System.out.println("actualizardatos");
        CRUD instance = new CRUD();
        String marca="benoti";
        Integer indexCategoria=3;
        String descripcion="fideos marca italiana";
        Integer stock=16;
        Integer estado =0;
        String fecha="2024-01-02";
        String id="3";
        
        assertNotEquals("", marca);
        assertNotEquals("", indexCategoria);
        assertNotEquals("", descripcion);
        assertNotEquals("", stock);
        assertNotEquals("", estado);
        assertNotEquals("", fecha);
        assertNotEquals("", id);
        assertTrue(stock>=0);
        assertTrue(descripcion.length()>10);
                
        int res=instance.actualizardatos(marca,indexCategoria,descripcion,stock,estado,fecha,id);
        assertEquals("Producto actualizado exitosamente", 1, res);
        
    }

    /**
     * Test of eliminar method, of class CRUD.
     */
    @Test
   // @Rollback(false)
    public void testEliminar() {
        System.out.println("eliminar");
        CRUD instance = new CRUD();
        String ide = "4";
        assertNotEquals("", ide);
        int res = instance.eliminar(ide);
        assertEquals("Producto eliminado exitosamente", 1, res);
        
    }

    /**
     * Test of filtrardatos method, of class CRUD.
     */
    @Test
    public void testFiltrardatos() {
        System.out.println("filtrardatos");
        
        CRUD instance = new CRUD();
        String valor = "fideo";
        assertNotEquals("", valor);
        
        int res = instance.filtrardatos(valor);
        
        assertEquals("Producto encontrado exitosamente", 1, res);
        assertFalse(res!=1);
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
