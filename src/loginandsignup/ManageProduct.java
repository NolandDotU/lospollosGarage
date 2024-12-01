/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package loginandsignup;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author mizaeltangkas
 */
public class ManageProduct extends javax.swing.JFrame {
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    private DefaultTableModel model;

    /** Creates new form ManageProduct */
    public ManageProduct() {
        initComponents();
        // Setup koneksi database dan model untuk tabel
        loadProductData();
        loadCategories(); 
    }
    
    // Method untuk memuat data produk ke dalam tabel
    private void loadProductData() {
        try {
            String query = "SELECT * FROM product";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            
            model = (DefaultTableModel) tblProduct.getModel();
            model.setRowCount(0);  // Clear table before loading new data
            
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("product_PK"),
                    rs.getString("name"),
                    rs.getInt("quantity"),
                    rs.getString("description"),
                    rs.getInt("category_FK"),
                    rs.getString("category_name")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error closing resources: " + ex.getMessage());
            }
        }

    }
    
    private void loadCategories() {
        try {
            String query = "SELECT category_name FROM category";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            ComboBoxCategory.removeAllItems();  // Clear previous items

            while (rs.next()) {
                ComboBoxCategory.addItem(rs.getString("category_name"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading categories: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error closing resources: " + ex.getMessage());
            }
        }
    }
    
    
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblQuatity = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lblDescription = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        lblCategory = new javax.swing.JLabel();
        ComboBoxCategory = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        jLabel1.setText("ManageProduct");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 27, -1, -1));

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Quantity", "Description", "Category ID", "Category Name"
            }
        ));
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduct);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        lblName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblName.setText("Nama");
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, -1, -1));

        txtName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 123, 289, -1));

        lblQuatity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblQuatity.setText("Quantity");
        getContentPane().add(lblQuatity, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 162, -1, -1));

        txtQuantity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        getContentPane().add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 195, 289, -1));

        lblPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPrice.setText("Price");
        getContentPane().add(lblPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 234, -1, -1));

        txtPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 267, 289, -1));

        lblDescription.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDescription.setText("Description");
        getContentPane().add(lblDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 306, -1, -1));

        txtDescription.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 339, 289, -1));

        lblCategory.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCategory.setText("Category");
        getContentPane().add(lblCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 378, -1, -1));

        ComboBoxCategory.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ComboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(ComboBoxCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 411, 289, -1));

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, 60, -1));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 450, -1, -1));

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(676, 450, -1, -1));

        btnClose.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 450, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/images/All_page_Background.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentShown

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String name = txtName.getText();
        String quantityText = txtQuantity.getText();
        String priceText = txtPrice.getText();
        String description = txtDescription.getText();
        String category = ComboBoxCategory.getSelectedItem().toString();

        if (name.isEmpty() || quantityText.isEmpty() || priceText.isEmpty() || description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        try {
            int quantity = Integer.parseInt(quantityText);
            double price = Double.parseDouble(priceText);

            String query = "INSERT INTO product (name, quantity, price, description, category_FK) VALUES (?, ?, ?, ?, ?)";
            pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setInt(2, quantity);
            pst.setDouble(3, price);
            pst.setString(4, description);
            pst.setString(5, category);  // Assuming category is passed as a string for now

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Product added successfully.");
            loadProductData();  // Reload data after save
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Quantity and price must be valid numbers.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage());
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblProduct.getSelectedRow();
        if (selectedRow >= 0) {
            int productId = (int) tblProduct.getValueAt(selectedRow, 0);
            String name = txtName.getText();
            String quantityText = txtQuantity.getText();
            String priceText = txtPrice.getText();
            String description = txtDescription.getText();
            String category = ComboBoxCategory.getSelectedItem().toString();

            if (name.isEmpty() || quantityText.isEmpty() || priceText.isEmpty() || description.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
                return;
            }

            try {
                int quantity = Integer.parseInt(quantityText);
                double price = Double.parseDouble(priceText);

                String query = "UPDATE product SET name = ?, quantity = ?, price = ?, description = ?, category_FK = ? WHERE product_PK = ?";
                pst = con.prepareStatement(query);
                pst.setString(1, name);
                pst.setInt(2, quantity);
                pst.setDouble(3, price);
                pst.setString(4, description);
                pst.setString(5, category);
                pst.setInt(6, productId);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Product updated successfully.");
                loadProductData();  // Reload data after update
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Quantity and price must be valid numbers.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error updating data: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a product to update.");
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();

    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtName.setText("");
        txtQuantity.setText("");
        txtPrice.setText("");
        txtDescription.setText("");
        ComboBoxCategory.setSelectedIndex(0);  
        
    }//GEN-LAST:event_btnResetActionPerformed

    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblProduct.getSelectedRow();
        txtName.setText(tblProduct.getValueAt(selectedRow, 1).toString());
        txtQuantity.setText(tblProduct.getValueAt(selectedRow, 2).toString());
        txtPrice.setText(tblProduct.getValueAt(selectedRow, 3).toString());
        txtDescription.setText(tblProduct.getValueAt(selectedRow, 4).toString());
        
        // Assuming Category is set from ComboBox with proper matching values
        ComboBoxCategory.setSelectedItem(tblProduct.getValueAt(selectedRow, 5).toString());

    }//GEN-LAST:event_tblProductMouseClicked

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
            java.util.logging.Logger.getLogger(ManageProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxCategory;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblQuatity;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables

}