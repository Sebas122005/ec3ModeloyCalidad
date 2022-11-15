
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Coneccion {
    
     public static Connection conectar() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/ec3_ModeloyCalidad", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conecccion : "+e.getMessage());
        }
         System.out.println("Coneccion :" +con.toString());
        return con;
    }
}
