/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Ashish
 */
public class DataBase {

    static final String DATABASE_URL = "jdbc:mysql://localhost/restaurantmanagement";
    static final String DATABASE_USER = "root";
    static final String DATABASE_PASS = "";
    Connection connection = null; // manages connection
    Statement statement = null; // query statement
    ResultSet resultSet = null;

    public DataBase() throws SQLException {
        getConnection();
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
    
    public void ShopNamePlace(String name, String place){      
        try {
            String sql = "update name_place set ShopName = '"+name+"', ShopPlace = '"+place+"' where id=1";
            System.out.println("Update Shop name Point 2");
            statement.executeUpdate(sql);
            System.out.println("Update Shop name Point 3");
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex);
        }
    }
    public void MatchUser(String UserName, String Password) {
        try {
            String sql = "select *from login where username = '" + UserName + "' and password = '" + Password + "'";
            resultSet = statement.executeQuery(sql);
            //String sql1 = "select Type from login where Type = 'Admin'";
            if (resultSet.next()) {
                String type = "null";
                type = resultSet.getString("Type");
                System.out.println("Type=" + type);
                System.out.println("GoodJob!");
                if (type.equals("Owner")) {
                    //System.out.println("What the heck!!!");
                    //this.dispose();
                    EditingPage ob = new EditingPage();
                    //ob.WhoSignedIn(userName);
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

    public void LogInDetails(String whoSigned, String time, String time1, String date) throws SQLException {
        try {
            String sql = "INSERT INTO logindetails (WhoLoggedIn, LogInTime, LogOutTime, TodaysDate) VALUES ('" + whoSigned + "','" + time + "', '" + time1 + "', '" + date + "');";
            System.out.println("LogIn Details Check Point 1");
            statement.executeUpdate(sql);
            System.out.println("LogIn Details Check Point 3");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void ReceiptSaveToDB(String name, String phone, String address, String R_Date, String g) {
        try {
            String sql = "INSERT INTO receipt (C_name, C_addrress, C_phone, Having_time, Total_cost) VALUES ('" + name + "','" + address + "', '" + phone + "', '" + R_Date + "','" + g + "');";
            System.out.println("Receipt table e dhukse...");
            statement.executeUpdate(sql);
            System.out.println("Execute o hoise....");
        } catch (SQLException ex) {
            System.out.println("Sorry Boss, You have some wrong in your code: " + ex);
        }
    }

    public void SearchEmployee(String id) {
        String Name, PermAddrress, PreAddrress, Phone, VID, Type;
        try {
            String sql = "select *from employee where Em_id = '" + id + "'";
            resultSet = statement.executeQuery(sql);
            //String sql1 = "select Type from login where Type = 'Admin'";
            if (resultSet.next()) {
                Name = resultSet.getString("Em_name");
                PermAddrress = resultSet.getString("EmPerm_addrress");
                PreAddrress = resultSet.getString("EmPre_addrress");
                Phone = resultSet.getString("Em_Phone");
                VID = resultSet.getString("EmV_id");
                Type = resultSet.getString("Em_type");
                EmployeeDetails ob = new EmployeeDetails();
                ob.SetEmDetails(Name, PermAddrress, PreAddrress, Phone, VID, Type);
                ob.setVisible(true);
                System.out.println("Name= " + Name);
                System.out.println("PermAdd= " + PermAddrress);
                System.out.println("PreAdd= " + PreAddrress);

            } else {
                JOptionPane.showMessageDialog(null, "Sorry! No Employee found!");
                EmployeeDetails ob = new EmployeeDetails();
                ob.setVisible(true);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR!"+ex);
        }

    }
    
    public void UpdateEmployee(int id, String name, String add1, String add2, String phone, String vidNo, String type){
        try {
            String sql = "update employee set Em_name = '" + name + "', EmPerm_addrress = '" + add1 + "', EmPre_addrress = '" + add2 + "', Em_Phone='" + phone + "', EmV_id='" + vidNo + "', Em_type='" + type + "' where Em_id = '" + id + "'";
            System.out.println("Update Employee Check Point 2");
            statement.executeUpdate(sql);
            EmployeeDetails ob = new EmployeeDetails();
            ob.showUpdateMessege();
            ob.dispose();
            System.out.println("Update Employee Check Point 3");
            System.out.println("Updated row 1");
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex);
        }
    }

    public void AddEmployees(String SetUser, String SetPermAd, String SetPreAd, String SPhone, String SVID, String Type) throws SQLException {

        try {
            String sql = "INSERT INTO employee (Em_name, EmPerm_addrress, EmPre_addrress, Em_Phone, EmV_id, Em_type) VALUES ('" + SetUser + "', '" + SetPermAd + "', '" + SetPreAd + "', '" + SPhone + "', '" + SVID + "', '" + Type + "');";
            System.out.println("Check Point 4");
            statement.executeUpdate(sql);
            System.out.println("Check Point 5");
        } catch (SQLException ex) {
            System.out.println("AddEmployees" + ex);
        }
    }

    public void closeDBConnection() {
        try {
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Closed DB");
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SaveToDB(String UserName, String Password) throws SQLException {
        //getConnection();
        System.out.println("Check Point 1: SaveToDB>>>");
        try {
            String sql = "INSERT INTO login (username, password, Type) VALUES ('" + UserName + "', '" + Password + "','Admin');";
            System.out.println("Check Point 2");
            statement.executeUpdate(sql);
            System.out.println("Check Point 3");
        } catch (SQLException ex) {
            System.out.println("ERROR!"+ex);
        }
    }

    public void InsertIntoBrekfast(String prod_id, String prod_name, int prod_avail, String prod_price, String prod_quantity) {
        try {
            String sql = "insert into breakfast (Prod_id, Prod_name, Prod_avail, Prod_price, Prod_inTotal, temp) values('" + prod_id + "', '" + prod_name + "','" + prod_avail + "', '" + prod_price + "', '" + prod_quantity + "', '0')";
            System.out.println("Check Point 2");
            statement.executeUpdate(sql);
            EditProductsList ob = new EditProductsList();
            ob.showInsertMessage();
            System.out.println("Check Point 3");
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        }
    }

    public void InsertIntoLunch(String prod_id, String prod_name, int prod_avail, String prod_price, String prod_quantity) {
        try {
            String sql = "insert into lunch (LProd_id, LProd_name, LProd_avail, Prod_Price, LProd_inTotal, temp) values('" + prod_id + "', '" + prod_name + "','" + prod_avail + "', '" + prod_price + "', '" + prod_quantity + "', '0')";
            System.out.println("Insert into Lunch Check Point 2");
            statement.executeUpdate(sql);
            EditProductsList ob = new EditProductsList();
            ob.showInsertMessage();
            System.out.println("Insert into Lunch Check Point 3");
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        }
    }

    public void InsertIntoDinner(String prod_id, String prod_name, int prod_avail, String prod_price, String prod_quantity) {
        try {
            String sql = "insert into dinner (DProd_id, DProd_name, DProd_avail, DProd_price, DProdTotal_bought, temp) values('" + prod_id + "', '" + prod_name + "','" + prod_avail + "', '" + prod_price + "', '" + prod_quantity + "', '0')";
            System.out.println("Insert into Lunch Check Point 2");
            statement.executeUpdate(sql);
            EditProductsList ob = new EditProductsList();
            ob.showInsertMessage();
            System.out.println("Insert into Lunch Check Point 3");
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        }
    }

    public void InsertIntoDrinks(String prod_id, String prod_name, int prod_avail, String prod_price, String prod_quantity) {
        try {
            String sql = "insert into drinks (Drinks_id, Drinks_name, Drinks_avail, Drinks_price, DrinksTotal_bought, temp) values('" + prod_id + "', '" + prod_name + "','" + prod_avail + "', '" + prod_price + "', '" + prod_quantity + "', '0')";
            System.out.println("Insert into Lunch Check Point 2");
            statement.executeUpdate(sql);
            EditProductsList ob = new EditProductsList();
            ob.showInsertMessage();
            System.out.println("Insert into Lunch Check Point 3");
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        }
    }

    public void UpdateBreakfast(String prod_id, String prod_name, int prod_avail, String prod_price, String prod_quantity) {
        try {
            String sql = "update breakfast set Prod_name = '" + prod_name + "', Prod_avail = '" + prod_avail + "', Prod_price = '" + prod_price + "', Prod_inTotal='" + prod_quantity + "' where Prod_id = '" + prod_id + "'";
            System.out.println("Update Breakfast Check Point 2");
            statement.executeUpdate(sql);
            EditProductsList ob = new EditProductsList();
            ob.showUpdateMessage();
            System.out.println("Update breakfast Check Point 3");
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex);
        }
    }
    public void UpdateLunch(String prod_id, String prod_name, int prod_avail, String prod_price, String prod_quantity) {
        try {
            String sql = "update lunch set LProd_name = '" + prod_name + "', LProd_avail = '" + prod_avail + "', Prod_Price = '" + prod_price + "', LProd_inTotal='" + prod_quantity + "' where LProd_id = '" + prod_id + "'";
            System.out.println("Update Lunch Check Point 2");
            statement.executeUpdate(sql);
            EditProductsList ob = new EditProductsList();
            ob.showUpdateMessage();
            System.out.println("Update Lunch Check Point 3");
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex);
        }
    }
    public void UpdateDinner(String prod_id, String prod_name, int prod_avail, String prod_price, String prod_quantity) {
        try {
            String sql = "update dinner set DProd_name = '" + prod_name + "', DProd_avail = '" + prod_avail + "', DProd_Price = '" + prod_price + "', DProdTotal_bought='" + prod_quantity + "' where DProd_id = '" + prod_id + "'";
            System.out.println("Update Dinner Check Point 2");
            statement.executeUpdate(sql);
            EditProductsList ob = new EditProductsList();
            ob.showUpdateMessage();
            System.out.println("Update Dinner Check Point 3");
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex);
        }
    }
    public void UpdateDrinks(String prod_id, String prod_name, int prod_avail, String prod_price, String prod_quantity) {
        try {
            String sql = "update drinks set Drinks_name = '" + prod_name + "', Drinks_avail = '" + prod_avail + "', Drinks_Price = '" + prod_price + "', DrinksTotal_bought='" + prod_quantity + "' where Drinks_id = '" + prod_id + "'";
            System.out.println("Update Drinks Check Point 2");
            statement.executeUpdate(sql);
            EditProductsList ob = new EditProductsList();
            ob.showUpdateMessage();
            System.out.println("Update Drinks Check Point 3");
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex);
        }
    }
    public void DeleteBreakFast(String prod_id){
        try {
            String sql = "delete from breakfast where Prod_id = "+prod_id+""; 
            System.out.println("Delete from Breakfast Check Point 2");
            statement.executeUpdate(sql);
            EditProductsList ob = new EditProductsList();
            ob.showDeleteMessage();
            System.out.println("Delete from Breakfast Check Point 3");
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex);
        }
    }
    public void DeleteLunch(String prod_id){
        try {
            String sql = "delete from lunch where LProd_id = "+prod_id+""; 
            System.out.println("Delete from Lunch Check Point 2");
            statement.executeUpdate(sql);
            EditProductsList ob = new EditProductsList();
            ob.showDeleteMessage();
            System.out.println("Delete from Lunch Check Point 3");
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex);
        }
    }
    public void DeleteDinner(String prod_id){
        try {
            String sql = "delete from dinner where DProd_id = "+prod_id+""; 
            System.out.println("Delete from Dinner Check Point 2");
            statement.executeUpdate(sql);
            EditProductsList ob = new EditProductsList();
            ob.showDeleteMessage();
            System.out.println("Delete from Dinner Check Point 3");
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex);
        }
        
    }
    public void DeleteDrinks(String prod_id){
        try {
            String sql = "delete from drinks where Drinks_id = "+prod_id+""; 
            System.out.println("Delete from Drinks Check Point 2");
            statement.executeUpdate(sql);
            EditProductsList ob = new EditProductsList();
            ob.showDeleteMessage();
            System.out.println("Delete from Drinks Check Point 3");
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex);
        }
        
    }
    public void UpdateProductsQuantity(){
        
        try {
            String sql = "update breakfast set Prod_avail = Prod_avail - temp, temp = 0";
            String sql1 = "update lunch set LProd_avail = LProd_avail - temp, temp = 0";
            String sql2 = "update dinner set DProd_avail = DProd_avail - temp, temp = 0";
            String sql3 = "update drinks set Drinks_avail = Drinks_avail - temp, temp = 0";
            System.out.println("Update Products availibility Check Point 2");
            statement.executeUpdate(sql);
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);
            statement.executeUpdate(sql3);
            System.out.println("Update Products availability Check Point 3");
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex);
        }
    }
    

}

//String sql1 = "INSERT INTO 'login' (id, username, password) VALUES (NULL, '" + UserName + "', '" + Password + "');";
