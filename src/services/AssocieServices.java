/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Associe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utils.DataBase;

/**
 *
 * @author SBS
 */
public class AssocieServices {
        protected Connection con;
    protected Statement ste;

    public AssocieServices() {
        con = DataBase.getInstance().getConnection();

    }
    
    
    
    public Associe findByUserIdPopulated(int id) throws SQLException {
        try {
            PreparedStatement pre = con.prepareStatement("SELECT * FROM `users` LEFT JOIN associe on users.id = associe.userId WHERE users.id = ?");
            pre.setString(1, String.valueOf(id));

            ResultSet rs = pre.executeQuery();
            Associe a = new Associe();
            if (rs.next()) {
            a.setId(rs.getInt("id"));
            a.setEmail(rs.getString("email"));
            a.setRole(rs.getString("role"));
            a.setNom(rs.getString("nom"));
            a.setPrenom(rs.getString("prenom"));
            a.setType(rs.getString("type"));
            a.setDescription(rs.getString("description"));
            a.setContactMail(rs.getString("contactMail"));
            a.setContactTel(rs.getInt("contactTel"));
            a.setLatitude(rs.getString("latitude"));
            a.setLongitude(rs.getString("longitude"));
            a.setNbreMaxClientParJours(rs.getInt("nbreMaxClientParJour"));
            }
        return a;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }
    
    public boolean updateAssocie(Associe a) throws SQLException {
        try {
            PreparedStatement pre = con.prepareStatement("update associe set nom= ? , prenom = ? , type = ? , description = ? ,contactMail = ? ,contactTel = ? ,latitude = ? ,longitude = ? ,nbreMaxClientParJour = ?  where userId = ?");
            pre.setString(1, a.getNom() );
            pre.setString(2, a.getPrenom());
            pre.setString(3, a.getType());
            pre.setString(4, a.getDescription());
            pre.setString(5, a.getContactMail());
            pre.setInt(6, a.getContactTel());
            pre.setString(7, a.getLatitude());
            pre.setString(8, a.getLongitude());
            pre.setInt(9, a.getNbreMaxClientParJours());


            pre.setString(10, String.valueOf(a.getId()) );
            pre.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }
    
    public boolean updateAssocieByAdmin(Associe a) throws SQLException {
        try {
            PreparedStatement pre = con.prepareStatement("update users set email = ?  where id = ?");
            pre.setString(1, a.getEmail());
            pre.setString(2, String.valueOf(a.getId()) );
            pre.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }
    
     public boolean deleteAssocie(Associe a) throws SQLException {
        try {
            PreparedStatement pre = con.prepareStatement("delete from associe where userId = ?");
            pre.setInt(1, a.getId());
            pre.executeUpdate();
            PreparedStatement pre2 = con.prepareStatement("delete from users where id = ?");
            pre2.setInt(1, a.getId());
            pre2.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
