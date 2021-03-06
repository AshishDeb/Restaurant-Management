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

/**
 *
 * @author Ashish
 */
public class EditingPage extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form EditingPage
     */
    public EditingPage() {
        initComponents();
        setTitle("Add User");
        setLocationRelativeTo(null);
        SetUsername1.setEditable(false);
        SetPasword.setEditable(false);
        ConfirmPassword.setEditable(false);
        SaveButton.addActionListener(this);
        Save.addActionListener(this);
        CancelButton.addActionListener(this);
        CheckYes.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SaveButton) {
            String user = SetUsername1.getText();
            System.out.println(user);
            String password1 = SetPasword.getText();
            String password2 = ConfirmPassword.getText();
            if (password1.equals(password2)) {
                try {
                    DataBase db = new DataBase();
                    db.SaveToDB(user, password1);
                    //db.closeDBConnection();
                    MessegeLabel.setText("");
                } catch (SQLException ex) {
                    Logger.getLogger(UserAdd.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                MessegeLabel.setText("*Sorry! Password didn't match!");
            }

        }
        if (e.getSource() == Save) {
            String SetUser = EmployeeName.getText();
            String SetPermAd = SetPermAddrress.getText();
            String SetPreAd = SetPreAddrress.getText();
            //String SID = SetID.getText();
            String SPhone = SetPhone.getText();
            String SVID = SetVID.getText();
            String Type = (String) TypeCombo.getSelectedItem();
            try {
                EmployeeName.setText("");
                SetPermAddrress.setText("");
                SetPreAddrress.setText("");
                SetPhone.setText("");
                SetVID.setText("");
                DataBase db = new DataBase();
                db.AddEmployees(SetUser, SetPermAd, SetPreAd, SPhone, SVID, Type);
            } catch (SQLException ex) {
                Logger.getLogger(UserAdd.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == CancelButton) {
            this.dispose();
        }
        if (e.getSource() == CheckYes) {
            SetUsername1.setEditable(true);
            SetPasword.setEditable(true);
            ConfirmPassword.setEditable(true);
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
        jPanel2 = new javax.swing.JPanel();
        EmployeeName = new javax.swing.JTextField();
        Save = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        AdminUserName2 = new javax.swing.JLabel();
        SetPermAddrress = new javax.swing.JTextField();
        AdminUserName3 = new javax.swing.JLabel();
        AdminUserName4 = new javax.swing.JLabel();
        AdminUserName5 = new javax.swing.JLabel();
        SetPreAddrress = new javax.swing.JTextField();
        AdminUserName7 = new javax.swing.JLabel();
        TypeCombo = new javax.swing.JComboBox();
        AdminUserName8 = new javax.swing.JLabel();
        SetPhone = new javax.swing.JTextField();
        AdminUserName9 = new javax.swing.JLabel();
        SetVID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        AdminUserName1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        AdminUserName = new javax.swing.JLabel();
        SetUsername1 = new javax.swing.JTextField();
        SetPasword = new javax.swing.JPasswordField();
        AdminPassword = new javax.swing.JLabel();
        AdminPassword1 = new javax.swing.JLabel();
        ConfirmPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        CheckYes = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        MessegeLabel = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        EmployeeName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        EmployeeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeNameActionPerformed(evt);
            }
        });

        Save.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        Save.setForeground(new java.awt.Color(0, 0, 153));
        Save.setText("Save");

        CancelButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        CancelButton.setForeground(new java.awt.Color(0, 0, 153));
        CancelButton.setText("Cancel");

        AdminUserName2.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        AdminUserName2.setText("Employee Name");

        SetPermAddrress.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SetPermAddrress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetPermAddrressActionPerformed(evt);
            }
        });

        AdminUserName3.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        AdminUserName3.setText("Addrress");

        AdminUserName4.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        AdminUserName4.setText("Present");

        AdminUserName5.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        AdminUserName5.setText("Permanent");

        SetPreAddrress.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SetPreAddrress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetPreAddrressActionPerformed(evt);
            }
        });

        AdminUserName7.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        AdminUserName7.setText("Employee Type");

        TypeCombo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TypeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose Type", "Admin", "Full Time Employee", "Part Time Employe", "Senior Waiter", "Waiter" }));

        AdminUserName8.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        AdminUserName8.setText("Phone No");

        SetPhone.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SetPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetPhoneActionPerformed(evt);
            }
        });

        AdminUserName9.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        AdminUserName9.setText("ID No");

        SetVID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SetVID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetVIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(AdminUserName2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EmployeeName))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AdminUserName5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AdminUserName4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SetPermAddrress)
                            .addComponent(SetPreAddrress)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(AdminUserName3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(AdminUserName7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                        .addComponent(TypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(AdminUserName8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(SetPhone))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(AdminUserName9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(SetVID)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdminUserName2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AdminUserName3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SetPermAddrress, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdminUserName4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdminUserName5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SetPreAddrress, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdminUserName8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SetPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdminUserName9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SetVID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdminUserName7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Restaurants/loginIcon.jpg"))); // NOI18N

        AdminUserName1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        AdminUserName1.setForeground(new java.awt.Color(0, 0, 153));
        AdminUserName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AdminUserName1.setText("ADD User");

        jPanel3.setBackground(new java.awt.Color(255, 255, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        AdminUserName.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        AdminUserName.setText("Set Username     :");

        SetUsername1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SetUsername1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetUsername1ActionPerformed(evt);
            }
        });

        SetPasword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SetPasword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetPaswordActionPerformed(evt);
            }
        });

        AdminPassword.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        AdminPassword.setText("Set Password     :");

        AdminPassword1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        AdminPassword1.setText("Confirm Password :");

        ConfirmPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmPasswordActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Want To Set Him As An Admin Who Can Access Your Database?");

        CheckYes.setText("Yes");
        CheckYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckYesActionPerformed(evt);
            }
        });

        jCheckBox2.setText("No");

        MessegeLabel.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        MessegeLabel.setForeground(new java.awt.Color(204, 0, 0));

        SaveButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SaveButton.setText("Save");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(CheckYes)
                        .addGap(110, 110, 110)
                        .addComponent(jCheckBox2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(AdminPassword1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(AdminPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(AdminUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SetUsername1)
                                    .addComponent(ConfirmPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(SetPasword, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(MessegeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(SaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(39, 39, 39))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckYes)
                    .addComponent(jCheckBox2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdminUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SetUsername1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AdminPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SetPasword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AdminPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MessegeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SaveButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(AdminUserName1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AdminUserName1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(58, 58, 58)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmployeeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmployeeNameActionPerformed

    private void SetPaswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetPaswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SetPaswordActionPerformed

    private void ConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfirmPasswordActionPerformed

    private void SetUsername1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetUsername1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SetUsername1ActionPerformed

    private void SetPermAddrressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetPermAddrressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SetPermAddrressActionPerformed

    private void SetPreAddrressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetPreAddrressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SetPreAddrressActionPerformed

    private void SetPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SetPhoneActionPerformed

    private void CheckYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckYesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckYesActionPerformed

    private void SetVIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetVIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SetVIDActionPerformed

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
            java.util.logging.Logger.getLogger(EditingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditingPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdminPassword;
    private javax.swing.JLabel AdminPassword1;
    private javax.swing.JLabel AdminUserName;
    private javax.swing.JLabel AdminUserName1;
    private javax.swing.JLabel AdminUserName2;
    private javax.swing.JLabel AdminUserName3;
    private javax.swing.JLabel AdminUserName4;
    private javax.swing.JLabel AdminUserName5;
    private javax.swing.JLabel AdminUserName7;
    private javax.swing.JLabel AdminUserName8;
    private javax.swing.JLabel AdminUserName9;
    private javax.swing.JButton CancelButton;
    private javax.swing.JCheckBox CheckYes;
    private javax.swing.JPasswordField ConfirmPassword;
    private javax.swing.JTextField EmployeeName;
    private javax.swing.JLabel MessegeLabel;
    private javax.swing.JButton Save;
    private javax.swing.JButton SaveButton;
    private javax.swing.JPasswordField SetPasword;
    private javax.swing.JTextField SetPermAddrress;
    private javax.swing.JTextField SetPhone;
    private javax.swing.JTextField SetPreAddrress;
    private javax.swing.JTextField SetUsername1;
    private javax.swing.JTextField SetVID;
    private javax.swing.JComboBox TypeCombo;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

}
