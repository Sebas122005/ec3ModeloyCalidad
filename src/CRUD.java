
import Clases.Coneccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author _ADMINISTRADOR_
 */
public class CRUD extends javax.swing.JFrame {

    Coneccion cone = new Coneccion();
    Connection con = cone.conectar();

    public CRUD() {
        initComponents();
        this.setLocationRelativeTo(null);
        listar();

    }

    public Boolean setear() {

        try {
            jtxtbusqueda.setText("");
            jtxtdescripcion.setText("");
            jtxtmarca.setText("");
            jtxtstock.setText("");
            jtxtvencimiento.setText("");
            return true;
        } catch (Exception e) {
            System.out.println("Error en limpiar campos");
            return false;
        }
    }

    public Integer guardardatos(String marca, Integer indexCate, String desc, Integer stock, Integer estado, String fecha_v) {

        try {
            String SQL = "insert into productos(marca,categoria,descripcion,stock,estado,fecha_v)values(?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setString(1, marca);

            pst.setString(2, jcbxcategoria.getItemAt(indexCate));

            pst.setString(3, desc);

            pst.setInt(4, stock);

            pst.setInt(5, estado);

            pst.setString(6, fecha_v);

            pst.execute();

            JOptionPane.showMessageDialog(null, "exitaso");

            setear();
            return 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No registró :" + e.getMessage());
            return 0;
        }
    }

    public Integer listar() {
        String[] titulos = {"Id", "Marca", "Categoria", "Descripción", "Stock", "F. Vencimiento"};
        String[] registros = new String[7];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        String SQL = "select * from productos where estado=1";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("marca");
                registros[2] = rs.getString("categoria");
                registros[3] = rs.getString("descripcion");
                registros[4] = rs.getString("stock");
                registros[5] = rs.getString("fecha_v");

                modelo.addRow(registros);
            }

            jtableproductos.setModel(modelo);
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    public Integer actualizardatos(String marca, Integer indexCate, String desc, Integer stock, Integer estado, String fecha_v, String id) {

        try {

            String SQL = "update productos set marca=?,categoria=?,descripcion=?,stock=?,estado=?,fecha_v=? where id=?";

            PreparedStatement pst = con.prepareStatement(SQL);
            //pst.setInt(1, jtxtid.getText());

            pst.setString(1, marca);

            pst.setString(2, jcbxcategoria.getItemAt(indexCate));

            pst.setString(3, desc);

            pst.setInt(4, stock);

            pst.setInt(5, estado);

            pst.setString(6, fecha_v);

            pst.setString(7, id);

            pst.execute();

            JOptionPane.showMessageDialog(null, "registro editado");

            setear();
            return 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no editado " + e.getMessage());
            return 0;
        }

    }

    public Integer eliminar(String id) {

        try {
            String SQL = "update productos set estado=0 where id=" + id;

            Statement st = con.createStatement();

            int n = st.executeUpdate(SQL);
            if (n >= 0) {
                JOptionPane.showMessageDialog(null, "registro eliminado");
                listar();
            }
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al eliminar " + e.getMessage());
            return 0;
        }
    }

    public Integer filtrardatos(String valor) {
        String[] titulos = {"Id", "Marca", "Categoria", "Descripción", "Stock", "F. Vencimiento"};
        String[] registros = new String[7];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        String SQL = "select * from productos where estado=1 and id like '%" + valor + "%'";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("marca");
                registros[2] = rs.getString("categoria");
                registros[3] = rs.getString("descripcion");
                registros[4] = rs.getString("stock");
                registros[5] = rs.getString("fecha_v");

                modelo.addRow(registros);
            }

            jtableproductos.setModel(modelo);
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtableproductos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtmarca = new javax.swing.JTextField();
        jtxtdescripcion = new javax.swing.JTextField();
        jtxtstock = new javax.swing.JTextField();
        jtxtvencimiento = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jtxtbusqueda = new javax.swing.JTextField();
        jcbxcategoria = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jcbxestado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtableproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtableproductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableproductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtableproductos);

        jLabel2.setText("Marca:");

        jLabel3.setText("Categoria:");

        jLabel4.setText("Descripción:");

        jLabel5.setText("Stock:");

        jLabel6.setText("F. Vencimiento:");

        jButton1.setText("Nuevo");

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Actualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 51, 51));
        jButton5.setText("Salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel7.setText("Busqueda :");

        jtxtbusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtbusquedaKeyReleased(evt);
            }
        });

        jcbxcategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bebida", "Galleta", "Fideo" }));

        jLabel8.setText("Estado:");

        jcbxestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inhabilitado", "Habilitado" }));
        jcbxestado.setSelectedIndex(1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtmarca)
                                    .addComponent(jtxtdescripcion)
                                    .addComponent(jcbxcategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtxtstock, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtvencimiento)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(211, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jcbxestado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtxtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtxtmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jcbxcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtxtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtxtstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtxtvencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jcbxestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(7, 7, 7)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(0, 31, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        login form = new login();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        guardardatos(jtxtmarca.getText(), jcbxcategoria.getSelectedIndex(), jtxtdescripcion.getText(), Integer.parseInt(jtxtstock.getText()), jcbxestado.getSelectedIndex(), jtxtvencimiento.getText());
        listar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtableproductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableproductosMouseClicked
        // TODO add your handling code here:
        int filaSeleccionada = jtableproductos.rowAtPoint(evt.getPoint());

        jtxtmarca.setText(jtableproductos.getValueAt(filaSeleccionada, 1).toString());
        jcbxcategoria.setSelectedItem(jtableproductos.getValueAt(filaSeleccionada, 2));
        jtxtdescripcion.setText(jtableproductos.getValueAt(filaSeleccionada, 3).toString());
        jtxtstock.setText(jtableproductos.getValueAt(filaSeleccionada, 4).toString());
        jtxtvencimiento.setText(jtableproductos.getValueAt(filaSeleccionada, 5).toString());
    }//GEN-LAST:event_jtableproductosMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        int filaSeleccionada = jtableproductos.getSelectedRow();
        String dao = (String) jtableproductos.getValueAt(filaSeleccionada, 0);

        actualizardatos(jtxtmarca.getText(), jcbxcategoria.getSelectedIndex(), jtxtdescripcion.getText(), Integer.parseInt(jtxtstock.getText()), jcbxestado.getSelectedIndex(), jtxtvencimiento.getText(), dao);
        setear();
        listar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        eliminar((String) jtableproductos.getValueAt(jtableproductos.getSelectedRow(), 0));
        listar();
        setear();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jtxtbusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbusquedaKeyReleased
        // TODO add your handling code here:
        filtrardatos(jtxtbusqueda.getText());
    }//GEN-LAST:event_jtxtbusquedaKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbxcategoria;
    private javax.swing.JComboBox<String> jcbxestado;
    private javax.swing.JTable jtableproductos;
    private javax.swing.JTextField jtxtbusqueda;
    private javax.swing.JTextField jtxtdescripcion;
    private javax.swing.JTextField jtxtmarca;
    private javax.swing.JTextField jtxtstock;
    private javax.swing.JTextField jtxtvencimiento;
    // End of variables declaration//GEN-END:variables
}
