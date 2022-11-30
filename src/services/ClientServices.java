/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Client;
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
public class ClientServices {
        protected Connection con;
    protected Statement ste;

    public ClientServices() {
                con = DataBase.getInstance().getConnection();
    }
    
    
    public Client findByUserIdPopulated(int id) throws SQLException {
        try {
            PreparedStatement pre = con.prepareStatement("SELECT *,client.id as clientId FROM `users` LEFT JOIN client on users.id = client.userId WHERE users.id = ?");
            pre.setString(1, String.valueOf(id));

            ResultSet rs = pre.executeQuery();
            Client c = new Client();
            if (rs.next()) {
            c.setId(rs.getInt("id"));
            c.setIdClient(rs.getInt("clientId"));
            c.setEmail(rs.getString("email"));
            c.setRole(rs.getString("role"));
            c.setNom(rs.getString("nom"));
            c.setPrenom(rs.getString("prenom"));
            c.setDdn(rs.getDate("dateDeNaissance"));
            c.setPhone(rs.getString("numeroTel"));
            }
        return c;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }
    
    public boolean updateClient(Client c) throws SQLException {
        try {
            PreparedStatement pre = con.prepareStatement("update client set nom= ? , prenom = ? , numeroTel = ?, dateDeNaissance = ? where userId = ?");
            pre.setString(1, c.getNom() );
            pre.setString(2, c.getPrenom());
            pre.setString(3, c.getPhone() );
            pre.setDate(4, c.getDdn());
            pre.setString(5, String.valueOf(c.getId()) );
            pre.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }
    
    public boolean updateClientByAdmin(Client c) throws SQLException {
        try {
            PreparedStatement pre = con.prepareStatement("update users set email = ? where id = ?");
            pre.setString(1, c.getEmail());
            pre.setString(2, String.valueOf(c.getId()) );
            pre.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }
    
     public boolean deleteClient(Client c) throws SQLException {
        try {
            System.out.println("fil service : "+ c.getId());
            PreparedStatement pre = con.prepareStatement("delete from client where userId = ?");
            pre.setInt(1, c.getId());
            pre.executeUpdate();
            PreparedStatement pre2 = con.prepareStatement("delete from users where id = ?");
            pre2.setInt(1, c.getId());
            pre2.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }
}
