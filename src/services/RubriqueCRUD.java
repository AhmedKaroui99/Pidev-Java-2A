/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Rubrique;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyConnection;

/**
 *
 * @author Ahmed
 */
public class RubriqueCRUD {
    
   
     public void addrubrique(Rubrique r){
        try {
            String requete="INSERT INTO Rubrique (associeid,titre,descriptionbreve,descriptiondetaille) VALUES ( '"+r.getAssocieid()+"','"+r.getTitre()+"','"+r.getDescriptionbreve()+"','"+r.getDescriptiondetaille()+"')";
                 
            PreparedStatement pst =
                    new MyConnection().cn.prepareStatement(requete);
           
            pst.executeUpdate();
            System.out.println("Rubrique ajoutée!");
        } catch (SQLException ex) {
            Logger.getLogger(RubriqueCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
     
  public void Supprimer_Rubrique(int associeid){
    
                                
   try {
            String requete = "DELETE FROM `rubrique` WHERE associeid  ="+associeid;
               
            PreparedStatement pst = new MyConnection().cn.prepareStatement(requete);
           
            pst.executeUpdate();
            System.out.println("Rubrique supprimée!");
        } catch (SQLException ex) {
            Logger.getLogger(RubriqueCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
  
  public void modifierrubrique(Rubrique r){
        try {
     
                    
                    String requete="UPDATE `rubrique` SET "
                    + "`titre`=  "+r.getTitre()+" ,"
                    + "`descriptionbreve`='"+r.getDescriptionbreve()+"',"
                    + "`descriptiondetaille`= '"+r.getDescriptiondetaille()+"' WHERE associeid =  "+r.getAssocieid()+" ";
                    
                    
                 
            PreparedStatement pst =
                    new MyConnection().cn.prepareStatement(requete);
           
            pst.executeUpdate();
            System.out.println("Rubrique modifie!");
        } catch (SQLException ex) {
            Logger.getLogger(RubriqueCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
    
}
