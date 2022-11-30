/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.rendezvous;
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
public class servicesrendezvous {
        private Connection cnx;
    private PreparedStatement ste;

    public servicesrendezvous() {
        cnx = DataBase.getInstance().getConnection();
    }

    public void ajouterrdv(rendezvous p) {
        String req = "INSERT INTO rdv ( idRdv,  clientid,  associeid ,  date ,  etat ,   Typepaiement, dater )" + "values (?,?,?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, p.getIdRdv());
            ste.setInt(2, p.getClientid());
            ste.setInt(3, p.getAssocieid());
            ste.setString(4, p.getDate());
            ste.setString(5, p.getEtat());
            ste.setString(6, p.getTypepaiement());
            ste.setDate(7, (Date) p.getDater());
            ste.executeUpdate();
            System.out.println("rendez-vous ajoutée");

        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());

        }

    
    }
ObservableList<rendezvous> rdvList = FXCollections.observableArrayList();
  public ObservableList<rendezvous> getParkingList(){
   
         
    
        String query="select * from rdv ";
        PreparedStatement pre;
        try {
            pre = cnx.prepareStatement(query);
             ResultSet rst =pre.executeQuery();
        
     
      
    
        
            while(rst.next())
            {    int idRdv= rst.getInt("idRdv");
            int clientid= rst.getInt("clientid");
            int associeid = rst.getInt("associeid");
            String date = rst.getString("date");
            String etat = rst.getString("etat");
              String Typepaiement = rst.getString("Typepaiement");
               Date dater = rst.getDate("dater");
            rendezvous p = new rendezvous (idRdv, clientid, associeid, date,etat,Typepaiement,dater);
            rdvList.add(p);
            
            }   } catch (SQLException ex) {
            Logger.getLogger(servicesrendezvous.class.getName()).log(Level.SEVERE, null, ex);
        } 
     
     return rdvList;
    }
 
        
            
   
    
            
    
     public void Supprimerrendezvous(rendezvous r){  
       String req="DELETE FROM `rdv` WHERE `idRdv`="+ r.getIdRdv();
         try {
             ste = cnx.prepareStatement(req);
             ste.executeUpdate();
             System.out.println("rendez-vous bien supprimé");
             
             
             
         }catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
        
    } 
}
     
    

    public List<rendezvous> ListClasse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<rendezvous> afficherRdvs() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public void modifierrdv(rendezvous p) {

            
     String req=  "UPDATE rdv SET `idRdv`=?,`clientid`=?,`associeid`=?,`date`=?,`etat`=?,`Typepaiement`=?,`dater`=? WHERE `idRdv`=?";
          
        try {
            ste = cnx.prepareStatement(req);

            ste.setInt(1, p.getIdRdv());
            ste.setInt(2, p.getClientid());
            ste.setInt(3, p.getAssocieid());
            ste.setString(4, p.getDate());
            ste.setString(5, p.getEtat());
            ste.setString(6, p.getTypepaiement());
            ste.setInt(8, p.getIdRdv());
            ste.setDate(7, (Date) p.getDater());
            ste.executeUpdate();
            System.out.println("rdv has Updated !!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    
    }
  
    
}
