/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.facture;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.DataBase;

/**
 *
 * @author Oasis
 */
public class servicefacture {
        private Connection cnx;
    private PreparedStatement ste;

    public servicefacture() {
        cnx = DataBase.getInstance().getConnection();
    }

    public void ajoutpaiement(facture p) {
        String req = "INSERT INTO facturepaiement ( clientid, montant,datef, datefacture,idRdv,idf )" + "values (?,?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, p.getClientid());
            ste.setFloat(2, p.getMontant());
            ste.setString(3, p.getDatef());
           ste.setDate(4, (Date) p.getDatefacture());
           ste.setInt(5, p.getIdRdv());
             ste.setInt(6, p.getIdfacture());
           
           
            ste.executeUpdate();
            System.out.println("facture ajoutée");

        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());

        }

    }
ObservableList<facture> factureList = FXCollections.observableArrayList();
  public ObservableList<facture> getfactureList(){
   
         
    
        String query="select * from facturepaiement ";
        PreparedStatement pre;
        try {
            pre = cnx.prepareStatement(query);
             ResultSet rst =pre.executeQuery();
        
     
      
    
        
            while(rst.next())
            {  
            int clientid= rst.getInt("clientid");
            Float montant = rst.getFloat("montant");
            String datef = rst.getString("datef");
            Date datefacture = rst.getDate("datefacture");
            int idRdv = rst.getInt("idRdv");
            int idfacture = rst.getInt("idf");
            facture p = new facture (idfacture,idRdv, clientid, montant,datef,datefacture);
            factureList.add(p);
            
            }   } catch (SQLException ex) {
            Logger.getLogger(servicefacture.class.getName()).log(Level.SEVERE, null, ex);
        } 
     
     return factureList;
    }
 
        
            
   
    
            
    
     public void Supprimerfacture(facture f){  
       String req="DELETE FROM `facturepaiement` WHERE `clientid`="+ f.getClientid();
         try {
             ste = cnx.prepareStatement(req);
             ste.executeUpdate();
             System.out.println("facturepaiement bien supprimé");
             
             
             
         }catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
        
    } 
}
    

    public List<facture> ListClasse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<facture> afficherRdvs() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   
    public void modifierfacture(facture r) {
                    
     String req=  "UPDATE facturepaiement SET `clientid`=?,`montant`=?,`datef`=?,`datefacture`=?,`idRdv`=? WHERE `idf`=?";
          
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, r.getClientid());
            ste.setFloat(2, r.getMontant());
            ste.setString(3, r.getDatef());
            ste.setDate(4, (Date) r.getDatefacture());
             ste.setInt(5, r.getIdRdv());
             ste.setInt(6, r.getIdfacture());
              
         ste.executeUpdate();
            System.out.println("facture has Updated !!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void retourrendezvous(facture r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Supprimerpersonne(facture f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void modifierrdv(facture r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void modifierfacture() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
