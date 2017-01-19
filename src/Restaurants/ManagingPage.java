/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurants;

import static Restaurants.LogHistory.DATABASE_URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Ashish
 */
public class ManagingPage extends javax.swing.JFrame implements ActionListener {

    static final String DATABASE_URL = "jdbc:mysql://localhost/restaurantmanagement";
    static final String DATABASE_USER = "root";
    static final String DATABASE_PASS = "";
    Connection connection = null; // manages connection
    Statement statement = null; // query statement
    ResultSet resultSet = null;

    double firstNum, secondNum, result, initPrice = 0.0, dInPrice = 0.0, DrinksPrice, ProdPrice, SubTotal, Total, rem1, rem2;
    String operation, whoSigned, time, time1, date, R_Date, ProdName[], ProdQuant[];

    public ManagingPage() {
        initComponents();
        setTitle("Managing Page");
        setDateAndTime();
        SignInTime();
        getConnection();
        setProductsList();
        addingActionListener();
        RemoveProdAction();

        ProdQuantityField.setText("0");
        MealCostLabel.setText("0");
        DrinksCostLabel.setText("0");
        SubTotalLabel.setText("0");
        VatField.setText("0");
        HomeDeliveryCostLabel.setText("0");
        DiscountField.setText("0");
        TotalLabel.setText("0");
        ProdPriceField.setEditable(false);
        ProdNameField.setEditable(false);

    }

    private void addingActionListener() {
        AddUser.addActionListener(this);
        SaveReceipt.addActionListener(this);
        ClearReceipt.addActionListener(this);
        CalculatorMenu.addActionListener(this);
        ConverterMenu.addActionListener(this);
        TotalButton.addActionListener(this);
        ReceiptButton.addActionListener(this);
        ResetButton.addActionListener(this);
        BackButton.addActionListener(this);
        QuitMenuItem.addActionListener(this);
        SignOutMenuItem.addActionListener(this);
        EmployeeDetails.addActionListener(this);
        EditProducts.addActionListener(this);
        CheckDelivery.addActionListener(this);
        LogHistoryMenu.addActionListener(this);
        AddProdButon.addActionListener(this);
        DoneAddButton.addActionListener(this);
        RemoveProdButton.addActionListener(this);
        RefreshProdList.addActionListener(this);
        Database.addActionListener(this);
        ChangePassword.addActionListener(this);
    }

    private void getConnection() {
        try {

            connection = (Connection) DriverManager.getConnection(DATABASE_URL,
                    DATABASE_USER, DATABASE_PASS);
            statement = (Statement) connection.createStatement();
            System.out.println("Connect Hoise...");
        } catch (SQLException e) {
            System.err.println("Connection Error");
        }
    }

    private void getProdNamePrice() {

        String prod_id = Prod_IDField.getText();
        double quantity = 0;
        
        //String prod_type = (String) ProdTypeCombo.getSelectedItem();
        if (ProdTypeCombo.getSelectedItem().equals("Breakfast")) {
            quantity = Double.parseDouble(ProdQuantityField.getText());
            try {
                System.out.println("hehehe");
                String sql = "select * from breakfast where Prod_id='" + prod_id + "'";
                resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    String name = resultSet.getString("Prod_name");
                    String price = resultSet.getString("Prod_price");
                    double fPrice = Double.parseDouble(price);
                    double TPrice = quantity * fPrice;
                    ProdNameField.setText(name);
                    ProdPriceField.setText("" + TPrice);
                }
            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex);
                Logger.getLogger(ManagingPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (ProdTypeCombo.getSelectedItem().equals("Lunch")) {
            quantity = Double.parseDouble(ProdQuantityField.getText());
            try {
                System.out.println("hehehe");
                String sql = "select * from lunch where LProd_id='" + prod_id + "'";
                resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    String name = resultSet.getString("LProd_name");
                    String price = resultSet.getString("Prod_Price");
                    double fPrice = Double.parseDouble(price);
                    double TPrice = quantity * fPrice;
                    ProdNameField.setText(name);
                    ProdPriceField.setText("" + TPrice);
                }
            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex);
                //Logger.getLogger(ManagingPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (ProdTypeCombo.getSelectedItem().equals("Dinner")) {
            quantity = Double.parseDouble(ProdQuantityField.getText());
            try {
                System.out.println("hehehe");
                String sql = "select * from dinner where DProd_id='" + prod_id + "'";
                resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    String name = resultSet.getString("DProd_name");
                    String price = resultSet.getString("DProd_Price");
                    double fPrice = Double.parseDouble(price);
                    double TPrice = quantity * fPrice;
                    ProdNameField.setText(name);
                    ProdPriceField.setText("" + TPrice);
                }
            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex);
                //Logger.getLogger(ManagingPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (ProdTypeCombo.getSelectedItem().equals("Drinks")) {
            quantity = Double.parseDouble(ProdQuantityField.getText());
            try {
                System.out.println("hehehe");
                String sql = "select * from drinks where Drinks_id = '" + prod_id + "'";
                resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    String name = resultSet.getString("Drinks_name");
                    String price = resultSet.getString("Drinks_Price");

                    double fPrice = Double.parseDouble(price);
                    double TPrice = quantity * fPrice;
                    ProdNameField.setText(name);
                    ProdPriceField.setText("" + TPrice);
                    System.out.println("hahaha");
                }
            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex);
                Logger.getLogger(ManagingPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        int Quantity = (int) quantity;
//        int quant[] = null;
//        for(int i=1; i<20; i++){
//            quant[i]+=Quantity;
//            System.out.println("quantity= "+quant[i]);
//        }

    }

    private void setProductsList() {
        try {
            String sql = "select * from breakfast";
            String sql1 = "select * from lunch";
            String sql2 = "select * from dinner";
            String sql3 = "select * from drinks";
//            String sql4 = "select * from others";
            System.out.println("logindetails table e dhukse...");
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery(sql);
            System.out.println("Execute o hoise....");
            BreakfastTable.setModel(DbUtils.resultSetToTableModel(resultSet));
            statement = connection.prepareStatement(sql1);
            resultSet = statement.executeQuery(sql1);
            LunchTable.setModel(DbUtils.resultSetToTableModel(resultSet));
            statement = connection.prepareStatement(sql2);
            resultSet = statement.executeQuery(sql2);
            DinnerTable.setModel(DbUtils.resultSetToTableModel(resultSet));
            statement = connection.prepareStatement(sql3);
            resultSet = statement.executeQuery(sql3);
            DrinksTable.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
            //Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    private void SignInTime() {
        Calendar cal = new GregorianCalendar();
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        int AmPm = cal.get(Calendar.AM_PM);
        if (AmPm == 0) {
            SignOutLabel.setText(hour + ":" + minute + ":" + second + " AM");
        } else {
            SignOutLabel.setText(hour + ":" + minute + ":" + second + " PM");
        }
        time = SignOutLabel.getText();
    }

    private void SignOutTime() {
        Calendar cal = new GregorianCalendar();
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        int AmPm = cal.get(Calendar.AM_PM);
        if (AmPm == 0) {
            SignOutLabel.setText(hour + ":" + minute + ":" + second + " AM");
            time1 = SignOutLabel.getText();
        } else {
            SignOutLabel.setText(hour + ":" + minute + ":" + second + " PM");
            time1 = SignOutLabel.getText();
        }
        time1 = SignOutLabel.getText();

        //Calendar cal = new GregorianCalendar();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        SignOutLabel.setText(time1 + " " + day + "/" + (month + 1) + "/" + year + " ");
        R_Date = SignOutLabel.getText();
        System.out.println(R_Date);

    }

    public void setDateAndTime() {
        Calendar cal = new GregorianCalendar();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        Date.setText(day + "/" + (month + 1) + "/" + year + " ");
        date = Date.getText();
        Thread clock = new Thread() {
            public void run() {
                for (;;) {
                    Calendar cal = new GregorianCalendar();
                    int hour = cal.get(Calendar.HOUR);
                    int minute = cal.get(Calendar.MINUTE);
                    int second = cal.get(Calendar.SECOND);
                    int AmPm = cal.get(Calendar.AM_PM);
                    if (AmPm == 0) {
                        Time.setText(hour + ":" + minute + ":" + second + " AM");
                        //time = Time.getText();
                    } else {
                        Time.setText(hour + ":" + minute + ":" + second + " PM");
                        //time = Time.getText();
                    }

                    try {
                        sleep(1000);
                    } catch (Exception ex) {
                        System.out.println("ERROR : " + ex);
                    }
                }
            }
        };
        clock.start();
    }

    public void WhoSignedIn(String username, String id) {
        SignLabel.setText("Signed in as : " + username);
        whoSigned = username;
        UserNameLabel.setText(""+username);
        UserIDLabel.setText(""+id);
    }

    public void shopName(String name) {
        Shop_Name.setText(name);

    }

    public void SignOut() {
        int answer = JOptionPane.showConfirmDialog(null, "Do you  really want to Sign Out?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.NO_OPTION) {
            this.setVisible(true);
        } else {
            try {
                SignOutTime();
                DataBase db = new DataBase();
                db.LogInDetails(whoSigned, time, time1, date);
                this.dispose();
                HomePage ob = new HomePage();
                ob.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ManagingPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void RemoveProdAction() {
        try {
            dInPrice = 0.0;
            initPrice = 0.0;
            MealCostLabel.setText("0");
            DrinksCostLabel.setText("0");
            ProdPriceField.setText("0");
            SubTotalLabel.setText("0");
            ProdNameField.setText("");
            ProdPriceField.setText("0");
            Prod_IDField.setText("");
            ProdQuantityField.setText("0");
            String sql = "update breakfast set temp = '0'";
            String sql1 = "update lunch set temp = '0'";
            String sql2 = "update dinner set temp = '0'";
            String sql3 = "update drinks set temp = '0'";
            statement.executeUpdate(sql);
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);
            statement.executeUpdate(sql3);
        } catch (SQLException ex) {
            Logger.getLogger(ManagingPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    String a, b, c, d, f, g, h;
    int k = 0;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == AddUser) {
            if (e.getSource() == AddUser) {
                UserAdd ob = new UserAdd();
                ob.setVisible(true);
            }
        }
        if (e.getSource() == CalculatorMenu) {
            Calculator ob = new Calculator();
            ob.setVisible(true);
        }
        if (e.getSource() == ChangePassword) {
            PasswordChange ob = new PasswordChange();
            ob.setVisible(true);
        }

        if (e.getSource() == ConverterMenu) {
            Converter ob = new Converter();
            ob.setVisible(true);
        }
        if (e.getSource() == AddProdButon) {
            getProdNamePrice();

        }

        if (e.getSource() == DoneAddButton) {
            
            String id = Prod_IDField.getText();
            String quant = ProdQuantityField.getText();
            if (ProdTypeCombo.getSelectedItem().equals("Drinks")) {

                try {
                    String sql = "update drinks set temp = temp+'" + quant + "' where Drinks_id = '" + id + "'";
                    System.out.println("Update Drinks temp Check Point 2");
                    statement.executeUpdate(sql);
                    System.out.println("Update Drinks temp Check Point 3");
                } catch (SQLException ex) {
                    System.out.println("ERROR: " + ex);
                }
                DrinksPrice = dInPrice + Double.parseDouble(ProdPriceField.getText());
                DrinksCostLabel.setText(DrinksPrice + "");
                dInPrice = DrinksPrice;
                SubTotal = DrinksPrice + ProdPrice;
                SubTotalLabel.setText(SubTotal + "");
                ProdPriceField.setText("0");
            } else {
                ProdPrice = initPrice + Double.parseDouble(ProdPriceField.getText());
                MealCostLabel.setText(ProdPrice + "");
                initPrice = ProdPrice;
                SubTotal = DrinksPrice + ProdPrice;
                SubTotalLabel.setText(SubTotal + "");
                ProdPriceField.setText("0");
                if (ProdTypeCombo.getSelectedItem().equals("Breakfast")) {
                    try {
                        String sql = "update breakfast set temp = temp+'" + quant + "' where Prod_id = '" + id + "'";
                        System.out.println("Update breakfast temp Check Point 2");
                        statement.executeUpdate(sql);
                        System.out.println("Update breakfast temp Check Point 3");
                    } catch (SQLException ex) {
                        System.out.println("ERROR: " + ex);
                    }
                }
                if (ProdTypeCombo.getSelectedItem().equals("Lunch")) {
                    try {
                        String sql = "update lunch set temp = temp+'" + quant + "' where LProd_id = '" + id + "'";
                        System.out.println("Update Lunch temp Check Point 2");
                        statement.executeUpdate(sql);
                        System.out.println("Update Lunch temp Check Point 3");
                    } catch (SQLException ex) {
                        System.out.println("ERROR: " + ex);
                    }
                }
                if (ProdTypeCombo.getSelectedItem().equals("Dinner")) {
                    try {
                        String sql = "update dinner set temp = temp+'" + quant + "' where DProd_id = '" + id + "'";
                        System.out.println("Update Dinner temp Check Point 2");
                        statement.executeUpdate(sql);
                        System.out.println("Update Dinner temp Check Point 3");
                    } catch (SQLException ex) {
                        System.out.println("ERROR: " + ex);
                    }
                }

            }
            ProdQuantityField.setText("0");
            ProdPriceField.setText("0");

        }

        if (e.getSource() == RemoveProdButton) {
            RemoveProdAction();

        }
        if (e.getSource() == TotalButton) {
            double sTotal = Double.parseDouble(SubTotalLabel.getText());
            double DelCost = Double.parseDouble(HomeDeliveryCostLabel.getText());
            double Discount = Double.parseDouble(DiscountField.getText());
            double vat = Double.parseDouble(VatField.getText());
            double fvat = ((vat / 100) * sTotal);
            double totalCost = (sTotal + DelCost + fvat);
            Discount = (Discount / 100) * totalCost;
            totalCost -= Discount;
            TotalLabel.setText(totalCost + "");
        }
        if (e.getSource() == EmployeeDetails) {
            EmployeeDetails ob = new EmployeeDetails();
            ob.setVisible(true);
        }
        if (e.getSource() == Database) {
            ShopDatabase ob = new ShopDatabase();
            ob.setVisible(true);
        }
        if (e.getSource() == LogHistoryMenu) {
            LogHistory ob = new LogHistory();
            ob.setVisible(true);
        }
        if (e.getSource() == ReceiptButton) {
            a = MealCostLabel.getText();
            b = DrinksCostLabel.getText();
            c = SubTotalLabel.getText();
            d = VatField.getText();
            h = HomeDeliveryCostLabel.getText();
            f = DiscountField.getText();
            g = TotalLabel.getText();
            MealLabel.setText(a + "/=");
            DrinksLabel.setText(b + "/=");
            SubTotalLabel1.setText(c + "/=");
            DeliveryLabel.setText(h + "/=");
            VatLabel1.setText(d + "%");
            DiscountLabel1.setText(f + "%");
            C_TotalLabel.setText(g + "/=");
            HavingDate.setText(date);
            HavingTime.setText(time);
        }
        if (e.getSource() == SaveReceipt) {
//            try {
//                setDateAndTime();
//                HavingDate.setText(date);
//                HavingTime.setText(time);
//                String name, phone, address;
//                name = C_NameField.getText();
//                phone = C_PhoneField.getText();
//                address = C_AddrressField.getText();
//                SignOutTime();
//                
//                DataBase db = new DataBase();
//                db.ReceiptSaveToDB(name, phone, address, R_Date, g);
//                db.UpdateProductsQuantity();
//            } catch (SQLException ex) {
//                Logger.getLogger(ManagingPage.class.getName()).log(Level.SEVERE, null, ex);
//            }
            setDateAndTime();
                HavingDate.setText(date);
                HavingTime.setText(time);
                //String usName = UserIDLabel.getText();
                //String ID = UserIDLabel.getText();
                //System.out.println("ID:-"+id);
                String name, phone, address, ID;                
                ID = UserIDLabel.getText();
                int uid = Integer.parseInt(ID);
                name = C_NameField.getText();
                phone = C_PhoneField.getText();
                address = C_AddrressField.getText();
                SignOutTime();
            try {
            String sql = "INSERT INTO receipt (C_name, C_addrress, C_phone, Having_time, Total_cost, id) VALUES ('" + name + "','" + address + "', '" + phone + "', '" + R_Date + "','" + g + "', "+ uid +");";
            System.out.println("Receipt table e dhukse...");
            statement.executeUpdate(sql);
            DataBase db = new DataBase();
            db.UpdateProductsQuantity();
            JOptionPane.showMessageDialog(null, "Data saved succesfully!");
            System.out.println("Execute o hoise....");
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        }

        }
        if (e.getSource() == ClearReceipt) {
            C_NameField.setText("Customer Name...");

            C_PhoneField.setText("Phone...");
            C_AddrressField.setText("Addrress...");
            MealLabel.setText("/=");
            DrinksLabel.setText("/=");
            SubTotalLabel1.setText("/=");
            DeliveryLabel.setText("/=");
            VatLabel1.setText("%");
            DiscountLabel1.setText("%");
            C_TotalLabel.setText("/=");
            HavingDate.setText("Date");
            HavingTime.setText("Time");
        }
        if (e.getSource() == ResetButton) {
            dInPrice = 0.0;
            initPrice = 0.0;
            MealCostLabel.setText("0");
            DrinksCostLabel.setText("0");
            SubTotalLabel.setText("0");
            VatField.setText("0");
            HomeDeliveryCostLabel.setText("0");
            DiscountField.setText("0");
            TotalLabel.setText("0");
        }
        if (e.getSource() == BackButton) {
            SignOut();
        }
        if (e.getSource() == QuitMenuItem) {
            int answer = JOptionPane.showConfirmDialog(null, "Do you  really want to quit?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.NO_OPTION) {
                this.setVisible(true);
            } else {
                System.exit(0);

            }
        }
        if (e.getSource() == SignOutMenuItem) {
            SignOut();
        }
        if (e.getSource() == EditProducts) {
            EditProductsList ob = new EditProductsList();
            ob.setVisible(true);
        }
        if (e.getSource() == RefreshProdList) {
            setProductsList();
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        BreakfastTable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        LunchTable = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        DinnerTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        DrinksTable = new javax.swing.JTable();
        RefreshProdList = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        ReceiptButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        ConverterButton = new javax.swing.JButton();
        TotalButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        MealCostLabel = new javax.swing.JLabel();
        DrinksCostLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        SubTotalLabel = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        HomeDeliveryCostLabel = new javax.swing.JLabel();
        JLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        TotalLabel = new javax.swing.JLabel();
        CheckDelivery = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        Prod_IDField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        ProdQuantityField = new javax.swing.JTextField();
        AddProdButon = new javax.swing.JButton();
        RemoveProdButton = new javax.swing.JButton();
        ProdNameField = new javax.swing.JTextField();
        ProdPriceField = new javax.swing.JTextField();
        DoneAddButton = new javax.swing.JButton();
        ProdTypeCombo = new javax.swing.JComboBox();
        DiscountField = new javax.swing.JTextField();
        VatField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        SignLabel = new javax.swing.JLabel();
        SignOutLabel = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Shop_Name = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        C_NameField = new javax.swing.JTextField();
        C_PhoneField = new javax.swing.JTextField();
        C_AddrressField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        MealLabel = new javax.swing.JLabel();
        DrinksLabel = new javax.swing.JLabel();
        SubTotalLabel1 = new javax.swing.JLabel();
        DeliveryLabel = new javax.swing.JLabel();
        VatLabel1 = new javax.swing.JLabel();
        DiscountLabel1 = new javax.swing.JLabel();
        C_TotalLabel = new javax.swing.JLabel();
        HavingDate = new javax.swing.JLabel();
        HavingTime = new javax.swing.JLabel();
        SaveReceipt = new javax.swing.JButton();
        SaveReceipt1 = new javax.swing.JButton();
        ClearReceipt = new javax.swing.JButton();
        UserIDLabel = new javax.swing.JLabel();
        UserNameLabel = new javax.swing.JLabel();
        UserIDLabel1 = new javax.swing.JLabel();
        UserIDLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Date = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        CalculatorMenu = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        ChangePassword = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        ConverterMenu = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        Database = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        EmployeeDetails = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        LogHistoryMenu = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        SignOutMenuItem = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        QuitMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        AddUser = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        EditProducts = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel1.setPreferredSize(new java.awt.Dimension(466, 552));

        BreakfastTable.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        BreakfastTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Avail", "Price", "Total Bought"
            }
        ));
        jScrollPane3.setViewportView(BreakfastTable);
        if (BreakfastTable.getColumnModel().getColumnCount() > 0) {
            BreakfastTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            BreakfastTable.getColumnModel().getColumn(1).setResizable(false);
            BreakfastTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Breakfast", jPanel6);

        LunchTable.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        LunchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Product Name", "Avail", "Price", "Total Bought"
            }
        ));
        jScrollPane5.setViewportView(LunchTable);
        if (LunchTable.getColumnModel().getColumnCount() > 0) {
            LunchTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            LunchTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lunch", jPanel7);

        DinnerTable.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        DinnerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Avail", "Price", "Total Bought"
            }
        ));
        jScrollPane6.setViewportView(DinnerTable);
        if (DinnerTable.getColumnModel().getColumnCount() > 0) {
            DinnerTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            DinnerTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        }

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dinner", jPanel8);

        DrinksTable.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        DrinksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Avail", "Price", "Total Bought"
            }
        ));
        jScrollPane7.setViewportView(DrinksTable);
        if (DrinksTable.getColumnModel().getColumnCount() > 0) {
            DrinksTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            DrinksTable.getColumnModel().getColumn(1).setPreferredWidth(120);
            DrinksTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            DrinksTable.getColumnModel().getColumn(3).setPreferredWidth(50);
            DrinksTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Drinks", jPanel5);

        RefreshProdList.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        RefreshProdList.setText("Refresh");
        RefreshProdList.setBorder(null);
        RefreshProdList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshProdListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RefreshProdList, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RefreshProdList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Managerial Body");

        jPanel10.setBackground(new java.awt.Color(255, 255, 0));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        ReceiptButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ReceiptButton.setText("Receipt");
        ReceiptButton.setBorder(null);
        ReceiptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReceiptButtonActionPerformed(evt);
            }
        });

        BackButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BackButton.setText("Sign Out");
        BackButton.setBorder(null);

        ConverterButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ConverterButton.setText("Converter");
        ConverterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConverterButtonActionPerformed(evt);
            }
        });

        TotalButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TotalButton.setText("Total");
        TotalButton.setBorder(null);

        ResetButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ResetButton.setText("Reset");
        ResetButton.setBorder(null);
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addComponent(TotalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(ConverterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(ReceiptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ResetButton)
                    .addComponent(TotalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ConverterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReceiptButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BackButton))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Cost of Meal");

        MealCostLabel.setBackground(new java.awt.Color(255, 255, 255));
        MealCostLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        MealCostLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        MealCostLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        DrinksCostLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        DrinksCostLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        DrinksCostLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Cost of Drinks");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("SubTotal");

        SubTotalLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        SubTotalLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        SubTotalLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setText("VAT");

        HomeDeliveryCostLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        HomeDeliveryCostLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        HomeDeliveryCostLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        JLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JLabel13.setText("Home Delivery");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setText("Discount");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Total");

        TotalLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        TotalLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TotalLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        CheckDelivery.setBackground(new java.awt.Color(255, 255, 0));
        CheckDelivery.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CheckDelivery.setText("Home Delivery");
        CheckDelivery.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        CheckDelivery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CheckDeliveryMouseClicked(evt);
            }
        });

        Prod_IDField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setText("Product ID");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setText("Product Name");
        jLabel13.setMaximumSize(new java.awt.Dimension(125, 20));
        jLabel13.setMinimumSize(new java.awt.Dimension(120, 20));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel24.setText("Quantity");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel25.setText("Price");

        ProdQuantityField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ProdQuantityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdQuantityFieldActionPerformed(evt);
            }
        });

        AddProdButon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        AddProdButon.setText("Sum");
        AddProdButon.setPreferredSize(new java.awt.Dimension(20, 40));

        RemoveProdButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        RemoveProdButton.setText("Cancel");
        RemoveProdButton.setPreferredSize(new java.awt.Dimension(20, 40));

        ProdNameField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ProdNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdNameFieldActionPerformed(evt);
            }
        });

        ProdPriceField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        DoneAddButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DoneAddButton.setText("Done");
        DoneAddButton.setPreferredSize(new java.awt.Dimension(20, 40));

        ProdTypeCombo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ProdTypeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Breakfast", "Lunch", "Dinner", "Drinks" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(Prod_IDField, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ProdNameField)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ProdQuantityField)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ProdPriceField)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(RemoveProdButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DoneAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AddProdButon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ProdTypeCombo, 0, 154, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Prod_IDField)
                        .addComponent(ProdNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ProdQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ProdPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RemoveProdButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DoneAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ProdTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AddProdButon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        DiscountField.setBackground(new java.awt.Color(255, 255, 0));
        DiscountField.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        DiscountField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        DiscountField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        VatField.setBackground(new java.awt.Color(255, 255, 0));
        VatField.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        VatField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        VatField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setText("%");
        jLabel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel23.setText("%");
        jLabel23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(CheckDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(DrinksCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SubTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(DiscountField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel23))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(VatField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel21)
                                                .addGap(6, 6, 6))))
                                    .addComponent(HomeDeliveryCostLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TotalLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MealCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(MealCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DrinksCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SubTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(VatField))
                        .addGap(18, 18, 18)
                        .addComponent(HomeDeliveryCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DiscountField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(CheckDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        SignLabel.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        SignLabel.setForeground(new java.awt.Color(255, 0, 0));
        SignLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        SignOutLabel.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        SignOutLabel.setForeground(new java.awt.Color(204, 204, 204));

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel2.setText("Customer Name   :");

        Shop_Name.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        Shop_Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Shop_Name.setText("Sylhet Biriyani House");

        jLabel5.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel5.setText("Phone No        :");

        jLabel6.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel6.setText("Addrress        :");

        C_NameField.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        C_NameField.setText("Customer Name...");

        C_PhoneField.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        C_PhoneField.setText("Phone No...");
        C_PhoneField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_PhoneFieldActionPerformed(evt);
            }
        });

        C_AddrressField.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        C_AddrressField.setText("Addrress...");

        jLabel8.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel8.setText("Cost of Meal    :");

        jLabel10.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel10.setText("Cost of Drinks  :");

        jLabel12.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel12.setText("Sub Total       :");

        jLabel15.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel15.setText("VAT             :");

        jLabel16.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel16.setText("Delivery Cost   :");

        jLabel17.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel17.setText("Discount        :");

        jLabel18.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel18.setText("Total           :");

        jLabel19.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 153));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Thank You!");

        MealLabel.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        MealLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        MealLabel.setText("/=");

        DrinksLabel.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        DrinksLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        DrinksLabel.setText("/=");

        SubTotalLabel1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        SubTotalLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        SubTotalLabel1.setText("/=");

        DeliveryLabel.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        DeliveryLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        DeliveryLabel.setText("/=");

        VatLabel1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        VatLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        VatLabel1.setText("%");

        DiscountLabel1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        DiscountLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        DiscountLabel1.setText("%");

        C_TotalLabel.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        C_TotalLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        C_TotalLabel.setText("/=");

        HavingDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        HavingDate.setText("Date");

        HavingTime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        HavingTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        HavingTime.setText("Time");

        SaveReceipt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SaveReceipt.setText("Save");
        SaveReceipt.setBorder(null);
        SaveReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveReceiptActionPerformed(evt);
            }
        });

        SaveReceipt1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SaveReceipt1.setText("Print");
        SaveReceipt1.setBorder(null);
        SaveReceipt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveReceipt1ActionPerformed(evt);
            }
        });

        ClearReceipt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ClearReceipt.setText("Clear");
        ClearReceipt.setBorder(null);
        ClearReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearReceiptActionPerformed(evt);
            }
        });

        UserIDLabel1.setText("User");

        UserIDLabel2.setText("ID");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DiscountLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(VatLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(C_TotalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(SaveReceipt1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(ClearReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SaveReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Shop_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(HavingDate, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(HavingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(UserIDLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(UserIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MealLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DrinksLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SubTotalLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DeliveryLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(C_NameField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(C_PhoneField, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(C_AddrressField))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(UserIDLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(UserNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Shop_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C_NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C_PhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C_AddrressField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(UserIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UserNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UserIDLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(MealLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(DrinksLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(SubTotalLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(DeliveryLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(VatLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(DiscountLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(C_TotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(HavingDate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HavingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SaveReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SaveReceipt1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ClearReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(UserIDLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 2));

        Date.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        Date.setForeground(new java.awt.Color(255, 255, 0));
        Date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Time.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        Time.setForeground(new java.awt.Color(255, 255, 0));
        Time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Time, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Time, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        CalculatorMenu.setText("Calculator");
        jMenu1.add(CalculatorMenu);
        jMenu1.add(jSeparator5);

        ChangePassword.setText("Change Password");
        jMenu1.add(ChangePassword);
        jMenu1.add(jSeparator10);

        ConverterMenu.setText("Converter");
        jMenu1.add(ConverterMenu);
        jMenu1.add(jSeparator4);

        Database.setText("Database");
        jMenu1.add(Database);
        jMenu1.add(jSeparator8);

        EmployeeDetails.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        EmployeeDetails.setText("EmployeeDetails");
        jMenu1.add(EmployeeDetails);
        jMenu1.add(jSeparator2);

        LogHistoryMenu.setText("Log History");
        jMenu1.add(LogHistoryMenu);
        jMenu1.add(jSeparator6);

        SignOutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        SignOutMenuItem.setText("Sign Out");
        jMenu1.add(SignOutMenuItem);
        jMenu1.add(jSeparator7);

        QuitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        QuitMenuItem.setText("Quit");
        jMenu1.add(QuitMenuItem);
        jMenu1.add(jSeparator3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        AddUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        AddUser.setText("Add User");
        jMenu2.add(AddUser);
        jMenu2.add(jSeparator1);

        EditProducts.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        EditProducts.setText("Edit Products List");
        jMenu2.add(EditProducts);
        jMenu2.add(jSeparator9);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SignLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SignOutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(SignLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(SignOutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReceiptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReceiptButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReceiptButtonActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResetButtonActionPerformed

    private void ConverterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConverterButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConverterButtonActionPerformed

    private void SaveReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveReceiptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveReceiptActionPerformed

    private void ProdNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProdNameFieldActionPerformed

    private void RefreshProdListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshProdListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RefreshProdListActionPerformed

    private void SaveReceipt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveReceipt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveReceipt1ActionPerformed

    private void C_PhoneFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_PhoneFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C_PhoneFieldActionPerformed

    private void CheckDeliveryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckDeliveryMouseClicked
        double eDelivery = 50;
        if (CheckDelivery.isSelected()) {
            String Delivery = String.format("%.2f", eDelivery);
            HomeDeliveryCostLabel.setText(Delivery);
        } else {
            HomeDeliveryCostLabel.setText(null);
        }
    }//GEN-LAST:event_CheckDeliveryMouseClicked

    private void ClearReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearReceiptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearReceiptActionPerformed

    private void ProdQuantityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdQuantityFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProdQuantityFieldActionPerformed

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
            java.util.logging.Logger.getLogger(ManagingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagingPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddProdButon;
    private javax.swing.JMenuItem AddUser;
    private javax.swing.JButton BackButton;
    private javax.swing.JTable BreakfastTable;
    private javax.swing.JTextField C_AddrressField;
    private javax.swing.JTextField C_NameField;
    private javax.swing.JTextField C_PhoneField;
    private javax.swing.JLabel C_TotalLabel;
    private javax.swing.JMenuItem CalculatorMenu;
    private javax.swing.JMenuItem ChangePassword;
    private javax.swing.JCheckBox CheckDelivery;
    private javax.swing.JButton ClearReceipt;
    private javax.swing.JButton ConverterButton;
    private javax.swing.JMenuItem ConverterMenu;
    private javax.swing.JMenuItem Database;
    private javax.swing.JLabel Date;
    private javax.swing.JLabel DeliveryLabel;
    private javax.swing.JTable DinnerTable;
    private javax.swing.JTextField DiscountField;
    private javax.swing.JLabel DiscountLabel1;
    private javax.swing.JButton DoneAddButton;
    private javax.swing.JLabel DrinksCostLabel;
    private javax.swing.JLabel DrinksLabel;
    private javax.swing.JTable DrinksTable;
    private javax.swing.JMenuItem EditProducts;
    private javax.swing.JMenuItem EmployeeDetails;
    private javax.swing.JLabel HavingDate;
    private javax.swing.JLabel HavingTime;
    private javax.swing.JLabel HomeDeliveryCostLabel;
    private javax.swing.JLabel JLabel13;
    private javax.swing.JMenuItem LogHistoryMenu;
    private javax.swing.JTable LunchTable;
    private javax.swing.JLabel MealCostLabel;
    private javax.swing.JLabel MealLabel;
    private javax.swing.JTextField ProdNameField;
    private javax.swing.JTextField ProdPriceField;
    private javax.swing.JTextField ProdQuantityField;
    private javax.swing.JComboBox ProdTypeCombo;
    private javax.swing.JTextField Prod_IDField;
    private javax.swing.JMenuItem QuitMenuItem;
    private javax.swing.JButton ReceiptButton;
    private javax.swing.JButton RefreshProdList;
    private javax.swing.JButton RemoveProdButton;
    private javax.swing.JButton ResetButton;
    private javax.swing.JButton SaveReceipt;
    private javax.swing.JButton SaveReceipt1;
    private javax.swing.JLabel Shop_Name;
    private javax.swing.JLabel SignLabel;
    private javax.swing.JLabel SignOutLabel;
    private javax.swing.JMenuItem SignOutMenuItem;
    private javax.swing.JLabel SubTotalLabel;
    private javax.swing.JLabel SubTotalLabel1;
    private javax.swing.JLabel Time;
    private javax.swing.JButton TotalButton;
    private javax.swing.JLabel TotalLabel;
    private javax.swing.JLabel UserIDLabel;
    private javax.swing.JLabel UserIDLabel1;
    private javax.swing.JLabel UserIDLabel2;
    private javax.swing.JLabel UserNameLabel;
    private javax.swing.JTextField VatField;
    private javax.swing.JLabel VatLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    void BreakFast(ResultSet resultSet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
