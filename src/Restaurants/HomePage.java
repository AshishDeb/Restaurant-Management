/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurants;
import static Restaurants.DataBase.DATABASE_URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Ashish
 */
public class HomePage extends javax.swing.JFrame implements ActionListener {

    static final String DATABASE_URL = "jdbc:mysql://localhost/restaurantmanagement";
    static final String DATABASE_USER = "root";
    static final String DATABASE_PASS = "";
    Connection connection = null; // manages connection
    Statement statement = null; // query statement
    ResultSet resultSet = null;
    String date, time;

    public HomePage() {
        initComponents();
        setTitle("Shop Management System! Version: 1.0");
        getConnection();
        getDateTime();
        setShopNamePlace();
        //saveToDB();
        CalculatorMenu.addActionListener(this);
        ConverterMenu.addActionListener(this);
        ChangeName.addActionListener(this);
        LogInButton.addActionListener(this);
        jButton1.addActionListener(this);
        QuitMenu.addActionListener(this);
        AboutUsMenu.addActionListener(this);
        HelpMenu.addActionListener(this);
        GameMenu.addActionListener(this);
        
    }
    
    public void setShopNamePlace(){
        try {
            String sql = "select ShopName, ShopPlace from name_place";
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                String shop_name = resultSet.getString("ShopName");
                String place = resultSet.getString("ShopPlace");
                ShopNameLabel.setText(shop_name);
                ShopPlaceLabel.setText(place);
            }
            
            
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex);
        }
        
    }
    public void getDateTime() {
        Calendar cal = new GregorianCalendar();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        Date.setText("Date:  " + day + "/" + (month + 1) + "/" + year + " ");
        //date = Date.getText();
        Thread clock = new Thread() {
            public void run() {
                for (;;) {
                    Calendar cal = new GregorianCalendar();
                    int hour = cal.get(Calendar.HOUR);
                    int minute = cal.get(Calendar.MINUTE);
                    int second = cal.get(Calendar.SECOND);
                    int AmPm = cal.get(Calendar.AM_PM);
                    if (AmPm == 0) {
                        Time.setText("Time: " + hour + ":" + minute + ":" + second + " AM");
                        //time = Time.getText();
                    } else {
                        Time.setText("Time: " + hour + ":" + minute + ":" + second + " PM");
                        //time = Time.getText();
                    }
                    try {
                        sleep(1000);
                    } catch (Exception ex) {
                        System.out.println("Calender ERROR :" + ex);
                    }
                }
            }
        };
        clock.start();
    }
    private void getConnection() {

        try {

            connection = (Connection) DriverManager.getConnection(DATABASE_URL,
                    DATABASE_USER, DATABASE_PASS);
            statement = (Statement) connection.createStatement();
            System.out.println("Connected");
        } catch (SQLException Ex) {
            System.out.println(Ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == LogInButton) {
            System.out.println("Login Button paise..");
            try {
                String userName = UserNameField.getText();
                String sql = "select *from login where username = '" + userName + "' and password = '" + PasswordField.getText() + "'";
                resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                     //type = "null";
                    String username = resultSet.getString("username");
                    String type = resultSet.getString("Type");
                    System.out.println("Type=" + type);
                    System.out.println("GoodJob!");
                    if (type.equals("Admin")||type.equals("Owner")) {
                        //saveTodb(userName);
                        System.out.println("What the heck!!!");
                        String id =  resultSet.getString("id");
                        this.dispose();
                        ManagingPage ob = new ManagingPage();
                        ob.WhoSignedIn(username, id);
                        ob.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry Boss! You don't have the right to access Database!");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Log In Details!");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR!");
            }
        }

        if (e.getSource() == jButton1) {
            try {
                String URL = "https://www.facebook.com/ashish.deb.77";
                java.awt.Desktop.getDesktop().browse(java.net.URI.create(URL));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }

        if (e.getSource() == CalculatorMenu) {
            Calculator ob = new Calculator();
            ob.setVisible(true);
        }
        if (e.getSource() == ConverterMenu) {
            Converter ob = new Converter();
            ob.setVisible(true);
        }
        if (e.getSource() == GameMenu) {
            Game ob = new Game();
            ob.setVisible(true);
        }
        
        if (e.getSource() == AboutUsMenu) {
            AboutUs ob = new AboutUs();
            ob.setVisible(true);
        }
        if (e.getSource() == HelpMenu) {
            Instruction ob = new Instruction();
            ob.setVisible(true);
        }
        if (e.getSource() == ChangeName) {
            ChangeNamePlace ob = new ChangeNamePlace();
            ob.setVisible(true);
        }

        if (e.getSource() == QuitMenu) {
            int answer = JOptionPane.showConfirmDialog(null, "Do you  really want to quit?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.NO_OPTION) {
                this.setVisible(true);
            } else {
                System.exit(0);

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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        UserNameField = new javax.swing.JTextField();
        LogInButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ShopPlaceLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        ShopNameLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Date = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        NamePlaceMenu = new javax.swing.JMenu();
        AboutUsMenu = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        CalculatorMenu = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        ConverterMenu = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        ChangeName = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        HelpMenu = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        GameMenu = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        QuitMenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 0, 102), new java.awt.Color(0, 0, 153), null, null));

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Sign In");

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel3.setText("Password  :");

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel4.setText("User Name :");

        PasswordField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        UserNameField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        LogInButton.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        LogInButton.setForeground(new java.awt.Color(102, 0, 102));
        LogInButton.setText("Go");
        LogInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("_____________________________________________");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LogInButton, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(UserNameField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(82, 82, 82)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addComponent(LogInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Restaurants/left_icon.jpg"))); // NOI18N

        ShopPlaceLabel.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        ShopPlaceLabel.setForeground(new java.awt.Color(0, 0, 204));
        ShopPlaceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ShopPlaceLabel.setText("VIP Road, SheikhGhat, Sylhet");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 102));
        jButton1.setText("https://www.facebook.com/ashish.deb.77");

        jLabel8.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Instructed By- Tazbeea Tazakka Oushneek, Devoloped By- NEUB_BackBencher's");

        ShopNameLabel.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        ShopNameLabel.setForeground(new java.awt.Color(0, 0, 204));
        ShopNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ShopNameLabel.setText("VIP Road, SheikhGhat, Sylhet");

        jPanel3.setBackground(new java.awt.Color(0, 0, 153));

        Date.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        Date.setForeground(new java.awt.Color(255, 255, 0));
        Date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Time.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        Time.setForeground(new java.awt.Color(255, 255, 0));
        Time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Date, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(Time, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Time, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ShopPlaceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ShopNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ShopNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ShopPlaceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        NamePlaceMenu.setText("Option");

        AboutUsMenu.setText("About Us");
        NamePlaceMenu.add(AboutUsMenu);
        NamePlaceMenu.add(jSeparator3);

        CalculatorMenu.setText("Calculator");
        NamePlaceMenu.add(CalculatorMenu);
        NamePlaceMenu.add(jSeparator7);

        ConverterMenu.setText("Converter");
        NamePlaceMenu.add(ConverterMenu);
        NamePlaceMenu.add(jSeparator4);

        ChangeName.setText("Change Shop Name");
        NamePlaceMenu.add(ChangeName);
        NamePlaceMenu.add(jSeparator8);

        HelpMenu.setText("Help");
        HelpMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpMenuActionPerformed(evt);
            }
        });
        NamePlaceMenu.add(HelpMenu);
        NamePlaceMenu.add(jSeparator11);

        GameMenu.setText("Play Game");
        NamePlaceMenu.add(GameMenu);
        NamePlaceMenu.add(jSeparator2);

        QuitMenu.setText("Quit");
        NamePlaceMenu.add(QuitMenu);
        NamePlaceMenu.add(jSeparator1);

        jMenuBar1.add(NamePlaceMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInButtonActionPerformed
//        System.out.println("Login Button paise..");
//            try {
//                String sql = "select *from login where username = '"+UserNameField.getText()+"' and password = '"+PasswordField.getText()+"'";
//                resultSet = statement.executeQuery(sql);
//                if(resultSet.next()){
//                    System.out.println("GoodJob!");
//                    this.dispose();
//                    ManagingPage ob = new ManagingPage();
//                    ob.setVisible(true);
//                }
//                else{
//                    JOptionPane.showMessageDialog(null, "Invalid Log In Details!");
//                }
//            } catch (SQLException ex) {
//               JOptionPane.showMessageDialog(null, "ERROR!");
//            }
    }//GEN-LAST:event_LogInButtonActionPerformed

    private void HelpMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HelpMenuActionPerformed

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutUsMenu;
    private javax.swing.JMenuItem CalculatorMenu;
    private javax.swing.JMenuItem ChangeName;
    private javax.swing.JMenuItem ConverterMenu;
    private javax.swing.JLabel Date;
    private javax.swing.JMenuItem GameMenu;
    private javax.swing.JMenuItem HelpMenu;
    private javax.swing.JButton LogInButton;
    private javax.swing.JMenu NamePlaceMenu;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JMenuItem QuitMenu;
    private javax.swing.JLabel ShopNameLabel;
    private javax.swing.JLabel ShopPlaceLabel;
    private javax.swing.JLabel Time;
    private javax.swing.JTextField UserNameField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    // End of variables declaration//GEN-END:variables

}
