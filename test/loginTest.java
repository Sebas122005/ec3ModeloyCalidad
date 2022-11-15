/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import com.mysql.jdbc.AssertionFailedException;
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
public class loginTest {

    public loginTest() {
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
     * Test of validarUsuario method, of class login.
     */
    @Test
    public void testValidarUsuario() {
        System.out.println("validarUsuario");
        login instance = new login();
        String user = "sebas1";
        String pass = "contra1";
        int res = instance.validarUsuario(user, pass);
        assertNotNull(user);
        assertNotNull(pass);
        assertNotEquals("",user);
        assertNotEquals("",pass);
        assertEquals("Cuenta valida", 1, res);

    }

    /**
     * Test of main method, of class login.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        login.main(args);

    }
}
