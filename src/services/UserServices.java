/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Client;
import entities.User;
import com.gn.module.main.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import utils.DataBase;

/**
 *
 * @author SBS
 */
public class UserServices {

    protected Connection con;
    protected Statement ste;
    
    public UserServices() {
        con = DataBase.getInstance().getConnection();
    }
    
     public ObservableList<User> getAllUsers() throws SQLException {
        try {
            PreparedStatement pre = con.prepareStatement("select * from users");
            ResultSet rs = pre.executeQuery();
            ObservableList<User> users = FXCollections.observableArrayList();
            while (rs.next()) {
                users.add(new User(rs.getInt("id"),rs.getString("email") , rs.getString("role")));
            }
        return users;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }
    
     public User findByEmail(String email) throws SQLException {
        try {
            PreparedStatement pre = con.prepareStatement("select * from users where email = ?");
            pre.setString(1, email);

            ResultSet rs = pre.executeQuery();
            User u = new User();
            if (rs.next()) {
            u.setId(rs.getInt("id"));
            u.setEmail(rs.getString("email"));
            u.setRole(rs.getString("role"));
            }
        return u;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }
     
     public User findByCode(int code) throws SQLException {
        try {
            System.out.println("code : "+code);
            PreparedStatement pre = con.prepareStatement("select * from users where forgetPasswordCode = ?");
            pre.setInt(1, code);

            ResultSet rs = pre.executeQuery();
            User u = null;
            if (rs.next()) {
            u = new User();
            u.setId(rs.getInt("id"));
            u.setEmail(rs.getString("email"));
            u.setRole(rs.getString("role"));
            }
        return u;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }
     
      public int checkUser(String email) throws SQLException {
        try {
            PreparedStatement pre = con.prepareStatement("select count(*) from users where email = ?");
            pre.setString(1, email);

            ResultSet rs = pre.executeQuery();
            rs.next();
        return rs.getInt("count(*)");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;

    }
    
    public boolean register(String email, String password, String role, String hash) {
        try {
            if (role.equals("client")){
                int verifUser = this.checkUser(email);
                if (verifUser <= 0 ){
                    PreparedStatement pre = con.prepareStatement("insert into users (email, password, role, hash) values ( ?,?, ?, ?) ");
                    pre.setString(1, email);
                    pre.setString(2, password);
                    pre.setString(3, role);
                    pre.setString(4, hash);
                    pre.executeUpdate();
                    User u = this.findByEmail(email);
                    if (u != null) {
                        pre = con.prepareStatement("insert into client (userId) values (?) ");
                        pre.setString(1, String.valueOf(u.getId()));
                        pre.executeUpdate();
                        System.out.println("Account ADDED");
                    }
                } else {
                    System.out.println("this email already used");
                }
            } else {
                int verifUser = this.checkUser(email);
                if (verifUser <= 0 ){
                    PreparedStatement pre = con.prepareStatement("insert into users (email, password, role) values ( ?,?, ?) ");
                    pre.setString(1, email);
                    pre.setString(2, password);
                    pre.setString(3, role);
                    pre.executeUpdate();
                    User u = this.findByEmail(email);
                    if (u != null) {
                        pre = con.prepareStatement("insert into associe (userId) values (?) ");
                        pre.setString(1, String.valueOf(u.getId()));
                        pre.executeUpdate();
                        System.out.println("Account ADDED");
                    }
                } else {
                    System.out.println("this email already used");
                }
            }
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean updateForgetPasswordCode(int code, int userId) throws SQLException {
        try {
            PreparedStatement pre = con.prepareStatement("update users set forgetPasswordCode = ? where id = ?");
            pre.setInt(1, code);
            pre.setInt(2, userId );
            pre.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }
    
    public boolean updatePassword(String password, int userId) throws SQLException {
        try {
            System.out.println(Data.userToChangePassword.toString());
            System.out.println(password);
            PreparedStatement pre = con.prepareStatement("update users set password = ? where id = ?");
            pre.setString(1, password);
            pre.setInt(2, userId );
            pre.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }
    
    public User login(String email,String password) throws SQLException {
        try {
            PreparedStatement pre = con.prepareStatement("select * from users where email = ? ");
            pre.setString(1, email);

            ResultSet rs = pre.executeQuery();
            User u = new User();
            if (rs.next()) {
            u.setId(rs.getInt("id"));
            u.setEmail(rs.getString("email"));
            u.setPassword(rs.getString("password"));
            u.setRole(rs.getString("role"));
            }
        return u;
        } catch (SQLException ex) {
            TrayNotification tray = new TrayNotification("Error","Vérifier vos informations",NotificationType.ERROR);
            tray.showAndDismiss(Duration.seconds(5));
            ex.printStackTrace();
        }
        return null;

    }
    
    
}
