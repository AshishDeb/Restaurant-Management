/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ashish
 */
public class EditProductsList extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form EditProductsList
     */
    public EditProductsList() {
        initComponents();
        setTitle("Edit Product List");
        setLocationRelativeTo(null);
        AddType.addActionListener(this);
        AddButton.addActionListener(this);
        UpdateButton.addActionListener(this);
        DeleteButton.addActionListener(this);
        CancelButton.addActionListener(this);

    }
    public void showUpdateMessage(){
        JOptionPane.showMessageDialog(null, "Product updated successfully!");
    }
    public void showDeleteMessage(){
        JOptionPane.showMessageDialog(null, "Product deleted successfully!");
    }
    public void showInsertMessage(){
        JOptionPane.showMessageDialog(null, "Product inserted successfully!");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == CancelButton) {
            this.dispose();
        }
        if (e.getSource() == AddButton) {
            String prod_id = AddSerial.getText();
            String prod_name = AddProduct.getText();
            String prod_quantity = AddProductQuantity.getText();
            String prod_price = AddProductPrice.getText();
            int prod_avail = Integer.parseInt(prod_quantity);

            if (AddType.getSelectedItem().equals("Breakfast")) {
                try {
                    DataBase db = new DataBase();
                    db.InsertIntoBrekfast(prod_id, prod_name, prod_avail, prod_price, prod_quantity);
                } catch (SQLException ex) {
                    Logger.getLogger(EditProductsList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (AddType.getSelectedItem().equals("Lunch")) {
                try {
                    DataBase db = new DataBase();
                    db.InsertIntoLunch(prod_id, prod_name, prod_avail, prod_price, prod_quantity);
                } catch (SQLException ex) {
                    Logger.getLogger(EditProductsList.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (AddType.getSelectedItem().equals("Dinner")) {
                try {
                    DataBase db = new DataBase();
                    db.InsertIntoDinner(prod_id, prod_name, prod_avail, prod_price, prod_quantity);
                } catch (SQLException ex) {
                    Logger.getLogger(EditProductsList.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (AddType.getSelectedItem().equals("Drinks")) {
                try {
                    DataBase db = new DataBase();
                    db.InsertIntoDrinks(prod_id, prod_name, prod_avail, prod_price, prod_quantity);
                } catch (SQLException ex) {
                    Logger.getLogger(EditProductsList.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
        if (e.getSource() == UpdateButton) {
            String prod_id = AddSerial.getText();
            String prod_name = AddProduct.getText();
            String prod_quantity = AddProductQuantity.getText();
            String prod_price = AddProductPrice.getText();
            int prod_avail = Integer.parseInt(prod_quantity);

            if (AddType.getSelectedItem().equals("Breakfast")) {
                try {
                    DataBase db = new DataBase();
                    db.UpdateBreakfast(prod_id, prod_name, prod_avail, prod_price, prod_quantity);
                } catch (SQLException ex) {
                    System.out.println("ERROR: "+ex);
                }
            }
            if (AddType.getSelectedItem().equals("Lunch")) {
                try {
                    DataBase db = new DataBase();
                    db.UpdateLunch(prod_id, prod_name, prod_avail, prod_price, prod_quantity);
                } catch (SQLException ex) {
                    System.out.println("ERROR: "+ex);
                }
            }
            if (AddType.getSelectedItem().equals("Dinner")) {
                try {
                    DataBase db = new DataBase();
                    db.UpdateDinner(prod_id, prod_name, prod_avail, prod_price, prod_quantity);
                } catch (SQLException ex) {
                    System.out.println("ERROR: "+ex);
                }
            }
            if (AddType.getSelectedItem().equals("Drinks")) {
                try {
                    DataBase db = new DataBase();
                    db.UpdateDrinks(prod_id, prod_name, prod_avail, prod_price, prod_quantity);
                } catch (SQLException ex) {
                    System.out.println("ERROR: "+ex);
                }
            }
        }
        if(e.getSource()== DeleteButton){
            String prod_id = AddSerial.getText();
            if (AddType.getSelectedItem().equals("Breakfast")) {
                try {
                    DataBase db = new DataBase();
                    db.DeleteBreakFast(prod_id);
                } catch (SQLException ex) {
                    System.out.println("ERROR: "+ex);
                }
            }
            if (AddType.getSelectedItem().equals("Lunch")) {
                try {
                    DataBase db = new DataBase();
                    db.DeleteLunch(prod_id);
                } catch (SQLException ex) {
                    System.out.println("ERROR: "+ex);
                }
            }
            if (AddType.getSelectedItem().equals("Dinner")) {
                try {
                    DataBase db = new DataBase();
                    db.DeleteDinner(prod_id);
                } catch (SQLException ex) {
                    System.out.println("ERROR: "+ex);
                }
            }
            if (AddType.getSelectedItem().equals("Drinks")) {
                try {
                    DataBase db = new DataBase();
                    db.DeleteDrinks(prod_id);
                } catch (SQLException ex) {
                    System.out.println("ERROR: "+ex);
                }
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        AddProductName = new javax.swing.JPanel();
        AddButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        AddSerial = new javax.swing.JTextField();
        AddProduct = new javax.swing.JTextField();
        AddProductQuantity = new javax.swing.JTextField();
        AddProductPrice = new javax.swing.JTextField();
        AddType = new javax.swing.JComboBox();
        MessegeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        AddProductName.setBackground(new java.awt.Color(255, 255, 0));

        AddButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        AddButton.setText("Add Products");
        AddButton.setBorder(null);
        AddButton.setPreferredSize(new java.awt.Dimension(120, 30));
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        UpdateButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        UpdateButton.setText("Update Products");
        UpdateButton.setBorder(null);
        UpdateButton.setPreferredSize(new java.awt.Dimension(120, 30));

        DeleteButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        DeleteButton.setText("Delete Products");
        DeleteButton.setBorder(null);
        DeleteButton.setPreferredSize(new java.awt.Dimension(120, 30));

        CancelButton.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        CancelButton.setText("Cancel");
        CancelButton.setBorder(null);

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Product Name");

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Serial No");

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Quantity");

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Price");

        AddSerial.setFont(new java.awt.Font("Consolas", 2, 14)); // NOI18N

        AddProduct.setFont(new java.awt.Font("Consolas", 2, 14)); // NOI18N

        AddProductQuantity.setFont(new java.awt.Font("Consolas", 2, 14)); // NOI18N

        AddProductPrice.setFont(new java.awt.Font("Consolas", 2, 14)); // NOI18N

        AddType.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        AddType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Type", "Breakfast", "Lunch", "Dinner", "Drinks", "Other" }));
        AddType.setBorder(null);

        MessegeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MessegeLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout AddProductNameLayout = new javax.swing.GroupLayout(AddProductName);
        AddProductName.setLayout(AddProductNameLayout);
        AddProductNameLayout.setHorizontalGroup(
            AddProductNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddProductNameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddProductNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddProductNameLayout.createSequentialGroup()
                        .addGroup(AddProductNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddSerial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddProductNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AddProduct)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddProductNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddProductQuantity))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddProductNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AddProductPrice)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddProductNameLayout.createSequentialGroup()
                        .addGroup(AddProductNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddProductNameLayout.createSequentialGroup()
                                .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(MessegeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addComponent(AddType, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddProductNameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        AddProductNameLayout.setVerticalGroup(
            AddProductNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddProductNameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddProductNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddProductNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddSerial, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AddProductNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(MessegeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddProductName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddProductName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddButtonActionPerformed

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
            java.util.logging.Logger.getLogger(EditProductsList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditProductsList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditProductsList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditProductsList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditProductsList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JTextField AddProduct;
    private javax.swing.JPanel AddProductName;
    private javax.swing.JTextField AddProductPrice;
    private javax.swing.JTextField AddProductQuantity;
    private javax.swing.JTextField AddSerial;
    private javax.swing.JComboBox AddType;
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JLabel MessegeLabel;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
